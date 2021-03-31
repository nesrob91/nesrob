
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReturnType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ReturnType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FEDEX_TAG"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="PRINT_RETURN_LABEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReturnType")
@XmlEnum
public enum ReturnType {

    FEDEX_TAG,
    PENDING,
    PRINT_RETURN_LABEL;

    public String value() {
        return name();
    }

    public static ReturnType fromValue(String v) {
        return valueOf(v);
    }

}
