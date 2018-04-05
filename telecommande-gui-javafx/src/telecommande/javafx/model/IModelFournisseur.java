package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Fournisseur;


public interface IModelFournisseur {

	ObservableList<Fournisseur> getFournisseurs();

	Fournisseur getFournisseurVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Fournisseur fournisseur);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Fournisseur fournisseur) throws ExceptionValidation;

}