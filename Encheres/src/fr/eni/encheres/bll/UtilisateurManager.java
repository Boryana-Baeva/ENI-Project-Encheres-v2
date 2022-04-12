package fr.eni.encheres.bll;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJDBCImpl;

public class UtilisateurManager {
	
	private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOJDBCImpl();
	private static Utilisateur utilisateur = new Utilisateur();
	private static BusinessException businessException = new BusinessException();
	
	public UtilisateurManager() {
		UtilisateurManager.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public static Utilisateur selectUserById(int id) throws BusinessException {
		return utilisateurDAO.getById(id);
	}

	public static List<Utilisateur> selectAllUsers() throws BusinessException {
		return utilisateurDAO.getAll();
	}

	public static Utilisateur selectUserByPseudo(String pseudo) throws BusinessException{
		return utilisateurDAO.getByPseudo(pseudo);
	}
	
	public static List<Article> selectArticles ()throws BusinessException{
		return utilisateurDAO.getAllUtilisateurArticles(utilisateur);
	}
	
	public static List<String> selectAllPseudos() throws BusinessException{
		return utilisateurDAO.getAllPseudos();
	}
	
	public static Utilisateur login(String pseudo, String password) throws BusinessException{
		//Valider pseudo utilisateur, verification si il est bien dans la bdd
		Utilisateur user = null;
		
		user = selectUserByPseudo(pseudo);
		
		
		//Si la connexion est reussie
		if(user!= null && password.equals(user.getPassword())) {
			return user;
		
		} else {
			throw new BusinessException();
		}
			
		
	}
	
	public static Utilisateur register(Utilisateur utilisateur) throws BusinessException {

		validateUserInfo(utilisateur);

		if (!businessException.hasErreurs()) {
			utilisateurDAO.insert(utilisateur);

		} else {

			throw businessException;
		}
		return utilisateur;
	}
	
	private static void validateUserInfo(Utilisateur utilisateur) {

		if (utilisateur.getPseudo().trim().equals("") || utilisateur.getNom().trim().equals("")
				|| utilisateur.getPrenom().trim().equals("") || utilisateur.getEmail().trim().equals("")
				|| utilisateur.getRue().trim().equals("") || utilisateur.getCodePostal().trim().equals("")
				|| utilisateur.getVille().trim().equals("") || utilisateur.getPassword().trim().equals("")) {

			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEURS_COORDONNEES_ERREUR);
		}
	}
	
	public static String encrypt(String password)  {
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
	}
	
	public static Boolean passwordVerify(String passwordPlain, String passwordEncrypted)  {
			
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			md.update(passwordPlain.getBytes());
			byte byteData[] = md.digest();
			
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        return sb.toString().equals(passwordEncrypted);
		}

	public static void delete(int id) throws BusinessException{
		utilisateurDAO.delete(id);
	}
}
