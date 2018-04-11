package telecommande.commun.service;

import telecommande.commun.dto.DtoCompte;


public interface IServiceConnexion {

	DtoCompte	sessionUtilisateurOuvrir( String pseudo, String motDePasse );

	void		sessionUtilisateurFermer();

}
