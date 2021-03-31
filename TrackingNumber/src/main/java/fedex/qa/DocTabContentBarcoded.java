
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DocTabContentBarcoded complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DocTabContentBarcoded">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Symbology" type="{http://fedex.com/ws/ship/v19}BarcodeSymbologyType" minOccurs="0"/>
 *         &lt;element name="Specification" type="{http://fedex.com/ws/ship/v19}DocTabZoneSpecification"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocTabContentBarcoded", propOrder = {
    "symbology",
    "specification"
})
public class DocTabContentBarcoded {

    @XmlElement(name = "Symbology")
    protected BarcodeSymbologyType symbology;
    @XmlElement(name = "Specification", required = true)
    protected DocTabZoneSpecification specification;

    /**
     * Obtiene el valor de la propiedad symbology.
     * 
     * @return
     *     possible object is
     *     {@link BarcodeSymbologyType }
     *     
     */
    public BarcodeSymbologyType getSymbology() {
        return symbology;
    }

    /**
     * Define el valor de la propiedad symbology.
     * 
     * @param value
     *     allowed object is
     *     {@link BarcodeSymbologyType }
     *     
     */
    public void setSymbology(BarcodeSymbologyType value) {
        this.symbology = value;
    }

    /**
     * Obtiene el valor de la propiedad specification.
     * 
     * @return
     *     possible object is
     *     {@link DocTabZoneSpecification }
     *     
     */
    public DocTabZoneSpecification getSpecification() {
        return specification;
    }

    /**
     * Define el valor de la propiedad specification.
     * 
     * @param value
     *     allowed object is
     *     {@link DocTabZoneSpecification }
     *     
     */
    public void setSpecification(DocTabZoneSpecification value) {
        this.specification = value;
    }

}
