package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		
		/*PrintWriter out = response.getWriter();
		out.print("Nom: " + request.getParameter("nom"));*/
	       
		Utilisateur user = null;
		
		try {
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String pseudo = request.getParameter("pseudo");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirmation = request.getParameter("password_confirmation");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("adresse");
			String ville = request.getParameter("ville");
			String codePostal = request.getParameter("code_postal");
			
			List<String> allPseudos = UtilisateurManager.selectAllPseudos();
			
			if(nom.length()==0 || nom.isEmpty() ) {
				request.setAttribute("erreur", "Le nom n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}	
			else if (prenom.length()==0 || prenom.isEmpty() ) {
				request.setAttribute("erreur", "Le pr�nom n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (pseudo.length()==0 || pseudo.isEmpty() ) {
				
				request.setAttribute("erreur", "Le pseudo n'a pas été renseigné, veuillez le saisir ...");			
				dispatcher.forward(request, response);
			}
			else if (allPseudos.contains(pseudo)) {
				request.setAttribute("erreur", "Ce pseudo est déjà utilisé, veuillez le saisir ...");
									
				dispatcher.forward(request, response);
			}
			else if (email.length()==0 || email.isEmpty() ) {
				request.setAttribute("erreur", "L'email n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (password.length()==0 || password.isEmpty() ) {
				request.setAttribute("erreur", "Le mot de passe n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (rue.length()==0 || rue.isEmpty() ) {
				request.setAttribute("erreur", "La rue n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (ville.length()==0 || ville.isEmpty() ) {
				request.setAttribute("erreur", "La ville n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (codePostal.length()==0 || codePostal.isEmpty() ) {
				request.setAttribute("erreur", "Le code postal n'a pas été renseigné, veuillez le saisir ...");
				dispatcher.forward(request, response);
			}
			else if (confirmation.equals(password)) {
				
				String encryptedPassword = UtilisateurManager.encrypt(password);
			
				user = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,encryptedPassword);
				user = UtilisateurManager.register(user);
				
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("ConnectedUser", user);
					
					//this.getServletContext().getRequestDispatcher("/").forward(request, response);
					response.sendRedirect(this.getServletContext().getContextPath() + "/");
				} 
				else 
				{
					request.setAttribute("erreur", "Aucun utilisateur");
					dispatcher.forward(request, response);
				}
								
			}
			
		}catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
