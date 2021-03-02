
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides reply information specific to a tag request.
 * 
 * <p>Clase Java para CompletedTagDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedTagDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfirmationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AccessTime" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="CutoffTime" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryCommitment" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DispatchDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedTagDetail", propOrder = {
    "confirmationNumber",
    "accessTime",
    "cutoffTime",
    "location",
    "deliveryCommitment",
    "dispatchDate"
})
public class CompletedTagDetail {

    @XmlElement(name = "ConfirmationNumber", required = true)
    protected String confirmationNumber;
    @XmlElement(name = "AccessTime")
    protected Duration accessTime;
    @XmlElement(name = "CutoffTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar cutoffTime;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "DeliveryCommitment")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryCommitment;
    @XmlElement(name = "DispatchDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dispatchDate;

    /**
     * Obtiene el valor de la propiedad confirmationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * Define el valor de la propiedad confirmationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationNumber(String value) {
        this.confirmationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad accessTime.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getAccessTime() {
        return accessTime;
    }

    /**
     * Define el valor de la propiedad accessTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setAccessTime(Duration value) {
        this.accessTime = value;
    }

    /**
     * Obtiene el valor de la propiedad cutoffTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCutoffTime() {
        return cutoffTime;
    }

    /**
     * Define el valor de la propiedad cutoffTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCutoffTime(XMLGregorianCalendar value) {
        this.cutoffTime = value;
    }

    /**
     * Obtiene el valor de la propiedad location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define el valor de la propiedad location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryCommitment.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryCommitment() {
        return deliveryCommitment;
    }

    /**
     * Define el valor de la propiedad deliveryCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryCommitment(XMLGregorianCalendar value) {
        this.deliveryCommitment = value;
    }

    /**
     * Obtiene el valor de la propiedad dispatchDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDispatchDate() {
        return dispatchDate;
    }

    /**
     * Define el valor de la propiedad dispatchDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDispatchDate(XMLGregorianCalendar value) {
        this.dispatchDate = value;
    }

}
