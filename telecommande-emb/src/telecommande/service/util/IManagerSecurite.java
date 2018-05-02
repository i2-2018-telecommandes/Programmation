<<<<<<< HEAD
package telecommande.service.util;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.util.ExceptionAutorisation;


public interface IManagerSecurite {

	int		getIdCompteConnecte();
	
	void 	verifierAutorisationUtilisateurOuAdmin() throws ExceptionAutorisation;
	
	void 	verifierAutorisationAdmin() throws ExceptionAutorisation;
	
	void 	verifierAutorisationAdminOuCompteConnecte( int idCompte ) throws ExceptionAutorisation;

	void	setCompteConnecté( DtoCompte compteConnecté );

=======
package telecommande.service.util;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.util.ExceptionAutorisation;


public interface IManagerSecurite {

	int		getIdCompteConnecte();
	
	void 	verifierAutorisationUtilisateurOuAdmin() throws ExceptionAutorisation;
	
	void 	verifierAutorisationAdmin() throws ExceptionAutorisation;
	
	void 	verifierAutorisationAdminOuCompteConnecte( int idCompte ) throws ExceptionAutorisation;

	void	setCompteConnecté( DtoCompte compteConnecté );

>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}