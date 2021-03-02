
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Individual charge which contributes to the total base charge for the shipment.
 * 
 * <p>Clase Java para FreightBaseCharge complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FreightBaseCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FreightClass" type="{http://fedex.com/ws/ship/v19}FreightClassType" minOccurs="0"/>
 *         &lt;element name="RatedAsClass" type="{http://fedex.com/ws/ship/v19}FreightClassType" minOccurs="0"/>
 *         &lt;element name="NmfcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="ChargeRate" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="ChargeBasis" type="{http://fedex.com/ws/ship/v19}FreightChargeBasisType" minOccurs="0"/>
 *         &lt;element name="ExtendedAmount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightBaseCharge", propOrder = {
    "freightClass",
    "ratedAsClass",
    "nmfcCode",
    "description",
    "weight",
    "chargeRate",
    "chargeBasis",
    "extendedAmount"
})
public class FreightBaseCharge {

    @XmlElement(name = "FreightClass")
    protected FreightClassType freightClass;
    @XmlElement(name = "RatedAsClass")
    protected FreightClassType ratedAsClass;
    @XmlElement(name = "NmfcCode")
    protected String nmfcCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Weight")
    protected Weight weight;
    @XmlElement(name = "ChargeRate")
    protected Money chargeRate;
    @XmlElement(name = "ChargeBasis")
    protected FreightChargeBasisType chargeBasis;
    @XmlElement(name = "ExtendedAmount")
    protected Money extendedAmount;

    /**
     * Obtiene el valor de la propiedad freightClass.
     * 
     * @return
     *     possible object is
     *     {@link FreightClassType }
     *     
     */
    public FreightClassType getFreightClass() {
        return freightClass;
    }

    /**
     * Define el valor de la propiedad freightClass.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightClassType }
     *     
     */
    public void setFreightClass(FreightClassType value) {
        this.freightClass = value;
    }

    /**
     * Obtiene el valor de la propiedad ratedAsClass.
     * 
     * @return
     *     possible object is
     *     {@link FreightClassType }
     *     
     */
    public FreightClassType getRatedAsClass() {
        return ratedAsClass;
    }

    /**
     * Define el valor de la propiedad ratedAsClass.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightClassType }
     *     
     */
    public void setRatedAsClass(FreightClassType value) {
        this.ratedAsClass = value;
    }

    /**
     * Obtiene el valor de la propiedad nmfcCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNmfcCode() {
        return nmfcCode;
    }

    /**
     * Define el valor de la propiedad nmfcCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNmfcCode(String value) {
        this.nmfcCode = value;
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
     * Obtiene el valor de la propiedad weight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setWeight(Weight value) {
        this.weight = value;
    }

    /**
     * Obtiene el valor de la propiedad chargeRate.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getChargeRate() {
        return chargeRate;
    }

    /**
     * Define el valor de la propiedad chargeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setChargeRate(Money value) {
        this.chargeRate = value;
    }

    /**
     * Obtiene el valor de la propiedad chargeBasis.
     * 
     * @return
     *     possible object is
     *     {@link FreightChargeBasisType }
     *     
     */
    public FreightChargeBasisType getChargeBasis() {
        return chargeBasis;
    }

    /**
     * Define el valor de la propiedad chargeBasis.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightChargeBasisType }
     *     
     */
    public void setChargeBasis(FreightChargeBasisType value) {
        this.chargeBasis = value;
    }

    /**
     * Obtiene el valor de la propiedad extendedAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getExtendedAmount() {
        return extendedAmount;
    }

    /**
     * Define el valor de la propiedad extendedAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setExtendedAmount(Money value) {
        this.extendedAmount = value;
    }

}
