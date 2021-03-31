
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ChargeBasisLevelType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ChargeBasisLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CURRENT_PACKAGE"/>
 *     &lt;enumeration value="SUM_OF_PACKAGES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChargeBasisLevelType")
@XmlEnum
public enum ChargeBasisLevelType {

    CURRENT_PACKAGE,
    SUM_OF_PACKAGES;

    public String value() {
        return name();
    }

    public static ChargeBasisLevelType fromValue(String v) {
        return valueOf(v);
    }

}
