
package com.paquetexpress.webbooking.documentacion.retorno;

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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}DetalleEmbarque" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}Servicios" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}Mensajes"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}formNo" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}guiaNo" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}guiaNoTemp" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}cadenaImpresion" minOccurs="0"/>
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
    "detalleEmbarque",
    "servicios",
    "mensajes",
    "formNo",
    "guiaNo",
    "guiaNoTemp",
    "cadenaImpresion"
})
@XmlRootElement(name = "RetornoSolicitud")
public class RetornoSolicitud {

    @XmlElement(name = "DetalleEmbarque")
    protected DetalleEmbarque detalleEmbarque;
    @XmlElement(name = "Servicios")
    protected Servicios servicios;
    @XmlElement(name = "Mensajes", required = true)
    protected Mensajes mensajes;
    protected String formNo;
    protected String guiaNo;
    protected String guiaNoTemp;
    protected String cadenaImpresion;

    /**
     * Obtiene el valor de la propiedad detalleEmbarque.
     * 
     * @return
     *     possible object is
     *     {@link DetalleEmbarque }
     *     
     */
    public DetalleEmbarque getDetalleEmbarque() {
        return detalleEmbarque;
    }

    /**
     * Define el valor de la propiedad detalleEmbarque.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleEmbarque }
     *     
     */
    public void setDetalleEmbarque(DetalleEmbarque value) {
        this.detalleEmbarque = value;
    }

    /**
     * Obtiene el valor de la propiedad servicios.
     * 
     * @return
     *     possible object is
     *     {@link Servicios }
     *     
     */
    public Servicios getServicios() {
        return servicios;
    }

    /**
     * Define el valor de la propiedad servicios.
     * 
     * @param value
     *     allowed object is
     *     {@link Servicios }
     *     
     */
    public void setServicios(Servicios value) {
        this.servicios = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajes.
     * 
     * @return
     *     possible object is
     *     {@link Mensajes }
     *     
     */
    public Mensajes getMensajes() {
        return mensajes;
    }

    /**
     * Define el valor de la propiedad mensajes.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensajes }
     *     
     */
    public void setMensajes(Mensajes value) {
        this.mensajes = value;
    }

    /**
     * Obtiene el valor de la propiedad formNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormNo() {
        return formNo;
    }

    /**
     * Define el valor de la propiedad formNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormNo(String value) {
        this.formNo = value;
    }

    /**
     * Obtiene el valor de la propiedad guiaNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuiaNo() {
        return guiaNo;
    }

    /**
     * Define el valor de la propiedad guiaNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuiaNo(String value) {
        this.guiaNo = value;
    }

    /**
     * Obtiene el valor de la propiedad guiaNoTemp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuiaNoTemp() {
        return guiaNoTemp;
    }

    /**
     * Define el valor de la propiedad guiaNoTemp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuiaNoTemp(String value) {
        this.guiaNoTemp = value;
    }

    /**
     * Obtiene el valor de la propiedad cadenaImpresion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadenaImpresion() {
        return cadenaImpresion;
    }

    /**
     * Define el valor de la propiedad cadenaImpresion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadenaImpresion(String value) {
        this.cadenaImpresion = value;
    }

}
