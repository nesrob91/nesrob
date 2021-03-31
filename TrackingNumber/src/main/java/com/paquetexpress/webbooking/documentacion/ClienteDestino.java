
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}DomicilioDestino"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}destClntId" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}destCustClntId"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}destClntName"/>
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
    "domicilioDestino",
    "destClntId",
    "destCustClntId",
    "destClntName"
})
@XmlRootElement(name = "ClienteDestino")
public class ClienteDestino {

    @XmlElement(name = "DomicilioDestino", required = true)
    protected DomicilioDestino domicilioDestino;
    @XmlElement(nillable = true)
    protected String destClntId;
    @XmlElement(required = true)
    protected String destCustClntId;
    @XmlElement(required = true)
    protected String destClntName;

    /**
     * Obtiene el valor de la propiedad domicilioDestino.
     * 
     * @return
     *     possible object is
     *     {@link DomicilioDestino }
     *     
     */
    public DomicilioDestino getDomicilioDestino() {
        return domicilioDestino;
    }

    /**
     * Define el valor de la propiedad domicilioDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link DomicilioDestino }
     *     
     */
    public void setDomicilioDestino(DomicilioDestino value) {
        this.domicilioDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad destClntId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestClntId() {
        return destClntId;
    }

    /**
     * Define el valor de la propiedad destClntId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestClntId(String value) {
        this.destClntId = value;
    }

    /**
     * Obtiene el valor de la propiedad destCustClntId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestCustClntId() {
        return destCustClntId;
    }

    /**
     * Define el valor de la propiedad destCustClntId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestCustClntId(String value) {
        this.destCustClntId = value;
    }

    /**
     * Obtiene el valor de la propiedad destClntName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestClntName() {
        return destClntName;
    }

    /**
     * Define el valor de la propiedad destClntName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestClntName(String value) {
        this.destClntName = value;
    }

}
