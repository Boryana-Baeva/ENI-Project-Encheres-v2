package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	 
	public List<Utilisateur> getAll() throws BusinessException;
	
	public Utilisateur getById(int id) throws BusinessException;
	
	public Utilisateur getByPseudo(String pseudo) throws BusinessException;
	
	public Utilisateur insert(Utilisateur utilisateur) throws BusinessException;
	
	public void update(Utilisateur utilisateur) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Article> getAllUtilisateurArticles(Utilisateur utilisateur) throws BusinessException;
	
	public List<String> getAllPseudos() throws BusinessException;
	
	

}
