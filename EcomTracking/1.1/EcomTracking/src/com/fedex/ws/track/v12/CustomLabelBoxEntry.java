
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Solid (filled) rectangular area on label.
 * 
 * <p>Clase Java para CustomLabelBoxEntry complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomLabelBoxEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TopLeftCorner" type="{http://fedex.com/ws/ship/v19}CustomLabelPosition"/>
 *         &lt;element name="BottomRightCorner" type="{http://fedex.com/ws/ship/v19}CustomLabelPosition"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomLabelBoxEntry", propOrder = {
    "topLeftCorner",
    "bottomRightCorner"
})
public class CustomLabelBoxEntry {

    @XmlElement(name = "TopLeftCorner", required = true)
    protected CustomLabelPosition topLeftCorner;
    @XmlElement(name = "BottomRightCorner", required = true)
    protected CustomLabelPosition bottomRightCorner;

    /**
     * Obtiene el valor de la propiedad topLeftCorner.
     * 
     * @return
     *     possible object is
     *     {@link CustomLabelPosition }
     *     
     */
    public CustomLabelPosition getTopLeftCorner() {
        return topLeftCorner;
    }

    /**
     * Define el valor de la propiedad topLeftCorner.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomLabelPosition }
     *     
     */
    public void setTopLeftCorner(CustomLabelPosition value) {
        this.topLeftCorner = value;
    }

    /**
     * Obtiene el valor de la propiedad bottomRightCorner.
     * 
     * @return
     *     possible object is
     *     {@link CustomLabelPosition }
     *     
     */
    public CustomLabelPosition getBottomRightCorner() {
        return bottomRightCorner;
    }

    /**
     * Define el valor de la propiedad bottomRightCorner.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomLabelPosition }
     *     
     */
    public void setBottomRightCorner(CustomLabelPosition value) {
        this.bottomRightCorner = value;
    }

}
