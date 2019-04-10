package biz.opengte.corso.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MessageTopicConsumer
 */
@MessageDriven(
		activationConfig = { 
				
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/topic/test"), 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "jms/topic/test")
public class MessageTopicConsumer2 implements MessageListener {

    /**
     * Default constructor. 
     */
    public MessageTopicConsumer2() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
    		String msg = ((TextMessage)message).getText();
			System.out.println("Messace Received Topic 2: " + msg);
			
		} catch (JMSException e) {
			System.out.println("Unable to process message:" + message);
			throw new EJBException(e);
		}

        
    }

}
