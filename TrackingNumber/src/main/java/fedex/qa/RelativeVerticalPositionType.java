
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RelativeVerticalPositionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RelativeVerticalPositionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABOVE"/>
 *     &lt;enumeration value="BELOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelativeVerticalPositionType")
@XmlEnum
public enum RelativeVerticalPositionType {

    ABOVE,
    BELOW;

    public String value() {
        return name();
    }

    public static RelativeVerticalPositionType fromValue(String v) {
        return valueOf(v);
    }

}
