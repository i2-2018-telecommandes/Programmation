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
