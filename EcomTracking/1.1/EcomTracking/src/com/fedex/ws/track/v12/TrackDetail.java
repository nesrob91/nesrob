
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
 * <p>Clase Java para TrackDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Notification" type="{http://fedex.com/ws/track/v12}Notification" minOccurs="0"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Barcode" type="{http://fedex.com/ws/track/v12}StringBarcode" minOccurs="0"/>
 *         &lt;element name="TrackingNumberUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusDetail" type="{http://fedex.com/ws/track/v12}TrackStatusDetail" minOccurs="0"/>
 *         &lt;element name="InformationNotes" type="{http://fedex.com/ws/track/v12}TrackInformationNoteDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CustomerExceptionRequests" type="{http://fedex.com/ws/track/v12}CustomerExceptionRequestDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Reconciliation" type="{http://fedex.com/ws/track/v12}TrackReconciliation" minOccurs="0"/>
 *         &lt;element name="ServiceCommitMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationServiceArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationServiceAreaDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarrierCode" type="{http://fedex.com/ws/track/v12}CarrierCodeType" minOccurs="0"/>
 *         &lt;element name="OperatingCompany" type="{http://fedex.com/ws/track/v12}OperatingCompanyType" minOccurs="0"/>
 *         &lt;element name="OperatingCompanyOrCarrierDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CartageAgentCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductionLocationContactAndAddress" type="{http://fedex.com/ws/track/v12}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="OtherIdentifiers" type="{http://fedex.com/ws/track/v12}TrackOtherIdentifierDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FormId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://fedex.com/ws/track/v12}TrackServiceDescriptionDetail" minOccurs="0"/>
 *         &lt;element name="PackageWeight" type="{http://fedex.com/ws/track/v12}Weight" minOccurs="0"/>
 *         &lt;element name="PackageDimensions" type="{http://fedex.com/ws/track/v12}Dimensions" minOccurs="0"/>
 *         &lt;element name="PackageDimensionalWeight" type="{http://fedex.com/ws/track/v12}Weight" minOccurs="0"/>
 *         &lt;element name="ShipmentWeight" type="{http://fedex.com/ws/track/v12}Weight" minOccurs="0"/>
 *         &lt;element name="Packaging" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackagingType" type="{http://fedex.com/ws/track/v12}PackagingType" minOccurs="0"/>
 *         &lt;element name="PhysicalPackagingType" type="{http://fedex.com/ws/track/v12}PhysicalPackagingType" minOccurs="0"/>
 *         &lt;element name="PackageSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="PackageCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="CreatorSoftwareId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Charges" type="{http://fedex.com/ws/track/v12}TrackChargeDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://fedex.com/ws/track/v12}TrackDetailAttributeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShipmentContents" type="{http://fedex.com/ws/track/v12}ContentRecord" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PackageContents" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ClearanceLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Commodities" type="{http://fedex.com/ws/track/v12}Commodity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReturnDetail" type="{http://fedex.com/ws/track/v12}TrackReturnDetail" minOccurs="0"/>
 *         &lt;element name="CustomsOptionDetails" type="{http://fedex.com/ws/track/v12}CustomsOptionDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdvanceNotificationDetail" type="{http://fedex.com/ws/track/v12}TrackAdvanceNotificationDetail" minOccurs="0"/>
 *         &lt;element name="SpecialHandlings" type="{http://fedex.com/ws/track/v12}TrackSpecialHandling" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Payments" type="{http://fedex.com/ws/track/v12}TrackPayment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Shipper" type="{http://fedex.com/ws/track/v12}Contact" minOccurs="0"/>
 *         &lt;element name="PossessionStatus" type="{http://fedex.com/ws/track/v12}TrackPossessionStatusType" minOccurs="0"/>
 *         &lt;element name="ShipperAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="OriginLocationAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="OriginStationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatesOrTimes" type="{http://fedex.com/ws/track/v12}TrackingDateOrTimestamp" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalTransitDistance" type="{http://fedex.com/ws/track/v12}Distance" minOccurs="0"/>
 *         &lt;element name="DistanceToDestination" type="{http://fedex.com/ws/track/v12}Distance" minOccurs="0"/>
 *         &lt;element name="SpecialInstructions" type="{http://fedex.com/ws/track/v12}TrackSpecialInstruction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Recipient" type="{http://fedex.com/ws/track/v12}Contact" minOccurs="0"/>
 *         &lt;element name="LastUpdatedDestinationAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="DestinationAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="HoldAtLocationContact" type="{http://fedex.com/ws/track/v12}Contact" minOccurs="0"/>
 *         &lt;element name="HoldAtLocationAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="DestinationStationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationLocationAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="DestinationLocationType" type="{http://fedex.com/ws/track/v12}FedExLocationType" minOccurs="0"/>
 *         &lt;element name="DestinationLocationTimeZoneOffset" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActualDeliveryAddress" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="OfficeOrderDeliveryMethod" type="{http://fedex.com/ws/track/v12}OfficeOrderDeliveryMethodType" minOccurs="0"/>
 *         &lt;element name="DeliveryLocationType" type="{http://fedex.com/ws/track/v12}TrackDeliveryLocationType" minOccurs="0"/>
 *         &lt;element name="DeliveryLocationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryAttempts" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="DeliverySignatureName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PieceCountVerificationDetails" type="{http://fedex.com/ws/track/v12}PieceCountVerificationDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalUniqueAddressCountInConsolidation" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="AvailableImages" type="{http://fedex.com/ws/track/v12}AvailableImagesDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Signature" type="{http://fedex.com/ws/track/v12}SignatureImageDetail" minOccurs="0"/>
 *         &lt;element name="NotificationEventsAvailable" type="{http://fedex.com/ws/track/v12}NotificationEventType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SplitShipmentParts" type="{http://fedex.com/ws/track/v12}TrackSplitShipmentPart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DeliveryOptionEligibilityDetails" type="{http://fedex.com/ws/track/v12}DeliveryOptionEligibilityDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Events" type="{http://fedex.com/ws/track/v12}TrackEvent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackDetail", propOrder = {
    "notification",
    "trackingNumber",
    "barcode",
    "trackingNumberUniqueIdentifier",
    "statusDetail",
    "informationNotes",
    "customerExceptionRequests",
    "reconciliation",
    "serviceCommitMessage",
    "destinationServiceArea",
    "destinationServiceAreaDescription",
    "carrierCode",
    "operatingCompany",
    "operatingCompanyOrCarrierDescription",
    "cartageAgentCompanyName",
    "productionLocationContactAndAddress",
    "otherIdentifiers",
    "formId",
    "service",
    "packageWeight",
    "packageDimensions",
    "packageDimensionalWeight",
    "shipmentWeight",
    "packaging",
    "packagingType",
    "physicalPackagingType",
    "packageSequenceNumber",
    "packageCount",
    "creatorSoftwareId",
    "charges",
    "nickName",
    "notes",
    "attributes",
    "shipmentContents",
    "packageContents",
    "clearanceLocationCode",
    "commodities",
    "returnDetail",
    "customsOptionDetails",
    "advanceNotificationDetail",
    "specialHandlings",
    "payments",
    "shipper",
    "possessionStatus",
    "shipperAddress",
    "originLocationAddress",
    "originStationId",
    "datesOrTimes",
    "totalTransitDistance",
    "distanceToDestination",
    "specialInstructions",
    "recipient",
    "lastUpdatedDestinationAddress",
    "destinationAddress",
    "holdAtLocationContact",
    "holdAtLocationAddress",
    "destinationStationId",
    "destinationLocationAddress",
    "destinationLocationType",
    "destinationLocationTimeZoneOffset",
    "actualDeliveryAddress",
    "officeOrderDeliveryMethod",
    "deliveryLocationType",
    "deliveryLocationDescription",
    "deliveryAttempts",
    "deliverySignatureName",
    "pieceCountVerificationDetails",
    "totalUniqueAddressCountInConsolidation",
    "availableImages",
    "signature",
    "notificationEventsAvailable",
    "splitShipmentParts",
    "deliveryOptionEligibilityDetails",
    "events"
})
public class TrackDetail {

    @XmlElement(name = "Notification")
    protected Notification notification;
    @XmlElement(name = "TrackingNumber")
    protected String trackingNumber;
    @XmlElement(name = "Barcode")
    protected StringBarcode barcode;
    @XmlElement(name = "TrackingNumberUniqueIdentifier")
    protected String trackingNumberUniqueIdentifier;
    @XmlElement(name = "StatusDetail")
    protected TrackStatusDetail statusDetail;
    @XmlElement(name = "InformationNotes")
    protected List<TrackInformationNoteDetail> informationNotes;
    @XmlElement(name = "CustomerExceptionRequests")
    protected List<CustomerExceptionRequestDetail> customerExceptionRequests;
    @XmlElement(name = "Reconciliation")
    protected TrackReconciliation reconciliation;
    @XmlElement(name = "ServiceCommitMessage")
    protected String serviceCommitMessage;
    @XmlElement(name = "DestinationServiceArea")
    protected String destinationServiceArea;
    @XmlElement(name = "DestinationServiceAreaDescription")
    protected String destinationServiceAreaDescription;
    @XmlElement(name = "CarrierCode")
    protected CarrierCodeType carrierCode;
    @XmlElement(name = "OperatingCompany")
    protected OperatingCompanyType operatingCompany;
    @XmlElement(name = "OperatingCompanyOrCarrierDescription")
    protected String operatingCompanyOrCarrierDescription;
    @XmlElement(name = "CartageAgentCompanyName")
    protected String cartageAgentCompanyName;
    @XmlElement(name = "ProductionLocationContactAndAddress")
    protected ContactAndAddress productionLocationContactAndAddress;
    @XmlElement(name = "OtherIdentifiers")
    protected List<TrackOtherIdentifierDetail> otherIdentifiers;
    @XmlElement(name = "FormId")
    protected String formId;
    @XmlElement(name = "Service")
    protected TrackServiceDescriptionDetail service;
    @XmlElement(name = "PackageWeight")
    protected Weight packageWeight;
    @XmlElement(name = "PackageDimensions")
    protected Dimensions packageDimensions;
    @XmlElement(name = "PackageDimensionalWeight")
    protected Weight packageDimensionalWeight;
    @XmlElement(name = "ShipmentWeight")
    protected Weight shipmentWeight;
    @XmlElement(name = "Packaging")
    protected String packaging;
    @XmlElement(name = "PackagingType")
    protected PackagingType packagingType;
    @XmlElement(name = "PhysicalPackagingType")
    protected PhysicalPackagingType physicalPackagingType;
    @XmlElement(name = "PackageSequenceNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger packageSequenceNumber;
    @XmlElement(name = "PackageCount")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger packageCount;
    @XmlElement(name = "CreatorSoftwareId")
    protected String creatorSoftwareId;
    @XmlElement(name = "Charges")
    protected List<TrackChargeDetail> charges;
    @XmlElement(name = "NickName")
    protected String nickName;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlElement(name = "Attributes")
    protected List<TrackDetailAttributeType> attributes;
    @XmlElement(name = "ShipmentContents")
    protected List<ContentRecord> shipmentContents;
    @XmlElement(name = "PackageContents")
    protected List<String> packageContents;
    @XmlElement(name = "ClearanceLocationCode")
    protected String clearanceLocationCode;
    @XmlElement(name = "Commodities")
    protected List<Commodity> commodities;
    @XmlElement(name = "ReturnDetail")
    protected TrackReturnDetail returnDetail;
    @XmlElement(name = "CustomsOptionDetails")
    protected List<CustomsOptionDetail> customsOptionDetails;
    @XmlElement(name = "AdvanceNotificationDetail")
    protected TrackAdvanceNotificationDetail advanceNotificationDetail;
    @XmlElement(name = "SpecialHandlings")
    protected List<TrackSpecialHandling> specialHandlings;
    @XmlElement(name = "Payments")
    protected List<TrackPayment> payments;
    @XmlElement(name = "Shipper")
    protected Contact shipper;
    @XmlElement(name = "PossessionStatus")
    protected TrackPossessionStatusType possessionStatus;
    @XmlElement(name = "ShipperAddress")
    protected Address shipperAddress;
    @XmlElement(name = "OriginLocationAddress")
    protected Address originLocationAddress;
    @XmlElement(name = "OriginStationId")
    protected String originStationId;
    @XmlElement(name = "DatesOrTimes")
    protected List<TrackingDateOrTimestamp> datesOrTimes;
    @XmlElement(name = "TotalTransitDistance")
    protected Distance totalTransitDistance;
    @XmlElement(name = "DistanceToDestination")
    protected Distance distanceToDestination;
    @XmlElement(name = "SpecialInstructions")
    protected List<TrackSpecialInstruction> specialInstructions;
    @XmlElement(name = "Recipient")
    protected Contact recipient;
    @XmlElement(name = "LastUpdatedDestinationAddress")
    protected Address lastUpdatedDestinationAddress;
    @XmlElement(name = "DestinationAddress")
    protected Address destinationAddress;
    @XmlElement(name = "HoldAtLocationContact")
    protected Contact holdAtLocationContact;
    @XmlElement(name = "HoldAtLocationAddress")
    protected Address holdAtLocationAddress;
    @XmlElement(name = "DestinationStationId")
    protected String destinationStationId;
    @XmlElement(name = "DestinationLocationAddress")
    protected Address destinationLocationAddress;
    @XmlElement(name = "DestinationLocationType")
    protected FedExLocationType destinationLocationType;
    @XmlElement(name = "DestinationLocationTimeZoneOffset")
    protected String destinationLocationTimeZoneOffset;
    @XmlElement(name = "ActualDeliveryAddress")
    protected Address actualDeliveryAddress;
    @XmlElement(name = "OfficeOrderDeliveryMethod")
    protected OfficeOrderDeliveryMethodType officeOrderDeliveryMethod;
    @XmlElement(name = "DeliveryLocationType")
    protected TrackDeliveryLocationType deliveryLocationType;
    @XmlElement(name = "DeliveryLocationDescription")
    protected String deliveryLocationDescription;
    @XmlElement(name = "DeliveryAttempts")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger deliveryAttempts;
    @XmlElement(name = "DeliverySignatureName")
    protected String deliverySignatureName;
    @XmlElement(name = "PieceCountVerificationDetails")
    protected List<PieceCountVerificationDetail> pieceCountVerificationDetails;
    @XmlElement(name = "TotalUniqueAddressCountInConsolidation")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totalUniqueAddressCountInConsolidation;
    @XmlElement(name = "AvailableImages")
    protected List<AvailableImagesDetail> availableImages;
    @XmlElement(name = "Signature")
    protected SignatureImageDetail signature;
    @XmlElement(name = "NotificationEventsAvailable")
    protected List<NotificationEventType> notificationEventsAvailable;
    @XmlElement(name = "SplitShipmentParts")
    protected List<TrackSplitShipmentPart> splitShipmentParts;
    @XmlElement(name = "DeliveryOptionEligibilityDetails")
    protected List<DeliveryOptionEligibilityDetail> deliveryOptionEligibilityDetails;
    @XmlElement(name = "Events")
    protected List<TrackEvent> events;

    /**
     * Obtiene el valor de la propiedad notification.
     * 
     * @return
     *     possible object is
     *     {@link Notification }
     *     
     */
    public Notification getNotification() {
        return notification;
    }

    /**
     * Define el valor de la propiedad notification.
     * 
     * @param value
     *     allowed object is
     *     {@link Notification }
     *     
     */
    public void setNotification(Notification value) {
        this.notification = value;
    }

    /**
     * Obtiene el valor de la propiedad trackingNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Define el valor de la propiedad trackingNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad barcode.
     * 
     * @return
     *     possible object is
     *     {@link StringBarcode }
     *     
     */
    public StringBarcode getBarcode() {
        return barcode;
    }

    /**
     * Define el valor de la propiedad barcode.
     * 
     * @param value
     *     allowed object is
     *     {@link StringBarcode }
     *     
     */
    public void setBarcode(StringBarcode value) {
        this.barcode = value;
    }

    /**
     * Obtiene el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumberUniqueIdentifier() {
        return trackingNumberUniqueIdentifier;
    }

    /**
     * Define el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumberUniqueIdentifier(String value) {
        this.trackingNumberUniqueIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad statusDetail.
     * 
     * @return
     *     possible object is
     *     {@link TrackStatusDetail }
     *     
     */
    public TrackStatusDetail getStatusDetail() {
        return statusDetail;
    }

    /**
     * Define el valor de la propiedad statusDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackStatusDetail }
     *     
     */
    public void setStatusDetail(TrackStatusDetail value) {
        this.statusDetail = value;
    }

    /**
     * Gets the value of the informationNotes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationNotes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationNotes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackInformationNoteDetail }
     * 
     * 
     */
    public List<TrackInformationNoteDetail> getInformationNotes() {
        if (informationNotes == null) {
            informationNotes = new ArrayList<TrackInformationNoteDetail>();
        }
        return this.informationNotes;
    }

    /**
     * Gets the value of the customerExceptionRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerExceptionRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerExceptionRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerExceptionRequestDetail }
     * 
     * 
     */
    public List<CustomerExceptionRequestDetail> getCustomerExceptionRequests() {
        if (customerExceptionRequests == null) {
            customerExceptionRequests = new ArrayList<CustomerExceptionRequestDetail>();
        }
        return this.customerExceptionRequests;
    }

    /**
     * Obtiene el valor de la propiedad reconciliation.
     * 
     * @return
     *     possible object is
     *     {@link TrackReconciliation }
     *     
     */
    public TrackReconciliation getReconciliation() {
        return reconciliation;
    }

    /**
     * Define el valor de la propiedad reconciliation.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackReconciliation }
     *     
     */
    public void setReconciliation(TrackReconciliation value) {
        this.reconciliation = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceCommitMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCommitMessage() {
        return serviceCommitMessage;
    }

    /**
     * Define el valor de la propiedad serviceCommitMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCommitMessage(String value) {
        this.serviceCommitMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationServiceArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationServiceArea() {
        return destinationServiceArea;
    }

    /**
     * Define el valor de la propiedad destinationServiceArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationServiceArea(String value) {
        this.destinationServiceArea = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationServiceAreaDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationServiceAreaDescription() {
        return destinationServiceAreaDescription;
    }

    /**
     * Define el valor de la propiedad destinationServiceAreaDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationServiceAreaDescription(String value) {
        this.destinationServiceAreaDescription = value;
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
     * Obtiene el valor de la propiedad operatingCompany.
     * 
     * @return
     *     possible object is
     *     {@link OperatingCompanyType }
     *     
     */
    public OperatingCompanyType getOperatingCompany() {
        return operatingCompany;
    }

    /**
     * Define el valor de la propiedad operatingCompany.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingCompanyType }
     *     
     */
    public void setOperatingCompany(OperatingCompanyType value) {
        this.operatingCompany = value;
    }

    /**
     * Obtiene el valor de la propiedad operatingCompanyOrCarrierDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatingCompanyOrCarrierDescription() {
        return operatingCompanyOrCarrierDescription;
    }

    /**
     * Define el valor de la propiedad operatingCompanyOrCarrierDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatingCompanyOrCarrierDescription(String value) {
        this.operatingCompanyOrCarrierDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad cartageAgentCompanyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartageAgentCompanyName() {
        return cartageAgentCompanyName;
    }

    /**
     * Define el valor de la propiedad cartageAgentCompanyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartageAgentCompanyName(String value) {
        this.cartageAgentCompanyName = value;
    }

    /**
     * Obtiene el valor de la propiedad productionLocationContactAndAddress.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getProductionLocationContactAndAddress() {
        return productionLocationContactAndAddress;
    }

    /**
     * Define el valor de la propiedad productionLocationContactAndAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setProductionLocationContactAndAddress(ContactAndAddress value) {
        this.productionLocationContactAndAddress = value;
    }

    /**
     * Gets the value of the otherIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackOtherIdentifierDetail }
     * 
     * 
     */
    public List<TrackOtherIdentifierDetail> getOtherIdentifiers() {
        if (otherIdentifiers == null) {
            otherIdentifiers = new ArrayList<TrackOtherIdentifierDetail>();
        }
        return this.otherIdentifiers;
    }

    /**
     * Obtiene el valor de la propiedad formId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormId() {
        return formId;
    }

    /**
     * Define el valor de la propiedad formId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormId(String value) {
        this.formId = value;
    }

    /**
     * Obtiene el valor de la propiedad service.
     * 
     * @return
     *     possible object is
     *     {@link TrackServiceDescriptionDetail }
     *     
     */
    public TrackServiceDescriptionDetail getService() {
        return service;
    }

    /**
     * Define el valor de la propiedad service.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackServiceDescriptionDetail }
     *     
     */
    public void setService(TrackServiceDescriptionDetail value) {
        this.service = value;
    }

    /**
     * Obtiene el valor de la propiedad packageWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getPackageWeight() {
        return packageWeight;
    }

    /**
     * Define el valor de la propiedad packageWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setPackageWeight(Weight value) {
        this.packageWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad packageDimensions.
     * 
     * @return
     *     possible object is
     *     {@link Dimensions }
     *     
     */
    public Dimensions getPackageDimensions() {
        return packageDimensions;
    }

    /**
     * Define el valor de la propiedad packageDimensions.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimensions }
     *     
     */
    public void setPackageDimensions(Dimensions value) {
        this.packageDimensions = value;
    }

    /**
     * Obtiene el valor de la propiedad packageDimensionalWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getPackageDimensionalWeight() {
        return packageDimensionalWeight;
    }

    /**
     * Define el valor de la propiedad packageDimensionalWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setPackageDimensionalWeight(Weight value) {
        this.packageDimensionalWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad shipmentWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getShipmentWeight() {
        return shipmentWeight;
    }

    /**
     * Define el valor de la propiedad shipmentWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setShipmentWeight(Weight value) {
        this.shipmentWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad packaging.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * Define el valor de la propiedad packaging.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackaging(String value) {
        this.packaging = value;
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
     * Obtiene el valor de la propiedad physicalPackagingType.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalPackagingType }
     *     
     */
    public PhysicalPackagingType getPhysicalPackagingType() {
        return physicalPackagingType;
    }

    /**
     * Define el valor de la propiedad physicalPackagingType.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalPackagingType }
     *     
     */
    public void setPhysicalPackagingType(PhysicalPackagingType value) {
        this.physicalPackagingType = value;
    }

    /**
     * Obtiene el valor de la propiedad packageSequenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPackageSequenceNumber() {
        return packageSequenceNumber;
    }

    /**
     * Define el valor de la propiedad packageSequenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPackageSequenceNumber(BigInteger value) {
        this.packageSequenceNumber = value;
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
     * Obtiene el valor de la propiedad creatorSoftwareId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorSoftwareId() {
        return creatorSoftwareId;
    }

    /**
     * Define el valor de la propiedad creatorSoftwareId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorSoftwareId(String value) {
        this.creatorSoftwareId = value;
    }

    /**
     * Gets the value of the charges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackChargeDetail }
     * 
     * 
     */
    public List<TrackChargeDetail> getCharges() {
        if (charges == null) {
            charges = new ArrayList<TrackChargeDetail>();
        }
        return this.charges;
    }

    /**
     * Obtiene el valor de la propiedad nickName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Define el valor de la propiedad nickName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

    /**
     * Obtiene el valor de la propiedad notes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Define el valor de la propiedad notes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
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
     * {@link TrackDetailAttributeType }
     * 
     * 
     */
    public List<TrackDetailAttributeType> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<TrackDetailAttributeType>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the shipmentContents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipmentContents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipmentContents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentRecord }
     * 
     * 
     */
    public List<ContentRecord> getShipmentContents() {
        if (shipmentContents == null) {
            shipmentContents = new ArrayList<ContentRecord>();
        }
        return this.shipmentContents;
    }

    /**
     * Gets the value of the packageContents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageContents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageContents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPackageContents() {
        if (packageContents == null) {
            packageContents = new ArrayList<String>();
        }
        return this.packageContents;
    }

    /**
     * Obtiene el valor de la propiedad clearanceLocationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearanceLocationCode() {
        return clearanceLocationCode;
    }

    /**
     * Define el valor de la propiedad clearanceLocationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearanceLocationCode(String value) {
        this.clearanceLocationCode = value;
    }

    /**
     * Gets the value of the commodities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commodities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommodities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Commodity }
     * 
     * 
     */
    public List<Commodity> getCommodities() {
        if (commodities == null) {
            commodities = new ArrayList<Commodity>();
        }
        return this.commodities;
    }

    /**
     * Obtiene el valor de la propiedad returnDetail.
     * 
     * @return
     *     possible object is
     *     {@link TrackReturnDetail }
     *     
     */
    public TrackReturnDetail getReturnDetail() {
        return returnDetail;
    }

    /**
     * Define el valor de la propiedad returnDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackReturnDetail }
     *     
     */
    public void setReturnDetail(TrackReturnDetail value) {
        this.returnDetail = value;
    }

    /**
     * Gets the value of the customsOptionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customsOptionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomsOptionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomsOptionDetail }
     * 
     * 
     */
    public List<CustomsOptionDetail> getCustomsOptionDetails() {
        if (customsOptionDetails == null) {
            customsOptionDetails = new ArrayList<CustomsOptionDetail>();
        }
        return this.customsOptionDetails;
    }

    /**
     * Obtiene el valor de la propiedad advanceNotificationDetail.
     * 
     * @return
     *     possible object is
     *     {@link TrackAdvanceNotificationDetail }
     *     
     */
    public TrackAdvanceNotificationDetail getAdvanceNotificationDetail() {
        return advanceNotificationDetail;
    }

    /**
     * Define el valor de la propiedad advanceNotificationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackAdvanceNotificationDetail }
     *     
     */
    public void setAdvanceNotificationDetail(TrackAdvanceNotificationDetail value) {
        this.advanceNotificationDetail = value;
    }

    /**
     * Gets the value of the specialHandlings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialHandlings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialHandlings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackSpecialHandling }
     * 
     * 
     */
    public List<TrackSpecialHandling> getSpecialHandlings() {
        if (specialHandlings == null) {
            specialHandlings = new ArrayList<TrackSpecialHandling>();
        }
        return this.specialHandlings;
    }

    /**
     * Gets the value of the payments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackPayment }
     * 
     * 
     */
    public List<TrackPayment> getPayments() {
        if (payments == null) {
            payments = new ArrayList<TrackPayment>();
        }
        return this.payments;
    }

    /**
     * Obtiene el valor de la propiedad shipper.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getShipper() {
        return shipper;
    }

    /**
     * Define el valor de la propiedad shipper.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setShipper(Contact value) {
        this.shipper = value;
    }

    /**
     * Obtiene el valor de la propiedad possessionStatus.
     * 
     * @return
     *     possible object is
     *     {@link TrackPossessionStatusType }
     *     
     */
    public TrackPossessionStatusType getPossessionStatus() {
        return possessionStatus;
    }

    /**
     * Define el valor de la propiedad possessionStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPossessionStatusType }
     *     
     */
    public void setPossessionStatus(TrackPossessionStatusType value) {
        this.possessionStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad shipperAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getShipperAddress() {
        return shipperAddress;
    }

    /**
     * Define el valor de la propiedad shipperAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setShipperAddress(Address value) {
        this.shipperAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad originLocationAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getOriginLocationAddress() {
        return originLocationAddress;
    }

    /**
     * Define el valor de la propiedad originLocationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setOriginLocationAddress(Address value) {
        this.originLocationAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad originStationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginStationId() {
        return originStationId;
    }

    /**
     * Define el valor de la propiedad originStationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginStationId(String value) {
        this.originStationId = value;
    }

    /**
     * Gets the value of the datesOrTimes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datesOrTimes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatesOrTimes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackingDateOrTimestamp }
     * 
     * 
     */
    public List<TrackingDateOrTimestamp> getDatesOrTimes() {
        if (datesOrTimes == null) {
            datesOrTimes = new ArrayList<TrackingDateOrTimestamp>();
        }
        return this.datesOrTimes;
    }

    /**
     * Obtiene el valor de la propiedad totalTransitDistance.
     * 
     * @return
     *     possible object is
     *     {@link Distance }
     *     
     */
    public Distance getTotalTransitDistance() {
        return totalTransitDistance;
    }

    /**
     * Define el valor de la propiedad totalTransitDistance.
     * 
     * @param value
     *     allowed object is
     *     {@link Distance }
     *     
     */
    public void setTotalTransitDistance(Distance value) {
        this.totalTransitDistance = value;
    }

    /**
     * Obtiene el valor de la propiedad distanceToDestination.
     * 
     * @return
     *     possible object is
     *     {@link Distance }
     *     
     */
    public Distance getDistanceToDestination() {
        return distanceToDestination;
    }

    /**
     * Define el valor de la propiedad distanceToDestination.
     * 
     * @param value
     *     allowed object is
     *     {@link Distance }
     *     
     */
    public void setDistanceToDestination(Distance value) {
        this.distanceToDestination = value;
    }

    /**
     * Gets the value of the specialInstructions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialInstructions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialInstructions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackSpecialInstruction }
     * 
     * 
     */
    public List<TrackSpecialInstruction> getSpecialInstructions() {
        if (specialInstructions == null) {
            specialInstructions = new ArrayList<TrackSpecialInstruction>();
        }
        return this.specialInstructions;
    }

    /**
     * Obtiene el valor de la propiedad recipient.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getRecipient() {
        return recipient;
    }

    /**
     * Define el valor de la propiedad recipient.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setRecipient(Contact value) {
        this.recipient = value;
    }

    /**
     * Obtiene el valor de la propiedad lastUpdatedDestinationAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getLastUpdatedDestinationAddress() {
        return lastUpdatedDestinationAddress;
    }

    /**
     * Define el valor de la propiedad lastUpdatedDestinationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setLastUpdatedDestinationAddress(Address value) {
        this.lastUpdatedDestinationAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Define el valor de la propiedad destinationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDestinationAddress(Address value) {
        this.destinationAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad holdAtLocationContact.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getHoldAtLocationContact() {
        return holdAtLocationContact;
    }

    /**
     * Define el valor de la propiedad holdAtLocationContact.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setHoldAtLocationContact(Contact value) {
        this.holdAtLocationContact = value;
    }

    /**
     * Obtiene el valor de la propiedad holdAtLocationAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getHoldAtLocationAddress() {
        return holdAtLocationAddress;
    }

    /**
     * Define el valor de la propiedad holdAtLocationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setHoldAtLocationAddress(Address value) {
        this.holdAtLocationAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationStationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationStationId() {
        return destinationStationId;
    }

    /**
     * Define el valor de la propiedad destinationStationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationStationId(String value) {
        this.destinationStationId = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDestinationLocationAddress() {
        return destinationLocationAddress;
    }

    /**
     * Define el valor de la propiedad destinationLocationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDestinationLocationAddress(Address value) {
        this.destinationLocationAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationType.
     * 
     * @return
     *     possible object is
     *     {@link FedExLocationType }
     *     
     */
    public FedExLocationType getDestinationLocationType() {
        return destinationLocationType;
    }

    /**
     * Define el valor de la propiedad destinationLocationType.
     * 
     * @param value
     *     allowed object is
     *     {@link FedExLocationType }
     *     
     */
    public void setDestinationLocationType(FedExLocationType value) {
        this.destinationLocationType = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationTimeZoneOffset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationLocationTimeZoneOffset() {
        return destinationLocationTimeZoneOffset;
    }

    /**
     * Define el valor de la propiedad destinationLocationTimeZoneOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationLocationTimeZoneOffset(String value) {
        this.destinationLocationTimeZoneOffset = value;
    }

    /**
     * Obtiene el valor de la propiedad actualDeliveryAddress.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getActualDeliveryAddress() {
        return actualDeliveryAddress;
    }

    /**
     * Define el valor de la propiedad actualDeliveryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setActualDeliveryAddress(Address value) {
        this.actualDeliveryAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad officeOrderDeliveryMethod.
     * 
     * @return
     *     possible object is
     *     {@link OfficeOrderDeliveryMethodType }
     *     
     */
    public OfficeOrderDeliveryMethodType getOfficeOrderDeliveryMethod() {
        return officeOrderDeliveryMethod;
    }

    /**
     * Define el valor de la propiedad officeOrderDeliveryMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link OfficeOrderDeliveryMethodType }
     *     
     */
    public void setOfficeOrderDeliveryMethod(OfficeOrderDeliveryMethodType value) {
        this.officeOrderDeliveryMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryLocationType.
     * 
     * @return
     *     possible object is
     *     {@link TrackDeliveryLocationType }
     *     
     */
    public TrackDeliveryLocationType getDeliveryLocationType() {
        return deliveryLocationType;
    }

    /**
     * Define el valor de la propiedad deliveryLocationType.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackDeliveryLocationType }
     *     
     */
    public void setDeliveryLocationType(TrackDeliveryLocationType value) {
        this.deliveryLocationType = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryLocationDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryLocationDescription() {
        return deliveryLocationDescription;
    }

    /**
     * Define el valor de la propiedad deliveryLocationDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryLocationDescription(String value) {
        this.deliveryLocationDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryAttempts.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeliveryAttempts() {
        return deliveryAttempts;
    }

    /**
     * Define el valor de la propiedad deliveryAttempts.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeliveryAttempts(BigInteger value) {
        this.deliveryAttempts = value;
    }

    /**
     * Obtiene el valor de la propiedad deliverySignatureName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverySignatureName() {
        return deliverySignatureName;
    }

    /**
     * Define el valor de la propiedad deliverySignatureName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverySignatureName(String value) {
        this.deliverySignatureName = value;
    }

    /**
     * Gets the value of the pieceCountVerificationDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pieceCountVerificationDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPieceCountVerificationDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PieceCountVerificationDetail }
     * 
     * 
     */
    public List<PieceCountVerificationDetail> getPieceCountVerificationDetails() {
        if (pieceCountVerificationDetails == null) {
            pieceCountVerificationDetails = new ArrayList<PieceCountVerificationDetail>();
        }
        return this.pieceCountVerificationDetails;
    }

    /**
     * Obtiene el valor de la propiedad totalUniqueAddressCountInConsolidation.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalUniqueAddressCountInConsolidation() {
        return totalUniqueAddressCountInConsolidation;
    }

    /**
     * Define el valor de la propiedad totalUniqueAddressCountInConsolidation.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalUniqueAddressCountInConsolidation(BigInteger value) {
        this.totalUniqueAddressCountInConsolidation = value;
    }

    /**
     * Gets the value of the availableImages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableImages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableImages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableImagesDetail }
     * 
     * 
     */
    public List<AvailableImagesDetail> getAvailableImages() {
        if (availableImages == null) {
            availableImages = new ArrayList<AvailableImagesDetail>();
        }
        return this.availableImages;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureImageDetail }
     *     
     */
    public SignatureImageDetail getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureImageDetail }
     *     
     */
    public void setSignature(SignatureImageDetail value) {
        this.signature = value;
    }

    /**
     * Gets the value of the notificationEventsAvailable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationEventsAvailable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationEventsAvailable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationEventType }
     * 
     * 
     */
    public List<NotificationEventType> getNotificationEventsAvailable() {
        if (notificationEventsAvailable == null) {
            notificationEventsAvailable = new ArrayList<NotificationEventType>();
        }
        return this.notificationEventsAvailable;
    }

    /**
     * Gets the value of the splitShipmentParts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splitShipmentParts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplitShipmentParts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackSplitShipmentPart }
     * 
     * 
     */
    public List<TrackSplitShipmentPart> getSplitShipmentParts() {
        if (splitShipmentParts == null) {
            splitShipmentParts = new ArrayList<TrackSplitShipmentPart>();
        }
        return this.splitShipmentParts;
    }

    /**
     * Gets the value of the deliveryOptionEligibilityDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryOptionEligibilityDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryOptionEligibilityDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryOptionEligibilityDetail }
     * 
     * 
     */
    public List<DeliveryOptionEligibilityDetail> getDeliveryOptionEligibilityDetails() {
        if (deliveryOptionEligibilityDetails == null) {
            deliveryOptionEligibilityDetails = new ArrayList<DeliveryOptionEligibilityDetail>();
        }
        return this.deliveryOptionEligibilityDetails;
    }

    /**
     * Gets the value of the events property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the events property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackEvent }
     * 
     * 
     */
    public List<TrackEvent> getEvents() {
        if (events == null) {
            events = new ArrayList<TrackEvent>();
        }
        return this.events;
    }

}
