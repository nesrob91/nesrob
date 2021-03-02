
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Surcharge complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Surcharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SurchargeType" type="{http://fedex.com/ws/ship/v19}SurchargeType" minOccurs="0"/>
 *         &lt;element name="Level" type="{http://fedex.com/ws/ship/v19}SurchargeLevelType" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://fedex.com/ws/ship/v19}Money"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Surcharge", propOrder = {
    "surchargeType",
    "level",
    "description",
    "amount"
})
public class Surcharge {

    @XmlElement(name = "SurchargeType")
    protected SurchargeType surchargeType;
    @XmlElement(name = "Level")
    protected SurchargeLevelType level;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Amount", required = true)
    protected Money amount;

    /**
     * Obtiene el valor de la propiedad surchargeType.
     * 
     * @return
     *     possible object is
     *     {@link SurchargeType }
     *     
     */
    public SurchargeType getSurchargeType() {
        return surchargeType;
    }

    /**
     * Define el valor de la propiedad surchargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link SurchargeType }
     *     
     */
    public void setSurchargeType(SurchargeType value) {
        this.surchargeType = value;
    }

    /**
     * Obtiene el valor de la propiedad level.
     * 
     * @return
     *     possible object is
     *     {@link SurchargeLevelType }
     *     
     */
    public SurchargeLevelType getLevel() {
        return level;
    }

    /**
     * Define el valor de la propiedad level.
     * 
     * @param value
     *     allowed object is
     *     {@link SurchargeLevelType }
     *     
     */
    public void setLevel(SurchargeLevelType value) {
        this.level = value;
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

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAmount(Money value) {
        this.amount = value;
    }

}
