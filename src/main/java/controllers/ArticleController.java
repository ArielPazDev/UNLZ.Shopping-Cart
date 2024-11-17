package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repos.ArticleRepo;

@WebServlet("/articles")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleRepo articleRepo;
       
    public ArticleController() {
        super();
        
        this.articleRepo = ArticleRepo.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ArticleRepo (view)
		articleRepo.view("ArticleController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}