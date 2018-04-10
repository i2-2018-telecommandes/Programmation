package telecommande.commun.service;

import java.util.List;
import telecommande.commun.dto.DtoMouvementstock;
import telecommande.commun.util.ExceptionValidation;

public interface IServiceMouvementstock {
	
	void			valider( DtoMouvementstock DtoMouvementstock) throws ExceptionValidation; 

	void			annuler( DtoMouvementstock DtoMouvementstock) throws ExceptionValidation; 

	DtoMouvementstock 		retrouver( int idMouvementstock ) ;

	List<DtoMouvementstock>	listerTout() ;
	
	


}
