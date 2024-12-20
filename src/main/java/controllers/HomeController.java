package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import repos.UserRepo;

@WebServlet("/home/*")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserRepo userRepo;

    public HomeController() {
	super();

	this.userRepo = UserRepo.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession(true);

	// Session (expires in 86400 seconds = 1 day)
	session.setMaxInactiveInterval(86400);

	if (session.getAttribute("user") != null) {
	    // Redirect (dashboard)
	    response.sendRedirect(request.getContextPath() + "/dashboard");

	    return;
	}

	// Character
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	// Attribute
	request.setAttribute("contextPath", request.getContextPath());

	// Path
	String path = Optional.ofNullable(request.getPathInfo()).orElse("/index");

	switch (path) {
	case "/index" -> getIndex(request, response);
	case "/signin" -> getSignIn(request, response);
	case "/signup" -> getSignUp(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(request, response);
    }

    private void getSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/home/signin.jsp").forward(request, response);
    }

    private void getSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/home/signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession(false);

	if (session == null) {
	    // Redirect (home)
	    response.sendRedirect(request.getContextPath() + "/home");

	    return;
	}

	// Character
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	// Path
	String path = Optional.ofNullable(request.getPathInfo()).orElse("/index");

	switch (path) {
	case "/signin" -> setSignIn(request, response);
	case "/signup" -> setSignUp(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void setSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// UserRepo (signin)
	User user = userRepo.signin(username, password);

	if (user == null) {
	    // Redirect (signin)
	    response.sendRedirect(request.getContextPath() + request.getServletPath() + "/signin");
	} else {
	    // Session
	    HttpSession session = request.getSession();

	    session.setAttribute("user", user);

	    // Redirect (dashboard)
	    response.sendRedirect(request.getContextPath() + "/dashboard");
	}
    }

    private void setSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}