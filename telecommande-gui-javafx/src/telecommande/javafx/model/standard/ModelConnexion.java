package telecommande.javafx.model.standard;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import telecommande.commun.dto.DtoCompte;
import telecommande.commun.service.IServiceConnexion;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Compte;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.IModelConnexion;


public class ModelConnexion implements IModelConnexion {
	
	// Logger
	private static final Logger logger = Logger.getLogger( ModelConnexion.class.getName() );
	
	
	// Données observables 
	
	// Vue connexion
	private final Compte		compteVue = new Compte();

	// Compte connecté
	private final ObjectProperty<Compte>	compteConnecté = new SimpleObjectProperty<>();

	
	// Autres champs
	private IMapper				mapper;
	private IServiceConnexion	serviceConnexion;
	

	// Getters 
	
	@Override
	public Compte getCompteVue() {
		return compteVue;
	}
	
	@Override
	public ObjectProperty<Compte> compteConnecteProperty() {
		return compteConnecté;
	}
	
	@Override
	public Compte getCompteConnecte() {
		return compteConnecté.get();
	}
	
	
	// Injecteurs
	
	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}

	public void setServiceConnexion(IServiceConnexion serviceConnexion) {
		this.serviceConnexion = serviceConnexion;

		compteVue.pseudoProperty().set( "" );
		compteVue.motDePasseProperty().set( "" );
	}
	
	
	// Actions


	@Override
	public void ouvrirSessionUtilisateur() throws ExceptionValidation {

		DtoCompte dto = serviceConnexion.sessionUtilisateurOuvrir(
				compteVue.pseudoProperty().get(), compteVue.motDePasseProperty().get() );
		
		// Message de log
		String logMessage;
		if( dto == null ) {
			logMessage = "Pseudo ou mot de passe invalide : " + compteVue.pseudoProperty().get() + " / " + compteVue.motDePasseProperty().get();
		} else {
			logMessage = "\n    Utilisateur connecté : " + dto.getId() +  " " + dto.getPseudo();
			logMessage += "\n    Roles :";
			for( String role : dto.getRoles() ) {
				logMessage += " " + role;
			}
		}
		logger.log( Level.CONFIG, logMessage );
		
		if( dto == null ) {
			throw new ExceptionValidation( "Pseudo ou mot de passe invalide." );
		} else {
			 Platform.runLater( () -> compteConnecté.set( mapper.map( dto ) ) );
		}
	}
	

	@Override
	public void fermerSessionUtilisateur() {
		serviceConnexion.sessionUtilisateurFermer();
		compteConnecté.set( null );
	}

}
