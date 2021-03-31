
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}quantity"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpCode"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}content"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}SlabNo" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}weight" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}volume" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}longShip" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}widthShip" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}highShip" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}slabAmount" minOccurs="0"/>
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
    "quantity",
    "shpCode",
    "content",
    "slabNo",
    "weight",
    "volume",
    "longShip",
    "widthShip",
    "highShip",
    "slabAmount"
})
@XmlRootElement(name = "Embarque")
public class Embarque {

    protected int quantity;
    @XmlElement(required = true)
    protected String shpCode;
    @XmlElement(required = true)
    protected String content;
    @XmlElement(name = "SlabNo")
    protected String slabNo;
    protected Double weight;
    protected Double volume;
    protected Double longShip;
    protected Double widthShip;
    protected Double highShip;
    protected Double slabAmount;

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Obtiene el valor de la propiedad shpCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShpCode() {
        return shpCode;
    }

    /**
     * Define el valor de la propiedad shpCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShpCode(String value) {
        this.shpCode = value;
    }

    /**
     * Obtiene el valor de la propiedad content.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Define el valor de la propiedad content.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Obtiene el valor de la propiedad slabNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlabNo() {
        return slabNo;
    }

    /**
     * Define el valor de la propiedad slabNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlabNo(String value) {
        this.slabNo = value;
    }

    /**
     * Obtiene el valor de la propiedad weight.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

    /**
     * Obtiene el valor de la propiedad volume.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Define el valor de la propiedad volume.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVolume(Double value) {
        this.volume = value;
    }

    /**
     * Obtiene el valor de la propiedad longShip.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongShip() {
        return longShip;
    }

    /**
     * Define el valor de la propiedad longShip.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongShip(Double value) {
        this.longShip = value;
    }

    /**
     * Obtiene el valor de la propiedad widthShip.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWidthShip() {
        return widthShip;
    }

    /**
     * Define el valor de la propiedad widthShip.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWidthShip(Double value) {
        this.widthShip = value;
    }

    /**
     * Obtiene el valor de la propiedad highShip.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHighShip() {
        return highShip;
    }

    /**
     * Define el valor de la propiedad highShip.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHighShip(Double value) {
        this.highShip = value;
    }

    /**
     * Obtiene el valor de la propiedad slabAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSlabAmount() {
        return slabAmount;
    }

    /**
     * Define el valor de la propiedad slabAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSlabAmount(Double value) {
        this.slabAmount = value;
    }

}
