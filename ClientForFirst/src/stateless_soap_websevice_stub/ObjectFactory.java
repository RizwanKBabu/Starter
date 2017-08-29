
package stateless_soap_websevice_stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stateless_soap_websevice_stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEntryStateless_QNAME = new QName("http://stateless_SOAP_webservice_using_Eclipse/", "getEntryStateless");
    private final static QName _GetEntryStatelessResponse_QNAME = new QName("http://stateless_SOAP_webservice_using_Eclipse/", "getEntryStatelessResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stateless_soap_websevice_stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEntryStatelessResponse }
     * 
     */
    public GetEntryStatelessResponse createGetEntryStatelessResponse() {
        return new GetEntryStatelessResponse();
    }

    /**
     * Create an instance of {@link GetEntryStateless }
     * 
     */
    public GetEntryStateless createGetEntryStateless() {
        return new GetEntryStateless();
    }

    /**
     * Create an instance of {@link TeststatelessToXML }
     * 
     */
    public TeststatelessToXML createTeststatelessToXML() {
        return new TeststatelessToXML();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEntryStateless }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stateless_SOAP_webservice_using_Eclipse/", name = "getEntryStateless")
    public JAXBElement<GetEntryStateless> createGetEntryStateless(GetEntryStateless value) {
        return new JAXBElement<GetEntryStateless>(_GetEntryStateless_QNAME, GetEntryStateless.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEntryStatelessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stateless_SOAP_webservice_using_Eclipse/", name = "getEntryStatelessResponse")
    public JAXBElement<GetEntryStatelessResponse> createGetEntryStatelessResponse(GetEntryStatelessResponse value) {
        return new JAXBElement<GetEntryStatelessResponse>(_GetEntryStatelessResponse_QNAME, GetEntryStatelessResponse.class, null, value);
    }

}
