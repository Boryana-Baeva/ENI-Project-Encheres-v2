package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Erreur à la suppression d'un article
	 */
	public static final int SUPPRESSION_ARTICLE_ERREUR = 10005;
	/**
	 * Erreur à la suppression d'une liste
	 */
	public static final int SUPPRESSION_LISTE_ERREUR = 10006;
	/**
	 * Erreur au cochage d'un article
	 */
	public static final int COCHE_ARTICLE_ERREUR = 10007;
	/**
	 * Erreur au décochage d'un article
	 */
	public static final int DECOCHE_ARTICLE_ERREUR = 10008;
	/**
	 * Erreur au décochage de tous les articles d'une liste
	 */
	public static final int DECOCHE_ARTICLES_ERREUR = 10009;
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_NULL_OBJECT_FAIL = 10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJECT_FAIL = 10001;
	
	/**
	 * Echec de la lecture d'un article
	 */
	public static final int GET_ARTICLE_FAIL = 10002;
	
	/**
	 * Echec de la lecture d'une liste d'articles
	 */
	public static final int GET_ARTICLES_FAIL = 10003;
	
	/**
	 * Echec de la lecture d'un utilisateur
	 */
	public static final int GET_UTILISATEUR_FAIL = 10004;
	
	/**
	 * Echec de la lecture d'une liste d'utilisateurs
	 */
	public static final int GET_UTILISATEURS_FAIL = 10005;
	
	/**
	 * Echec de la lecture d'une catégorie
	 */
	public static final int GET_CATEGORIE_FAIL = 10006;
	
	/**
	 * Echec de la lecture d'une liste de catégories
	 */
	public static final int GET_CATEGORIES_FAIL = 10007;
	
	/**
	 * Echec de la lecture d'une enchère
	 */
	public static final int GET_ENCHERE_FAIL = 10008;
	
	/**
	 * Echec de la lecture d'une liste d'echères
	 */
	public static final int GET_ENCHERES_FAIL = 10009;
	
	/**
	 * Echec de la lecture d'un lieu de retrait
	 */
	public static final int GET_RETRAIT_FAIL = 10010;
	
	/**
	 * Echec de la lecture d'une liste de lieux de retrait
	 */
	public static final int GET_RETRAITS_FAIL = 10011;
	
	/**
	 * Erreur à la modification d'un objet
	 */
	public static final int UPDATE_OBJECT_FAIL = 10012;
	
	/**
	 * Erreur à la suppression d'un objet
	 */
	public static final int DELETE_OBJECT_FAIL = 10013;
	
	/**
	 * Echec de la lecture d'une liste de pseudos
	 */
	public static final int GET_ALL_PSEUDOS_FAIL = 10014;
}












