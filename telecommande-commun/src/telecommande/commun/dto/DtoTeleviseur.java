<<<<<<< HEAD
package telecommande.commun.dto;

public class DtoTeleviseur {


	private int			idTeleviseur;
	
	private String		nom;
	
	private String		reference;
	
	private DtoMarque	marque;
	
	
	public 	DtoTeleviseur() {
	}

	public DtoTeleviseur(int idteleviseur,String nom,String reference,DtoMarque marque) {
		this.idTeleviseur = idteleviseur;
		
		this.nom=nom;
		
		this.reference=reference;
		
		this.marque=marque;
		
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

	public DtoMarque getMarque() {
		return marque;
	}

	public void setMarque(DtoMarque marque) {
		this.marque = marque;
	}
}
=======
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
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
