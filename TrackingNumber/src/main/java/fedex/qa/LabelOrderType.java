
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LabelOrderType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="LabelOrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHIPPING_LABEL_FIRST"/>
 *     &lt;enumeration value="SHIPPING_LABEL_LAST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LabelOrderType")
@XmlEnum
public enum LabelOrderType {

    SHIPPING_LABEL_FIRST,
    SHIPPING_LABEL_LAST;

    public String value() {
        return name();
    }

    public static LabelOrderType fromValue(String v) {
        return valueOf(v);
    }

}
