
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PackageSpecialServiceType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PackageSpecialServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALCOHOL"/>
 *     &lt;enumeration value="APPOINTMENT_DELIVERY"/>
 *     &lt;enumeration value="COD"/>
 *     &lt;enumeration value="DANGEROUS_GOODS"/>
 *     &lt;enumeration value="DRY_ICE"/>
 *     &lt;enumeration value="NON_STANDARD_CONTAINER"/>
 *     &lt;enumeration value="PRIORITY_ALERT"/>
 *     &lt;enumeration value="SIGNATURE_OPTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PackageSpecialServiceType")
@XmlEnum
public enum PackageSpecialServiceType {

    ALCOHOL,
    APPOINTMENT_DELIVERY,
    COD,
    DANGEROUS_GOODS,
    DRY_ICE,
    NON_STANDARD_CONTAINER,
    PRIORITY_ALERT,
    SIGNATURE_OPTION;

    public String value() {
        return name();
    }

    public static PackageSpecialServiceType fromValue(String v) {
        return valueOf(v);
    }

}
