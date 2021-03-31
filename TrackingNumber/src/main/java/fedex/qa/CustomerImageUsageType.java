
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomerImageUsageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerImageUsageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LETTER_HEAD"/>
 *     &lt;enumeration value="SIGNATURE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerImageUsageType")
@XmlEnum
public enum CustomerImageUsageType {

    LETTER_HEAD,
    SIGNATURE;

    public String value() {
        return name();
    }

    public static CustomerImageUsageType fromValue(String v) {
        return valueOf(v);
    }

}
