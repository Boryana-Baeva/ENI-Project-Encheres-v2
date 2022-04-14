package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exceptions.BusinessException;

public class EnchereDAOJDBCImpl implements EnchereDAO {

	private static final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM ENCHERES";
	private static final String GET_BY_ID = "SELECT * FROM ENCHERES WHERE no_utilisateur=? AND no_article=?";
	private static final String GET_BY_ENCHERISSEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur=?";
	private static final String UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?,"  +
											"no_article=?, no_utilisateur=?, remporte=? WHERE no_utilisateur=? AND no_article=?";
	private static final String DELETE = "DELETE ENCHERES WHERE no_utilisateur=? AND no_article=?";
	private static final String GET_ALL_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?";
	
	private static ArticleDAO articleDao = new ArticleDAOJDBCImpl();
	private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOJDBCImpl();
	
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
		if (enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_NULL_OBJECT_FAIL);
			throw businessException;
		}
		
		try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setDate(1, Date.valueOf(enchere.getDate()));
            statement.setInt(2, enchere.getMontant());
            statement.setInt(3, enchere.getArticle().getId());
            statement.setInt(4, enchere.getEncherisseur().getId());
           
            statement.executeUpdate();
 

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_FAIL);
			throw businessException;
		}
		return enchere;
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
		List<Enchere> encheres = new ArrayList<>();
		
		try (Connection connection = ConnectionProvider.getConnection()) {
			 PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ARTICLE);
			 statement.setInt(1, id);
			
			 ResultSet rs = statement.executeQuery();
			 
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setDate(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant(rs.getInt("montant_enchere"));
				enchere.setArticle(articleDao.getById(rs.getInt("no_article")));
				enchere.setEncherisseur(utilisateurDAO.getById(rs.getInt("no_utilisateur")));
				
				encheres.add(enchere);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.GET_ENCHERES_FAIL);
			throw businessException;
		}

		return encheres;
	
	}

}
