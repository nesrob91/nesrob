
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GroundDeliveryEligibilityType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="GroundDeliveryEligibilityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALTERNATE_DAY_SERVICE"/>
 *     &lt;enumeration value="CARTAGE_AGENT_DELIVERY"/>
 *     &lt;enumeration value="SATURDAY_DELIVERY"/>
 *     &lt;enumeration value="USPS_DELIVERY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GroundDeliveryEligibilityType")
@XmlEnum
public enum GroundDeliveryEligibilityType {

    ALTERNATE_DAY_SERVICE,
    CARTAGE_AGENT_DELIVERY,
    SATURDAY_DELIVERY,
    USPS_DELIVERY;

    public String value() {
        return name();
    }

    public static GroundDeliveryEligibilityType fromValue(String v) {
        return valueOf(v);
    }

}
