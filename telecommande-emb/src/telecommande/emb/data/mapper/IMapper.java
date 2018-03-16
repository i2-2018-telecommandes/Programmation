package telecommande.emb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import telecommande.commun.dto.DtoCompte;
import telecommande.emb.data.Compte;

 
@Mapper
public interface IMapper {  
	
	static final IMapper INSTANCE = Mappers.getMapper( IMapper.class );
	
	
	// Comptes
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );
}
