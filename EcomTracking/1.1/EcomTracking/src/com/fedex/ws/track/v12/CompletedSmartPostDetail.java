
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides reply information specific to SmartPost shipments.
 * 
 * <p>Clase Java para CompletedSmartPostDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedSmartPostDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PickUpCarrier" type="{http://fedex.com/ws/ship/v19}CarrierCodeType" minOccurs="0"/>
 *         &lt;element name="Machinable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedSmartPostDetail", propOrder = {
    "pickUpCarrier",
    "machinable"
})
public class CompletedSmartPostDetail {

    @XmlElement(name = "PickUpCarrier")
    protected CarrierCodeType pickUpCarrier;
    @XmlElement(name = "Machinable")
    protected Boolean machinable;

    /**
     * Obtiene el valor de la propiedad pickUpCarrier.
     * 
     * @return
     *     possible object is
     *     {@link CarrierCodeType }
     *     
     */
    public CarrierCodeType getPickUpCarrier() {
        return pickUpCarrier;
    }

    /**
     * Define el valor de la propiedad pickUpCarrier.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierCodeType }
     *     
     */
    public void setPickUpCarrier(CarrierCodeType value) {
        this.pickUpCarrier = value;
    }

    /**
     * Obtiene el valor de la propiedad machinable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMachinable() {
        return machinable;
    }

    /**
     * Define el valor de la propiedad machinable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMachinable(Boolean value) {
        this.machinable = value;
    }

}
