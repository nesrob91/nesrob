
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SmartPostAncillaryEndorsementType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SmartPostAncillaryEndorsementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADDRESS_CORRECTION"/>
 *     &lt;enumeration value="CARRIER_LEAVE_IF_NO_RESPONSE"/>
 *     &lt;enumeration value="CHANGE_SERVICE"/>
 *     &lt;enumeration value="FORWARDING_SERVICE"/>
 *     &lt;enumeration value="RETURN_SERVICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SmartPostAncillaryEndorsementType")
@XmlEnum
public enum SmartPostAncillaryEndorsementType {

    ADDRESS_CORRECTION,
    CARRIER_LEAVE_IF_NO_RESPONSE,
    CHANGE_SERVICE,
    FORWARDING_SERVICE,
    RETURN_SERVICE;

    public String value() {
        return name();
    }

    public static SmartPostAncillaryEndorsementType fromValue(String v) {
        return valueOf(v);
    }

}
