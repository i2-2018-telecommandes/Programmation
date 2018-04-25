package telecommande.dao.jdbc;
/*
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import telecommande.dao.jdbc.util.UtilJdbc;
import telecommande.emb.data.ModeleTelecommande;

public class DaoModeleTelecommande {
	
	
	
	// Champs

		private DataSource		dataSource;
		

		
		// Injecteurs
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
		
		
		// Actions
		
		public int inserer(ModeleTelecommande ModeleTelecommande)  {

			Connection			cn		= null;
			PreparedStatement	stmt	= null;
			ResultSet 			rs 		= null;
			String				sql;

			try {
				cn = (Connection) dataSource.getConnection();

				// Insère le televiseur
				sql = "INSERT INTO ModeleTelecommande nom  VALUES ( ?)";
				stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS  );
				stmt.setString(	1, ModeleTelecommande.getNom() );
				
				stmt.executeUpdate();

				// Récupère l'identifiant généré par le SGBD
				rs = stmt.getGeneratedKeys();
				rs.next();
				ModeleTelecommande.setIdTelecommande( rs.getInt(1) );
		
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				UtilJdbc.close( rs, stmt, cn );
			}

		
			
			// Retourne l'identifiant
			return ModeleTelecommande.getIdTelecommande();
		}

		
		public void modifier(ModeleTelecommande ModeleTelecommande)  {

			Connection			cn		= null;
			PreparedStatement	stmt	= null;
			String 				sql;

			try {
				cn = (Connection) dataSource.getConnection();

				// Modifie le televiseur
				sql = "UPDATE ModeleTelecommande SET nom = ? WHERE IdTelecommande =  ?";
				stmt = cn.prepareStatement( sql );
				
				stmt.setString(	1, ModeleTelecommande.getNom() );
				stmt.setInt(2, ModeleTelecommande.getIdTelecommande() );
				
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				UtilJdbc.close( stmt, cn );
			}

			
		}

		
		public void supprimer(int idTelecommande)  {

			Connection			cn		= null;
			PreparedStatement	stmt	= null;
			String 				sql;

			try {
				cn = (Connection) dataSource.getConnection();

				// Supprime le televiseur
				sql = "DELETE FROM Televiseur WHERE Idteleviseur = ? ";
				stmt = cn.prepareStatement( sql );
				stmt.setInt( 1, idTelecommande );
				stmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				UtilJdbc.close( stmt, cn );
			}
		}

		
		public ModeleTelecommande retrouver(int idTelecommande)  {

			Connection			cn		= null;
			PreparedStatement	stmt	= null;
			ResultSet 			rs 		= null;
			String				sql;

			try {
				cn = (Connection) dataSource.getConnection();

				sql = "SELECT * FROM Televiseur WHERE idTeleviseur = ?";
	            stmt = cn.prepareStatement( sql );
	            stmt.setInt( 1, idTelecommande );
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

		
		
		public List<Marque> listerToutm()   {

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
			televiseur.setIdMarque(rs.getInt("IdMarque"));
			
			return televiseur;
		}
		
		
		private Marque construireMarque( ResultSet rs ) throws SQLException {
			Marque marque = new Marque();
			marque.setIdMarque( rs.getInt( "IdMarque" ) );
			marque.setNom( rs.getString( "nom" ) );
			
			return marque;
		}
	
	

}

*/
