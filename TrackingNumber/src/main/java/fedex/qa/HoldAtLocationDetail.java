
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HoldAtLocationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HoldAtLocationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LocationContactAndAddress" type="{http://fedex.com/ws/ship/v19}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="LocationType" type="{http://fedex.com/ws/ship/v19}FedExLocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HoldAtLocationDetail", propOrder = {
    "phoneNumber",
    "locationContactAndAddress",
    "locationType"
})
public class HoldAtLocationDetail {

    @XmlElement(name = "PhoneNumber", required = true)
    protected String phoneNumber;
    @XmlElement(name = "LocationContactAndAddress")
    protected ContactAndAddress locationContactAndAddress;
    @XmlElement(name = "LocationType")
    protected FedExLocationType locationType;

    /**
     * Obtiene el valor de la propiedad phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define el valor de la propiedad phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad locationContactAndAddress.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getLocationContactAndAddress() {
        return locationContactAndAddress;
    }

    /**
     * Define el valor de la propiedad locationContactAndAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setLocationContactAndAddress(ContactAndAddress value) {
        this.locationContactAndAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad locationType.
     * 
     * @return
     *     possible object is
     *     {@link FedExLocationType }
     *     
     */
    public FedExLocationType getLocationType() {
        return locationType;
    }

    /**
     * Define el valor de la propiedad locationType.
     * 
     * @param value
     *     allowed object is
     *     {@link FedExLocationType }
     *     
     */
    public void setLocationType(FedExLocationType value) {
        this.locationType = value;
    }

}
