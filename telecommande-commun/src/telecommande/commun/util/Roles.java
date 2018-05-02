<<<<<<< HEAD
package telecommande.commun.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public final class Roles {
	
	// Champs statiques
	
	public static final String DONNEES	= "DONNEES";
	public static final String STOCK		= "STOCK";
	public static final String VENTE		= "VENTE";
	
	
	private static final List<String>	roles = Collections.unmodifiableList( Arrays.asList( 
			DONNEES,			
			STOCK,
			VENTE
	) );

	private static final String[]	 	libellés = new String[] {
			"DONNEES",
			"STOCK",
			"VENTE"
	};
	
	
	// Constructeur privé qui empêche l'instanciation de la classe
	private Roles() {
	}
	
	
	// Actions

	public static List<String> getRoles() {
		return roles;
	}
	
	public static String getLibellé( String role ) {
		int index = roles.indexOf( role );
		if ( index == -1 ) {
			throw new IllegalArgumentException();
		} 
		return libellés[index];
	}

}
=======
package telecommande.commun.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public final class Roles {
	
	// Champs statiques
	
	public static final String DONNEES	= "DONNEES";
	public static final String STOCK		= "STOCK";
	public static final String VENTE		= "VENTE";
	
	
	private static final List<String>	roles = Collections.unmodifiableList( Arrays.asList( 
			DONNEES,			
			STOCK,
			VENTE
	) );

	private static final String[]	 	libellés = new String[] {
			"DONNEES",
			"STOCK",
			"VENTE"
	};
	
	
	// Constructeur privé qui empêche l'instanciation de la classe
	private Roles() {
	}
	
	
	// Actions

	public static List<String> getRoles() {
		return roles;
	}
	
	public static String getLibellé( String role ) {
		int index = roles.indexOf( role );
		if ( index == -1 ) {
			throw new IllegalArgumentException();
		} 
		return libellés[index];
	}

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
