
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RegulatoryControlType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RegulatoryControlType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EU_CIRCULATION"/>
 *     &lt;enumeration value="FOOD_OR_PERISHABLE"/>
 *     &lt;enumeration value="NAFTA"/>
 *     &lt;enumeration value="NOT_APPLICABLE_FOR_LOW_CUSTOMS_VALUE_EXCEPTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RegulatoryControlType")
@XmlEnum
public enum RegulatoryControlType {

    EU_CIRCULATION,
    FOOD_OR_PERISHABLE,
    NAFTA,
    NOT_APPLICABLE_FOR_LOW_CUSTOMS_VALUE_EXCEPTION;

    public String value() {
        return name();
    }

    public static RegulatoryControlType fromValue(String v) {
        return valueOf(v);
    }

}
