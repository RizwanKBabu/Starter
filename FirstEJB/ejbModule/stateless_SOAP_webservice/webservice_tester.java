package stateless_SOAP_webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.testEntityStateless;

import Start_from_stateless.FIrstStateless;
import Start_from_stateless.FIrstStatelessLocal;
import XML_Packaging.Teststateless_to_XML;

/**
 * Session Bean implementation class webservice_tester
 */
@WebService
@Stateless
public class webservice_tester implements webservice_testerRemote {

	@PersistenceContext(unitName="EjbPU")
	private EntityManager entityManager;
	
	@EJB
	FIrstStatelessLocal s;
	
	@Override
	public Teststateless_to_XML getEntryStateless(int id) {
		testEntityStateless t = entityManager.find(testEntityStateless.class,id);
		Teststateless_to_XML x = new Teststateless_to_XML(t.getfullName(),t.getId());
		return x;
	}

}
