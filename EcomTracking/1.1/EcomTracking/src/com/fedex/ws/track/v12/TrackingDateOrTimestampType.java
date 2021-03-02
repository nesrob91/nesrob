
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackingDateOrTimestampType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackingDateOrTimestampType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTUAL_DELIVERY"/>
 *     &lt;enumeration value="ACTUAL_PICKUP"/>
 *     &lt;enumeration value="ACTUAL_TENDER"/>
 *     &lt;enumeration value="ANTICIPATED_TENDER"/>
 *     &lt;enumeration value="APPOINTMENT_DELIVERY"/>
 *     &lt;enumeration value="ESTIMATED_DELIVERY"/>
 *     &lt;enumeration value="ESTIMATED_PICKUP"/>
 *     &lt;enumeration value="SHIP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackingDateOrTimestampType")
@XmlEnum
public enum TrackingDateOrTimestampType {

    ACTUAL_DELIVERY,
    ACTUAL_PICKUP,
    ACTUAL_TENDER,
    ANTICIPATED_TENDER,
    APPOINTMENT_DELIVERY,
    ESTIMATED_DELIVERY,
    ESTIMATED_PICKUP,
    SHIP;

    public String value() {
        return name();
    }

    public static TrackingDateOrTimestampType fromValue(String v) {
        return valueOf(v);
    }

}
