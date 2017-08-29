/**
 * Webservice_testerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package for_eclipse_client;

public class Webservice_testerServiceLocator extends org.apache.axis.client.Service implements for_eclipse_client.Webservice_testerService {

    public Webservice_testerServiceLocator() {
    }


    public Webservice_testerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Webservice_testerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for webservice_testerPort
    private java.lang.String webservice_testerPort_address = "http://localhost:7004/FirstEJB/webservice_tester";

    public java.lang.String getwebservice_testerPortAddress() {
        return webservice_testerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String webservice_testerPortWSDDServiceName = "webservice_testerPort";

    public java.lang.String getwebservice_testerPortWSDDServiceName() {
        return webservice_testerPortWSDDServiceName;
    }

    public void setwebservice_testerPortWSDDServiceName(java.lang.String name) {
        webservice_testerPortWSDDServiceName = name;
    }

    public for_eclipse_client.Webservice_testerRemote getwebservice_testerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(webservice_testerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwebservice_testerPort(endpoint);
    }

    public for_eclipse_client.Webservice_testerRemote getwebservice_testerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            for_eclipse_client.Webservice_testerServiceSoapBindingStub _stub = new for_eclipse_client.Webservice_testerServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getwebservice_testerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwebservice_testerPortEndpointAddress(java.lang.String address) {
        webservice_testerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (for_eclipse_client.Webservice_testerRemote.class.isAssignableFrom(serviceEndpointInterface)) {
                for_eclipse_client.Webservice_testerServiceSoapBindingStub _stub = new for_eclipse_client.Webservice_testerServiceSoapBindingStub(new java.net.URL(webservice_testerPort_address), this);
                _stub.setPortName(getwebservice_testerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("webservice_testerPort".equals(inputPortName)) {
            return getwebservice_testerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://stateless_SOAP_webservice/", "webservice_testerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://stateless_SOAP_webservice/", "webservice_testerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("webservice_testerPort".equals(portName)) {
            setwebservice_testerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
