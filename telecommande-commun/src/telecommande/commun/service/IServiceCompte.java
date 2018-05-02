<<<<<<< HEAD
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceCompte {
	
	int				inserer( DtoCompte dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoCompte dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idUtilisateur ) throws ExceptionValidation;

	DtoCompte 		retrouver( int idUtilisateur ) ;

	List<DtoCompte>	listerTout() ;

}
=======
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceCompte {
	
	int				inserer( DtoCompte dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoCompte dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idUtilisateur ) throws ExceptionValidation;

	DtoCompte 		retrouver( int idUtilisateur ) ;

	List<DtoCompte>	listerTout() ;

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
