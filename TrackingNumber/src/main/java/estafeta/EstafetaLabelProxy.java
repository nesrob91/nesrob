package estafeta;
import estafeta.beans.*;

public class EstafetaLabelProxy implements EstafetaLabel {
  private String _endpoint = null;
  private EstafetaLabel estafetaLabel = null;
  
  public EstafetaLabelProxy() {
    _initEstafetaLabelProxy();
  }
  
  public EstafetaLabelProxy(String endpoint) {
    _endpoint = endpoint;
    _initEstafetaLabelProxy();
  }
  
  private void _initEstafetaLabelProxy() {
    try {
      estafetaLabel = (new EstafetaLabelServiceLocator()).getEstafetaLabelWS();
      if (estafetaLabel != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)estafetaLabel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)estafetaLabel)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (estafetaLabel != null)
      ((javax.xml.rpc.Stub)estafetaLabel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EstafetaLabel getEstafetaLabel() {
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel;
  }
  
  public EstafetaLabelResponse createLabel(EstafetaLabelRequest in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabel(in0);
  }
  
  public EstafetaLabelResponse reprintLabel(EstafetaReprintLabelRequest in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.reprintLabel(in0);
  }
  
  public EstafetaLabelSimpleResponse createSimpleLabel(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createSimpleLabel(in0);
  }
  
  public EstafetaLabelImageSimpleResponse createSimpleLabelImage(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createSimpleLabelImage(in0);
  }
  
  public EstafetaLabelResponseVol createLabelVol(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabelVol(in0);
  }
  
  public EstafetaLabelResponseIndividual createLabelIndividual(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabelIndividual(in0);
  }
  
  public EstafetaLabelResponseVol createLabelVolR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabelVolR(in0);
  }
  
  public EstafetaLabelResponseIndividual createLabelIndividualR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabelIndividualR(in0);
  }
  
  public EstafetaLabelResponseExtended createLabelExtended(EstafetaLabelRequestExtended in0) throws java.rmi.RemoteException{
    if (estafetaLabel == null)
      _initEstafetaLabelProxy();
    return estafetaLabel.createLabelExtended(in0);
  }
  
  
}