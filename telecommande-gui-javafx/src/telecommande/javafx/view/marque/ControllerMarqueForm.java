<<<<<<< HEAD
package telecommande.javafx.view.marque;

import java.util.Collections;
import java.util.Comparator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import telecommande.commun.util.ExceptionValidation;
import telecommande.commun.util.Roles;
import telecommande.javafx.data.Marque;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerMarqueForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;

	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelMarque		modelMarque;
	private Marque 				marqueVue;
	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelMarque(IModelMarque modelMarque) {
		this.modelMarque = modelMarque;
		marqueVue = modelMarque.getMarqueVue();
	}


	// Initialisation du Controller
	
	public void init() {

		// Data binding
		//textFieldId.textProperty().bind(new StringBindingId(marqueVue.idMarqueProperty()));
        textFieldNom.textProperty().bindBidirectional(marqueVue.nomProperty());
		
		// Configuration de l'objet ListView

		// Data binding

	  			

        
    	
   
    	
		
		// Affichage
        
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.MarqueListe2 );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelMarque.validerMiseAJour();
		managerGui.showView( EnumView.MarqueListe2 );;
	}

    
    
}
	
	



=======
package telecommande.javafx.view.marque;

import java.util.Collections;
import java.util.Comparator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import telecommande.commun.util.ExceptionValidation;
import telecommande.commun.util.Roles;
import telecommande.javafx.data.Marque;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerMarqueForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldNom;

	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelMarque		modelMarque;
	private Marque 				marqueVue;
	


	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelMarque(IModelMarque modelMarque) {
		this.modelMarque = modelMarque;
		marqueVue = modelMarque.getMarqueVue();
	}


	// Initialisation du Controller
	
	public void init() {

		// Data binding
		textFieldId.textProperty().bind(new StringBindingId(marqueVue.idMarqueProperty()));
        textFieldNom.textProperty().bindBidirectional(marqueVue.nomProperty());
		
		// Configuration de l'objet ListView

		// Data binding

	  			

        
    	
   
    	
		
		// Affichage
        
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.MarqueListe );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelMarque.validerMiseAJour();
		managerGui.showView( EnumView.MarqueListe );;
	}

    
    
}
	
	



>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
