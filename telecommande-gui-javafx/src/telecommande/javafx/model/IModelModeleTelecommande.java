package telecommande.javafx.model;

import javafx.collections.ObservableList;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.ModeleTelecommande;


public interface IModelModeleTelecommande {

	ObservableList<ModeleTelecommande> getModeleTelecommandes();

	ModeleTelecommande getModeleTelecommandeVue();
	
	void actualiserListe();

	void preparerAjouter();

	void preparerModifier(ModeleTelecommande modeleTecommande);

	void validerMiseAJour() throws ExceptionValidation;

	void supprimer(ModeleTelecommande modeleTecommande) throws ExceptionValidation;

}