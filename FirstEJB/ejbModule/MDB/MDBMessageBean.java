package MDB;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.entity.testEntityStateless;

import Start_from_stateless.FIrstStatelessRemote;

@MessageDriven(
activationConfig = 
{ 
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
,
@ActivationConfigProperty(propertyName = "destination", propertyValue ="/queue/BookQueue")
,
@ActivationConfigProperty(propertyName = "user", propertyValue = "guest")
,
@ActivationConfigProperty(propertyName = "password", propertyValue = "guest")
/*,
@ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "-1")
,   
@ActivationConfigProperty(propertyName = "setupAttempts", propertyValue = "-1")*/
}             ) 
                
public class MDBMessageBean implements MessageListener {

	@Resource
	private MessageDrivenContext mdc; 
	
	@EJB
	FIrstStatelessRemote fsr;
	
    public void onMessage(Message message) 
    {
    	ObjectMessage objectMessage = null;
        try {
           objectMessage = (ObjectMessage) message;
           testEntityStateless t = (testEntityStateless) objectMessage.getObject();           
           fsr.makeEntryEntity(t);   
        } catch (JMSException ex) {
        	mdc.setRollbackOnly();
        } 
    }

}
