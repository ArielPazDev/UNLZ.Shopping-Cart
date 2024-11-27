package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Article;
import repos.ArticleRepo;

@WebServlet("/articles/*")
public class ArticleController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArticleRepo articleRepo;

    public ArticleController() {
	super();

	this.articleRepo = ArticleRepo.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Character
	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	// Attributes
    	request.setAttribute("contextPath", request.getContextPath());    	

	// Path
	String path = Optional
		.ofNullable(request.getPathInfo())
		.orElse("/index");

	switch (path) {
	case "/index" -> getIndex(request, response);
	case "/create" -> getCreate(request, response);
	case "/update" -> getUpdate(request, response);
	case "/delete" -> getDelete(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("articles", articleRepo.array());

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/articles/index.jsp").forward(request, response);
    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/articles/create.jsp").forward(request, response);
    }

    private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("article", articleRepo.find(request.getParameter("id")));

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/articles/update.jsp").forward(request, response);
    }

    private void getDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("idArticle", request.getParameter("id"));

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/articles/delete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Character
	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
	// Path
	String path = Optional
		.ofNullable(request.getPathInfo())
		.orElse("/index");

	switch (path) {
	case "/create" -> setCreate(request, response);
	case "/update" -> setUpdate(request, response);
	case "/delete" -> setDelete(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void setCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameters
	String idArticle = request.getParameter("idArticle");
	String name = request.getParameter("name");
	String description = request.getParameter("description");
	double price = Double.parseDouble(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));

	// ArticleRepo (add)
	articleRepo.add(new Article(idArticle, name, description, price, stock));

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

    private void setUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameters
	String idArticle = request.getParameter("idArticle");
	String name = request.getParameter("name");
	String description = request.getParameter("description");
	double price = Double.parseDouble(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));

	// ArticleRepo (update)
	articleRepo.update(new Article(idArticle, name, description, price, stock));

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

    private void setDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameters
	String idArticle = request.getParameter("idArticle");

	// ArticleRepo (delete)
	articleRepo.delete(idArticle);

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }
}