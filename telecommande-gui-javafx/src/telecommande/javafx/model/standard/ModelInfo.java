package telecommande.javafx.model.standard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import telecommande.javafx.model.IModelInfo;


public class ModelInfo implements IModelInfo {
	
	
	// Données observables 
	
	private final StringProperty	titre = new SimpleStringProperty();
	private final StringProperty	message = new SimpleStringProperty();
	

	// Getters 
	
	@Override
	public StringProperty titreProperty() {
		return titre;
	}
	
	@Override
	public StringProperty messageProperty() {
		return message;
	}
	
	
	// Initialisaiton
	
//	public void init() throws Exception {
//	}
	
	
}
