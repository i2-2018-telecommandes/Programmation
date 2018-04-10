package telecommande.javafx.view.fournisseur;

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
import telecommande.javafx.data.Fournisseur;
import telecommande.javafx.model.IModelFournisseur;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;

public class ControllerFournisseurListe {







	
	
	// Composants de la vue

	@FXML
	private TableView<Fournisseur> tableView ;
	@FXML
	private TableColumn<Fournisseur,String> columnnom ;
	@FXML
	private TableColumn<Fournisseur,String> columnmail ;
	@FXML
	private TableColumn<Fournisseur,String> columntelephone ;
	
	@FXML
	private ListView<Fournisseur> listViewReference ;
	
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;
	@FXML
	private Button				buttonMemos;
	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelFournisseur		modelFournisseur;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelFournisseur(IModelFournisseur modelFournisseur) {
		this.modelFournisseur = modelFournisseur;
	}
	
	
	// Initialisation du Controller

	public void init() {
		
		// Configuration de l'objet ListView
		
		// Data binding
		tableView.setItems( modelFournisseur.getFournisseurs() );
		
		columnnom.setCellValueFactory( cellData -> cellData.getValue().nomProperty());
		columnmail.setCellValueFactory( cellData -> cellData.getValue().MailProperty());
		columntelephone.setCellValueFactory( cellData -> cellData.getValue().TelephoneProperty());
		
		
		// Affichage
		columnnom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		columnmail.setCellValueFactory(cellData -> cellData.getValue().MailProperty());
		columntelephone.setCellValueFactory(cellData -> cellData.getValue().TelephoneProperty());
		
		/*columnnom.setCellFactory( (list) -> {
		    return new ListCell<Fournisseur,String>() {
		        @Override
		        protected void updateItem(Fournisseur item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null) {
		                setText(null);
		            } else {
		                setText(item.nomProperty().get() );
		            }
		        }
		    };
		});		

		columnreference.setCellFactory( (list) -> {
		    return new ListCell<Fournisseur,	String>() {
		        @Override
		        protected void updateItem(Fournisseur item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null) {
		                setText(null);
		            } else {
		                setText(item.referenceProperty().get() );
		            }
		        }
		    };
		});	*/
		// Comportement si modificaiton de la séleciton
		tableView.getSelectionModel().getSelectedItems().addListener( 
				(ListChangeListener<Fournisseur>) (c) -> {
					 configurerBoutons();					
		});

		// Comportement si changement du contenu
		tableView.getItems().addListener( (ListChangeListener<Fournisseur>) (c) -> {
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
		modelFournisseur.actualiserListe();
		tableView.getSelectionModel().clearSelection();;
	}

	@FXML
	private void doAjouter() {
		modelFournisseur.preparerAjouter();
		managerGui.showView( EnumView.FournisseurForm2 );
	}

	@FXML
	private void doModifier() {
		modelFournisseur.preparerModifier( tableView.getSelectionModel().getSelectedItem() );
		managerGui.showView( EnumView.FournisseurForm2 );
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous la suppresion ?" );
		if ( reponse ) {
			modelFournisseur.supprimer( tableView.getSelectionModel().getSelectedItem() );
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
