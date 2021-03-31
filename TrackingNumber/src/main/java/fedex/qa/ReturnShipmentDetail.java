
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReturnShipmentDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ReturnShipmentDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnType" type="{http://fedex.com/ws/ship/v19}ReturnType"/>
 *         &lt;element name="Rma" type="{http://fedex.com/ws/ship/v19}Rma" minOccurs="0"/>
 *         &lt;element name="ReturnEMailDetail" type="{http://fedex.com/ws/ship/v19}ReturnEMailDetail" minOccurs="0"/>
 *         &lt;element name="ReturnAssociation" type="{http://fedex.com/ws/ship/v19}ReturnAssociationDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnShipmentDetail", propOrder = {
    "returnType",
    "rma",
    "returnEMailDetail",
    "returnAssociation"
})
public class ReturnShipmentDetail {

    @XmlElement(name = "ReturnType", required = true)
    protected ReturnType returnType;
    @XmlElement(name = "Rma")
    protected Rma rma;
    @XmlElement(name = "ReturnEMailDetail")
    protected ReturnEMailDetail returnEMailDetail;
    @XmlElement(name = "ReturnAssociation")
    protected ReturnAssociationDetail returnAssociation;

    /**
     * Obtiene el valor de la propiedad returnType.
     * 
     * @return
     *     possible object is
     *     {@link ReturnType }
     *     
     */
    public ReturnType getReturnType() {
        return returnType;
    }

    /**
     * Define el valor de la propiedad returnType.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnType }
     *     
     */
    public void setReturnType(ReturnType value) {
        this.returnType = value;
    }

    /**
     * Obtiene el valor de la propiedad rma.
     * 
     * @return
     *     possible object is
     *     {@link Rma }
     *     
     */
    public Rma getRma() {
        return rma;
    }

    /**
     * Define el valor de la propiedad rma.
     * 
     * @param value
     *     allowed object is
     *     {@link Rma }
     *     
     */
    public void setRma(Rma value) {
        this.rma = value;
    }

    /**
     * Obtiene el valor de la propiedad returnEMailDetail.
     * 
     * @return
     *     possible object is
     *     {@link ReturnEMailDetail }
     *     
     */
    public ReturnEMailDetail getReturnEMailDetail() {
        return returnEMailDetail;
    }

    /**
     * Define el valor de la propiedad returnEMailDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnEMailDetail }
     *     
     */
    public void setReturnEMailDetail(ReturnEMailDetail value) {
        this.returnEMailDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad returnAssociation.
     * 
     * @return
     *     possible object is
     *     {@link ReturnAssociationDetail }
     *     
     */
    public ReturnAssociationDetail getReturnAssociation() {
        return returnAssociation;
    }

    /**
     * Define el valor de la propiedad returnAssociation.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnAssociationDetail }
     *     
     */
    public void setReturnAssociation(ReturnAssociationDetail value) {
        this.returnAssociation = value;
    }

}
