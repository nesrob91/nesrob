
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityDescriptionProcessingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityDescriptionProcessingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCLUDE_SPECIAL_PROVISIONS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityDescriptionProcessingOptionType")
@XmlEnum
public enum HazardousCommodityDescriptionProcessingOptionType {

    INCLUDE_SPECIAL_PROVISIONS;

    public String value() {
        return name();
    }

    public static HazardousCommodityDescriptionProcessingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
