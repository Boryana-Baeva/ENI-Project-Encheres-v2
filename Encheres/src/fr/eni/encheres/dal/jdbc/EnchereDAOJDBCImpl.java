package fr.eni.encheres.dal.jdbc;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.exceptions.BusinessException;

public class EnchereDAOJDBCImpl implements EnchereDAO {

	@Override
	public List<Enchere> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere getById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere insert(Enchere enchere) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Enchere enchere) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getByEncherisseur(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getRemportesParEncherisseur(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllByArticle(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
