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
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJDBCmpl implements UtilisateurDAO {
		
	private static final String GET_ALL = "SELECT * FROM UTILISATEURS";
	private static final String GET_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String GET_BY_PSEUDO ="SELECT * FROM UTILISATEURS WHERE pseudo=? ";
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE UTILISATEURS SET nom=?, prenom=?,"
			+ "email=?, telephone=?, rue=?, code_postal=?, ville=?," + " mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private static final String DELETE = "DELETE UTILISATEURS WHERE no_utilisateur=?";
	private static final String GET_ALL_UTILISATEUR_ARTICLES = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String GET_ALL_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> getAllUtilisateurArticles(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub
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
