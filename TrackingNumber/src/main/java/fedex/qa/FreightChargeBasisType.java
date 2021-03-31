
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FreightChargeBasisType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="FreightChargeBasisType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CWT"/>
 *     &lt;enumeration value="FLAT"/>
 *     &lt;enumeration value="MINIMUM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreightChargeBasisType")
@XmlEnum
public enum FreightChargeBasisType {

    CWT,
    FLAT,
    MINIMUM;

    public String value() {
        return name();
    }

    public static FreightChargeBasisType fromValue(String v) {
        return valueOf(v);
    }

}
