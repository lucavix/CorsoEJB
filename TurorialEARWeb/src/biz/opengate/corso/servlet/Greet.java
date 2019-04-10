package biz.opengate.corso.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.opengte.corso.ejb.Greeter;

/**
 * Servlet implementation class Greet
 */
@WebServlet("/Greet")
public class Greet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Greeter greeter;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(greeter.greet());
	}


}
