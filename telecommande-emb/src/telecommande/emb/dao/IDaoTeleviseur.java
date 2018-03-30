package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Televiseur;


public interface IDaoTeleviseur {

	int			inserer( Televiseur televiseur );

	void 		modifier( Televiseur televiseur );

	void 		supprimer( int idTeleviseur );

	Televiseur 		retrouver( int idTeleviseur );

	List<Televiseur> listerTout();

	

	boolean 	verifierUniciteNom( String nom, int idteleviseur );

}
