
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShipmentEventNotificationSpecification complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentEventNotificationSpecification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Role" type="{http://fedex.com/ws/ship/v19}ShipmentNotificationRoleType" minOccurs="0"/>
 *         &lt;element name="Events" type="{http://fedex.com/ws/ship/v19}NotificationEventType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NotificationDetail" type="{http://fedex.com/ws/ship/v19}NotificationDetail" minOccurs="0"/>
 *         &lt;element name="FormatSpecification" type="{http://fedex.com/ws/ship/v19}ShipmentNotificationFormatSpecification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentEventNotificationSpecification", propOrder = {
    "role",
    "events",
    "notificationDetail",
    "formatSpecification"
})
public class ShipmentEventNotificationSpecification {

    @XmlElement(name = "Role")
    protected ShipmentNotificationRoleType role;
    @XmlElement(name = "Events")
    protected List<NotificationEventType> events;
    @XmlElement(name = "NotificationDetail")
    protected NotificationDetail notificationDetail;
    @XmlElement(name = "FormatSpecification")
    protected ShipmentNotificationFormatSpecification formatSpecification;

    /**
     * Obtiene el valor de la propiedad role.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentNotificationRoleType }
     *     
     */
    public ShipmentNotificationRoleType getRole() {
        return role;
    }

    /**
     * Define el valor de la propiedad role.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentNotificationRoleType }
     *     
     */
    public void setRole(ShipmentNotificationRoleType value) {
        this.role = value;
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
     * {@link NotificationEventType }
     * 
     * 
     */
    public List<NotificationEventType> getEvents() {
        if (events == null) {
            events = new ArrayList<NotificationEventType>();
        }
        return this.events;
    }

    /**
     * Obtiene el valor de la propiedad notificationDetail.
     * 
     * @return
     *     possible object is
     *     {@link NotificationDetail }
     *     
     */
    public NotificationDetail getNotificationDetail() {
        return notificationDetail;
    }

    /**
     * Define el valor de la propiedad notificationDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationDetail }
     *     
     */
    public void setNotificationDetail(NotificationDetail value) {
        this.notificationDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad formatSpecification.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentNotificationFormatSpecification }
     *     
     */
    public ShipmentNotificationFormatSpecification getFormatSpecification() {
        return formatSpecification;
    }

    /**
     * Define el valor de la propiedad formatSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentNotificationFormatSpecification }
     *     
     */
    public void setFormatSpecification(ShipmentNotificationFormatSpecification value) {
        this.formatSpecification = value;
    }

}
