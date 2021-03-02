
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShipmentManifestDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentManifestDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ManifestReferenceType" type="{http://fedex.com/ws/ship/v19}CustomerReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentManifestDetail", propOrder = {
    "manifestReferenceType"
})
public class ShipmentManifestDetail {

    @XmlElement(name = "ManifestReferenceType")
    protected CustomerReferenceType manifestReferenceType;

    /**
     * Obtiene el valor de la propiedad manifestReferenceType.
     * 
     * @return
     *     possible object is
     *     {@link CustomerReferenceType }
     *     
     */
    public CustomerReferenceType getManifestReferenceType() {
        return manifestReferenceType;
    }

    /**
     * Define el valor de la propiedad manifestReferenceType.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerReferenceType }
     *     
     */
    public void setManifestReferenceType(CustomerReferenceType value) {
        this.manifestReferenceType = value;
    }

}
