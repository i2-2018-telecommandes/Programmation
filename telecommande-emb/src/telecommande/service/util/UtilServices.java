<<<<<<< HEAD
package telecommande.service.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import telecommande.commun.util.ExceptionAnomalie;
import telecommande.commun.util.ExceptionValidation;


public final class UtilServices {


	// Logger
	private static final Logger logger = Logger.getLogger( UtilServices.class.getName() );
	
	
	// Constructeur
	private UtilServices() {
	}
    
    
	public static ExceptionAnomalie exceptionAnomalie( Exception e ) {

    	if ( e instanceof ExceptionAnomalie ) {
    		return (ExceptionAnomalie) e;
    	} else {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return new ExceptionAnomalie(e);
    	}
    }
    
    
    public static ExceptionValidation exceptionValidationOuAnomalie( Exception e ) {
    	
    	if ( e instanceof ExceptionValidation ) {
    		return (ExceptionValidation) e;
    	}
    	
    	throw exceptionAnomalie( e  );
    }

}
=======
package telecommande.service.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import telecommande.commun.util.ExceptionAnomalie;
import telecommande.commun.util.ExceptionValidation;


public final class UtilServices {


	// Logger
	private static final Logger logger = Logger.getLogger( UtilServices.class.getName() );
	
	
	// Constructeur
	private UtilServices() {
	}
    
    
	public static ExceptionAnomalie exceptionAnomalie( Exception e ) {

    	if ( e instanceof ExceptionAnomalie ) {
    		return (ExceptionAnomalie) e;
    	} else {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return new ExceptionAnomalie(e);
    	}
    }
    
    
    public static ExceptionValidation exceptionValidationOuAnomalie( Exception e ) {
    	
    	if ( e instanceof ExceptionValidation ) {
    		return (ExceptionValidation) e;
    	}
    	
    	throw exceptionAnomalie( e  );
    }

}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
