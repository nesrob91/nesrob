
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}RetornoSolicitud"/>
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
    "retornoSolicitud"
})
@XmlRootElement(name = "DataResponse")
public class DataResponse {

    @XmlElement(name = "RetornoSolicitud", required = true)
    protected RetornoSolicitud retornoSolicitud;

    /**
     * Obtiene el valor de la propiedad retornoSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link RetornoSolicitud }
     *     
     */
    public RetornoSolicitud getRetornoSolicitud() {
        return retornoSolicitud;
    }

    /**
     * Define el valor de la propiedad retornoSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoSolicitud }
     *     
     */
    public void setRetornoSolicitud(RetornoSolicitud value) {
        this.retornoSolicitud = value;
    }

}
