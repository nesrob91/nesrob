package com.estafeta.www;

public class ServiceSoapProxy implements com.estafeta.www.ServiceSoap {
  private String _endpoint = null;
  private com.estafeta.www.ServiceSoap serviceSoap = null;
  
  public ServiceSoapProxy() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoap = (new com.estafeta.www.ServiceLocator()).getServiceSoap();
      if (serviceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoap != null)
      ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.estafeta.www.ServiceSoap getServiceSoap() {
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap;
  }
  
  public com.estafeta.www.QueryResult executeQuery(java.lang.String suscriberId, java.lang.String login, java.lang.String password, com.estafeta.www.SearchType searchType, com.estafeta.www.SearchConfiguration searchConfiguration) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.executeQuery(suscriberId, login, password, searchType, searchConfiguration);
  }
  
  
}