
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para B13AFilingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="B13AFilingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FEDEX_TO_STAMP"/>
 *     &lt;enumeration value="FILED_ELECTRONICALLY"/>
 *     &lt;enumeration value="MANUALLY_ATTACHED"/>
 *     &lt;enumeration value="NOT_REQUIRED"/>
 *     &lt;enumeration value="SUMMARY_REPORTING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "B13AFilingOptionType")
@XmlEnum
public enum B13AFilingOptionType {

    FEDEX_TO_STAMP,
    FILED_ELECTRONICALLY,
    MANUALLY_ATTACHED,
    NOT_REQUIRED,
    SUMMARY_REPORTING;

    public String value() {
        return name();
    }

    public static B13AFilingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
