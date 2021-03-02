
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RequestedShipment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestedShipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShipTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DropoffType" type="{http://fedex.com/ws/ship/v19}DropoffType"/>
 *         &lt;element name="ServiceType" type="{http://fedex.com/ws/ship/v19}ServiceType"/>
 *         &lt;element name="PackagingType" type="{http://fedex.com/ws/ship/v19}PackagingType"/>
 *         &lt;element name="ManifestDetail" type="{http://fedex.com/ws/ship/v19}ShipmentManifestDetail" minOccurs="0"/>
 *         &lt;element name="TotalWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="TotalInsuredValue" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="PreferredCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipmentAuthorizationDetail" type="{http://fedex.com/ws/ship/v19}ShipmentAuthorizationDetail" minOccurs="0"/>
 *         &lt;element name="Shipper" type="{http://fedex.com/ws/ship/v19}Party"/>
 *         &lt;element name="Recipient" type="{http://fedex.com/ws/ship/v19}Party"/>
 *         &lt;element name="RecipientLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Origin" type="{http://fedex.com/ws/ship/v19}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="SoldTo" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *         &lt;element name="ShippingChargesPayment" type="{http://fedex.com/ws/ship/v19}Payment" minOccurs="0"/>
 *         &lt;element name="SpecialServicesRequested" type="{http://fedex.com/ws/ship/v19}ShipmentSpecialServicesRequested" minOccurs="0"/>
 *         &lt;element name="ExpressFreightDetail" type="{http://fedex.com/ws/ship/v19}ExpressFreightDetail" minOccurs="0"/>
 *         &lt;element name="FreightShipmentDetail" type="{http://fedex.com/ws/ship/v19}FreightShipmentDetail" minOccurs="0"/>
 *         &lt;element name="DeliveryInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VariableHandlingChargeDetail" type="{http://fedex.com/ws/ship/v19}VariableHandlingChargeDetail" minOccurs="0"/>
 *         &lt;element name="CustomsClearanceDetail" type="{http://fedex.com/ws/ship/v19}CustomsClearanceDetail" minOccurs="0"/>
 *         &lt;element name="PickupDetail" type="{http://fedex.com/ws/ship/v19}PickupDetail" minOccurs="0"/>
 *         &lt;element name="SmartPostDetail" type="{http://fedex.com/ws/ship/v19}SmartPostShipmentDetail" minOccurs="0"/>
 *         &lt;element name="BlockInsightVisibility" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LabelSpecification" type="{http://fedex.com/ws/ship/v19}LabelSpecification"/>
 *         &lt;element name="ShippingDocumentSpecification" type="{http://fedex.com/ws/ship/v19}ShippingDocumentSpecification" minOccurs="0"/>
 *         &lt;element name="RateRequestTypes" type="{http://fedex.com/ws/ship/v19}RateRequestType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EdtRequestType" type="{http://fedex.com/ws/ship/v19}EdtRequestType" minOccurs="0"/>
 *         &lt;element name="MasterTrackingId" type="{http://fedex.com/ws/ship/v19}TrackingId" minOccurs="0"/>
 *         &lt;element name="PackageCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="ConfigurationData" type="{http://fedex.com/ws/ship/v19}ShipmentConfigurationData" minOccurs="0"/>
 *         &lt;element name="RequestedPackageLineItems" type="{http://fedex.com/ws/ship/v19}RequestedPackageLineItem" maxOccurs="999" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedShipment", propOrder = {
    "shipTimestamp",
    "dropoffType",
    "serviceType",
    "packagingType",
    "manifestDetail",
    "totalWeight",
    "totalInsuredValue",
    "preferredCurrency",
    "shipmentAuthorizationDetail",
    "shipper",
    "recipient",
    "recipientLocationNumber",
    "origin",
    "soldTo",
    "shippingChargesPayment",
    "specialServicesRequested",
    "expressFreightDetail",
    "freightShipmentDetail",
    "deliveryInstructions",
    "variableHandlingChargeDetail",
    "customsClearanceDetail",
    "pickupDetail",
    "smartPostDetail",
    "blockInsightVisibility",
    "labelSpecification",
    "shippingDocumentSpecification",
    "rateRequestTypes",
    "edtRequestType",
    "masterTrackingId",
    "packageCount",
    "configurationData",
    "requestedPackageLineItems"
})
public class RequestedShipment {

    @XmlElement(name = "ShipTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shipTimestamp;
    @XmlElement(name = "DropoffType", required = true)
    protected DropoffType dropoffType;
    @XmlElement(name = "ServiceType", required = true)
    protected ServiceType serviceType;
    @XmlElement(name = "PackagingType", required = true)
    protected PackagingType packagingType;
    @XmlElement(name = "ManifestDetail")
    protected ShipmentManifestDetail manifestDetail;
    @XmlElement(name = "TotalWeight")
    protected Weight totalWeight;
    @XmlElement(name = "TotalInsuredValue")
    protected Money totalInsuredValue;
    @XmlElement(name = "PreferredCurrency")
    protected String preferredCurrency;
    @XmlElement(name = "ShipmentAuthorizationDetail")
    protected ShipmentAuthorizationDetail shipmentAuthorizationDetail;
    @XmlElement(name = "Shipper", required = true)
    protected Party shipper;
    @XmlElement(name = "Recipient", required = true)
    protected Party recipient;
    @XmlElement(name = "RecipientLocationNumber")
    protected String recipientLocationNumber;
    @XmlElement(name = "Origin")
    protected ContactAndAddress origin;
    @XmlElement(name = "SoldTo")
    protected Party soldTo;
    @XmlElement(name = "ShippingChargesPayment")
    protected Payment shippingChargesPayment;
    @XmlElement(name = "SpecialServicesRequested")
    protected ShipmentSpecialServicesRequested specialServicesRequested;
    @XmlElement(name = "ExpressFreightDetail")
    protected ExpressFreightDetail expressFreightDetail;
    @XmlElement(name = "FreightShipmentDetail")
    protected FreightShipmentDetail freightShipmentDetail;
    @XmlElement(name = "DeliveryInstructions")
    protected String deliveryInstructions;
    @XmlElement(name = "VariableHandlingChargeDetail")
    protected VariableHandlingChargeDetail variableHandlingChargeDetail;
    @XmlElement(name = "CustomsClearanceDetail")
    protected CustomsClearanceDetail customsClearanceDetail;
    @XmlElement(name = "PickupDetail")
    protected PickupDetail pickupDetail;
    @XmlElement(name = "SmartPostDetail")
    protected SmartPostShipmentDetail smartPostDetail;
    @XmlElement(name = "BlockInsightVisibility")
    protected Boolean blockInsightVisibility;
    @XmlElement(name = "LabelSpecification", required = true)
    protected LabelSpecification labelSpecification;
    @XmlElement(name = "ShippingDocumentSpecification")
    protected ShippingDocumentSpecification shippingDocumentSpecification;
    @XmlElement(name = "RateRequestTypes")
    protected List<RateRequestType> rateRequestTypes;
    @XmlElement(name = "EdtRequestType")
    protected EdtRequestType edtRequestType;
    @XmlElement(name = "MasterTrackingId")
    protected TrackingId masterTrackingId;
    @XmlElement(name = "PackageCount", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger packageCount;
    @XmlElement(name = "ConfigurationData")
    protected ShipmentConfigurationData configurationData;
    @XmlElement(name = "RequestedPackageLineItems")
    protected List<RequestedPackageLineItem> requestedPackageLineItems;

    /**
     * Obtiene el valor de la propiedad shipTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipTimestamp() {
        return shipTimestamp;
    }

    /**
     * Define el valor de la propiedad shipTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipTimestamp(XMLGregorianCalendar value) {
        this.shipTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad dropoffType.
     * 
     * @return
     *     possible object is
     *     {@link DropoffType }
     *     
     */
    public DropoffType getDropoffType() {
        return dropoffType;
    }

    /**
     * Define el valor de la propiedad dropoffType.
     * 
     * @param value
     *     allowed object is
     *     {@link DropoffType }
     *     
     */
    public void setDropoffType(DropoffType value) {
        this.dropoffType = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceType.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Define el valor de la propiedad serviceType.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setServiceType(ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Obtiene el valor de la propiedad packagingType.
     * 
     * @return
     *     possible object is
     *     {@link PackagingType }
     *     
     */
    public PackagingType getPackagingType() {
        return packagingType;
    }

    /**
     * Define el valor de la propiedad packagingType.
     * 
     * @param value
     *     allowed object is
     *     {@link PackagingType }
     *     
     */
    public void setPackagingType(PackagingType value) {
        this.packagingType = value;
    }

    /**
     * Obtiene el valor de la propiedad manifestDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentManifestDetail }
     *     
     */
    public ShipmentManifestDetail getManifestDetail() {
        return manifestDetail;
    }

    /**
     * Define el valor de la propiedad manifestDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentManifestDetail }
     *     
     */
    public void setManifestDetail(ShipmentManifestDetail value) {
        this.manifestDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad totalWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getTotalWeight() {
        return totalWeight;
    }

    /**
     * Define el valor de la propiedad totalWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setTotalWeight(Weight value) {
        this.totalWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad totalInsuredValue.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalInsuredValue() {
        return totalInsuredValue;
    }

    /**
     * Define el valor de la propiedad totalInsuredValue.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalInsuredValue(Money value) {
        this.totalInsuredValue = value;
    }

    /**
     * Obtiene el valor de la propiedad preferredCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredCurrency() {
        return preferredCurrency;
    }

    /**
     * Define el valor de la propiedad preferredCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredCurrency(String value) {
        this.preferredCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad shipmentAuthorizationDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentAuthorizationDetail }
     *     
     */
    public ShipmentAuthorizationDetail getShipmentAuthorizationDetail() {
        return shipmentAuthorizationDetail;
    }

    /**
     * Define el valor de la propiedad shipmentAuthorizationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentAuthorizationDetail }
     *     
     */
    public void setShipmentAuthorizationDetail(ShipmentAuthorizationDetail value) {
        this.shipmentAuthorizationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad shipper.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getShipper() {
        return shipper;
    }

    /**
     * Define el valor de la propiedad shipper.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setShipper(Party value) {
        this.shipper = value;
    }

    /**
     * Obtiene el valor de la propiedad recipient.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getRecipient() {
        return recipient;
    }

    /**
     * Define el valor de la propiedad recipient.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setRecipient(Party value) {
        this.recipient = value;
    }

    /**
     * Obtiene el valor de la propiedad recipientLocationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientLocationNumber() {
        return recipientLocationNumber;
    }

    /**
     * Define el valor de la propiedad recipientLocationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientLocationNumber(String value) {
        this.recipientLocationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad origin.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getOrigin() {
        return origin;
    }

    /**
     * Define el valor de la propiedad origin.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setOrigin(ContactAndAddress value) {
        this.origin = value;
    }

    /**
     * Obtiene el valor de la propiedad soldTo.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getSoldTo() {
        return soldTo;
    }

    /**
     * Define el valor de la propiedad soldTo.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setSoldTo(Party value) {
        this.soldTo = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingChargesPayment.
     * 
     * @return
     *     possible object is
     *     {@link Payment }
     *     
     */
    public Payment getShippingChargesPayment() {
        return shippingChargesPayment;
    }

    /**
     * Define el valor de la propiedad shippingChargesPayment.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment }
     *     
     */
    public void setShippingChargesPayment(Payment value) {
        this.shippingChargesPayment = value;
    }

    /**
     * Obtiene el valor de la propiedad specialServicesRequested.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentSpecialServicesRequested }
     *     
     */
    public ShipmentSpecialServicesRequested getSpecialServicesRequested() {
        return specialServicesRequested;
    }

    /**
     * Define el valor de la propiedad specialServicesRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentSpecialServicesRequested }
     *     
     */
    public void setSpecialServicesRequested(ShipmentSpecialServicesRequested value) {
        this.specialServicesRequested = value;
    }

    /**
     * Obtiene el valor de la propiedad expressFreightDetail.
     * 
     * @return
     *     possible object is
     *     {@link ExpressFreightDetail }
     *     
     */
    public ExpressFreightDetail getExpressFreightDetail() {
        return expressFreightDetail;
    }

    /**
     * Define el valor de la propiedad expressFreightDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressFreightDetail }
     *     
     */
    public void setExpressFreightDetail(ExpressFreightDetail value) {
        this.expressFreightDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad freightShipmentDetail.
     * 
     * @return
     *     possible object is
     *     {@link FreightShipmentDetail }
     *     
     */
    public FreightShipmentDetail getFreightShipmentDetail() {
        return freightShipmentDetail;
    }

    /**
     * Define el valor de la propiedad freightShipmentDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightShipmentDetail }
     *     
     */
    public void setFreightShipmentDetail(FreightShipmentDetail value) {
        this.freightShipmentDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryInstructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    /**
     * Define el valor de la propiedad deliveryInstructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryInstructions(String value) {
        this.deliveryInstructions = value;
    }

    /**
     * Obtiene el valor de la propiedad variableHandlingChargeDetail.
     * 
     * @return
     *     possible object is
     *     {@link VariableHandlingChargeDetail }
     *     
     */
    public VariableHandlingChargeDetail getVariableHandlingChargeDetail() {
        return variableHandlingChargeDetail;
    }

    /**
     * Define el valor de la propiedad variableHandlingChargeDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableHandlingChargeDetail }
     *     
     */
    public void setVariableHandlingChargeDetail(VariableHandlingChargeDetail value) {
        this.variableHandlingChargeDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad customsClearanceDetail.
     * 
     * @return
     *     possible object is
     *     {@link CustomsClearanceDetail }
     *     
     */
    public CustomsClearanceDetail getCustomsClearanceDetail() {
        return customsClearanceDetail;
    }

    /**
     * Define el valor de la propiedad customsClearanceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsClearanceDetail }
     *     
     */
    public void setCustomsClearanceDetail(CustomsClearanceDetail value) {
        this.customsClearanceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad pickupDetail.
     * 
     * @return
     *     possible object is
     *     {@link PickupDetail }
     *     
     */
    public PickupDetail getPickupDetail() {
        return pickupDetail;
    }

    /**
     * Define el valor de la propiedad pickupDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupDetail }
     *     
     */
    public void setPickupDetail(PickupDetail value) {
        this.pickupDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad smartPostDetail.
     * 
     * @return
     *     possible object is
     *     {@link SmartPostShipmentDetail }
     *     
     */
    public SmartPostShipmentDetail getSmartPostDetail() {
        return smartPostDetail;
    }

    /**
     * Define el valor de la propiedad smartPostDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link SmartPostShipmentDetail }
     *     
     */
    public void setSmartPostDetail(SmartPostShipmentDetail value) {
        this.smartPostDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad blockInsightVisibility.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlockInsightVisibility() {
        return blockInsightVisibility;
    }

    /**
     * Define el valor de la propiedad blockInsightVisibility.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlockInsightVisibility(Boolean value) {
        this.blockInsightVisibility = value;
    }

    /**
     * Obtiene el valor de la propiedad labelSpecification.
     * 
     * @return
     *     possible object is
     *     {@link LabelSpecification }
     *     
     */
    public LabelSpecification getLabelSpecification() {
        return labelSpecification;
    }

    /**
     * Define el valor de la propiedad labelSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelSpecification }
     *     
     */
    public void setLabelSpecification(LabelSpecification value) {
        this.labelSpecification = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingDocumentSpecification.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentSpecification }
     *     
     */
    public ShippingDocumentSpecification getShippingDocumentSpecification() {
        return shippingDocumentSpecification;
    }

    /**
     * Define el valor de la propiedad shippingDocumentSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentSpecification }
     *     
     */
    public void setShippingDocumentSpecification(ShippingDocumentSpecification value) {
        this.shippingDocumentSpecification = value;
    }

    /**
     * Gets the value of the rateRequestTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rateRequestTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRateRequestTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RateRequestType }
     * 
     * 
     */
    public List<RateRequestType> getRateRequestTypes() {
        if (rateRequestTypes == null) {
            rateRequestTypes = new ArrayList<RateRequestType>();
        }
        return this.rateRequestTypes;
    }

    /**
     * Obtiene el valor de la propiedad edtRequestType.
     * 
     * @return
     *     possible object is
     *     {@link EdtRequestType }
     *     
     */
    public EdtRequestType getEdtRequestType() {
        return edtRequestType;
    }

    /**
     * Define el valor de la propiedad edtRequestType.
     * 
     * @param value
     *     allowed object is
     *     {@link EdtRequestType }
     *     
     */
    public void setEdtRequestType(EdtRequestType value) {
        this.edtRequestType = value;
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
     * Obtiene el valor de la propiedad packageCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPackageCount() {
        return packageCount;
    }

    /**
     * Define el valor de la propiedad packageCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPackageCount(BigInteger value) {
        this.packageCount = value;
    }

    /**
     * Obtiene el valor de la propiedad configurationData.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentConfigurationData }
     *     
     */
    public ShipmentConfigurationData getConfigurationData() {
        return configurationData;
    }

    /**
     * Define el valor de la propiedad configurationData.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentConfigurationData }
     *     
     */
    public void setConfigurationData(ShipmentConfigurationData value) {
        this.configurationData = value;
    }

    /**
     * Gets the value of the requestedPackageLineItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestedPackageLineItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestedPackageLineItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestedPackageLineItem }
     * 
     * 
     */
    public List<RequestedPackageLineItem> getRequestedPackageLineItems() {
        if (requestedPackageLineItems == null) {
            requestedPackageLineItems = new ArrayList<RequestedPackageLineItem>();
        }
        return this.requestedPackageLineItems;
    }

    public void setRequestedPackageLineItems(List<RequestedPackageLineItem> requestedPackageLineItems) {
        this.requestedPackageLineItems = requestedPackageLineItems;
    }
    
    

}
