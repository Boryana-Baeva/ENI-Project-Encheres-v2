package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.exceptions.BusinessException;

public interface CategorieDAO {

	public List<Categorie> getAll() throws BusinessException;
	
	public Categorie getById(int id) throws BusinessException;
	
	public Categorie insert(Categorie categorie) throws BusinessException;
	
	public void update(Categorie categorie) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
}
