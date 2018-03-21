package telecommande.service.util;

import java.io.Serializable;

import telecommande.commun.dto.DtoCompte;
import telecommande.commun.util.ExceptionAutorisation;
import telecommande.commun.util.Roles;


@SuppressWarnings("serial")
public class ManagerSecurite implements IManagerSecurite, Serializable {
	
	
	// Champs
	
	protected DtoCompte compteConnecté;

	
	// Getters & Setters
	
	@Override
	public void setCompteConnecté( DtoCompte compteConnecté ) {
		this.compteConnecté = compteConnecté;
	}
	

	// Actions 
	
	@Override
	public int getIdCompteConnecte() {
		return compteConnecté.getId();
	}

	// Vérifie que le compte connecté a le rôle utilisateur (ou à défaut administrateur)
	@Override
	public void verifierAutorisationUtilisateurOuAdmin() throws ExceptionAutorisation {
		if ( 
				compteConnecté == null
				|| (
						! compteConnecté.isInRole( Roles.VENTE )
						&& ! compteConnecté.isInRole( Roles.STOCK) 
								&& ! compteConnecté.isInRole( Roles.DONNEES) 
				)
			) {
			throw new ExceptionAutorisation();
		}
	}

	// Vérifie que le compte connecté a le rôle administrateur
	@Override
	public void verifierAutorisationAdmin() throws ExceptionAutorisation {
		if ( 
				compteConnecté == null
				|| ! compteConnecté.isInRole( Roles.DONNEES )
			) {
			throw new ExceptionAutorisation();
		}
	}

	// Vérifie que le compte connecte, soit a le rôle administrateur
	// soit a comme identifiant celui passé en paramètre
	@Override
	public void verifierAutorisationAdminOuCompteConnecte( int idCompte ) throws ExceptionAutorisation {
		if ( 
				compteConnecté == null
				|| ( 
						! compteConnecté.isInRole( Roles.DONNEES )
						&& compteConnecté.getId() != idCompte
				)
			) {
			throw new ExceptionAutorisation();
		}
	}

}
