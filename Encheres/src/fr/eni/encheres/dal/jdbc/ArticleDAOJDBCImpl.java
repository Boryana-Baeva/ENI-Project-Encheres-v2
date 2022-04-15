package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.codes.ErrorCodes;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exceptions.BusinessException;

public class ArticleDAOJDBCImpl implements ArticleDAO {
	
	private static final String GET_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String GET_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article= ?";
	private static final String GET_BY_VENDEUR = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur= ?";
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?,"
			+ "							 date_debut_encheres=?, date_fin_encheres= ?, prix_initial= ?, prix_vente= ?, "
			+ "							 no_utilisateur= ?, no_categorie=? WHERE no_article= ? ";
	private static final String DELETE = "DELETE ARTICLES_VENDUS WHERE no_article = ?";


	
	public Article articleBuilder(ResultSet rs) throws BusinessException, SQLException {

		Utilisateur vendeur = this.getVendeurArticle(rs.getInt("no_utilisateur"));
		Categorie categorie = this.getCategorieArticle(rs.getInt("no_categorie"));

		Article article = new Article();

		article.setId(rs.getInt("no_article"));
		article.setNom(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebutEncheres((rs.getDate("date_debut_encheres").toLocalDate()));
		article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
		article.setMiseAPrix(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		article.setVendeur(vendeur);
		article.setCategorie(categorie);

		return article;

	}
	
	@Override
	public List<Article> getAll() throws BusinessException {
		
		List<Article> articles = new ArrayList<>();
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_ALL);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				articles.add(articleBuilder(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_ARTICLE_FAIL);
			throw businessException;
		}
		
		return articles;
	}

	@Override
	public Article getById(int id) throws BusinessException {
		
		Article article = new Article();
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				article = articleBuilder(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_ARTICLE_FAIL);
			throw businessException;
		}
		
		return article;
	}

	@Override
	public Article insert(Article article) throws BusinessException {
		
		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_FAIL);
			throw businessException;
		}

		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, article.getNom());
			statement.setString(2, article.getDescription());
			statement.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			statement.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			statement.setInt(5, article.getMiseAPrix());
			statement.setInt(6, article.getVendeur().getId());
			statement.setInt(7, article.getCategorie().getId());

			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();

			if (rs.next()) {
				article.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_FAIL);
			throw businessException;
		}
		return article;
	}

	@Override
	public void update(Article article) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(UPDATE);

			statement.setString(1, article.getNom());
			statement.setString(2, article.getDescription());
			statement.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			statement.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			statement.setInt(5, article.getMiseAPrix());
			statement.setInt(6, article.getPrixVente());
			statement.setInt(7, article.getVendeur().getId());
			statement.setInt(8, article.getCategorie().getId());
			statement.setInt(9, article.getId());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJECT_FAIL);
			throw businessException;

		}
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	private Utilisateur getVendeurArticle(int vendeurId) {
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Utilisateur vendeurArticle = null;
		try {
			vendeurArticle = utilisateurDAO.getById(vendeurId);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return vendeurArticle;
	}

	private Categorie getCategorieArticle(int categorieId) {
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		Categorie categorieArticle = null;
		try {
			categorieArticle = categorieDAO.getById(categorieId);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return categorieArticle;
	}
	
	@Override
	public List<Article> getByVendeur(int id) throws BusinessException {

		List<Article> articles = new ArrayList<>();

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_BY_VENDEUR);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			Article articleVendu = null;

			while (rs.next()) {
				articleVendu = articleBuilder(rs);
				articles.add(articleVendu);

			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.GET_ARTICLES_FAIL);
			throw businessException;

		}
		return articles;
	}
}
