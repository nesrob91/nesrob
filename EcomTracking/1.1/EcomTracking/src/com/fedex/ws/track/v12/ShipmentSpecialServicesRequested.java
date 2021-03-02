
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * These special services are available at the shipment level for some or all service types. If the shipper is requesting a special service which requires additional data (such as the COD amount), the shipment special service type must be present in the specialServiceTypes collection, and the supporting detail must be provided in the appropriate sub-object below.
 * 
 * <p>Clase Java para ShipmentSpecialServicesRequested complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentSpecialServicesRequested">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialServiceTypes" type="{http://fedex.com/ws/ship/v19}ShipmentSpecialServiceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CodDetail" type="{http://fedex.com/ws/ship/v19}CodDetail" minOccurs="0"/>
 *         &lt;element name="DeliveryOnInvoiceAcceptanceDetail" type="{http://fedex.com/ws/ship/v19}DeliveryOnInvoiceAcceptanceDetail" minOccurs="0"/>
 *         &lt;element name="HoldAtLocationDetail" type="{http://fedex.com/ws/ship/v19}HoldAtLocationDetail" minOccurs="0"/>
 *         &lt;element name="EventNotificationDetail" type="{http://fedex.com/ws/ship/v19}ShipmentEventNotificationDetail" minOccurs="0"/>
 *         &lt;element name="ReturnShipmentDetail" type="{http://fedex.com/ws/ship/v19}ReturnShipmentDetail" minOccurs="0"/>
 *         &lt;element name="PendingShipmentDetail" type="{http://fedex.com/ws/ship/v19}PendingShipmentDetail" minOccurs="0"/>
 *         &lt;element name="InternationalControlledExportDetail" type="{http://fedex.com/ws/ship/v19}InternationalControlledExportDetail" minOccurs="0"/>
 *         &lt;element name="InternationalTrafficInArmsRegulationsDetail" type="{http://fedex.com/ws/ship/v19}InternationalTrafficInArmsRegulationsDetail" minOccurs="0"/>
 *         &lt;element name="ShipmentDryIceDetail" type="{http://fedex.com/ws/ship/v19}ShipmentDryIceDetail" minOccurs="0"/>
 *         &lt;element name="HomeDeliveryPremiumDetail" type="{http://fedex.com/ws/ship/v19}HomeDeliveryPremiumDetail" minOccurs="0"/>
 *         &lt;element name="FreightGuaranteeDetail" type="{http://fedex.com/ws/ship/v19}FreightGuaranteeDetail" minOccurs="0"/>
 *         &lt;element name="EtdDetail" type="{http://fedex.com/ws/ship/v19}EtdDetail" minOccurs="0"/>
 *         &lt;element name="CustomDeliveryWindowDetail" type="{http://fedex.com/ws/ship/v19}CustomDeliveryWindowDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentSpecialServicesRequested", propOrder = {
    "specialServiceTypes",
    "codDetail",
    "deliveryOnInvoiceAcceptanceDetail",
    "holdAtLocationDetail",
    "eventNotificationDetail",
    "returnShipmentDetail",
    "pendingShipmentDetail",
    "internationalControlledExportDetail",
    "internationalTrafficInArmsRegulationsDetail",
    "shipmentDryIceDetail",
    "homeDeliveryPremiumDetail",
    "freightGuaranteeDetail",
    "etdDetail",
    "customDeliveryWindowDetail"
})
public class ShipmentSpecialServicesRequested {

