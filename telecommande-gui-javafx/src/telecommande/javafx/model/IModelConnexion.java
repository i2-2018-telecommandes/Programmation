package telecommande.javafx.model;

import javafx.beans.property.ObjectProperty;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Compte;


public interface IModelConnexion {

	Compte getCompteVue();

	ObjectProperty<Compte> compteConnecteProperty();

	Compte getCompteConnecte();

	void ouvrirSessionUtilisateur() throws ExceptionValidation;

	void fermerSessionUtilisateur();

}