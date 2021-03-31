
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DocTabZoneJustificationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DocTabZoneJustificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LEFT"/>
 *     &lt;enumeration value="RIGHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocTabZoneJustificationType")
@XmlEnum
public enum DocTabZoneJustificationType {

    LEFT,
    RIGHT;

    public String value() {
        return name();
    }

    public static DocTabZoneJustificationType fromValue(String v) {
        return valueOf(v);
    }

}
