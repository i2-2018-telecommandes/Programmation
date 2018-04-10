package telecommande.javafx.data;

import java.util.Date;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mouvementstock {
	private final IntegerProperty idMouvementstock = new SimpleIntegerProperty();
	private final IntegerProperty Quantite = new SimpleIntegerProperty();
	private final StringProperty Libelle = new SimpleStringProperty();
	private final ObjectProperty<LocalDate> Date = new SimpleObjectProperty<>();
	private final ObjectProperty<Telecommande> telecommande = new SimpleObjectProperty<>();
	private final IntegerProperty idTelecommande = new SimpleIntegerProperty();

	public final IntegerProperty idMouvementstockProperty() {
		return this.idMouvementstock;
	}

	public final int getIdMouvementstock() {
		return this.idMouvementstockProperty().get();
	}

	public final void setIdMouvementstock(final int idMouvementstock) {
		this.idMouvementstockProperty().set(idMouvementstock);
	}

	public final IntegerProperty QuantiteProperty() {
		return this.Quantite;
	}

	public final int getQuantite() {
		return this.QuantiteProperty().get();
	}

	public final void setQuantite(final int Quantite) {
		this.QuantiteProperty().set(Quantite);
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

	public final ObjectProperty<LocalDate> DateProperty() {
		return this.Date;
	}

	public final LocalDate getDate() {
		return this.DateProperty().get();
	}

	public final void setDate(final LocalDate Date) {
		this.DateProperty().set(Date);
	}

	public final ObjectProperty<Telecommande> telecommandeProperty() {
		return this.telecommande;
	}

	public final Telecommande getTelecommande() {
		return this.telecommandeProperty().get();
	}

	public final void setTelecommande(final Telecommande telecommande) {
		this.telecommandeProperty().set(telecommande);
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

	public Mouvementstock() {

	}

	public Mouvementstock(int idmouvementstock, int quantite, String libelle, LocalDate date,
			Telecommande telecommande) {
		setIdMouvementstock(idmouvementstock);
		setQuantite(quantite);
		setLibelle(libelle);
		setDate(date);
		setTelecommande(telecommande);

	}

}
