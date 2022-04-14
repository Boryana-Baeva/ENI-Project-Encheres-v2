package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

/**
 * Servlet implementation class DetailArticleServlet
 */
@WebServlet(name = "DetailArticleServlet", urlPatterns = { "/article" })
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticleServlet() {
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
			
			request.getRequestDispatcher("/WEB-INF/jsp/detailArticle.jsp").forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
