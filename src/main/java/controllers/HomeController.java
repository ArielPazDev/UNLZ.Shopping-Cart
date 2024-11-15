package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
    	
    	response.setHeader("Content-Type", "text/plain; charset=UTF-8");
		
    	PrintWriter print = response.getWriter();
		
    	print.append("request.getContextPath(): ").append(request.getContextPath() + "\n");
		print.append("request.getServletPath(): ").append(request.getServletPath() + "\n");
		print.append("request.getPathInfo(): ").append(request.getPathInfo() + "\n");
	}
}