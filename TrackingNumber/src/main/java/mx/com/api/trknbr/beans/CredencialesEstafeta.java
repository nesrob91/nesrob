/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

/**
 *
 * @author dparra
 */
public class CredencialesEstafeta {
    
    private String paperType;
    private String content;
    private boolean deliveryToEstafeta;
    private int numberOfLabels;
    private int parcelType;
    private boolean returnDocument;
    private String usuario;
    private String contrasenia;
    private String numOfi;
    private String idSuscriptor;
    private String numcte;
    private String serviceTypeId;
    private String serviceTypeDocRet;
    private String effectiveDate;
    private String idSap;

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeliveryToEstafeta() {
        return deliveryToEstafeta;
    }

    public void setDeliveryToEstafeta(boolean deliveryToEstafeta) {
        this.deliveryToEstafeta = deliveryToEstafeta;
    }

    public int getNumberOfLabels() {
        return numberOfLabels;
    }

    public void setNumberOfLabels(int numberOfLabels) {
        this.numberOfLabels = numberOfLabels;
    }

    public int getParcelType() {
        return parcelType;
    }

    public void setParcelType(int parcelType) {
        this.parcelType = parcelType;
    }

    public boolean isReturnDocument() {
        return returnDocument;
    }

    public void setReturnDocument(boolean returnDocument) {
        this.returnDocument = returnDocument;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNumOfi() {
        return numOfi;
    }

    public void setNumOfi(String numOfi) {
        this.numOfi = numOfi;
    }

    public String getIdSuscriptor() {
        return idSuscriptor;
    }

    public void setIdSuscriptor(String idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    public String getNumcte() {
        return numcte;
    }

    public void setNumcte(String numcte) {
        this.numcte = numcte;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeDocRet() {
        return serviceTypeDocRet;
    }

    public void setServiceTypeDocRet(String serviceTypeDocRet) {
        this.serviceTypeDocRet = serviceTypeDocRet;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getIdSap() {
        return idSap;
    }

    public void setIdSap(String idSap) {
        this.idSap = idSap;
    }
    
}
