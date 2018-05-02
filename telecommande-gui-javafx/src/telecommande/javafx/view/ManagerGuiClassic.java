<<<<<<< HEAD
package telecommande.javafx.view;

import telecommande.javafx.model.IContextModel;

public class ManagerGuiClassic extends ManagerGuiAbstract {

	
	// Champs
	
	private final IContextModel		contextModel;


	// Constructeur
	
	public ManagerGuiClassic(IContextModel contextModel) {
		this.contextModel = contextModel;
	}


	// Actions
	
	@Override
	protected <T> T getModelFromContext(Class<T> type) {
		return contextModel.getModel(type);
	}
	
	
=======
package telecommande.javafx.view;

import telecommande.javafx.model.IContextModel;

public class ManagerGuiClassic extends ManagerGuiAbstract {

	
	// Champs
	
	private final IContextModel		contextModel;


	// Constructeur
	
	public ManagerGuiClassic(IContextModel contextModel) {
		this.contextModel = contextModel;
	}


	// Actions
	
	@Override
	protected <T> T getModelFromContext(Class<T> type) {
		return contextModel.getModel(type);
	}
	
	
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}