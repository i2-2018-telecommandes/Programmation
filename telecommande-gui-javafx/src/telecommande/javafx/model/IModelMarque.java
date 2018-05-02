<<<<<<< HEAD
package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Marque;


public interface IModelMarque {

	ObservableList<Marque> getMarques();

	Marque getMarqueVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Marque marque);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Marque marque) throws ExceptionValidation;

=======
package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Marque;


public interface IModelMarque {

	ObservableList<Marque> getMarques();

	Marque getMarqueVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Marque marque);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Marque marque) throws ExceptionValidation;

>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}