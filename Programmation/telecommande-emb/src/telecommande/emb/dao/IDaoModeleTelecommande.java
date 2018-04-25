package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.ModeleTelecommande;

public interface IDaoModeleTelecommande {
	
	
	int			inserer( ModeleTelecommande ModeleTelecommande );

	void 		modifier( ModeleTelecommande ModeleTelecommande );

	void 		supprimer( int idTelecommande );

	ModeleTelecommande 		retrouver( int idTelecommande );

	List<ModeleTelecommande> listerTout();

	boolean 	verifierUniciteNom( String nom, int idTelecommande );
	

}
