
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackChargeDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackChargeDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/track/v12}TrackChargeDetailType" minOccurs="0"/>
 *         &lt;element name="ChargeAmount" type="{http://fedex.com/ws/track/v12}Money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackChargeDetail", propOrder = {
    "type",
    "chargeAmount"
})
public class TrackChargeDetail {

    @XmlElement(name = "Type")
    protected TrackChargeDetailType type;
    @XmlElement(name = "ChargeAmount")
    protected Money chargeAmount;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link TrackChargeDetailType }
     *     
     */
    public TrackChargeDetailType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackChargeDetailType }
     *     
     */
    public void setType(TrackChargeDetailType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad chargeAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getChargeAmount() {
        return chargeAmount;
    }

    /**
     * Define el valor de la propiedad chargeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setChargeAmount(Money value) {
        this.chargeAmount = value;
    }

}
