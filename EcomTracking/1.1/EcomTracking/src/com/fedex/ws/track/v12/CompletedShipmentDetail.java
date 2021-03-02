
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CompletedShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UsDomestic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CarrierCode" type="{http://fedex.com/ws/ship/v19}CarrierCodeType" minOccurs="0"/>
 *         &lt;element name="MasterTrackingId" type="{http://fedex.com/ws/ship/v19}TrackingId" minOccurs="0"/>
 *         &lt;element name="ServiceTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackagingDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationalDetail" type="{http://fedex.com/ws/ship/v19}ShipmentOperationalDetail" minOccurs="0"/>
 *         &lt;element name="AccessDetail" type="{http://fedex.com/ws/ship/v19}PendingShipmentAccessDetail" minOccurs="0"/>
 *         &lt;element name="TagDetail" type="{http://fedex.com/ws/ship/v19}CompletedTagDetail" minOccurs="0"/>
 *         &lt;element name="SmartPostDetail" type="{http://fedex.com/ws/ship/v19}CompletedSmartPostDetail" minOccurs="0"/>
 *         &lt;element name="HazardousShipmentDetail" type="{http://fedex.com/ws/ship/v19}CompletedHazardousShipmentDetail" minOccurs="0"/>
 *         &lt;element name="ShipmentRating" type="{http://fedex.com/ws/ship/v19}ShipmentRating" minOccurs="0"/>
 *         &lt;element name="CompletedHoldAtLocationDetail" type="{http://fedex.com/ws/ship/v19}CompletedHoldAtLocationDetail" minOccurs="0"/>
 *         &lt;element name="ExportComplianceStatement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompletedEtdDetail" type="{http://fedex.com/ws/ship/v19}CompletedEtdDetail" minOccurs="0"/>
 *         &lt;element name="ShipmentDocuments" type="{http://fedex.com/ws/ship/v19}ShippingDocument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AssociatedShipments" type="{http://fedex.com/ws/ship/v19}AssociatedShipmentDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CompletedCodDetail" type="{http://fedex.com/ws/ship/v19}CompletedCodDetail" minOccurs="0"/>
 *         &lt;element name="CompletedPackageDetails" type="{http://fedex.com/ws/ship/v19}CompletedPackageDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedShipmentDetail", propOrder = {
    "usDomestic",
    "carrierCode",
    "masterTrackingId",
    "serviceTypeDescription",
    "packagingDescription",
    "operationalDetail",
    "accessDetail",
    "tagDetail",
    "smartPostDetail",
    "hazardousShipmentDetail",
    "shipmentRating",
    "completedHoldAtLocationDetail",
    "exportComplianceStatement",
    "completedEtdDetail",
    "shipmentDocuments",
    "associatedShipments",
    "completedCodDetail",
    "completedPackageDetails"
})
public class CompletedShipmentDetail {

    @XmlElement(name = "UsDomestic")
    protected Boolean usDomestic;
    @XmlElement(name = "CarrierCode")
    protected CarrierCodeType carrierCode;
    @XmlElement(name = "MasterTrackingId")
    protected TrackingId masterTrackingId;
    @XmlElement(name = "ServiceTypeDescription")
    protected String serviceTypeDescription;
    @XmlElement(name = "PackagingDescription")
    protected String packagingDescription;
    @XmlElement(name = "OperationalDetail")
    protected ShipmentOperationalDetail operationalDetail;
    @XmlElement(name = "AccessDetail")
    protected PendingShipmentAccessDetail accessDetail;
    @XmlElement(name = "TagDetail")
    protected CompletedTagDetail tagDetail;
    @XmlElement(name = "SmartPostDetail")
    protected CompletedSmartPostDetail smartPostDetail;
    @XmlElement(name = "HazardousShipmentDetail")
    protected CompletedHazardousShipmentDetail hazardousShipmentDetail;
    @XmlElement(name = "ShipmentRating")
    protected ShipmentRating shipmentRating;
    @XmlElement(name = "CompletedHoldAtLocationDetail")
    protected CompletedHoldAtLocationDetail completedHoldAtLocationDetail;
    @XmlElement(name = "ExportComplianceStatement")
    protected String exportComplianceStatement;
    @XmlElement(name = "CompletedEtdDetail")
    protected CompletedEtdDetail completedEtdDetail;
    @XmlElement(name = "ShipmentDocuments")
    protected List<ShippingDocument> shipmentDocuments;
    @XmlElement(name = "AssociatedShipments")
    protected List<AssociatedShipmentDetail> associatedShipments;
    @XmlElement(name = "CompletedCodDetail")
    protected CompletedCodDetail completedCodDetail;
    @XmlElement(name = "CompletedPackageDetails")
    protected List<CompletedPackageDetail> completedPackageDetails;

    /**
     * Obtiene el valor de la propiedad usDomestic.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUsDomestic() {
        return usDomestic;
    }

    /**
     * Define el valor de la propiedad usDomestic.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUsDomestic(Boolean value) {
        this.usDomestic = value;
    }

    /**
     * Obtiene el valor de la propiedad carrierCode.
     * 
     * @return
     *     possible object is
     *     {@link CarrierCodeType }
     *     
     */
    public CarrierCodeType getCarrierCode() {
        return carrierCode;
    }

    /**
     * Define el valor de la propiedad carrierCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierCodeType }
     *     
     */
    public void setCarrierCode(CarrierCodeType value) {
        this.carrierCode = value;
    }

