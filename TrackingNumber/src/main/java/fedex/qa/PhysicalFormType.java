
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PhysicalFormType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalFormType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GAS"/>
 *     &lt;enumeration value="LIQUID"/>
 *     &lt;enumeration value="SOLID"/>
 *     &lt;enumeration value="SPECIAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalFormType")
@XmlEnum
public enum PhysicalFormType {

    GAS,
    LIQUID,
    SOLID,
    SPECIAL;

    public String value() {
        return name();
    }

    public static PhysicalFormType fromValue(String v) {
        return valueOf(v);
    }

}
