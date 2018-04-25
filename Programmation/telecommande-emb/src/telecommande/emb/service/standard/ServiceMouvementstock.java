package telecommande.emb.service.standard;

import java.util.ArrayList;
import java.util.List;

import telecommande.commun.dto.DtoMouvementstock;
import telecommande.commun.service.IServiceMouvementstock;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoMouvementstock;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.Mouvementstock;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;
import telecommande.service.util.UtilServices;

public class ServiceMouvementstock implements IServiceMouvementstock {
	// Champs

	@SuppressWarnings("unused")
	private IManagerSecurite managerSecurite;
	private IManagerTransaction managerTransaction;
	private IMapper mapper;
	private IDaoMouvementstock daoMouvementstock;

	// Injecteurs

	public void setManagerSecurite(IManagerSecurite managerSecurite) {
		this.managerSecurite = managerSecurite;
	}

	public void setManagerTransaction(IManagerTransaction managerTransaction) {
		this.managerTransaction = managerTransaction;
	}

	public void setMapper(IMapper mapper) {
		this.mapper = mapper;
	}

	public void setDaoMouvementstock(IDaoMouvementstock daoMouvementstock) {
		this.daoMouvementstock = daoMouvementstock;
	}

	// Action

	@Override
	public DtoMouvementstock retrouver(int idMouvementstock) {
		try {
			return mapper.map(daoMouvementstock.retrouver(idMouvementstock));
		} catch (Exception e) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	@Override
	public List<DtoMouvementstock> listerTout() {
		try {

			// managerSecurite.verifierAutorisationAdmin();
			List<DtoMouvementstock> liste = new ArrayList<>();
			for (Mouvementstock mouvement : daoMouvementstock.listerTout()) {
				liste.add(mapper.map(mouvement));
			}
			return liste;

		} catch (Exception e) {
			throw UtilServices.exceptionAnomalie(e);
		}
	}

	@Override
	public int inserer(DtoMouvementstock dtoMouvementstock) throws ExceptionValidation {
		try {
			// managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees(dtoMouvementstock);

			managerTransaction.begin();
			int id = daoMouvementstock.inserer(mapper.map(dtoMouvementstock));
			managerTransaction.commit();
			return id;

		} catch (Exception e) {
			managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}
	}

	@Override
	public void modifier(DtoMouvementstock dtoMouvementstock) throws ExceptionValidation {
		try {

			// managerSecurite.verifierAutorisationAdmin();
			verifierValiditeDonnees(dtoMouvementstock);

			managerTransaction.begin();
			daoMouvementstock.modifier(mapper.map(dtoMouvementstock));
			managerTransaction.commit();

		} catch (Exception e) {
			managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}

	}

	@Override
	public void supprimer(int idMouvement) throws ExceptionValidation {
		try {

			managerTransaction.begin();
			daoMouvementstock.supprimer(idMouvement);
			managerTransaction.commit();

		} catch (Exception e) {
			managerTransaction.rollbackSiApplicable();
			throw UtilServices.exceptionValidationOuAnomalie(e);
		}

	}

	private void verifierValiditeDonnees(DtoMouvementstock dtoMouvementstock) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoMouvementstock.getLibelle() == null || dtoMouvementstock.getLibelle().isEmpty()) {
			message.append("\nLe Libelle est absent.");

		} else if (!daoMouvementstock.verifierUniciteNom(dtoMouvementstock.getLibelle(),
				dtoMouvementstock.getIdMouvementstock())) {
			message.append("\nLe Libelle " + dtoMouvementstock.getLibelle() + " est déjà utilisé.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
