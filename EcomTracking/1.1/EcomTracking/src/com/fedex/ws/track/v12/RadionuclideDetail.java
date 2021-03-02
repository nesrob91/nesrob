
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RadionuclideDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RadionuclideDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Radionuclide" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Activity" type="{http://fedex.com/ws/ship/v19}RadionuclideActivity" minOccurs="0"/>
 *         &lt;element name="ExceptedPackagingIsReportableQuantity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PhysicalForm" type="{http://fedex.com/ws/ship/v19}PhysicalFormType" minOccurs="0"/>
 *         &lt;element name="ChemicalForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RadionuclideDetail", propOrder = {
    "radionuclide",
    "activity",
    "exceptedPackagingIsReportableQuantity",
    "physicalForm",
    "chemicalForm"
})
public class RadionuclideDetail {

    @XmlElement(name = "Radionuclide")
    protected String radionuclide;
    @XmlElement(name = "Activity")
    protected RadionuclideActivity activity;
    @XmlElement(name = "ExceptedPackagingIsReportableQuantity")
    protected Boolean exceptedPackagingIsReportableQuantity;
    @XmlElement(name = "PhysicalForm")
    protected PhysicalFormType physicalForm;
    @XmlElement(name = "ChemicalForm")
    protected String chemicalForm;

    /**
     * Obtiene el valor de la propiedad radionuclide.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRadionuclide() {
        return radionuclide;
    }

    /**
     * Define el valor de la propiedad radionuclide.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRadionuclide(String value) {
        this.radionuclide = value;
    }

    /**
     * Obtiene el valor de la propiedad activity.
     * 
     * @return
     *     possible object is
     *     {@link RadionuclideActivity }
     *     
     */
    public RadionuclideActivity getActivity() {
        return activity;
    }

    /**
     * Define el valor de la propiedad activity.
     * 
     * @param value
     *     allowed object is
     *     {@link RadionuclideActivity }
     *     
     */
    public void setActivity(RadionuclideActivity value) {
        this.activity = value;
    }

    /**
     * Obtiene el valor de la propiedad exceptedPackagingIsReportableQuantity.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExceptedPackagingIsReportableQuantity() {
        return exceptedPackagingIsReportableQuantity;
    }

    /**
     * Define el valor de la propiedad exceptedPackagingIsReportableQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExceptedPackagingIsReportableQuantity(Boolean value) {
        this.exceptedPackagingIsReportableQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad physicalForm.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalFormType }
     *     
     */
    public PhysicalFormType getPhysicalForm() {
        return physicalForm;
    }

    /**
     * Define el valor de la propiedad physicalForm.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalFormType }
     *     
     */
    public void setPhysicalForm(PhysicalFormType value) {
        this.physicalForm = value;
    }

    /**
     * Obtiene el valor de la propiedad chemicalForm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChemicalForm() {
        return chemicalForm;
    }

    /**
     * Define el valor de la propiedad chemicalForm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChemicalForm(String value) {
        this.chemicalForm = value;
    }

}
