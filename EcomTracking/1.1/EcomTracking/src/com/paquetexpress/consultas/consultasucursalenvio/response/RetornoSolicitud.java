
package com.paquetexpress.consultas.consultasucursalenvio.response;

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
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response}sucursal" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response}direccion" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response}telefonos" minOccurs="0"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response}Mensajes"/>
 *         &lt;element ref="{http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response}DatosAdicionales" minOccurs="0"/>
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
    "sucursal",
    "direccion",
    "telefonos",
    "mensajes",
    "datosAdicionales"
})
@XmlRootElement(name = "RetornoSolicitud")
public class RetornoSolicitud {

    protected String sucursal;
    protected String direccion;
    protected String telefonos;
    @XmlElement(name = "Mensajes", required = true)
    protected Mensajes mensajes;
    @XmlElement(name = "DatosAdicionales")
    protected DatosAdicionales datosAdicionales;

    /**
     * Obtiene el valor de la propiedad sucursal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * Define el valor de la propiedad sucursal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSucursal(String value) {
        this.sucursal = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * Define el valor de la propiedad telefonos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonos(String value) {
        this.telefonos = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajes.
     * 
     * @return
     *     possible object is
     *     {@link Mensajes }
     *     
     */
    public Mensajes getMensajes() {
        return mensajes;
    }

    /**
     * Define el valor de la propiedad mensajes.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensajes }
     *     
     */
    public void setMensajes(Mensajes value) {
        this.mensajes = value;
    }

    /**
     * Obtiene el valor de la propiedad datosAdicionales.
     * 
     * @return
     *     possible object is
     *     {@link DatosAdicionales }
     *     
     */
    public DatosAdicionales getDatosAdicionales() {
        return datosAdicionales;
    }

    /**
     * Define el valor de la propiedad datosAdicionales.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosAdicionales }
     *     
     */
    public void setDatosAdicionales(DatosAdicionales value) {
        this.datosAdicionales = value;
    }

}
