package telecommande.javafx.model.standard;

import static telecommande.javafx.model.EnumModeVue.CREER;
import static telecommande.javafx.model.EnumModeVue.MODIFIER;

import java.util.Comparator;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import telecommande.commun.dto.DtoFournisseur;
import telecommande.commun.service.IServiceFournisseur;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Fournisseur;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.EnumModeVue;
import telecommande.javafx.model.IModelFournisseur;

public class ModelFournisseur implements IModelFournisseur {

	// Données observables

	private final ObservableList<Fournisseur> fournisseurs = FXCollections
			.observableArrayList(c -> new Observable[] { c.nomProperty() });

	private final Fournisseur fournisseurVue = new Fournisseur();

	// Objet courant

	private Fournisseur fournisseurCourant;
	private EnumModeVue modeVue;

	// Autres champs
	private IMapper mapper;
	private IServiceFournisseur serviceFournisseur;

	// Getters

	@Override
	public ObservableList<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	@Override
	public Fournisseur getFournisseurVue() {
		return fournisseurVue;
	}

	// Injecteurs

	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}

	public void setServiceFournisseur(IServiceFournisseur serviceFournisseur) {
		this.serviceFournisseur = serviceFournisseur;
	}

	// Actualisations

	@Override
	public void actualiserListe() {

		// Prépare la récupération de l'objet courant
		int idCourant = 0;
		if (fournisseurCourant != null) {
			idCourant = fournisseurCourant.getIdFournisseur();
		}

		// Actualise la liste des fournisseurs
		fournisseurs.clear();
		for (DtoFournisseur dto : serviceFournisseur.listerTout()) {
			Fournisseur fournisseur = mapper.map(dto);
			fournisseurs.add(fournisseur);
			if (fournisseur.getIdFournisseur() == idCourant) {
				fournisseurCourant = fournisseur;
			}
		}
	}

	// Actions

	@Override
	public void preparerAjouter() {
		modeVue = CREER;
		mapper.update(new Fournisseur(fournisseurs.get(fournisseurs.size()-1).getIdFournisseur()+1,"","",""), fournisseurVue);
	}

	@Override
	public void preparerModifier(Fournisseur fournisseur) {
		modeVue = MODIFIER;
		fournisseurCourant = fournisseur;
		mapper.update(fournisseur, fournisseurVue);
	}

	@Override
	public void validerMiseAJour() throws ExceptionValidation {

		// Crée un objet contenant le données pour la mise à jour
		DtoFournisseur dto = mapper.map(fournisseurVue);

		// Effectue la mise à jour
		if (fournisseurVue.getNom().equals("")) {
			throw new ExceptionValidation("Le champ Nom ne doit pas être vide");
		} else {
			if (modeVue == CREER) {
				int id = serviceFournisseur.inserer(dto);
				fournisseurVue.setIdFournisseur(id);
				fournisseurCourant = mapper.update(fournisseurVue, new Fournisseur());
				fournisseurs.add(fournisseurCourant);
			}
			if (modeVue == MODIFIER) {
				serviceFournisseur.modifier(dto);
				mapper.update(fournisseurVue, fournisseurCourant);
			}

			// Trie la liste
			trierListe();
		}
	}

	@Override
	public void supprimer(Fournisseur fournisseur) throws ExceptionValidation {
		serviceFournisseur.supprimer(fournisseur.getIdFournisseur());
		fournisseurs.remove(fournisseur);
	}

	// Initialisaiton

	public void refresh() {
		actualiserListe();
	}

	// Méthodes auxiliaires

	private void trierListe() {
		FXCollections.sort(fournisseurs, (Comparator<Fournisseur>) (c1, c2) -> {
			return (c1.nomProperty().get().toUpperCase().compareTo(c2.nomProperty().get().toUpperCase()));
		});
	}

}
