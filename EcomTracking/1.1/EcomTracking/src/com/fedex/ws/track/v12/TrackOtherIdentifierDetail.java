
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackOtherIdentifierDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackOtherIdentifierDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageIdentifier" type="{http://fedex.com/ws/track/v12}TrackPackageIdentifier" minOccurs="0"/>
 *         &lt;element name="TrackingNumberUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarrierCode" type="{http://fedex.com/ws/track/v12}CarrierCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackOtherIdentifierDetail", propOrder = {
    "packageIdentifier",
    "trackingNumberUniqueIdentifier",
    "carrierCode"
})
public class TrackOtherIdentifierDetail {

    @XmlElement(name = "PackageIdentifier")
    protected TrackPackageIdentifier packageIdentifier;
    @XmlElement(name = "TrackingNumberUniqueIdentifier")
    protected String trackingNumberUniqueIdentifier;
    @XmlElement(name = "CarrierCode")
    protected CarrierCodeType carrierCode;

    /**
     * Obtiene el valor de la propiedad packageIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link TrackPackageIdentifier }
     *     
     */
    public TrackPackageIdentifier getPackageIdentifier() {
        return packageIdentifier;
    }

    /**
     * Define el valor de la propiedad packageIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPackageIdentifier }
     *     
     */
    public void setPackageIdentifier(TrackPackageIdentifier value) {
        this.packageIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumberUniqueIdentifier() {
        return trackingNumberUniqueIdentifier;
    }

    /**
     * Define el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumberUniqueIdentifier(String value) {
        this.trackingNumberUniqueIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad carrierCode.
     * 
     * @return
     *     possible object is
     *     {@link CarrierCodeType }
     *     
     */
    public CarrierCodeType getCarrierCode() {
        return carrierCode;
    }

    /**
     * Define el valor de la propiedad carrierCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierCodeType }
     *     
     */
    public void setCarrierCode(CarrierCodeType value) {
        this.carrierCode = value;
    }

}
