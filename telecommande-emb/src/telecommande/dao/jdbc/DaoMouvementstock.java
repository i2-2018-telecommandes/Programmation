package telecommande.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.sql.DataSource;

import telecommande.dao.jdbc.util.UtilJdbc;
import telecommande.emb.dao.IDaoModeleTelecommande;
import telecommande.emb.dao.IDaoMouvementstock;
import telecommande.emb.data.Mouvementstock;

public class DaoMouvementstock implements IDaoMouvementstock {

	// Champs

	private DataSource dataSource;
	private IDaoModeleTelecommande daoModeleTelecommande;

	// Injecteurs

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setDaoModeleTelecommande(IDaoModeleTelecommande daoModeleTelecommande) {
		this.daoModeleTelecommande = daoModeleTelecommande;
	}

	@Override
	public int inserer(Mouvementstock mouvementstock) {
		Connection cn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		String sql, sql2;

		try {
			cn = dataSource.getConnection();

			// Insère le mouvement
			sql2 = "UPDATE ModeleTelecommande set QteStock = QteStock + ? where idTelecommande = ?";
			sql = "INSERT INTO MouvementStock (qte,libelle,date,idTelecommande)  VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt2 = cn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			stmt2.setInt(1, mouvementstock.getQuantite());
			stmt2.setInt(2, mouvementstock.getIdMouvementstock());
			stmt.setInt(1, mouvementstock.getQuantite());
			stmt.setString(2, mouvementstock.getLibelle());
			stmt.setDate(3, (Date) mouvementstock.getDate());
			stmt.setInt(4, mouvementstock.getModeleTelecommande().getIdTelecommande());

			stmt.executeUpdate();
			stmt2.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			mouvementstock.setIdMouvementstock(rs.getInt(1));

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}

		// Retourne l'identifiant
		return mouvementstock.getIdMouvementstock();
	}

	@Override
	public Mouvementstock retrouver(int idMouvementstock) {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM MouvementStock WHERE idMouvement = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idMouvementstock);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return construireMouvement(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	@Override
	public boolean verifierUniciteNom(String libelle, int idMouvement) {
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) AS nbMouvemets" + " FROM Mouvement WHERE libelle=? AND idMouvement <> ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, libelle);
			stmt.setInt(2, idMouvement);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getInt("nbMouvements") == 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	@Override
	public List<Mouvementstock> listerTout() {
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM MouvementStock ORDER BY libelle";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();

			List<Mouvementstock> mouvements = new ArrayList<>();
			while (rs.next()) {
				mouvements.add(construireMouvement(rs));
			}
			return mouvements;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	private Mouvementstock construireMouvement(ResultSet rs) throws SQLException {
		Mouvementstock mouvement = new Mouvementstock();
		mouvement.setIdMouvementstock(rs.getInt("idMouvement"));
		mouvement.setQuantite(rs.getInt("qte"));
		mouvement.setLibelle(rs.getString("libelle"));
		mouvement.setDate(rs.getDate("date"));
		mouvement.setModeleTelecommande(daoModeleTelecommande.retrouver(rs.getInt("idTelecommande")));
		return mouvement;
	}

}
