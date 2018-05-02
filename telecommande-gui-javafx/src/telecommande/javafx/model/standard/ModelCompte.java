package telecommande.javafx.model.standard;

import static telecommande.javafx.model.EnumModeVue.CREER;
import static telecommande.javafx.model.EnumModeVue.MODIFIER;

import java.util.Comparator;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import telecommande.commun.dto.DtoCompte;
import telecommande.commun.service.IServiceCompte;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Compte;
import telecommande.javafx.data.mapper.IMapper;
import telecommande.javafx.model.EnumModeVue;
import telecommande.javafx.model.IModelCompte;

public class ModelCompte implements IModelCompte {

	// Données observables

	private final ObservableList<Compte> comptes = FXCollections
			.observableArrayList(c -> new Observable[] { c.pseudoProperty() });

	private final Compte compteVue = new Compte();

	// Objet courant

	private Compte compteCourant;
	private EnumModeVue modeVue;

	// Autres champs
	private IMapper mapper;
	private IServiceCompte serviceCompte;

	// Getters

	@Override
	public ObservableList<Compte> getComptes() {
		return comptes;
	}

	@Override
	public Compte getCompteVue() {
		return compteVue;
	}

	// Injecteurs

	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}

	public void setServiceCompte(IServiceCompte serviceCompte) {
		this.serviceCompte = serviceCompte;
	}

	// Actualisations

	@Override
	public void actualiserListe() {

		// Prépare la récupération de l'objet courant
		int idCourant = 0;
		if (compteCourant != null) {
			idCourant = compteCourant.getId();
		}

		// Actualise la liste des comptes
		comptes.clear();
		for (DtoCompte dto : serviceCompte.listerTout()) {
			Compte compte = mapper.map(dto);
			comptes.add(compte);
			if (compte.getId() == idCourant) {
				compteCourant = compte;
			}
		}
	}

	// Actions

	@Override
	public void preparerAjouter() {
		modeVue = CREER;
		mapper.update(new Compte(comptes.get(comptes.size() - 1).getId() + 1, "", "", "", "", ""), compteVue);
	}

	@Override
	public void preparerModifier(Compte compte) {
		modeVue = MODIFIER;
		compteCourant = compte;
		mapper.update(compte, compteVue);
	}

	@Override
	public void validerMiseAJour() throws ExceptionValidation {

		// Crée un objet contenant le données pour la mise à jour
		DtoCompte dto = mapper.map(compteVue);

		// Effectue la mise à jour
		if (compteVue.getNom().equals("")) {
			throw new ExceptionValidation("Le champ Nom ne doit pas être vide");
		} else if (compteVue.getEmail().equals("")) {
			throw new ExceptionValidation("Le champ Mail ne doit pas être vide");
		} else if (compteVue.getMotDePasse().equals("")) {
			throw new ExceptionValidation("Le champ Mot de passe ne doit pas être vide");
		} else if (compteVue.getPrenom().equals("")) {
			throw new ExceptionValidation("Le champ Prenom ne doit pas être vide");
		} else if (compteVue.getPseudo().equals("")) {
			throw new ExceptionValidation("Le champ Pseudo ne doit pas être vide");
		} else if (compteVue.getRoles().isEmpty()) {
			throw new ExceptionValidation("Choisir le rôle ");
		} else {
			if (modeVue == CREER) {
				int id = serviceCompte.inserer(dto);
				compteVue.setId(id);
				compteCourant = mapper.update(compteVue, new Compte());
				comptes.add(compteCourant);
			}
			if (modeVue == MODIFIER) {
				serviceCompte.modifier(dto);
				mapper.update(compteVue, compteCourant);
			}

			// Trie la liste
			trierListe();
		}
	}

	@Override
	public void supprimer(Compte compte) throws ExceptionValidation {
		serviceCompte.supprimer(compte.getId());
		comptes.remove(compte);
	}

	// Initialisaiton

	public void refresh() {
		actualiserListe();
	}

	// Méthodes auxiliaires

	private void trierListe() {
		FXCollections.sort(comptes, (Comparator<Compte>) (c1, c2) -> {
			return (c1.pseudoProperty().get().toUpperCase().compareTo(c2.pseudoProperty().get().toUpperCase()));
		});
	}

}
