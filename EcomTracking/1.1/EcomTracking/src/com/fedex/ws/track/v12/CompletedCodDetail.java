
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the results of processing for the COD special service.
 * 
 * <p>Clase Java para CompletedCodDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedCodDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CollectionAmount" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="AdjustmentType" type="{http://fedex.com/ws/ship/v19}CodAdjustmentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedCodDetail", propOrder = {
    "collectionAmount",
    "adjustmentType"
})
public class CompletedCodDetail {

    @XmlElement(name = "CollectionAmount")
    protected Money collectionAmount;
    @XmlElement(name = "AdjustmentType")
    protected CodAdjustmentType adjustmentType;

    /**
     * Obtiene el valor de la propiedad collectionAmount.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCollectionAmount() {
        return collectionAmount;
    }

    /**
     * Define el valor de la propiedad collectionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCollectionAmount(Money value) {
        this.collectionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad adjustmentType.
     * 
     * @return
     *     possible object is
     *     {@link CodAdjustmentType }
     *     
     */
    public CodAdjustmentType getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * Define el valor de la propiedad adjustmentType.
     * 
     * @param value
     *     allowed object is
     *     {@link CodAdjustmentType }
     *     
     */
    public void setAdjustmentType(CodAdjustmentType value) {
        this.adjustmentType = value;
    }

}
