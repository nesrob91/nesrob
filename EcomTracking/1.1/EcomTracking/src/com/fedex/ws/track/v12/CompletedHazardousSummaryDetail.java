
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CompletedHazardousSummaryDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompletedHazardousSummaryDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SmallQuantityExceptionPackageCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedHazardousSummaryDetail", propOrder = {
    "smallQuantityExceptionPackageCount"
})
public class CompletedHazardousSummaryDetail {

    @XmlElement(name = "SmallQuantityExceptionPackageCount")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger smallQuantityExceptionPackageCount;

    /**
     * Obtiene el valor de la propiedad smallQuantityExceptionPackageCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSmallQuantityExceptionPackageCount() {
        return smallQuantityExceptionPackageCount;
    }

    /**
     * Define el valor de la propiedad smallQuantityExceptionPackageCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSmallQuantityExceptionPackageCount(BigInteger value) {
        this.smallQuantityExceptionPackageCount = value;
    }

}
