package telecommande.javafx.data;

import java.text.SimpleDateFormat;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.DateStringConverter;

public class Mouvementstock {
 private final IntegerProperty idMouvementstock = new SimpleIntegerProperty();
 private final IntegerProperty qte = new SimpleIntegerProperty();
 private final StringProperty Libelle = new SimpleStringProperty();
 private final SimpleDateFormat date = new SimpleDateFormat();
 private final ObjectProperty<ModeleTelecommande> modeletelecommande = new SimpleObjectProperty<>();
 
 public Mouvementstock(int idMouvementstock, int qte, SimpleDateFormat date, ModeleTelecommande modele) {
	setIdMouvementstock(idMouvementstock);
	setQte(qte);
	date= this.date;
	setModeletelecommande(modele);
}
 
public final IntegerProperty idMouvementstockProperty() {
	return this.idMouvementstock;
}

public final int getIdMouvementstock() {
	return this.idMouvementstockProperty().get();
}

public final void setIdMouvementstock(final int idMouvementstock) {
	this.idMouvementstockProperty().set(idMouvementstock);
}

public final IntegerProperty qteProperty() {
	return this.qte;
}

public final int getQte() {
	return this.qteProperty().get();
}

public final void setQte(final int qte) {
	this.qteProperty().set(qte);
}

public final StringProperty LibelleProperty() {
	return this.Libelle;
}

public final String getLibelle() {
	return this.LibelleProperty().get();
}

public final void setLibelle(final String Libelle) {
	this.LibelleProperty().set(Libelle);
}

public final ObjectProperty<ModeleTelecommande> modeletelecommandeProperty() {
	return this.modeletelecommande;
}

public final ModeleTelecommande getModeletelecommande() {
	return this.modeletelecommandeProperty().get();
}

public final void setModeletelecommande(final ModeleTelecommande modeletelecommande) {
	this.modeletelecommandeProperty().set(modeletelecommande);
}

 
 
}
