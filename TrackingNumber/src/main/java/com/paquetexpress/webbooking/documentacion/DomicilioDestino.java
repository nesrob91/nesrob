
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}pais" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}estado" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}ciudad" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}strtName"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}drnr"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}colonyName"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}zipCode"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}amMailId" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}phoneNo" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}destinationRefDom" minOccurs="0"/>
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
    "pais",
    "estado",
    "ciudad",
    "strtName",
    "drnr",
    "colonyName",
    "zipCode",
    "amMailId",
    "phoneNo",
    "destinationRefDom"
})
@XmlRootElement(name = "DomicilioDestino")
public class DomicilioDestino {

    @XmlElement(nillable = true)
    protected String pais;
    @XmlElement(nillable = true)
    protected String estado;
    @XmlElement(nillable = true)
    protected String ciudad;
    @XmlElement(required = true)
    protected String strtName;
    @XmlElement(required = true)
    protected String drnr;
    @XmlElement(required = true)
    protected String colonyName;
    @XmlElement(required = true)
    protected String zipCode;
    @XmlElement(nillable = true)
    protected String amMailId;
    @XmlElement(nillable = true)
    protected String phoneNo;
    @XmlElement(nillable = true)
    protected String destinationRefDom;

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad strtName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrtName() {
        return strtName;
    }

    /**
     * Define el valor de la propiedad strtName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrtName(String value) {
        this.strtName = value;
    }

    /**
     * Obtiene el valor de la propiedad drnr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrnr() {
        return drnr;
    }

    /**
     * Define el valor de la propiedad drnr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrnr(String value) {
        this.drnr = value;
    }

    /**
     * Obtiene el valor de la propiedad colonyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColonyName() {
        return colonyName;
    }

    /**
     * Define el valor de la propiedad colonyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColonyName(String value) {
        this.colonyName = value;
    }

    /**
     * Obtiene el valor de la propiedad zipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Define el valor de la propiedad zipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Obtiene el valor de la propiedad amMailId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmMailId() {
        return amMailId;
    }

    /**
     * Define el valor de la propiedad amMailId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmMailId(String value) {
        this.amMailId = value;
    }

    /**
     * Obtiene el valor de la propiedad phoneNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Define el valor de la propiedad phoneNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationRefDom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationRefDom() {
        return destinationRefDom;
    }

    /**
     * Define el valor de la propiedad destinationRefDom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationRefDom(String value) {
        this.destinationRefDom = value;
    }

}
