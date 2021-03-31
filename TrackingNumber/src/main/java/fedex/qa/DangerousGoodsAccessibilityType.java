
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DangerousGoodsAccessibilityType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DangerousGoodsAccessibilityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCESSIBLE"/>
 *     &lt;enumeration value="INACCESSIBLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DangerousGoodsAccessibilityType")
@XmlEnum
public enum DangerousGoodsAccessibilityType {

    ACCESSIBLE,
    INACCESSIBLE;

    public String value() {
        return name();
    }

    public static DangerousGoodsAccessibilityType fromValue(String v) {
        return valueOf(v);
    }

}
