
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PageQuadrantType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PageQuadrantType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BOTTOM_LEFT"/>
 *     &lt;enumeration value="BOTTOM_RIGHT"/>
 *     &lt;enumeration value="TOP_LEFT"/>
 *     &lt;enumeration value="TOP_RIGHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PageQuadrantType")
@XmlEnum
public enum PageQuadrantType {

    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    TOP_LEFT,
    TOP_RIGHT;

    public String value() {
        return name();
    }

    public static PageQuadrantType fromValue(String v) {
        return valueOf(v);
    }

}
