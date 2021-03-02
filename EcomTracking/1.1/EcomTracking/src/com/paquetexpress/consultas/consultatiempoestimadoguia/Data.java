
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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia}Header"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia}SolicitudEnvio"/>
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
    "header",
    "solicitudEnvio"
})
@XmlRootElement(name = "Data")
public class Data {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "SolicitudEnvio", required = true)
    protected SolicitudEnvio solicitudEnvio;

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitudEnvio.
     * 
     * @return
     *     possible object is
     *     {@link SolicitudEnvio }
     *     
     */
    public SolicitudEnvio getSolicitudEnvio() {
        return solicitudEnvio;
    }

    /**
     * Define el valor de la propiedad solicitudEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link SolicitudEnvio }
     *     
     */
    public void setSolicitudEnvio(SolicitudEnvio value) {
        this.solicitudEnvio = value;
    }

}