    /**
     * Obtiene el valor de la propiedad masterTrackingId.
     * 
     * @return
     *     possible object is
     *     {@link TrackingId }
     *     
     */
    public TrackingId getMasterTrackingId() {
        return masterTrackingId;
    }

    /**
     * Define el valor de la propiedad masterTrackingId.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingId }
     *     
     */
    public void setMasterTrackingId(TrackingId value) {
        this.masterTrackingId = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceTypeDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceTypeDescription() {
        return serviceTypeDescription;
    }

    /**
     * Define el valor de la propiedad serviceTypeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceTypeDescription(String value) {
        this.serviceTypeDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad packagingDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackagingDescription() {
        return packagingDescription;
    }

    /**
     * Define el valor de la propiedad packagingDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackagingDescription(String value) {
        this.packagingDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad operationalDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentOperationalDetail }
     *     
     */
    public ShipmentOperationalDetail getOperationalDetail() {
        return operationalDetail;
    }

    /**
     * Define el valor de la propiedad operationalDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentOperationalDetail }
     *     
     */
    public void setOperationalDetail(ShipmentOperationalDetail value) {
        this.operationalDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad accessDetail.
     * 
     * @return
     *     possible object is
     *     {@link PendingShipmentAccessDetail }
     *     
     */
    public PendingShipmentAccessDetail getAccessDetail() {
        return accessDetail;
    }

    /**
     * Define el valor de la propiedad accessDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingShipmentAccessDetail }
     *     
     */
    public void setAccessDetail(PendingShipmentAccessDetail value) {
        this.accessDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad tagDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedTagDetail }
     *     
     */
    public CompletedTagDetail getTagDetail() {
        return tagDetail;
    }

    /**
     * Define el valor de la propiedad tagDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedTagDetail }
     *     
     */
    public void setTagDetail(CompletedTagDetail value) {
        this.tagDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad smartPostDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedSmartPostDetail }
     *     
     */
    public CompletedSmartPostDetail getSmartPostDetail() {
        return smartPostDetail;
    }

    /**
     * Define el valor de la propiedad smartPostDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedSmartPostDetail }
     *     
     */
    public void setSmartPostDetail(CompletedSmartPostDetail value) {
        this.smartPostDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad hazardousShipmentDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedHazardousShipmentDetail }
     *     
     */
    public CompletedHazardousShipmentDetail getHazardousShipmentDetail() {
        return hazardousShipmentDetail;
    }

    /**
     * Define el valor de la propiedad hazardousShipmentDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedHazardousShipmentDetail }
     *     
     */
    public void setHazardousShipmentDetail(CompletedHazardousShipmentDetail value) {
        this.hazardousShipmentDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad shipmentRating.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentRating }
     *     
     */
    public ShipmentRating getShipmentRating() {
        return shipmentRating;
    }

    /**
     * Define el valor de la propiedad shipmentRating.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentRating }
     *     
     */
    public void setShipmentRating(ShipmentRating value) {
        this.shipmentRating = value;
    }

    /**
     * Obtiene el valor de la propiedad completedHoldAtLocationDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedHoldAtLocationDetail }
     *     
     */
    public CompletedHoldAtLocationDetail getCompletedHoldAtLocationDetail() {
        return completedHoldAtLocationDetail;
    }

    /**
     * Define el valor de la propiedad completedHoldAtLocationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedHoldAtLocationDetail }
     *     
     */
    public void setCompletedHoldAtLocationDetail(CompletedHoldAtLocationDetail value) {
        this.completedHoldAtLocationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad exportComplianceStatement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportComplianceStatement() {
        return exportComplianceStatement;
    }

    /**
     * Define el valor de la propiedad exportComplianceStatement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportComplianceStatement(String value) {
        this.exportComplianceStatement = value;
    }

    /**
     * Obtiene el valor de la propiedad completedEtdDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedEtdDetail }
     *     
     */
    public CompletedEtdDetail getCompletedEtdDetail() {
        return completedEtdDetail;
    }

    /**
     * Define el valor de la propiedad completedEtdDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedEtdDetail }
     *     
     */
    public void setCompletedEtdDetail(CompletedEtdDetail value) {
        this.completedEtdDetail = value;
    }

    /**
     * Gets the value of the shipmentDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShippingDocument }
     * 
     * 
     */
    public List<ShippingDocument> getShipmentDocuments() {
        if (shipmentDocuments == null) {
            shipmentDocuments = new ArrayList<ShippingDocument>();
        }
        return this.shipmentDocuments;
    }

    /**
     * Gets the value of the associatedShipments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedShipments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedShipments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociatedShipmentDetail }
     * 
     * 
     */
    public List<AssociatedShipmentDetail> getAssociatedShipments() {
        if (associatedShipments == null) {
            associatedShipments = new ArrayList<AssociatedShipmentDetail>();
        }
        return this.associatedShipments;
    }

    /**
     * Obtiene el valor de la propiedad completedCodDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedCodDetail }
     *     
     */
    public CompletedCodDetail getCompletedCodDetail() {
        return completedCodDetail;
    }

    /**
     * Define el valor de la propiedad completedCodDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedCodDetail }
     *     
     */
    public void setCompletedCodDetail(CompletedCodDetail value) {
        this.completedCodDetail = value;
    }

    /**
     * Gets the value of the completedPackageDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completedPackageDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletedPackageDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedPackageDetail }
     * 
     * 
     */
    public List<CompletedPackageDetail> getCompletedPackageDetails() {
        if (completedPackageDetails == null) {
            completedPackageDetails = new ArrayList<CompletedPackageDetail>();
        }
        return this.completedPackageDetails;
    }

}
