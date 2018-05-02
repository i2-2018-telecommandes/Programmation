package telecommande.emb.service.standard;

import java.util.ArrayList;
import java.util.List;

import telecommande.commun.dto.DtoFournisseur;
import telecommande.commun.service.IServiceFournisseur;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoFournisseur;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.Fournisseur;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceFournisseur implements IServiceFournisseur {

	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private	IManagerTransaction	managerTransaction;
	private IMapper				mapper;
	private IDaoFournisseur		daoFournisseur;
	
	
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

	public void setDaoFournisseur( IDaoFournisseur daoFournisseur ) {
		this.daoFournisseur = daoFournisseur;
	}

	
	// Actions 

	@Override
	public int inserer( DtoFournisseur dtoFournisseur ) throws ExceptionValidation {
		
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoFournisseur );

			managerTransaction.begin();
			int id = daoFournisseur.inserer( mapper.map( dtoFournisseur ) );
			managerTransaction.commit();
			return id;

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	@Override
	public void modifier( DtoFournisseur dtoFournisseur ) throws ExceptionValidation { 
		try {

			//managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees( dtoFournisseur );

			managerTransaction.begin();
			daoFournisseur.modifier( mapper.map( dtoFournisseur ) );
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
		
	}

	@Override
	public void supprimer( int idFournisseur ) throws ExceptionValidation  {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			

			managerTransaction.begin();
			daoFournisseur.supprimer(idFournisseur);
			managerTransaction.commit();

		} catch ( Exception e ) {
	    	managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	
	@Override
	public DtoFournisseur retrouver( int idFournisseur ) {
		try {
			
			//managerSecurite.verifierAutorisationAdmin();
			return mapper.map( daoFournisseur.retrouver(idFournisseur) );

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	
	@Override
	public List<DtoFournisseur> listerTout() {
		try {

			//managerSecurite.verifierAutorisationAdmin();
			List<DtoFournisseur> liste = new ArrayList<>();
			for( Fournisseur fournisseur : daoFournisseur.listerTout() ) {
				liste.add( mapper.map( fournisseur ) );
			}
			return liste;

		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}
	
	
	// Méthodes auxiliaires
	
	private void verifierValiditeDonnees( DtoFournisseur dtoFournisseur ) throws ExceptionValidation {
		
		StringBuilder message = new StringBuilder();
		
		if ( dtoFournisseur.getNom() == null || dtoFournisseur.getNom().isEmpty() ) {
			message.append( "\nLe nom est absent." );
		
		} else 	if ( ! daoFournisseur.verifierUniciteNom( dtoFournisseur.getNom(), dtoFournisseur.getIdFournisseur() ) ) {
			message.append( "\nLe Nom " + dtoFournisseur.getNom() + " est déjà utilisé." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
	}
	
}
