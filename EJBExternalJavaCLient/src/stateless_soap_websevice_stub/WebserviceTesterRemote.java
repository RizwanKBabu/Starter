
package stateless_soap_websevice_stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "webservice_testerRemote", targetNamespace = "http://stateless_SOAP_webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebserviceTesterRemote {


    /**
     * 
     * @param arg0
     * @return
     *     returns stateless_soap_websevice_stub.TeststatelessToXML
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEntryStateless", targetNamespace = "http://stateless_SOAP_webservice/", className = "stateless_soap_websevice_stub.GetEntryStateless")
    @ResponseWrapper(localName = "getEntryStatelessResponse", targetNamespace = "http://stateless_SOAP_webservice/", className = "stateless_soap_websevice_stub.GetEntryStatelessResponse")
    public TeststatelessToXML getEntryStateless(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
