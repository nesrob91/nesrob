
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LiabilityCoverageDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LiabilityCoverageDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CoverageType" type="{http://fedex.com/ws/ship/v19}LiabilityCoverageType" minOccurs="0"/>
 *         &lt;element name="CoverageAmount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiabilityCoverageDetail", propOrder = {
    "coverageType",
    "coverageAmount"
})
public class LiabilityCoverageDetail {

    @XmlElement(name = "CoverageType")
    protected LiabilityCoverageType coverageType;
    @XmlElement(name = "CoverageAmount")
    protected Money coverageAmount;

    /**
     * Obtiene el valor de la propiedad coverageType.
     * 
     * @return
     *     possible object is
     *     {@link LiabilityCoverageType }
     *     
     */
    public LiabilityCoverageType getCoverageType() {
        return coverageType;
    }

    /**
     * Define el valor de la propiedad coverageType.
     * 
     * @param value
     *     allowed object is
     *     {@link LiabilityCoverageType }
     *     
     */
    public void setCoverageType(LiabilityCoverageType value) {
        this.coverageType = value;
    }

    /**
     * Obtiene el valor de la propiedad coverageAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCoverageAmount() {
        return coverageAmount;
    }

    /**
     * Define el valor de la propiedad coverageAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCoverageAmount(Money value) {
        this.coverageAmount = value;
    }

}
