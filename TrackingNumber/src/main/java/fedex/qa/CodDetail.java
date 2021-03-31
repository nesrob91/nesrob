
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Descriptive data required for a FedEx COD (Collect-On-Delivery) shipment.
 * 
 * <p>Clase Java para CodDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CodDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodCollectionAmount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="AddTransportationChargesDetail" type="{http://fedex.com/ws/ship/v19}CodAddTransportationChargesDetail" minOccurs="0"/>
 *         &lt;element name="CollectionType" type="{http://fedex.com/ws/ship/v19}CodCollectionType"/>
 *         &lt;element name="CodRecipient" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *         &lt;element name="FinancialInstitutionContactAndAddress" type="{http://fedex.com/ws/ship/v19}ContactAndAddress" minOccurs="0"/>
 *         &lt;element name="RemitToName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceIndicator" type="{http://fedex.com/ws/ship/v19}CodReturnReferenceIndicatorType" minOccurs="0"/>
 *         &lt;element name="ReturnTrackingId" type="{http://fedex.com/ws/ship/v19}TrackingId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodDetail", propOrder = {
    "codCollectionAmount",
    "addTransportationChargesDetail",
    "collectionType",
    "codRecipient",
    "financialInstitutionContactAndAddress",
    "remitToName",
    "referenceIndicator",
    "returnTrackingId"
})
public class CodDetail {

    @XmlElement(name = "CodCollectionAmount")
    protected Money codCollectionAmount;
    @XmlElement(name = "AddTransportationChargesDetail")
    protected CodAddTransportationChargesDetail addTransportationChargesDetail;
    @XmlElement(name = "CollectionType", required = true)
    protected CodCollectionType collectionType;
    @XmlElement(name = "CodRecipient")
    protected Party codRecipient;
    @XmlElement(name = "FinancialInstitutionContactAndAddress")
    protected ContactAndAddress financialInstitutionContactAndAddress;
    @XmlElement(name = "RemitToName")
    protected String remitToName;
    @XmlElement(name = "ReferenceIndicator")
    protected CodReturnReferenceIndicatorType referenceIndicator;
    @XmlElement(name = "ReturnTrackingId")
    protected TrackingId returnTrackingId;

    /**
     * Obtiene el valor de la propiedad codCollectionAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCodCollectionAmount() {
        return codCollectionAmount;
    }

    /**
     * Define el valor de la propiedad codCollectionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCodCollectionAmount(Money value) {
        this.codCollectionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad addTransportationChargesDetail.
     * 
     * @return
     *     possible object is
     *     {@link CodAddTransportationChargesDetail }
     *     
     */
    public CodAddTransportationChargesDetail getAddTransportationChargesDetail() {
        return addTransportationChargesDetail;
    }

    /**
     * Define el valor de la propiedad addTransportationChargesDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CodAddTransportationChargesDetail }
     *     
     */
    public void setAddTransportationChargesDetail(CodAddTransportationChargesDetail value) {
        this.addTransportationChargesDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad collectionType.
     * 
     * @return
     *     possible object is
     *     {@link CodCollectionType }
     *     
     */
    public CodCollectionType getCollectionType() {
        return collectionType;
    }

    /**
     * Define el valor de la propiedad collectionType.
     * 
     * @param value
     *     allowed object is
     *     {@link CodCollectionType }
     *     
     */
    public void setCollectionType(CodCollectionType value) {
        this.collectionType = value;
    }

    /**
     * Obtiene el valor de la propiedad codRecipient.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getCodRecipient() {
        return codRecipient;
    }

    /**
     * Define el valor de la propiedad codRecipient.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setCodRecipient(Party value) {
        this.codRecipient = value;
    }

    /**
     * Obtiene el valor de la propiedad financialInstitutionContactAndAddress.
     * 
     * @return
     *     possible object is
     *     {@link ContactAndAddress }
     *     
     */
    public ContactAndAddress getFinancialInstitutionContactAndAddress() {
        return financialInstitutionContactAndAddress;
    }

    /**
     * Define el valor de la propiedad financialInstitutionContactAndAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAndAddress }
     *     
     */
    public void setFinancialInstitutionContactAndAddress(ContactAndAddress value) {
        this.financialInstitutionContactAndAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad remitToName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitToName() {
        return remitToName;
    }

    /**
     * Define el valor de la propiedad remitToName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitToName(String value) {
        this.remitToName = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceIndicator.
     * 
     * @return
     *     possible object is
     *     {@link CodReturnReferenceIndicatorType }
     *     
     */
    public CodReturnReferenceIndicatorType getReferenceIndicator() {
        return referenceIndicator;
    }

    /**
     * Define el valor de la propiedad referenceIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link CodReturnReferenceIndicatorType }
     *     
     */
    public void setReferenceIndicator(CodReturnReferenceIndicatorType value) {
        this.referenceIndicator = value;
    }

    /**
     * Obtiene el valor de la propiedad returnTrackingId.
     * 
     * @return
     *     possible object is
     *     {@link TrackingId }
     *     
     */
    public TrackingId getReturnTrackingId() {
        return returnTrackingId;
    }

    /**
     * Define el valor de la propiedad returnTrackingId.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingId }
     *     
     */
    public void setReturnTrackingId(TrackingId value) {
        this.returnTrackingId = value;
    }

}
