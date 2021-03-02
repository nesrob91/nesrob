
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Image to be included from printer's memory, or from a local file for offline clients.
 * 
 * <p>Clase Java para CustomLabelGraphicEntry complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomLabelGraphicEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Position" type="{http://fedex.com/ws/ship/v19}CustomLabelPosition" minOccurs="0"/>
 *         &lt;element name="PrinterGraphicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileGraphicFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomLabelGraphicEntry", propOrder = {
    "position",
    "printerGraphicId",
    "fileGraphicFullName"
})
public class CustomLabelGraphicEntry {

    @XmlElement(name = "Position")
    protected CustomLabelPosition position;
    @XmlElement(name = "PrinterGraphicId")
    protected String printerGraphicId;
    @XmlElement(name = "FileGraphicFullName")
    protected String fileGraphicFullName;

    /**
     * Obtiene el valor de la propiedad position.
     * 
     * @return
     *     possible object is
     *     {@link CustomLabelPosition }
     *     
     */
    public CustomLabelPosition getPosition() {
        return position;
    }

    /**
     * Define el valor de la propiedad position.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomLabelPosition }
     *     
     */
    public void setPosition(CustomLabelPosition value) {
        this.position = value;
    }

    /**
     * Obtiene el valor de la propiedad printerGraphicId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinterGraphicId() {
        return printerGraphicId;
    }

    /**
     * Define el valor de la propiedad printerGraphicId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinterGraphicId(String value) {
        this.printerGraphicId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileGraphicFullName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileGraphicFullName() {
        return fileGraphicFullName;
    }

    /**
     * Define el valor de la propiedad fileGraphicFullName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileGraphicFullName(String value) {
        this.fileGraphicFullName = value;
    }

}
