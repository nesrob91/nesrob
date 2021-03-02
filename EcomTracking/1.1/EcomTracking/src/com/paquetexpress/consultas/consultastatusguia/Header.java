
package com.paquetexpress.consultas.consultastatusguia;

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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaStatusGuia}orgnSystem"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaStatusGuia}agreementKey"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaStatusGuia}typeEvent"/>
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
    "orgnSystem",
    "agreementKey",
    "typeEvent"
})
@XmlRootElement(name = "Header")
public class Header {

    @XmlElement(required = true)
    protected String orgnSystem;
    @XmlElement(required = true)
    protected String agreementKey;
    @XmlElement(required = true)
    protected String typeEvent;

    /**
     * Obtiene el valor de la propiedad orgnSystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnSystem() {
        return orgnSystem;
    }

    /**
     * Define el valor de la propiedad orgnSystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnSystem(String value) {
        this.orgnSystem = value;
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
