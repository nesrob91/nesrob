
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityQuantityType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityQuantityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GROSS"/>
 *     &lt;enumeration value="NET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityQuantityType")
@XmlEnum
public enum HazardousCommodityQuantityType {

    GROSS,
    NET;

    public String value() {
        return name();
    }

    public static HazardousCommodityQuantityType fromValue(String v) {
        return valueOf(v);
    }

}