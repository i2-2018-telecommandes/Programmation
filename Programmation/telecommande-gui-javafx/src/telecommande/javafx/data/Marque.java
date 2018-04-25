package telecommande.javafx.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Marque {

	
	private final IntegerProperty	idMarque	 = new SimpleIntegerProperty();
	private final StringProperty	nom			 = new SimpleStringProperty();
	
	
	public final IntegerProperty idMarqueProperty() {
		return this.idMarque;
	}
	
	public final int getIdMarque() {
		return this.idMarqueProperty().get();
	}
	
	public final void setIdMarque(final int idMarque) {
		this.idMarqueProperty().set(idMarque);
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
	
	
	// Constructeurs
	
		public Marque() {
		}

		public Marque( int id,String nom) {
			setIdMarque(id);
			setNom(nom);
			
		}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom.get();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMarque == null) ? 0 : idMarque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marque other = (Marque) obj;
		if (idMarque == null) {
			if (other.idMarque != null)
				return false;
		} else if (!idMarque.equals(other.idMarque))
			return false;
		return true;
	}
}
