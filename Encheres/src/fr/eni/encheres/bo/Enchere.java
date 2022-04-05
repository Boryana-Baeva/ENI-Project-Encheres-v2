package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Enchere implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate date;
	private int montant;
	private Article article;
	private Utilisateur encherisseur;
	private boolean remporte = false;
	
	// Constructors
	public Enchere() {
		
	}

	public Enchere(LocalDate date, int montant, Article article, Utilisateur encherisseur) {
		this.date = date;
		this.montant = montant;
		this.article = article;
		this.encherisseur = encherisseur;
		this.setRemporte(false);
	}

	public Enchere(int id, LocalDate date, int montant, Article article, Utilisateur encherisseur) {
		this(date, montant, article, encherisseur);
		this.id = id;
		this.setRemporte(false);
	}
		
	// Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @return the montant
	 */
	public int getMontant() {
		return montant;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @return the encherisseur
	 */
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	/**
	 * @return the remporte
	 */
	public boolean isRemporte() {
		return remporte;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(int montant) {
		this.montant = montant;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @param encherisseur the encherisseur to set
	 */
	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	/**
	 * @param remporte the remporte to set
	 */
	public void setRemporte(boolean remporte) {
		this.remporte = remporte;
	}
	
	
	@Override
	public String toString() {
		return "Enchere [id=" + id + ", date=" + date + ", montant=" + montant + ", article=" + article
				+ ", encherisseur=" + encherisseur + "]";
	}
}
