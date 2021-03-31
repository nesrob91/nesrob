
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}ClienteDestino"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}DetalleEmbarque"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}Servicios"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}custAgnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}ghPediNumb" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}DatosAdicionales" minOccurs="0"/>
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
    "clienteDestino",
    "detalleEmbarque",
    "servicios",
    "custAgnt",
    "ghPediNumb",
    "datosAdicionales"
})
@XmlRootElement(name = "SolicitudEnvio")
public class SolicitudEnvio {

    @XmlElement(name = "ClienteDestino", required = true)
    protected ClienteDestino clienteDestino;
    @XmlElement(name = "DetalleEmbarque", required = true)
    protected DetalleEmbarque detalleEmbarque;
    @XmlElement(name = "Servicios", required = true)
    protected Servicios servicios;
    @XmlElement(nillable = true)
    protected String custAgnt;
    @XmlElement(nillable = true)
    protected String ghPediNumb;
    @XmlElement(name = "DatosAdicionales")
    protected DatosAdicionales datosAdicionales;

    /**
     * Obtiene el valor de la propiedad clienteDestino.
     * 
     * @return
     *     possible object is
     *     {@link ClienteDestino }
     *     
     */
    public ClienteDestino getClienteDestino() {
        return clienteDestino;
    }

    /**
     * Define el valor de la propiedad clienteDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteDestino }
     *     
     */
    public void setClienteDestino(ClienteDestino value) {
        this.clienteDestino = value;
    }

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
     * Obtiene el valor de la propiedad custAgnt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAgnt() {
        return custAgnt;
    }

    /**
     * Define el valor de la propiedad custAgnt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAgnt(String value) {
        this.custAgnt = value;
    }

    /**
     * Obtiene el valor de la propiedad ghPediNumb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGhPediNumb() {
        return ghPediNumb;
    }

    /**
     * Define el valor de la propiedad ghPediNumb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGhPediNumb(String value) {
        this.ghPediNumb = value;
    }

    /**
     * Obtiene el valor de la propiedad datosAdicionales.
     * 
     * @return
     *     possible object is
     *     {@link DatosAdicionales }
     *     
     */
    public DatosAdicionales getDatosAdicionales() {
        return datosAdicionales;
    }

    /**
     * Define el valor de la propiedad datosAdicionales.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosAdicionales }
     *     
     */
    public void setDatosAdicionales(DatosAdicionales value) {
        this.datosAdicionales = value;
    }

}