    @XmlElement(name = "SpecialServiceTypes")
    protected List<ShipmentSpecialServiceType> specialServiceTypes;
    @XmlElement(name = "CodDetail")
    protected CodDetail codDetail;
    @XmlElement(name = "DeliveryOnInvoiceAcceptanceDetail")
    protected DeliveryOnInvoiceAcceptanceDetail deliveryOnInvoiceAcceptanceDetail;
    @XmlElement(name = "HoldAtLocationDetail")
    protected HoldAtLocationDetail holdAtLocationDetail;
    @XmlElement(name = "EventNotificationDetail")
    protected ShipmentEventNotificationDetail eventNotificationDetail;
    @XmlElement(name = "ReturnShipmentDetail")
    protected ReturnShipmentDetail returnShipmentDetail;
    @XmlElement(name = "PendingShipmentDetail")
    protected PendingShipmentDetail pendingShipmentDetail;
    @XmlElement(name = "InternationalControlledExportDetail")
    protected InternationalControlledExportDetail internationalControlledExportDetail;
    @XmlElement(name = "InternationalTrafficInArmsRegulationsDetail")
    protected InternationalTrafficInArmsRegulationsDetail internationalTrafficInArmsRegulationsDetail;
    @XmlElement(name = "ShipmentDryIceDetail")
    protected ShipmentDryIceDetail shipmentDryIceDetail;
    @XmlElement(name = "HomeDeliveryPremiumDetail")
    protected HomeDeliveryPremiumDetail homeDeliveryPremiumDetail;
    @XmlElement(name = "FreightGuaranteeDetail")
    protected FreightGuaranteeDetail freightGuaranteeDetail;
    @XmlElement(name = "EtdDetail")
    protected EtdDetail etdDetail;
    @XmlElement(name = "CustomDeliveryWindowDetail")
    protected CustomDeliveryWindowDetail customDeliveryWindowDetail;

    /**
     * Gets the value of the specialServiceTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialServiceTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialServiceTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentSpecialServiceType }
     * 
     * 
     */
    public List<ShipmentSpecialServiceType> getSpecialServiceTypes() {
        if (specialServiceTypes == null) {
            specialServiceTypes = new ArrayList<ShipmentSpecialServiceType>();
        }
        return this.specialServiceTypes;
    }

    /**
     * Obtiene el valor de la propiedad codDetail.
     * 
     * @return
     *     possible object is
     *     {@link CodDetail }
     *     
     */
    public CodDetail getCodDetail() {
        return codDetail;
    }

    /**
     * Define el valor de la propiedad codDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CodDetail }
     *     
     */
    public void setCodDetail(CodDetail value) {
        this.codDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryOnInvoiceAcceptanceDetail.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryOnInvoiceAcceptanceDetail }
     *     
     */
    public DeliveryOnInvoiceAcceptanceDetail getDeliveryOnInvoiceAcceptanceDetail() {
        return deliveryOnInvoiceAcceptanceDetail;
    }

