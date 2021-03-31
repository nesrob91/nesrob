
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data required for shipments handled under the SMART_POST and GROUND_SMART_POST service types.
 * 
 * <p>Clase Java para SmartPostShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SmartPostShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessingOptionsRequested" type="{http://fedex.com/ws/ship/v19}SmartPostShipmentProcessingOptionsRequested" minOccurs="0"/>
 *         &lt;element name="Indicia" type="{http://fedex.com/ws/ship/v19}SmartPostIndiciaType" minOccurs="0"/>
 *         &lt;element name="AncillaryEndorsement" type="{http://fedex.com/ws/ship/v19}SmartPostAncillaryEndorsementType" minOccurs="0"/>
 *         &lt;element name="HubId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerManifestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmartPostShipmentDetail", propOrder = {
    "processingOptionsRequested",
    "indicia",
    "ancillaryEndorsement",
    "hubId",
    "customerManifestId"
})
public class SmartPostShipmentDetail {

    @XmlElement(name = "ProcessingOptionsRequested")
    protected SmartPostShipmentProcessingOptionsRequested processingOptionsRequested;
    @XmlElement(name = "Indicia")
    protected SmartPostIndiciaType indicia;
    @XmlElement(name = "AncillaryEndorsement")
    protected SmartPostAncillaryEndorsementType ancillaryEndorsement;
    @XmlElement(name = "HubId")
    protected String hubId;
    @XmlElement(name = "CustomerManifestId")
    protected String customerManifestId;

    /**
     * Obtiene el valor de la propiedad processingOptionsRequested.
     * 
     * @return
     *     possible object is
     *     {@link SmartPostShipmentProcessingOptionsRequested }
     *     
     */
    public SmartPostShipmentProcessingOptionsRequested getProcessingOptionsRequested() {
        return processingOptionsRequested;
    }

    /**
     * Define el valor de la propiedad processingOptionsRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link SmartPostShipmentProcessingOptionsRequested }
     *     
     */
    public void setProcessingOptionsRequested(SmartPostShipmentProcessingOptionsRequested value) {
        this.processingOptionsRequested = value;
    }

    /**
     * Obtiene el valor de la propiedad indicia.
     * 
     * @return
     *     possible object is
     *     {@link SmartPostIndiciaType }
     *     
     */
    public SmartPostIndiciaType getIndicia() {
        return indicia;
    }

    /**
     * Define el valor de la propiedad indicia.
     * 
     * @param value
     *     allowed object is
     *     {@link SmartPostIndiciaType }
     *     
     */
    public void setIndicia(SmartPostIndiciaType value) {
        this.indicia = value;
    }

    /**
     * Obtiene el valor de la propiedad ancillaryEndorsement.
     * 
     * @return
     *     possible object is
     *     {@link SmartPostAncillaryEndorsementType }
     *     
     */
    public SmartPostAncillaryEndorsementType getAncillaryEndorsement() {
        return ancillaryEndorsement;
    }

    /**
     * Define el valor de la propiedad ancillaryEndorsement.
     * 
     * @param value
     *     allowed object is
     *     {@link SmartPostAncillaryEndorsementType }
     *     
     */
    public void setAncillaryEndorsement(SmartPostAncillaryEndorsementType value) {
        this.ancillaryEndorsement = value;
    }

    /**
     * Obtiene el valor de la propiedad hubId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubId() {
        return hubId;
    }

    /**
     * Define el valor de la propiedad hubId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubId(String value) {
        this.hubId = value;
    }

    /**
     * Obtiene el valor de la propiedad customerManifestId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerManifestId() {
        return customerManifestId;
    }

    /**
     * Define el valor de la propiedad customerManifestId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerManifestId(String value) {
        this.customerManifestId = value;
    }

}
