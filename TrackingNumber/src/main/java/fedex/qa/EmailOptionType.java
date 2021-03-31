
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EmailOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EmailOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUPPRESS_ACCESS_EMAILS"/>
 *     &lt;enumeration value="SUPPRESS_ADDITIONAL_LANGUAGES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EmailOptionType")
@XmlEnum
public enum EmailOptionType {

    SUPPRESS_ACCESS_EMAILS,
    SUPPRESS_ADDITIONAL_LANGUAGES;

    public String value() {
        return name();
    }

    public static EmailOptionType fromValue(String v) {
        return valueOf(v);
    }

}
