
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackingIdType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackingIdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXPRESS"/>
 *     &lt;enumeration value="FEDEX"/>
 *     &lt;enumeration value="FREIGHT"/>
 *     &lt;enumeration value="GROUND"/>
 *     &lt;enumeration value="USPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackingIdType")
@XmlEnum
public enum TrackingIdType {

    EXPRESS,
    FEDEX,
    FREIGHT,
    GROUND,
    USPS;

    public String value() {
        return name();
    }

    public static TrackingIdType fromValue(String v) {
        return valueOf(v);
    }

}
