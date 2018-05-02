<<<<<<< HEAD
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
=======
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
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
