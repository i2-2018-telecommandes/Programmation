<<<<<<< HEAD
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceMarque {
	
	int				inserer( DtoMarque dtoMarque ) throws ExceptionValidation;

	void			modifier( DtoMarque dtoMarque ) throws ExceptionValidation; 

	void			supprimer( int idMarque ) throws ExceptionValidation;

	DtoMarque 		retrouver( int idMarque ) ;

	List<DtoMarque>	listerTout() ;

}
=======
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceMarque {
	
	int				inserer( DtoMarque dtoMarque ) throws ExceptionValidation;

	void			modifier( DtoMarque dtoMarque ) throws ExceptionValidation; 

	void			supprimer( int idMarque ) throws ExceptionValidation;

	DtoMarque 		retrouver( int idMarque ) ;

	List<DtoMarque>	listerTout() ;

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
