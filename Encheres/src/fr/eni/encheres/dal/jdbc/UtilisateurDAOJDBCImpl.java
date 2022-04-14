package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.codes.ErrorCodes;
import fr.eni.encheres.dal.ConnectionProvider;
//import fr.eni.encheres.dal.ArticleDAO;
//import fr.eni.encheres.dal.CategorieDAO;
//import fr.eni.encheres.dal.EnchereDAO;
//import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJDBCImpl implements UtilisateurDAO {
		
	private static final String GET_ALL = "SELECT * FROM UTILISATEURS";
	private static final String GET_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String GET_BY_PSEUDO ="SELECT * FROM UTILISATEURS WHERE pseudo=? ";
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE UTILISATEURS SET nom=?, prenom=?,"
			+ "email=?, telephone=?, rue=?, code_postal=?, ville=?," + " mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String DELETE = "DELETE UTILISATEURS WHERE no_utilisateur=?";
	private static final String GET_ALL_UTILISATEUR_ARTICLES = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String GET_ALL_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";

	
	//private static EnchereDAO enchereDao = new EnchereDAOJDBCImpl();
	//private static ArticleDAO articleDao = new ArticleVenduDAOJDBCImpl();
	//private static CategorieDAO categorieDao = new CategorieDAOJDBCImpl();
	//private static RetraitDAO retraitDao = new RetraitDAOJDBCImpl();
	
	/**
	 * Creates a new user from a ResultSet
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Utilisateur utilisateurBuilder(ResultSet rs) throws SQLException
	{
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setId(rs.getInt("no_utilisateur"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setEmail(rs.getString("email"));
		utilisateur.setTelephone(rs.getString("telephone"));
		utilisateur.setRue(rs.getString("rue"));
		utilisateur.setCodePostal(rs.getString("code_postal"));
		utilisateur.setVille(rs.getString("ville"));
		utilisateur.setPassword(rs.getString("mot_de_passe"));
		utilisateur.setCredit(rs.getInt("credit"));
		utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
	
		return utilisateur;

	}
	
	
	@Override
	public List<Utilisateur> getAll() throws BusinessException {
		
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_ALL);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				utilisateurs.add(utilisateurBuilder(rs));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_UTILISATEUR_FAIL);
			throw businessException;
		}
		
		return utilisateurs;	
	}

	@Override
	public Utilisateur getById(int id) throws BusinessException {
		
		Utilisateur utilisateur = null;

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				utilisateur = utilisateurBuilder(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_UTILISATEUR_FAIL);
			throw businessException;
		}

		return utilisateur;
	}

	@Override
	public Utilisateur getByPseudo(String pseudo) throws BusinessException {
		
		Utilisateur utilisateur = null;

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_BY_PSEUDO);
			statement.setString(1, pseudo);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				utilisateur = utilisateurBuilder(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_UTILISATEUR_FAIL);
			throw businessException;
		}

		return utilisateur;
	}

	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws BusinessException {
		
		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.INSERT_NULL_OBJECT_FAIL);
			throw businessException;
		}

		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, utilisateur.getPseudo());
			statement.setString(2, utilisateur.getNom());
			statement.setString(3, utilisateur.getPrenom());
			statement.setString(4, utilisateur.getEmail());
			if (utilisateur.getTelephone() != null) {
				statement.setString(5, utilisateur.getTelephone());
			} else {
				statement.setNull(5, Types.VARCHAR);
			}
			statement.setString(6, utilisateur.getRue());
			statement.setString(7, utilisateur.getCodePostal());
			statement.setString(8, utilisateur.getVille());
			statement.setString(9, utilisateur.getPassword());
			statement.setInt(10, utilisateur.getCredit());
			statement.setBoolean(11, utilisateur.isAdministrateur());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();

			if (rs.next()) {
				utilisateur.setId(rs.getInt(1));
			}

			statement.close();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.INSERT_OBJECT_FAIL);
			throw businessException;
		}
		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur) throws BusinessException {
		
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(UPDATE);
			statement.setString(1, utilisateur.getNom());
			statement.setString(2, utilisateur.getPrenom());
			statement.setString(3, utilisateur.getEmail());
			if (utilisateur.getTelephone() != null) {
				statement.setString(4, utilisateur.getTelephone());
			} else {
				statement.setNull(4, Types.VARCHAR);
			}
			statement.setString(5, utilisateur.getRue());
			statement.setString(6, utilisateur.getCodePostal());
			statement.setString(7, utilisateur.getVille());
			statement.setString(8, utilisateur.getPassword());
			statement.setInt(9, utilisateur.getCredit());
			statement.setBoolean(10, utilisateur.isAdministrateur());
			statement.setInt(11, utilisateur.getId());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.UPDATE_OBJECT_FAIL);
			throw businessException;

		}
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		
		try (Connection connection = ConnectionProvider.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(DELETE);
			statement.setInt(1, id);
			
			/*List<Article> listeArticles=articleDao.getByVendeur(id);
			
			for (Article article : listeArticles) {
				articleDao.delete(article.getId());
			}*/
			
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.DELETE_OBJECT_FAIL);
			throw businessException;
		}
		
	}

	@Override
	public List<Article> getAllUtilisateurArticles(Utilisateur utilisateur) throws BusinessException {
		
		/*List<ArticleVendu> listeArticlesVendus = new ArrayList<ArticleVendu>();

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_ARTICLES_VENDUS);
			statement.setInt(1, utilisateur.getId());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setId(rs.getInt("no_article"));
				articleVendu.setNom(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres((rs.getDate("date_debut_encheres").toLocalDate()));
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				articleVendu.setVendeur(utilisateur);
				articleVendu.setCategorie(categorieDao.getById(rs.getInt("no_categorie")));
				articleVendu.setLieuRetrait(retraitDao.getById(rs.getInt("no_retrait")));
				listeArticlesVendus.add(articleVendu);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLES_ECHEC);
			throw businessException;
		}
		return listeArticlesVendus;*/
		return null;
	}

	@Override
	public List<String> getAllPseudos() throws BusinessException {
		
		List<String> pseudos = new ArrayList<>();
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(GET_ALL_PSEUDOS);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				pseudos.add(rs.getString("pseudo"));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(ErrorCodes.GET_ALL_PSEUDOS_FAIL);
			throw businessException;
		}
		return pseudos;
	}
}
