package telecommande.commun.dto;

import java.util.Date;

public class DtoMouvementstock {

	private int idMouvementstock;

	private int Quantite;

	private String Libelle;

	private Date Date;

	private DtoModeleTelecommande ModeleTelecommande;

	public DtoMouvementstock() {

	}

	public DtoMouvementstock(int idmouvementstock, int quantite, String libelle, java.util.Date date,
			DtoModeleTelecommande ModeleTelecommande) {

		this.idMouvementstock = idmouvementstock;

		this.Quantite = quantite;

		this.Libelle = libelle;

		this.Date = date;

		this.ModeleTelecommande = ModeleTelecommande;
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

	public DtoModeleTelecommande getModeleTelecommande() {
		return ModeleTelecommande;
	}

	public void setModeleTelecommande(DtoModeleTelecommande ModeleTelecommande) {
		this.ModeleTelecommande = ModeleTelecommande;
	}

}
