package biz.opengate.corso.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.opengte.corso.ejb.ItemCrud;
import biz.opengte.corso.entities.Item;

@WebServlet("/Items")
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ItemCrud itemCrud;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op;
		String description;
		String id;
		try {
			op = request.getParameter("op");
			description = request.getParameter("description");
			id = request.getParameter("id");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("Woops");
		}
		
		switch (op) {
		case "createNew":
			// http://localhost:8080/TurorialEARWeb/Items?op=createNew&description=New%20One
			response.getWriter().append(itemCrud.createNew(description).toString());
			break;
		case "update":
			// http://localhost:8080/TurorialEARWeb/Items?op=update&description=Ciao&id=1
			response.getWriter().append(itemCrud.update(Long.valueOf(id),description).toString());
			break;
		case "list":
			// http://localhost:8080/TurorialEARWeb/Items?op=list
			List<Item> list = itemCrud.list();
			for(Item i:list) {
				response.getWriter().append(i.toString()).append("\n");
			}			
			break;
		
		default:
			response.getWriter().append("Unknown operation");
			break;
		}

	}

}
