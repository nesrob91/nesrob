
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RateElementBasisType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RateElementBasisType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BASE_CHARGE"/>
 *     &lt;enumeration value="NET_CHARGE"/>
 *     &lt;enumeration value="NET_CHARGE_EXCLUDING_TAXES"/>
 *     &lt;enumeration value="NET_FREIGHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RateElementBasisType")
@XmlEnum
public enum RateElementBasisType {

    BASE_CHARGE,
    NET_CHARGE,
    NET_CHARGE_EXCLUDING_TAXES,
    NET_FREIGHT;

    public String value() {
        return name();
    }

    public static RateElementBasisType fromValue(String v) {
        return valueOf(v);
    }

}
