
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies details for a package containing alcohol
 * 
 * <p>Clase Java para AlcoholDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AlcoholDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecipientType" type="{http://fedex.com/ws/ship/v19}AlcoholRecipientType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlcoholDetail", propOrder = {
    "recipientType"
})
public class AlcoholDetail {

    @XmlElement(name = "RecipientType")
    protected AlcoholRecipientType recipientType;

    /**
     * Obtiene el valor de la propiedad recipientType.
     * 
     * @return
     *     possible object is
     *     {@link AlcoholRecipientType }
     *     
     */
    public AlcoholRecipientType getRecipientType() {
        return recipientType;
    }

    /**
     * Define el valor de la propiedad recipientType.
     * 
     * @param value
     *     allowed object is
     *     {@link AlcoholRecipientType }
     *     
     */
    public void setRecipientType(AlcoholRecipientType value) {
        this.recipientType = value;
    }

}
