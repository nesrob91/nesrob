
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LiabilityCoverageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="LiabilityCoverageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="USED_OR_RECONDITIONED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LiabilityCoverageType")
@XmlEnum
public enum LiabilityCoverageType {

    NEW,
    USED_OR_RECONDITIONED;

    public String value() {
        return name();
    }

    public static LiabilityCoverageType fromValue(String v) {
        return valueOf(v);
    }

}
