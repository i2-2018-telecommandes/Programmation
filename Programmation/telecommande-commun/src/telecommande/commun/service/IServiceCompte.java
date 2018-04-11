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
