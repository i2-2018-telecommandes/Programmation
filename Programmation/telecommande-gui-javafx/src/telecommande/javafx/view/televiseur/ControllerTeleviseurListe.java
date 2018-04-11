package telecommande.javafx.view.televiseur;

import telecommande.javafx.view.util.EditingCell;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import telecommande.commun.util.ExceptionValidation;
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.model.IModelTeleviseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;

public class ControllerTeleviseurListe {

	// Composants de la vue

	@FXML
	private TableView<Televiseur> tableView;
	@FXML
	private TableColumn<Televiseur, String> columnnom;
	@FXML
	private TableColumn<Televiseur, String> columnreference;

	@FXML
	private ListView<Televiseur> listViewReference;

	@FXML
	private Button buttonModifier;
	@FXML
	private Button buttonSupprimer;
	@FXML
	private Button buttonMemos;

	// Autres champs

	private IManagerGui managerGui;
	private IModelTeleviseur modelTeleviseur;

	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}

	public void setModelTeleviseur(IModelTeleviseur modelTeleviseur) {
		this.modelTeleviseur = modelTeleviseur;
	}

	// Initialisation du Controller

	public void init() {

		// Configuration de l'objet ListView

		// Data binding
		tableView.setItems(modelTeleviseur.getTeleviseurs());

		columnnom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		columnreference.setCellValueFactory(cellData -> cellData.getValue().referenceProperty());

		// Affichage
		columnnom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		columnreference.setCellValueFactory(cellData -> cellData.getValue().referenceProperty());

		/*
		 * columnnom.setCellFactory( (list) -> { return new
		 * ListCell<Televiseur,String>() {
		 * 
		 * @Override protected void updateItem(Televiseur item, boolean empty) {
		 * super.updateItem(item, empty); if (item == null) { setText(null); } else {
		 * setText(item.nomProperty().get() ); } } }; });
		 * 
		 * columnreference.setCellFactory( (list) -> { return new ListCell<Televiseur,
		 * String>() {
		 * 
		 * @Override protected void updateItem(Televiseur item, boolean empty) {
		 * super.updateItem(item, empty); if (item == null) { setText(null); } else {
		 * setText(item.referenceProperty().get() ); } } }; });
		 */
		// Comportement si modificaiton de la séleciton
		tableView.getSelectionModel().getSelectedItems().addListener((ListChangeListener<Televiseur>) (c) -> {
			configurerBoutons();
		});

		// Comportement si changement du contenu
		tableView.getItems().addListener((ListChangeListener<Televiseur>) (c) -> {
			c.next();
			// Après insertion d'un élément, le sélectionne
			// Après suppression d'un élément, sélectionne le suivant
			if (c.wasAdded() || c.wasRemoved()) {
				tableView.getSelectionModel().clearSelection();
				tableView.getSelectionModel().select(c.getFrom());
				tableView.getFocusModel().focus(c.getFrom());
				tableView.scrollTo(c.getFrom());
				tableView.requestFocus();
			}
		});
	}

	// Actions

	@FXML
	private void doActualiser() {
		modelTeleviseur.actualiserListe();
		tableView.getSelectionModel().clearSelection();
		;
	}

	@FXML
	private void doAjouter() {
		modelTeleviseur.preparerAjouter();
		managerGui.showView(EnumView.TeleviseurForm);
	}

	@FXML
	private void doModifier() {
		modelTeleviseur.preparerModifier(tableView.getSelectionModel().getSelectedItem());
		managerGui.showView(EnumView.TeleviseurForm);
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation("Confirmez-vous la suppresion ?");
		if (reponse) {
			modelTeleviseur.supprimer(tableView.getSelectionModel().getSelectedItem());
		}
	}

	// Gestion des évènements

	// Clic sur la liste
	@FXML
	private void gererClicSurListe(MouseEvent event) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				doModifier();
			}
		}
	}

	// Méthodes auxiliaires

	private void configurerBoutons() {
		int nbSelections = tableView.getSelectionModel().getSelectedItems().size();
		if (nbSelections == 1) {
			buttonModifier.setDisable(false);
			buttonSupprimer.setDisable(false);
		} else {
			buttonModifier.setDisable(true);
			buttonSupprimer.setDisable(true);
		}
	}

}
