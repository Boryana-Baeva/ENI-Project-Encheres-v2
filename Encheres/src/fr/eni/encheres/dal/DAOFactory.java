package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.CategorieDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.EnchereDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.RetraitDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJDBCImpl;

public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJDBCImpl();		
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJDBCImpl();		
	}

	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJDBCImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJDBCImpl();
	}
	
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOJDBCImpl();
	}
	
}
