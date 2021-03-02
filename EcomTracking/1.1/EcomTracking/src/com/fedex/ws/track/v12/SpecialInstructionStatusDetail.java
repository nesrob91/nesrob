
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SpecialInstructionStatusDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SpecialInstructionStatusDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://fedex.com/ws/track/v12}SpecialInstructionsStatusCode" minOccurs="0"/>
 *         &lt;element name="StatusCreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialInstructionStatusDetail", propOrder = {
    "status",
    "statusCreateTime"
})
public class SpecialInstructionStatusDetail {

    @XmlElement(name = "Status")
    protected SpecialInstructionsStatusCode status;
    @XmlElement(name = "StatusCreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusCreateTime;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link SpecialInstructionsStatusCode }
     *     
     */
    public SpecialInstructionsStatusCode getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialInstructionsStatusCode }
     *     
     */
    public void setStatus(SpecialInstructionsStatusCode value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad statusCreateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusCreateTime() {
        return statusCreateTime;
    }

    /**
     * Define el valor de la propiedad statusCreateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusCreateTime(XMLGregorianCalendar value) {
        this.statusCreateTime = value;
    }

}
