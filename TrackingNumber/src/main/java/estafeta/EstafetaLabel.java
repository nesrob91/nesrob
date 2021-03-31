/**
 * EstafetaLabel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta;
import estafeta.beans.*;

public interface EstafetaLabel extends java.rmi.Remote {
    public EstafetaLabelResponse createLabel(EstafetaLabelRequest in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponse reprintLabel(EstafetaReprintLabelRequest in0) throws java.rmi.RemoteException;
    public EstafetaLabelSimpleResponse createSimpleLabel(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException;
    public EstafetaLabelImageSimpleResponse createSimpleLabelImage(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponseVol createLabelVol(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponseIndividual createLabelIndividual(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponseVol createLabelVolR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponseIndividual createLabelIndividualR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException;
    public EstafetaLabelResponseExtended createLabelExtended(EstafetaLabelRequestExtended in0) throws java.rmi.RemoteException;
}
