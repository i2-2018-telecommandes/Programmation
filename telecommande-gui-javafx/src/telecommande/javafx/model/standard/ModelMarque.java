package telecommande.javafx.model.standard;


import static telecommande.javafx.model.EnumModeVue.CREER;
import static telecommande.javafx.model.EnumModeVue.MODIFIER;

import java.util.Comparator;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import telecommande.commun.dto.DtoMarque;
import telecommande.commun.service.IServiceMarque;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Marque;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.EnumModeVue;
import telecommande.javafx.model.IModelMarque;


public class ModelMarque implements IModelMarque {
	
	
	// Données observables 
	
	private final ObservableList<Marque> marques = FXCollections.observableArrayList( 
			c ->  new Observable[] { c.nomProperty()  } 
		);
	
	private final Marque	marqueVue = new Marque();
	
	
	// Objet courant

	private Marque			marqueCourant;
    private EnumModeVue		modeVue;
	
	
	// Autres champs
	private IMapper			mapper;
	private IServiceMarque	serviceMarque;
	
	
	// Getters
	
	@Override
	public ObservableList<Marque> getMarques() {
		return marques;
	}

	@Override
	public Marque getMarqueVue() {
		return marqueVue;
	}
	
	
	// Injecteurs
	
	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}
	
	public void setServiceMarque(IServiceMarque serviceMarque) {
		this.serviceMarque = serviceMarque;
	}
	
	
	// Actualisations
	
	@Override
	public void actualiserListe() {
		
		// Prépare la récupération de l'objet courant
		int idCourant = 0;
		if( marqueCourant != null ) {
			idCourant = marqueCourant.getIdMarque();
		}
		
		// Actualise la liste des marques
		marques.clear();
		for( DtoMarque dto : serviceMarque.listerTout() ) {
			Marque marque = mapper.map( dto );
			marques.add( marque );
			if( marque.getIdMarque() == idCourant ) {
				marqueCourant = marque;
			}
		}
 	}
	
	
	// Actions
	
	@Override
	public void preparerAjouter() {
        modeVue = CREER;
		mapper.update( new Marque(), marqueVue );		
	}
	
	@Override
	public void preparerModifier( Marque marque ) {
        modeVue = MODIFIER;
		marqueCourant = marque;
		mapper.update( marque, marqueVue );	
	}
	
	
	@Override
	public void validerMiseAJour() throws ExceptionValidation  {

		// Crée un objet contenant le données pour la mise à jour
		DtoMarque dto = mapper.map( marqueVue );
		
		// Effectue la mise à jour
        if ( modeVue == CREER ) {
			int id = serviceMarque.inserer(dto);
			marqueVue.setIdMarque(id);
            marqueCourant = mapper.update(marqueVue, new Marque());
			marques.add( marqueCourant );
		}
        if ( modeVue == MODIFIER ) {
			serviceMarque.modifier(dto);
			mapper.update( marqueVue, marqueCourant );		
		}

        // Trie la liste
        trierListe();
	}
	
	
	@Override
	public void supprimer( Marque marque ) throws ExceptionValidation  {
		serviceMarque.supprimer( marque.getIdMarque() );
		marques.remove( marque );
	}
	
	
	// Initialisaiton
	
	public void refresh() {
		actualiserListe();
	}
    
    
    // Méthodes auxiliaires
    
    private void trierListe() {
		FXCollections.sort( marques,
            (Comparator<Marque>) ( c1, c2) -> {
                return ( c1.nomProperty().get().toUpperCase().compareTo(c2.nomProperty().get().toUpperCase()));
		});
    }

}
