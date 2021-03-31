
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SpecialRatingAppliedType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SpecialRatingAppliedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FEDEX_ONE_RATE"/>
 *     &lt;enumeration value="FIXED_FUEL_SURCHARGE"/>
 *     &lt;enumeration value="IMPORT_PRICING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpecialRatingAppliedType")
@XmlEnum
public enum SpecialRatingAppliedType {

    FEDEX_ONE_RATE,
    FIXED_FUEL_SURCHARGE,
    IMPORT_PRICING;

    public String value() {
        return name();
    }

    public static SpecialRatingAppliedType fromValue(String v) {
        return valueOf(v);
    }

}
