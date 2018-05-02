<<<<<<< HEAD
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

=======
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

>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}