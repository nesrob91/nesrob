
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Payor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Payor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponsibleParty" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payor", propOrder = {
    "responsibleParty"
})
public class Payor {

    @XmlElement(name = "ResponsibleParty")
    protected Party responsibleParty;

    /**
     * Obtiene el valor de la propiedad responsibleParty.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * Define el valor de la propiedad responsibleParty.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setResponsibleParty(Party value) {
        this.responsibleParty = value;
    }

}
