package telecommande.commun.dto;

public class DtoModeleTelecommande {


    private int			  idTelecommande;
	
	private String		  photo;
	
	private String		  notice;
	
	private String		  nom;
	
	private int			  qteStock;
	
	private int			  qteSeuil;
	
	private float		   prix;
	
	private DtoFournisseur fournisseur;
	

	public 	DtoModeleTelecommande() {
	}

	public DtoModeleTelecommande(int idTelecommande,String photo,String notice,String nom,int qteStock,int qteSeuil,float prix,DtoFournisseur fournisseur) {
		
		this.idTelecommande=idTelecommande;
		this.photo=photo;
		this.notice=notice;
		this.nom=nom;
		this.prix=prix;
		this.qteSeuil=qteSeuil;
		this.qteStock=qteStock;
		this.fournisseur=fournisseur;
	}
	

	public int getIdTelecommande() {
		return idTelecommande;
	}

	public void setIdTelecommande(int idTelecommande) {
		this.idTelecommande = idTelecommande;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public int getQteSeuil() {
		return qteSeuil;
	}

	public void setQteSeuil(int qteSeuil) {
		this.qteSeuil = qteSeuil;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public DtoFournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(DtoFournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
}