    /**
     * Define el valor de la propiedad deliveryOnInvoiceAcceptanceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryOnInvoiceAcceptanceDetail }
     *     
     */
    public void setDeliveryOnInvoiceAcceptanceDetail(DeliveryOnInvoiceAcceptanceDetail value) {
        this.deliveryOnInvoiceAcceptanceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad holdAtLocationDetail.
     * 
     * @return
     *     possible object is
     *     {@link HoldAtLocationDetail }
     *     
     */
    public HoldAtLocationDetail getHoldAtLocationDetail() {
        return holdAtLocationDetail;
    }

    /**
     * Define el valor de la propiedad holdAtLocationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link HoldAtLocationDetail }
     *     
     */
    public void setHoldAtLocationDetail(HoldAtLocationDetail value) {
        this.holdAtLocationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad eventNotificationDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentEventNotificationDetail }
     *     
     */
    public ShipmentEventNotificationDetail getEventNotificationDetail() {
        return eventNotificationDetail;
    }

    /**
     * Define el valor de la propiedad eventNotificationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentEventNotificationDetail }
     *     
     */
    public void setEventNotificationDetail(ShipmentEventNotificationDetail value) {
        this.eventNotificationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad returnShipmentDetail.
     * 
     * @return
     *     possible object is
     *     {@link ReturnShipmentDetail }
     *     
     */
    public ReturnShipmentDetail getReturnShipmentDetail() {
        return returnShipmentDetail;
    }

    /**
     * Define el valor de la propiedad returnShipmentDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnShipmentDetail }
     *     
     */
    public void setReturnShipmentDetail(ReturnShipmentDetail value) {
        this.returnShipmentDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad pendingShipmentDetail.
     * 
     * @return
     *     possible object is
     *     {@link PendingShipmentDetail }
     *     
     */
    public PendingShipmentDetail getPendingShipmentDetail() {
        return pendingShipmentDetail;
    }

    /**
     * Define el valor de la propiedad pendingShipmentDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingShipmentDetail }
     *     
     */
    public void setPendingShipmentDetail(PendingShipmentDetail value) {
        this.pendingShipmentDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad internationalControlledExportDetail.
     * 
     * @return
     *     possible object is
     *     {@link InternationalControlledExportDetail }
     *     
     */
    public InternationalControlledExportDetail getInternationalControlledExportDetail() {
        return internationalControlledExportDetail;
    }

    /**
     * Define el valor de la propiedad internationalControlledExportDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link InternationalControlledExportDetail }
     *     
     */
    public void setInternationalControlledExportDetail(InternationalControlledExportDetail value) {
        this.internationalControlledExportDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad internationalTrafficInArmsRegulationsDetail.
     * 
     * @return
     *     possible object is
     *     {@link InternationalTrafficInArmsRegulationsDetail }
     *     
     */
    public InternationalTrafficInArmsRegulationsDetail getInternationalTrafficInArmsRegulationsDetail() {
        return internationalTrafficInArmsRegulationsDetail;
    }

    /**
     * Define el valor de la propiedad internationalTrafficInArmsRegulationsDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link InternationalTrafficInArmsRegulationsDetail }
     *     
     */
    public void setInternationalTrafficInArmsRegulationsDetail(InternationalTrafficInArmsRegulationsDetail value) {
        this.internationalTrafficInArmsRegulationsDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad shipmentDryIceDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentDryIceDetail }
     *     
     */
    public ShipmentDryIceDetail getShipmentDryIceDetail() {
        return shipmentDryIceDetail;
    }

    /**
     * Define el valor de la propiedad shipmentDryIceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentDryIceDetail }
     *     
     */
    public void setShipmentDryIceDetail(ShipmentDryIceDetail value) {
        this.shipmentDryIceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad homeDeliveryPremiumDetail.
     * 
     * @return
     *     possible object is
     *     {@link HomeDeliveryPremiumDetail }
     *     
     */
    public HomeDeliveryPremiumDetail getHomeDeliveryPremiumDetail() {
        return homeDeliveryPremiumDetail;
    }

    /**
     * Define el valor de la propiedad homeDeliveryPremiumDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link HomeDeliveryPremiumDetail }
     *     
     */
    public void setHomeDeliveryPremiumDetail(HomeDeliveryPremiumDetail value) {
        this.homeDeliveryPremiumDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad freightGuaranteeDetail.
     * 
     * @return
     *     possible object is
     *     {@link FreightGuaranteeDetail }
     *     
     */
    public FreightGuaranteeDetail getFreightGuaranteeDetail() {
        return freightGuaranteeDetail;
    }

    /**
     * Define el valor de la propiedad freightGuaranteeDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightGuaranteeDetail }
     *     
     */
    public void setFreightGuaranteeDetail(FreightGuaranteeDetail value) {
        this.freightGuaranteeDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad etdDetail.
     * 
     * @return
     *     possible object is
     *     {@link EtdDetail }
     *     
     */
    public EtdDetail getEtdDetail() {
        return etdDetail;
    }

    /**
     * Define el valor de la propiedad etdDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link EtdDetail }
     *     
     */
    public void setEtdDetail(EtdDetail value) {
        this.etdDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad customDeliveryWindowDetail.
     * 
     * @return
     *     possible object is
     *     {@link CustomDeliveryWindowDetail }
     *     
     */
    public CustomDeliveryWindowDetail getCustomDeliveryWindowDetail() {
        return customDeliveryWindowDetail;
    }

    /**
     * Define el valor de la propiedad customDeliveryWindowDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomDeliveryWindowDetail }
     *     
     */
    public void setCustomDeliveryWindowDetail(CustomDeliveryWindowDetail value) {
        this.customDeliveryWindowDetail = value;
    }

}
