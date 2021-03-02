
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies and describes an individual hazardous commodity.
 * 
 * <p>Clase Java para HazardousCommodityDescription complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HazardousCommodityDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="PackingGroup" type="{http://fedex.com/ws/ship/v19}HazardousCommodityPackingGroupType" minOccurs="0"/>
 *         &lt;element name="PackingDetails" type="{http://fedex.com/ws/ship/v19}HazardousCommodityPackingDetail" minOccurs="0"/>
 *         &lt;element name="ReportableQuantity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ProperShippingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TechnicalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="HazardClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubsidiaryClasses" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LabelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessingOptions" type="{http://fedex.com/ws/ship/v19}HazardousCommodityDescriptionProcessingOptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Authorization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousCommodityDescription", propOrder = {
    "id",
    "sequenceNumber",
    "packingGroup",
    "packingDetails",
    "reportableQuantity",
    "properShippingName",
    "technicalName",
    "percentage",
    "hazardClass",
    "subsidiaryClasses",
    "labelText",
    "processingOptions",
    "authorization"
})
public class HazardousCommodityDescription {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "SequenceNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger sequenceNumber;
    @XmlElement(name = "PackingGroup")
    protected HazardousCommodityPackingGroupType packingGroup;
    @XmlElement(name = "PackingDetails")
    protected HazardousCommodityPackingDetail packingDetails;
    @XmlElement(name = "ReportableQuantity")
    protected Boolean reportableQuantity;
    @XmlElement(name = "ProperShippingName")
    protected String properShippingName;
    @XmlElement(name = "TechnicalName")
    protected String technicalName;
    @XmlElement(name = "Percentage")
    protected BigDecimal percentage;
    @XmlElement(name = "HazardClass")
    protected String hazardClass;
    @XmlElement(name = "SubsidiaryClasses")
    protected List<String> subsidiaryClasses;
    @XmlElement(name = "LabelText")
    protected String labelText;
    @XmlElement(name = "ProcessingOptions")
    protected List<HazardousCommodityDescriptionProcessingOptionType> processingOptions;
    @XmlElement(name = "Authorization")
    protected String authorization;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad sequenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Define el valor de la propiedad sequenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad packingGroup.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityPackingGroupType }
     *     
     */
    public HazardousCommodityPackingGroupType getPackingGroup() {
        return packingGroup;
    }

    /**
     * Define el valor de la propiedad packingGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityPackingGroupType }
     *     
     */
    public void setPackingGroup(HazardousCommodityPackingGroupType value) {
        this.packingGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad packingDetails.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityPackingDetail }
     *     
     */
    public HazardousCommodityPackingDetail getPackingDetails() {
        return packingDetails;
    }

    /**
     * Define el valor de la propiedad packingDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityPackingDetail }
     *     
     */
    public void setPackingDetails(HazardousCommodityPackingDetail value) {
        this.packingDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad reportableQuantity.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReportableQuantity() {
        return reportableQuantity;
    }

    /**
     * Define el valor de la propiedad reportableQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReportableQuantity(Boolean value) {
        this.reportableQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad properShippingName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperShippingName() {
        return properShippingName;
    }

    /**
     * Define el valor de la propiedad properShippingName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperShippingName(String value) {
        this.properShippingName = value;
    }

    /**
     * Obtiene el valor de la propiedad technicalName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnicalName() {
        return technicalName;
    }

    /**
     * Define el valor de la propiedad technicalName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnicalName(String value) {
        this.technicalName = value;
    }

    /**
     * Obtiene el valor de la propiedad percentage.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * Define el valor de la propiedad percentage.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentage(BigDecimal value) {
        this.percentage = value;
    }

    /**
     * Obtiene el valor de la propiedad hazardClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazardClass() {
        return hazardClass;
    }

    /**
     * Define el valor de la propiedad hazardClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazardClass(String value) {
        this.hazardClass = value;
    }

    /**
     * Gets the value of the subsidiaryClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsidiaryClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsidiaryClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSubsidiaryClasses() {
        if (subsidiaryClasses == null) {
            subsidiaryClasses = new ArrayList<String>();
        }
        return this.subsidiaryClasses;
    }

    /**
     * Obtiene el valor de la propiedad labelText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * Define el valor de la propiedad labelText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelText(String value) {
        this.labelText = value;
    }

    /**
     * Gets the value of the processingOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processingOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousCommodityDescriptionProcessingOptionType }
     * 
     * 
     */
    public List<HazardousCommodityDescriptionProcessingOptionType> getProcessingOptions() {
        if (processingOptions == null) {
            processingOptions = new ArrayList<HazardousCommodityDescriptionProcessingOptionType>();
        }
        return this.processingOptions;
    }

    /**
     * Obtiene el valor de la propiedad authorization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Define el valor de la propiedad authorization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorization(String value) {
        this.authorization = value;
    }

}
