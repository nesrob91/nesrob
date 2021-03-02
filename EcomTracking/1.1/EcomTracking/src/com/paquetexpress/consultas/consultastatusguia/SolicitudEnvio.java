
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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaStatusGuia}numRastreo"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaStatusGuia}DatosAdicionales" minOccurs="0"/>
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
    "numRastreo",
    "datosAdicionales"
})
@XmlRootElement(name = "SolicitudEnvio")
public class SolicitudEnvio {

    @XmlElement(required = true)
    protected String numRastreo;
    @XmlElement(name = "DatosAdicionales")
    protected DatosAdicionales datosAdicionales;

    /**
     * Obtiene el valor de la propiedad numRastreo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumRastreo() {
        return numRastreo;
    }

    /**
     * Define el valor de la propiedad numRastreo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumRastreo(String value) {
        this.numRastreo = value;
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
