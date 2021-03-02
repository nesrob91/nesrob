
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PagingDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PagingDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PagingToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumberOfResultsPerPage" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagingDetail", propOrder = {
    "pagingToken",
    "numberOfResultsPerPage"
})
public class PagingDetail {

    @XmlElement(name = "PagingToken")
    protected String pagingToken;
    @XmlElement(name = "NumberOfResultsPerPage")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfResultsPerPage;

    /**
     * Obtiene el valor de la propiedad pagingToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagingToken() {
        return pagingToken;
    }

    /**
     * Define el valor de la propiedad pagingToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagingToken(String value) {
        this.pagingToken = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfResultsPerPage.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfResultsPerPage() {
        return numberOfResultsPerPage;
    }

    /**
     * Define el valor de la propiedad numberOfResultsPerPage.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfResultsPerPage(BigInteger value) {
        this.numberOfResultsPerPage = value;
    }

}
