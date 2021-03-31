
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BrokerType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="BrokerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXPORT"/>
 *     &lt;enumeration value="IMPORT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BrokerType")
@XmlEnum
public enum BrokerType {

    EXPORT,
    IMPORT;

    public String value() {
        return name();
    }

    public static BrokerType fromValue(String v) {
        return valueOf(v);
    }

}
