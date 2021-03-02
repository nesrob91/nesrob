
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PickupRequestType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PickupRequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FUTURE_DAY"/>
 *     &lt;enumeration value="SAME_DAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PickupRequestType")
@XmlEnum
public enum PickupRequestType {

    FUTURE_DAY,
    SAME_DAY;

    public String value() {
        return name();
    }

    public static PickupRequestType fromValue(String v) {
        return valueOf(v);
    }

}
