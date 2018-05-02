package telecommande.emb.service.standard;

import java.util.ArrayList;
import java.util.List;

import telecommande.commun.dto.DtoMarque;
import telecommande.commun.service.IServiceMarque;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoMarque;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.Marque;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceMarque implements IServiceMarque {

	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private	IManagerTransaction	managerTransaction;
	private IMapper				mapper;
	private IDaoMarque			daoMarque;
	
	
	// Injecteurs
	
	public void setManagerSecurite( IManagerSecurite managerSecurite ) {
		this.managerSecurite = managerSecurite;
	}
	
	public void setManagerTransaction( IManagerTransaction managerTransaction ) {
		this.managerTransaction = managerTransaction;
	}
	
	public void setMapper( IMapper mapper ) {
		this.mapper = mapper;
	}

	public void setDaoMarque( IDaoMarque daoMarque ) {
		this.daoMarque = daoMarque;
	}

	
	// Actions 

	@Override
	public int inserer( DtoMarque dtoMarque ) throws ExceptionValidation {
		
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoMarque );

			managerTransaction.begin();
			int id = daoMarque.inserer( mapper.map( dtoMarque ) );
			managerTransaction.commit();
			return id;

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	@Override
	public void modifier( DtoMarque dtoMarque ) throws ExceptionValidation { 
		try {

			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoMarque );

			managerTransaction.begin();
			daoMarque.modifier( mapper.map( dtoMarque ) );
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
		
	}

	@Override
	public void supprimer( int idMarque ) throws ExceptionValidation  {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			

			managerTransaction.begin();
			daoMarque.supprimer(idMarque);
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	
	@Override
	public DtoMarque retrouver( int idMarque ) {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			return mapper.map( daoMarque.retrouver(idMarque) );

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	
	@Override
	public List<DtoMarque> listerTout() {
		try {

			//managerSecurite.verifierAutorisationAdmin();
			List<DtoMarque> liste = new ArrayList<>();
			for( Marque marque : daoMarque.listerTout() ) {
				liste.add( mapper.map( marque ) );
			}
			return liste;

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}
	
	
	// Méthodes auxiliaires
	
	private void verifierValiditeDonnees( DtoMarque dtoMarque ) throws ExceptionValidation {
		
		StringBuilder message = new StringBuilder();
		
		if ( dtoMarque.getNom() == null || dtoMarque.getNom().isEmpty() ) {
			message.append( "\nLe nom est absent." );
		
		} else 	if ( ! daoMarque.verifierUniciteNom( dtoMarque.getNom(), dtoMarque.getIdMarque() ) ) {
			message.append( "\nLe Nom " + dtoMarque.getNom() + " est déjà utilisé." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
	}
	
}
