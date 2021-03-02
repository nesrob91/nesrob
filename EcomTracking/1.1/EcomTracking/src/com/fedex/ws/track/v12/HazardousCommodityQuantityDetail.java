
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies amount and units for quantity of hazardous commodities.
 * 
 * <p>Clase Java para HazardousCommodityQuantityDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HazardousCommodityQuantityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuantityType" type="{http://fedex.com/ws/ship/v19}HazardousCommodityQuantityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousCommodityQuantityDetail", propOrder = {
    "amount",
    "units",
    "quantityType"
})
public class HazardousCommodityQuantityDetail {

    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "Units")
    protected String units;
    @XmlElement(name = "QuantityType")
    protected HazardousCommodityQuantityType quantityType;

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad units.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Define el valor de la propiedad units.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Obtiene el valor de la propiedad quantityType.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityQuantityType }
     *     
     */
    public HazardousCommodityQuantityType getQuantityType() {
        return quantityType;
    }

    /**
     * Define el valor de la propiedad quantityType.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityQuantityType }
     *     
     */
    public void setQuantityType(HazardousCommodityQuantityType value) {
        this.quantityType = value;
    }

}
