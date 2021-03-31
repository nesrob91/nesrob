
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * These special services are available at the package level for some or all service types. If the shipper is requesting a special service which requires additional data, the package special service type must be present in the specialServiceTypes collection, and the supporting detail must be provided in the appropriate sub-object below.
 * 
 * <p>Clase Java para PackageSpecialServicesRequested complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PackageSpecialServicesRequested">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialServiceTypes" type="{http://fedex.com/ws/ship/v19}PackageSpecialServiceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CodDetail" type="{http://fedex.com/ws/ship/v19}CodDetail" minOccurs="0"/>
 *         &lt;element name="DangerousGoodsDetail" type="{http://fedex.com/ws/ship/v19}DangerousGoodsDetail" minOccurs="0"/>
 *         &lt;element name="DryIceWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="SignatureOptionDetail" type="{http://fedex.com/ws/ship/v19}SignatureOptionDetail" minOccurs="0"/>
 *         &lt;element name="PriorityAlertDetail" type="{http://fedex.com/ws/ship/v19}PriorityAlertDetail" minOccurs="0"/>
 *         &lt;element name="AlcoholDetail" type="{http://fedex.com/ws/ship/v19}AlcoholDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageSpecialServicesRequested", propOrder = {
    "specialServiceTypes",
    "codDetail",
    "dangerousGoodsDetail",
    "dryIceWeight",
    "signatureOptionDetail",
    "priorityAlertDetail",
    "alcoholDetail"
})
public class PackageSpecialServicesRequested {

    @XmlElement(name = "SpecialServiceTypes")
    protected List<PackageSpecialServiceType> specialServiceTypes;
    @XmlElement(name = "CodDetail")
    protected CodDetail codDetail;
    @XmlElement(name = "DangerousGoodsDetail")
    protected DangerousGoodsDetail dangerousGoodsDetail;
    @XmlElement(name = "DryIceWeight")
    protected Weight dryIceWeight;
    @XmlElement(name = "SignatureOptionDetail")
    protected SignatureOptionDetail signatureOptionDetail;
    @XmlElement(name = "PriorityAlertDetail")
    protected PriorityAlertDetail priorityAlertDetail;
    @XmlElement(name = "AlcoholDetail")
    protected AlcoholDetail alcoholDetail;

    /**
     * Gets the value of the specialServiceTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialServiceTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialServiceTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageSpecialServiceType }
     * 
     * 
     */
    public List<PackageSpecialServiceType> getSpecialServiceTypes() {
        if (specialServiceTypes == null) {
            specialServiceTypes = new ArrayList<PackageSpecialServiceType>();
        }
        return this.specialServiceTypes;
    }

    /**
     * Obtiene el valor de la propiedad codDetail.
     * 
     * @return
     *     possible object is
     *     {@link CodDetail }
     *     
     */
    public CodDetail getCodDetail() {
        return codDetail;
    }

    /**
     * Define el valor de la propiedad codDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CodDetail }
     *     
     */
    public void setCodDetail(CodDetail value) {
        this.codDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad dangerousGoodsDetail.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodsDetail }
     *     
     */
    public DangerousGoodsDetail getDangerousGoodsDetail() {
        return dangerousGoodsDetail;
    }

    /**
     * Define el valor de la propiedad dangerousGoodsDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodsDetail }
     *     
     */
    public void setDangerousGoodsDetail(DangerousGoodsDetail value) {
        this.dangerousGoodsDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad dryIceWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getDryIceWeight() {
        return dryIceWeight;
    }

    /**
     * Define el valor de la propiedad dryIceWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setDryIceWeight(Weight value) {
        this.dryIceWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureOptionDetail.
     * 
     * @return
     *     possible object is
     *     {@link SignatureOptionDetail }
     *     
     */
    public SignatureOptionDetail getSignatureOptionDetail() {
        return signatureOptionDetail;
    }

    /**
     * Define el valor de la propiedad signatureOptionDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureOptionDetail }
     *     
     */
    public void setSignatureOptionDetail(SignatureOptionDetail value) {
        this.signatureOptionDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad priorityAlertDetail.
     * 
     * @return
     *     possible object is
     *     {@link PriorityAlertDetail }
     *     
     */
    public PriorityAlertDetail getPriorityAlertDetail() {
        return priorityAlertDetail;
    }

    /**
     * Define el valor de la propiedad priorityAlertDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityAlertDetail }
     *     
     */
    public void setPriorityAlertDetail(PriorityAlertDetail value) {
        this.priorityAlertDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad alcoholDetail.
     * 
     * @return
     *     possible object is
     *     {@link AlcoholDetail }
     *     
     */
    public AlcoholDetail getAlcoholDetail() {
        return alcoholDetail;
    }

    /**
     * Define el valor de la propiedad alcoholDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link AlcoholDetail }
     *     
     */
    public void setAlcoholDetail(AlcoholDetail value) {
        this.alcoholDetail = value;
    }

}
