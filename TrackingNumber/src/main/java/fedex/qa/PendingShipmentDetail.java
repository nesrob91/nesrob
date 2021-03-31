
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This information describes the kind of pending shipment being requested.
 * 
 * <p>Clase Java para PendingShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PendingShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}PendingShipmentType"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EmailLabelDetail" type="{http://fedex.com/ws/ship/v19}EMailLabelDetail" minOccurs="0"/>
 *         &lt;element name="ProcessingOptions" type="{http://fedex.com/ws/ship/v19}PendingShipmentProcessingOptionsRequested" minOccurs="0"/>
 *         &lt;element name="RecommendedDocumentSpecification" type="{http://fedex.com/ws/ship/v19}RecommendedDocumentSpecification" minOccurs="0"/>
 *         &lt;element name="DocumentReferences" type="{http://fedex.com/ws/ship/v19}UploadDocumentReferenceDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PendingShipmentDetail", propOrder = {
    "type",
    "expirationDate",
    "emailLabelDetail",
    "processingOptions",
    "recommendedDocumentSpecification",
    "documentReferences"
})
public class PendingShipmentDetail {

    @XmlElement(name = "Type", required = true)
    protected PendingShipmentType type;
    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "EmailLabelDetail")
    protected EMailLabelDetail emailLabelDetail;
    @XmlElement(name = "ProcessingOptions")
    protected PendingShipmentProcessingOptionsRequested processingOptions;
    @XmlElement(name = "RecommendedDocumentSpecification")
    protected RecommendedDocumentSpecification recommendedDocumentSpecification;
    @XmlElement(name = "DocumentReferences")
    protected List<UploadDocumentReferenceDetail> documentReferences;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link PendingShipmentType }
     *     
     */
    public PendingShipmentType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingShipmentType }
     *     
     */
    public void setType(PendingShipmentType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad emailLabelDetail.
     * 
     * @return
     *     possible object is
     *     {@link EMailLabelDetail }
     *     
     */
    public EMailLabelDetail getEmailLabelDetail() {
        return emailLabelDetail;
    }

    /**
     * Define el valor de la propiedad emailLabelDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link EMailLabelDetail }
     *     
     */
    public void setEmailLabelDetail(EMailLabelDetail value) {
        this.emailLabelDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad processingOptions.
     * 
     * @return
     *     possible object is
     *     {@link PendingShipmentProcessingOptionsRequested }
     *     
     */
    public PendingShipmentProcessingOptionsRequested getProcessingOptions() {
        return processingOptions;
    }

    /**
     * Define el valor de la propiedad processingOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingShipmentProcessingOptionsRequested }
     *     
     */
    public void setProcessingOptions(PendingShipmentProcessingOptionsRequested value) {
        this.processingOptions = value;
    }

    /**
     * Obtiene el valor de la propiedad recommendedDocumentSpecification.
     * 
     * @return
     *     possible object is
     *     {@link RecommendedDocumentSpecification }
     *     
     */
    public RecommendedDocumentSpecification getRecommendedDocumentSpecification() {
        return recommendedDocumentSpecification;
    }

    /**
     * Define el valor de la propiedad recommendedDocumentSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link RecommendedDocumentSpecification }
     *     
     */
    public void setRecommendedDocumentSpecification(RecommendedDocumentSpecification value) {
        this.recommendedDocumentSpecification = value;
    }

    /**
     * Gets the value of the documentReferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UploadDocumentReferenceDetail }
     * 
     * 
     */
    public List<UploadDocumentReferenceDetail> getDocumentReferences() {
        if (documentReferences == null) {
            documentReferences = new ArrayList<UploadDocumentReferenceDetail>();
        }
        return this.documentReferences;
    }

}
