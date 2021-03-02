
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DeliveryOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INDIRECT_SIGNATURE_RELEASE"/>
 *     &lt;enumeration value="REDIRECT_TO_HOLD_AT_LOCATION"/>
 *     &lt;enumeration value="REROUTE"/>
 *     &lt;enumeration value="RESCHEDULE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryOptionType")
@XmlEnum
public enum DeliveryOptionType {

    INDIRECT_SIGNATURE_RELEASE,
    REDIRECT_TO_HOLD_AT_LOCATION,
    REROUTE,
    RESCHEDULE;

    public String value() {
        return name();
    }

    public static DeliveryOptionType fromValue(String v) {
        return valueOf(v);
    }

}
