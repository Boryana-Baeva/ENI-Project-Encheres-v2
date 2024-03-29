package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.exceptions.BusinessException;

public interface EnchereDAO {
	
	public List<Enchere> getAll() throws BusinessException;
	
	public Enchere getById(int userId, int articleId) throws BusinessException;
	
	public Enchere insert(Enchere enchere) throws BusinessException;
	
	public void update(Enchere enchere) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Enchere> getByEncherisseur(int id) throws BusinessException;
	
	public List<Enchere> getRemportesParEncherisseur(int id) throws BusinessException;
	
	public List<Enchere> getAllByArticle(int id) throws BusinessException;

}
