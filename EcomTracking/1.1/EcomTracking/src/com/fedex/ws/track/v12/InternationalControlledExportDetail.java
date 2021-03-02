
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para InternationalControlledExportDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InternationalControlledExportDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}InternationalControlledExportType"/>
 *         &lt;element name="ForeignTradeZoneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntryNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenseOrPermitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenseOrPermitExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalControlledExportDetail", propOrder = {
    "type",
    "foreignTradeZoneCode",
    "entryNumber",
    "licenseOrPermitNumber",
    "licenseOrPermitExpirationDate"
})
public class InternationalControlledExportDetail {

    @XmlElement(name = "Type", required = true)
    protected InternationalControlledExportType type;
    @XmlElement(name = "ForeignTradeZoneCode")
    protected String foreignTradeZoneCode;
    @XmlElement(name = "EntryNumber")
    protected String entryNumber;
    @XmlElement(name = "LicenseOrPermitNumber")
    protected String licenseOrPermitNumber;
    @XmlElement(name = "LicenseOrPermitExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar licenseOrPermitExpirationDate;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link InternationalControlledExportType }
     *     
     */
    public InternationalControlledExportType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link InternationalControlledExportType }
     *     
     */
    public void setType(InternationalControlledExportType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad foreignTradeZoneCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTradeZoneCode() {
        return foreignTradeZoneCode;
    }

    /**
     * Define el valor de la propiedad foreignTradeZoneCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTradeZoneCode(String value) {
        this.foreignTradeZoneCode = value;
    }

    /**
     * Obtiene el valor de la propiedad entryNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryNumber() {
        return entryNumber;
    }

    /**
     * Define el valor de la propiedad entryNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryNumber(String value) {
        this.entryNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad licenseOrPermitNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseOrPermitNumber() {
        return licenseOrPermitNumber;
    }

    /**
     * Define el valor de la propiedad licenseOrPermitNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseOrPermitNumber(String value) {
        this.licenseOrPermitNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad licenseOrPermitExpirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLicenseOrPermitExpirationDate() {
        return licenseOrPermitExpirationDate;
    }

    /**
     * Define el valor de la propiedad licenseOrPermitExpirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLicenseOrPermitExpirationDate(XMLGregorianCalendar value) {
        this.licenseOrPermitExpirationDate = value;
    }

}
