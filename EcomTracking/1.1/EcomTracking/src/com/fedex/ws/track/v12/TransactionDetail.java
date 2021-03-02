
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransactionDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransactionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "TransactionDetail", propOrder = {
    "customerTransactionId",
    "localization"
})
public class TransactionDetail {

    @XmlElement(name = "CustomerTransactionId")
    protected String customerTransactionId;
    @XmlElement(name = "Localization")
    protected Localization localization;

    /**
     * Obtiene el valor de la propiedad customerTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTransactionId() {
        return customerTransactionId;
    }

    /**
     * Define el valor de la propiedad customerTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTransactionId(String value) {
        this.customerTransactionId = value;
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
