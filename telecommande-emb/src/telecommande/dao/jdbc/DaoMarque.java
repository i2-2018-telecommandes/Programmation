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
import telecommande.emb.dao.IDaoMarque;
import telecommande.emb.data.Marque;


public class DaoMarque implements IDaoMarque {

	
	// Champs

	private DataSource		dataSource;
	

	
	// Injecteurs
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	// Actions
	
	@Override
	public int inserer(Marque marque)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le marque
			sql = "INSERT INTO Marque (nom)  VALUES ( ?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
			stmt.setString(	1, marque.getNom() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			marque.setIdMarque( rs.getInt(1) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	
		
		// Retourne l'identifiant
		return marque.getIdMarque();
	}

	
	@Override
	public void modifier(Marque marque)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le marque
			sql = "UPDATE marque SET nom = ? WHERE IdMarque =  ?";
			stmt = cn.prepareStatement( sql );
			
			stmt.setString(	1, marque.getNom() );
			stmt.setInt(2, marque.getIdMarque() );
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		
	}

	
	@Override
	public void supprimer(int idMarque)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le marque
			sql = "DELETE FROM Marque WHERE Idmarque = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idMarque );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	@Override
	public Marque retrouver(int idMarque)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Marque WHERE idMarque = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setInt( 1, idMarque );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireMarque( rs );
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
	public List<Marque> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Marque ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Marque> marques = new ArrayList<>();
			while ( rs.next() ) {
				marques.add( construireMarque(rs) );
			}
			return marques;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	

	@Override
	public boolean verifierUniciteNom( String nom, int idMarque )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) AS nbMarques"
				+ " FROM Marque WHERE nom=? AND idMarque <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(	1, nom );
			stmt.setInt(	2, idMarque );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getInt( "nbMarques" ) == 0;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Marque construireMarque( ResultSet rs ) throws SQLException {
		Marque marque = new Marque();
		marque.setIdMarque( rs.getInt( "IdMarque" ) );
		marque.setNom( rs.getString( "nom" ) );
		
		return marque;
	}
	
}
