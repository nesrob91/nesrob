
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LabelSpecification complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LabelSpecification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Dispositions" type="{http://fedex.com/ws/ship/v19}ShippingDocumentDispositionDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LabelFormatType" type="{http://fedex.com/ws/ship/v19}LabelFormatType"/>
 *         &lt;element name="ImageType" type="{http://fedex.com/ws/ship/v19}ShippingDocumentImageType" minOccurs="0"/>
 *         &lt;element name="LabelStockType" type="{http://fedex.com/ws/ship/v19}LabelStockType" minOccurs="0"/>
 *         &lt;element name="LabelPrintingOrientation" type="{http://fedex.com/ws/ship/v19}LabelPrintingOrientationType" minOccurs="0"/>
 *         &lt;element name="LabelOrder" type="{http://fedex.com/ws/ship/v19}LabelOrderType" minOccurs="0"/>
 *         &lt;element name="PrintedLabelOrigin" type="{http://fedex.com/ws/ship/v19}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="CustomerSpecifiedDetail" type="{http://fedex.com/ws/ship/v19}CustomerSpecifiedLabelDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LabelSpecification", propOrder = {
    "dispositions",
    "labelFormatType",
    "imageType",
    "labelStockType",
    "labelPrintingOrientation",
    "labelOrder",
    "printedLabelOrigin",
    "customerSpecifiedDetail"
})
public class LabelSpecification {

    @XmlElement(name = "Dispositions")
    protected List<ShippingDocumentDispositionDetail> dispositions;
    @XmlElement(name = "LabelFormatType", required = true)
    protected LabelFormatType labelFormatType;
    @XmlElement(name = "ImageType")
    protected ShippingDocumentImageType imageType;
    @XmlElement(name = "LabelStockType")
    protected LabelStockType labelStockType;
    @XmlElement(name = "LabelPrintingOrientation")
    protected LabelPrintingOrientationType labelPrintingOrientation;
    @XmlElement(name = "LabelOrder")
    protected LabelOrderType labelOrder;
    @XmlElement(name = "PrintedLabelOrigin")
    protected ContactAndAddress printedLabelOrigin;
    @XmlElement(name = "CustomerSpecifiedDetail")
    protected CustomerSpecifiedLabelDetail customerSpecifiedDetail;

    /**
     * Gets the value of the dispositions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dispositions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDispositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShippingDocumentDispositionDetail }
     * 
     * 
     */
    public List<ShippingDocumentDispositionDetail> getDispositions() {
        if (dispositions == null) {
            dispositions = new ArrayList<ShippingDocumentDispositionDetail>();
        }
        return this.dispositions;
    }

    /**
     * Obtiene el valor de la propiedad labelFormatType.
     * 
     * @return
     *     possible object is
     *     {@link LabelFormatType }
     *     
     */
    public LabelFormatType getLabelFormatType() {
        return labelFormatType;
    }

    /**
     * Define el valor de la propiedad labelFormatType.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelFormatType }
     *     
     */
    public void setLabelFormatType(LabelFormatType value) {
        this.labelFormatType = value;
    }

    /**
     * Obtiene el valor de la propiedad imageType.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentImageType }
     *     
     */
    public ShippingDocumentImageType getImageType() {
        return imageType;
    }

    /**
     * Define el valor de la propiedad imageType.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentImageType }
     *     
     */
    public void setImageType(ShippingDocumentImageType value) {
        this.imageType = value;
    }

    /**
     * Obtiene el valor de la propiedad labelStockType.
     * 
     * @return
     *     possible object is
     *     {@link LabelStockType }
     *     
     */
    public LabelStockType getLabelStockType() {
        return labelStockType;
    }

    /**
     * Define el valor de la propiedad labelStockType.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelStockType }
     *     
     */
    public void setLabelStockType(LabelStockType value) {
        this.labelStockType = value;
    }

    /**
     * Obtiene el valor de la propiedad labelPrintingOrientation.
     * 
     * @return
     *     possible object is
     *     {@link LabelPrintingOrientationType }
     *     
     */
    public LabelPrintingOrientationType getLabelPrintingOrientation() {
        return labelPrintingOrientation;
    }

    /**
     * Define el valor de la propiedad labelPrintingOrientation.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelPrintingOrientationType }
     *     
     */
    public void setLabelPrintingOrientation(LabelPrintingOrientationType value) {
        this.labelPrintingOrientation = value;
    }

    /**
     * Obtiene el valor de la propiedad labelOrder.
     * 
     * @return
     *     possible object is
     *     {@link LabelOrderType }
     *     
     */
    public LabelOrderType getLabelOrder() {
        return labelOrder;
    }

    /**
     * Define el valor de la propiedad labelOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelOrderType }
     *     
     */
    public void setLabelOrder(LabelOrderType value) {
        this.labelOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad printedLabelOrigin.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getPrintedLabelOrigin() {
        return printedLabelOrigin;
    }

    /**
     * Define el valor de la propiedad printedLabelOrigin.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setPrintedLabelOrigin(ContactAndAddress value) {
        this.printedLabelOrigin = value;
    }

    /**
     * Obtiene el valor de la propiedad customerSpecifiedDetail.
     * 
     * @return
     *     possible object is
     *     {@link CustomerSpecifiedLabelDetail }
     *     
     */
    public CustomerSpecifiedLabelDetail getCustomerSpecifiedDetail() {
        return customerSpecifiedDetail;
    }

    /**
     * Define el valor de la propiedad customerSpecifiedDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSpecifiedLabelDetail }
     *     
     */
    public void setCustomerSpecifiedDetail(CustomerSpecifiedLabelDetail value) {
        this.customerSpecifiedDetail = value;
    }

}
