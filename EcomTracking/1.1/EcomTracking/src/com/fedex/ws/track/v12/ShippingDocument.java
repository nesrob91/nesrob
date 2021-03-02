
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShippingDocument complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShippingDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}ReturnedShippingDocumentType" minOccurs="0"/>
 *         &lt;element name="Localizations" type="{http://fedex.com/ws/ship/v19}Localization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Grouping" type="{http://fedex.com/ws/ship/v19}ShippingDocumentGroupingType" minOccurs="0"/>
 *         &lt;element name="ShippingDocumentDisposition" type="{http://fedex.com/ws/ship/v19}ShippingDocumentDispositionType" minOccurs="0"/>
 *         &lt;element name="AccessReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImageType" type="{http://fedex.com/ws/ship/v19}ShippingDocumentImageType" minOccurs="0"/>
 *         &lt;element name="Resolution" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="CopiesToPrint" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Parts" type="{http://fedex.com/ws/ship/v19}ShippingDocumentPart" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingDocument", propOrder = {
    "type",
    "localizations",
    "grouping",
    "shippingDocumentDisposition",
    "accessReference",
    "imageType",
    "resolution",
    "copiesToPrint",
    "parts"
})
public class ShippingDocument {

    @XmlElement(name = "Type")
    protected ReturnedShippingDocumentType type;
    @XmlElement(name = "Localizations")
    protected List<Localization> localizations;
    @XmlElement(name = "Grouping")
    protected ShippingDocumentGroupingType grouping;
    @XmlElement(name = "ShippingDocumentDisposition")
    protected ShippingDocumentDispositionType shippingDocumentDisposition;
    @XmlElement(name = "AccessReference")
    protected String accessReference;
    @XmlElement(name = "ImageType")
    protected ShippingDocumentImageType imageType;
    @XmlElement(name = "Resolution")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger resolution;
    @XmlElement(name = "CopiesToPrint")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger copiesToPrint;
    @XmlElement(name = "Parts")
    protected List<ShippingDocumentPart> parts;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link ReturnedShippingDocumentType }
     *     
     */
    public ReturnedShippingDocumentType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnedShippingDocumentType }
     *     
     */
    public void setType(ReturnedShippingDocumentType value) {
        this.type = value;
    }

    /**
     * Gets the value of the localizations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Localization }
     * 
     * 
     */
    public List<Localization> getLocalizations() {
        if (localizations == null) {
            localizations = new ArrayList<Localization>();
        }
        return this.localizations;
    }

    /**
     * Obtiene el valor de la propiedad grouping.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentGroupingType }
     *     
     */
    public ShippingDocumentGroupingType getGrouping() {
        return grouping;
    }

    /**
     * Define el valor de la propiedad grouping.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentGroupingType }
     *     
     */
    public void setGrouping(ShippingDocumentGroupingType value) {
        this.grouping = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingDocumentDisposition.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentDispositionType }
     *     
     */
    public ShippingDocumentDispositionType getShippingDocumentDisposition() {
        return shippingDocumentDisposition;
    }

    /**
     * Define el valor de la propiedad shippingDocumentDisposition.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentDispositionType }
     *     
     */
    public void setShippingDocumentDisposition(ShippingDocumentDispositionType value) {
        this.shippingDocumentDisposition = value;
    }

    /**
     * Obtiene el valor de la propiedad accessReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessReference() {
        return accessReference;
    }

    /**
     * Define el valor de la propiedad accessReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessReference(String value) {
        this.accessReference = value;
    }

    /**
     * Obtiene el valor de la propiedad imageType.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentImageType }
     *     
     */
    public ShippingDocumentImageType getImageType() {
        return imageType;
    }

    /**
     * Define el valor de la propiedad imageType.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentImageType }
     *     
     */
    public void setImageType(ShippingDocumentImageType value) {
        this.imageType = value;
    }

    /**
     * Obtiene el valor de la propiedad resolution.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResolution() {
        return resolution;
    }

    /**
     * Define el valor de la propiedad resolution.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResolution(BigInteger value) {
        this.resolution = value;
    }

    /**
     * Obtiene el valor de la propiedad copiesToPrint.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCopiesToPrint() {
        return copiesToPrint;
    }

    /**
     * Define el valor de la propiedad copiesToPrint.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCopiesToPrint(BigInteger value) {
        this.copiesToPrint = value;
    }

    /**
     * Gets the value of the parts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShippingDocumentPart }
     * 
     * 
     */
    public List<ShippingDocumentPart> getParts() {
        if (parts == null) {
            parts = new ArrayList<ShippingDocumentPart>();
        }
        return this.parts;
    }

}
