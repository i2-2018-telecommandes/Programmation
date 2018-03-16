package telecommande.javafx.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import telecommande.commun.dto.DtoCompte;
import telecommande.javafx.data.Compte;
   

@Mapper( uses=IMapper.FactoryObsservableList.class  )
public interface IMapper { 
	
	IMapper INSTANCE = Mappers.getMapper( IMapper.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte update( Compte source, @MappingTarget Compte target );
	
	
    // Classe auxiliaire
    
    public static class FactoryObsservableList {

    	ObservableList<String> createObsListString() {
    		return FXCollections.observableArrayList();
    	}

    }
    
}