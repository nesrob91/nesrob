
package com.paquetexpress.consultas.consultatiempoestimadoguia;

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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia}codigoPostalOrigen"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia}codigoPostalDestino"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia}DatosAdicionales" minOccurs="0"/>
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
    "codigoPostalOrigen",
    "codigoPostalDestino",
    "datosAdicionales"
})
@XmlRootElement(name = "SolicitudEnvio")
public class SolicitudEnvio {

    @XmlElement(required = true)
    protected String codigoPostalOrigen;
    @XmlElement(required = true)
    protected String codigoPostalDestino;
    @XmlElement(name = "DatosAdicionales")
    protected DatosAdicionales datosAdicionales;

    /**
     * Obtiene el valor de la propiedad codigoPostalOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPostalOrigen() {
        return codigoPostalOrigen;
    }

    /**
     * Define el valor de la propiedad codigoPostalOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPostalOrigen(String value) {
        this.codigoPostalOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPostalDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPostalDestino() {
        return codigoPostalDestino;
    }

    /**
     * Define el valor de la propiedad codigoPostalDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPostalDestino(String value) {
        this.codigoPostalDestino = value;
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
