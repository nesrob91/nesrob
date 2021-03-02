
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityAttributeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityAttributeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_SUBJECT_TO_REGULATIONS"/>
 *     &lt;enumeration value="PLACARDED_VEHICLE_REQUIRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityAttributeType")
@XmlEnum
public enum HazardousCommodityAttributeType {

    NOT_SUBJECT_TO_REGULATIONS,
    PLACARDED_VEHICLE_REQUIRED;

    public String value() {
        return name();
    }

    public static HazardousCommodityAttributeType fromValue(String v) {
        return valueOf(v);
    }

}
