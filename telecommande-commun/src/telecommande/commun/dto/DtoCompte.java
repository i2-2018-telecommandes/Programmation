package telecommande.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoCompte implements Serializable  {

	
	// Champs
	
	private int			id;
	
	private String		login;
	
	private String		nom;
	
	private String		prenom;
	
	private String		MotPass;
	
	private String		email;
	
	private List<String> roles = new ArrayList<>();
	
	
	// Constructeurs
	
	public DtoCompte() {
	}

	public DtoCompte(int id, String pseudo, String motDePasse, String email,String nom,String prenom ) {
		this.id = id;
		this.login = pseudo;
		this.MotPass = motDePasse;
		this.email = email;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	
	// Getters & setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return login;
	}

	public void setPseudo(String pseudo) {
		this.login = pseudo;
	}

	public String getMotDePasse() {
		return MotPass;
	}

	public void setMotDePasse(String motDePasse) {
		this.MotPass = motDePasse;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotPass() {
		return MotPass;
	}

	public void setMotPass(String motPass) {
		MotPass = motPass;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	public boolean isInRole( String role ) {
		
		if ( role != null ) {
			for ( String r : roles ) {
				if ( r.equals(role) ) {
					return true;
				}
			}
		}
		return false;
	}
}
