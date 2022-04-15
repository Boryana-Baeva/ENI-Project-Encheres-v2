package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.exceptions.BusinessException;

/**
 * Servlet implementation class UpdateArticleServlet
 */
@WebServlet(name = "UpdateArticleServlet", urlPatterns = { "/modifier-article" })
public class UpdateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			article = ArticleManager.getById(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		if (article != null) {
			request.setAttribute("article", article);
			
			request.getRequestDispatcher("/WEB-INF/jsp/updateArticle.jsp").forward(request, response);
		
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle = Integer.parseInt(request.getParameter("id"));
		Article article = null;
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		int idCategorie = Integer.parseInt(request.getParameter("category"));
		int miseAPrix = Integer.parseInt(request.getParameter("initial-price"));
		LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("date-start"));
		LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("date-end"));
		/*String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");*/
		
		
		try {
			article = ArticleManager.getById(idArticle);	
			Categorie categorie = CategorieManager.getById(idCategorie);
			/*Retrait retrait = RetraitManager.selectionnerRetraitById(article.getLieuRetrait().getId());
			retrait.setRue(rue);
			retrait.setCodePostal(codePostal);
			retrait.setVille(ville);
			//RetraitManager.modifierRetrait(retrait);*/
				
			article.setNom(nom);
			article.setDescription(description);
			article.setMiseAPrix(miseAPrix);
			article.setDateDebutEncheres(dateDebutEncheres);
			article.setDateFinEncheres(dateFinEncheres);
			article.setCategorie(categorie);
			//article.setLieuRetrait(retrait);
			ArticleManager.update(article);
			
			request.setAttribute("idArticle", idArticle);
			//request.getRequestDispatcher("/detailArticle").forward(request, response);
			response.sendRedirect(this.getServletContext().getContextPath() + "/article?id=" + idArticle);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
