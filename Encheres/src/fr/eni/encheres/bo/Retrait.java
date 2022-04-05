package fr.eni.encheres.bo;

import java.io.Serializable;

public class Retrait implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String rue;
	private String codePostal;
	private String ville;
	
	// Constructors
	public Retrait() {}

	public Retrait(int id, String rue, String codePostal, String ville) {
		super();
		this.id = id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
	@Override
	public String toString() {
		return "Retrait [id=" + id + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
}
