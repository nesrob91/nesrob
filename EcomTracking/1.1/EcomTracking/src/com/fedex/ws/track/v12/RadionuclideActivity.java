
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RadionuclideActivity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RadionuclideActivity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UnitOfMeasure" type="{http://fedex.com/ws/ship/v19}RadioactivityUnitOfMeasure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RadionuclideActivity", propOrder = {
    "value",
    "unitOfMeasure"
})
public class RadionuclideActivity {

    @XmlElement(name = "Value")
    protected BigDecimal value;
    @XmlElement(name = "UnitOfMeasure")
    protected RadioactivityUnitOfMeasure unitOfMeasure;

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

    /**
     * Obtiene el valor de la propiedad unitOfMeasure.
     * 
     * @return
     *     possible object is
     *     {@link RadioactivityUnitOfMeasure }
     *     
     */
    public RadioactivityUnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Define el valor de la propiedad unitOfMeasure.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioactivityUnitOfMeasure }
     *     
     */
    public void setUnitOfMeasure(RadioactivityUnitOfMeasure value) {
        this.unitOfMeasure = value;
    }

}
