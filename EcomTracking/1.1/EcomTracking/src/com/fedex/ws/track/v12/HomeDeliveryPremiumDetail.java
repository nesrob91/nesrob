
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para HomeDeliveryPremiumDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HomeDeliveryPremiumDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HomeDeliveryPremiumType" type="{http://fedex.com/ws/ship/v19}HomeDeliveryPremiumType"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HomeDeliveryPremiumDetail", propOrder = {
    "homeDeliveryPremiumType",
    "date",
    "phoneNumber"
})
public class HomeDeliveryPremiumDetail {

    @XmlElement(name = "HomeDeliveryPremiumType", required = true)
    protected HomeDeliveryPremiumType homeDeliveryPremiumType;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;

    /**
     * Obtiene el valor de la propiedad homeDeliveryPremiumType.
     * 
     * @return
     *     possible object is
     *     {@link HomeDeliveryPremiumType }
     *     
     */
    public HomeDeliveryPremiumType getHomeDeliveryPremiumType() {
        return homeDeliveryPremiumType;
    }

    /**
     * Define el valor de la propiedad homeDeliveryPremiumType.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeDeliveryPremiumType }
     *     
     */
    public void setHomeDeliveryPremiumType(HomeDeliveryPremiumType value) {
        this.homeDeliveryPremiumType = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define el valor de la propiedad phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

}
