
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackRequestProcessingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackRequestProcessingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCLUDE_DETAILED_SCANS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackRequestProcessingOptionType")
@XmlEnum
public enum TrackRequestProcessingOptionType {

    INCLUDE_DETAILED_SCANS;

    public String value() {
        return name();
    }

    public static TrackRequestProcessingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
