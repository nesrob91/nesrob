
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This class describes the pickup characteristics of a shipment (e.g. for use in a tag request).
 * 
 * <p>Clase Java para PickupDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PickupDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReadyDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LatestPickupDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CourierInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequestType" type="{http://fedex.com/ws/ship/v19}PickupRequestType" minOccurs="0"/>
 *         &lt;element name="RequestSource" type="{http://fedex.com/ws/ship/v19}PickupRequestSourceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PickupDetail", propOrder = {
    "readyDateTime",
    "latestPickupDateTime",
    "courierInstructions",
    "requestType",
    "requestSource"
})
public class PickupDetail {

    @XmlElement(name = "ReadyDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar readyDateTime;
    @XmlElement(name = "LatestPickupDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestPickupDateTime;
    @XmlElement(name = "CourierInstructions")
    protected String courierInstructions;
    @XmlElement(name = "RequestType")
    protected PickupRequestType requestType;
    @XmlElement(name = "RequestSource")
    protected PickupRequestSourceType requestSource;

    /**
     * Obtiene el valor de la propiedad readyDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReadyDateTime() {
        return readyDateTime;
    }

    /**
     * Define el valor de la propiedad readyDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReadyDateTime(XMLGregorianCalendar value) {
        this.readyDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad latestPickupDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestPickupDateTime() {
        return latestPickupDateTime;
    }

    /**
     * Define el valor de la propiedad latestPickupDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestPickupDateTime(XMLGregorianCalendar value) {
        this.latestPickupDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad courierInstructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourierInstructions() {
        return courierInstructions;
    }

    /**
     * Define el valor de la propiedad courierInstructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourierInstructions(String value) {
        this.courierInstructions = value;
    }

    /**
     * Obtiene el valor de la propiedad requestType.
     * 
     * @return
     *     possible object is
     *     {@link PickupRequestType }
     *     
     */
    public PickupRequestType getRequestType() {
        return requestType;
    }

    /**
     * Define el valor de la propiedad requestType.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupRequestType }
     *     
     */
    public void setRequestType(PickupRequestType value) {
        this.requestType = value;
    }

    /**
     * Obtiene el valor de la propiedad requestSource.
     * 
     * @return
     *     possible object is
     *     {@link PickupRequestSourceType }
     *     
     */
    public PickupRequestSourceType getRequestSource() {
        return requestSource;
    }

    /**
     * Define el valor de la propiedad requestSource.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupRequestSourceType }
     *     
     */
    public void setRequestSource(PickupRequestSourceType value) {
        this.requestSource = value;
    }

}
