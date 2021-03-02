
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DistanceUnits.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DistanceUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KM"/>
 *     &lt;enumeration value="MI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistanceUnits")
@XmlEnum
public enum DistanceUnits {

    KM,
    MI;

    public String value() {
        return name();
    }

    public static DistanceUnits fromValue(String v) {
        return valueOf(v);
    }

}
