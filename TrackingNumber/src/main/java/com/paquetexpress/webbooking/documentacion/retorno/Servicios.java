
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}OtrosServicios" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}Importe" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}ackType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}ackTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}ackTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}ackTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}ackTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}codAmount" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}codTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}codTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}codTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}codTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}dlvyType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}dlvyTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}dlvyTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}dlvyTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}dlvyTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}totldeclVlue" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}invType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}invTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}invTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}invTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}invTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}radType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}radTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}radTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}radTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}radTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpEType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpETypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpETypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpETypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpETypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpType" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpTypeAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpTypeAmtDisc" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpTypeAmtTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}shpTypeAmtRetTax" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/retorno}formaPago" minOccurs="0"/>
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
    "otrosServicios",
    "importe",
    "ackType",
    "ackTypeAmt",
    "ackTypeAmtDisc",
    "ackTypeAmtTax",
    "ackTypeAmtRetTax",
    "codAmount",
    "codTypeAmt",
    "codTypeAmtDisc",
    "codTypeAmtTax",
    "codTypeAmtRetTax",
    "dlvyType",
    "dlvyTypeAmt",
    "dlvyTypeAmtDisc",
    "dlvyTypeAmtTax",
    "dlvyTypeAmtRetTax",
    "totldeclVlue",
    "invType",
    "invTypeAmt",
    "invTypeAmtDisc",
    "invTypeAmtTax",
    "invTypeAmtRetTax",
    "radType",
    "radTypeAmt",
    "radTypeAmtDisc",
    "radTypeAmtTax",
    "radTypeAmtRetTax",
    "shpEType",
    "shpETypeAmt",
    "shpETypeAmtDisc",
    "shpETypeAmtTax",
    "shpETypeAmtRetTax",
    "shpType",
    "shpTypeAmt",
    "shpTypeAmtDisc",
    "shpTypeAmtTax",
    "shpTypeAmtRetTax",
    "formaPago"
})
@XmlRootElement(name = "Servicios")
public class Servicios {

    @XmlElement(name = "OtrosServicios")
    protected OtrosServicios otrosServicios;
    @XmlElement(name = "Importe")
    protected Importe importe;
    protected String ackType;
    protected Double ackTypeAmt;
    protected Double ackTypeAmtDisc;
    protected Double ackTypeAmtTax;
    protected Double ackTypeAmtRetTax;
    protected Double codAmount;
    protected Double codTypeAmt;
    protected Double codTypeAmtDisc;
    protected Double codTypeAmtTax;
    protected Double codTypeAmtRetTax;
    protected String dlvyType;
    protected Double dlvyTypeAmt;
    protected Double dlvyTypeAmtDisc;
    protected Double dlvyTypeAmtTax;
    protected Double dlvyTypeAmtRetTax;
    protected Double totldeclVlue;
    protected String invType;
    protected Double invTypeAmt;
    protected Double invTypeAmtDisc;
    protected Double invTypeAmtTax;
    protected Double invTypeAmtRetTax;
    protected String radType;
    protected Double radTypeAmt;
    protected Double radTypeAmtDisc;
    protected Double radTypeAmtTax;
    protected Double radTypeAmtRetTax;
    protected String shpEType;
    protected Double shpETypeAmt;
    protected Double shpETypeAmtDisc;
    protected Double shpETypeAmtTax;
    protected Double shpETypeAmtRetTax;
    protected String shpType;
    protected Double shpTypeAmt;
    protected Double shpTypeAmtDisc;
    protected Double shpTypeAmtTax;
    protected Double shpTypeAmtRetTax;
    protected String formaPago;

    /**
     * Obtiene el valor de la propiedad otrosServicios.
     * 
     * @return
     *     possible object is
     *     {@link OtrosServicios }
     *     
     */
    public OtrosServicios getOtrosServicios() {
        return otrosServicios;
    }

    /**
     * Define el valor de la propiedad otrosServicios.
     * 
     * @param value
     *     allowed object is
     *     {@link OtrosServicios }
     *     
     */
    public void setOtrosServicios(OtrosServicios value) {
        this.otrosServicios = value;
    }

    /**
     * Obtiene el valor de la propiedad importe.
     * 
     * @return
     *     possible object is
     *     {@link Importe }
     *     
     */
    public Importe getImporte() {
        return importe;
    }

    /**
     * Define el valor de la propiedad importe.
     * 
     * @param value
     *     allowed object is
     *     {@link Importe }
     *     
     */
    public void setImporte(Importe value) {
        this.importe = value;
    }

