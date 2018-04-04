package telecommande.emb.data;

public class Televiseur {

	private int			idTeleviseur;
	
	private String		nom;
	
	private String		reference;
	
	private Marque		marque;
	
	
	public 	Televiseur() {
	}

	public Televiseur(int idteleviseur,String nom,String reference,Marque marque) {
		this.marque = marque;
		
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

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
}
