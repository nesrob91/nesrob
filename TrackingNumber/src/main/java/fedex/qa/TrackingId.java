
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackingId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackingId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrackingIdType" type="{http://fedex.com/ws/ship/v19}TrackingIdType" minOccurs="0"/>
 *         &lt;element name="FormId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UspsApplicationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackingId", propOrder = {
    "trackingIdType",
    "formId",
    "uspsApplicationId",
    "trackingNumber"
})
public class TrackingId {

    @XmlElement(name = "TrackingIdType")
    protected TrackingIdType trackingIdType;
    @XmlElement(name = "FormId")
    protected String formId;
    @XmlElement(name = "UspsApplicationId")
    protected String uspsApplicationId;
    @XmlElement(name = "TrackingNumber")
    protected String trackingNumber;

    /**
     * Obtiene el valor de la propiedad trackingIdType.
     * 
     * @return
     *     possible object is
     *     {@link TrackingIdType }
     *     
     */
    public TrackingIdType getTrackingIdType() {
        return trackingIdType;
    }

    /**
     * Define el valor de la propiedad trackingIdType.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingIdType }
     *     
     */
    public void setTrackingIdType(TrackingIdType value) {
        this.trackingIdType = value;
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
     * Obtiene el valor de la propiedad uspsApplicationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUspsApplicationId() {
        return uspsApplicationId;
    }

    /**
     * Define el valor de la propiedad uspsApplicationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUspsApplicationId(String value) {
        this.uspsApplicationId = value;
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

}
