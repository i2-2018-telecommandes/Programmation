package telecommande.commun.service;

import java.util.List;
import telecommande.commun.dto.DtoMouvementstock;
import telecommande.commun.util.ExceptionValidation;

public interface IServiceMouvementstock {
	
	int				inserer( DtoMouvementstock dtoMouvementstock) throws ExceptionValidation;

	DtoMouvementstock 		retrouver( int idMouvementstock ) ;

	List<DtoMouvementstock>	listerTout() ;
	
	


}
