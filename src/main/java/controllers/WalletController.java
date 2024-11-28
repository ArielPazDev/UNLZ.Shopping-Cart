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

@WebServlet("/dashboard/wallets/*")
public class WalletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserRepo userRepo;

    public WalletController() {
	super();

	this.userRepo = UserRepo.getInstance();
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
	case "/deposit" -> getDeposit(request, response);
	case "/transfer" -> getTransfer(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/wallets/index.jsp").forward(request, response);
    }

    private void getDeposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/wallets/deposit.jsp").forward(request, response);
    }

    private void getTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Dispatcher
	request.getRequestDispatcher("/WEB-INF/views/wallets/transfer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	request.setAttribute("user", (User) session.getAttribute("user"));

	// Path
	String path = Optional.ofNullable(request.getPathInfo()).orElse("/index");

	switch (path) {
	case "/deposit" -> setDeposit(request, response);
	case "/transfer" -> setTransfer(request, response);
	default -> response.sendRedirect(request.getContextPath() + request.getServletPath());
	}
    }

    private void setDeposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	double money = Double.parseDouble(request.getParameter("money"));

	// UserRepo (deposit)
	userRepo.deposit(((User) request.getAttribute("user")).getIdUser(), money);

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

    private void setTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Parameter
	int idUserReceptor = Integer.parseInt(request.getParameter("idUserReceptor"));
	double money = Double.parseDouble(request.getParameter("money"));

	// UserRepo (transfer)
	userRepo.transfer(((User) request.getAttribute("user")).getIdUser(), idUserReceptor, money);

	// Redirect
	response.sendRedirect(request.getContextPath() + request.getServletPath());
    }
}