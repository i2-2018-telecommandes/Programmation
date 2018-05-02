<<<<<<< HEAD
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceTeleviseur {
	
	int				inserer( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation;

	void			modifier( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation; 

	void			supprimer( int idTeleviseur ) throws ExceptionValidation;

	DtoTeleviseur 		retrouver( int idTeleviseur ) ;

	List<DtoTeleviseur>	listerTout() ;

}
=======
package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceTeleviseur {
	
	int				inserer( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation;

	void			modifier( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation; 

	void			supprimer( int idTeleviseur ) throws ExceptionValidation;

	DtoTeleviseur 		retrouver( int idTeleviseur ) ;

	List<DtoTeleviseur>	listerTout() ;

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
