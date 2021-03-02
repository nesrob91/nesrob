
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Description of an individual commodity or class of content in a shipment.
 * 
 * <p>Clase Java para FreightShipmentLineItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FreightShipmentLineItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FreightClass" type="{http://fedex.com/ws/ship/v19}FreightClassType" minOccurs="0"/>
 *         &lt;element name="ClassProvidedByCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HandlingUnits" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Packaging" type="{http://fedex.com/ws/ship/v19}PhysicalPackagingType" minOccurs="0"/>
 *         &lt;element name="Pieces" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="NmfcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HazardousMaterials" type="{http://fedex.com/ws/ship/v19}HazardousCommodityOptionType" minOccurs="0"/>
 *         &lt;element name="PurchaseOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="Dimensions" type="{http://fedex.com/ws/ship/v19}Dimensions" minOccurs="0"/>
 *         &lt;element name="Volume" type="{http://fedex.com/ws/ship/v19}Volume" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightShipmentLineItem", propOrder = {
    "freightClass",
    "classProvidedByCustomer",
    "handlingUnits",
    "packaging",
    "pieces",
    "nmfcCode",
    "hazardousMaterials",
    "purchaseOrderNumber",
    "description",
    "weight",
    "dimensions",
    "volume"
})
public class FreightShipmentLineItem {

    @XmlElement(name = "FreightClass")
    protected FreightClassType freightClass;
    @XmlElement(name = "ClassProvidedByCustomer")
    protected Boolean classProvidedByCustomer;
    @XmlElement(name = "HandlingUnits")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger handlingUnits;
    @XmlElement(name = "Packaging")
    protected PhysicalPackagingType packaging;
    @XmlElement(name = "Pieces")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger pieces;
    @XmlElement(name = "NmfcCode")
    protected String nmfcCode;
    @XmlElement(name = "HazardousMaterials")
    protected HazardousCommodityOptionType hazardousMaterials;
    @XmlElement(name = "PurchaseOrderNumber")
    protected String purchaseOrderNumber;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Weight")
    protected Weight weight;
    @XmlElement(name = "Dimensions")
    protected Dimensions dimensions;
    @XmlElement(name = "Volume")
    protected Volume volume;

    /**
     * Obtiene el valor de la propiedad freightClass.
     * 
     * @return
     *     possible object is
     *     {@link FreightClassType }
     *     
     */
    public FreightClassType getFreightClass() {
        return freightClass;
    }

    /**
     * Define el valor de la propiedad freightClass.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightClassType }
     *     
     */
    public void setFreightClass(FreightClassType value) {
        this.freightClass = value;
    }

    /**
     * Obtiene el valor de la propiedad classProvidedByCustomer.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClassProvidedByCustomer() {
        return classProvidedByCustomer;
    }

    /**
     * Define el valor de la propiedad classProvidedByCustomer.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClassProvidedByCustomer(Boolean value) {
        this.classProvidedByCustomer = value;
    }

    /**
     * Obtiene el valor de la propiedad handlingUnits.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHandlingUnits() {
        return handlingUnits;
    }

    /**
     * Define el valor de la propiedad handlingUnits.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHandlingUnits(BigInteger value) {
        this.handlingUnits = value;
    }

    /**
     * Obtiene el valor de la propiedad packaging.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalPackagingType }
     *     
     */
    public PhysicalPackagingType getPackaging() {
        return packaging;
    }

    /**
     * Define el valor de la propiedad packaging.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalPackagingType }
     *     
     */
    public void setPackaging(PhysicalPackagingType value) {
        this.packaging = value;
    }

    /**
     * Obtiene el valor de la propiedad pieces.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPieces() {
        return pieces;
    }

    /**
     * Define el valor de la propiedad pieces.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPieces(BigInteger value) {
        this.pieces = value;
    }

    /**
     * Obtiene el valor de la propiedad nmfcCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNmfcCode() {
        return nmfcCode;
    }

    /**
     * Define el valor de la propiedad nmfcCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNmfcCode(String value) {
        this.nmfcCode = value;
    }

    /**
     * Obtiene el valor de la propiedad hazardousMaterials.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityOptionType }
     *     
     */
    public HazardousCommodityOptionType getHazardousMaterials() {
        return hazardousMaterials;
    }

    /**
     * Define el valor de la propiedad hazardousMaterials.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityOptionType }
     *     
     */
    public void setHazardousMaterials(HazardousCommodityOptionType value) {
        this.hazardousMaterials = value;
    }

    /**
     * Obtiene el valor de la propiedad purchaseOrderNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    /**
     * Define el valor de la propiedad purchaseOrderNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrderNumber(String value) {
        this.purchaseOrderNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad weight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setWeight(Weight value) {
        this.weight = value;
    }

    /**
     * Obtiene el valor de la propiedad dimensions.
     * 
     * @return
     *     possible object is
     *     {@link Dimensions }
     *     
     */
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * Define el valor de la propiedad dimensions.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimensions }
     *     
     */
    public void setDimensions(Dimensions value) {
        this.dimensions = value;
    }

    /**
     * Obtiene el valor de la propiedad volume.
     * 
     * @return
     *     possible object is
     *     {@link Volume }
     *     
     */
    public Volume getVolume() {
        return volume;
    }

    /**
     * Define el valor de la propiedad volume.
     * 
     * @param value
     *     allowed object is
     *     {@link Volume }
     *     
     */
    public void setVolume(Volume value) {
        this.volume = value;
    }

}
