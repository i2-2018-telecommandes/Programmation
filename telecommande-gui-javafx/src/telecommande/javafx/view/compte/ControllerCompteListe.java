package telecommande.javafx.view.compte;

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
import telecommande.javafx.data.Compte;
import telecommande.javafx.data.ModeleTelecommande;
import telecommande.javafx.data.Televiseur;
import telecommande.javafx.model.IModelCompte;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;


public class ControllerCompteListe  {
	
	
	// Composants de la vue
	@FXML
	private TableView<Compte> tableView ;
	@FXML
	private TableColumn<Compte,String> columnnom;
	@FXML
	private TableColumn<Compte,String> columnlogin;
	@FXML
	private TableColumn<Compte,String> columnmail;
	
	@FXML
	private ListView<Compte>	listView;
	
	@FXML
	private Button				buttonAjouter;
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;
	

	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelCompte		modelCompte;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelCompte(IModelCompte modelCompte) {
		this.modelCompte = modelCompte;
	}
	
	
	// Initialisation du Controller

	public void init() {
		
		// Configuration de l'objet ListView
		
tableView.setItems( modelCompte.getComptes() );
		
		columnnom.setCellValueFactory( cellData -> cellData.getValue().nomProperty());
		columnlogin.setCellValueFactory( cellData -> cellData.getValue().pseudoProperty());
		columnmail.setCellValueFactory( cellData -> cellData.getValue().emailProperty());
		// Affichage
		columnnom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		columnlogin.setCellValueFactory(cellData -> cellData.getValue().pseudoProperty());
		columnmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		
		

		// Comportement si modificaiton de la séleciton
		tableView.getSelectionModel().getSelectedItems().addListener( 
				(ListChangeListener<Compte>) (c) -> {
					 configurerBoutons();					
		});

		// Comportement si changement du contenu
		tableView.getItems().addListener( (ListChangeListener<Compte>) (c) -> {
			c.next();
			// Après insertion d'un élément, le sélectionne
			// Après suppression d'un élément, sélectionne le suivant
			if ( c.wasAdded() || c.wasRemoved() ) {
				tableView.getSelectionModel().clearSelection();
				tableView.getSelectionModel().select( c.getFrom());
				tableView.getFocusModel().focus(c.getFrom());
				tableView.scrollTo( c.getFrom());
				tableView.requestFocus();
			}
		});
	}

	
	// Actions

	@FXML
	private void doActualiser() {
		modelCompte.actualiserListe();
		listView.getSelectionModel().clearSelection();;
	}

	@FXML
	private void doAjouter() {
		modelCompte.preparerAjouter();
		managerGui.showView( EnumView.CompteForm2 );
	}

	@FXML
	private void doModifier() {
		modelCompte.preparerModifier( tableView.getSelectionModel().getSelectedItem() );
		managerGui.showView( EnumView.CompteForm2 );
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous la suppresion ?" );
		if ( reponse ) {
			modelCompte.supprimer( tableView.getSelectionModel().getSelectedItem() );
		}
	}
	
	
	// Gestion des évènements

	// Clic sur la liste
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				doModifier();
			}
		}
	}


	// Méthodes auxiliaires
	
	private void configurerBoutons() {
		int nbSelections = tableView.getSelectionModel().getSelectedItems().size();
		if ( nbSelections == 1 ) {
			buttonModifier.setDisable(false);
			buttonSupprimer.setDisable(false);
		} else {
			buttonModifier.setDisable(true);
			buttonSupprimer.setDisable(true);
		}
	}

}
