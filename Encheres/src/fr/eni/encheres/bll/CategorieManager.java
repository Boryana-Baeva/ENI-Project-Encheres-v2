package fr.eni.encheres.bll;

import fr.eni.encheres.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.jdbc.CategorieDAOJDBCImpl;

public class CategorieManager {
	
	private static CategorieDAO categorieDAO = new CategorieDAOJDBCImpl();
	private static BusinessException businessException = new BusinessException();
	
	public CategorieManager() {

	}
	
	public static List<Categorie> getAll()
	{
		List<Categorie> categories = new ArrayList<>();
		
		try {
			categories =  categorieDAO.getAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
	
	public static Categorie getById(int id ) throws BusinessException
	{
		return categorieDAO.getById(id);
	}
	
	public static Categorie insert(Categorie categorie) throws BusinessException{
		
		validateLibelle(categorie.getLibelle(), businessException);
		
		if(!businessException.hasErreurs()) {
			categorieDAO.insert(categorie);
		}
		else
		{
			throw businessException;
		}
		return categorie;
		
	}
	
	private static void validateLibelle(String libelle, BusinessException businessException) {
		
		if (libelle == null || libelle.trim().equals(""))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_CATEGORIES_LIBELLE_ERREUR);
		}
	}

}
