package fr.eni.encheres.bll;

import fr.eni.encheres.exceptions.BusinessException;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.jdbc.EnchereDAOJDBCImpl;

public class EnchereManager {
	private static EnchereDAO enchereDAO = new EnchereDAOJDBCImpl();
	private static BusinessException businessException = new BusinessException();
	
	public EnchereManager() {
		businessException = new BusinessException();
	}
	
	public static Enchere getById(int userId, int articleId)throws BusinessException{
		return enchereDAO.getById(userId, articleId);	
	}
	
	
	public static Enchere insert (Enchere enchere) throws BusinessException {

		validateDate(enchere.getDate(), businessException);
		
		if(!businessException.hasErreurs())
		{
			enchereDAO.insert(enchere);
		}
		else
		{
			throw businessException;
		}
		return enchere;
		
	}
	
	private static void validateDate(LocalDate date, BusinessException businessException) {
		
		if(date == null || date.isAfter(LocalDate.now()))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ENCHERES_DATE_ERREUR);
		}		
	}
		
	public static List<Enchere> getAllByArticle(int id)
	{		
		try {
			return enchereDAO.getAllByArticle(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
