
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RateTypeBasisType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RateTypeBasisType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCOUNT"/>
 *     &lt;enumeration value="LIST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RateTypeBasisType")
@XmlEnum
public enum RateTypeBasisType {

    ACCOUNT,
    LIST;

    public String value() {
        return name();
    }

    public static RateTypeBasisType fromValue(String v) {
        return valueOf(v);
    }

}
