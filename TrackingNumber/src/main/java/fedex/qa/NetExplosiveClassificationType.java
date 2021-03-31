
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NetExplosiveClassificationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NetExplosiveClassificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NET_EXPLOSIVE_CONTENT"/>
 *     &lt;enumeration value="NET_EXPLOSIVE_MASS"/>
 *     &lt;enumeration value="NET_EXPLOSIVE_QUANTITY"/>
 *     &lt;enumeration value="NET_EXPLOSIVE_WEIGHT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NetExplosiveClassificationType")
@XmlEnum
public enum NetExplosiveClassificationType {

    NET_EXPLOSIVE_CONTENT,
    NET_EXPLOSIVE_MASS,
    NET_EXPLOSIVE_QUANTITY,
    NET_EXPLOSIVE_WEIGHT;

    public String value() {
        return name();
    }

    public static NetExplosiveClassificationType fromValue(String v) {
        return valueOf(v);
    }

}
