package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.exceptions.BusinessException;

public interface RetraitDAO {
	
	public List<Retrait> getAll() throws BusinessException;
	
	public Retrait getById (int id) throws BusinessException;
	
	public Retrait insert (Retrait retrait) throws BusinessException;
	
	public void update(Retrait retrait) throws BusinessException;
	
	public void delete(int id) throws BusinessException;

}
