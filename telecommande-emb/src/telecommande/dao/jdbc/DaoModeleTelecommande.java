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
import telecommande.emb.dao.IDaoModeleTelecommande;
import telecommande.emb.dao.IDaoFournisseur;
import telecommande.emb.data.ModeleTelecommande;


public class DaoModeleTelecommande implements IDaoModeleTelecommande {

	
	// Champs

	private DataSource		dataSource;
	private IDaoFournisseur      daofournisseur;

	
	// Injecteurs
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDaofournisseur(IDaoFournisseur daofournisseur) {
		this.daofournisseur = daofournisseur;
	}
	// Actions
	
	@Override
	public int inserer(ModeleTelecommande modeleTecommande)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			
			// Insère le modeleTecommande
			sql = "INSERT INTO ModeleTelecommande (nom,notice,qteseuil,qtestock,prix,idfournisseur)  VALUES (?,?,?,?,?)";
	   		stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
			stmt.setString(	1, modeleTecommande.getNom());
			stmt.setString(	2, modeleTecommande.getNotice());
			stmt.setInt   (	3, modeleTecommande.getQteSeuil() );
			stmt.setInt   ( 4, modeleTecommande.getQteStock());
			stmt.setFloat (	5, modeleTecommande.getPrix() );
			stmt.setInt   (	6, modeleTecommande.getFournisseur().getIdFournisseur() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
            rs.next();
			modeleTecommande.setIdTelecommande( rs.getInt(1) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}

	
		
		// Retourne l'identifiant
		return modeleTecommande.getIdTelecommande();
	}

	
	@Override
	public void modifier(ModeleTelecommande modeleTecommande)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le modeleTecommande
			
			sql = "UPDATE ModeleTelecommande SET nom = ?,notice=?, qteseuil=?, qtestock=?, prix=?, idfourniseur=? WHERE IdModeleTelecommande =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(	1, modeleTecommande.getNom() );
			stmt.setString(	2, modeleTecommande.getNotice() );
			stmt.setInt   (	3, modeleTecommande.getQteSeuil() );
			stmt.setInt   ( 4, modeleTecommande.getQteStock());
			stmt.setFloat (	5, modeleTecommande.getPrix() );
			stmt.setInt   (	6, modeleTecommande.getFournisseur().getIdFournisseur() );
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		
	}

	
	@Override
	public void supprimer(int idModeleTelecommande)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le modeleTecommande
			sql = "DELETE FROM ModeleTelecommande WHERE IdTelecommande = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idModeleTelecommande );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	@Override
	public ModeleTelecommande retrouver(int idModeleTelecommande)  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM ModeleTelecommande WHERE idTelecommande = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setInt( 1, idModeleTelecommande );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireModeleTelecommande( rs );
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
	public List<ModeleTelecommande> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM ModeleTelecommande ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<ModeleTelecommande> modeleTecommandes = new ArrayList<>();
			while ( rs.next() ) {
				modeleTecommandes.add( construireModeleTelecommande(rs) );
			}
			return modeleTecommandes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	@Override
	public boolean verifierUniciteNom( String nom, int idModeleTelecommande )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) AS nbModeleTelecommandes"
				+ " FROM ModeleTelecommande WHERE nom=? AND idModeleTelecommande <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setString(	1, nom );
			stmt.setInt(	2, idModeleTelecommande );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getInt( "nbModeleTelecommandes" ) == 0;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires

	private ModeleTelecommande construireModeleTelecommande( ResultSet rs ) throws SQLException {
		ModeleTelecommande modeleTecommande = new ModeleTelecommande();
		modeleTecommande.setIdTelecommande( rs.getInt( "IdModeleTelecommande" ) );
		modeleTecommande.setNom( rs.getString( "nom" ) );
		modeleTecommande.setNotice( rs.getString( "notice" ) );
		modeleTecommande.setQteSeuil(rs.getInt( "qteseuil" ) );
		modeleTecommande.setQteStock( rs.getInt( "qtestock" ) );
		modeleTecommande.setPrix( rs.getFloat("prix") );
		modeleTecommande.setFournisseur(((daofournisseur.retrouver(rs.getInt("IdFournisseur")))));		
		return modeleTecommande;
	}
	
	

}
