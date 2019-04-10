package biz.opengte.corso.ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/queue/test"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "jms/queue/test")
public class MessageQueueConsumer2 implements MessageListener {

	@EJB
	ItemComplexOp itOp;
	
	 @Resource
	 private MessageDrivenContext mdbContext;
	
	public MessageQueueConsumer2() {
    }
	// jms-queue --queue-address=testQueue pause
	// jms-queue --queue-address=testQueue resume
    public void onMessage(Message message) {
        	try {
        		String msg = ((TextMessage)message).getText();
				System.out.println("Messace Received Queue 2: " + msg);
				itOp.complexOp(msg, 1);
				
			} catch (JMSException e) {
				System.out.println("Unable to process message:" + message);
				mdbContext.setRollbackOnly();
				throw new EJBException(e);
			}
        
    }

}
