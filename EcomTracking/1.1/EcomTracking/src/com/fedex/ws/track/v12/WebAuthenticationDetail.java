
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Used in authentication of the sender's identity.
 * 
 * <p>Clase Java para WebAuthenticationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WebAuthenticationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParentCredential" type="{http://fedex.com/ws/track/v12}WebAuthenticationCredential" minOccurs="0"/>
 *         &lt;element name="UserCredential" type="{http://fedex.com/ws/track/v12}WebAuthenticationCredential"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebAuthenticationDetail", propOrder = {
    "parentCredential",
    "userCredential"
})
public class WebAuthenticationDetail {

    @XmlElement(name = "ParentCredential")
    protected WebAuthenticationCredential parentCredential;
    @XmlElement(name = "UserCredential", required = true)
    protected WebAuthenticationCredential userCredential;

    /**
     * Obtiene el valor de la propiedad parentCredential.
     * 
     * @return
     *     possible object is
     *     {@link WebAuthenticationCredential }
     *     
     */
    public WebAuthenticationCredential getParentCredential() {
        return parentCredential;
    }

    /**
     * Define el valor de la propiedad parentCredential.
     * 
     * @param value
     *     allowed object is
     *     {@link WebAuthenticationCredential }
     *     
     */
    public void setParentCredential(WebAuthenticationCredential value) {
        this.parentCredential = value;
    }

    /**
     * Obtiene el valor de la propiedad userCredential.
     * 
     * @return
     *     possible object is
     *     {@link WebAuthenticationCredential }
     *     
     */
    public WebAuthenticationCredential getUserCredential() {
        return userCredential;
    }

    /**
     * Define el valor de la propiedad userCredential.
     * 
     * @param value
     *     allowed object is
     *     {@link WebAuthenticationCredential }
     *     
     */
    public void setUserCredential(WebAuthenticationCredential value) {
        this.userCredential = value;
    }

}
