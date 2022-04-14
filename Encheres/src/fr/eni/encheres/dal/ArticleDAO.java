package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.exceptions.BusinessException;

public interface ArticleDAO {

	public List<Article> getAll() throws BusinessException;
	
	public Article getById(int id) throws BusinessException;
	
	public Article insert(Article article) throws BusinessException;
	
	public void update(Article article) throws BusinessException;
	
	public void delete(int id) throws BusinessException;

	List<Article> getByVendeur(int id) throws BusinessException;
	
	
	
}
