
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackChargeDetailType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackChargeDetailType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ORIGINAL_CHARGES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackChargeDetailType")
@XmlEnum
public enum TrackChargeDetailType {

    ORIGINAL_CHARGES;

    public String value() {
        return name();
    }

    public static TrackChargeDetailType fromValue(String v) {
        return valueOf(v);
    }

}
