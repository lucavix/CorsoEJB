package biz.opengate.corso.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostMessage
 */
@WebServlet("/PostMessage")
public class PostMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

    

	@Resource(lookup = "java:/ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Resource(lookup = "java:jboss/exported/jms/queue/test")
    Destination queue;

    @Resource(lookup = "java:jboss/exported/jms/topic/test")
    Destination topic;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		
		
		try {
			msg = request.getParameter("msg");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("Woops");
		}

		// http://localhost:8080/TurorialEARWeb/PostMessage?msg=HelloWorld
		try {
			QueueConnection connection = (QueueConnection)connectionFactory.createConnection();
			QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage(msg);
			producer.send(message);
			producer.close();

			producer = session.createProducer(topic);
			message = session.createTextMessage(msg);
			producer.send(message);
			producer.close();

			
			session.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		response.getWriter().append("Message: " + msg);
	}


}
