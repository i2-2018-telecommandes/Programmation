package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Fournisseur;


public interface IDaoFournisseur {

	int			inserer( Fournisseur fournisseur );

	void 		modifier( Fournisseur fournisseur );

	void 		supprimer( int idFournisseur );

	Fournisseur 		retrouver( int idFournisseur );

	List<Fournisseur> listerTout();

	

	boolean 	verifierUniciteNom( String nom, int idFournisseur );

}
