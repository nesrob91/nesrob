
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackReturnMovementStatusType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackReturnMovementStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MOVEMENT_OCCURRED"/>
 *     &lt;enumeration value="NO_MOVEMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackReturnMovementStatusType")
@XmlEnum
public enum TrackReturnMovementStatusType {

    MOVEMENT_OCCURRED,
    NO_MOVEMENT;

    public String value() {
        return name();
    }

    public static TrackReturnMovementStatusType fromValue(String v) {
        return valueOf(v);
    }

}
