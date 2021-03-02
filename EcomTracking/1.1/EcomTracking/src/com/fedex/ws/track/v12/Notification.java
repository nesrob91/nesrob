
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The descriptive data regarding the result of the submitted transaction.
 * 
 * <p>Clase Java para Notification complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Severity" type="{http://fedex.com/ws/track/v12}NotificationSeverityType"/>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalizedMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageParameters" type="{http://fedex.com/ws/track/v12}NotificationParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Notification", propOrder = {
    "severity",
    "source",
    "code",
    "message",
    "localizedMessage",
    "messageParameters"
})
public class Notification {

    @XmlElement(name = "Severity", required = true)
    protected NotificationSeverityType severity;
    @XmlElement(name = "Source", required = true)
    protected String source;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "LocalizedMessage")
    protected String localizedMessage;
    @XmlElement(name = "MessageParameters")
    protected List<NotificationParameter> messageParameters;

    /**
     * Obtiene el valor de la propiedad severity.
     * 
     * @return
     *     possible object is
     *     {@link NotificationSeverityType }
     *     
     */
    public NotificationSeverityType getSeverity() {
        return severity;
    }

    /**
     * Define el valor de la propiedad severity.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationSeverityType }
     *     
     */
    public void setSeverity(NotificationSeverityType value) {
        this.severity = value;
    }

    /**
     * Obtiene el valor de la propiedad source.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Define el valor de la propiedad source.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtiene el valor de la propiedad message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define el valor de la propiedad message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtiene el valor de la propiedad localizedMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalizedMessage() {
        return localizedMessage;
    }

    /**
     * Define el valor de la propiedad localizedMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalizedMessage(String value) {
        this.localizedMessage = value;
    }

    /**
     * Gets the value of the messageParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationParameter }
     * 
     * 
     */
    public List<NotificationParameter> getMessageParameters() {
        if (messageParameters == null) {
            messageParameters = new ArrayList<NotificationParameter>();
        }
        return this.messageParameters;
    }

}
