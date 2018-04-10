package telecommande.emb.data;

import java.util.Date;


public class Mouvementstock {

private int			idMouvementstock;
	
    private int			Quantite;
    
	private String		Libelle;
	
	private Date        Date;
	
	private Telecommande		Telecommande;

	public Mouvementstock() {

	}

	public Mouvementstock(int idMouvementstock, int quantite, String libelle, java.util.Date date,
			Telecommande telecommande) {
		
		
		this.idMouvementstock = idMouvementstock;
		
		this.Quantite = quantite;
		
		this.Libelle = libelle;
		
		this.Date = date;
		
		this.Telecommande = telecommande;
	}

	public int getIdMouvementstock() {
		return idMouvementstock;
	}

	public void setIdMouvementstock(int idMouvementstock) {
		this.idMouvementstock = idMouvementstock;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Telecommande getTelecommande() {
		return Telecommande;
	}

	public void setTelecommande(Telecommande telecommande) {
		Telecommande = telecommande;
	}

	
}
