
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackPayment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Classification" type="{http://fedex.com/ws/track/v12}TrackChargesPaymentClassificationType" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://fedex.com/ws/track/v12}TrackPaymentType" minOccurs="0"/>
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
@XmlType(name = "TrackPayment", propOrder = {
    "classification",
    "type",
    "description"
})
public class TrackPayment {

    @XmlElement(name = "Classification")
    protected TrackChargesPaymentClassificationType classification;
    @XmlElement(name = "Type")
    protected TrackPaymentType type;
    @XmlElement(name = "Description")
    protected String description;

    /**
     * Obtiene el valor de la propiedad classification.
     * 
     * @return
     *     possible object is
     *     {@link TrackChargesPaymentClassificationType }
     *     
     */
    public TrackChargesPaymentClassificationType getClassification() {
        return classification;
    }

    /**
     * Define el valor de la propiedad classification.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackChargesPaymentClassificationType }
     *     
     */
    public void setClassification(TrackChargesPaymentClassificationType value) {
        this.classification = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link TrackPaymentType }
     *     
     */
    public TrackPaymentType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPaymentType }
     *     
     */
    public void setType(TrackPaymentType value) {
        this.type = value;
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
