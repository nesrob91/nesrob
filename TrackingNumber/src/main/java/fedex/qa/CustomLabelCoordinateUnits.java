
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomLabelCoordinateUnits.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomLabelCoordinateUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MILS"/>
 *     &lt;enumeration value="PIXELS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomLabelCoordinateUnits")
@XmlEnum
public enum CustomLabelCoordinateUnits {

    MILS,
    PIXELS;

    public String value() {
        return name();
    }

    public static CustomLabelCoordinateUnits fromValue(String v) {
        return valueOf(v);
    }

}
