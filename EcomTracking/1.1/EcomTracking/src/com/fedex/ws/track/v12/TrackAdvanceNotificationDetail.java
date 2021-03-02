
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TrackAdvanceNotificationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackAdvanceNotificationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EstimatedTimeOfArrival" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://fedex.com/ws/track/v12}TrackAdvanceNotificationStatusType" minOccurs="0"/>
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackAdvanceNotificationDetail", propOrder = {
    "estimatedTimeOfArrival",
    "reason",
    "status",
    "statusDescription",
    "statusTime"
})
public class TrackAdvanceNotificationDetail {

    @XmlElement(name = "EstimatedTimeOfArrival")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedTimeOfArrival;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "Status")
    protected TrackAdvanceNotificationStatusType status;
    @XmlElement(name = "StatusDescription")
    protected String statusDescription;
    @XmlElement(name = "StatusTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusTime;

    /**
     * Obtiene el valor de la propiedad estimatedTimeOfArrival.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    /**
     * Define el valor de la propiedad estimatedTimeOfArrival.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedTimeOfArrival(XMLGregorianCalendar value) {
        this.estimatedTimeOfArrival = value;
    }

    /**
     * Obtiene el valor de la propiedad reason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Define el valor de la propiedad reason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link TrackAdvanceNotificationStatusType }
     *     
     */
    public TrackAdvanceNotificationStatusType getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackAdvanceNotificationStatusType }
     *     
     */
    public void setStatus(TrackAdvanceNotificationStatusType value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad statusDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Define el valor de la propiedad statusDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad statusTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusTime() {
        return statusTime;
    }

    /**
     * Define el valor de la propiedad statusTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusTime(XMLGregorianCalendar value) {
        this.statusTime = value;
    }

}
