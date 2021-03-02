
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackAdvanceNotificationStatusType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackAdvanceNotificationStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BACK_ON_TRACK"/>
 *     &lt;enumeration value="FAIL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackAdvanceNotificationStatusType")
@XmlEnum
public enum TrackAdvanceNotificationStatusType {

    BACK_ON_TRACK,
    FAIL;

    public String value() {
        return name();
    }

    public static TrackAdvanceNotificationStatusType fromValue(String v) {
        return valueOf(v);
    }

}
