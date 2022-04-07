package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.codes.ErrorCodesDAL;
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
			BusinessException be = new BusinessException();
			be.ajouterErreur(ErrorCodesDAL.LECTURE_UTILISATEURS_ECHEC);
			throw be;
		}
		
		return utilisateurs;
		
	}

	@Override
	public Utilisateur getById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getByPseudo(String pseudo) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
}
