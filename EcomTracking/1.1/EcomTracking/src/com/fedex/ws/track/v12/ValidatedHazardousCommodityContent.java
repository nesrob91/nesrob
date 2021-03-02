
package com.fedex.ws.track.v12;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Documents the kind and quantity of an individual hazardous commodity in a package.
 * 
 * <p>Clase Java para ValidatedHazardousCommodityContent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ValidatedHazardousCommodityContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://fedex.com/ws/ship/v19}ValidatedHazardousCommodityDescription" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://fedex.com/ws/ship/v19}HazardousCommodityQuantityDetail" minOccurs="0"/>
 *         &lt;element name="MassPoints" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Options" type="{http://fedex.com/ws/ship/v19}HazardousCommodityOptionDetail" minOccurs="0"/>
 *         &lt;element name="NetExplosiveDetail" type="{http://fedex.com/ws/ship/v19}NetExplosiveDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidatedHazardousCommodityContent", propOrder = {
    "description",
    "quantity",
    "massPoints",
    "options",
    "netExplosiveDetail"
})
public class ValidatedHazardousCommodityContent {

    @XmlElement(name = "Description")
    protected ValidatedHazardousCommodityDescription description;
    @XmlElement(name = "Quantity")
    protected HazardousCommodityQuantityDetail quantity;
    @XmlElement(name = "MassPoints")
    protected BigDecimal massPoints;
    @XmlElement(name = "Options")
    protected HazardousCommodityOptionDetail options;
    @XmlElement(name = "NetExplosiveDetail")
    protected NetExplosiveDetail netExplosiveDetail;

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link ValidatedHazardousCommodityDescription }
     *     
     */
    public ValidatedHazardousCommodityDescription getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidatedHazardousCommodityDescription }
     *     
     */
    public void setDescription(ValidatedHazardousCommodityDescription value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityQuantityDetail }
     *     
     */
    public HazardousCommodityQuantityDetail getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityQuantityDetail }
     *     
     */
    public void setQuantity(HazardousCommodityQuantityDetail value) {
        this.quantity = value;
    }

    /**
     * Obtiene el valor de la propiedad massPoints.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMassPoints() {
        return massPoints;
    }

    /**
     * Define el valor de la propiedad massPoints.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMassPoints(BigDecimal value) {
        this.massPoints = value;
    }

    /**
     * Obtiene el valor de la propiedad options.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityOptionDetail }
     *     
     */
    public HazardousCommodityOptionDetail getOptions() {
        return options;
    }

    /**
     * Define el valor de la propiedad options.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityOptionDetail }
     *     
     */
    public void setOptions(HazardousCommodityOptionDetail value) {
        this.options = value;
    }

    /**
     * Obtiene el valor de la propiedad netExplosiveDetail.
     * 
     * @return
     *     possible object is
     *     {@link NetExplosiveDetail }
     *     
     */
    public NetExplosiveDetail getNetExplosiveDetail() {
        return netExplosiveDetail;
    }

    /**
     * Define el valor de la propiedad netExplosiveDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link NetExplosiveDetail }
     *     
     */
    public void setNetExplosiveDetail(NetExplosiveDetail value) {
        this.netExplosiveDetail = value;
    }

}
