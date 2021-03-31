
package com.paquetexpress.webbooking.documentacion.retorno;

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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}cveMsjeRetorno" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}desMsjeRetorno" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}tratamientoMsje" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}tipoMsje" minOccurs="0"/>
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
    "cveMsjeRetorno",
    "desMsjeRetorno",
    "tratamientoMsje",
    "tipoMsje"
})
@XmlRootElement(name = "Mensaje")
public class Mensaje {

    protected Integer cveMsjeRetorno;
    protected String desMsjeRetorno;
    protected String tratamientoMsje;
    protected String tipoMsje;

    /**
     * Obtiene el valor de la propiedad cveMsjeRetorno.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCveMsjeRetorno() {
        return cveMsjeRetorno;
    }

    /**
     * Define el valor de la propiedad cveMsjeRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCveMsjeRetorno(Integer value) {
        this.cveMsjeRetorno = value;
    }

    /**
     * Obtiene el valor de la propiedad desMsjeRetorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesMsjeRetorno() {
        return desMsjeRetorno;
    }

    /**
     * Define el valor de la propiedad desMsjeRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesMsjeRetorno(String value) {
        this.desMsjeRetorno = value;
    }

    /**
     * Obtiene el valor de la propiedad tratamientoMsje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTratamientoMsje() {
        return tratamientoMsje;
    }

    /**
     * Define el valor de la propiedad tratamientoMsje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTratamientoMsje(String value) {
        this.tratamientoMsje = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoMsje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMsje() {
        return tipoMsje;
    }

    /**
     * Define el valor de la propiedad tipoMsje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMsje(String value) {
        this.tipoMsje = value;
    }

}
