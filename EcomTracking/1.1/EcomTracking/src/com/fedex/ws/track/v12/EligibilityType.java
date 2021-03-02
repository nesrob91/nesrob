
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EligibilityType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EligibilityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ELIGIBLE"/>
 *     &lt;enumeration value="INELIGIBLE"/>
 *     &lt;enumeration value="POSSIBLY_ELIGIBLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EligibilityType")
@XmlEnum
public enum EligibilityType {

    ELIGIBLE,
    INELIGIBLE,
    POSSIBLY_ELIGIBLE;

    public String value() {
        return name();
    }

    public static EligibilityType fromValue(String v) {
        return valueOf(v);
    }

}
