package telecommande.emb.service.standard;

import java.util.List;

import telecommande.commun.dto.DtoMouvementstock;
import telecommande.commun.service.IServiceMouvementstock;
import telecommande.commun.util.ExceptionValidation;
import telecommande.emb.dao.IDaoMouvementstock;
import telecommande.emb.dao.IManagerTransaction;
import telecommande.emb.data.mapper.IMapper;
import telecommande.service.util.IManagerSecurite;

public class ServiceMouvementstock implements IServiceMouvementstock {
	// Champs

	private IManagerSecurite managerSecurite;
	private IManagerTransaction managerTransaction;
	private IMapper mapper;
	private IDaoMouvementstock daoMouvementstock;
	
	
	//Injecteurs
	
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

	
	
	//Action
	
	@Override
	public void valider(DtoMouvementstock DtoMouvementstock) throws ExceptionValidation {
		// TODO Auto-generated method stub

	}

	@Override
	public void annuler(DtoMouvementstock DtoMouvementstock) throws ExceptionValidation {
		// TODO Auto-generated method stub

	}

	@Override
	public DtoMouvementstock retrouver(int idMouvementstock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtoMouvementstock> listerTout() {
		// TODO Auto-generated method stub
		return null;
	}

}
