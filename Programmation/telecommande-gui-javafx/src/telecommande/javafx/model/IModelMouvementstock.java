package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Mouvementstock;



public interface IModelMouvementstock {
	
	ObservableList<Mouvementstock> getMouvementstock();
	
	Mouvementstock getMouvementstockVue();
	
	void validerMiseAJour() throws ExceptionValidation;

}
