
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * CommercialInvoice element is required for electronic upload of CI data. It will serve to create/transmit an Electronic Commercial Invoice through the FedEx Systems. Customers are responsible for printing their own Commercial Invoice.If you would likeFedEx to generate a Commercial Invoice and transmit it to Customs. for clearance purposes, you need to specify that in the ShippingDocumentSpecification element. If you would like a copy of the Commercial Invoice that FedEx generated returned to you in reply it needs to be specified in the ETDDetail/RequestedDocumentCopies element. Commercial Invoice support consists of maximum of 99 commodity line items.
 * 
 * <p>Clase Java para CommercialInvoice complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CommercialInvoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="99" minOccurs="0"/>
 *         &lt;element name="FreightCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TaxesOrMiscellaneousCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TaxesOrMiscellaneousChargeType" type="{http://fedex.com/ws/ship/v19}TaxesOrMiscellaneousChargeType" minOccurs="0"/>
 *         &lt;element name="PackingCosts" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="HandlingCosts" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="SpecialInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeclarationStatement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentTerms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Purpose" type="{http://fedex.com/ws/ship/v19}PurposeOfShipmentType" minOccurs="0"/>
 *         &lt;element name="CustomerReferences" type="{http://fedex.com/ws/ship/v19}CustomerReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OriginatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TermsOfSale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialInvoice", propOrder = {
    "comments",
    "freightCharge",
    "taxesOrMiscellaneousCharge",
    "taxesOrMiscellaneousChargeType",
    "packingCosts",
    "handlingCosts",
    "specialInstructions",
    "declarationStatement",
    "paymentTerms",
    "purpose",
    "customerReferences",
    "originatorName",
    "termsOfSale"
})
public class CommercialInvoice {

    @XmlElement(name = "Comments")
    protected List<String> comments;
    @XmlElement(name = "FreightCharge")
    protected Money freightCharge;
    @XmlElement(name = "TaxesOrMiscellaneousCharge")
    protected Money taxesOrMiscellaneousCharge;
    @XmlElement(name = "TaxesOrMiscellaneousChargeType")
    protected TaxesOrMiscellaneousChargeType taxesOrMiscellaneousChargeType;
    @XmlElement(name = "PackingCosts")
    protected Money packingCosts;
    @XmlElement(name = "HandlingCosts")
    protected Money handlingCosts;
    @XmlElement(name = "SpecialInstructions")
    protected String specialInstructions;
    @XmlElement(name = "DeclarationStatement")
    protected String declarationStatement;
    @XmlElement(name = "PaymentTerms")
    protected String paymentTerms;
    @XmlElement(name = "Purpose")
    protected PurposeOfShipmentType purpose;
    @XmlElement(name = "CustomerReferences")
    protected List<CustomerReference> customerReferences;
    @XmlElement(name = "OriginatorName")
    protected String originatorName;
    @XmlElement(name = "TermsOfSale")
    protected String termsOfSale;

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComments() {
        if (comments == null) {
            comments = new ArrayList<String>();
        }
        return this.comments;
    }

    /**
     * Obtiene el valor de la propiedad freightCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFreightCharge() {
        return freightCharge;
    }

    /**
     * Define el valor de la propiedad freightCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFreightCharge(Money value) {
        this.freightCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad taxesOrMiscellaneousCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTaxesOrMiscellaneousCharge() {
        return taxesOrMiscellaneousCharge;
    }

    /**
     * Define el valor de la propiedad taxesOrMiscellaneousCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTaxesOrMiscellaneousCharge(Money value) {
        this.taxesOrMiscellaneousCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad taxesOrMiscellaneousChargeType.
     * 
     * @return
     *     possible object is
     *     {@link TaxesOrMiscellaneousChargeType }
     *     
     */
    public TaxesOrMiscellaneousChargeType getTaxesOrMiscellaneousChargeType() {
        return taxesOrMiscellaneousChargeType;
    }

    /**
     * Define el valor de la propiedad taxesOrMiscellaneousChargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesOrMiscellaneousChargeType }
     *     
     */
    public void setTaxesOrMiscellaneousChargeType(TaxesOrMiscellaneousChargeType value) {
        this.taxesOrMiscellaneousChargeType = value;
    }

    /**
     * Obtiene el valor de la propiedad packingCosts.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPackingCosts() {
        return packingCosts;
    }

    /**
     * Define el valor de la propiedad packingCosts.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPackingCosts(Money value) {
        this.packingCosts = value;
    }

    /**
     * Obtiene el valor de la propiedad handlingCosts.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getHandlingCosts() {
        return handlingCosts;
    }

    /**
     * Define el valor de la propiedad handlingCosts.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setHandlingCosts(Money value) {
        this.handlingCosts = value;
    }

    /**
     * Obtiene el valor de la propiedad specialInstructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Define el valor de la propiedad specialInstructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialInstructions(String value) {
        this.specialInstructions = value;
    }

    /**
     * Obtiene el valor de la propiedad declarationStatement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclarationStatement() {
        return declarationStatement;
    }

    /**
     * Define el valor de la propiedad declarationStatement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclarationStatement(String value) {
        this.declarationStatement = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentTerms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Define el valor de la propiedad paymentTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTerms(String value) {
        this.paymentTerms = value;
    }

    /**
     * Obtiene el valor de la propiedad purpose.
     * 
     * @return
     *     possible object is
     *     {@link PurposeOfShipmentType }
     *     
     */
    public PurposeOfShipmentType getPurpose() {
        return purpose;
    }

    /**
     * Define el valor de la propiedad purpose.
     * 
     * @param value
     *     allowed object is
     *     {@link PurposeOfShipmentType }
     *     
     */
    public void setPurpose(PurposeOfShipmentType value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the customerReferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerReferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerReferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerReference }
     * 
     * 
     */
    public List<CustomerReference> getCustomerReferences() {
        if (customerReferences == null) {
            customerReferences = new ArrayList<CustomerReference>();
        }
        return this.customerReferences;
    }

    /**
     * Obtiene el valor de la propiedad originatorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatorName() {
        return originatorName;
    }

    /**
     * Define el valor de la propiedad originatorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatorName(String value) {
        this.originatorName = value;
    }

    /**
     * Obtiene el valor de la propiedad termsOfSale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsOfSale() {
        return termsOfSale;
    }

    /**
     * Define el valor de la propiedad termsOfSale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsOfSale(String value) {
        this.termsOfSale = value;
    }

}
