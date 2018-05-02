package telecommande.javafx.data;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fournisseur {

	private final IntegerProperty	idFournisseur = new SimpleIntegerProperty();
	private final StringProperty	nom			  = new SimpleStringProperty();
	private final StringProperty	Mail	      = new SimpleStringProperty();
	private final StringProperty	Telephone	  = new SimpleStringProperty();
	
	public Fournisseur() {
	}

	public Fournisseur( int id,String nom,String mail,String Telephone) {
		setIdFournisseur(id);
		setNom(nom);
		setMail(mail);
		setTelephone(Telephone);		
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
	
	public final StringProperty nomProperty() {
		return this.nom;
	}
	
	public final String getNom() {
		return this.nomProperty().get();
	}
	
	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	
	public final StringProperty MailProperty() {
		return this.Mail;
	}
	
	public final String getMail() {
		return this.MailProperty().get();
	}
	
	public final void setMail(final String Mail) {
		this.MailProperty().set(Mail);
	}
	
	public final StringProperty TelephoneProperty() {
		return this.Telephone;
	}
	
	public final String getTelephone() {
		return this.TelephoneProperty().get();
	}
	
	public final void setTelephone(final String Telephone) {
		this.TelephoneProperty().set(Telephone);
	}
	
	
	
}
