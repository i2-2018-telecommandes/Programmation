package telecommande.commun.dto;

public class DtoFournisseur {


	private int			idFournisseur;
	
	private String		nom;
	
	private String		mail;
	
	private String	   telephone;

	public 	DtoFournisseur() {
	}

  public DtoFournisseur(int idfournisseur,String nom,String mail,String telephone) {
		
		this.idFournisseur = idfournisseur;
		
		this.nom=nom;
		
		this.mail=mail;
		
		this.telephone=telephone;
		
	}

	
	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}
