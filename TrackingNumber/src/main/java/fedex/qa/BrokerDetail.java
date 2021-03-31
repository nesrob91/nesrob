
package fedex.qa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BrokerDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BrokerDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://fedex.com/ws/ship/v19}BrokerType" minOccurs="0"/>
 *         &lt;element name="Broker" type="{http://fedex.com/ws/ship/v19}Party" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BrokerDetail", propOrder = {
    "type",
    "broker"
})
public class BrokerDetail {

    @XmlElement(name = "Type")
    protected BrokerType type;
    @XmlElement(name = "Broker")
    protected Party broker;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link BrokerType }
     *     
     */
    public BrokerType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link BrokerType }
     *     
     */
    public void setType(BrokerType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad broker.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getBroker() {
        return broker;
    }

    /**
     * Define el valor de la propiedad broker.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setBroker(Party value) {
        this.broker = value;
    }

}
