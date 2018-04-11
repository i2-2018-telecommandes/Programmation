package telecommande.javafx.view.fournisseur;


import java.util.Collections;
import java.util.Comparator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import telecommande.commun.util.ExceptionValidation;
import telecommande.commun.util.Roles;
import telecommande.javafx.data.Marque;
import telecommande.javafx.data.Fournisseur;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.model.IModelFournisseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerFournisseurForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;
	@FXML
	private TextField			textFieldMail;
	
	@FXML
	private TextField			textFieldTelephone;
	

	
	// Autres champs
	
	private IManagerGui			    managerGui;
	private IModelFournisseur		modelFournisseur;
	private Fournisseur 				fournisseurVue;

	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelFournisseur(IModelFournisseur modelFournisseur) {
		this.modelFournisseur = modelFournisseur;
		fournisseurVue = modelFournisseur.getFournisseurVue();
	}


	// Initialisation du Controller
	
	public void init() {


		// Data binding
		textFieldId.textProperty().bind(new StringBindingId(fournisseurVue.idFournisseurProperty()));
        textFieldNom.textProperty().bindBidirectional(fournisseurVue.nomProperty());
        textFieldMail.textProperty().bindBidirectional(fournisseurVue.MailProperty());
        textFieldTelephone.textProperty().bindBidirectional(fournisseurVue.TelephoneProperty());
       

		// Data binding

	  			

        
    	
   
    	
		
		// Affichage
        
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.FournisseurListe );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelFournisseur.validerMiseAJour();
		managerGui.showView( EnumView.FournisseurListe );;
	}

    
    
}
	
	



