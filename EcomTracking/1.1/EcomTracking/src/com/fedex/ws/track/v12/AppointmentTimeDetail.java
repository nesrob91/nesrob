
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details about the appointment time window.
 * 
 * <p>Clase Java para AppointmentTimeDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AppointmentTimeDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/track/v12}AppointmentWindowType" minOccurs="0"/>
 *         &lt;element name="Window" type="{http://fedex.com/ws/track/v12}LocalTimeRange" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppointmentTimeDetail", propOrder = {
    "type",
    "window",
    "description"
})
public class AppointmentTimeDetail {

    @XmlElement(name = "Type")
    protected AppointmentWindowType type;
    @XmlElement(name = "Window")
    protected LocalTimeRange window;
    @XmlElement(name = "Description")
    protected String description;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link AppointmentWindowType }
     *     
     */
    public AppointmentWindowType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link AppointmentWindowType }
     *     
     */
    public void setType(AppointmentWindowType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad window.
     * 
     * @return
     *     possible object is
     *     {@link LocalTimeRange }
     *     
     */
    public LocalTimeRange getWindow() {
        return window;
    }

    /**
     * Define el valor de la propiedad window.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTimeRange }
     *     
     */
    public void setWindow(LocalTimeRange value) {
        this.window = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
