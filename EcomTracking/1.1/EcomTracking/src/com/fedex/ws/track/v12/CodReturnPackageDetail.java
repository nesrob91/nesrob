
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the information associated with a package that has COD special service in a ground shipment.
 * 
 * <p>Clase Java para CodReturnPackageDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CodReturnPackageDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CollectionAmount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="AdjustmentType" type="{http://fedex.com/ws/ship/v19}CodAdjustmentType" minOccurs="0"/>
 *         &lt;element name="Electronic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Barcodes" type="{http://fedex.com/ws/ship/v19}PackageBarcodes" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://fedex.com/ws/ship/v19}ShippingDocument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodReturnPackageDetail", propOrder = {
    "collectionAmount",
    "adjustmentType",
    "electronic",
    "barcodes",
    "label"
})
public class CodReturnPackageDetail {

    @XmlElement(name = "CollectionAmount")
    protected Money collectionAmount;
    @XmlElement(name = "AdjustmentType")
    protected CodAdjustmentType adjustmentType;
    @XmlElement(name = "Electronic")
    protected Boolean electronic;
    @XmlElement(name = "Barcodes")
    protected PackageBarcodes barcodes;
    @XmlElement(name = "Label")
    protected ShippingDocument label;

    /**
     * Obtiene el valor de la propiedad collectionAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCollectionAmount() {
        return collectionAmount;
    }

    /**
     * Define el valor de la propiedad collectionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCollectionAmount(Money value) {
        this.collectionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad adjustmentType.
     * 
     * @return
     *     possible object is
     *     {@link CodAdjustmentType }
     *     
     */
    public CodAdjustmentType getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * Define el valor de la propiedad adjustmentType.
     * 
     * @param value
     *     allowed object is
     *     {@link CodAdjustmentType }
     *     
     */
    public void setAdjustmentType(CodAdjustmentType value) {
        this.adjustmentType = value;
    }

    /**
     * Obtiene el valor de la propiedad electronic.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isElectronic() {
        return electronic;
    }

    /**
     * Define el valor de la propiedad electronic.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setElectronic(Boolean value) {
        this.electronic = value;
    }

    /**
     * Obtiene el valor de la propiedad barcodes.
     * 
     * @return
     *     possible object is
     *     {@link PackageBarcodes }
     *     
     */
    public PackageBarcodes getBarcodes() {
        return barcodes;
    }

    /**
     * Define el valor de la propiedad barcodes.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageBarcodes }
     *     
     */
    public void setBarcodes(PackageBarcodes value) {
        this.barcodes = value;
    }

    /**
     * Obtiene el valor de la propiedad label.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocument }
     *     
     */
    public ShippingDocument getLabel() {
        return label;
    }

    /**
     * Define el valor de la propiedad label.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocument }
     *     
     */
    public void setLabel(ShippingDocument value) {
        this.label = value;
    }

}
