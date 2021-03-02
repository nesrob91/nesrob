
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureOptionDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignatureOptionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OptionType" type="{http://fedex.com/ws/ship/v19}SignatureOptionType"/>
 *         &lt;element name="SignatureReleaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureOptionDetail", propOrder = {
    "optionType",
    "signatureReleaseNumber"
})
public class SignatureOptionDetail {

    @XmlElement(name = "OptionType", required = true)
    protected SignatureOptionType optionType;
    @XmlElement(name = "SignatureReleaseNumber")
    protected String signatureReleaseNumber;

    /**
     * Obtiene el valor de la propiedad optionType.
     * 
     * @return
     *     possible object is
     *     {@link SignatureOptionType }
     *     
     */
    public SignatureOptionType getOptionType() {
        return optionType;
    }

    /**
     * Define el valor de la propiedad optionType.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureOptionType }
     *     
     */
    public void setOptionType(SignatureOptionType value) {
        this.optionType = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureReleaseNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureReleaseNumber() {
        return signatureReleaseNumber;
    }

    /**
     * Define el valor de la propiedad signatureReleaseNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureReleaseNumber(String value) {
        this.signatureReleaseNumber = value;
    }

}
