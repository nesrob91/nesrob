
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DropoffType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DropoffType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BUSINESS_SERVICE_CENTER"/>
 *     &lt;enumeration value="DROP_BOX"/>
 *     &lt;enumeration value="REGULAR_PICKUP"/>
 *     &lt;enumeration value="REQUEST_COURIER"/>
 *     &lt;enumeration value="STATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DropoffType")
@XmlEnum
public enum DropoffType {

    BUSINESS_SERVICE_CENTER,
    DROP_BOX,
    REGULAR_PICKUP,
    REQUEST_COURIER,
    STATION;

    public String value() {
        return name();
    }

    public static DropoffType fromValue(String v) {
        return valueOf(v);
    }

}
