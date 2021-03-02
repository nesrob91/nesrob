
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackPossessionStatusType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackPossessionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BROKER"/>
 *     &lt;enumeration value="CARRIER"/>
 *     &lt;enumeration value="CUSTOMS"/>
 *     &lt;enumeration value="RECIPIENT"/>
 *     &lt;enumeration value="SHIPPER"/>
 *     &lt;enumeration value="SPLIT_STATUS"/>
 *     &lt;enumeration value="TRANSFER_PARTNER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackPossessionStatusType")
@XmlEnum
public enum TrackPossessionStatusType {

    BROKER,
    CARRIER,
    CUSTOMS,
    RECIPIENT,
    SHIPPER,
    SPLIT_STATUS,
    TRANSFER_PARTNER;

    public String value() {
        return name();
    }

    public static TrackPossessionStatusType fromValue(String v) {
        return valueOf(v);
    }

}
