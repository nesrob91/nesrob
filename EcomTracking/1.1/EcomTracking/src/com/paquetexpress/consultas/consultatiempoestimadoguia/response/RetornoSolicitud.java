
package com.paquetexpress.consultas.consultatiempoestimadoguia.response;

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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia/Response}tiempoEstimado" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia/Response}Mensajes"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia/Response}DatosAdicionales" minOccurs="0"/>
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
    "tiempoEstimado",
    "mensajes",
    "datosAdicionales"
})
@XmlRootElement(name = "RetornoSolicitud")
public class RetornoSolicitud {

    protected String tiempoEstimado;
    @XmlElement(name = "Mensajes", required = true)
    protected Mensajes mensajes;
    @XmlElement(name = "DatosAdicionales")
    protected DatosAdicionales datosAdicionales;

    /**
     * Obtiene el valor de la propiedad tiempoEstimado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    /**
     * Define el valor de la propiedad tiempoEstimado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiempoEstimado(String value) {
        this.tiempoEstimado = value;
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
