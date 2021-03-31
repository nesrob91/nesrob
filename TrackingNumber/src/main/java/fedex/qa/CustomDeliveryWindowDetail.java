
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para CustomDeliveryWindowDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomDeliveryWindowDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}CustomDeliveryWindowType" minOccurs="0"/>
 *         &lt;element name="RequestTime" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="RequestRange" type="{http://fedex.com/ws/ship/v19}DateRange" minOccurs="0"/>
 *         &lt;element name="RequestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomDeliveryWindowDetail", propOrder = {
    "type",
    "requestTime",
    "requestRange",
    "requestDate"
})
public class CustomDeliveryWindowDetail {

    @XmlElement(name = "Type")
    protected CustomDeliveryWindowType type;
    @XmlElement(name = "RequestTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar requestTime;
    @XmlElement(name = "RequestRange")
    protected DateRange requestRange;
    @XmlElement(name = "RequestDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar requestDate;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link CustomDeliveryWindowType }
     *     
     */
    public CustomDeliveryWindowType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomDeliveryWindowType }
     *     
     */
    public void setType(CustomDeliveryWindowType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad requestTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestTime() {
        return requestTime;
    }

    /**
     * Define el valor de la propiedad requestTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestTime(XMLGregorianCalendar value) {
        this.requestTime = value;
    }

    /**
     * Obtiene el valor de la propiedad requestRange.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getRequestRange() {
        return requestRange;
    }

    /**
     * Define el valor de la propiedad requestRange.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setRequestRange(DateRange value) {
        this.requestRange = value;
    }

    /**
     * Obtiene el valor de la propiedad requestDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Define el valor de la propiedad requestDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
    }

}
