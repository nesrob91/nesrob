
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data for a package's rates, as calculated per a specific rate type.
 * 
 * <p>Clase Java para PackageRateDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PackageRateDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RateType" type="{http://fedex.com/ws/ship/v19}ReturnedRateType" minOccurs="0"/>
 *         &lt;element name="RatedWeightMethod" type="{http://fedex.com/ws/ship/v19}RatedWeightMethod" minOccurs="0"/>
 *         &lt;element name="MinimumChargeType" type="{http://fedex.com/ws/ship/v19}MinimumChargeType" minOccurs="0"/>
 *         &lt;element name="BillingWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="DimWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="OversizeWeight" type="{http://fedex.com/ws/ship/v19}Weight" minOccurs="0"/>
 *         &lt;element name="BaseCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TotalFreightDiscounts" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="NetFreight" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TotalSurcharges" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="NetFedExCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TotalTaxes" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="NetCharge" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="TotalRebates" type="{http://fedex.com/ws/ship/v19}Money" minOccurs="0"/>
 *         &lt;element name="FreightDiscounts" type="{http://fedex.com/ws/ship/v19}RateDiscount" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Rebates" type="{http://fedex.com/ws/ship/v19}Rebate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Surcharges" type="{http://fedex.com/ws/ship/v19}Surcharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Taxes" type="{http://fedex.com/ws/ship/v19}Tax" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VariableHandlingCharges" type="{http://fedex.com/ws/ship/v19}VariableHandlingCharges" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageRateDetail", propOrder = {
    "rateType",
    "ratedWeightMethod",
    "minimumChargeType",
    "billingWeight",
    "dimWeight",
    "oversizeWeight",
    "baseCharge",
    "totalFreightDiscounts",
    "netFreight",
    "totalSurcharges",
    "netFedExCharge",
    "totalTaxes",
    "netCharge",
    "totalRebates",
    "freightDiscounts",
    "rebates",
    "surcharges",
    "taxes",
    "variableHandlingCharges"
})
public class PackageRateDetail {

    @XmlElement(name = "RateType")
    protected ReturnedRateType rateType;
    @XmlElement(name = "RatedWeightMethod")
    protected RatedWeightMethod ratedWeightMethod;
    @XmlElement(name = "MinimumChargeType")
    protected MinimumChargeType minimumChargeType;
    @XmlElement(name = "BillingWeight")
    protected Weight billingWeight;
    @XmlElement(name = "DimWeight")
    protected Weight dimWeight;
    @XmlElement(name = "OversizeWeight")
    protected Weight oversizeWeight;
    @XmlElement(name = "BaseCharge")
    protected Money baseCharge;
    @XmlElement(name = "TotalFreightDiscounts")
    protected Money totalFreightDiscounts;
    @XmlElement(name = "NetFreight")
    protected Money netFreight;
    @XmlElement(name = "TotalSurcharges")
    protected Money totalSurcharges;
    @XmlElement(name = "NetFedExCharge")
    protected Money netFedExCharge;
    @XmlElement(name = "TotalTaxes")
    protected Money totalTaxes;
    @XmlElement(name = "NetCharge")
    protected Money netCharge;
    @XmlElement(name = "TotalRebates")
    protected Money totalRebates;
    @XmlElement(name = "FreightDiscounts")
    protected List<RateDiscount> freightDiscounts;
    @XmlElement(name = "Rebates")
    protected List<Rebate> rebates;
    @XmlElement(name = "Surcharges")
    protected List<Surcharge> surcharges;
    @XmlElement(name = "Taxes")
    protected List<Tax> taxes;
    @XmlElement(name = "VariableHandlingCharges")
    protected VariableHandlingCharges variableHandlingCharges;

    /**
     * Obtiene el valor de la propiedad rateType.
     * 
     * @return
     *     possible object is
     *     {@link ReturnedRateType }
     *     
     */
    public ReturnedRateType getRateType() {
        return rateType;
    }

    /**
     * Define el valor de la propiedad rateType.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnedRateType }
     *     
     */
    public void setRateType(ReturnedRateType value) {
        this.rateType = value;
    }

    /**
     * Obtiene el valor de la propiedad ratedWeightMethod.
     * 
     * @return
     *     possible object is
     *     {@link RatedWeightMethod }
     *     
     */
    public RatedWeightMethod getRatedWeightMethod() {
        return ratedWeightMethod;
    }

    /**
     * Define el valor de la propiedad ratedWeightMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link RatedWeightMethod }
     *     
     */
    public void setRatedWeightMethod(RatedWeightMethod value) {
        this.ratedWeightMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad minimumChargeType.
     * 
     * @return
     *     possible object is
     *     {@link MinimumChargeType }
     *     
     */
    public MinimumChargeType getMinimumChargeType() {
        return minimumChargeType;
    }

    /**
     * Define el valor de la propiedad minimumChargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumChargeType }
     *     
     */
    public void setMinimumChargeType(MinimumChargeType value) {
        this.minimumChargeType = value;
    }

    /**
     * Obtiene el valor de la propiedad billingWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getBillingWeight() {
        return billingWeight;
    }

    /**
     * Define el valor de la propiedad billingWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setBillingWeight(Weight value) {
        this.billingWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad dimWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getDimWeight() {
        return dimWeight;
    }

    /**
     * Define el valor de la propiedad dimWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setDimWeight(Weight value) {
        this.dimWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad oversizeWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getOversizeWeight() {
        return oversizeWeight;
    }

    /**
     * Define el valor de la propiedad oversizeWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setOversizeWeight(Weight value) {
        this.oversizeWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad baseCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getBaseCharge() {
        return baseCharge;
    }

    /**
     * Define el valor de la propiedad baseCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setBaseCharge(Money value) {
        this.baseCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad totalFreightDiscounts.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalFreightDiscounts() {
        return totalFreightDiscounts;
    }

    /**
     * Define el valor de la propiedad totalFreightDiscounts.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalFreightDiscounts(Money value) {
        this.totalFreightDiscounts = value;
    }

    /**
     * Obtiene el valor de la propiedad netFreight.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getNetFreight() {
        return netFreight;
    }

    /**
     * Define el valor de la propiedad netFreight.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setNetFreight(Money value) {
        this.netFreight = value;
    }

    /**
     * Obtiene el valor de la propiedad totalSurcharges.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalSurcharges() {
        return totalSurcharges;
    }

    /**
     * Define el valor de la propiedad totalSurcharges.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalSurcharges(Money value) {
        this.totalSurcharges = value;
    }

    /**
     * Obtiene el valor de la propiedad netFedExCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getNetFedExCharge() {
        return netFedExCharge;
    }

    /**
     * Define el valor de la propiedad netFedExCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setNetFedExCharge(Money value) {
        this.netFedExCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad totalTaxes.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalTaxes() {
        return totalTaxes;
    }

    /**
     * Define el valor de la propiedad totalTaxes.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalTaxes(Money value) {
        this.totalTaxes = value;
    }

    /**
     * Obtiene el valor de la propiedad netCharge.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getNetCharge() {
        return netCharge;
    }

    /**
     * Define el valor de la propiedad netCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setNetCharge(Money value) {
        this.netCharge = value;
    }

    /**
     * Obtiene el valor de la propiedad totalRebates.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalRebates() {
        return totalRebates;
    }

    /**
     * Define el valor de la propiedad totalRebates.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalRebates(Money value) {
        this.totalRebates = value;
    }

    /**
     * Gets the value of the freightDiscounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the freightDiscounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFreightDiscounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RateDiscount }
     * 
     * 
     */
    public List<RateDiscount> getFreightDiscounts() {
        if (freightDiscounts == null) {
            freightDiscounts = new ArrayList<RateDiscount>();
        }
        return this.freightDiscounts;
    }

    /**
     * Gets the value of the rebates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rebates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRebates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rebate }
     * 
     * 
     */
    public List<Rebate> getRebates() {
        if (rebates == null) {
            rebates = new ArrayList<Rebate>();
        }
        return this.rebates;
    }

    /**
     * Gets the value of the surcharges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surcharges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurcharges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Surcharge }
     * 
     * 
     */
    public List<Surcharge> getSurcharges() {
        if (surcharges == null) {
            surcharges = new ArrayList<Surcharge>();
        }
        return this.surcharges;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tax }
     * 
     * 
     */
    public List<Tax> getTaxes() {
        if (taxes == null) {
            taxes = new ArrayList<Tax>();
        }
        return this.taxes;
    }

    /**
     * Obtiene el valor de la propiedad variableHandlingCharges.
     * 
     * @return
     *     possible object is
     *     {@link VariableHandlingCharges }
     *     
     */
    public VariableHandlingCharges getVariableHandlingCharges() {
        return variableHandlingCharges;
    }

    /**
     * Define el valor de la propiedad variableHandlingCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableHandlingCharges }
     *     
     */
    public void setVariableHandlingCharges(VariableHandlingCharges value) {
        this.variableHandlingCharges = value;
    }

}
