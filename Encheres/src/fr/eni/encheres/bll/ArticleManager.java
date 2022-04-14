package fr.eni.encheres.bll;

import fr.eni.encheres.exceptions.BusinessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.EtatVente;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.jdbc.ArticleDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.RetraitDAOJDBCImpl;

public class ArticleManager {

	private static ArticleDAO articleDAO = new ArticleDAOJDBCImpl();
	private static RetraitDAO retraitDAO = new RetraitDAOJDBCImpl();
	private static Article article = new Article();
			
	private static BusinessException businessException = new BusinessException();
	
	public ArticleManager() {
		
	}
	
	public static List<Article> getAll() { 	
		List<Article> articles = new ArrayList<>();
		
		try {
			articles =  articleDAO.getAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return articles;
	}
	
	public static Article getById(int id)throws BusinessException{
		return articleDAO.getById(id);	
	}
	
	public static Article insert(Article article)
			throws BusinessException {

		validateDate(article);

		if (!businessException.hasErreurs()) {
			articleDAO.insert(article);
		} else {
			businessException.printStackTrace();	
		}
		
		return article;
	}
	
	public static void update(Article article) throws BusinessException{
		
		validateDate(article);
		
		if(!businessException.hasErreurs())
		{
			articleDAO.update(article);
		} else {
			businessException.printStackTrace();	
		}
	
	}

	private static void validateDate(Article article) {
		
		if (article.getDateDebutEncheres() == null || article.getDateFinEncheres() == null || LocalDate.now().isBefore(article.getDateDebutEncheres()) ||
				article.getDateFinEncheres().isBefore(article.getDateDebutEncheres())) 
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ENCHERES_DATE_ERREUR);
		}
		
	}
	
	public static Retrait getByArticleId(int id)throws BusinessException{
		return retraitDAO.getById(id);	
	}

}
