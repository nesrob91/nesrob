
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomDeliveryWindowType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomDeliveryWindowType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AFTER"/>
 *     &lt;enumeration value="BEFORE"/>
 *     &lt;enumeration value="BETWEEN"/>
 *     &lt;enumeration value="ON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomDeliveryWindowType")
@XmlEnum
public enum CustomDeliveryWindowType {

    AFTER,
    BEFORE,
    BETWEEN,
    ON;

    public String value() {
        return name();
    }

    public static CustomDeliveryWindowType fromValue(String v) {
        return valueOf(v);
    }

}
