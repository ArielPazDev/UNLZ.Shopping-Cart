package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import repos.UserRepo;

@WebServlet("/users")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserRepo userRepo;
	
    public UserController() {
        super();
        
        this.userRepo = UserRepo.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserController...");
		userRepo.viewList();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Params
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// UserRepo (add user)
		userRepo.add(new User(username, password, "Client", 1000.0f));

		// UserRepo (view list)
		userRepo.viewList();
	}
}