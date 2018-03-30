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

}