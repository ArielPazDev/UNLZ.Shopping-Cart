package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import repos.UserRepo;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// User (repo)
		UserRepo userRepo = new UserRepo();
		
		//userRepo.add(new User("1", "1", "Employee", 0.0f));

		userRepo.print();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Params
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// User (repo)
		UserRepo userRepo = new UserRepo();
		
		userRepo.add(new User(username, password, "Client", 100.0f));

		userRepo.print();
	}
}