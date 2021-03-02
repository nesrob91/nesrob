
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies the version/level of a service operation expected by a caller (in each request) and performed by the callee (in each reply).
 * 
 * <p>Clase Java para VersionId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VersionId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Major" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Intermediate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Minor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionId", propOrder = {
    "serviceId",
    "major",
    "intermediate",
    "minor"
})
public class VersionId {

    @XmlElement(name = "ServiceId", required = true)
    protected String serviceId;
    @XmlElement(name = "Major")
    protected int major;
    @XmlElement(name = "Intermediate")
    protected int intermediate;
    @XmlElement(name = "Minor")
    protected int minor;

    /**
     * Obtiene el valor de la propiedad serviceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Define el valor de la propiedad serviceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceId(String value) {
        this.serviceId = value;
    }

    /**
     * Obtiene el valor de la propiedad major.
     * 
     */
    public int getMajor() {
        return major;
    }

    /**
     * Define el valor de la propiedad major.
     * 
     */
    public void setMajor(int value) {
        this.major = value;
    }

    /**
     * Obtiene el valor de la propiedad intermediate.
     * 
     */
    public int getIntermediate() {
        return intermediate;
    }

    /**
     * Define el valor de la propiedad intermediate.
     * 
     */
    public void setIntermediate(int value) {
        this.intermediate = value;
    }

    /**
     * Obtiene el valor de la propiedad minor.
     * 
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Define el valor de la propiedad minor.
     * 
     */
    public void setMinor(int value) {
        this.minor = value;
    }

}
