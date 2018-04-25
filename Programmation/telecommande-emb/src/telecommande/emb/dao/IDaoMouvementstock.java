package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Mouvementstock;



public interface IDaoMouvementstock {


	int			inserer( Mouvementstock mouvementstock );

	void 		modifier( Mouvementstock mouvementstock );

	void 		supprimer( int idMouvementstock );

	Mouvementstock 		retrouver( int idMouvementstock);

	boolean 	verifierUniciteNom( String nom, int idMarque );
	
	List<Mouvementstock> listerTout();
}

