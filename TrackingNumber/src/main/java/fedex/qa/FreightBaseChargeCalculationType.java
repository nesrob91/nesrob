
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FreightBaseChargeCalculationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="FreightBaseChargeCalculationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BEYOND"/>
 *     &lt;enumeration value="LINE_ITEMS"/>
 *     &lt;enumeration value="UNIT_PRICING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreightBaseChargeCalculationType")
@XmlEnum
public enum FreightBaseChargeCalculationType {

    BEYOND,
    LINE_ITEMS,
    UNIT_PRICING;

    public String value() {
        return name();
    }

    public static FreightBaseChargeCalculationType fromValue(String v) {
        return valueOf(v);
    }

}
