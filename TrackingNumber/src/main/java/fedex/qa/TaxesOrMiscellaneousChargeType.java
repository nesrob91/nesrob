
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TaxesOrMiscellaneousChargeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxesOrMiscellaneousChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMMISSIONS"/>
 *     &lt;enumeration value="DISCOUNTS"/>
 *     &lt;enumeration value="HANDLING_FEES"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="ROYALTIES_AND_LICENSE_FEES"/>
 *     &lt;enumeration value="TAXES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxesOrMiscellaneousChargeType")
@XmlEnum
public enum TaxesOrMiscellaneousChargeType {

    COMMISSIONS,
    DISCOUNTS,
    HANDLING_FEES,
    OTHER,
    ROYALTIES_AND_LICENSE_FEES,
    TAXES;

    public String value() {
        return name();
    }

    public static TaxesOrMiscellaneousChargeType fromValue(String v) {
        return valueOf(v);
    }

}
