
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Constructed string, based on format and zero or more data fields, printed in specified barcode symbology.
 * 
 * <p>Clase Java para CustomLabelBarcodeEntry complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomLabelBarcodeEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Position" type="{http://fedex.com/ws/ship/v19}CustomLabelPosition"/>
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataFields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BarHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ThinBarWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BarcodeSymbology" type="{http://fedex.com/ws/ship/v19}BarcodeSymbologyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomLabelBarcodeEntry", propOrder = {
    "position",
    "format",
    "dataFields",
    "barHeight",
    "thinBarWidth",
    "barcodeSymbology"
})
public class CustomLabelBarcodeEntry {

    @XmlElement(name = "Position", required = true)
    protected CustomLabelPosition position;
    @XmlElement(name = "Format")
    protected String format;
    @XmlElement(name = "DataFields")
    protected List<String> dataFields;
    @XmlElement(name = "BarHeight")
    protected Integer barHeight;
    @XmlElement(name = "ThinBarWidth")
    protected Integer thinBarWidth;
    @XmlElement(name = "BarcodeSymbology", required = true)
    protected BarcodeSymbologyType barcodeSymbology;

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
     * Obtiene el valor de la propiedad format.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Define el valor de la propiedad format.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the dataFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDataFields() {
        if (dataFields == null) {
            dataFields = new ArrayList<String>();
        }
        return this.dataFields;
    }

    /**
     * Obtiene el valor de la propiedad barHeight.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarHeight() {
        return barHeight;
    }

    /**
     * Define el valor de la propiedad barHeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarHeight(Integer value) {
        this.barHeight = value;
    }

    /**
     * Obtiene el valor de la propiedad thinBarWidth.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getThinBarWidth() {
        return thinBarWidth;
    }

    /**
     * Define el valor de la propiedad thinBarWidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setThinBarWidth(Integer value) {
        this.thinBarWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad barcodeSymbology.
     * 
     * @return
     *     possible object is
     *     {@link BarcodeSymbologyType }
     *     
     */
    public BarcodeSymbologyType getBarcodeSymbology() {
        return barcodeSymbology;
    }

    /**
     * Define el valor de la propiedad barcodeSymbology.
     * 
     * @param value
     *     allowed object is
     *     {@link BarcodeSymbologyType }
     *     
     */
    public void setBarcodeSymbology(BarcodeSymbologyType value) {
        this.barcodeSymbology = value;
    }

}
