
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ShipmentOperationalDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentOperationalDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UrsaPrefixCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UrsaSuffixCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginLocationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginLocationNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="OriginServiceArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationLocationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationLocationNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DestinationServiceArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationLocationStateOrProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeliveryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DeliveryDay" type="{http://fedex.com/ws/ship/v19}DayOfWeekType" minOccurs="0"/>
 *         &lt;element name="PublishedDeliveryTime" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="CommitDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CommitDay" type="{http://fedex.com/ws/ship/v19}DayOfWeekType" minOccurs="0"/>
 *         &lt;element name="TransitTime" type="{http://fedex.com/ws/ship/v19}TransitTimeType" minOccurs="0"/>
 *         &lt;element name="MaximumTransitTime" type="{http://fedex.com/ws/ship/v19}TransitTimeType" minOccurs="0"/>
 *         &lt;element name="CustomTransitTime" type="{http://fedex.com/ws/ship/v19}TransitTimeType" minOccurs="0"/>
 *         &lt;element name="IneligibleForMoneyBackGuarantee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeliveryEligibilities" type="{http://fedex.com/ws/ship/v19}GroundDeliveryEligibilityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AstraPlannedServiceLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AstraDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOrProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AirportId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackagingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Scac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentOperationalDetail", propOrder = {
    "ursaPrefixCode",
    "ursaSuffixCode",
    "originLocationId",
    "originLocationNumber",
    "originServiceArea",
    "destinationLocationId",
    "destinationLocationNumber",
    "destinationServiceArea",
    "destinationLocationStateOrProvinceCode",
    "deliveryDate",
    "deliveryDay",
    "publishedDeliveryTime",
    "commitDate",
    "commitDay",
    "transitTime",
    "maximumTransitTime",
    "customTransitTime",
    "ineligibleForMoneyBackGuarantee",
    "deliveryEligibilities",
    "astraPlannedServiceLevel",
    "astraDescription",
    "postalCode",
    "stateOrProvinceCode",
    "countryCode",
    "airportId",
    "serviceCode",
    "packagingCode",
    "scac"
})
public class ShipmentOperationalDetail {

