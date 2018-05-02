package telecommande.emb.dao;

import java.util.List;

import telecommande.emb.data.Personne;
import telecommande.emb.data.Telephone;


public interface IDaoTelephone {

	void insererPourPersonne(Personne personne);

	void modifierPourPersonne(Personne personne);

	void supprimerPourPersonne(int idPersonne);

	List<Telephone> listerPourPersonne( Personne personne );

}
