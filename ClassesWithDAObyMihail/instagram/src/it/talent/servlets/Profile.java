package it.talent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		if (request.getSession(false) == null) {
			response.sendRedirect("./");
			return;
		}
	// ако искаш тук май вече трябва да сложим хтмл документите да paste всичко яко или не знам и аз
		
		// така взимам профила от индекса като се подаде чрез сесия
		
		Profile user = (Profile) request.getSession().getAttribute("user");
		
		
		//tyka maj sega trqbvka html- da se kopirat no naistina ne znam
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
