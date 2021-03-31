
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}claveDataAd"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}valorDataAd"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional1"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional2"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional3"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional4"/>
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
    "claveDataAd",
    "valorDataAd",
    "dataAditional1",
    "dataAditional2",
    "dataAditional3",
    "dataAditional4"
})
@XmlRootElement(name = "DatoAdicional")
public class DatoAdicional {

    @XmlElement(required = true)
    protected String claveDataAd;
    @XmlElement(required = true)
    protected String valorDataAd;
    @XmlElement(required = true)
    protected String dataAditional1;
    @XmlElement(required = true)
    protected String dataAditional2;
    @XmlElement(required = true)
    protected String dataAditional3;
    @XmlElement(required = true)
    protected String dataAditional4;

    /**
     * Obtiene el valor de la propiedad claveDataAd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveDataAd() {
        return claveDataAd;
    }

    /**
     * Define el valor de la propiedad claveDataAd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveDataAd(String value) {
        this.claveDataAd = value;
    }

    /**
     * Obtiene el valor de la propiedad valorDataAd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorDataAd() {
        return valorDataAd;
    }

    /**
     * Define el valor de la propiedad valorDataAd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorDataAd(String value) {
        this.valorDataAd = value;
    }

    /**
     * Obtiene el valor de la propiedad dataAditional1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAditional1() {
        return dataAditional1;
    }

    /**
     * Define el valor de la propiedad dataAditional1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAditional1(String value) {
        this.dataAditional1 = value;
    }

    /**
     * Obtiene el valor de la propiedad dataAditional2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAditional2() {
        return dataAditional2;
    }

    /**
     * Define el valor de la propiedad dataAditional2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAditional2(String value) {
        this.dataAditional2 = value;
    }

    /**
     * Obtiene el valor de la propiedad dataAditional3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAditional3() {
        return dataAditional3;
    }

    /**
     * Define el valor de la propiedad dataAditional3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAditional3(String value) {
        this.dataAditional3 = value;
    }

    /**
     * Obtiene el valor de la propiedad dataAditional4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAditional4() {
        return dataAditional4;
    }

    /**
     * Define el valor de la propiedad dataAditional4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAditional4(String value) {
        this.dataAditional4 = value;
    }

}
