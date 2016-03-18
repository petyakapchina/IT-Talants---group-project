package it.talent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import exceptions.InvalidUserNameException;
import instagram.Profile;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet1")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		ProfileDAO userDao = new ProfileDAO();
		response.setContentType("text/html");

		Profile user;

		try {
			user = userDao.loginUser(username, password);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("./HomePage.html");

		} catch (InvalidUserNameException e) {
			response.sendRedirect("./index.html");
			e.printStackTrace();
		}

	}

}
