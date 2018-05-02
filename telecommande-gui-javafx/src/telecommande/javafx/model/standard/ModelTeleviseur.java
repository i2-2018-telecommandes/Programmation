package telecommande.javafx.model.standard;


import static telecommande.javafx.model.EnumModeVue.CREER;
import static telecommande.javafx.model.EnumModeVue.MODIFIER;

import java.util.Comparator;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import telecommande.commun.dto.DtoMarque;
import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.service.IServiceMarque;
import telecommande.commun.service.IServiceTeleviseur;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Marque;
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.EnumModeVue;
import telecommande.javafx.model.IModelTeleviseur;


public class ModelTeleviseur implements IModelTeleviseur {
	
	
	// Données observables 
	
	private final ObservableList<Televiseur> televiseurs = FXCollections.observableArrayList( 
			c ->  new Observable[] { c.nomProperty()  } 
		);
	
	private final ObservableList<Marque> marques = FXCollections.observableArrayList( 
			c ->  new Observable[] { c.nomProperty()  } 
		);
	private final Televiseur televiseurVue = new Televiseur();
	private final Marque	marqueVue = new Marque();
	
	// Objet courant

	private Televiseur		televiseurCourant;
    private EnumModeVue		modeVue;
	
	
	// Autres champs
	private IMapper			    mapper;
	private IServiceTeleviseur	serviceTeleviseur;
	private IServiceMarque	    serviceMarque;
	
	
	// Getters
	
	@Override
	public ObservableList<Televiseur> getTeleviseurs() {
		return televiseurs;
	}

	@Override
	public Televiseur getTeleviseurVue() {
		return televiseurVue;
	}
	
	
	// Injecteurs
	
	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}
	
	public void setServiceTeleviseur(IServiceTeleviseur serviceTeleviseur) {
		this.serviceTeleviseur = serviceTeleviseur;
	}
	
	
	// Actualisations
	
	@Override
	public void actualiserListe() {
		
		// Prépare la récupération de l'objet courant
		int idCourant = 0;
		if( televiseurCourant != null ) {
			idCourant = televiseurCourant.getIdTeleviseur();
		}
		
		// Actualise la liste des televiseurs
		televiseurs.clear();
		for( DtoTeleviseur dto : serviceTeleviseur.listerTout() ) {
			Televiseur televiseur = mapper.map( dto );
			televiseurs.add( televiseur );
			if( televiseur.getIdTeleviseur() == idCourant ) {
				televiseurCourant = televiseur;
			}
		}
		
		
 	}
	
	
	// Actions
	
	@Override
	public void preparerAjouter() {
        modeVue = CREER;
		mapper.update( new Televiseur(), televiseurVue );		
	}
	
	@Override
	public void preparerModifier( Televiseur televiseur ) {
        modeVue = MODIFIER;
		televiseurCourant = televiseur;
		mapper.update( televiseur, televiseurVue );	
	}
	
	
	@Override
	public void validerMiseAJour() throws ExceptionValidation  {

		// Crée un objet contenant le données pour la mise à jour
		DtoTeleviseur dto = mapper.map( televiseurVue );
		
		// Effectue la mise à jour
        if ( modeVue == CREER ) {
			int id = serviceTeleviseur.inserer(dto);
			televiseurVue.setIdTeleviseur(id);
            televiseurCourant = mapper.update(televiseurVue, new Televiseur());
			televiseurs.add( televiseurCourant );
		}
        if ( modeVue == MODIFIER ) {
			serviceTeleviseur.modifier(dto);
			mapper.update( televiseurVue, televiseurCourant );		
		}

        // Trie la liste
        trierListe();
	}
	
	
	@Override
	public void supprimer( Televiseur televiseur ) throws ExceptionValidation  {
		serviceTeleviseur.supprimer( televiseur.getIdTeleviseur() );
		televiseurs.remove( televiseur );
	}
	
	
	// Initialisaiton
	
	public void refresh() {
		actualiserListe();
	}
    
    
    // Méthodes auxiliaires
    
    private void trierListe() {
		FXCollections.sort( televiseurs,
            (Comparator<Televiseur>) ( c1, c2) -> {
                return ( c1.nomProperty().get().toUpperCase().compareTo(c2.nomProperty().get().toUpperCase()));
		});
    }

}
