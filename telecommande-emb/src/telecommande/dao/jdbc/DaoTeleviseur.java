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
import telecommande.emb.dao.IDaoTeleviseur;
import telecommande.emb.dao.IDaoMarque;
import telecommande.emb.data.Televiseur;


public class DaoTeleviseur implements IDaoTeleviseur {

	
	// Champs

	private DataSource		dataSource;
	private IDaoMarque      daomarque;

	
	// Injecteurs
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDaomarque(IDaoMarque daomarque) {
		this.daomarque = daomarque;
	}
	// Actions
	
	@Override
	public int inserer(Televiseur televiseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le televiseur
			sql = "INSERT INTO Televiseur (nom,reference,idmarque)  VALUES (?,?,?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
			stmt.setString(	1, televiseur.getNom() );
			stmt.setString(	2, televiseur.getReference() );
			stmt.setInt   ( 3, televiseur.getMarque().getIdMarque() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			televiseur.setIdTeleviseur( rs.getInt(1) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	
		
		// Retourne l'identifiant
		return televiseur.getIdTeleviseur();
	}

	
	@Override
	public void modifier(Televiseur televiseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le televiseur
			sql = "UPDATE televiseur SET nom = ?,reference=?, idmarque=? WHERE IdTeleviseur =  ?";
			stmt = cn.prepareStatement( sql );
			
			stmt.setString(	1, televiseur.getNom() );
			stmt.setString(	2, televiseur.getReference() );
			stmt.setInt   (	3, televiseur.getMarque().getIdMarque() );
			stmt.setInt   ( 4, televiseur.getIdTeleviseur() );
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		
	}

	
	@Override
	public void supprimer(int idTeleviseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le televiseur
			sql = "DELETE FROM Televiseur WHERE Idteleviseur = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idTeleviseur );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	@Override
	public Televiseur retrouver(int idTeleviseur)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Televiseur WHERE idTeleviseur = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setInt( 1, idTeleviseur );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireTeleviseur( rs );
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
	public List<Televiseur> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Televiseur ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Televiseur> televiseurs = new ArrayList<>();
			while ( rs.next() ) {
				televiseurs.add( construireTeleviseur(rs) );
			}
			return televiseurs;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	@Override
	public boolean verifierUniciteNom( String nom, int idTeleviseur )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) AS nbTeleviseurs"
				+ " FROM Televiseur WHERE nom=? AND idTeleviseur <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(	1, nom );
			stmt.setInt(	2, idTeleviseur );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getInt( "nbTeleviseurs" ) == 0;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Televiseur construireTeleviseur( ResultSet rs ) throws SQLException {
		Televiseur televiseur = new Televiseur();
		televiseur.setIdTeleviseur( rs.getInt( "IdTeleviseur" ) );
		televiseur.setNom( rs.getString( "nom" ) );
		televiseur.setReference( rs.getString( "reference" ) );
		televiseur.setMarque(daomarque.retrouver(rs.getInt("IdMarque")));
		
		return televiseur;
	}
	
	

}
