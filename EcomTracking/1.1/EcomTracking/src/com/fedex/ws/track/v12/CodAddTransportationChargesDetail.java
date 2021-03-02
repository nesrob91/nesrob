
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CodAddTransportationChargesDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CodAddTransportationChargesDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RateTypeBasis" type="{http://fedex.com/ws/ship/v19}RateTypeBasisType" minOccurs="0"/>
 *         &lt;element name="ChargeBasis" type="{http://fedex.com/ws/ship/v19}CodAddTransportationChargeBasisType" minOccurs="0"/>
 *         &lt;element name="ChargeBasisLevel" type="{http://fedex.com/ws/ship/v19}ChargeBasisLevelType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodAddTransportationChargesDetail", propOrder = {
    "rateTypeBasis",
    "chargeBasis",
    "chargeBasisLevel"
})
public class CodAddTransportationChargesDetail {

    @XmlElement(name = "RateTypeBasis")
    protected RateTypeBasisType rateTypeBasis;
    @XmlElement(name = "ChargeBasis")
    protected CodAddTransportationChargeBasisType chargeBasis;
    @XmlElement(name = "ChargeBasisLevel")
    protected ChargeBasisLevelType chargeBasisLevel;

    /**
     * Obtiene el valor de la propiedad rateTypeBasis.
     * 
     * @return
     *     possible object is
     *     {@link RateTypeBasisType }
     *     
     */
    public RateTypeBasisType getRateTypeBasis() {
        return rateTypeBasis;
    }

    /**
     * Define el valor de la propiedad rateTypeBasis.
     * 
     * @param value
     *     allowed object is
     *     {@link RateTypeBasisType }
     *     
     */
    public void setRateTypeBasis(RateTypeBasisType value) {
        this.rateTypeBasis = value;
    }

    /**
     * Obtiene el valor de la propiedad chargeBasis.
     * 
     * @return
     *     possible object is
     *     {@link CodAddTransportationChargeBasisType }
     *     
     */
    public CodAddTransportationChargeBasisType getChargeBasis() {
        return chargeBasis;
    }

    /**
     * Define el valor de la propiedad chargeBasis.
     * 
     * @param value
     *     allowed object is
     *     {@link CodAddTransportationChargeBasisType }
     *     
     */
    public void setChargeBasis(CodAddTransportationChargeBasisType value) {
        this.chargeBasis = value;
    }

    /**
     * Obtiene el valor de la propiedad chargeBasisLevel.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBasisLevelType }
     *     
     */
    public ChargeBasisLevelType getChargeBasisLevel() {
        return chargeBasisLevel;
    }

    /**
     * Define el valor de la propiedad chargeBasisLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBasisLevelType }
     *     
     */
    public void setChargeBasisLevel(ChargeBasisLevelType value) {
        this.chargeBasisLevel = value;
    }

}
