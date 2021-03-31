
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShipmentEventNotificationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentEventNotificationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AggregationType" type="{http://fedex.com/ws/ship/v19}ShipmentNotificationAggregationType" minOccurs="0"/>
 *         &lt;element name="PersonalMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventNotifications" type="{http://fedex.com/ws/ship/v19}ShipmentEventNotificationSpecification" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentEventNotificationDetail", propOrder = {
    "aggregationType",
    "personalMessage",
    "eventNotifications"
})
public class ShipmentEventNotificationDetail {

    @XmlElement(name = "AggregationType")
    protected ShipmentNotificationAggregationType aggregationType;
    @XmlElement(name = "PersonalMessage")
    protected String personalMessage;
    @XmlElement(name = "EventNotifications")
    protected List<ShipmentEventNotificationSpecification> eventNotifications;

    /**
     * Obtiene el valor de la propiedad aggregationType.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentNotificationAggregationType }
     *     
     */
    public ShipmentNotificationAggregationType getAggregationType() {
        return aggregationType;
    }

    /**
     * Define el valor de la propiedad aggregationType.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentNotificationAggregationType }
     *     
     */
    public void setAggregationType(ShipmentNotificationAggregationType value) {
        this.aggregationType = value;
    }

    /**
     * Obtiene el valor de la propiedad personalMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalMessage() {
        return personalMessage;
    }

    /**
     * Define el valor de la propiedad personalMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalMessage(String value) {
        this.personalMessage = value;
    }

    /**
     * Gets the value of the eventNotifications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventNotifications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventNotifications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipmentEventNotificationSpecification }
     * 
     * 
     */
    public List<ShipmentEventNotificationSpecification> getEventNotifications() {
        if (eventNotifications == null) {
            eventNotifications = new ArrayList<ShipmentEventNotificationSpecification>();
        }
        return this.eventNotifications;
    }

}
