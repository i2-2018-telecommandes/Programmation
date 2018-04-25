package telecommande.commun.service;

import java.util.List;
import telecommande.commun.dto.DtoMouvementstock;
import telecommande.commun.util.ExceptionValidation;

public interface IServiceMouvementstock {
	
	int				inserer( DtoMouvementstock dtoMouvementstock) throws ExceptionValidation;

	void			modifier( DtoMouvementstock dtoMouvementstock ) throws ExceptionValidation; 

	void			supprimer( int idMouvement ) throws ExceptionValidation;

	DtoMouvementstock 		retrouver( int idMouvementstock ) ;

	List<DtoMouvementstock>	listerTout() ;
	
	


}
