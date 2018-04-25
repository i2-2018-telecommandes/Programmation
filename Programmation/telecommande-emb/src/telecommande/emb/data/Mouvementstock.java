package telecommande.emb.data;

import java.util.Date;


public class Mouvementstock {

private int			idMouvementstock;
	
    private int			Quantite;
    
	private String		Libelle;
	
	private Date        Date;
	
	private ModeleTelecommande		ModeleTelecommande;

	public Mouvementstock() {

	}

	public Mouvementstock(int idMouvementstock, int quantite, String libelle, java.util.Date date,
			ModeleTelecommande ModeleTelecommande) {
		
		
		this.idMouvementstock = idMouvementstock;
		
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

	public ModeleTelecommande getModeleTelecommande() {
		return ModeleTelecommande;
	}

	public void setModeleTelecommande(ModeleTelecommande modeleTelecommande) {
		ModeleTelecommande = modeleTelecommande;
	}

	
}
