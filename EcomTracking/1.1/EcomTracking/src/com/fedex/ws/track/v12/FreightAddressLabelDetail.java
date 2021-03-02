
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Data required to produce the Freight handling-unit-level address labels. Note that the number of UNIQUE labels (the N as in 1 of N, 2 of N, etc.) is determined by total handling units.
 * 
 * <p>Clase Java para FreightAddressLabelDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FreightAddressLabelDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://fedex.com/ws/ship/v19}ShippingDocumentFormat" minOccurs="0"/>
 *         &lt;element name="Copies" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="StartingPosition" type="{http://fedex.com/ws/ship/v19}PageQuadrantType" minOccurs="0"/>
 *         &lt;element name="DocTabContent" type="{http://fedex.com/ws/ship/v19}DocTabContent" minOccurs="0"/>
 *         &lt;element name="CustomContentPosition" type="{http://fedex.com/ws/ship/v19}RelativeVerticalPositionType" minOccurs="0"/>
 *         &lt;element name="CustomContent" type="{http://fedex.com/ws/ship/v19}CustomLabelDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightAddressLabelDetail", propOrder = {
    "format",
    "copies",
    "startingPosition",
    "docTabContent",
    "customContentPosition",
    "customContent"
})
public class FreightAddressLabelDetail {

    @XmlElement(name = "Format")
    protected ShippingDocumentFormat format;
    @XmlElement(name = "Copies")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger copies;
    @XmlElement(name = "StartingPosition")
    protected PageQuadrantType startingPosition;
    @XmlElement(name = "DocTabContent")
    protected DocTabContent docTabContent;
    @XmlElement(name = "CustomContentPosition")
    protected RelativeVerticalPositionType customContentPosition;
    @XmlElement(name = "CustomContent")
    protected CustomLabelDetail customContent;

    /**
     * Obtiene el valor de la propiedad format.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentFormat }
     *     
     */
    public ShippingDocumentFormat getFormat() {
        return format;
    }

    /**
     * Define el valor de la propiedad format.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentFormat }
     *     
     */
    public void setFormat(ShippingDocumentFormat value) {
        this.format = value;
    }

    /**
     * Obtiene el valor de la propiedad copies.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCopies() {
        return copies;
    }

    /**
     * Define el valor de la propiedad copies.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCopies(BigInteger value) {
        this.copies = value;
    }

    /**
     * Obtiene el valor de la propiedad startingPosition.
     * 
     * @return
     *     possible object is
     *     {@link PageQuadrantType }
     *     
     */
    public PageQuadrantType getStartingPosition() {
        return startingPosition;
    }

    /**
     * Define el valor de la propiedad startingPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link PageQuadrantType }
     *     
     */
    public void setStartingPosition(PageQuadrantType value) {
        this.startingPosition = value;
    }

    /**
     * Obtiene el valor de la propiedad docTabContent.
     * 
     * @return
     *     possible object is
     *     {@link DocTabContent }
     *     
     */
    public DocTabContent getDocTabContent() {
        return docTabContent;
    }

    /**
     * Define el valor de la propiedad docTabContent.
     * 
     * @param value
     *     allowed object is
     *     {@link DocTabContent }
     *     
     */
    public void setDocTabContent(DocTabContent value) {
        this.docTabContent = value;
    }

    /**
     * Obtiene el valor de la propiedad customContentPosition.
     * 
     * @return
     *     possible object is
     *     {@link RelativeVerticalPositionType }
     *     
     */
    public RelativeVerticalPositionType getCustomContentPosition() {
        return customContentPosition;
    }

    /**
     * Define el valor de la propiedad customContentPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeVerticalPositionType }
     *     
     */
    public void setCustomContentPosition(RelativeVerticalPositionType value) {
        this.customContentPosition = value;
    }

    /**
     * Obtiene el valor de la propiedad customContent.
     * 
     * @return
     *     possible object is
     *     {@link CustomLabelDetail }
     *     
     */
    public CustomLabelDetail getCustomContent() {
        return customContent;
    }

    /**
     * Define el valor de la propiedad customContent.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomLabelDetail }
     *     
     */
    public void setCustomContent(CustomLabelDetail value) {
        this.customContent = value;
    }

}
