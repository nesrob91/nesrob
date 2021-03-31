
package fedex.qa;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Shipment-level totals of dry ice data across all packages.
 * 
 * <p>Clase Java para ShipmentDryIceDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShipmentDryIceDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="TotalWeight" type="{http://fedex.com/ws/ship/v19}Weight"/>
 *         &lt;element name="ProcessingOptions" type="{http://fedex.com/ws/ship/v19}ShipmentDryIceProcessingOptionsRequested" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentDryIceDetail", propOrder = {
    "packageCount",
    "totalWeight",
    "processingOptions"
})
public class ShipmentDryIceDetail {

    @XmlElement(name = "PackageCount", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger packageCount;
    @XmlElement(name = "TotalWeight", required = true)
    protected Weight totalWeight;
    @XmlElement(name = "ProcessingOptions")
    protected ShipmentDryIceProcessingOptionsRequested processingOptions;

    /**
     * Obtiene el valor de la propiedad packageCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPackageCount() {
        return packageCount;
    }

    /**
     * Define el valor de la propiedad packageCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPackageCount(BigInteger value) {
        this.packageCount = value;
    }

    /**
     * Obtiene el valor de la propiedad totalWeight.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getTotalWeight() {
        return totalWeight;
    }

    /**
     * Define el valor de la propiedad totalWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setTotalWeight(Weight value) {
        this.totalWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad processingOptions.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentDryIceProcessingOptionsRequested }
     *     
     */
    public ShipmentDryIceProcessingOptionsRequested getProcessingOptions() {
        return processingOptions;
    }

    /**
     * Define el valor de la propiedad processingOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentDryIceProcessingOptionsRequested }
     *     
     */
    public void setProcessingOptions(ShipmentDryIceProcessingOptionsRequested value) {
        this.processingOptions = value;
    }

}
