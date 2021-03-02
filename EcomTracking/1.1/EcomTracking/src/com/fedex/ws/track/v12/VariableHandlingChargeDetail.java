
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This definition of variable handling charge detail is intended for use in Jan 2011 corp load.
 * 
 * <p>Clase Java para VariableHandlingChargeDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VariableHandlingChargeDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FixedValue" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="PercentValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RateElementBasis" type="{http://fedex.com/ws/ship/v19}RateElementBasisType" minOccurs="0"/>
 *         &lt;element name="RateTypeBasis" type="{http://fedex.com/ws/ship/v19}RateTypeBasisType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableHandlingChargeDetail", propOrder = {
    "fixedValue",
    "percentValue",
    "rateElementBasis",
    "rateTypeBasis"
})
public class VariableHandlingChargeDetail {

    @XmlElement(name = "FixedValue")
    protected Money fixedValue;
    @XmlElement(name = "PercentValue")
    protected BigDecimal percentValue;
    @XmlElement(name = "RateElementBasis")
    protected RateElementBasisType rateElementBasis;
    @XmlElement(name = "RateTypeBasis")
    protected RateTypeBasisType rateTypeBasis;

    /**
     * Obtiene el valor de la propiedad fixedValue.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFixedValue() {
        return fixedValue;
    }

    /**
     * Define el valor de la propiedad fixedValue.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFixedValue(Money value) {
        this.fixedValue = value;
    }

    /**
     * Obtiene el valor de la propiedad percentValue.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentValue() {
        return percentValue;
    }

    /**
     * Define el valor de la propiedad percentValue.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentValue(BigDecimal value) {
        this.percentValue = value;
    }

    /**
     * Obtiene el valor de la propiedad rateElementBasis.
     * 
     * @return
     *     possible object is
     *     {@link RateElementBasisType }
     *     
     */
    public RateElementBasisType getRateElementBasis() {
        return rateElementBasis;
    }

    /**
     * Define el valor de la propiedad rateElementBasis.
     * 
     * @param value
     *     allowed object is
     *     {@link RateElementBasisType }
     *     
     */
    public void setRateElementBasis(RateElementBasisType value) {
        this.rateElementBasis = value;
    }

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

}
