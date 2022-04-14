package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.exceptions.BusinessException;

public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private Categorie categorie;
	private Utilisateur vendeur;
	private Retrait lieuRetrait;
	private EtatVente etatVente;
	
	// Constructors
	public Article() {
		
	}

	public Article(String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, Utilisateur vendeur, Categorie categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		this.vendeur = vendeur;
		this.etatVente = EtatVente.CREE;
		this.lieuRetrait = vendeur.getLieuRetraitParDefaut();
		
	}

	public Article(String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, Categorie categorie, Utilisateur vendeur, EtatVente etatVente ,
			Retrait lieuRetrait) {
		this(nom,description,dateDebutEncheres,dateFinEncheres,miseAPrix,vendeur,categorie);
		this.etatVente=etatVente;
		this.lieuRetrait=lieuRetrait;
		
	}
	
	
	public Article(String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, Categorie categorie, Utilisateur vendeur) {
		this(nom,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,categorie,vendeur,EtatVente.CREE, vendeur.getLieuRetraitParDefaut());		
	}
	
	
	public Article(int id, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, Categorie categorie, Utilisateur vendeur, EtatVente etatVente,
			Retrait lieuRetrait) {
		this(nom, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, categorie, vendeur, etatVente,
				lieuRetrait);
		this.id = id;
	}
	
    // Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the dateDebutEncheres
	 */
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	/**
	 * @return the dateFinEncheres
	 */
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}
	/**
	 * @return the lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	/**
	 * @return the etatVente
	 */
	public EtatVente getEtatVente() {
		return etatVente;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	/**
	 * @param lieuRetrait the lieuRetrait to set
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	/**
	 * @param etatVente the etatVente to set
	 */
	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}
	
	public Retrait getArticleRetrait() {

		Retrait retrait = null; 
		retrait = RetraitManager.selectionnerRetraitById(this.id);
		
		if(retrait == null) {
			retrait = vendeur.getLieuRetraitParDefaut();
		}
		
		return retrait;
	}
	
	@Override
	public String toString() {
		return "ArticleVendu [id=" + id + ", nom=" + nom + ", description=" + description + ", dateDebutEncheres="
				+ dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix=" + miseAPrix
				+ ", prixVente=" + prixVente + ", categorie=" + categorie + ", vendeur=" + vendeur + ", lieuRetrait=" + lieuRetrait + "]";
	}

}
