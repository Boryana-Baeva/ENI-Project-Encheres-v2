package fr.eni.encheres.codes;

public class ErrorCodes {

	// DAL
	public static final int INSERT_NULL_OBJECT_FAIL = 10000;
	public static final int INSERT_OBJECT_FAIL = 10001;
	public static final int GET_ARTICLE_FAIL = 10002;
	public static final int GET_UTILISATEUR_FAIL = 10003;
	public static final int GET_CATEGORIE_FAIL = 10004;
	public static final int GET_ENCHERE_FAIL = 10005;
	public static final int GET_RETRAIT_FAIL = 10007;
	public static final int UPDATE_OBJECT_FAIL = 10008;
	public static final int DELETE_OBJECT_FAIL = 10009;
	public static final int GET_ALL_PSEUDOS_FAIL = 10010;
	
	
	// BLL
	/**
	 * Echec quand le libelle ne respecte pas les règles définies
	 */
	public static final int REGLE_CATEGORIES_LIBELLE_ERREUR=20000;
	
	/**
	 * Echec quand la la date de l'enchere ne respecte pas les règles définies
	 */
	public static final int REGLE_ENCHERES_DATE_ERREUR=20001;
	
	/**
	 * Echec quand l'adresse  ne respecte pas les règles définies
	 */
	public static final int REGLE_RETRAITS_ADRESSE_ERREUR=20002;
	
	/**
	 * Echec quand les coordonnées de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_UTILISATEURS_COORDONNEES_ERREUR=20003;
	
	/**
	 * Echec quand la liste des articles vendus ne respecte pas les règles définies
	 */
	public static final int REGLE_UTILISATEURS_ARTICLE_VENDU_ERREUR=20004;
	
	/**
	 * Echec quand la liste des articles achetés ne respecte pas les règles définies
	 */
	public static final int REGLE_UTILISATEURS_ARTICLE_ACHETE_ERREUR=20005;
	
	/**
	 * Echec quand la liste des encheres ne respecte pas les règles définies
	 */
	public static final int REGLE_UTILISATEURS_ENCHERES_ERREUR=20006;
	/**
	 * Echec quand la date de début et de fin des enchères  ne respectent pas les règles définies
	 */
	public static final int REGLE_ARTICLES_DATE_ERREUR=20007;
	/**
	 * Echec lors d'une tentative de supprimer un article déjà acheté
	 */
	public static final int REGLE_ARTICLES_ETAT_VENTE_ERREUR=20008;
	
}
