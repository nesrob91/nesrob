
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies details needed to generate any label artifacts required due to regulatory requirements.
 * 
 * <p>Clase Java para RegulatoryLabelContentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RegulatoryLabelContentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}RegulatoryLabelType" minOccurs="0"/>
 *         &lt;element name="GenerationOptions" type="{http://fedex.com/ws/ship/v19}CustomerSpecifiedLabelGenerationOptionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegulatoryLabelContentDetail", propOrder = {
    "type",
    "generationOptions"
})
public class RegulatoryLabelContentDetail {

    @XmlElement(name = "Type")
    protected RegulatoryLabelType type;
    @XmlElement(name = "GenerationOptions")
    protected List<CustomerSpecifiedLabelGenerationOptionType> generationOptions;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryLabelType }
     *     
     */
    public RegulatoryLabelType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryLabelType }
     *     
     */
    public void setType(RegulatoryLabelType value) {
        this.type = value;
    }

    /**
     * Gets the value of the generationOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generationOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenerationOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerSpecifiedLabelGenerationOptionType }
     * 
     * 
     */
    public List<CustomerSpecifiedLabelGenerationOptionType> getGenerationOptions() {
        if (generationOptions == null) {
            generationOptions = new ArrayList<CustomerSpecifiedLabelGenerationOptionType>();
        }
        return this.generationOptions;
    }

}
