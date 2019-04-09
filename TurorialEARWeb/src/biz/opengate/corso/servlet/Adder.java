package biz.opengate.corso.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.opengte.corso.ejb.AdderLocal;

/**
 * Servlet implementation class Adder
 */
@WebServlet("/Adder")
public class Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@EJB
	private AdderLocal adderLocal;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer a = Integer.valueOf(request.getParameter("a"));
		Integer b = Integer.valueOf(request.getParameter("b"));
		
		Writer w = response.getWriter();
		w.append("Served at: ").append(request.getContextPath()).append("\n\n");
		
		StringBuffer sb = new StringBuffer(10);
		sb.append(a).append(" + ").append(b).append(" = ").append(adderLocal.add(a, b));
	
		w.append(sb);
		
	}

}
