package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoModeleTelecommande;
import telecommande.commun.util.ExceptionValidation;

public interface IServiceModeleTelecommande {
	
	
	int				inserer( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation;

	void			modifier(  DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation; 

	void			supprimer( int idTelecommande ) throws ExceptionValidation;

	DtoModeleTelecommande 		retrouver( int idTelecommande ) ;

	List<DtoModeleTelecommande>	listerTout() ;
	  
	

}
