
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureProofOfDeliveryFaxRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignatureProofOfDeliveryFaxRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebAuthenticationDetail" type="{http://fedex.com/ws/track/v12}WebAuthenticationDetail"/>
 *         &lt;element name="ClientDetail" type="{http://fedex.com/ws/track/v12}ClientDetail"/>
 *         &lt;element name="TransactionDetail" type="{http://fedex.com/ws/track/v12}TransactionDetail" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://fedex.com/ws/track/v12}VersionId"/>
 *         &lt;element name="QualifiedTrackingNumber" type="{http://fedex.com/ws/track/v12}QualifiedTrackingNumber" minOccurs="0"/>
 *         &lt;element name="AdditionalComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaxSender" type="{http://fedex.com/ws/track/v12}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="FaxRecipient" type="{http://fedex.com/ws/track/v12}ContactAndAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureProofOfDeliveryFaxRequest", propOrder = {
    "webAuthenticationDetail",
    "clientDetail",
    "transactionDetail",
    "version",
    "qualifiedTrackingNumber",
    "additionalComments",
    "faxSender",
    "faxRecipient"
})
public class SignatureProofOfDeliveryFaxRequest {

    @XmlElement(name = "WebAuthenticationDetail", required = true)
    protected WebAuthenticationDetail webAuthenticationDetail;
    @XmlElement(name = "ClientDetail", required = true)
    protected ClientDetail clientDetail;
    @XmlElement(name = "TransactionDetail")
    protected TransactionDetail transactionDetail;
    @XmlElement(name = "Version", required = true)
    protected VersionId version;
    @XmlElement(name = "QualifiedTrackingNumber")
    protected QualifiedTrackingNumber qualifiedTrackingNumber;
    @XmlElement(name = "AdditionalComments")
    protected String additionalComments;
    @XmlElement(name = "FaxSender")
    protected ContactAndAddress faxSender;
    @XmlElement(name = "FaxRecipient")
    protected ContactAndAddress faxRecipient;

    /**
     * Obtiene el valor de la propiedad webAuthenticationDetail.
     * 
     * @return
     *     possible object is
     *     {@link WebAuthenticationDetail }
     *     
     */
    public WebAuthenticationDetail getWebAuthenticationDetail() {
        return webAuthenticationDetail;
    }

    /**
     * Define el valor de la propiedad webAuthenticationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link WebAuthenticationDetail }
     *     
     */
    public void setWebAuthenticationDetail(WebAuthenticationDetail value) {
        this.webAuthenticationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad clientDetail.
     * 
     * @return
     *     possible object is
     *     {@link ClientDetail }
     *     
     */
    public ClientDetail getClientDetail() {
        return clientDetail;
    }

    /**
     * Define el valor de la propiedad clientDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientDetail }
     *     
     */
    public void setClientDetail(ClientDetail value) {
        this.clientDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionDetail.
     * 
     * @return
     *     possible object is
     *     {@link TransactionDetail }
     *     
     */
    public TransactionDetail getTransactionDetail() {
        return transactionDetail;
    }

    /**
     * Define el valor de la propiedad transactionDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDetail }
     *     
     */
    public void setTransactionDetail(TransactionDetail value) {
        this.transactionDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link VersionId }
     *     
     */
    public VersionId getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionId }
     *     
     */
    public void setVersion(VersionId value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad qualifiedTrackingNumber.
     * 
     * @return
     *     possible object is
     *     {@link QualifiedTrackingNumber }
     *     
     */
    public QualifiedTrackingNumber getQualifiedTrackingNumber() {
        return qualifiedTrackingNumber;
    }

    /**
     * Define el valor de la propiedad qualifiedTrackingNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link QualifiedTrackingNumber }
     *     
     */
    public void setQualifiedTrackingNumber(QualifiedTrackingNumber value) {
        this.qualifiedTrackingNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad additionalComments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalComments() {
        return additionalComments;
    }

    /**
     * Define el valor de la propiedad additionalComments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalComments(String value) {
        this.additionalComments = value;
    }

    /**
     * Obtiene el valor de la propiedad faxSender.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getFaxSender() {
        return faxSender;
    }

    /**
     * Define el valor de la propiedad faxSender.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setFaxSender(ContactAndAddress value) {
        this.faxSender = value;
    }

    /**
     * Obtiene el valor de la propiedad faxRecipient.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getFaxRecipient() {
        return faxRecipient;
    }

    /**
     * Define el valor de la propiedad faxRecipient.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setFaxRecipient(ContactAndAddress value) {
        this.faxRecipient = value;
    }

}
