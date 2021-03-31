
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReturnEMailDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReturnEMailDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AllowedSpecialServices" type="{http://fedex.com/ws/ship/v19}ReturnEMailAllowedSpecialServiceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnEMailDetail", propOrder = {
    "merchantPhoneNumber",
    "allowedSpecialServices"
})
public class ReturnEMailDetail {

    @XmlElement(name = "MerchantPhoneNumber")
    protected String merchantPhoneNumber;
    @XmlElement(name = "AllowedSpecialServices")
    protected List<ReturnEMailAllowedSpecialServiceType> allowedSpecialServices;

    /**
     * Obtiene el valor de la propiedad merchantPhoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantPhoneNumber() {
        return merchantPhoneNumber;
    }

    /**
     * Define el valor de la propiedad merchantPhoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantPhoneNumber(String value) {
        this.merchantPhoneNumber = value;
    }

    /**
     * Gets the value of the allowedSpecialServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedSpecialServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedSpecialServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnEMailAllowedSpecialServiceType }
     * 
     * 
     */
    public List<ReturnEMailAllowedSpecialServiceType> getAllowedSpecialServices() {
        if (allowedSpecialServices == null) {
            allowedSpecialServices = new ArrayList<ReturnEMailAllowedSpecialServiceType>();
        }
        return this.allowedSpecialServices;
    }

}
