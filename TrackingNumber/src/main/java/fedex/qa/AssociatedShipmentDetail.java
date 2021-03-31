
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AssociatedShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AssociatedShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}AssociatedShipmentType" minOccurs="0"/>
 *         &lt;element name="Sender" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *         &lt;element name="Recipient" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *         &lt;element name="ServiceType" type="{http://fedex.com/ws/ship/v19}ServiceType" minOccurs="0"/>
 *         &lt;element name="PackagingType" type="{http://fedex.com/ws/ship/v19}PackagingType" minOccurs="0"/>
 *         &lt;element name="TrackingId" type="{http://fedex.com/ws/ship/v19}TrackingId" minOccurs="0"/>
 *         &lt;element name="CustomerReferences" type="{http://fedex.com/ws/ship/v19}CustomerReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShipmentOperationalDetail" type="{http://fedex.com/ws/ship/v19}ShipmentOperationalDetail" minOccurs="0"/>
 *         &lt;element name="PackageOperationalDetail" type="{http://fedex.com/ws/ship/v19}PackageOperationalDetail" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://fedex.com/ws/ship/v19}ShippingDocument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociatedShipmentDetail", propOrder = {
    "type",
    "sender",
    "recipient",
    "serviceType",
    "packagingType",
    "trackingId",
    "customerReferences",
    "shipmentOperationalDetail",
    "packageOperationalDetail",
    "label"
})
public class AssociatedShipmentDetail {

    @XmlElement(name = "Type")
    protected AssociatedShipmentType type;
    @XmlElement(name = "Sender")
    protected Party sender;
    @XmlElement(name = "Recipient")
    protected Party recipient;
    @XmlElement(name = "ServiceType")
    protected ServiceType serviceType;
    @XmlElement(name = "PackagingType")
    protected PackagingType packagingType;
    @XmlElement(name = "TrackingId")
    protected TrackingId trackingId;
    @XmlElement(name = "CustomerReferences")
    protected List<CustomerReference> customerReferences;
    @XmlElement(name = "ShipmentOperationalDetail")
    protected ShipmentOperationalDetail shipmentOperationalDetail;
    @XmlElement(name = "PackageOperationalDetail")
    protected PackageOperationalDetail packageOperationalDetail;
    @XmlElement(name = "Label")
    protected ShippingDocument label;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedShipmentType }
     *     
     */
    public AssociatedShipmentType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedShipmentType }
     *     
     */
    public void setType(AssociatedShipmentType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad sender.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getSender() {
        return sender;
    }

    /**
     * Define el valor de la propiedad sender.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setSender(Party value) {
        this.sender = value;
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
     * Obtiene el valor de la propiedad trackingId.
     * 
     * @return
     *     possible object is
     *     {@link TrackingId }
     *     
     */
    public TrackingId getTrackingId() {
        return trackingId;
    }

    /**
     * Define el valor de la propiedad trackingId.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingId }
     *     
     */
    public void setTrackingId(TrackingId value) {
        this.trackingId = value;
    }

    /**
     * Gets the value of the customerReferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerReferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerReferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerReference }
     * 
     * 
     */
    public List<CustomerReference> getCustomerReferences() {
        if (customerReferences == null) {
            customerReferences = new ArrayList<CustomerReference>();
        }
        return this.customerReferences;
    }

    /**
     * Obtiene el valor de la propiedad shipmentOperationalDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentOperationalDetail }
     *     
     */
    public ShipmentOperationalDetail getShipmentOperationalDetail() {
        return shipmentOperationalDetail;
    }

    /**
     * Define el valor de la propiedad shipmentOperationalDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentOperationalDetail }
     *     
     */
    public void setShipmentOperationalDetail(ShipmentOperationalDetail value) {
        this.shipmentOperationalDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad packageOperationalDetail.
     * 
     * @return
     *     possible object is
     *     {@link PackageOperationalDetail }
     *     
     */
    public PackageOperationalDetail getPackageOperationalDetail() {
        return packageOperationalDetail;
    }

    /**
     * Define el valor de la propiedad packageOperationalDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageOperationalDetail }
     *     
     */
    public void setPackageOperationalDetail(PackageOperationalDetail value) {
        this.packageOperationalDetail = value;
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

}
