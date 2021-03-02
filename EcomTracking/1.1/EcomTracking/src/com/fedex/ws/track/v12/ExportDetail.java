
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ExportDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExportDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="B13AFilingOption" type="{http://fedex.com/ws/ship/v19}B13AFilingOptionType" minOccurs="0"/>
 *         &lt;element name="ExportComplianceStatement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PermitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationControlDetail" type="{http://fedex.com/ws/ship/v19}DestinationControlDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportDetail", propOrder = {
    "b13AFilingOption",
    "exportComplianceStatement",
    "permitNumber",
    "destinationControlDetail"
})
public class ExportDetail {

    @XmlElement(name = "B13AFilingOption")
    protected B13AFilingOptionType b13AFilingOption;
    @XmlElement(name = "ExportComplianceStatement")
    protected String exportComplianceStatement;
    @XmlElement(name = "PermitNumber")
    protected String permitNumber;
    @XmlElement(name = "DestinationControlDetail")
    protected DestinationControlDetail destinationControlDetail;

    /**
     * Obtiene el valor de la propiedad b13AFilingOption.
     * 
     * @return
     *     possible object is
     *     {@link B13AFilingOptionType }
     *     
     */
    public B13AFilingOptionType getB13AFilingOption() {
        return b13AFilingOption;
    }

    /**
     * Define el valor de la propiedad b13AFilingOption.
     * 
     * @param value
     *     allowed object is
     *     {@link B13AFilingOptionType }
     *     
     */
    public void setB13AFilingOption(B13AFilingOptionType value) {
        this.b13AFilingOption = value;
    }

    /**
     * Obtiene el valor de la propiedad exportComplianceStatement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportComplianceStatement() {
        return exportComplianceStatement;
    }

    /**
     * Define el valor de la propiedad exportComplianceStatement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportComplianceStatement(String value) {
        this.exportComplianceStatement = value;
    }

    /**
     * Obtiene el valor de la propiedad permitNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitNumber() {
        return permitNumber;
    }

    /**
     * Define el valor de la propiedad permitNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitNumber(String value) {
        this.permitNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad destinationControlDetail.
     * 
     * @return
     *     possible object is
     *     {@link DestinationControlDetail }
     *     
     */
    public DestinationControlDetail getDestinationControlDetail() {
        return destinationControlDetail;
    }

    /**
     * Define el valor de la propiedad destinationControlDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationControlDetail }
     *     
     */
    public void setDestinationControlDetail(DestinationControlDetail value) {
        this.destinationControlDetail = value;
    }

}
