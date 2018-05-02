package telecommande.javafx.view;

import javafx.scene.layout.Pane;


public enum EnumView {

	
	// Valeurs
	
	Info			        ( "systeme/ViewInfo.fxml" ),
	Connexion		        ( "systeme/ViewConnexion.fxml" ),
	CompteListe2	        ( "compte/ViewCompteListe2.fxml" ),
	CompteForm2		        ( "compte/ViewCompteForm2.fxml" ),
	MarqueListe2            ( "marque/ViewMarqueListe2.fxml"),
	MarqueForm2             ( "marque/ViewMarqueForm2.fxml"),
	TeleviseurForm2         ( "televiseur/ViewTeleviseurForm2.fxml"),
	TeleviseurListe2        ( "televiseur/ViewTeleviseurListe2.fxml"),
	FournisseurForm2        ( "fournisseur/ViewFournisseurForm2.fxml"),
	FournisseurListe2       ( "fournisseur/ViewFournisseurListe2.fxml"),
	ModeleTelecommandeListe ( "modeleTelecommande/ViewModeleTelecommandeListe.fxml"),
	ModeleTelecommandeForm  ( "modeleTelecommande/ViewModeleTelecommandeForm.fxml")
	;

	
	// Champs
	
	private String		path;
	private Pane		pane;
	private Runnable	runnableEnter;
	private Runnable	runnableEscape;

	
	// Constructeur 
	
	EnumView( String path ) {
		this.path = path;
	}

	
	// Getters & setters

	public String getPathn() {
		return path;
	}
	
	public Pane getPane() {
		return pane;
	}
	
	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	public Runnable getRunnableEnter() {
		return runnableEnter;
	}
	public void setRunnableEnter(Runnable runnableEnter) {
		this.runnableEnter = runnableEnter;
	}
	
	public Runnable getRunnableEscape() {
		return runnableEscape;
	}
	public void setRunnableCancel(Runnable runnableCancel) {
		this.runnableEscape = runnableCancel;
	}
}
