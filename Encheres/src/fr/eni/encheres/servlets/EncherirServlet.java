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

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet(name = "EncherirServlet", urlPatterns = { "/encherir" })
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncherirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detailArticle.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
			int currentCredit = connectedUser.getCredit();
			
			int prixEnchere = Integer.parseInt(request.getParameter("proposed-price"));
			int idArticle = Integer.parseInt(request.getParameter("idArticle"));
			
			Article article = null;
			try {
				article = ArticleManager.getById(idArticle);
			} catch (BusinessException e1) {
				e1.printStackTrace();
			}
			 
			
			if (article != null && prixEnchere > article.getMiseAPrix() && connectedUser.getCredit() >= prixEnchere) {
				Enchere enchere = new Enchere(LocalDate.now(), prixEnchere, article, connectedUser);
				article.setPrixVente(prixEnchere);
						
				try {
					EnchereManager.insert(enchere);
					ArticleManager.update(article);
	
				} catch (BusinessException e) {
					e.printStackTrace();
				}
				
				//request.getRequestDispatcher("/WEB-INF/jsp/homeConnected.jsp").forward(request, response);
				response.sendRedirect(this.getServletContext().getContextPath() + "/article?id=" + idArticle);
			}
			
	}
	

}
