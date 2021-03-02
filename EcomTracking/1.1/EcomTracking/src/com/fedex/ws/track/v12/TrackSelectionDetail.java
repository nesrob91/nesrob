
package com.fedex.ws.track.v12;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TrackSelectionDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TrackSelectionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarrierCode" type="{http://fedex.com/ws/track/v12}CarrierCodeType" minOccurs="0"/>
 *         &lt;element name="OperatingCompany" type="{http://fedex.com/ws/track/v12}OperatingCompanyType" minOccurs="0"/>
 *         &lt;element name="PackageIdentifier" type="{http://fedex.com/ws/track/v12}TrackPackageIdentifier" minOccurs="0"/>
 *         &lt;element name="TrackingNumberUniqueIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipDateRangeBegin" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ShipDateRangeEnd" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ShipmentAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecureSpodAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://fedex.com/ws/track/v12}Address" minOccurs="0"/>
 *         &lt;element name="PagingDetail" type="{http://fedex.com/ws/track/v12}PagingDetail" minOccurs="0"/>
 *         &lt;element name="CustomerSpecifiedTimeOutValueInMilliseconds" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackSelectionDetail", propOrder = {
    "carrierCode",
    "operatingCompany",
    "packageIdentifier",
    "trackingNumberUniqueIdentifier",
    "shipDateRangeBegin",
    "shipDateRangeEnd",
    "shipmentAccountNumber",
    "secureSpodAccount",
    "destination",
    "pagingDetail",
    "customerSpecifiedTimeOutValueInMilliseconds"
})
public class TrackSelectionDetail {

    @XmlElement(name = "CarrierCode")
    protected CarrierCodeType carrierCode;
    @XmlElement(name = "OperatingCompany")
    protected OperatingCompanyType operatingCompany;
    @XmlElement(name = "PackageIdentifier")
    protected TrackPackageIdentifier packageIdentifier;
    @XmlElement(name = "TrackingNumberUniqueIdentifier")
    protected String trackingNumberUniqueIdentifier;
    @XmlElement(name = "ShipDateRangeBegin")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shipDateRangeBegin;
    @XmlElement(name = "ShipDateRangeEnd")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shipDateRangeEnd;
    @XmlElement(name = "ShipmentAccountNumber")
    protected String shipmentAccountNumber;
    @XmlElement(name = "SecureSpodAccount")
    protected String secureSpodAccount;
    @XmlElement(name = "Destination")
    protected Address destination;
    @XmlElement(name = "PagingDetail")
    protected PagingDetail pagingDetail;
    @XmlElement(name = "CustomerSpecifiedTimeOutValueInMilliseconds")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger customerSpecifiedTimeOutValueInMilliseconds;

    /**
     * Obtiene el valor de la propiedad carrierCode.
     * 
     * @return
     *     possible object is
     *     {@link CarrierCodeType }
     *     
     */
    public CarrierCodeType getCarrierCode() {
        return carrierCode;
    }

    /**
     * Define el valor de la propiedad carrierCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CarrierCodeType }
     *     
     */
    public void setCarrierCode(CarrierCodeType value) {
        this.carrierCode = value;
    }

    /**
     * Obtiene el valor de la propiedad operatingCompany.
     * 
     * @return
     *     possible object is
     *     {@link OperatingCompanyType }
     *     
     */
    public OperatingCompanyType getOperatingCompany() {
        return operatingCompany;
    }

    /**
     * Define el valor de la propiedad operatingCompany.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingCompanyType }
     *     
     */
    public void setOperatingCompany(OperatingCompanyType value) {
        this.operatingCompany = value;
    }

    /**
     * Obtiene el valor de la propiedad packageIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link TrackPackageIdentifier }
     *     
     */
    public TrackPackageIdentifier getPackageIdentifier() {
        return packageIdentifier;
    }

    /**
     * Define el valor de la propiedad packageIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackPackageIdentifier }
     *     
     */
    public void setPackageIdentifier(TrackPackageIdentifier value) {
        this.packageIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumberUniqueIdentifier() {
        return trackingNumberUniqueIdentifier;
    }

    /**
     * Define el valor de la propiedad trackingNumberUniqueIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumberUniqueIdentifier(String value) {
        this.trackingNumberUniqueIdentifier = value;
    }

    /**
     * Obtiene el valor de la propiedad shipDateRangeBegin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipDateRangeBegin() {
        return shipDateRangeBegin;
    }

    /**
     * Define el valor de la propiedad shipDateRangeBegin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipDateRangeBegin(XMLGregorianCalendar value) {
        this.shipDateRangeBegin = value;
    }

    /**
     * Obtiene el valor de la propiedad shipDateRangeEnd.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShipDateRangeEnd() {
        return shipDateRangeEnd;
    }

    /**
     * Define el valor de la propiedad shipDateRangeEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShipDateRangeEnd(XMLGregorianCalendar value) {
        this.shipDateRangeEnd = value;
    }

    /**
     * Obtiene el valor de la propiedad shipmentAccountNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentAccountNumber() {
        return shipmentAccountNumber;
    }

    /**
     * Define el valor de la propiedad shipmentAccountNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentAccountNumber(String value) {
        this.shipmentAccountNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad secureSpodAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecureSpodAccount() {
        return secureSpodAccount;
    }

    /**
     * Define el valor de la propiedad secureSpodAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecureSpodAccount(String value) {
        this.secureSpodAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad destination.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDestination() {
        return destination;
    }

    /**
     * Define el valor de la propiedad destination.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDestination(Address value) {
        this.destination = value;
    }

    /**
     * Obtiene el valor de la propiedad pagingDetail.
     * 
     * @return
     *     possible object is
     *     {@link PagingDetail }
     *     
     */
    public PagingDetail getPagingDetail() {
        return pagingDetail;
    }

    /**
     * Define el valor de la propiedad pagingDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link PagingDetail }
     *     
     */
    public void setPagingDetail(PagingDetail value) {
        this.pagingDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad customerSpecifiedTimeOutValueInMilliseconds.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCustomerSpecifiedTimeOutValueInMilliseconds() {
        return customerSpecifiedTimeOutValueInMilliseconds;
    }

    /**
     * Define el valor de la propiedad customerSpecifiedTimeOutValueInMilliseconds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCustomerSpecifiedTimeOutValueInMilliseconds(BigInteger value) {
        this.customerSpecifiedTimeOutValueInMilliseconds = value;
    }

}
