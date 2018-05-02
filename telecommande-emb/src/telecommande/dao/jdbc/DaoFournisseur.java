package telecommande.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import telecommande.dao.jdbc.util.UtilJdbc;
import telecommande.emb.dao.IDaoFournisseur;
import telecommande.emb.data.Fournisseur;


public class DaoFournisseur implements IDaoFournisseur {

	
	// Champs

	private DataSource		dataSource;
	

	
	// Injecteurs
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	// Actions
	
	@Override
	public int inserer(Fournisseur fournisseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le fournisseur
			sql = "INSERT INTO Fournisseur (nom,email,telephone)  VALUES (?,?,?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
			stmt.setString(	1, fournisseur.getNom() );
			stmt.setString(	2, fournisseur.getMail() );
			stmt.setString(	3, fournisseur.getTelephone() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			fournisseur.setIdFournisseur( rs.getInt(1) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	
		
		// Retourne l'identifiant
		return fournisseur.getIdFournisseur();
	}

	
	@Override
	public void modifier(Fournisseur fournisseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le fournisseur
			sql = "UPDATE fournisseur SET nom = ?,email= ?,telephone= ?  WHERE IdFournisseur =  ?";
			stmt = cn.prepareStatement( sql );
			
			stmt.setString(1, fournisseur.getNom() );
			stmt.setString(2, fournisseur.getMail() );
			stmt.setString(3, fournisseur.getTelephone() );
			stmt.setInt   (4, fournisseur.getIdFournisseur());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		
	}

	
	@Override
	public void supprimer(int idFournisseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le fournisseur
			sql = "DELETE FROM Fournisseur WHERE Idfournisseur = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idFournisseur );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	@Override
	public Fournisseur retrouver(int idFournisseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Fournisseur WHERE idFournisseur = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setInt( 1, idFournisseur );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireFournisseur( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	
	
	@Override
	public List<Fournisseur> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Fournisseur ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Fournisseur> fournisseurs = new ArrayList<>();
			while ( rs.next() ) {
				fournisseurs.add( construireFournisseur(rs) );
			}
			return fournisseurs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	

	@Override
	public boolean verifierUniciteNom( String nom, int idFournisseur )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) AS nbFournisseurs"
				+ " FROM Fournisseur WHERE nom=? AND idFournisseur <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(	1, nom );
			stmt.setInt(	2, idFournisseur );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getInt( "nbFournisseurs" ) == 0;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Fournisseur construireFournisseur( ResultSet rs ) throws SQLException {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdFournisseur( rs.getInt( "IdFournisseur" ) );
		fournisseur.setNom( rs.getString( "nom" ) );
		fournisseur.setMail( rs.getString( "email" ) );
		fournisseur.setTelephone(rs.getString("telephone"));
		return fournisseur;
	}
	
}
