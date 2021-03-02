
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Payment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentType" type="{http://fedex.com/ws/ship/v19}PaymentType"/>
 *         &lt;element name="Payor" type="{http://fedex.com/ws/ship/v19}Payor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = {
    "paymentType",
    "payor"
})
public class Payment {

    @XmlElement(name = "PaymentType", required = true)
    protected PaymentType paymentType;
    @XmlElement(name = "Payor")
    protected Payor payor;

    /**
     * Obtiene el valor de la propiedad paymentType.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Define el valor de la propiedad paymentType.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
    }

    /**
     * Obtiene el valor de la propiedad payor.
     * 
     * @return
     *     possible object is
     *     {@link Payor }
     *     
     */
    public Payor getPayor() {
        return payor;
    }

    /**
     * Define el valor de la propiedad payor.
     * 
     * @param value
     *     allowed object is
     *     {@link Payor }
     *     
     */
    public void setPayor(Payor value) {
        this.payor = value;
    }

}
