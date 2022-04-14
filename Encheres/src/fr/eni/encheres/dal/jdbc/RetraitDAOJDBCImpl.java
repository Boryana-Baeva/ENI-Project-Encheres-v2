package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.exceptions.BusinessException;

public class RetraitDAOJDBCImpl implements RetraitDAO {
	
	private static final String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) values (?,?,?,?)";
	private static final String GET_BY_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";
	private static final String GET_ALL = "SELECT * FROM RETRAITS";
	private static final String UPDATE = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article=?";
	private static final String DELETE = "DELETE RETRAITS WHERE no_article = ?";
	

	private static ArticleDAO articleDao = new ArticleDAOJDBCImpl();
	
	@Override
	public  Retrait insert(Retrait retrait) throws BusinessException 
	{
		if (retrait == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_NULL_OBJECT_FAIL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(INSERT);
			statement.setInt(1, retrait.getId());
			statement.setString(2, retrait.getRue());
			statement.setString(3, retrait.getCodePostal());
			statement.setString(4, retrait.getVille());
						
			statement.executeUpdate();
					

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_FAIL);
			throw businessException;
		}
		return retrait;
		
	}

	@Override
	public Retrait getById(int id) throws BusinessException 
	{
		Retrait retrait = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement statement = cnx.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				retrait = new Retrait();
				retrait.setId(rs.getInt("no_article"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCodePostal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.GET_RETRAIT_FAIL);
			throw businessException;

		}
		return retrait;
	}

	@Override
	public List<Retrait> getAll() throws BusinessException
	{
		List<Retrait> retraits = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(GET_ALL);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Retrait retrait = new Retrait();
				retrait.setId(rs.getInt("no_retrait"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCodePostal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));
				retraits.add(retrait);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.GET_RETRAITS_FAIL);
			throw businessException;

		}
		return retraits;
	}


	@Override
	public void update(Retrait retrait) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
