<<<<<<< HEAD
package telecommande.dao.jdbc.util;


public final class UtilJdbc {
	
	
	// Constructeur
	private UtilJdbc() {
	}

	
	// Méthodes utilitaires
	
	public static void close( AutoCloseable...closeables ) {
		for ( AutoCloseable closeable : closeables ) {
			if ( closeable != null ) {
				try {
					closeable.close();
				} catch( Exception e ) {
				}
			}
		}
		
	}
	
}
=======
package telecommande.dao.jdbc.util;


public final class UtilJdbc {
	
	
	// Constructeur
	private UtilJdbc() {
	}

	
	// Méthodes utilitaires
	
	public static void close( AutoCloseable...closeables ) {
		for ( AutoCloseable closeable : closeables ) {
			if ( closeable != null ) {
				try {
					closeable.close();
				} catch( Exception e ) {
				}
			}
		}
		
	}
	
}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
