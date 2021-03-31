
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VolumeUnits.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="VolumeUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUBIC_FT"/>
 *     &lt;enumeration value="CUBIC_M"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VolumeUnits")
@XmlEnum
public enum VolumeUnits {

    CUBIC_FT,
    CUBIC_M;

    public String value() {
        return name();
    }

    public static VolumeUnits fromValue(String v) {
        return valueOf(v);
    }

}
