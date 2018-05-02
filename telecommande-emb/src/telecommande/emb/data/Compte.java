<<<<<<< HEAD
package telecommande.emb.data;

import java.util.ArrayList;
import java.util.List;


public class Compte  {

	
	// Champs
	
	private int			id;
	
	private String		login;
	
	private String		nom;
	
	private String		prenom;
	
	private String		MotPass;
	
	private String		email;
	
	private List<String> roles = new ArrayList<>();	
	
	
	// Constructeurs
	
	public Compte() {
	}

	public Compte(int id, String pseudo, String motDePasse, String email,String nom,String prenom) {
		this.id = id;
		this.login = pseudo;
		this.MotPass = motDePasse;
		this.email = email;
		this.nom=nom;
		this.prenom=prenom;
	}
	
		
	// Getters & setters
	
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

    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
=======
package telecommande.emb.data;

import java.util.ArrayList;
import java.util.List;


public class Compte  {

	
	// Champs
	
	private int			id;
	
	private String		login;
	
	private String		nom;
	
	private String		prenom;
	
	private String		MotPass;
	
	private String		email;
	
	private List<String> roles = new ArrayList<>();	
	
	
	// Constructeurs
	
	public Compte() {
	}

	public Compte(int id, String pseudo, String motDePasse, String email,String nom,String prenom) {
		this.id = id;
		this.login = pseudo;
		this.MotPass = motDePasse;
		this.email = email;
		this.nom=nom;
		this.prenom=prenom;
	}
	
		
	// Getters & setters
	
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

    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
