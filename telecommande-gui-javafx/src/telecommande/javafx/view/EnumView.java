package telecommande.javafx.view;

import javafx.scene.layout.Pane;


public enum EnumView {

	
	// Valeurs
	
	Info			( "systeme/ViewInfo.fxml" ),
	Connexion		( "systeme/ViewConnexion.fxml" ),
	CompteListe		( "compte/ViewCompteListe.fxml" ),
	CompteForm		( "compte/ViewCompteForm.fxml" ),
	MarqueListe     ("marque/ViewMarqueListe.fxml"),
	MarqueForm      ("marque/ViewMarqueForm.fxml"),
	TeleviseurForm  ("televiseur/ViewTeleviseurForm.fxml"),
	TeleviseurListe ("televiseur/ViewTeleviseurListe.fxml"),
	FournisseurForm  ("fournisseur/ViewFournisseurForm.fxml"),
	FournisseurListe ("televiseur/ViewFournisseurListe.fxml")
	
	
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
