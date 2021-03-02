
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FreightGuaranteeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="FreightGuaranteeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GUARANTEED_DATE"/>
 *     &lt;enumeration value="GUARANTEED_MORNING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreightGuaranteeType")
@XmlEnum
public enum FreightGuaranteeType {

    GUARANTEED_DATE,
    GUARANTEED_MORNING;

    public String value() {
        return name();
    }

    public static FreightGuaranteeType fromValue(String v) {
        return valueOf(v);
    }

}
