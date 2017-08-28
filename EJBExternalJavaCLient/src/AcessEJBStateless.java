import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.entity.HSQLTestEntity;
import com.entity.testEntityStateless;

import Start_from_stateless.FIrstStatelessRemote;
import XML_Packaging.Teststateless_to_XML;
import start_from_stateful.StatefulBeanRemote;
import stateless_SOAP_webservice.webservice_testerRemote;
import stateless_soap_websevice_stub.TeststatelessToXML;
import stateless_soap_websevice_stub.WebserviceTesterRemote;
import stateless_soap_websevice_stub.WebserviceTesterService;

public class AcessEJBStateless {
	
	public static void main(String[] args) {
		try{
			 
			System.out.println("Hello From Java!");
			
			Properties props = new Properties();
			props.load(new FileInputStream("src/jndi.properties"));
			
            InitialContext context = new InitialContext(props);
 
	        FIrstStatelessRemote bean1 = (FIrstStatelessRemote)context.lookup("StatelessFirst");
	        System.out.println("Result computed by EJB is :"+bean1.start()); 	
	        bean1.makeEntryStateless("Moidu");
	        System.out.println(bean1.getEntryStateless(1901));
	        
	        bean1.createTimer(1000*30);
	        
	        bean1.hsql_insert("welcome");
	        List<HSQLTestEntity> l = bean1.getHsql(1);
	        
	        for(HSQLTestEntity ll : l)
	        	System.out.println(ll+"\n\n");
	        
	        
	        StatefulBeanRemote bean2 = (StatefulBeanRemote)context.lookup("StatefulFirst");
	        System.out.println("Result computed by EJB is :"+bean2.StartWithStateful());
	        bean2.makeEntry("Shameer");
	        //System.out.println(bean2.getEntry(50));
	        
	         Queue queue = (Queue) context.lookup("/queue/BookQueue");
	         QueueConnectionFactory factory =  (QueueConnectionFactory) context.lookup("ConnectionFactory");
	         QueueConnection connection =  factory.createQueueConnection();
	         QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	         QueueSender sender = session.createSender(queue);
	         ObjectMessage objectMessage = session.createObjectMessage(new testEntityStateless("Life"));
	         sender.send(objectMessage);
	         
	         
	         //One way of accessing Web service using normal access from Standalone  
	         URL url = new URL("http://localhost:7004/FirstEJB/webservice_tester?wsdl"); 
	         QName qname = new QName("http://stateless_SOAP_webservice/", "webservice_testerService");
	         Service service = Service.create(url, qname);
	         webservice_testerRemote hello = service.getPort(webservice_testerRemote.class);

	         Teststateless_to_XML x = hello.getEntryStateless(1901);
	         System.out.println("Result : id - "+x.getId() +" name - "+x.getName());
	         
	         
	         /**Using wsimport
	          **set path="C:\Program Files\Java\jdk1.8.0_111\bin"
	          **wsimport -keep -verbose  http://localhost:7004/FirstEJB/webservice_tester?wsdl -folderName
	          **move generated folder to project as package 
	          ** similar way can use wsgen also to generate webservice
	          */
	         WebserviceTesterService s = new WebserviceTesterService();
	         WebserviceTesterRemote h = s.getWebserviceTesterPort();
	          
	         TeststatelessToXML x1 = h.getEntryStateless(1902);
	         System.out.println("Result : id - "+x1.getId() +" name - "+x1.getName());
	         
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
