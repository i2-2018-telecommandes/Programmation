package telecommande.javafx.view.systeme;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import telecommande.commun.util.Roles;
import telecommande.javafx.model.IModelConnexion;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;


public class ControllerPrincipal  {
 	

	// Composants de la vue
	
	@FXML
	private MenuItem	menuItemSeDeconnecter;
	@FXML
	private Menu 		menuDonnees;
	@FXML
	private MenuItem	menuItemComptes;
	@FXML
	private Menu        menuVente;
	@FXML
	private Menu        menuStock;
	@FXML
	private MenuItem	menuItemMarque;
	@FXML
	private MenuItem	menuItemTeleviseur;
	@FXML
	private MenuItem	menuItemFournisseur;
	
	// Autres champs
	
	private IManagerGui		managerGui;
	private IModelConnexion	modelConnexion;

	
	// Injecteurs
	
	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelConnexion(IModelConnexion modelConnexion) {
		this.modelConnexion = modelConnexion;
	}
	
	
	// Initialisation du Controller
	
	public void init() {
		
		// Le changement du compte connecté modifie automatiquement le menu
		modelConnexion.compteConnecteProperty().addListener(
				( ov, oldValue, newValue) -> {
					configurerMenu();
				}
			); 

		// Adapte le menu
		configurerMenu();
	}
	

	// Actions
	
	@FXML
	public void doSeDeconnecter() {
		modelConnexion.fermerSessionUtilisateur();
		managerGui.reinit();
		setManagerGui(managerGui);
		managerGui.showView( EnumView.Connexion );
	}
	
	@FXML
	public void doQuitter() {
		managerGui.close();
	}
	
	@FXML
	public void doAfficherListeComptes() {
		managerGui.showView( EnumView.CompteListe );;
	}
	@FXML
	public void doAfficherListeMarque() {
		managerGui.showView( EnumView.MarqueListe );;
	}
	@FXML
	public void doAfficherListeTeleviseur() {
		managerGui.showView( EnumView.TeleviseurListe );;
	}
	@FXML
	public void doAfficherListeFournisseur() {
		managerGui.showView( EnumView.FournisseurListe );;
	}
	// Méthodes auxiliaires
	
	private void configurerMenu() {

		menuItemSeDeconnecter.setDisable(true);
		
		menuDonnees.setVisible(false);
		menuItemComptes.setVisible(false);
		menuVente.setVisible(false);
		menuStock.setVisible(false);
		
		if( modelConnexion.getCompteConnecte() != null ) {
			menuItemSeDeconnecter.setDisable(false);
			if( modelConnexion.getCompteConnecte().isInRole( Roles.STOCK) ) {
				//menuDonnees.setVisible(true);
				menuStock.setVisible(true);
				menuItemMarque.setVisible(true);
				menuItemTeleviseur.setVisible(true);
			}
			if( modelConnexion.getCompteConnecte().isInRole( Roles.VENTE) ) {
				//menuDonnees.setVisible(true);
				menuVente.setVisible(true);
			}
			if( modelConnexion.getCompteConnecte().isInRole( Roles.DONNEES ) ) {
				menuDonnees.setVisible(true);
				menuItemComptes.setVisible(true);
			}
		}
	}

}
