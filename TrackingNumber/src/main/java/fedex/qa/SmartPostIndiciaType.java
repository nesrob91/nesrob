
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SmartPostIndiciaType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SmartPostIndiciaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MEDIA_MAIL"/>
 *     &lt;enumeration value="PARCEL_RETURN"/>
 *     &lt;enumeration value="PARCEL_SELECT"/>
 *     &lt;enumeration value="PRESORTED_BOUND_PRINTED_MATTER"/>
 *     &lt;enumeration value="PRESORTED_STANDARD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SmartPostIndiciaType")
@XmlEnum
public enum SmartPostIndiciaType {

    MEDIA_MAIL,
    PARCEL_RETURN,
    PARCEL_SELECT,
    PRESORTED_BOUND_PRINTED_MATTER,
    PRESORTED_STANDARD;

    public String value() {
        return name();
    }

    public static SmartPostIndiciaType fromValue(String v) {
        return valueOf(v);
    }

}
