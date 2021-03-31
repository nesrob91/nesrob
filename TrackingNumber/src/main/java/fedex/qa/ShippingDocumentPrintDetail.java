
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies printing options for a shipping document.
 * 
 * <p>Clase Java para ShippingDocumentPrintDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShippingDocumentPrintDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrinterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingDocumentPrintDetail", propOrder = {
    "printerId"
})
public class ShippingDocumentPrintDetail {

    @XmlElement(name = "PrinterId")
    protected String printerId;

    /**
     * Obtiene el valor de la propiedad printerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinterId() {
        return printerId;
    }

    /**
     * Define el valor de la propiedad printerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinterId(String value) {
        this.printerId = value;
    }

}
