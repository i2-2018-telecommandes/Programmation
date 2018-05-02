<<<<<<< HEAD
package telecommande.emb.service.standard;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.service.IServiceConnexion;
import telecommande.emb.dao.IDaoCompte;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceConnexion implements IServiceConnexion {
	
	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private IMapper				mapper;
	private IDaoCompte			daoCompte;
	
	
	// Injecteurs
	
	public void setMapper( IMapper mapper ) {
		this.mapper = mapper;
	}

	public void setDaoCompte( IDaoCompte daoCompte ) {
		this.daoCompte = daoCompte;
	}
	
	public void setManagerSecurite( IManagerSecurite managerSecurite ) {
		this.managerSecurite = managerSecurite;
	}
	
	
	// Actions

	@Override
	public DtoCompte sessionUtilisateurOuvrir( String pseudo, String motDePasse ) {
		try {
			DtoCompte compte = mapper.map( daoCompte.validerAuthentification(pseudo, motDePasse) );
			managerSecurite.setCompteConnecté( compte );
			return compte;
		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}


	@Override
	public void sessionUtilisateurFermer() {
		try {
			managerSecurite.setCompteConnecté( null );
		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

}
=======
package telecommande.emb.service.standard;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.service.IServiceConnexion;
import telecommande.emb.dao.IDaoCompte;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;


public class ServiceConnexion implements IServiceConnexion {
	
	
	// Champs 

	private IManagerSecurite	managerSecurite;
	private IMapper				mapper;
	private IDaoCompte			daoCompte;
	
	
	// Injecteurs
	
	public void setMapper( IMapper mapper ) {
		this.mapper = mapper;
	}

	public void setDaoCompte( IDaoCompte daoCompte ) {
		this.daoCompte = daoCompte;
	}
	
	public void setManagerSecurite( IManagerSecurite managerSecurite ) {
		this.managerSecurite = managerSecurite;
	}
	
	
	// Actions

	@Override
	public DtoCompte sessionUtilisateurOuvrir( String pseudo, String motDePasse ) {
		try {
			DtoCompte compte = mapper.map( daoCompte.validerAuthentification(pseudo, motDePasse) );
			managerSecurite.setCompteConnecté( compte );
			return compte;
		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}


	@Override
	public void sessionUtilisateurFermer() {
		try {
			managerSecurite.setCompteConnecté( null );
		} catch ( Exception e ) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
