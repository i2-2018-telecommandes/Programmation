package telecommande.javafx.view.compte;

import java.util.Collections;
import java.util.Comparator;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import telecommande.commun.util.ExceptionValidation;
import telecommande.commun.util.Roles;
import telecommande.javafx.data.Compte;
import telecommande.javafx.model.IModelCompte;
import telecommande.javafx.view.EnumView;
import telecommande.javafx.view.IManagerGui;
import telecommande.javafx.view.util.StringBindingId;


public class ControllerCompteForm {

	
	// Composants de la vue
	
	@FXML
	private TextField			textFieldId;
	@FXML
	private TextField			textFieldPseudo;
	@FXML
	private TextField			textFieldNom;
	@FXML
	private TextField			textFieldPrenom;
	@FXML
	private TextField			textFieldMotDePasse;
	@FXML
	private TextField			textFieldEmail;
	@FXML
	private ListView<ItemRole>	listViewRoles;

	
	// Autres champs
	
	private IManagerGui			managerGui;
	private IModelCompte		modelCompte;
	private Compte 				compteVue;
	
	private final ObservableList<ItemRole> itemRoles = FXCollections.observableArrayList();

	
	// Injecteurs

	public void setManagerGui(IManagerGui managerGui) {
		this.managerGui = managerGui;
	}
	
	public void setModelCompte(IModelCompte modelCompte) {
		this.modelCompte = modelCompte;
		compteVue = modelCompte.getCompteVue();
	}


	// Initialisation du Controller
	
	public void init() {

		// Data binding
		//textFieldId.textProperty().bind(new StringBindingId(compteVue.idProperty()));
		textFieldPseudo.textProperty().bindBidirectional( compteVue.pseudoProperty() );
		textFieldMotDePasse.textProperty().bindBidirectional( compteVue.motDePasseProperty() );
		textFieldEmail.textProperty().bindBidirectional( compteVue.emailProperty() );
        textFieldNom.textProperty().bindBidirectional(compteVue.nomProperty());
        textFieldPrenom.textProperty().bindBidirectional(compteVue.prenomProperty());
		
		// Configuration de l'objet ListView

		// Data binding

		itemRoles.clear();
    	for ( String role : Roles.getRoles()  ) {
    		itemRoleAjouter( role, false);
    	}
		actualiserListeItemRoles();    			

        listViewRoles.setItems( itemRoles );
    	
    	// De compteVue vers la liste
    	compteVue.getRoles().addListener(
        	(ListChangeListener<String>)	c -> {
    			c.next();
				for ( String role : c.getAddedSubList() ) {
					itemRoleChoisir(role, true );
				}
				for ( String role : c.getRemoved() ) {
					itemRoleChoisir(role, false );
				}
        });
    	
		
		// Affichage
        listViewRoles.setCellFactory( CheckBoxListCell.forListView(
        		(ItemRole item) -> item.choisiProperty()
   		) );
        
	}
	
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.CompteListe2 );;
	}
	
	@FXML
	private void doValider() throws ExceptionValidation  {
		modelCompte.validerMiseAJour();
		managerGui.showView( EnumView.CompteListe2 );;
	}

    
    
    // Méthodes auxiliaires
    
    private void actualiserListeItemRoles() {
    	Collections.sort( itemRoles,
    			(Comparator<ItemRole>) (i1, i2) -> {
    				return i1.getRole().toUpperCase().compareTo( i2.getRole().toUpperCase() );
    	} );
		for( ItemRole item : itemRoles ) {
			item.setChoisi( compteVue.isInRole( item.getRole() ) );
		}
    }
	
    
    
    private ItemRole itemRoleRetrouver( String role ) {
    	if ( role != null ) {
    		for ( ItemRole item : itemRoles ) {
    			if ( item.getRole().equals( role ) ) {
    				return item;
    			}
    		}
    	}
		return null;
    }

    
    private void itemRoleAjouter( String role, boolean choisi ) {
		ItemRole item = itemRoleRetrouver(role);
		if ( item == null ) {
			itemRoles.add( new ItemRole(role, choisi) );
		}
    }
    
    private void itemRoleChoisir( String role, boolean choisi ) {
		ItemRole item = itemRoleRetrouver(role);
		if ( item != null ) {
			item.setChoisi(choisi);;
		}
    }
	
	
	// Classe auxiliaire

	private class ItemRole {

		// Champs
		
		private final String			role;
		private final BooleanProperty	choisi;
		

		// Constructeurs

		public ItemRole( String role, boolean present ) {
			this.role = role;
			this.choisi = new SimpleBooleanProperty( present );
        	// Binding de l'item vers compteVue 
    		choisi.addListener(
    			(ChangeListener<Boolean> ) ( obs, oldValue, newValue ) -> {
    				if ( newValue ) {
    					if( ! compteVue.getRoles().contains( role) ) {
        					compteVue.getRoles().add( role );
    					}
    				} else {
       					compteVue.getRoles().remove( role );
    				}
        		});
		}

		
		// Getters & Setters

		public String getRole() {
			return role;
		}
		
		public void setChoisi( boolean choisi ) {
			choisiProperty().set(choisi);
		}
		
		public BooleanProperty choisiProperty() {
			return choisi;
		}
		
		@Override
		public String toString() {
			return Roles.getLibellé( role );
		}
		
	}
}
