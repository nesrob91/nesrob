
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AvailableImagesDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AvailableImagesDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/track/v12}AvailableImageType" minOccurs="0"/>
 *         &lt;element name="Size" type="{http://fedex.com/ws/track/v12}ImageSizeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableImagesDetail", propOrder = {
    "type",
    "size"
})
public class AvailableImagesDetail {

    @XmlElement(name = "Type")
    protected AvailableImageType type;
    @XmlElement(name = "Size")
    protected ImageSizeType size;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link AvailableImageType }
     *     
     */
    public AvailableImageType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableImageType }
     *     
     */
    public void setType(AvailableImageType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad size.
     * 
     * @return
     *     possible object is
     *     {@link ImageSizeType }
     *     
     */
    public ImageSizeType getSize() {
        return size;
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageSizeType }
     *     
     */
    public void setSize(ImageSizeType value) {
        this.size = value;
    }

}
