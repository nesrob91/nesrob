
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NaftaCommodityDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NaftaCommodityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PreferenceCriterion" type="{http://fedex.com/ws/ship/v19}NaftaPreferenceCriterionCode" minOccurs="0"/>
 *         &lt;element name="ProducerDetermination" type="{http://fedex.com/ws/ship/v19}NaftaProducerDeterminationCode" minOccurs="0"/>
 *         &lt;element name="ProducerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NetCostMethod" type="{http://fedex.com/ws/ship/v19}NaftaNetCostMethodCode" minOccurs="0"/>
 *         &lt;element name="NetCostDateRange" type="{http://fedex.com/ws/ship/v19}DateRange" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaftaCommodityDetail", propOrder = {
    "preferenceCriterion",
    "producerDetermination",
    "producerId",
    "netCostMethod",
    "netCostDateRange"
})
public class NaftaCommodityDetail {

    @XmlElement(name = "PreferenceCriterion")
    protected NaftaPreferenceCriterionCode preferenceCriterion;
    @XmlElement(name = "ProducerDetermination")
    protected NaftaProducerDeterminationCode producerDetermination;
    @XmlElement(name = "ProducerId")
    protected String producerId;
    @XmlElement(name = "NetCostMethod")
    protected NaftaNetCostMethodCode netCostMethod;
    @XmlElement(name = "NetCostDateRange")
    protected DateRange netCostDateRange;

    /**
     * Obtiene el valor de la propiedad preferenceCriterion.
     * 
     * @return
     *     possible object is
     *     {@link NaftaPreferenceCriterionCode }
     *     
     */
    public NaftaPreferenceCriterionCode getPreferenceCriterion() {
        return preferenceCriterion;
    }

    /**
     * Define el valor de la propiedad preferenceCriterion.
     * 
     * @param value
     *     allowed object is
     *     {@link NaftaPreferenceCriterionCode }
     *     
     */
    public void setPreferenceCriterion(NaftaPreferenceCriterionCode value) {
        this.preferenceCriterion = value;
    }

    /**
     * Obtiene el valor de la propiedad producerDetermination.
     * 
     * @return
     *     possible object is
     *     {@link NaftaProducerDeterminationCode }
     *     
     */
    public NaftaProducerDeterminationCode getProducerDetermination() {
        return producerDetermination;
    }

    /**
     * Define el valor de la propiedad producerDetermination.
     * 
     * @param value
     *     allowed object is
     *     {@link NaftaProducerDeterminationCode }
     *     
     */
    public void setProducerDetermination(NaftaProducerDeterminationCode value) {
        this.producerDetermination = value;
    }

    /**
     * Obtiene el valor de la propiedad producerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerId() {
        return producerId;
    }

    /**
     * Define el valor de la propiedad producerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerId(String value) {
        this.producerId = value;
    }

    /**
     * Obtiene el valor de la propiedad netCostMethod.
     * 
     * @return
     *     possible object is
     *     {@link NaftaNetCostMethodCode }
     *     
     */
    public NaftaNetCostMethodCode getNetCostMethod() {
        return netCostMethod;
    }

    /**
     * Define el valor de la propiedad netCostMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link NaftaNetCostMethodCode }
     *     
     */
    public void setNetCostMethod(NaftaNetCostMethodCode value) {
        this.netCostMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad netCostDateRange.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getNetCostDateRange() {
        return netCostDateRange;
    }

    /**
     * Define el valor de la propiedad netCostDateRange.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setNetCostDateRange(DateRange value) {
        this.netCostDateRange = value;
    }

}
