
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Customer-provided specifications for handling individual commodities.
 * 
 * <p>Clase Java para HazardousCommodityOptionDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HazardousCommodityOptionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LabelTextOption" type="{http://fedex.com/ws/ship/v19}HazardousCommodityLabelTextOptionType" minOccurs="0"/>
 *         &lt;element name="CustomerSuppliedLabelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousCommodityOptionDetail", propOrder = {
    "labelTextOption",
    "customerSuppliedLabelText"
})
public class HazardousCommodityOptionDetail {

    @XmlElement(name = "LabelTextOption")
    protected HazardousCommodityLabelTextOptionType labelTextOption;
    @XmlElement(name = "CustomerSuppliedLabelText")
    protected String customerSuppliedLabelText;

    /**
     * Obtiene el valor de la propiedad labelTextOption.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityLabelTextOptionType }
     *     
     */
    public HazardousCommodityLabelTextOptionType getLabelTextOption() {
        return labelTextOption;
    }

    /**
     * Define el valor de la propiedad labelTextOption.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityLabelTextOptionType }
     *     
     */
    public void setLabelTextOption(HazardousCommodityLabelTextOptionType value) {
        this.labelTextOption = value;
    }

    /**
     * Obtiene el valor de la propiedad customerSuppliedLabelText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerSuppliedLabelText() {
        return customerSuppliedLabelText;
    }

    /**
     * Define el valor de la propiedad customerSuppliedLabelText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerSuppliedLabelText(String value) {
        this.customerSuppliedLabelText = value;
    }

}
