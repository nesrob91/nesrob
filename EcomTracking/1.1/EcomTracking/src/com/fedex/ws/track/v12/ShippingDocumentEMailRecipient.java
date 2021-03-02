
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies an individual recipient of e-mailed shipping document(s).
 * 
 * <p>Clase Java para ShippingDocumentEMailRecipient complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShippingDocumentEMailRecipient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecipientType" type="{http://fedex.com/ws/ship/v19}EMailNotificationRecipientType" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingDocumentEMailRecipient", propOrder = {
    "recipientType",
    "address"
})
public class ShippingDocumentEMailRecipient {

    @XmlElement(name = "RecipientType")
    protected EMailNotificationRecipientType recipientType;
    @XmlElement(name = "Address")
    protected String address;

    /**
     * Obtiene el valor de la propiedad recipientType.
     * 
     * @return
     *     possible object is
     *     {@link EMailNotificationRecipientType }
     *     
     */
    public EMailNotificationRecipientType getRecipientType() {
        return recipientType;
    }

    /**
     * Define el valor de la propiedad recipientType.
     * 
     * @param value
     *     allowed object is
     *     {@link EMailNotificationRecipientType }
     *     
     */
    public void setRecipientType(EMailNotificationRecipientType value) {
        this.recipientType = value;
    }

    /**
     * Obtiene el valor de la propiedad address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

}
