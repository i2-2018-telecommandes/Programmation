package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.ModeleTelecommande;



public interface IDaoModeleTelecommande {

	int			inserer( ModeleTelecommande modeleTecommande );

	void 		modifier( ModeleTelecommande modeleTecommande );

	void 		supprimer( int idModeleTelecommande );

	ModeleTelecommande 		retrouver( int idModeleTelecommande );

	List<ModeleTelecommande> listerTout();

	

	boolean 	verifierUniciteNom( String nom, int idmodeleTecommande );

}
