package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Mouvementstock;



public interface IDaoMouvementstock {

	void valider( Mouvementstock mouvementstock );
	
	
	void annuler( Mouvementstock mouvementstock );
	
	Mouvementstock 		retrouver( int idMouvementstock );
	
	List<Mouvementstock> listerTout();
}

