<<<<<<< HEAD
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
=======
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
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
