
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RadioactivityDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RadioactivityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransportIndex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SurfaceReading" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CriticalitySafetyIndex" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Dimensions" type="{http://fedex.com/ws/ship/v19}Dimensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RadioactivityDetail", propOrder = {
    "transportIndex",
    "surfaceReading",
    "criticalitySafetyIndex",
    "dimensions"
})
public class RadioactivityDetail {

    @XmlElement(name = "TransportIndex")
    protected BigDecimal transportIndex;
    @XmlElement(name = "SurfaceReading")
    protected BigDecimal surfaceReading;
    @XmlElement(name = "CriticalitySafetyIndex")
    protected BigDecimal criticalitySafetyIndex;
    @XmlElement(name = "Dimensions")
    protected Dimensions dimensions;

    /**
     * Obtiene el valor de la propiedad transportIndex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransportIndex() {
        return transportIndex;
    }

    /**
     * Define el valor de la propiedad transportIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransportIndex(BigDecimal value) {
        this.transportIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad surfaceReading.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSurfaceReading() {
        return surfaceReading;
    }

    /**
     * Define el valor de la propiedad surfaceReading.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSurfaceReading(BigDecimal value) {
        this.surfaceReading = value;
    }

    /**
     * Obtiene el valor de la propiedad criticalitySafetyIndex.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCriticalitySafetyIndex() {
        return criticalitySafetyIndex;
    }

    /**
     * Define el valor de la propiedad criticalitySafetyIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCriticalitySafetyIndex(BigDecimal value) {
        this.criticalitySafetyIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad dimensions.
     * 
     * @return
     *     possible object is
     *     {@link Dimensions }
     *     
     */
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * Define el valor de la propiedad dimensions.
     * 
     * @param value
     *     allowed object is
     *     {@link Dimensions }
     *     
     */
    public void setDimensions(Dimensions value) {
        this.dimensions = value;
    }

}
