
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SurchargeLevelType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SurchargeLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PACKAGE"/>
 *     &lt;enumeration value="SHIPMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SurchargeLevelType")
@XmlEnum
public enum SurchargeLevelType {

    PACKAGE,
    SHIPMENT;

    public String value() {
        return name();
    }

    public static SurchargeLevelType fromValue(String v) {
        return valueOf(v);
    }

}
