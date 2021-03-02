
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackingDateOrTimestamp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackingDateOrTimestamp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/track/v12}TrackingDateOrTimestampType" minOccurs="0"/>
 *         &lt;element name="DateOrTimestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackingDateOrTimestamp", propOrder = {
    "type",
    "dateOrTimestamp"
})
public class TrackingDateOrTimestamp {

    @XmlElement(name = "Type")
    protected TrackingDateOrTimestampType type;
    @XmlElement(name = "DateOrTimestamp")
    protected String dateOrTimestamp;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link TrackingDateOrTimestampType }
     *     
     */
    public TrackingDateOrTimestampType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingDateOrTimestampType }
     *     
     */
    public void setType(TrackingDateOrTimestampType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad dateOrTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOrTimestamp() {
        return dateOrTimestamp;
    }

    /**
     * Define el valor de la propiedad dateOrTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOrTimestamp(String value) {
        this.dateOrTimestamp = value;
    }

}
