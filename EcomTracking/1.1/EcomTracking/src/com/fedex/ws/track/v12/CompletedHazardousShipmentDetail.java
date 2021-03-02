
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Computed shipment level hazardous commodity information.
 * 
 * <p>Clase Java para CompletedHazardousShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedHazardousShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HazardousSummaryDetail" type="{http://fedex.com/ws/ship/v19}CompletedHazardousSummaryDetail" minOccurs="0"/>
 *         &lt;element name="DryIceDetail" type="{http://fedex.com/ws/ship/v19}ShipmentDryIceDetail" minOccurs="0"/>
 *         &lt;element name="AdrLicense" type="{http://fedex.com/ws/ship/v19}AdrLicenseDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedHazardousShipmentDetail", propOrder = {
    "hazardousSummaryDetail",
    "dryIceDetail",
    "adrLicense"
})
public class CompletedHazardousShipmentDetail {

    @XmlElement(name = "HazardousSummaryDetail")
    protected CompletedHazardousSummaryDetail hazardousSummaryDetail;
    @XmlElement(name = "DryIceDetail")
    protected ShipmentDryIceDetail dryIceDetail;
    @XmlElement(name = "AdrLicense")
    protected AdrLicenseDetail adrLicense;

    /**
     * Obtiene el valor de la propiedad hazardousSummaryDetail.
     * 
     * @return
     *     possible object is
     *     {@link CompletedHazardousSummaryDetail }
     *     
     */
    public CompletedHazardousSummaryDetail getHazardousSummaryDetail() {
        return hazardousSummaryDetail;
    }

    /**
     * Define el valor de la propiedad hazardousSummaryDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletedHazardousSummaryDetail }
     *     
     */
    public void setHazardousSummaryDetail(CompletedHazardousSummaryDetail value) {
        this.hazardousSummaryDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad dryIceDetail.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentDryIceDetail }
     *     
     */
    public ShipmentDryIceDetail getDryIceDetail() {
        return dryIceDetail;
    }

    /**
     * Define el valor de la propiedad dryIceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentDryIceDetail }
     *     
     */
    public void setDryIceDetail(ShipmentDryIceDetail value) {
        this.dryIceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad adrLicense.
     * 
     * @return
     *     possible object is
     *     {@link AdrLicenseDetail }
     *     
     */
    public AdrLicenseDetail getAdrLicense() {
        return adrLicense;
    }

    /**
     * Define el valor de la propiedad adrLicense.
     * 
     * @param value
     *     allowed object is
     *     {@link AdrLicenseDetail }
     *     
     */
    public void setAdrLicense(AdrLicenseDetail value) {
        this.adrLicense = value;
    }

}
