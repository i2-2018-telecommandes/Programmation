package telecommande.dao.jdbc;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import telecommande.emb.dao.IDaoMouvementstock;
import telecommande.emb.dao.IDaoTelecommande;
import telecommande.emb.data.Mouvementstock;


public class DaoMouvementstock implements IDaoMouvementstock {

	// Champs

	private DataSource dataSource;
	private IDaoTelecommande daotelecommande;

	// Injecteurs

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setDaoTelecommande(IDaoTelecommande daotelecommande) {
		this.daotelecommande = daotelecommande;
	}

	// Actions
	@Override
	public void valider(Mouvementstock mouvementstock) {

	}

	@Override
	public void annuler(Mouvementstock mouvementstock) {

	}

	@Override
	public List<Mouvementstock> listerTout() {
		return null;

	}

	@Override
	public Mouvementstock retrouver(int idMouvementstock) {
		return null;
	}
}
