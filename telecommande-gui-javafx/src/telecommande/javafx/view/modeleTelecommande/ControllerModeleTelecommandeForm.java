package telecommande.javafx.view.modeleTelecommande;


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
import telecommande.javafx.data.Fournisseur;
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.model.IModelFournisseur;
import telecommande.javafx.model.IModelTeleviseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerModeleTelecommandeForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;
	@FXML
	private TextField			textQteseuil;
	@FXML
	private TextField			textQte;
	@FXML
	private TextField			textFieldPrix;
	@FXML
	private TextField			textFieldNotice;
	@FXML
	private ComboBox<Fournisseur>			comboFournisseur;

	
	// Autres champs
	
	private IManagerGui			    managerGui;
	private IModelTeleviseur		modelTeleviseur;
	private IModelFournisseur		    modelFournisseur;
	private Televiseur 				televiseurVue;
	
	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelTeleviseur(IModelTeleviseur modelTeleviseur) {
		this.modelTeleviseur = modelTeleviseur;
		televiseurVue = modelTeleviseur.getTeleviseurVue();
	}
   
	public void setModelFournisseur(IModelFournisseur modelFournisseur) {
		this.modelFournisseur = modelFournisseur;
	}
	// Initialisation du Controller
	
	public void init() {


		// Data binding
		//textFieldId.textProperty().bind(new StringBindingId(televiseurVue.idTeleviseurProperty()));
        textFieldNom.textProperty().bindBidirectional(televiseurVue.nomProperty());
        textFieldPrix.textProperty().bindBidirectional(televiseurVue.referenceProperty());
		comboFournisseur.setItems( modelFournisseur.getFournisseurs() );
      
        
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.TeleviseurListe2 );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelTeleviseur.validerMiseAJour();
		managerGui.showView( EnumView.TeleviseurListe2 );;
	}

    
    
}
	
	



