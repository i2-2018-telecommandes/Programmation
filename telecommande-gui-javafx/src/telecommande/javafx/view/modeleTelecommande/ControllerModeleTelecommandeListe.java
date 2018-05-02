package telecommande.javafx.view.modeleTelecommande;

import  telecommande.javafx.view.util.EditingCell;
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
import telecommande.javafx.data.ModeleTelecommande;
import telecommande.javafx.model.IModelModeleTelecommande;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;

public class ControllerModeleTelecommandeListe {







	
	
	// Composants de la vue

	@FXML
	private TableView<ModeleTelecommande> tableView ;
	@FXML
	private TableColumn<ModeleTelecommande,String> columnfournisseur ;
	@FXML
	private TableColumn<ModeleTelecommande,String> columntele ;
	@FXML
	private TableColumn<ModeleTelecommande,String> columnseuil; ;
	@FXML
	private TableColumn<ModeleTelecommande,String> columnstock ;

	
	@FXML
	private ListView<ModeleTelecommande> listViewReference ;
	
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;
	@FXML
	private Button				buttonMemos;
	
	// Autres champs
	
	private IManagerGui			            managerGui;
	private IModelModeleTelecommande		modelModeleTelecommande;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelModeleTelecommande(IModelModeleTelecommande modelModeleTelecommande) {
		this.modelModeleTelecommande = modelModeleTelecommande;
	}
	
	
	// Initialisation du Controller

	public void init() {
		
		// Configuration de l'objet ListView
		
		// Data binding
		tableView.setItems( modelModeleTelecommande.getModeleTelecommandes() );
		
		columnfournisseur.setCellValueFactory( cellData -> cellData.getValue().nomProperty());
		columntele.setCellValueFactory( cellData -> cellData.getValue().referenceProperty());
		columnseuil.setCellValueFactory( cellData -> cellData.getValue().referenceProperty());
		columnstock.setCellValueFactory( cellData -> cellData.getValue().referenceProperty());
		
		// Affichage
		columnfournisseur.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		columntele.setCellValueFactory(cellData -> cellData.getValue().referenceProperty());
		columnseuil.setCellValueFactory(cellData -> cellData.getValue().referenceProperty());
		columnstock.setCellValueFactory(cellData -> cellData.getValue().referenceProperty());

		// Comportement si modificaiton de la séleciton
		tableView.getSelectionModel().getSelectedItems().addListener( 
				(ListChangeListener<ModeleTelecommande>) (c) -> {
					 configurerBoutons();					
		});

		// Comportement si changement du contenu
		tableView.getItems().addListener( (ListChangeListener<ModeleTelecommande>) (c) -> {
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
		modelModeleTelecommande.actualiserListe();
		tableView.getSelectionModel().clearSelection();;
	}

	@FXML
	private void doAjouter() {
		modelModeleTelecommande.preparerAjouter();
		managerGui.showView( EnumView.ModeleTelecommandeForm );
	}

	@FXML
	private void doModifier() {
		modelModeleTelecommande.preparerModifier( tableView.getSelectionModel().getSelectedItem() );
		managerGui.showView( EnumView.ModeleTelecommandeForm );
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous la suppresion ?" );
		if ( reponse ) {
			modelModeleTelecommande.supprimer( tableView.getSelectionModel().getSelectedItem() );
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
