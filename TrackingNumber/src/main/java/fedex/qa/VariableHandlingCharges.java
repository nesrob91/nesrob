
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VariableHandlingCharges complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VariableHandlingCharges">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VariableHandlingCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="FixedVariableHandlingCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="PercentVariableHandlingCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TotalCustomerCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableHandlingCharges", propOrder = {
    "variableHandlingCharge",
    "fixedVariableHandlingCharge",
    "percentVariableHandlingCharge",
    "totalCustomerCharge"
})
public class VariableHandlingCharges {

    @XmlElement(name = "VariableHandlingCharge")
    protected Money variableHandlingCharge;
    @XmlElement(name = "FixedVariableHandlingCharge")
    protected Money fixedVariableHandlingCharge;
    @XmlElement(name = "PercentVariableHandlingCharge")
    protected Money percentVariableHandlingCharge;
    @XmlElement(name = "TotalCustomerCharge")
    protected Money totalCustomerCharge;

    /**
     * Obtiene el valor de la propiedad variableHandlingCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getVariableHandlingCharge() {
        return variableHandlingCharge;
    }

    /**
     * Define el valor de la propiedad variableHandlingCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setVariableHandlingCharge(Money value) {
        this.variableHandlingCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad fixedVariableHandlingCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFixedVariableHandlingCharge() {
        return fixedVariableHandlingCharge;
    }

    /**
     * Define el valor de la propiedad fixedVariableHandlingCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFixedVariableHandlingCharge(Money value) {
        this.fixedVariableHandlingCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad percentVariableHandlingCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPercentVariableHandlingCharge() {
        return percentVariableHandlingCharge;
    }

    /**
     * Define el valor de la propiedad percentVariableHandlingCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPercentVariableHandlingCharge(Money value) {
        this.percentVariableHandlingCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad totalCustomerCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalCustomerCharge() {
        return totalCustomerCharge;
    }

    /**
     * Define el valor de la propiedad totalCustomerCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalCustomerCharge(Money value) {
        this.totalCustomerCharge = value;
    }

}
