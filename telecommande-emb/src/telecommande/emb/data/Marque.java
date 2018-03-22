package telecommande.emb.data;

public class Marque {

	
    private int			idMarque;
	
	private String		nom;
	
	
	
	// Constructeurs
	
	public 	Marque() {
	}

	public Marque(int id,String nom) {
		this.idMarque = id;
		
		this.nom=nom;
		
	}

	

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	// equals() et hashcode()

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idMarque;
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
			if (idMarque != other.getIdMarque())
				return false;
			return true;
		}
		
	}


