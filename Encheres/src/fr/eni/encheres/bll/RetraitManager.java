package fr.eni.encheres.bll;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.jdbc.RetraitDAOJDBCImpl;

public class RetraitManager {

	private static RetraitDAO retraitDAO = new RetraitDAOJDBCImpl();
	private static BusinessException businessException = new BusinessException();
	
	public RetraitManager() {
	}
	
	public static Retrait insert(Retrait retrait) throws BusinessException {
			
		validerAdresse(retrait, businessException);
		
		if(!businessException.hasErreurs()) {
			retraitDAO.insert(retrait);
		}
		else
		{
			businessException.printStackTrace();
		}
		return retrait;
		
	}

	public static Retrait selectionnerRetraitById(int id) {
		
		try {
			return retraitDAO.getById(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void validerAdresse(Retrait retrait, BusinessException businessException) {
		
		if(retrait.getRue() == null || retrait.getCodePostal() == null || retrait.getVille() == null 
				|| retrait.getRue().trim().equals("") ||  retrait.getCodePostal().trim().equals("") 
				|| retrait.getVille().trim().equals(""))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_RETRAITS_ADRESSE_ERREUR);
		}
	}
}
