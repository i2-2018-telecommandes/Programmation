package telecommande.commun.dto;

import java.util.Date;

public class DtoMouvementstock {

	private int idMouvementstock;

	private int Quantite;

	private String Libelle;

	private Date Date;

	private DtoTelecommande Telecommande;

	public DtoMouvementstock() {

	}

	public DtoMouvementstock(int idmouvementstock, int quantite, String libelle, java.util.Date date,
			DtoTelecommande telecommande) {

		this.idMouvementstock = idmouvementstock;
		
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

	public DtoTelecommande getTelecommande() {
		return Telecommande;
	}

	public void setTelecommande(DtoTelecommande telecommande) {
		Telecommande = telecommande;
	}

}
