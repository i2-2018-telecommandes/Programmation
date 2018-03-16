package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Compte;


public interface IModelCompte {

	ObservableList<Compte> getComptes();

	Compte getCompteVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(Compte compte);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(Compte compte) throws ExceptionValidation;

}