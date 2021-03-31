
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
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}clave"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}descripcion" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional1" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/webbooking/Documentacion/}dataAditional2" minOccurs="0"/>
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
    "dataAditional1",
    "dataAditional2"
})
@XmlRootElement(name = "OtroServicio")
public class OtroServicio {

    @XmlElement(required = true)
    protected String clave;
    protected String descripcion;
    protected String dataAditional1;
    protected String dataAditional2;

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

}
