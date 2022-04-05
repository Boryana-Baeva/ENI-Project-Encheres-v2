package fr.eni.encheres.bo;

import java.io.Serializable;

public class Categorie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String libelle;
	
	// Constructors
	public Categorie() {}
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	
	// Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}

}
