
package fedex.qa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies and describes an individual hazardous commodity. For 201001 load, this is based on data from the FedEx Ground Hazardous Materials Shipping Guide.
 * 
 * <p>Clase Java para ValidatedHazardousCommodityDescription complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ValidatedHazardousCommodityDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="PackingGroup" type="{http://fedex.com/ws/ship/v19}HazardousCommodityPackingGroupType" minOccurs="0"/>
 *         &lt;element name="PackingInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProperShippingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProperShippingNameAndDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TechnicalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HazardClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubsidiaryClasses" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Symbols" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TunnelRestrictionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecialProvisions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://fedex.com/ws/ship/v19}HazardousCommodityAttributeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Authorization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LabelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidatedHazardousCommodityDescription", propOrder = {
    "id",
    "sequenceNumber",
    "packingGroup",
    "packingInstructions",
    "properShippingName",
    "properShippingNameAndDescription",
    "technicalName",
    "hazardClass",
    "subsidiaryClasses",
    "symbols",
    "tunnelRestrictionCode",
    "specialProvisions",
    "attributes",
    "authorization",
    "labelText"
})
public class ValidatedHazardousCommodityDescription {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "SequenceNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger sequenceNumber;
    @XmlElement(name = "PackingGroup")
    protected HazardousCommodityPackingGroupType packingGroup;
    @XmlElement(name = "PackingInstructions")
    protected String packingInstructions;
    @XmlElement(name = "ProperShippingName")
    protected String properShippingName;
    @XmlElement(name = "ProperShippingNameAndDescription")
    protected String properShippingNameAndDescription;
    @XmlElement(name = "TechnicalName")
    protected String technicalName;
    @XmlElement(name = "HazardClass")
    protected String hazardClass;
    @XmlElement(name = "SubsidiaryClasses")
    protected List<String> subsidiaryClasses;
    @XmlElement(name = "Symbols")
    protected String symbols;
    @XmlElement(name = "TunnelRestrictionCode")
    protected String tunnelRestrictionCode;
    @XmlElement(name = "SpecialProvisions")
    protected String specialProvisions;
    @XmlElement(name = "Attributes")
    protected List<HazardousCommodityAttributeType> attributes;
    @XmlElement(name = "Authorization")
    protected String authorization;
    @XmlElement(name = "LabelText")
    protected String labelText;

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
     * Obtiene el valor de la propiedad packingInstructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackingInstructions() {
        return packingInstructions;
    }

    /**
     * Define el valor de la propiedad packingInstructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackingInstructions(String value) {
        this.packingInstructions = value;
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
     * Obtiene el valor de la propiedad properShippingNameAndDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperShippingNameAndDescription() {
        return properShippingNameAndDescription;
    }

    /**
     * Define el valor de la propiedad properShippingNameAndDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperShippingNameAndDescription(String value) {
        this.properShippingNameAndDescription = value;
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
     * Obtiene el valor de la propiedad symbols.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbols() {
        return symbols;
    }

    /**
     * Define el valor de la propiedad symbols.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbols(String value) {
        this.symbols = value;
    }

    /**
     * Obtiene el valor de la propiedad tunnelRestrictionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTunnelRestrictionCode() {
        return tunnelRestrictionCode;
    }

    /**
     * Define el valor de la propiedad tunnelRestrictionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTunnelRestrictionCode(String value) {
        this.tunnelRestrictionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad specialProvisions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialProvisions() {
        return specialProvisions;
    }

    /**
     * Define el valor de la propiedad specialProvisions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialProvisions(String value) {
        this.specialProvisions = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousCommodityAttributeType }
     * 
     * 
     */
    public List<HazardousCommodityAttributeType> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<HazardousCommodityAttributeType>();
        }
        return this.attributes;
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

}
