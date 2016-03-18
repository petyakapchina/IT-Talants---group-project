package it.talent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.ProfileDAO;
import exceptions.DataBaseProblemException;
import instagram.Profile;

/**
 * Servlet implementation class makeAccount
 */
@WebServlet("/registration")
public class makeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");

		Profile profile = new Profile(firstName, lastName, username, email, password);

		ProfileDAO profileDao = new ProfileDAO();
		try {
			profileDao.addProfile(profile);
			request.getSession().setAttribute("user", profile);
		} catch (DataBaseProblemException e) {
			e.printStackTrace();
		}

	}

}
