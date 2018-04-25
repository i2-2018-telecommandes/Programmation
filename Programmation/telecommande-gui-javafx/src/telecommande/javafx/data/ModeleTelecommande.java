package telecommande.javafx.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModeleTelecommande {
	
	private final IntegerProperty	idTelecommande	 = new SimpleIntegerProperty();
	private final StringProperty	photo		 = new SimpleStringProperty();
	private final StringProperty	notice	= new SimpleStringProperty();
	private final StringProperty	nom		 = new SimpleStringProperty();
	private final ObjectProperty<Fournisseur>	Fournisseur	= new SimpleObjectProperty<>();
	private final IntegerProperty	qteStock	 = new SimpleIntegerProperty();
	private final IntegerProperty	qteSeuil	 = new SimpleIntegerProperty();
	private final IntegerProperty	prix	 = new SimpleIntegerProperty();
	private final IntegerProperty	idFournisseur	 = new SimpleIntegerProperty();
	
	
	public final IntegerProperty idTelecommandeProperty() {
		return this.idTelecommande;
		
		
	}
	
	
	public final int getIdTelecommande() {
		return this.idTelecommandeProperty().get();
	}
	
	public final void setIdTelecommande(final int idTelecommande) {
		this.idTelecommandeProperty().set(idTelecommande);
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
	
	public final StringProperty noticeProperty() {
		return this.notice;
	}
	
	public final String getnotice() {
		return this.noticeProperty().get();
	}
	
	public final void setnotice(final String notice) {
		this.noticeProperty().set(notice);
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
	
	
	
	
	public final IntegerProperty qteStockProperty() {
		return this.qteStock;
	}
	
	public final int getqteStock() {
		return this.qteStockProperty().get();
	}
	
	public final void setqteStock(final int qteStock) {
		this.qteStockProperty().set(qteStock);
	}
	
	public final IntegerProperty qteSeuilProperty() {
		return this.qteSeuil;
	}
	
	public final int getqteSeuil() {
		return this.qteSeuilProperty().get();
	}
	
	public final void setqteSeuil(final int qteSeuil) {
		this.qteSeuilProperty().set(qteSeuil);
	}

	
	public final IntegerProperty idFournisseurProperty() {
		return this.idFournisseur;
	}
	
	public final int getIdFournisseur() {
		return this.idFournisseurProperty().get();
	}
	
	public final void setIdFournisseur(final int idFournisseur) {
		this.idFournisseurProperty().set(idFournisseur);
	}
	
	
	public final IntegerProperty prixProperty() {
		return this.prix;
	}
	
	public final float getprix() {
		return this.prixProperty().get();
	}
	
	public final void setprix(final float prix) {
		this.prixProperty().set((int) prix);
	}

	public ModeleTelecommande() {
	}

	public ModeleTelecommande(int idTelecommande,String photo,String notice,String nom,int qteStock,int qteSeuil,float prix,int idFournisseur ) {
		
		setIdTelecommande(idTelecommande);
		setnotice(notice);
		setNom(nom);
		setPhoto(photo);
		setqteStock(qteStock);
		setqteSeuil(qteSeuil);
		setIdFournisseur(idFournisseur);
		setprix(prix);
		
	}

	public final ObjectProperty<Fournisseur> FournisseurProperty() {
		return this.Fournisseur;
	}
	

	public final Fournisseur getFournisseur() {
		return this.FournisseurProperty().get();
	}
	

	public final void setFournisseur(final Fournisseur Fournisseur) {
		this.FournisseurProperty().set(Fournisseur);
	}
	
	

}
