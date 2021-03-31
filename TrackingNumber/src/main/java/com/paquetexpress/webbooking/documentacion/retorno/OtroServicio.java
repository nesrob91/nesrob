
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}clave" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}descripcion" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}serviceAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}otrTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}otrTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}otrTypeAmtRetTax" minOccurs="0"/>
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
    "clave",
    "descripcion",
    "serviceAmnt",
    "otrTypeAmtDisc",
    "otrTypeAmtTax",
    "otrTypeAmtRetTax"
})
@XmlRootElement(name = "OtroServicio")
public class OtroServicio {

    protected String clave;
    protected String descripcion;
    protected Double serviceAmnt;
    protected Double otrTypeAmtDisc;
    protected Double otrTypeAmtTax;
    protected Double otrTypeAmtRetTax;

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getServiceAmnt() {
        return serviceAmnt;
    }

    /**
     * Define el valor de la propiedad serviceAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setServiceAmnt(Double value) {
        this.serviceAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad otrTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOtrTypeAmtDisc() {
        return otrTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad otrTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOtrTypeAmtDisc(Double value) {
        this.otrTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad otrTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOtrTypeAmtTax() {
        return otrTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad otrTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOtrTypeAmtTax(Double value) {
        this.otrTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad otrTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOtrTypeAmtRetTax() {
        return otrTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad otrTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOtrTypeAmtRetTax(Double value) {
        this.otrTypeAmtRetTax = value;
    }

}
