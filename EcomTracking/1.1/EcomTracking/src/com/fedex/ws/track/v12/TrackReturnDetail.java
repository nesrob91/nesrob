
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackReturnDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackReturnDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MovementStatus" type="{http://fedex.com/ws/track/v12}TrackReturnMovementStatusType" minOccurs="0"/>
 *         &lt;element name="LabelType" type="{http://fedex.com/ws/track/v12}TrackReturnLabelType" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackReturnDetail", propOrder = {
    "movementStatus",
    "labelType",
    "description",
    "authorizationName"
})
public class TrackReturnDetail {

    @XmlElement(name = "MovementStatus")
    protected TrackReturnMovementStatusType movementStatus;
    @XmlElement(name = "LabelType")
    protected TrackReturnLabelType labelType;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "AuthorizationName")
    protected String authorizationName;

    /**
     * Obtiene el valor de la propiedad movementStatus.
     * 
     * @return
     *     possible object is
     *     {@link TrackReturnMovementStatusType }
     *     
     */
    public TrackReturnMovementStatusType getMovementStatus() {
        return movementStatus;
    }

    /**
     * Define el valor de la propiedad movementStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackReturnMovementStatusType }
     *     
     */
    public void setMovementStatus(TrackReturnMovementStatusType value) {
        this.movementStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad labelType.
     * 
     * @return
     *     possible object is
     *     {@link TrackReturnLabelType }
     *     
     */
    public TrackReturnLabelType getLabelType() {
        return labelType;
    }

    /**
     * Define el valor de la propiedad labelType.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackReturnLabelType }
     *     
     */
    public void setLabelType(TrackReturnLabelType value) {
        this.labelType = value;
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

    /**
     * Obtiene el valor de la propiedad authorizationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationName() {
        return authorizationName;
    }

    /**
     * Define el valor de la propiedad authorizationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationName(String value) {
        this.authorizationName = value;
    }

}
