package biz.opengate.corso.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.opengte.corso.ejb.CounterSingleton;

@WebServlet("/Concurrent")
public class Concurrent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CounterSingleton counter;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int op;
		try {
			op = Integer.valueOf(request.getParameter("op"));
		} catch (NumberFormatException e) {
			op = -1;
		}
		switch (op) {
		case 0:
			counter.dec();
			response.getWriter().append("dec");
			break;
		case 1:
			counter.inc();
			response.getWriter().append("inc");
			break;

		default:
			response.getWriter().append(counter.getCounter().toString());
			break;
		}

	}

}
