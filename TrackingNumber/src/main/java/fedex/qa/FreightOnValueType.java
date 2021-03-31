
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FreightOnValueType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="FreightOnValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CARRIER_RISK"/>
 *     &lt;enumeration value="OWN_RISK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreightOnValueType")
@XmlEnum
public enum FreightOnValueType {

    CARRIER_RISK,
    OWN_RISK;

    public String value() {
        return name();
    }

    public static FreightOnValueType fromValue(String v) {
        return valueOf(v);
    }

}
