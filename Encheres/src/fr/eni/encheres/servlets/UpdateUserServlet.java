package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exceptions.BusinessException;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = { "/modifier-profil" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur user = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			user = UtilisateurManager.selectUserById(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
	
		Utilisateur user = null;
		int id= Integer.parseInt(request.getParameter("id"));
		
		try {
			user = UtilisateurManager.selectUserById(id);
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("code_postal");
			String ville = request.getParameter("ville");
			int credit = Integer.parseInt(request.getParameter("credit"));
			
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setCredit(credit);
								
			UtilisateurManager.update(user);
			
			request.setAttribute("id", id);
			
			if(id == connectedUser.getId()) {
				response.sendRedirect(this.getServletContext().getContextPath() + "/profil");
			} else {
				response.sendRedirect(this.getServletContext().getContextPath() + "/profil?id=" + id);
			}
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
	}

}
