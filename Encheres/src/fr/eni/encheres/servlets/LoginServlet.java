package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
       	
		PrintWriter out= response.getWriter();
		
		HttpSession session = request.getSession();
		
		String erreur = null;
		
		String identifiant = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if(identifiant.length()==0 || identifiant.isEmpty()){
				
			//création de l'erreur
			request.setAttribute("erreur", "pseudo non renseigné. Veuillez le saisir...");
			erreur = (String) session.getAttribute("erreur");
			out.println(erreur);
			
			//redirection vers la page de connexion pour saisir le login
			this.getServletContext().getRequestDispatcher("/login").forward(request, response);
			
			
		}else if(password.length()==0 || password.isEmpty()) {
				
			//cr�ation de l'erreur
			request.setAttribute("erreur", "mot de passe non renseign�. Veuillez le saisir...");
			erreur = (String) session.getAttribute("erreur");
			out.println(erreur);
			//redirection vers la page de connexion pour saisir le login
			this.getServletContext().getRequestDispatcher("/login").forward(request, response);
			
		}else {
			try {
				//Valider pseudo utilisateur, verification si il est bien dans la bdd
				Utilisateur user = UtilisateurManager.selectUserByPseudo(identifiant);
				//out.println(identifiant);
				//Si la connexion est reussie
				if(user!= null && password.equals(user.getPassword())) {
					request.getSession().setAttribute("ConnectedUser", user);
					
					this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
					
				} else {
					request.getSession().setAttribute("erreur", "Pseudo et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants...");
					erreur = (String) session.getAttribute("erreur");
					out.println(erreur);
					
					this.getServletContext().getRequestDispatcher("/login").forward(request, response);
				}
			} catch (BusinessException e) {
				request.getSession().setAttribute("erreur", e);
				this.getServletContext().getRequestDispatcher("/").forward(request, response);
			}
		
		}
	}

}
