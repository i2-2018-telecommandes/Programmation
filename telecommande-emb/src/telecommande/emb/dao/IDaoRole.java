<<<<<<< HEAD
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Compte;


public interface IDaoRole {

	void insererPourCompte( Compte compte );

	void modifierPourCompte( Compte compte );

	void supprimerPourCompte( int idCompte );

	List<String> listerPourCompte( Compte compte );

}
=======
package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Compte;


public interface IDaoRole {

	void insererPourCompte( Compte compte );

	void modifierPourCompte( Compte compte );

	void supprimerPourCompte( int idCompte );

	List<String> listerPourCompte( Compte compte );

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
