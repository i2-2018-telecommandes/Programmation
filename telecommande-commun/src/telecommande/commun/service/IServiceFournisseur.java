package telecommande.commun.service;

import java.util.List;

import telecommande.commun.dto.DtoFournisseur;
import telecommande.commun.util.ExceptionValidation;


public interface IServiceFournisseur {
	
	int				inserer( DtoFournisseur dtoFournisseur ) throws ExceptionValidation;

	void			modifier( DtoFournisseur dtoFournisseur ) throws ExceptionValidation; 

	void			supprimer( int idFournisseur ) throws ExceptionValidation;

	DtoFournisseur 		retrouver( int idFournisseur ) ;

	List<DtoFournisseur>	listerTout() ;

}
