
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information describing the address of of the email recipient, role of the email recipient and languages that are requested to be supported.
 * 
 * <p>Clase Java para EMailRecipient complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EMailRecipient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Role" type="{http://fedex.com/ws/ship/v19}AccessorRoleType" minOccurs="0"/>
 *         &lt;element name="OptionsRequested" type="{http://fedex.com/ws/ship/v19}EmailOptionsRequested" minOccurs="0"/>
 *         &lt;element name="Localization" type="{http://fedex.com/ws/ship/v19}Localization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EMailRecipient", propOrder = {
    "emailAddress",
    "role",
    "optionsRequested",
    "localization"
})
public class EMailRecipient {

    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "Role")
    protected AccessorRoleType role;
    @XmlElement(name = "OptionsRequested")
    protected EmailOptionsRequested optionsRequested;
    @XmlElement(name = "Localization")
    protected Localization localization;

    /**
     * Obtiene el valor de la propiedad emailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Define el valor de la propiedad emailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad role.
     * 
     * @return
     *     possible object is
     *     {@link AccessorRoleType }
     *     
     */
    public AccessorRoleType getRole() {
        return role;
    }

    /**
     * Define el valor de la propiedad role.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessorRoleType }
     *     
     */
    public void setRole(AccessorRoleType value) {
        this.role = value;
    }

    /**
     * Obtiene el valor de la propiedad optionsRequested.
     * 
     * @return
     *     possible object is
     *     {@link EmailOptionsRequested }
     *     
     */
    public EmailOptionsRequested getOptionsRequested() {
        return optionsRequested;
    }

    /**
     * Define el valor de la propiedad optionsRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailOptionsRequested }
     *     
     */
    public void setOptionsRequested(EmailOptionsRequested value) {
        this.optionsRequested = value;
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
