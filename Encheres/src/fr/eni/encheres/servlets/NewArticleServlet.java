package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exceptions.BusinessException;

/**
 * Servlet implementation class NewArticleServlet
 */
@WebServlet(name = "NewArticleServlet", urlPatterns = { "/vendre" })
public class NewArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newArticle.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Article article = new Article();
		
		try {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("date-start"));
			LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("date-end"));
			int miseAPrix = Integer.parseInt(request.getParameter("initial-price"));
			int categerieId = Integer.parseInt(request.getParameter("category"));
				
			Categorie categorie = CategorieManager.getById(categerieId);
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("ConnectedUser");
			
			article.setNom(nom);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebutEncheres);
			article.setDateFinEncheres(dateFinEncheres);
			article.setMiseAPrix(miseAPrix);
			article.setCategorie(categorie);
			article.setVendeur(utilisateur);
			
			ArticleManager.insert(article);
			
			if(request.getParameter("rue") != null &&
					request.getParameter("code-postal") != null &&
					request.getParameter("ville") != null) {
				
				Retrait retrait = new Retrait();
				retrait.setRue(request.getParameter("rue"));
				retrait.setCodePostal(request.getParameter("code-postal"));
				retrait.setVille(request.getParameter("ville"));
				retrait.setId(article.getId());
				
				RetraitManager.insert(retrait);
						
			}
			
			response.sendRedirect(this.getServletContext().getContextPath() + "/");
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
