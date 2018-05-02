package telecommande.javafx.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ModeleTelecommande {

	
	private final IntegerProperty	            idTelecommande	 = new SimpleIntegerProperty();
	private final StringProperty	            photo			 = new SimpleStringProperty();
	private final StringProperty	            notice			 = new SimpleStringProperty();
	private final StringProperty	            nom			     = new SimpleStringProperty();
	private final IntegerProperty	            qteStock	     = new SimpleIntegerProperty();
	private final IntegerProperty	            qteSeuil	     = new SimpleIntegerProperty();
	private final IntegerProperty	            prix	         = new SimpleIntegerProperty();
	private final StringProperty	            reference	     = new SimpleStringProperty();
	private final ObjectProperty<Fournisseur>	fournisseur	     = new SimpleObjectProperty<>();
	
	public ModeleTelecommande() {
	}

	public ModeleTelecommande( int idtelecommande,String nom,String photo,String notice,int qteSeuil,int qteStock,Fournisseur fournisseur) {
		setIdTelecommande(idtelecommande);
		setPhoto(photo);
		setNotice(notice);
		setNom(nom);
		setQteSeuil(qteSeuil);
		setQteStock(qteStock);
		setFournisseur(fournisseur);
		
	}
	
	public final IntegerProperty idTelecommandeProperty() {
		return this.idTelecommande;
	}
	
	public final int getIdTelecommande() {
		return this.idTelecommandeProperty().get();
	}
	
	public final void setIdTelecommande(final int idTelecommande) {
		this.idTelecommandeProperty().set(idTelecommande);
	}
	
	public final StringProperty photoProperty() {
		return this.photo;
	}
	
	public final String getPhoto() {
		return this.photoProperty().get();
	}
	
	public final void setPhoto(final String photo) {
		this.photoProperty().set(photo);
	}
	
	public final StringProperty noticeProperty() {
		return this.notice;
	}
	
	public final String getNotice() {
		return this.noticeProperty().get();
	}
	
	public final void setNotice(final String notice) {
		this.noticeProperty().set(notice);
	}
	
	public final StringProperty nomProperty() {
		return this.nom;
	}
	
	public final String getNom() {
		return this.nomProperty().get();
	}
	
	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	
	public final IntegerProperty qteStockProperty() {
		return this.qteStock;
	}
	
	public final int getQteStock() {
		return this.qteStockProperty().get();
	}
	
	public final void setQteStock(final int qteStock) {
		this.qteStockProperty().set(qteStock);
	}
	
	public final IntegerProperty qteSeuilProperty() {
		return this.qteSeuil;
	}
	
	public final int getQteSeuil() {
		return this.qteSeuilProperty().get();
	}
	
	public final void setQteSeuil(final int qteSeuil) {
		this.qteSeuilProperty().set(qteSeuil);
	}
	
	public final IntegerProperty prixProperty() {
		return this.prix;
	}
	
	public final int getPrix() {
		return this.prixProperty().get();
	}
	
	public final void setPrix(final int prix) {
		this.prixProperty().set(prix);
	}
	
	public final StringProperty referenceProperty() {
		return this.reference;
	}
	
	public final String getReference() {
		return this.referenceProperty().get();
	}
	
	public final void setReference(final String reference) {
		this.referenceProperty().set(reference);
	}
	
	public final ObjectProperty<Fournisseur> fournisseurProperty() {
		return this.fournisseur;
	}
	
	public final Fournisseur getFournisseur() {
		return this.fournisseurProperty().get();
	}
	
	public final void setFournisseur(final Fournisseur fournisseur) {
		this.fournisseurProperty().set(fournisseur);
	}
	
	
}
	