    @XmlElement(name = "UrsaPrefixCode")
    protected String ursaPrefixCode;
    @XmlElement(name = "UrsaSuffixCode")
    protected String ursaSuffixCode;
    @XmlElement(name = "OriginLocationId")
    protected String originLocationId;
    @XmlElement(name = "OriginLocationNumber")
    protected Integer originLocationNumber;
    @XmlElement(name = "OriginServiceArea")
    protected String originServiceArea;
    @XmlElement(name = "DestinationLocationId")
    protected String destinationLocationId;
    @XmlElement(name = "DestinationLocationNumber")
    protected Integer destinationLocationNumber;
    @XmlElement(name = "DestinationServiceArea")
    protected String destinationServiceArea;
    @XmlElement(name = "DestinationLocationStateOrProvinceCode")
    protected String destinationLocationStateOrProvinceCode;
    @XmlElement(name = "DeliveryDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDate;
    @XmlElement(name = "DeliveryDay")
    protected DayOfWeekType deliveryDay;
    @XmlElement(name = "PublishedDeliveryTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar publishedDeliveryTime;
    @XmlElement(name = "CommitDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commitDate;
    @XmlElement(name = "CommitDay")
    protected DayOfWeekType commitDay;
    @XmlElement(name = "TransitTime")
    protected TransitTimeType transitTime;
    @XmlElement(name = "MaximumTransitTime")
    protected TransitTimeType maximumTransitTime;
    @XmlElement(name = "CustomTransitTime")
    protected TransitTimeType customTransitTime;
    @XmlElement(name = "IneligibleForMoneyBackGuarantee")
    protected Boolean ineligibleForMoneyBackGuarantee;
    @XmlElement(name = "DeliveryEligibilities")
    protected List<GroundDeliveryEligibilityType> deliveryEligibilities;
    @XmlElement(name = "AstraPlannedServiceLevel")
    protected String astraPlannedServiceLevel;
    @XmlElement(name = "AstraDescription")
    protected String astraDescription;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "StateOrProvinceCode")
    protected String stateOrProvinceCode;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "AirportId")
    protected String airportId;
    @XmlElement(name = "ServiceCode")
    protected String serviceCode;
    @XmlElement(name = "PackagingCode")
    protected String packagingCode;
    @XmlElement(name = "Scac")
    protected String scac;

    /**
     * Obtiene el valor de la propiedad ursaPrefixCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrsaPrefixCode() {
        return ursaPrefixCode;
    }

    /**
     * Define el valor de la propiedad ursaPrefixCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrsaPrefixCode(String value) {
        this.ursaPrefixCode = value;
    }

    /**
     * Obtiene el valor de la propiedad ursaSuffixCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrsaSuffixCode() {
        return ursaSuffixCode;
    }

    /**
     * Define el valor de la propiedad ursaSuffixCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrsaSuffixCode(String value) {
        this.ursaSuffixCode = value;
    }

    /**
     * Obtiene el valor de la propiedad originLocationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginLocationId() {
        return originLocationId;
    }

    /**
     * Define el valor de la propiedad originLocationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginLocationId(String value) {
        this.originLocationId = value;
    }

    /**
     * Obtiene el valor de la propiedad originLocationNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOriginLocationNumber() {
        return originLocationNumber;
    }

    /**
     * Define el valor de la propiedad originLocationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOriginLocationNumber(Integer value) {
        this.originLocationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad originServiceArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginServiceArea() {
        return originServiceArea;
    }

    /**
     * Define el valor de la propiedad originServiceArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginServiceArea(String value) {
        this.originServiceArea = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationLocationId() {
        return destinationLocationId;
    }

    /**
     * Define el valor de la propiedad destinationLocationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationLocationId(String value) {
        this.destinationLocationId = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationLocationNumber() {
        return destinationLocationNumber;
    }

    /**
     * Define el valor de la propiedad destinationLocationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationLocationNumber(Integer value) {
        this.destinationLocationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationServiceArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationServiceArea() {
        return destinationServiceArea;
    }

    /**
     * Define el valor de la propiedad destinationServiceArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationServiceArea(String value) {
        this.destinationServiceArea = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationLocationStateOrProvinceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationLocationStateOrProvinceCode() {
        return destinationLocationStateOrProvinceCode;
    }

    /**
     * Define el valor de la propiedad destinationLocationStateOrProvinceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationLocationStateOrProvinceCode(String value) {
        this.destinationLocationStateOrProvinceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Define el valor de la propiedad deliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryDay.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeekType }
     *     
     */
    public DayOfWeekType getDeliveryDay() {
        return deliveryDay;
    }

    /**
     * Define el valor de la propiedad deliveryDay.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeekType }
     *     
     */
    public void setDeliveryDay(DayOfWeekType value) {
        this.deliveryDay = value;
    }

    /**
     * Obtiene el valor de la propiedad publishedDeliveryTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublishedDeliveryTime() {
        return publishedDeliveryTime;
    }

    /**
     * Define el valor de la propiedad publishedDeliveryTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublishedDeliveryTime(XMLGregorianCalendar value) {
        this.publishedDeliveryTime = value;
    }

    /**
     * Obtiene el valor de la propiedad commitDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommitDate() {
        return commitDate;
    }

    /**
     * Define el valor de la propiedad commitDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommitDate(XMLGregorianCalendar value) {
        this.commitDate = value;
    }

    /**
     * Obtiene el valor de la propiedad commitDay.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeekType }
     *     
     */
    public DayOfWeekType getCommitDay() {
        return commitDay;
    }

    /**
     * Define el valor de la propiedad commitDay.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeekType }
     *     
     */
    public void setCommitDay(DayOfWeekType value) {
        this.commitDay = value;
    }

    /**
     * Obtiene el valor de la propiedad transitTime.
     * 
     * @return
     *     possible object is
     *     {@link TransitTimeType }
     *     
     */
    public TransitTimeType getTransitTime() {
        return transitTime;
    }

    /**
     * Define el valor de la propiedad transitTime.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTimeType }
     *     
     */
    public void setTransitTime(TransitTimeType value) {
        this.transitTime = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumTransitTime.
     * 
     * @return
     *     possible object is
     *     {@link TransitTimeType }
     *     
     */
    public TransitTimeType getMaximumTransitTime() {
        return maximumTransitTime;
    }

    /**
     * Define el valor de la propiedad maximumTransitTime.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTimeType }
     *     
     */
    public void setMaximumTransitTime(TransitTimeType value) {
        this.maximumTransitTime = value;
    }

    /**
     * Obtiene el valor de la propiedad customTransitTime.
     * 
     * @return
     *     possible object is
     *     {@link TransitTimeType }
     *     
     */
    public TransitTimeType getCustomTransitTime() {
        return customTransitTime;
    }

    /**
     * Define el valor de la propiedad customTransitTime.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTimeType }
     *     
     */
    public void setCustomTransitTime(TransitTimeType value) {
        this.customTransitTime = value;
    }

    /**
     * Obtiene el valor de la propiedad ineligibleForMoneyBackGuarantee.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIneligibleForMoneyBackGuarantee() {
        return ineligibleForMoneyBackGuarantee;
    }

    /**
     * Define el valor de la propiedad ineligibleForMoneyBackGuarantee.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIneligibleForMoneyBackGuarantee(Boolean value) {
        this.ineligibleForMoneyBackGuarantee = value;
    }

    /**
     * Gets the value of the deliveryEligibilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryEligibilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryEligibilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroundDeliveryEligibilityType }
     * 
     * 
     */
    public List<GroundDeliveryEligibilityType> getDeliveryEligibilities() {
        if (deliveryEligibilities == null) {
            deliveryEligibilities = new ArrayList<GroundDeliveryEligibilityType>();
        }
        return this.deliveryEligibilities;
    }

    /**
     * Obtiene el valor de la propiedad astraPlannedServiceLevel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAstraPlannedServiceLevel() {
        return astraPlannedServiceLevel;
    }

    /**
     * Define el valor de la propiedad astraPlannedServiceLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAstraPlannedServiceLevel(String value) {
        this.astraPlannedServiceLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad astraDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAstraDescription() {
        return astraDescription;
    }

    /**
     * Define el valor de la propiedad astraDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAstraDescription(String value) {
        this.astraDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad postalCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Define el valor de la propiedad postalCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Obtiene el valor de la propiedad stateOrProvinceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrProvinceCode() {
        return stateOrProvinceCode;
    }

    /**
     * Define el valor de la propiedad stateOrProvinceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvinceCode(String value) {
        this.stateOrProvinceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad countryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Define el valor de la propiedad countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad airportId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirportId() {
        return airportId;
    }

    /**
     * Define el valor de la propiedad airportId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirportId(String value) {
        this.airportId = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Define el valor de la propiedad serviceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad packagingCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackagingCode() {
        return packagingCode;
    }

    /**
     * Define el valor de la propiedad packagingCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackagingCode(String value) {
        this.packagingCode = value;
    }

    /**
     * Obtiene el valor de la propiedad scac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScac() {
        return scac;
    }

    /**
     * Define el valor de la propiedad scac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScac(String value) {
        this.scac = value;
    }

}
