
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousContainerPackingType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousContainerPackingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL_PACKED_IN_ONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousContainerPackingType")
@XmlEnum
public enum HazardousContainerPackingType {

    ALL_PACKED_IN_ONE;

    public String value() {
        return name();
    }

    public static HazardousContainerPackingType fromValue(String v) {
        return valueOf(v);
    }

}
