package telecommande.javafx.view;

import javafx.scene.layout.Pane;


public enum EnumView {

	
	// Valeurs
	
	Info			( "systeme/ViewInfo.fxml" ),
	Connexion		( "systeme/ViewConnexion.fxml" ),
	CompteListe		( "compte/ViewCompteListe.fxml" ),
	CompteListe2		( "compte/ViewCompteListe2.fxml" ),
	CompteForm		( "compte/ViewCompteForm.fxml" ),
	CompteForm2		( "compte/ViewCompteForm2.fxml" ),
	MarqueListe     ("marque/ViewMarqueListe.fxml"),
	MarqueListe2     ("marque/ViewMarqueListe2.fxml"),
	MarqueForm      ("marque/ViewMarqueForm.fxml"),
	MarqueForm2      ("marque/ViewMarqueForm2.fxml"),
	TeleviseurForm  ("televiseur/ViewTeleviseurForm.fxml"),
	TeleviseurForm2  ("televiseur/ViewTeleviseurForm2.fxml"),
	TeleviseurListe ("televiseur/ViewTeleviseurListe.fxml"),
	TeleviseurListe2 ("televiseur/ViewTeleviseurListe2.fxml"),
	FournisseurForm  ("fournisseur/ViewFournisseurForm.fxml"),
	FournisseurForm2  ("fournisseur/ViewFournisseurForm2.fxml"),
	FournisseurListe ("fournisseur/ViewFournisseurListe.fxml"),
	FournisseurListe2 ("fournisseur/ViewFournisseurListe2.fxml")
	
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
