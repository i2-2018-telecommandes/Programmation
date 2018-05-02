<<<<<<< HEAD
package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Televiseur;


public interface IModelTeleviseur {

	ObservableList<Televiseur> getTeleviseurs();

	Televiseur getTeleviseurVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Televiseur televiseur);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Televiseur televiseur) throws ExceptionValidation;

=======
package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Televiseur;


public interface IModelTeleviseur {

	ObservableList<Televiseur> getTeleviseurs();

	Televiseur getTeleviseurVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Televiseur televiseur);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Televiseur televiseur) throws ExceptionValidation;

>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}