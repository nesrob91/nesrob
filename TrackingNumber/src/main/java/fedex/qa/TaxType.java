
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TaxType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXPORT"/>
 *     &lt;enumeration value="GST"/>
 *     &lt;enumeration value="HST"/>
 *     &lt;enumeration value="INTRACOUNTRY"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PST"/>
 *     &lt;enumeration value="VAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxType")
@XmlEnum
public enum TaxType {

    EXPORT,
    GST,
    HST,
    INTRACOUNTRY,
    OTHER,
    PST,
    VAT;

    public String value() {
        return name();
    }

    public static TaxType fromValue(String v) {
        return valueOf(v);
    }

}
