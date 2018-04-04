package telecommande.javafx.data;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Televiseur {

	private final IntegerProperty	idTeleviseur	 = new SimpleIntegerProperty();
	private final StringProperty	nom			 = new SimpleStringProperty();
	private final StringProperty	reference	= new SimpleStringProperty();
	private final ObjectProperty<Marque>	Marque	= new SimpleObjectProperty<>();
	private final IntegerProperty	idMarque	 = new SimpleIntegerProperty();
	public final IntegerProperty idTeleviseurProperty() {
		return this.idTeleviseur;
	}
	
	public final int getIdTeleviseur() {
		return this.idTeleviseurProperty().get();
	}
	
	public final void setIdTeleviseur(final int idTeleviseur) {
		this.idTeleviseurProperty().set(idTeleviseur);
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
	
	public final StringProperty referenceProperty() {
		return this.reference;
	}
	
	public final String getReference() {
		return this.referenceProperty().get();
	}
	
	public final void setReference(final String reference) {
		this.referenceProperty().set(reference);
	}
	
	public final IntegerProperty idMarqueProperty() {
		return this.idMarque;
	}
	
	public final int getIdMarque() {
		return this.idMarqueProperty().get();
	}
	
	public final void setIdMarque(final int idMarque) {
		this.idMarqueProperty().set(idMarque);
	}
	
	
	public Televiseur() {
	}

	public Televiseur( int idteleviseur,String nom,String reference,int idmarque) {
		setIdTeleviseur(idteleviseur);
		setNom(nom);
		setReference(reference);
		setIdMarque(idmarque);
		
	}

	public final ObjectProperty<Marque> MarqueProperty() {
		return this.Marque;
	}
	

	public final Marque getMarque() {
		return this.MarqueProperty().get();
	}
	

	public final void setMarque(final Marque Marque) {
		this.MarqueProperty().set(Marque);
   }


}

