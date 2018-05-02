<<<<<<< HEAD
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Compte;


public interface IDaoCompte {

	int			inserer( Compte compte );

	void 		modifier( Compte compte );

	void 		supprimer( int idCompte );

	Compte 		retrouver( int idCompte );

	List<Compte> listerTout();

	Compte 		validerAuthentification( String pseudo, String motDePasse );

	boolean 	verifierUnicitePseudo( String pseudo, int idCompte );

	Compte retrouvernom(char pseudo);

}
=======
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Compte;


public interface IDaoCompte {

	int			inserer( Compte compte );

	void 		modifier( Compte compte );

	void 		supprimer( int idCompte );

	Compte 		retrouver( int idCompte );

	List<Compte> listerTout();

	Compte 		validerAuthentification( String pseudo, String motDePasse );

	boolean 	verifierUnicitePseudo( String pseudo, int idCompte );

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
