
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClearanceBrokerageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ClearanceBrokerageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BROKER_INCLUSIVE"/>
 *     &lt;enumeration value="BROKER_INCLUSIVE_NON_RESIDENT_IMPORTER"/>
 *     &lt;enumeration value="BROKER_SELECT"/>
 *     &lt;enumeration value="BROKER_SELECT_NON_RESIDENT_IMPORTER"/>
 *     &lt;enumeration value="BROKER_UNASSIGNED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClearanceBrokerageType")
@XmlEnum
public enum ClearanceBrokerageType {

    BROKER_INCLUSIVE,
    BROKER_INCLUSIVE_NON_RESIDENT_IMPORTER,
    BROKER_SELECT,
    BROKER_SELECT_NON_RESIDENT_IMPORTER,
    BROKER_UNASSIGNED;

    public String value() {
        return name();
    }

    public static ClearanceBrokerageType fromValue(String v) {
        return valueOf(v);
    }

}
