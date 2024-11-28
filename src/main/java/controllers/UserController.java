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

@WebServlet("/dashboard/users/*")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserRepo userRepo;

    public UserController() {
	super();

	this.userRepo = UserRepo.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession(false);

	if (session == null || session.getAttribute("user") == null || !((User) session.getAttribute("user")).getRol().equals("Empleado")) {
	    // Redirect (home)
	    response.sendRedirect(request.getContextPath() + "/home");

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
	case "/create" -> getCreate(request, response);
	case "/update" -> getUpdate(request, response);
	case "/delete" -> getDelete(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("users", userRepo.array());

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/users/index.jsp").forward(request, response);
    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/users/create.jsp").forward(request, response);
    }

    private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("user", userRepo.find(Integer.parseInt(request.getParameter("id"))));

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/users/update.jsp").forward(request, response);
    }

    private void getDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Attribute
	request.setAttribute("user", userRepo.find(Integer.parseInt(request.getParameter("id"))));

	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/users/delete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Session
	HttpSession session = request.getSession(false);

	if (session == null || session.getAttribute("user") == null || !((User) session.getAttribute("user")).getRol().equals("Empleado")) {
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
	case "/create" -> setCreate(request, response);
	case "/update" -> setUpdate(request, response);
	case "/delete" -> setDelete(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void setCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	String name = request.getParameter("name");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String rol = request.getParameter("rol");

	// UserRepo (add)
	userRepo.add(new User(name, username, password, rol));

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

    private void setUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	int idUser = Integer.parseInt(request.getParameter("idUser"));
	String name = request.getParameter("name");
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// UserRepo (update)
	userRepo.update(new User(idUser, name, username, password));

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

    private void setDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	int idUser = Integer.parseInt(request.getParameter("idUser"));

	// UserRepo (delete)
	userRepo.delete(idUser);

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }
}