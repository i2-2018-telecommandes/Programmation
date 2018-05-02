<<<<<<< HEAD
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Fournisseur;
import telecommande.emb.data.Marque;


public interface IDaoMarque {

	int			inserer( Marque marque );

	void 		modifier( Marque marque );

	void 		supprimer( int idMarque );

	Marque      retrouver( int idMarque );

	List<Marque> listerTout();

	

	boolean 	verifierUniciteNom( String nom, int idMarque );

}
=======
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Marque;


public interface IDaoMarque {

	int			inserer( Marque marque );

	void 		modifier( Marque marque );

	void 		supprimer( int idMarque );

	Marque 		retrouver( int idMarque );

	List<Marque> listerTout();

	

	boolean 	verifierUniciteNom( String nom, int idMarque );

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
