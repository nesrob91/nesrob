
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details around the ADR license required for shipping.
 * 
 * <p>Clase Java para AdrLicenseDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AdrLicenseDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LicenseOrPermitDetail" type="{http://fedex.com/ws/ship/v19}LicenseOrPermitDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdrLicenseDetail", propOrder = {
    "licenseOrPermitDetail"
})
public class AdrLicenseDetail {

    @XmlElement(name = "LicenseOrPermitDetail")
    protected LicenseOrPermitDetail licenseOrPermitDetail;

    /**
     * Obtiene el valor de la propiedad licenseOrPermitDetail.
     * 
     * @return
     *     possible object is
     *     {@link LicenseOrPermitDetail }
     *     
     */
    public LicenseOrPermitDetail getLicenseOrPermitDetail() {
        return licenseOrPermitDetail;
    }

    /**
     * Define el valor de la propiedad licenseOrPermitDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseOrPermitDetail }
     *     
     */
    public void setLicenseOrPermitDetail(LicenseOrPermitDetail value) {
        this.licenseOrPermitDetail = value;
    }

}
