
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies which party will be responsible for payment of any surcharges for Freight special services for which split billing is allowed.
 * 
 * <p>Clase Java para FreightSpecialServicePayment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FreightSpecialServicePayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialService" type="{http://fedex.com/ws/ship/v19}ShipmentSpecialServiceType" minOccurs="0"/>
 *         &lt;element name="PaymentType" type="{http://fedex.com/ws/ship/v19}FreightShipmentRoleType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightSpecialServicePayment", propOrder = {
    "specialService",
    "paymentType"
})
public class FreightSpecialServicePayment {

    @XmlElement(name = "SpecialService")
    protected ShipmentSpecialServiceType specialService;
    @XmlElement(name = "PaymentType")
    protected FreightShipmentRoleType paymentType;

    /**
     * Obtiene el valor de la propiedad specialService.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentSpecialServiceType }
     *     
     */
    public ShipmentSpecialServiceType getSpecialService() {
        return specialService;
    }

    /**
     * Define el valor de la propiedad specialService.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentSpecialServiceType }
     *     
     */
    public void setSpecialService(ShipmentSpecialServiceType value) {
        this.specialService = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentType.
     * 
     * @return
     *     possible object is
     *     {@link FreightShipmentRoleType }
     *     
     */
    public FreightShipmentRoleType getPaymentType() {
        return paymentType;
    }

    /**
     * Define el valor de la propiedad paymentType.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightShipmentRoleType }
     *     
     */
    public void setPaymentType(FreightShipmentRoleType value) {
        this.paymentType = value;
    }

}
