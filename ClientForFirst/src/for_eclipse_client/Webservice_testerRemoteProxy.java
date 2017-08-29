package for_eclipse_client;

public class Webservice_testerRemoteProxy implements for_eclipse_client.Webservice_testerRemote {
  private String _endpoint = null;
  private for_eclipse_client.Webservice_testerRemote webservice_testerRemote = null;
  
  public Webservice_testerRemoteProxy() {
    _initWebservice_testerRemoteProxy();
  }
  
  public Webservice_testerRemoteProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebservice_testerRemoteProxy();
  }
  
  private void _initWebservice_testerRemoteProxy() {
    try {
      webservice_testerRemote = (new for_eclipse_client.Webservice_testerServiceLocator()).getwebservice_testerPort();
      if (webservice_testerRemote != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webservice_testerRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webservice_testerRemote)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webservice_testerRemote != null)
      ((javax.xml.rpc.Stub)webservice_testerRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public for_eclipse_client.Webservice_testerRemote getWebservice_testerRemote() {
    if (webservice_testerRemote == null)
      _initWebservice_testerRemoteProxy();
    return webservice_testerRemote;
  }
  
  public for_eclipse_client.TeststatelessToXML getEntryStateless(int arg0) throws java.rmi.RemoteException{
    if (webservice_testerRemote == null)
      _initWebservice_testerRemoteProxy();
    return webservice_testerRemote.getEntryStateless(arg0);
  }
  
  
}