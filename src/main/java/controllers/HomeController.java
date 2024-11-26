package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;

@WebServlet("/index")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Session
    	HttpSession session = request.getSession();

    	// Character
    	response.setCharacterEncoding("UTF-8");
    	
    	response.setHeader("Content-Type", "text/plain; charset=UTF-8");
    	
    	String id = session.getId();
		
    	session.setAttribute("nombre", "Ariel");
    	
    	/*// Cart
    	Cart cart;
    	
    	if (session.getAttribute("cart") == null) {
    		cart = new Cart();
    		
    		session.setAttribute("cart", cart);
    	} else {
    		cart = (Cart) session.getAttribute("cart");
    	}*/
    	
    	
    	
    	
    	PrintWriter pr = response.getWriter();
		
    	pr.append("HomeController\n");
    	pr.append("request.getContextPath(): ").append(request.getContextPath() + "\n");
		pr.append("request.getServletPath(): ").append(request.getServletPath() + "\n");
		pr.append("request.getPathInfo(): ").append(request.getPathInfo() + "\n");
		pr.append("Sesion ID: ").append(id + "\n");
		pr.append("Sesion Nombre: ").append(session.getAttribute("nombre") + "\n");
	}
}