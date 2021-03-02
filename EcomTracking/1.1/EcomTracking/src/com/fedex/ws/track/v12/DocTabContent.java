
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DocTabContent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DocTabContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocTabContentType" type="{http://fedex.com/ws/ship/v19}DocTabContentType"/>
 *         &lt;element name="Zone001" type="{http://fedex.com/ws/ship/v19}DocTabContentZone001" minOccurs="0"/>
 *         &lt;element name="Barcoded" type="{http://fedex.com/ws/ship/v19}DocTabContentBarcoded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocTabContent", propOrder = {
    "docTabContentType",
    "zone001",
    "barcoded"
})
public class DocTabContent {

    @XmlElement(name = "DocTabContentType", required = true)
    protected DocTabContentType docTabContentType;
    @XmlElement(name = "Zone001")
    protected DocTabContentZone001 zone001;
    @XmlElement(name = "Barcoded")
    protected DocTabContentBarcoded barcoded;

    /**
     * Obtiene el valor de la propiedad docTabContentType.
     * 
     * @return
     *     possible object is
     *     {@link DocTabContentType }
     *     
     */
    public DocTabContentType getDocTabContentType() {
        return docTabContentType;
    }

    /**
     * Define el valor de la propiedad docTabContentType.
     * 
     * @param value
     *     allowed object is
     *     {@link DocTabContentType }
     *     
     */
    public void setDocTabContentType(DocTabContentType value) {
        this.docTabContentType = value;
    }

    /**
     * Obtiene el valor de la propiedad zone001.
     * 
     * @return
     *     possible object is
     *     {@link DocTabContentZone001 }
     *     
     */
    public DocTabContentZone001 getZone001() {
        return zone001;
    }

    /**
     * Define el valor de la propiedad zone001.
     * 
     * @param value
     *     allowed object is
     *     {@link DocTabContentZone001 }
     *     
     */
    public void setZone001(DocTabContentZone001 value) {
        this.zone001 = value;
    }

    /**
     * Obtiene el valor de la propiedad barcoded.
     * 
     * @return
     *     possible object is
     *     {@link DocTabContentBarcoded }
     *     
     */
    public DocTabContentBarcoded getBarcoded() {
        return barcoded;
    }

    /**
     * Define el valor de la propiedad barcoded.
     * 
     * @param value
     *     allowed object is
     *     {@link DocTabContentBarcoded }
     *     
     */
    public void setBarcoded(DocTabContentBarcoded value) {
        this.barcoded = value;
    }

}
