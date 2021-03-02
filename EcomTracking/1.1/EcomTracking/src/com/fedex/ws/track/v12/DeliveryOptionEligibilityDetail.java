
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details about the eligibility for a delivery option.
 * 
 * <p>Clase Java para DeliveryOptionEligibilityDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DeliveryOptionEligibilityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Option" type="{http://fedex.com/ws/track/v12}DeliveryOptionType" minOccurs="0"/>
 *         &lt;element name="Eligibility" type="{http://fedex.com/ws/track/v12}EligibilityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryOptionEligibilityDetail", propOrder = {
    "option",
    "eligibility"
})
public class DeliveryOptionEligibilityDetail {

    @XmlElement(name = "Option")
    protected DeliveryOptionType option;
    @XmlElement(name = "Eligibility")
    protected EligibilityType eligibility;

    /**
     * Obtiene el valor de la propiedad option.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryOptionType }
     *     
     */
    public DeliveryOptionType getOption() {
        return option;
    }

    /**
     * Define el valor de la propiedad option.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryOptionType }
     *     
     */
    public void setOption(DeliveryOptionType value) {
        this.option = value;
    }

    /**
     * Obtiene el valor de la propiedad eligibility.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityType }
     *     
     */
    public EligibilityType getEligibility() {
        return eligibility;
    }

    /**
     * Define el valor de la propiedad eligibility.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityType }
     *     
     */
    public void setEligibility(EligibilityType value) {
        this.eligibility = value;
    }

}
