package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.dto.DtoModeleTelecommande;
import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceModeleTelecommande {
	
	int				inserer( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation;

	void			modifier( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation; 

	void			supprimer( int idModeleTelecommande ) throws ExceptionValidation;

	 DtoModeleTelecommande 		retrouver( int idModeleTelecommande ) ;

	List<DtoModeleTelecommande>	listerTout() ;

	

}
