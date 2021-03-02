
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SendNotificationsRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SendNotificationsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebAuthenticationDetail" type="{http://fedex.com/ws/track/v12}WebAuthenticationDetail"/>
 *         &lt;element name="ClientDetail" type="{http://fedex.com/ws/track/v12}ClientDetail"/>
 *         &lt;element name="TransactionDetail" type="{http://fedex.com/ws/track/v12}TransactionDetail" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://fedex.com/ws/track/v12}VersionId"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MultiPiece" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PagingToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingNumberUniqueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipDateRangeBegin" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ShipDateRangeEnd" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SenderEMailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SenderContactName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EventNotificationDetail" type="{http://fedex.com/ws/track/v12}ShipmentEventNotificationDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendNotificationsRequest", propOrder = {
    "webAuthenticationDetail",
    "clientDetail",
    "transactionDetail",
    "version",
    "trackingNumber",
    "multiPiece",
    "pagingToken",
    "trackingNumberUniqueId",
    "shipDateRangeBegin",
    "shipDateRangeEnd",
    "senderEMailAddress",
    "senderContactName",
    "eventNotificationDetail"
})
public class SendNotificationsRequest {

    @XmlElement(name = "WebAuthenticationDetail", required = true)
    protected WebAuthenticationDetail webAuthenticationDetail;
    @XmlElement(name = "ClientDetail", required = true)
    protected ClientDetail clientDetail;
    @XmlElement(name = "TransactionDetail")
    protected TransactionDetail transactionDetail;
    @XmlElement(name = "Version", required = true)
    protected VersionId version;
    @XmlElement(name = "TrackingNumber", required = true)
    protected String trackingNumber;
    @XmlElement(name = "MultiPiece")
    protected Boolean multiPiece;
    @XmlElement(name = "PagingToken")
    protected String pagingToken;
    @XmlElement(name = "TrackingNumberUniqueId")
    protected String trackingNumberUniqueId;
    @XmlElement(name = "ShipDateRangeBegin")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shipDateRangeBegin;
    @XmlElement(name = "ShipDateRangeEnd")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shipDateRangeEnd;
    @XmlElement(name = "SenderEMailAddress")
    protected String senderEMailAddress;
    @XmlElement(name = "SenderContactName", required = true)
    protected String senderContactName;
    @XmlElement(name = "EventNotificationDetail")
    protected ShipmentEventNotificationDetail eventNotificationDetail;

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
     * Obtiene el valor de la propiedad trackingNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Define el valor de la propiedad trackingNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad multiPiece.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultiPiece() {
        return multiPiece;
    }

    /**
     * Define el valor de la propiedad multiPiece.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultiPiece(Boolean value) {
        this.multiPiece = value;
    }

    /**
     * Obtiene el valor de la propiedad pagingToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagingToken() {
        return pagingToken;
    }

    /**
     * Define el valor de la propiedad pagingToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagingToken(String value) {
        this.pagingToken = value;
    }

    /**
     * Obtiene el valor de la propiedad trackingNumberUniqueId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumberUniqueId() {
        return trackingNumberUniqueId;
    }

    /**
     * Define el valor de la propiedad trackingNumberUniqueId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumberUniqueId(String value) {
        this.trackingNumberUniqueId = value;
    }

    /**
     * Obtiene el valor de la propiedad shipDateRangeBegin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipDateRangeBegin() {
        return shipDateRangeBegin;
    }

    /**
     * Define el valor de la propiedad shipDateRangeBegin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipDateRangeBegin(XMLGregorianCalendar value) {
        this.shipDateRangeBegin = value;
    }

    /**
     * Obtiene el valor de la propiedad shipDateRangeEnd.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipDateRangeEnd() {
        return shipDateRangeEnd;
    }

    /**
     * Define el valor de la propiedad shipDateRangeEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipDateRangeEnd(XMLGregorianCalendar value) {
        this.shipDateRangeEnd = value;
    }

    /**
     * Obtiene el valor de la propiedad senderEMailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderEMailAddress() {
        return senderEMailAddress;
    }

    /**
     * Define el valor de la propiedad senderEMailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderEMailAddress(String value) {
        this.senderEMailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad senderContactName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderContactName() {
        return senderContactName;
    }

    /**
     * Define el valor de la propiedad senderContactName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderContactName(String value) {
        this.senderContactName = value;
    }

    /**
     * Obtiene el valor de la propiedad eventNotificationDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentEventNotificationDetail }
     *     
     */
    public ShipmentEventNotificationDetail getEventNotificationDetail() {
        return eventNotificationDetail;
    }

    /**
     * Define el valor de la propiedad eventNotificationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentEventNotificationDetail }
     *     
     */
    public void setEventNotificationDetail(ShipmentEventNotificationDetail value) {
        this.eventNotificationDetail = value;
    }

}
