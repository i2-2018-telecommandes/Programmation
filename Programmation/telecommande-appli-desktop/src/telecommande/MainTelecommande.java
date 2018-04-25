package telecommande;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import telecommande.commun.service.IContextService;
import telecommande.dao.jdbc.util.DataSourceSingleConnection;
import telecommande.emb.dao.IContextDao;
import telecommande.javafx.model.IContextModel;
import telecommande.javafx.view.IManagerGui;


public class MainTelecommande {

	
	// Composants de l'application
	private static DataSourceSingleConnection	dataSource;
	private static IContextDao					contextDao;
	private static IContextService				contextService;
	private static IContextModel 				contextModel;
	private static IManagerGui					managerGui;

	
	// main()
	
	public static void main(String[] args) {

		// Logger
		Logger logger = Logger.getLogger( MainTelecommande.class.getName() );

		
		try {

			// Configuration de la trace
			configurerLogging();
			
			// DataSource JDBC
			dataSource = new DataSourceSingleConnection( MainTelecommande.class.getResourceAsStream( "/META-INF/jdbc.properties" ) );
			
			// ContextDao
//			contextDao = new contacts.emb.dao.mock.ContextDao();
			contextDao = new telecommande.dao.jdbc.ContextDao( dataSource );
			
			// ContextService
//			contextService = new contacts.emb.service.mock.ContextService();
			contextService = new telecommande.emb.service.standard.ContextService( contextDao );

			// ContextModel
//			contextModel = new contacts.javafx.model.mock.ContextModel();
			contextModel = new telecommande.javafx.model.standard.ContextModel( contextService );
			
			// ManagerGui
			managerGui = new telecommande.javafx.view.ManagerGuiClassic( contextModel );
			
			// Libère les ressources à la fermeture de l'application
	    	Runtime.getRuntime().addShutdownHook(new Thread(
	    		() -> {
	    			try {

		    			// JDBC
	    				if ( dataSource != null ) {
							dataSource.closeConnection();
	    				}

						logger.config( "\n    Fermeture de l'application" );
	    				
	    			} finally {
	    				LogManagerSpecial.resetFinally();
	    			}
	    	    }
	    	));

	    	
	    	// Trace
	    	
	    	StringBuilder sbMessage = new StringBuilder();
	    	if ( contextDao != null ) {
	    		sbMessage.append( "\n    contextDao     : " ).append( contextDao.getClass().getName() );
	    	}
	    	if ( contextService != null ) {
	    		sbMessage.append( "\n    contextService : " ).append( contextService.getClass().getName() );
	    	}
	    	if ( contextModel != null ) {
	    		sbMessage.append( "\n    contextModel   : " ).append( contextModel.getClass().getName() );
	    	}
	    	if ( managerGui != null ) {
	    		sbMessage.append( "\n    managerGui     : " ).append( managerGui.getClass().getName() );
	    	}
			logger.log(Level.CONFIG, sbMessage.toString() );
			
			
			// Démarre l'application
			managerGui.launch( "Gestion de stock" );
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossible de démarrer l'application.", "", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		System.exit(0);
    }


    // Méthodes auxiliaires
	
	private static void configurerLogging() {
    	try {
    		Files.createDirectories( Paths.get("logs") );
        	InputStream in = MainTelecommande.class.getResourceAsStream("/META-INF/logging.properties");
        	LogManager logManager = LogManagerSpecial.getLogManager();
			logManager.readConfiguration( in );
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Types auxiliaires

    public static class LogManagerSpecial extends LogManager {
    	static LogManagerSpecial instance;
    	public LogManagerSpecial() { 
        	instance = this; 
        }
        @Override 
        public void reset() {
        }
        private void resetSuper() { 
        	super.reset(); 
        }
        public static void resetFinally() { 
        	instance.resetSuper(); 
        }
    }
    
    // Initialise la property au chargement de la classe
    static {
        System.setProperty("java.util.logging.manager", LogManagerSpecial.class.getName());
    }
	
    
}