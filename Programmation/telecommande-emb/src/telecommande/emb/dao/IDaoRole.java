package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Compte;


public interface IDaoRole {

	void insererPourCompte( Compte compte );

	void modifierPourCompte( Compte compte );

	void supprimerPourCompte( int idCompte );

	List<String> listerPourCompte( Compte compte );

}
