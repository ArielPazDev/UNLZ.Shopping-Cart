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

@WebServlet("/dashboard/*")
public class DashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DashboardController() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession(false);

	if (session == null || session.getAttribute("user") == null) {
	    // Redirect (home)
	    response.sendRedirect(request.getContextPath() + "/home");

	    return;
	}

	// Character
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	// Attribute
	request.setAttribute("contextPath", request.getContextPath());
	request.setAttribute("user", (User) session.getAttribute("user"));

	// Path
	String path = Optional.ofNullable(request.getPathInfo()).orElse("/index");

	switch (path) {
	case "/index" -> getIndex(request, response);
	case "/signout" -> getSignOut(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/dashboard/index.jsp").forward(request, response);
    }

    private void getSignOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession();

	// Session (invalidate)
	session.invalidate();

	// Redirect (home)
	response.sendRedirect(request.getContextPath() + "/home");
    }
}
