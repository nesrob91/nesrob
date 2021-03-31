
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PriorityAlertEnhancementType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PriorityAlertEnhancementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRIORITY_ALERT_PLUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PriorityAlertEnhancementType")
@XmlEnum
public enum PriorityAlertEnhancementType {

    PRIORITY_ALERT_PLUS;

    public String value() {
        return name();
    }

    public static PriorityAlertEnhancementType fromValue(String v) {
        return valueOf(v);
    }

}
