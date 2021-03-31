
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}discAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}srvcAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}subTotlAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}taxAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}taxRetAmnt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}totalAmnt" minOccurs="0"/>
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
    "shpAmnt",
    "discAmnt",
    "srvcAmnt",
    "subTotlAmnt",
    "taxAmnt",
    "taxRetAmnt",
    "totalAmnt"
})
@XmlRootElement(name = "Importe")
public class Importe {

    protected Double shpAmnt;
    protected Double discAmnt;
    protected Double srvcAmnt;
    protected Double subTotlAmnt;
    protected Double taxAmnt;
    protected Double taxRetAmnt;
    protected Double totalAmnt;

    /**
     * Obtiene el valor de la propiedad shpAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpAmnt() {
        return shpAmnt;
    }

    /**
     * Define el valor de la propiedad shpAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpAmnt(Double value) {
        this.shpAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad discAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDiscAmnt() {
        return discAmnt;
    }

    /**
     * Define el valor de la propiedad discAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDiscAmnt(Double value) {
        this.discAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad srvcAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSrvcAmnt() {
        return srvcAmnt;
    }

    /**
     * Define el valor de la propiedad srvcAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSrvcAmnt(Double value) {
        this.srvcAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad subTotlAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSubTotlAmnt() {
        return subTotlAmnt;
    }

    /**
     * Define el valor de la propiedad subTotlAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSubTotlAmnt(Double value) {
        this.subTotlAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad taxAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxAmnt() {
        return taxAmnt;
    }

    /**
     * Define el valor de la propiedad taxAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxAmnt(Double value) {
        this.taxAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad taxRetAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxRetAmnt() {
        return taxRetAmnt;
    }

    /**
     * Define el valor de la propiedad taxRetAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxRetAmnt(Double value) {
        this.taxRetAmnt = value;
    }

    /**
     * Obtiene el valor de la propiedad totalAmnt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalAmnt() {
        return totalAmnt;
    }

    /**
     * Define el valor de la propiedad totalAmnt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalAmnt(Double value) {
        this.totalAmnt = value;
    }

}
