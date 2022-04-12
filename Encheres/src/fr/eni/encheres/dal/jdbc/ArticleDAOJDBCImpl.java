package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.codes.ErrorCodes;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.exceptions.BusinessException;

public class ArticleDAOJDBCImpl implements ArticleDAO {
	
	private static final String GET_ALL = "select * from ARTICLES_VENDUS";
	private static final String GET_BY_ID = "select * from ARTICLES_VENDUS where no_article= ?";
	private static final String GET_BY_VENDEUR = "select * from ARTICLES_VENDUS where no_utilisateur= ?";
	private static final String INSERT = "insert into ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres,prix_initial,no_utilisateur,no_categorie,no_retrait) VALUES (?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "update ARTICLES_VENDUS set nom_article = ?, description = ?,"
			+ "							 date_debut_encheres=?, date_fin_encheres= ?, prix_initial= ?, prix_vente= ?, "
			+ "							 no_utilisateur= ?, no_categorie=?, no_retrait=? where no_article= ? ";
	private static final String DELETE = "delete ARTICLES_VENDUS where no_article = ?";
	private static final String GET_BY_RETRAIT = "select * from ARTICLES_VENDUS where no_retrait=?";

	
	public Article articleBuilder(ResultSet rs) throws BusinessException, SQLException {

		/*Utilisateur vendeur = this.getVendeurArticle(rs.getInt("no_utilisateur"));
		Categorie categorie = this.getCategorieArticle(rs.getInt("no_categorie"));
		Retrait retrait = this.getRetraitArticle(rs.getInt("no_retrait"));*/

		Article article = new Article();

		article.setId(rs.getInt("no_article"));
		article.setNom(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebutEncheres((rs.getDate("date_debut_encheres").toLocalDate()));
		article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
		article.setMiseAPrix(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		/*article.setVendeur(vendeur);
		article.setCategorie(categorie);
		article.setLieuRetrait(retrait);*/

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
