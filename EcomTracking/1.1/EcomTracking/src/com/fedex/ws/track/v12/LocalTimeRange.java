
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Time Range specified in local time.
 * 
 * <p>Clase Java para LocalTimeRange complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocalTimeRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Begins" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ends" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalTimeRange", propOrder = {
    "begins",
    "ends"
})
public class LocalTimeRange {

    @XmlElement(name = "Begins")
    protected String begins;
    @XmlElement(name = "Ends")
    protected String ends;

    /**
     * Obtiene el valor de la propiedad begins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBegins() {
        return begins;
    }

    /**
     * Define el valor de la propiedad begins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegins(String value) {
        this.begins = value;
    }

    /**
     * Obtiene el valor de la propiedad ends.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnds() {
        return ends;
    }

    /**
     * Define el valor de la propiedad ends.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnds(String value) {
        this.ends = value;
    }

}
