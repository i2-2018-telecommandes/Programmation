<<<<<<< HEAD
package telecommande.javafx.view.televiseur;


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
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.model.IModelTeleviseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerTeleviseurForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;
	@FXML
	private TextField			textFieldReference;
	@FXML
	private ComboBox<Marque>	comboMarque;

	
	// Autres champs
	
	private IManagerGui			    managerGui;
	private IModelTeleviseur		modelTeleviseur;
	private IModelMarque		    modelMarque;
	private Televiseur 				televiseurVue;
	
	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelTeleviseur(IModelTeleviseur modelTeleviseur) {
		this.modelTeleviseur = modelTeleviseur;
		televiseurVue = modelTeleviseur.getTeleviseurVue();
	}
   
	public void setModelMarque(IModelMarque modelMarque) {
		this.modelMarque = modelMarque;
	}
	// Initialisation du Controller
	
	public void init() {


		// Data binding
		//textFieldId.textProperty().bind(new StringBindingId(televiseurVue.idTeleviseurProperty()));
        textFieldNom.textProperty().bindBidirectional(televiseurVue.nomProperty());
        textFieldReference.textProperty().bindBidirectional(televiseurVue.referenceProperty());
        comboMarque.valueProperty().bindBidirectional( televiseurVue.MarqueProperty());
		comboMarque.setItems( modelMarque.getMarques() );
        
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
	
	



=======
package telecommande.javafx.view.televiseur;


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
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.model.IModelTeleviseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerTeleviseurForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;
	@FXML
	private TextField			textFieldReference;
	@FXML
	private ComboBox<Marque>			comboIdMarque;

	
	// Autres champs
	
	private IManagerGui			    managerGui;
	private IModelTeleviseur		modelTeleviseur;
	private IModelMarque		modelMarque;
	private Televiseur 				televiseurVue;
	String marqueVue;
	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelTeleviseur(IModelTeleviseur modelTeleviseur) {
		this.modelTeleviseur = modelTeleviseur;
		televiseurVue = modelTeleviseur.getTeleviseurVue();
	}


	// Initialisation du Controller
	
	public void init() {


		// Data binding
		textFieldId.textProperty().bind(new StringBindingId(televiseurVue.idTeleviseurProperty()));
        textFieldNom.textProperty().bindBidirectional(televiseurVue.nomProperty());
        textFieldReference.textProperty().bindBidirectional(televiseurVue.referenceProperty());
        comboIdMarque.valueProperty().unbindBidirectional( televiseurVue.MarqueProperty());
        //comboIdMarque.valueProperty().bind(new StringBindingId(televiseurVue.idMarqueProperty()) );
		comboIdMarque.setItems( modelMarque.getMarques() );
        //combodIdMarque.getSelectionModel().selectedItemProperty().(televiseurVue.idMarqueProperty());
        //combodIdMarque.selectionModelProperty<   (televiseurVue.nomProperty());
		// Configuration de l'objet ListView

		// Data binding

	  			

        
    	
   
    	
		
		// Affichage
        
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.TeleviseurListe );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelTeleviseur.validerMiseAJour();
		managerGui.showView( EnumView.TeleviseurListe );;
	}

    
    
}
	
	



>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
