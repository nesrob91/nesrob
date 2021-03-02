
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AppointmentWindowType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="AppointmentWindowType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AFTERNOON"/>
 *     &lt;enumeration value="LATE_AFTERNOON"/>
 *     &lt;enumeration value="MID_DAY"/>
 *     &lt;enumeration value="MORNING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AppointmentWindowType")
@XmlEnum
public enum AppointmentWindowType {

    AFTERNOON,
    LATE_AFTERNOON,
    MID_DAY,
    MORNING;

    public String value() {
        return name();
    }

    public static AppointmentWindowType fromValue(String v) {
        return valueOf(v);
    }

}