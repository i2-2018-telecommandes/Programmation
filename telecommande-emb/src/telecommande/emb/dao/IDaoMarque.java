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
