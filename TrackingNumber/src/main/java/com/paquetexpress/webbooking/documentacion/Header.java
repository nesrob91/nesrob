
package com.paquetexpress.webbooking.documentacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}orgnClntId"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}clntPswd"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}agreementKey"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}typeEvent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orgnClntId",
    "clntPswd",
    "agreementKey",
    "typeEvent"
})
@XmlRootElement(name = "Header")
public class Header {

    @XmlElement(required = true)
    protected String orgnClntId;
    @XmlElement(required = true)
    protected String clntPswd;
    @XmlElement(required = true)
    protected String agreementKey;
    @XmlElement(required = true)
    protected String typeEvent;

    /**
     * Obtiene el valor de la propiedad orgnClntId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnClntId() {
        return orgnClntId;
    }

    /**
     * Define el valor de la propiedad orgnClntId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnClntId(String value) {
        this.orgnClntId = value;
    }

    /**
     * Obtiene el valor de la propiedad clntPswd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClntPswd() {
        return clntPswd;
    }

    /**
     * Define el valor de la propiedad clntPswd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClntPswd(String value) {
        this.clntPswd = value;
    }

    /**
     * Obtiene el valor de la propiedad agreementKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementKey() {
        return agreementKey;
    }

    /**
     * Define el valor de la propiedad agreementKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementKey(String value) {
        this.agreementKey = value;
    }

    /**
     * Obtiene el valor de la propiedad typeEvent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeEvent() {
        return typeEvent;
    }

    /**
     * Define el valor de la propiedad typeEvent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeEvent(String value) {
        this.typeEvent = value;
    }

}
