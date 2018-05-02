<<<<<<< HEAD
package telecommande.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoTelephone implements Serializable {

	
	// Champs

	private int				id;

	private String			libelle;

	private String			numero;
	
	
	// Constructeurs
	
	public DtoTelephone() {
	}
	
	public DtoTelephone(int id, String libelle, String numero) {
		this.id = id;
		this.libelle = libelle;
		this.numero = numero;
	}


	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
=======
package telecommande.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoTelephone implements Serializable {

	
	// Champs

	private int				id;

	private String			libelle;

	private String			numero;
	
	
	// Constructeurs
	
	public DtoTelephone() {
	}
	
	public DtoTelephone(int id, String libelle, String numero) {
		this.id = id;
		this.libelle = libelle;
		this.numero = numero;
	}


	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
