package telecommande.emb.service.standard;

import java.util.ArrayList;
import java.util.List;

import telecommande.commun.dto.DtoTeleviseur;
import telecommande.commun.service.IServiceTeleviseur;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoTeleviseur;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.Televiseur;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceTeleviseur implements IServiceTeleviseur {

	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private	IManagerTransaction	managerTransaction;
	private IMapper				mapper;
	private IDaoTeleviseur			daoTeleviseur;
	
	
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

	public void setDaoTeleviseur( IDaoTeleviseur daoTeleviseur ) {
		this.daoTeleviseur = daoTeleviseur;
	}

	
	// Actions 

	@Override
	public int inserer( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation {
		
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoTeleviseur );

			managerTransaction.begin();
			int id = daoTeleviseur.inserer( mapper.map( dtoTeleviseur ) );
			managerTransaction.commit();
			return id;

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	@Override
	public void modifier( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation { 
		try {

			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoTeleviseur );

			managerTransaction.begin();
			daoTeleviseur.modifier( mapper.map( dtoTeleviseur ) );
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
		
	}

	@Override
	public void supprimer( int idTeleviseur ) throws ExceptionValidation  {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			

			managerTransaction.begin();
			daoTeleviseur.supprimer(idTeleviseur);
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	
	@Override
	public DtoTeleviseur retrouver( int idTeleviseur ) {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			return mapper.map( daoTeleviseur.retrouver(idTeleviseur) );

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	
	@Override
	public List<DtoTeleviseur> listerTout() {
		try {

			//managerSecurite.verifierAutorisationAdmin();
			List<DtoTeleviseur> liste = new ArrayList<>();
			for( Televiseur televiseur : daoTeleviseur.listerTout() ) {
				liste.add( mapper.map( televiseur ) );
			}
			return liste;

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}
	
	
	// Méthodes auxiliaires
	
	private void verifierValiditeDonnees( DtoTeleviseur dtoTeleviseur ) throws ExceptionValidation {
		
		StringBuilder message = new StringBuilder();
		
		if ( dtoTeleviseur.getNom() == null || dtoTeleviseur.getNom().isEmpty() ) {
			message.append( "\nLe nom est absent." );
		
		} else 	if ( ! daoTeleviseur.verifierUniciteNom( dtoTeleviseur.getNom(), dtoTeleviseur.getIdTeleviseur() ) ) {
			message.append( "\nLe Nom " + dtoTeleviseur.getNom() + " est déjà utilisé." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
	}
	
}
