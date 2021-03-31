
package fedex.qa;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The descriptive data for the heaviness of an object.
 * 
 * <p>Clase Java para Weight complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Weight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Units" type="{http://fedex.com/ws/ship/v19}WeightUnits"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Weight", propOrder = {
    "units",
    "value"
})
public class Weight {

    @XmlElement(name = "Units", required = true)
    protected WeightUnits units;
    @XmlElement(name = "Value", required = true)
    protected BigDecimal value;

    /**
     * Obtiene el valor de la propiedad units.
     * 
     * @return
     *     possible object is
     *     {@link WeightUnits }
     *     
     */
    public WeightUnits getUnits() {
        return units;
    }

    /**
     * Define el valor de la propiedad units.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightUnits }
     *     
     */
    public void setUnits(WeightUnits value) {
        this.units = value;
    }

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
