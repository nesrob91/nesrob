
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Each occurrence of this class specifies a particular way in which a kind of shipping document is to be produced and provided.
 * 
 * <p>Clase Java para ShippingDocumentDispositionDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShippingDocumentDispositionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DispositionType" type="{http://fedex.com/ws/ship/v19}ShippingDocumentDispositionType" minOccurs="0"/>
 *         &lt;element name="Grouping" type="{http://fedex.com/ws/ship/v19}ShippingDocumentGroupingType" minOccurs="0"/>
 *         &lt;element name="EMailDetail" type="{http://fedex.com/ws/ship/v19}ShippingDocumentEMailDetail" minOccurs="0"/>
 *         &lt;element name="PrintDetail" type="{http://fedex.com/ws/ship/v19}ShippingDocumentPrintDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingDocumentDispositionDetail", propOrder = {
    "dispositionType",
    "grouping",
    "eMailDetail",
    "printDetail"
})
public class ShippingDocumentDispositionDetail {

    @XmlElement(name = "DispositionType")
    protected ShippingDocumentDispositionType dispositionType;
    @XmlElement(name = "Grouping")
    protected ShippingDocumentGroupingType grouping;
    @XmlElement(name = "EMailDetail")
    protected ShippingDocumentEMailDetail eMailDetail;
    @XmlElement(name = "PrintDetail")
    protected ShippingDocumentPrintDetail printDetail;

    /**
     * Obtiene el valor de la propiedad dispositionType.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentDispositionType }
     *     
     */
    public ShippingDocumentDispositionType getDispositionType() {
        return dispositionType;
    }

    /**
     * Define el valor de la propiedad dispositionType.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentDispositionType }
     *     
     */
    public void setDispositionType(ShippingDocumentDispositionType value) {
        this.dispositionType = value;
    }

    /**
     * Obtiene el valor de la propiedad grouping.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentGroupingType }
     *     
     */
    public ShippingDocumentGroupingType getGrouping() {
        return grouping;
    }

    /**
     * Define el valor de la propiedad grouping.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentGroupingType }
     *     
     */
    public void setGrouping(ShippingDocumentGroupingType value) {
        this.grouping = value;
    }

    /**
     * Obtiene el valor de la propiedad eMailDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentEMailDetail }
     *     
     */
    public ShippingDocumentEMailDetail getEMailDetail() {
        return eMailDetail;
    }

    /**
     * Define el valor de la propiedad eMailDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentEMailDetail }
     *     
     */
    public void setEMailDetail(ShippingDocumentEMailDetail value) {
        this.eMailDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad printDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentPrintDetail }
     *     
     */
    public ShippingDocumentPrintDetail getPrintDetail() {
        return printDetail;
    }

    /**
     * Define el valor de la propiedad printDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentPrintDetail }
     *     
     */
    public void setPrintDetail(ShippingDocumentPrintDetail value) {
        this.printDetail = value;
    }

}
