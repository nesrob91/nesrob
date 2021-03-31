
package fedex.qa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Documents the kind and quantity of an individual hazardous commodity in a package.
 * 
 * <p>Clase Java para HazardousCommodityContent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="HazardousCommodityContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://fedex.com/ws/ship/v19}HazardousCommodityDescription" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://fedex.com/ws/ship/v19}HazardousCommodityQuantityDetail" minOccurs="0"/>
 *         &lt;element name="InnerReceptacles" type="{http://fedex.com/ws/ship/v19}HazardousCommodityInnerReceptacleDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Options" type="{http://fedex.com/ws/ship/v19}HazardousCommodityOptionDetail" minOccurs="0"/>
 *         &lt;element name="RadionuclideDetail" type="{http://fedex.com/ws/ship/v19}RadionuclideDetail" minOccurs="0"/>
 *         &lt;element name="NetExplosiveDetail" type="{http://fedex.com/ws/ship/v19}NetExplosiveDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousCommodityContent", propOrder = {
    "description",
    "quantity",
    "innerReceptacles",
    "options",
    "radionuclideDetail",
    "netExplosiveDetail"
})
public class HazardousCommodityContent {

    @XmlElement(name = "Description")
    protected HazardousCommodityDescription description;
    @XmlElement(name = "Quantity")
    protected HazardousCommodityQuantityDetail quantity;
    @XmlElement(name = "InnerReceptacles")
    protected List<HazardousCommodityInnerReceptacleDetail> innerReceptacles;
    @XmlElement(name = "Options")
    protected HazardousCommodityOptionDetail options;
    @XmlElement(name = "RadionuclideDetail")
    protected RadionuclideDetail radionuclideDetail;
    @XmlElement(name = "NetExplosiveDetail")
    protected NetExplosiveDetail netExplosiveDetail;

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityDescription }
     *     
     */
    public HazardousCommodityDescription getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityDescription }
     *     
     */
    public void setDescription(HazardousCommodityDescription value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityQuantityDetail }
     *     
     */
    public HazardousCommodityQuantityDetail getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityQuantityDetail }
     *     
     */
    public void setQuantity(HazardousCommodityQuantityDetail value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the innerReceptacles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerReceptacles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerReceptacles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousCommodityInnerReceptacleDetail }
     * 
     * 
     */
    public List<HazardousCommodityInnerReceptacleDetail> getInnerReceptacles() {
        if (innerReceptacles == null) {
            innerReceptacles = new ArrayList<HazardousCommodityInnerReceptacleDetail>();
        }
        return this.innerReceptacles;
    }

    /**
     * Obtiene el valor de la propiedad options.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCommodityOptionDetail }
     *     
     */
    public HazardousCommodityOptionDetail getOptions() {
        return options;
    }

    /**
     * Define el valor de la propiedad options.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCommodityOptionDetail }
     *     
     */
    public void setOptions(HazardousCommodityOptionDetail value) {
        this.options = value;
    }

    /**
     * Obtiene el valor de la propiedad radionuclideDetail.
     * 
     * @return
     *     possible object is
     *     {@link RadionuclideDetail }
     *     
     */
    public RadionuclideDetail getRadionuclideDetail() {
        return radionuclideDetail;
    }

    /**
     * Define el valor de la propiedad radionuclideDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link RadionuclideDetail }
     *     
     */
    public void setRadionuclideDetail(RadionuclideDetail value) {
        this.radionuclideDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad netExplosiveDetail.
     * 
     * @return
     *     possible object is
     *     {@link NetExplosiveDetail }
     *     
     */
    public NetExplosiveDetail getNetExplosiveDetail() {
        return netExplosiveDetail;
    }

    /**
     * Define el valor de la propiedad netExplosiveDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link NetExplosiveDetail }
     *     
     */
    public void setNetExplosiveDetail(NetExplosiveDetail value) {
        this.netExplosiveDetail = value;
    }

}
