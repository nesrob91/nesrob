
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
 * <p>Clase Java para CompletedPackageDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedPackageDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="TrackingIds" type="{http://fedex.com/ws/ship/v19}TrackingId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GroupNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="OversizeClass" type="{http://fedex.com/ws/ship/v19}OversizeClassType" minOccurs="0"/>
 *         &lt;element name="PackageRating" type="{http://fedex.com/ws/ship/v19}PackageRating" minOccurs="0"/>
 *         &lt;element name="OperationalDetail" type="{http://fedex.com/ws/ship/v19}PackageOperationalDetail" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://fedex.com/ws/ship/v19}ShippingDocument" minOccurs="0"/>
 *         &lt;element name="PackageDocuments" type="{http://fedex.com/ws/ship/v19}ShippingDocument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CodReturnDetail" type="{http://fedex.com/ws/ship/v19}CodReturnPackageDetail" minOccurs="0"/>
 *         &lt;element name="SignatureOption" type="{http://fedex.com/ws/ship/v19}SignatureOptionType" minOccurs="0"/>
 *         &lt;element name="DryIceWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="HazardousPackageDetail" type="{http://fedex.com/ws/ship/v19}CompletedHazardousPackageDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedPackageDetail", propOrder = {
    "sequenceNumber",
    "trackingIds",
    "groupNumber",
    "oversizeClass",
    "packageRating",
    "operationalDetail",
    "label",
    "packageDocuments",
    "codReturnDetail",
    "signatureOption",
    "dryIceWeight",
    "hazardousPackageDetail"
})
public class CompletedPackageDetail {

    @XmlElement(name = "SequenceNumber")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sequenceNumber;
    @XmlElement(name = "TrackingIds")
    protected List<TrackingId> trackingIds;
    @XmlElement(name = "GroupNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger groupNumber;
    @XmlElement(name = "OversizeClass")
    protected OversizeClassType oversizeClass;
    @XmlElement(name = "PackageRating")
    protected PackageRating packageRating;
    @XmlElement(name = "OperationalDetail")
    protected PackageOperationalDetail operationalDetail;
    @XmlElement(name = "Label")
    protected ShippingDocument label;
    @XmlElement(name = "PackageDocuments")
    protected List<ShippingDocument> packageDocuments;
    @XmlElement(name = "CodReturnDetail")
    protected CodReturnPackageDetail codReturnDetail;
    @XmlElement(name = "SignatureOption")
    protected SignatureOptionType signatureOption;
    @XmlElement(name = "DryIceWeight")
    protected Weight dryIceWeight;
    @XmlElement(name = "HazardousPackageDetail")
    protected CompletedHazardousPackageDetail hazardousPackageDetail;

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
     * Gets the value of the trackingIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackingIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackingIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackingId }
     * 
     * 
     */
    public List<TrackingId> getTrackingIds() {
        if (trackingIds == null) {
            trackingIds = new ArrayList<TrackingId>();
        }
        return this.trackingIds;
    }

    /**
     * Obtiene el valor de la propiedad groupNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGroupNumber() {
        return groupNumber;
    }

    /**
     * Define el valor de la propiedad groupNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGroupNumber(BigInteger value) {
        this.groupNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad oversizeClass.
     * 
     * @return
     *     possible object is
     *     {@link OversizeClassType }
     *     
     */
    public OversizeClassType getOversizeClass() {
        return oversizeClass;
    }

    /**
     * Define el valor de la propiedad oversizeClass.
     * 
     * @param value
     *     allowed object is
     *     {@link OversizeClassType }
     *     
     */
    public void setOversizeClass(OversizeClassType value) {
        this.oversizeClass = value;
    }

    /**
     * Obtiene el valor de la propiedad packageRating.
     * 
     * @return
     *     possible object is
     *     {@link PackageRating }
     *     
     */
    public PackageRating getPackageRating() {
        return packageRating;
    }

    /**
     * Define el valor de la propiedad packageRating.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageRating }
     *     
     */
    public void setPackageRating(PackageRating value) {
        this.packageRating = value;
    }

    /**
     * Obtiene el valor de la propiedad operationalDetail.
     * 
     * @return
     *     possible object is
     *     {@link PackageOperationalDetail }
     *     
     */
    public PackageOperationalDetail getOperationalDetail() {
        return operationalDetail;
    }

    /**
     * Define el valor de la propiedad operationalDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageOperationalDetail }
     *     
     */
    public void setOperationalDetail(PackageOperationalDetail value) {
        this.operationalDetail = value;
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

    /**
     * Gets the value of the packageDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShippingDocument }
     * 
     * 
     */
    public List<ShippingDocument> getPackageDocuments() {
        if (packageDocuments == null) {
            packageDocuments = new ArrayList<ShippingDocument>();
        }
        return this.packageDocuments;
    }

    /**
     * Obtiene el valor de la propiedad codReturnDetail.
     * 
     * @return
     *     possible object is
     *     {@link CodReturnPackageDetail }
     *     
     */
    public CodReturnPackageDetail getCodReturnDetail() {
        return codReturnDetail;
    }

    /**
     * Define el valor de la propiedad codReturnDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CodReturnPackageDetail }
     *     
     */
    public void setCodReturnDetail(CodReturnPackageDetail value) {
        this.codReturnDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureOption.
     * 
     * @return
     *     possible object is
     *     {@link SignatureOptionType }
     *     
     */
    public SignatureOptionType getSignatureOption() {
        return signatureOption;
    }

    /**
     * Define el valor de la propiedad signatureOption.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureOptionType }
     *     
     */
    public void setSignatureOption(SignatureOptionType value) {
        this.signatureOption = value;
    }

    /**
     * Obtiene el valor de la propiedad dryIceWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getDryIceWeight() {
        return dryIceWeight;
    }

    /**
     * Define el valor de la propiedad dryIceWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setDryIceWeight(Weight value) {
        this.dryIceWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad hazardousPackageDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedHazardousPackageDetail }
     *     
     */
    public CompletedHazardousPackageDetail getHazardousPackageDetail() {
        return hazardousPackageDetail;
    }

    /**
     * Define el valor de la propiedad hazardousPackageDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedHazardousPackageDetail }
     *     
     */
    public void setHazardousPackageDetail(CompletedHazardousPackageDetail value) {
        this.hazardousPackageDetail = value;
    }

}
