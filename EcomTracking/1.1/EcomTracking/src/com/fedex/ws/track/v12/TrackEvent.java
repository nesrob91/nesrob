
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * FedEx scanning information about a package.
 * 
 * <p>Clase Java para TrackEvent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EventType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusExceptionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusExceptionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="StationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArrivalLocation" type="{http://fedex.com/ws/track/v12}ArrivalLocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackEvent", propOrder = {
    "timestamp",
    "eventType",
    "eventDescription",
    "statusExceptionCode",
    "statusExceptionDescription",
    "address",
    "stationId",
    "arrivalLocation"
})
public class TrackEvent {

    @XmlElement(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(name = "EventType")
    protected String eventType;
    @XmlElement(name = "EventDescription")
    protected String eventDescription;
    @XmlElement(name = "StatusExceptionCode")
    protected String statusExceptionCode;
    @XmlElement(name = "StatusExceptionDescription")
    protected String statusExceptionDescription;
    @XmlElement(name = "Address")
    protected Address address;
    @XmlElement(name = "StationId")
    protected String stationId;
    @XmlElement(name = "ArrivalLocation")
    protected ArrivalLocationType arrivalLocation;

    /**
     * Obtiene el valor de la propiedad timestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Define el valor de la propiedad timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad eventType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Define el valor de la propiedad eventType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Obtiene el valor de la propiedad eventDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Define el valor de la propiedad eventDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDescription(String value) {
        this.eventDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad statusExceptionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusExceptionCode() {
        return statusExceptionCode;
    }

    /**
     * Define el valor de la propiedad statusExceptionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusExceptionCode(String value) {
        this.statusExceptionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad statusExceptionDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusExceptionDescription() {
        return statusExceptionDescription;
    }

    /**
     * Define el valor de la propiedad statusExceptionDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusExceptionDescription(String value) {
        this.statusExceptionDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad address.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Obtiene el valor de la propiedad stationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * Define el valor de la propiedad stationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationId(String value) {
        this.stationId = value;
    }

    /**
     * Obtiene el valor de la propiedad arrivalLocation.
     * 
     * @return
     *     possible object is
     *     {@link ArrivalLocationType }
     *     
     */
    public ArrivalLocationType getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * Define el valor de la propiedad arrivalLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrivalLocationType }
     *     
     */
    public void setArrivalLocation(ArrivalLocationType value) {
        this.arrivalLocation = value;
    }

}
