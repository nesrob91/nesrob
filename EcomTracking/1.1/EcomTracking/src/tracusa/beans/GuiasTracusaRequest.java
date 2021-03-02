/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracusa.beans;

/**
 *
 * @author alimon
 */
public class GuiasTracusaRequest {

    String idService;
    String reference;
    String trackingCode;
    String observations;
    ToAddress toAddress;
    FromAddress fromAddress;
    Parcel parcel;

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public ToAddress getToAddress() {
        return toAddress;
    }

    public void setToAddress(ToAddress toAddress) {
        this.toAddress = toAddress;
    }

    public FromAddress getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(FromAddress fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    
    
}
