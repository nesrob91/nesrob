
package com.paquetexpress.webbooking.documentacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}claveRef" minOccurs="0"/>
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
    "claveRef"
})
@XmlRootElement(name = "Referencia")
public class Referencia {

    protected String claveRef;

    /**
     * Obtiene el valor de la propiedad claveRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveRef() {
        return claveRef;
    }

    /**
     * Define el valor de la propiedad claveRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveRef(String value) {
        this.claveRef = value;
    }

}
