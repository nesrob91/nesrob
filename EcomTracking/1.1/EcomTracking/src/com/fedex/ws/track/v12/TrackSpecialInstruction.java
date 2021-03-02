
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TrackSpecialInstruction complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackSpecialInstruction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryOption" type="{http://fedex.com/ws/track/v12}TrackDeliveryOptionType" minOccurs="0"/>
 *         &lt;element name="StatusDetail" type="{http://fedex.com/ws/track/v12}SpecialInstructionStatusDetail" minOccurs="0"/>
 *         &lt;element name="OriginalEstimatedDeliveryTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OriginalRequestTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RequestedAppointmentTime" type="{http://fedex.com/ws/track/v12}AppointmentDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackSpecialInstruction", propOrder = {
    "description",
    "deliveryOption",
    "statusDetail",
    "originalEstimatedDeliveryTimestamp",
    "originalRequestTime",
    "requestedAppointmentTime"
})
public class TrackSpecialInstruction {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "DeliveryOption")
    protected TrackDeliveryOptionType deliveryOption;
    @XmlElement(name = "StatusDetail")
    protected SpecialInstructionStatusDetail statusDetail;
    @XmlElement(name = "OriginalEstimatedDeliveryTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalEstimatedDeliveryTimestamp;
    @XmlElement(name = "OriginalRequestTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalRequestTime;
    @XmlElement(name = "RequestedAppointmentTime")
    protected AppointmentDetail requestedAppointmentTime;

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
     * Obtiene el valor de la propiedad deliveryOption.
     * 
     * @return
     *     possible object is
     *     {@link TrackDeliveryOptionType }
     *     
     */
    public TrackDeliveryOptionType getDeliveryOption() {
        return deliveryOption;
    }

    /**
     * Define el valor de la propiedad deliveryOption.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackDeliveryOptionType }
     *     
     */
    public void setDeliveryOption(TrackDeliveryOptionType value) {
        this.deliveryOption = value;
    }

    /**
     * Obtiene el valor de la propiedad statusDetail.
     * 
     * @return
     *     possible object is
     *     {@link SpecialInstructionStatusDetail }
     *     
     */
    public SpecialInstructionStatusDetail getStatusDetail() {
        return statusDetail;
    }

    /**
     * Define el valor de la propiedad statusDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialInstructionStatusDetail }
     *     
     */
    public void setStatusDetail(SpecialInstructionStatusDetail value) {
        this.statusDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad originalEstimatedDeliveryTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalEstimatedDeliveryTimestamp() {
        return originalEstimatedDeliveryTimestamp;
    }

    /**
     * Define el valor de la propiedad originalEstimatedDeliveryTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalEstimatedDeliveryTimestamp(XMLGregorianCalendar value) {
        this.originalEstimatedDeliveryTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad originalRequestTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalRequestTime() {
        return originalRequestTime;
    }

    /**
     * Define el valor de la propiedad originalRequestTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalRequestTime(XMLGregorianCalendar value) {
        this.originalRequestTime = value;
    }

    /**
     * Obtiene el valor de la propiedad requestedAppointmentTime.
     * 
     * @return
     *     possible object is
     *     {@link AppointmentDetail }
     *     
     */
    public AppointmentDetail getRequestedAppointmentTime() {
        return requestedAppointmentTime;
    }

    /**
     * Define el valor de la propiedad requestedAppointmentTime.
     * 
     * @param value
     *     allowed object is
     *     {@link AppointmentDetail }
     *     
     */
    public void setRequestedAppointmentTime(AppointmentDetail value) {
        this.requestedAppointmentTime = value;
    }

}
