package telecommande.emb.data;

public class Televiseur {

	private int			idTeleviseur;
	
	private String		nom;
	
	private String		reference;
	
	private int			idMarque;
	
	
	public 	Televiseur() {
	}

	public Televiseur(int idteleviseur,String nom,String reference,int idmarque) {
		this.idMarque = idmarque;
		
		this.nom=nom;
		
		this.reference=reference;
		
		this.idTeleviseur=idteleviseur;
		
	}
	
	

	public int getIdTeleviseur() {
		return idTeleviseur;
	}

	public void setIdTeleviseur(int idTeleviseur) {
		this.idTeleviseur = idTeleviseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}
	
	
	
}
