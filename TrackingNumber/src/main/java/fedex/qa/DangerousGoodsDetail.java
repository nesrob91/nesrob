
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DangerousGoodsDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DangerousGoodsDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UploadedTrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Regulation" type="{http://fedex.com/ws/ship/v19}HazardousCommodityRegulationType" minOccurs="0"/>
 *         &lt;element name="Accessibility" type="{http://fedex.com/ws/ship/v19}DangerousGoodsAccessibilityType" minOccurs="0"/>
 *         &lt;element name="CargoAircraftOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Options" type="{http://fedex.com/ws/ship/v19}HazardousCommodityOptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PackingOption" type="{http://fedex.com/ws/ship/v19}DangerousGoodsPackingOptionType" minOccurs="0"/>
 *         &lt;element name="ReferenceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Containers" type="{http://fedex.com/ws/ship/v19}DangerousGoodsContainer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Packaging" type="{http://fedex.com/ws/ship/v19}HazardousCommodityPackagingDetail" minOccurs="0"/>
 *         &lt;element name="Signatory" type="{http://fedex.com/ws/ship/v19}DangerousGoodsSignatory" minOccurs="0"/>
 *         &lt;element name="EmergencyContactNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Offeror" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfectiousSubstanceResponsibleContact" type="{http://fedex.com/ws/ship/v19}Contact" minOccurs="0"/>
 *         &lt;element name="AdditionalHandling" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RadioactivityDetail" type="{http://fedex.com/ws/ship/v19}RadioactivityDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DangerousGoodsDetail", propOrder = {
    "uploadedTrackingNumber",
    "regulation",
    "accessibility",
    "cargoAircraftOnly",
    "options",
    "packingOption",
    "referenceId",
    "containers",
    "packaging",
    "signatory",
    "emergencyContactNumber",
    "offeror",
    "infectiousSubstanceResponsibleContact",
    "additionalHandling",
    "radioactivityDetail"
})
public class DangerousGoodsDetail {

    @XmlElement(name = "UploadedTrackingNumber")
    protected String uploadedTrackingNumber;
    @XmlElement(name = "Regulation")
    protected HazardousCommodityRegulationType regulation;
    @XmlElement(name = "Accessibility")
    protected DangerousGoodsAccessibilityType accessibility;
    @XmlElement(name = "CargoAircraftOnly")
    protected Boolean cargoAircraftOnly;
    @XmlElement(name = "Options")
    protected List<HazardousCommodityOptionType> options;
    @XmlElement(name = "PackingOption")
    protected DangerousGoodsPackingOptionType packingOption;
    @XmlElement(name = "ReferenceId")
    protected String referenceId;
    @XmlElement(name = "Containers")
    protected List<DangerousGoodsContainer> containers;
    @XmlElement(name = "Packaging")
    protected HazardousCommodityPackagingDetail packaging;
    @XmlElement(name = "Signatory")
    protected DangerousGoodsSignatory signatory;
    @XmlElement(name = "EmergencyContactNumber")
    protected String emergencyContactNumber;
    @XmlElement(name = "Offeror")
    protected String offeror;
    @XmlElement(name = "InfectiousSubstanceResponsibleContact")
    protected Contact infectiousSubstanceResponsibleContact;
    @XmlElement(name = "AdditionalHandling")
    protected String additionalHandling;
    @XmlElement(name = "RadioactivityDetail")
    protected RadioactivityDetail radioactivityDetail;

    /**
     * Obtiene el valor de la propiedad uploadedTrackingNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadedTrackingNumber() {
        return uploadedTrackingNumber;
    }

    /**
     * Define el valor de la propiedad uploadedTrackingNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadedTrackingNumber(String value) {
        this.uploadedTrackingNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad regulation.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityRegulationType }
     *     
     */
    public HazardousCommodityRegulationType getRegulation() {
        return regulation;
    }

    /**
     * Define el valor de la propiedad regulation.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityRegulationType }
     *     
     */
    public void setRegulation(HazardousCommodityRegulationType value) {
        this.regulation = value;
    }

    /**
     * Obtiene el valor de la propiedad accessibility.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsAccessibilityType }
     *     
     */
    public DangerousGoodsAccessibilityType getAccessibility() {
        return accessibility;
    }

    /**
     * Define el valor de la propiedad accessibility.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsAccessibilityType }
     *     
     */
    public void setAccessibility(DangerousGoodsAccessibilityType value) {
        this.accessibility = value;
    }

    /**
     * Obtiene el valor de la propiedad cargoAircraftOnly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCargoAircraftOnly() {
        return cargoAircraftOnly;
    }

    /**
     * Define el valor de la propiedad cargoAircraftOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCargoAircraftOnly(Boolean value) {
        this.cargoAircraftOnly = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousCommodityOptionType }
     * 
     * 
     */
    public List<HazardousCommodityOptionType> getOptions() {
        if (options == null) {
            options = new ArrayList<HazardousCommodityOptionType>();
        }
        return this.options;
    }

    /**
     * Obtiene el valor de la propiedad packingOption.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsPackingOptionType }
     *     
     */
    public DangerousGoodsPackingOptionType getPackingOption() {
        return packingOption;
    }

    /**
     * Define el valor de la propiedad packingOption.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsPackingOptionType }
     *     
     */
    public void setPackingOption(DangerousGoodsPackingOptionType value) {
        this.packingOption = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Define el valor de la propiedad referenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceId(String value) {
        this.referenceId = value;
    }

    /**
     * Gets the value of the containers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the containers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContainers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DangerousGoodsContainer }
     * 
     * 
     */
    public List<DangerousGoodsContainer> getContainers() {
        if (containers == null) {
            containers = new ArrayList<DangerousGoodsContainer>();
        }
        return this.containers;
    }

    /**
     * Obtiene el valor de la propiedad packaging.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityPackagingDetail }
     *     
     */
    public HazardousCommodityPackagingDetail getPackaging() {
        return packaging;
    }

    /**
     * Define el valor de la propiedad packaging.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityPackagingDetail }
     *     
     */
    public void setPackaging(HazardousCommodityPackagingDetail value) {
        this.packaging = value;
    }

    /**
     * Obtiene el valor de la propiedad signatory.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsSignatory }
     *     
     */
    public DangerousGoodsSignatory getSignatory() {
        return signatory;
    }

    /**
     * Define el valor de la propiedad signatory.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsSignatory }
     *     
     */
    public void setSignatory(DangerousGoodsSignatory value) {
        this.signatory = value;
    }

    /**
     * Obtiene el valor de la propiedad emergencyContactNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    /**
     * Define el valor de la propiedad emergencyContactNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergencyContactNumber(String value) {
        this.emergencyContactNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad offeror.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferor() {
        return offeror;
    }

    /**
     * Define el valor de la propiedad offeror.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferor(String value) {
        this.offeror = value;
    }

    /**
     * Obtiene el valor de la propiedad infectiousSubstanceResponsibleContact.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getInfectiousSubstanceResponsibleContact() {
        return infectiousSubstanceResponsibleContact;
    }

    /**
     * Define el valor de la propiedad infectiousSubstanceResponsibleContact.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setInfectiousSubstanceResponsibleContact(Contact value) {
        this.infectiousSubstanceResponsibleContact = value;
    }

    /**
     * Obtiene el valor de la propiedad additionalHandling.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalHandling() {
        return additionalHandling;
    }

    /**
     * Define el valor de la propiedad additionalHandling.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalHandling(String value) {
        this.additionalHandling = value;
    }

    /**
     * Obtiene el valor de la propiedad radioactivityDetail.
     * 
     * @return
     *     possible object is
     *     {@link RadioactivityDetail }
     *     
     */
    public RadioactivityDetail getRadioactivityDetail() {
        return radioactivityDetail;
    }

    /**
     * Define el valor de la propiedad radioactivityDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioactivityDetail }
     *     
     */
    public void setRadioactivityDetail(RadioactivityDetail value) {
        this.radioactivityDetail = value;
    }

}
