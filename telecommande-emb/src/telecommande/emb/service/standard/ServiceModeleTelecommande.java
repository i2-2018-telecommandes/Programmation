package telecommande.emb.service.standard;

import java.util.ArrayList;
import java.util.List;

import telecommande.commun.dto.DtoModeleTelecommande;
import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.service.IServiceModeleTelecommande;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoModeleTelecommande;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.ModeleTelecommande;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceModeleTelecommande implements IServiceModeleTelecommande {

	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private	IManagerTransaction	managerTransaction;
	private IMapper				mapper;
	private IDaoModeleTelecommande			daoModeleTelecommande;
	
	
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

	public void setDaoModeleTelecommande( IDaoModeleTelecommande daoModeleTelecommande ) {
		this.daoModeleTelecommande = daoModeleTelecommande;
	}

	
	// Actions 

	@Override
	public int inserer( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation {
		
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoModeleTelecommande );

			managerTransaction.begin();
			int id = daoModeleTelecommande.inserer( mapper.map( dtoModeleTelecommande ) );
			managerTransaction.commit();
			return id;

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	@Override
	public void modifier( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation { 
		try {

			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoModeleTelecommande );

			managerTransaction.begin();
			daoModeleTelecommande.modifier( mapper.map( dtoModeleTelecommande ) );
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
		
	}

	@Override
	public void supprimer( int idModeleTelecommande ) throws ExceptionValidation  {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			

			managerTransaction.begin();
			daoModeleTelecommande.supprimer(idModeleTelecommande);
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	
	@Override
	public DtoModeleTelecommande retrouver( int idModeleTelecommande ) {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			return mapper.map( daoModeleTelecommande.retrouver(idModeleTelecommande) );

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	
	@Override
	public List<DtoModeleTelecommande> listerTout() {
		try {

			//managerSecurite.verifierAutorisationAdmin();
			List<DtoModeleTelecommande> liste = new ArrayList<>();
			for( ModeleTelecommande modeleTecommande : daoModeleTelecommande.listerTout() ) {
				liste.add( mapper.map( modeleTecommande ) );
			}
			return liste;

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}
	
	
	// Méthodes auxiliaires
	
	private void verifierValiditeDonnees( DtoModeleTelecommande dtoModeleTelecommande ) throws ExceptionValidation {
		
		StringBuilder message = new StringBuilder();
		
		if ( dtoModeleTelecommande.getNom() == null || dtoModeleTelecommande.getNom().isEmpty() ) {
			message.append( "\nLe nom est absent." );
		
		} else 	if ( ! daoModeleTelecommande.verifierUniciteNom( dtoModeleTelecommande.getNom(), dtoModeleTelecommande.getIdTelecommande() ) ) {
			message.append( "\nLe Nom " + dtoModeleTelecommande.getNom() + " est déjà utilisé." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
	}


	
}
