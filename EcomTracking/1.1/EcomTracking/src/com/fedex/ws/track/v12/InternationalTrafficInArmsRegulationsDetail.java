
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InternationalTrafficInArmsRegulationsDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InternationalTrafficInArmsRegulationsDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LicenseOrExemptionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalTrafficInArmsRegulationsDetail", propOrder = {
    "licenseOrExemptionNumber"
})
public class InternationalTrafficInArmsRegulationsDetail {

    @XmlElement(name = "LicenseOrExemptionNumber")
    protected String licenseOrExemptionNumber;

    /**
     * Obtiene el valor de la propiedad licenseOrExemptionNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseOrExemptionNumber() {
        return licenseOrExemptionNumber;
    }

    /**
     * Define el valor de la propiedad licenseOrExemptionNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseOrExemptionNumber(String value) {
        this.licenseOrExemptionNumber = value;
    }

}
