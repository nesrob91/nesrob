
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
 * Describes an approved container used to package dangerous goods commodities. This does not describe any individual inner receptacles that may be within this container.
 * 
 * <p>Clase Java para DangerousGoodsContainer complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DangerousGoodsContainer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackingType" type="{http://fedex.com/ws/ship/v19}HazardousContainerPackingType" minOccurs="0"/>
 *         &lt;element name="ContainerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RadioactiveContainerClass" type="{http://fedex.com/ws/ship/v19}RadioactiveContainerClassType" minOccurs="0"/>
 *         &lt;element name="NumberOfContainers" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="HazardousCommodities" type="{http://fedex.com/ws/ship/v19}HazardousCommodityContent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DangerousGoodsContainer", propOrder = {
    "packingType",
    "containerType",
    "radioactiveContainerClass",
    "numberOfContainers",
    "hazardousCommodities"
})
public class DangerousGoodsContainer {

    @XmlElement(name = "PackingType")
    protected HazardousContainerPackingType packingType;
    @XmlElement(name = "ContainerType")
    protected String containerType;
    @XmlElement(name = "RadioactiveContainerClass")
    protected RadioactiveContainerClassType radioactiveContainerClass;
    @XmlElement(name = "NumberOfContainers")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfContainers;
    @XmlElement(name = "HazardousCommodities")
    protected List<HazardousCommodityContent> hazardousCommodities;

    /**
     * Obtiene el valor de la propiedad packingType.
     * 
     * @return
     *     possible object is
     *     {@link HazardousContainerPackingType }
     *     
     */
    public HazardousContainerPackingType getPackingType() {
        return packingType;
    }

    /**
     * Define el valor de la propiedad packingType.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousContainerPackingType }
     *     
     */
    public void setPackingType(HazardousContainerPackingType value) {
        this.packingType = value;
    }

    /**
     * Obtiene el valor de la propiedad containerType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerType() {
        return containerType;
    }

    /**
     * Define el valor de la propiedad containerType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerType(String value) {
        this.containerType = value;
    }

    /**
     * Obtiene el valor de la propiedad radioactiveContainerClass.
     * 
     * @return
     *     possible object is
     *     {@link RadioactiveContainerClassType }
     *     
     */
    public RadioactiveContainerClassType getRadioactiveContainerClass() {
        return radioactiveContainerClass;
    }

    /**
     * Define el valor de la propiedad radioactiveContainerClass.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioactiveContainerClassType }
     *     
     */
    public void setRadioactiveContainerClass(RadioactiveContainerClassType value) {
        this.radioactiveContainerClass = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfContainers.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfContainers() {
        return numberOfContainers;
    }

    /**
     * Define el valor de la propiedad numberOfContainers.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfContainers(BigInteger value) {
        this.numberOfContainers = value;
    }

    /**
     * Gets the value of the hazardousCommodities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazardousCommodities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazardousCommodities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousCommodityContent }
     * 
     * 
     */
    public List<HazardousCommodityContent> getHazardousCommodities() {
        if (hazardousCommodities == null) {
            hazardousCommodities = new ArrayList<HazardousCommodityContent>();
        }
        return this.hazardousCommodities;
    }

}
