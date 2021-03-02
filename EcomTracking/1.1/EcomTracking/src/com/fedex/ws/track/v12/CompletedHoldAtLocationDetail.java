
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CompletedHoldAtLocationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedHoldAtLocationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HoldingLocation" type="{http://fedex.com/ws/ship/v19}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="HoldingLocationType" type="{http://fedex.com/ws/ship/v19}FedExLocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedHoldAtLocationDetail", propOrder = {
    "holdingLocation",
    "holdingLocationType"
})
public class CompletedHoldAtLocationDetail {

    @XmlElement(name = "HoldingLocation")
    protected ContactAndAddress holdingLocation;
    @XmlElement(name = "HoldingLocationType")
    protected FedExLocationType holdingLocationType;

    /**
     * Obtiene el valor de la propiedad holdingLocation.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getHoldingLocation() {
        return holdingLocation;
    }

    /**
     * Define el valor de la propiedad holdingLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setHoldingLocation(ContactAndAddress value) {
        this.holdingLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad holdingLocationType.
     * 
     * @return
     *     possible object is
     *     {@link FedExLocationType }
     *     
     */
    public FedExLocationType getHoldingLocationType() {
        return holdingLocationType;
    }

    /**
     * Define el valor de la propiedad holdingLocationType.
     * 
     * @param value
     *     allowed object is
     *     {@link FedExLocationType }
     *     
     */
    public void setHoldingLocationType(FedExLocationType value) {
        this.holdingLocationType = value;
    }

}
