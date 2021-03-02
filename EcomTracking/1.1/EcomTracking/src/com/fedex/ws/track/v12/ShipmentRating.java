
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class groups together all shipment-level rate data (across all rate types) as part of the response to a shipping request, which groups shipment-level data together and groups package-level data by package.
 * 
 * <p>Clase Java para ShipmentRating complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentRating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActualRateType" type="{http://fedex.com/ws/ship/v19}ReturnedRateType" minOccurs="0"/>
 *         &lt;element name="EffectiveNetDiscount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="ShipmentRateDetails" type="{http://fedex.com/ws/ship/v19}ShipmentRateDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentRating", propOrder = {
    "actualRateType",
    "effectiveNetDiscount",
    "shipmentRateDetails"
})
public class ShipmentRating {

    @XmlElement(name = "ActualRateType")
    protected ReturnedRateType actualRateType;
    @XmlElement(name = "EffectiveNetDiscount")
    protected Money effectiveNetDiscount;
    @XmlElement(name = "ShipmentRateDetails")
    protected List<ShipmentRateDetail> shipmentRateDetails;

    /**
     * Obtiene el valor de la propiedad actualRateType.
     * 
     * @return
     *     possible object is
     *     {@link ReturnedRateType }
     *     
     */
    public ReturnedRateType getActualRateType() {
        return actualRateType;
    }

    /**
     * Define el valor de la propiedad actualRateType.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnedRateType }
     *     
     */
    public void setActualRateType(ReturnedRateType value) {
        this.actualRateType = value;
    }

    /**
     * Obtiene el valor de la propiedad effectiveNetDiscount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getEffectiveNetDiscount() {
        return effectiveNetDiscount;
    }

    /**
     * Define el valor de la propiedad effectiveNetDiscount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setEffectiveNetDiscount(Money value) {
        this.effectiveNetDiscount = value;
    }

    /**
     * Gets the value of the shipmentRateDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentRateDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentRateDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentRateDetail }
     * 
     * 
     */
    public List<ShipmentRateDetail> getShipmentRateDetails() {
        if (shipmentRateDetails == null) {
            shipmentRateDetails = new ArrayList<ShipmentRateDetail>();
        }
        return this.shipmentRateDetails;
    }

}
