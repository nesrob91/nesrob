
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Descriptive data for the client submitting a transaction.
 * 
 * <p>Clase Java para ClientDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClientDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MeterNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IntegratorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Localization" type="{http://fedex.com/ws/track/v12}Localization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientDetail", propOrder = {
    "accountNumber",
    "meterNumber",
    "integratorId",
    "localization"
})
public class ClientDetail {

    @XmlElement(name = "AccountNumber", required = true)
    protected String accountNumber;
    @XmlElement(name = "MeterNumber", required = true)
    protected String meterNumber;
    @XmlElement(name = "IntegratorId")
    protected String integratorId;
    @XmlElement(name = "Localization")
    protected Localization localization;

    /**
     * Obtiene el valor de la propiedad accountNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Define el valor de la propiedad accountNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad meterNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterNumber() {
        return meterNumber;
    }

    /**
     * Define el valor de la propiedad meterNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterNumber(String value) {
        this.meterNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad integratorId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegratorId() {
        return integratorId;
    }

    /**
     * Define el valor de la propiedad integratorId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegratorId(String value) {
        this.integratorId = value;
    }

    /**
     * Obtiene el valor de la propiedad localization.
     * 
     * @return
     *     possible object is
     *     {@link Localization }
     *     
     */
    public Localization getLocalization() {
        return localization;
    }

    /**
     * Define el valor de la propiedad localization.
     * 
     * @param value
     *     allowed object is
     *     {@link Localization }
     *     
     */
    public void setLocalization(Localization value) {
        this.localization = value;
    }

}
