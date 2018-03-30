package telecommande.commun.dto;

public class DtoTeleviseur {


	private int			idTeleviseur;
	
	private String		nom;
	
	private String		reference;
	
	private int			idMarque;
	
	
	public 	DtoTeleviseur() {
	}

	public DtoTeleviseur(int idteleviseur,String nom,String reference,int idmarque) {
		this.idTeleviseur = idteleviseur;
		
		this.nom=nom;
		
		this.reference=reference;
		
		this.idMarque=idmarque;
		
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
		return idTeleviseur;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}
}
