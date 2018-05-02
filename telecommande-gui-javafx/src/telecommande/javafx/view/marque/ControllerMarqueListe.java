<<<<<<< HEAD
package telecommande.javafx.view.marque;

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
import telecommande.javafx.data.Marque;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;

public class ControllerMarqueListe {

	
	// Composants de la vue

	@FXML
	private ListView<Marque> listView ;
	
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;
	@FXML
	private Button				buttonMemos;
	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelMarque		modelMarque;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelMarque(IModelMarque modelMarque) {
		this.modelMarque = modelMarque;
	}
	
	
	// Initialisation du Controller

	public void init() {
		
		// Configuration de l'objet ListView
		
		// Data binding
		listView.setItems( modelMarque.getMarques() );
		

		// Affichage
		listView.setCellFactory( (list) -> {
		    return new ListCell<Marque>() {
		        @Override
		        protected void updateItem(Marque item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null) {
		                setText(null);
		            } else {
		                setText(item.nomProperty().get() );
		            }
		        }
		    };
		});		

		// Comportement si modificaiton de la séleciton
		listView.getSelectionModel().getSelectedItems().addListener( 
				(ListChangeListener<Marque>) (c) -> {
					 configurerBoutons();					
		});

		// Comportement si changement du contenu
		listView.getItems().addListener( (ListChangeListener<Marque>) (c) -> {
			c.next();
			// Après insertion d'un élément, le sélectionne
			// Après suppression d'un élément, sélectionne le suivant
			if ( c.wasAdded() || c.wasRemoved() ) {
				listView.getSelectionModel().clearSelection();
				listView.getSelectionModel().select( c.getFrom());
				listView.getFocusModel().focus(c.getFrom());
				listView.scrollTo( c.getFrom());
				listView.requestFocus();
			}
		});
	}

	
	// Actions

	@FXML
	private void doActualiser() {
		modelMarque.actualiserListe();
		listView.getSelectionModel().clearSelection();;
	}

	@FXML
	private void doAjouter() {
		modelMarque.preparerAjouter();
		managerGui.showView( EnumView.MarqueForm2 );
	}

	@FXML
	private void doModifier() {
		modelMarque.preparerModifier( listView.getSelectionModel().getSelectedItem() );
		managerGui.showView( EnumView.MarqueForm2 );
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous la suppresion ?" );
		if ( reponse ) {
			modelMarque.supprimer( listView.getSelectionModel().getSelectedItem() );
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
		int nbSelections = listView.getSelectionModel().getSelectedItems().size();
		if ( nbSelections == 1 ) {
			buttonModifier.setDisable(false);
			buttonSupprimer.setDisable(false);
		} else {
			buttonModifier.setDisable(true);
			buttonSupprimer.setDisable(true);
		}
	}

}
=======
package telecommande.javafx.view.marque;

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
import telecommande.javafx.data.Marque;
import telecommande.javafx.model.IModelMarque;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;

public class ControllerMarqueListe {







	
	
	// Composants de la vue

	@FXML
	private ListView<Marque> listView ;
	private TableColumn< Marque,String> columnnom;
	
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;
	@FXML
	private Button				buttonMemos;
	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelMarque		modelMarque;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelMarque(IModelMarque modelMarque) {
		this.modelMarque = modelMarque;
	}
	
	
	// Initialisation du Controller

	public void init() {
		
		// Configuration de l'objet ListView
		
		// Data binding
		listView.setItems( modelMarque.getMarques() );
		

		// Affichage
		listView.setCellFactory( (list) -> {
		    return new ListCell<Marque>() {
		        @Override
		        protected void updateItem(Marque item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null) {
		                setText(null);
		            } else {
		                setText(item.nomProperty().get() );
		            }
		        }
		    };
		});		

		// Comportement si modificaiton de la séleciton
		listView.getSelectionModel().getSelectedItems().addListener( 
				(ListChangeListener<Marque>) (c) -> {
					 configurerBoutons();					
		});

		// Comportement si changement du contenu
		listView.getItems().addListener( (ListChangeListener<Marque>) (c) -> {
			c.next();
			// Après insertion d'un élément, le sélectionne
			// Après suppression d'un élément, sélectionne le suivant
			if ( c.wasAdded() || c.wasRemoved() ) {
				listView.getSelectionModel().clearSelection();
				listView.getSelectionModel().select( c.getFrom());
				listView.getFocusModel().focus(c.getFrom());
				listView.scrollTo( c.getFrom());
				listView.requestFocus();
			}
		});
	}

	
	// Actions

	@FXML
	private void doActualiser() {
		modelMarque.actualiserListe();
		listView.getSelectionModel().clearSelection();;
	}

	@FXML
	private void doAjouter() {
		modelMarque.preparerAjouter();
		managerGui.showView( EnumView.MarqueForm );
	}

	@FXML
	private void doModifier() {
		modelMarque.preparerModifier( listView.getSelectionModel().getSelectedItem() );
		managerGui.showView( EnumView.MarqueForm );
	}

	@FXML
	private void doSupprimer() throws ExceptionValidation {
		boolean reponse = managerGui.demanderConfirmation( "Confirmez-vous la suppresion ?" );
		if ( reponse ) {
			modelMarque.supprimer( listView.getSelectionModel().getSelectedItem() );
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
		int nbSelections = listView.getSelectionModel().getSelectedItems().size();
		if ( nbSelections == 1 ) {
			buttonModifier.setDisable(false);
			buttonSupprimer.setDisable(false);
		} else {
			buttonModifier.setDisable(true);
			buttonSupprimer.setDisable(true);
		}
	}

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
