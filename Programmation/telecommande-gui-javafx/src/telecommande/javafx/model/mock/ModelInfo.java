package telecommande.javafx.model.mock;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import telecommande.javafx.model.IModelInfo;


public class ModelInfo implements IModelInfo {
	
	
	// Données observables 
	
	private final StringProperty	propTitre = new SimpleStringProperty();
	private final StringProperty	propMessage = new SimpleStringProperty();
	

	// Getters
	
	@Override
	public StringProperty titreProperty() {
		return propTitre;
	}
	
	@Override
	public StringProperty messageProperty() {
		return propMessage;
	}
}
