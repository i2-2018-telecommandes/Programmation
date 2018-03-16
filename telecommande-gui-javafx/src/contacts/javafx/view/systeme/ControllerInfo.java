package contacts.javafx.view.systeme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import telecommande.javafx.model.IModelInfo;


public class ControllerInfo {
	
	
	// Composants de la vue
	
	@FXML
	private Label		labelTitre;
	@FXML
	private Label		labelMessage;

	
	// Autres champs
	
	private IModelInfo	modelInfo;
	
	
	
	// Injecteurs
	
	public void setModelInfo(IModelInfo modelInfo) {
		this.modelInfo = modelInfo;
	}
	
	
	// Initialisation
	
	public void init() {
		
		// Data binding
		labelTitre.textProperty().bind( modelInfo.titreProperty() );
		labelMessage.textProperty().bind( modelInfo.messageProperty() );
		
	}
	

}
