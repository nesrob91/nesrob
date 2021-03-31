
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}OtrosServicios" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dlvyType"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}ackType"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}codAmount" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}totlDeclVlue" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}invType"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}comments" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}reference" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}formaPago" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}Referencias" minOccurs="0"/>
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
    "otrosServicios",
    "dlvyType",
    "ackType",
    "codAmount",
    "totlDeclVlue",
    "invType",
    "comments",
    "reference",
    "formaPago",
    "referencias"
})
@XmlRootElement(name = "Servicios")
public class Servicios {

    @XmlElement(name = "OtrosServicios")
    protected OtrosServicios otrosServicios;
    @XmlElement(required = true)
    protected String dlvyType;
    @XmlElement(required = true)
    protected String ackType;
    @XmlElement(nillable = true)
    protected Double codAmount;
    @XmlElement(nillable = true)
    protected Double totlDeclVlue;
    @XmlElement(required = true)
    protected String invType;
    @XmlElement(nillable = true)
    protected String comments;
    @XmlElement(nillable = true)
    protected String reference;
    @XmlElement(nillable = true)
    protected String formaPago;
    @XmlElement(name = "Referencias")
    protected Referencias referencias;

    /**
     * Obtiene el valor de la propiedad otrosServicios.
     * 
     * @return
     *     possible object is
     *     {@link OtrosServicios }
     *     
     */
    public OtrosServicios getOtrosServicios() {
        return otrosServicios;
    }

    /**
     * Define el valor de la propiedad otrosServicios.
     * 
     * @param value
     *     allowed object is
     *     {@link OtrosServicios }
     *     
     */
    public void setOtrosServicios(OtrosServicios value) {
        this.otrosServicios = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvyType() {
        return dlvyType;
    }

    /**
     * Define el valor de la propiedad dlvyType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvyType(String value) {
        this.dlvyType = value;
    }

    /**
     * Obtiene el valor de la propiedad ackType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAckType() {
        return ackType;
    }

    /**
     * Define el valor de la propiedad ackType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAckType(String value) {
        this.ackType = value;
    }

    /**
     * Obtiene el valor de la propiedad codAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodAmount() {
        return codAmount;
    }

    /**
     * Define el valor de la propiedad codAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodAmount(Double value) {
        this.codAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad totlDeclVlue.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotlDeclVlue() {
        return totlDeclVlue;
    }

    /**
     * Define el valor de la propiedad totlDeclVlue.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotlDeclVlue(Double value) {
        this.totlDeclVlue = value;
    }

    /**
     * Obtiene el valor de la propiedad invType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvType() {
        return invType;
    }

    /**
     * Define el valor de la propiedad invType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvType(String value) {
        this.invType = value;
    }

    /**
     * Obtiene el valor de la propiedad comments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Define el valor de la propiedad comments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Obtiene el valor de la propiedad reference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Define el valor de la propiedad reference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Define el valor de la propiedad formaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad referencias.
     * 
     * @return
     *     possible object is
     *     {@link Referencias }
     *     
     */
    public Referencias getReferencias() {
        return referencias;
    }

    /**
     * Define el valor de la propiedad referencias.
     * 
     * @param value
     *     allowed object is
     *     {@link Referencias }
     *     
     */
    public void setReferencias(Referencias value) {
        this.referencias = value;
    }

}
