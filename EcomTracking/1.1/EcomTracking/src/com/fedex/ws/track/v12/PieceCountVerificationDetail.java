
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PieceCountVerificationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PieceCountVerificationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountLocationType" type="{http://fedex.com/ws/track/v12}PieceCountLocationType" minOccurs="0"/>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PieceCountVerificationDetail", propOrder = {
    "countLocationType",
    "count",
    "description"
})
public class PieceCountVerificationDetail {

    @XmlElement(name = "CountLocationType")
    protected PieceCountLocationType countLocationType;
    @XmlElement(name = "Count")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger count;
    @XmlElement(name = "Description")
    protected String description;

    /**
     * Obtiene el valor de la propiedad countLocationType.
     * 
     * @return
     *     possible object is
     *     {@link PieceCountLocationType }
     *     
     */
    public PieceCountLocationType getCountLocationType() {
        return countLocationType;
    }

    /**
     * Define el valor de la propiedad countLocationType.
     * 
     * @param value
     *     allowed object is
     *     {@link PieceCountLocationType }
     *     
     */
    public void setCountLocationType(PieceCountLocationType value) {
        this.countLocationType = value;
    }

    /**
     * Obtiene el valor de la propiedad count.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCount() {
        return count;
    }

    /**
     * Define el valor de la propiedad count.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCount(BigInteger value) {
        this.count = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