    /**
     * Obtiene el valor de la propiedad ackType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAckType() {
        return ackType;
    }

    /**
     * Define el valor de la propiedad ackType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAckType(String value) {
        this.ackType = value;
    }

    /**
     * Obtiene el valor de la propiedad ackTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAckTypeAmt() {
        return ackTypeAmt;
    }

    /**
     * Define el valor de la propiedad ackTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAckTypeAmt(Double value) {
        this.ackTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad ackTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAckTypeAmtDisc() {
        return ackTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad ackTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAckTypeAmtDisc(Double value) {
        this.ackTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad ackTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAckTypeAmtTax() {
        return ackTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad ackTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAckTypeAmtTax(Double value) {
        this.ackTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad ackTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAckTypeAmtRetTax() {
        return ackTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad ackTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAckTypeAmtRetTax(Double value) {
        this.ackTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad codAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodAmount() {
        return codAmount;
    }

    /**
     * Define el valor de la propiedad codAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodAmount(Double value) {
        this.codAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad codTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodTypeAmt() {
        return codTypeAmt;
    }

    /**
     * Define el valor de la propiedad codTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodTypeAmt(Double value) {
        this.codTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad codTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodTypeAmtDisc() {
        return codTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad codTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodTypeAmtDisc(Double value) {
        this.codTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad codTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodTypeAmtTax() {
        return codTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad codTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodTypeAmtTax(Double value) {
        this.codTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad codTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCodTypeAmtRetTax() {
        return codTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad codTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCodTypeAmtRetTax(Double value) {
        this.codTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvyType() {
        return dlvyType;
    }

    /**
     * Define el valor de la propiedad dlvyType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvyType(String value) {
        this.dlvyType = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDlvyTypeAmt() {
        return dlvyTypeAmt;
    }

    /**
     * Define el valor de la propiedad dlvyTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDlvyTypeAmt(Double value) {
        this.dlvyTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDlvyTypeAmtDisc() {
        return dlvyTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad dlvyTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDlvyTypeAmtDisc(Double value) {
        this.dlvyTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDlvyTypeAmtTax() {
        return dlvyTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad dlvyTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDlvyTypeAmtTax(Double value) {
        this.dlvyTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad dlvyTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDlvyTypeAmtRetTax() {
        return dlvyTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad dlvyTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDlvyTypeAmtRetTax(Double value) {
        this.dlvyTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad totldeclVlue.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotldeclVlue() {
        return totldeclVlue;
    }

    /**
     * Define el valor de la propiedad totldeclVlue.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotldeclVlue(Double value) {
        this.totldeclVlue = value;
    }

    /**
     * Obtiene el valor de la propiedad invType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvType() {
        return invType;
    }

    /**
     * Define el valor de la propiedad invType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvType(String value) {
        this.invType = value;
    }

    /**
     * Obtiene el valor de la propiedad invTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvTypeAmt() {
        return invTypeAmt;
    }

    /**
     * Define el valor de la propiedad invTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvTypeAmt(Double value) {
        this.invTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad invTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvTypeAmtDisc() {
        return invTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad invTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvTypeAmtDisc(Double value) {
        this.invTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad invTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvTypeAmtTax() {
        return invTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad invTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvTypeAmtTax(Double value) {
        this.invTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad invTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvTypeAmtRetTax() {
        return invTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad invTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvTypeAmtRetTax(Double value) {
        this.invTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad radType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRadType() {
        return radType;
    }

    /**
     * Define el valor de la propiedad radType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRadType(String value) {
        this.radType = value;
    }

    /**
     * Obtiene el valor de la propiedad radTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRadTypeAmt() {
        return radTypeAmt;
    }

    /**
     * Define el valor de la propiedad radTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRadTypeAmt(Double value) {
        this.radTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad radTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRadTypeAmtDisc() {
        return radTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad radTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRadTypeAmtDisc(Double value) {
        this.radTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad radTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRadTypeAmtTax() {
        return radTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad radTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRadTypeAmtTax(Double value) {
        this.radTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad radTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRadTypeAmtRetTax() {
        return radTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad radTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRadTypeAmtRetTax(Double value) {
        this.radTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad shpEType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShpEType() {
        return shpEType;
    }

    /**
     * Define el valor de la propiedad shpEType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShpEType(String value) {
        this.shpEType = value;
    }

    /**
     * Obtiene el valor de la propiedad shpETypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpETypeAmt() {
        return shpETypeAmt;
    }

    /**
     * Define el valor de la propiedad shpETypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpETypeAmt(Double value) {
        this.shpETypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad shpETypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpETypeAmtDisc() {
        return shpETypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad shpETypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpETypeAmtDisc(Double value) {
        this.shpETypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad shpETypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpETypeAmtTax() {
        return shpETypeAmtTax;
    }

    /**
     * Define el valor de la propiedad shpETypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpETypeAmtTax(Double value) {
        this.shpETypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad shpETypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpETypeAmtRetTax() {
        return shpETypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad shpETypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpETypeAmtRetTax(Double value) {
        this.shpETypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad shpType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShpType() {
        return shpType;
    }

    /**
     * Define el valor de la propiedad shpType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShpType(String value) {
        this.shpType = value;
    }

    /**
     * Obtiene el valor de la propiedad shpTypeAmt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpTypeAmt() {
        return shpTypeAmt;
    }

    /**
     * Define el valor de la propiedad shpTypeAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpTypeAmt(Double value) {
        this.shpTypeAmt = value;
    }

    /**
     * Obtiene el valor de la propiedad shpTypeAmtDisc.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpTypeAmtDisc() {
        return shpTypeAmtDisc;
    }

    /**
     * Define el valor de la propiedad shpTypeAmtDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpTypeAmtDisc(Double value) {
        this.shpTypeAmtDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad shpTypeAmtTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpTypeAmtTax() {
        return shpTypeAmtTax;
    }

    /**
     * Define el valor de la propiedad shpTypeAmtTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpTypeAmtTax(Double value) {
        this.shpTypeAmtTax = value;
    }

    /**
     * Obtiene el valor de la propiedad shpTypeAmtRetTax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShpTypeAmtRetTax() {
        return shpTypeAmtRetTax;
    }

    /**
     * Define el valor de la propiedad shpTypeAmtRetTax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShpTypeAmtRetTax(Double value) {
        this.shpTypeAmtRetTax = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Define el valor de la propiedad formaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

}
