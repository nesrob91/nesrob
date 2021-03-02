
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityPackingGroupType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityPackingGroupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="II"/>
 *     &lt;enumeration value="III"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityPackingGroupType")
@XmlEnum
public enum HazardousCommodityPackingGroupType {

    DEFAULT,
    I,
    II,
    III;

    public String value() {
        return name();
    }

    public static HazardousCommodityPackingGroupType fromValue(String v) {
        return valueOf(v);
    }

}
