
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RotationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RotationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LEFT"/>
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="RIGHT"/>
 *     &lt;enumeration value="UPSIDE_DOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RotationType")
@XmlEnum
public enum RotationType {

    LEFT,
    NONE,
    RIGHT,
    UPSIDE_DOWN;

    public String value() {
        return name();
    }

    public static RotationType fromValue(String v) {
        return valueOf(v);
    }

}
