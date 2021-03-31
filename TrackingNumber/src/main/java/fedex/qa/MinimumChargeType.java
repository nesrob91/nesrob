
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MinimumChargeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="MinimumChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="CUSTOMER_FREIGHT_WEIGHT"/>
 *     &lt;enumeration value="EARNED_DISCOUNT"/>
 *     &lt;enumeration value="MIXED"/>
 *     &lt;enumeration value="RATE_SCALE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MinimumChargeType")
@XmlEnum
public enum MinimumChargeType {

    CUSTOMER,
    CUSTOMER_FREIGHT_WEIGHT,
    EARNED_DISCOUNT,
    MIXED,
    RATE_SCALE;

    public String value() {
        return name();
    }

    public static MinimumChargeType fromValue(String v) {
        return valueOf(v);
    }

}
