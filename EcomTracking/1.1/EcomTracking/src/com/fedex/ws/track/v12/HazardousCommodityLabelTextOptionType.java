
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityLabelTextOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityLabelTextOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPEND"/>
 *     &lt;enumeration value="OVERRIDE"/>
 *     &lt;enumeration value="STANDARD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityLabelTextOptionType")
@XmlEnum
public enum HazardousCommodityLabelTextOptionType {

    APPEND,
    OVERRIDE,
    STANDARD;

    public String value() {
        return name();
    }

    public static HazardousCommodityLabelTextOptionType fromValue(String v) {
        return valueOf(v);
    }

}
