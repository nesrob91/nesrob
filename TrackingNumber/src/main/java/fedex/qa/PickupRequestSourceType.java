
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PickupRequestSourceType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PickupRequestSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTOMATION"/>
 *     &lt;enumeration value="CUSTOMER_SERVICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PickupRequestSourceType")
@XmlEnum
public enum PickupRequestSourceType {

    AUTOMATION,
    CUSTOMER_SERVICE;

    public String value() {
        return name();
    }

    public static PickupRequestSourceType fromValue(String v) {
        return valueOf(v);
    }

}
