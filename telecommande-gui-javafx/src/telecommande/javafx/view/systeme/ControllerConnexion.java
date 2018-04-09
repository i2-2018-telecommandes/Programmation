package telecommande.javafx.view.systeme;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import telecommande.commun.service.IServiceCompte;
import telecommande.javafx.data.Compte;
import telecommande.javafx.data.Fournisseur;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.IModelConnexion;
import telecommande.javafx.model.IModelInfo;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;


public class ControllerConnexion {
	


	// Composants de la vue
	
	@FXML
	private TextField		fieldPseudo;
	@FXML
	private PasswordField	fieldMotDePasse;

	
	// Autres champs
	
	private IManagerGui		managerGui;
	private IModelConnexion	modelConnexion;
	private IModelInfo		modelInfo;
	
	

	
	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelConnexion(IModelConnexion modelConnexion) {
		this.modelConnexion = modelConnexion;
	}
	
	public void setModelInfo(IModelInfo modelInfo) {
		this.modelInfo = modelInfo;
	}
	

	// Initialisation du Controller
	
	public void init() {
		
		// Data binding
		Compte compteVue = modelConnexion.getCompteVue();
		fieldPseudo.textProperty().bindBidirectional( compteVue.pseudoProperty() );
		fieldMotDePasse.textProperty().bindBidirectional( compteVue.motDePasseProperty() );
	}
	

	// Actions
	
	@FXML
	public void doConnexion()  {
		managerGui.execTask( () -> {
			modelConnexion.ouvrirSessionUtilisateur();
			String nom=modelConnexion.getCompteVue().getPseudo();
			 Platform.runLater( () -> {
         			modelInfo.titreProperty().set( "Bienvenue "+nom);
        			modelInfo.messageProperty().set( "Connexion réussie" );
        			managerGui.showView(EnumView.Info);
             }) ;
		} );
	}
	

}
