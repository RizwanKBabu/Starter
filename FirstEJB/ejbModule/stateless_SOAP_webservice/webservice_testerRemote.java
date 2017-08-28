package stateless_SOAP_webservice;

import javax.ejb.Remote;
import javax.jws.WebService;

import com.entity.testEntityStateless;

import XML_Packaging.Teststateless_to_XML;

@WebService// to access with URL,QName,Service,Service
@Remote
public interface webservice_testerRemote {

	Teststateless_to_XML getEntryStateless(int id);
	
}
