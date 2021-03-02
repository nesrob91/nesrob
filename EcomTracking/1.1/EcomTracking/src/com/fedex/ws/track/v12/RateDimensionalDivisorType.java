
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RateDimensionalDivisorType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RateDimensionalDivisorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COUNTRY"/>
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PRODUCT"/>
 *     &lt;enumeration value="WAIVED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RateDimensionalDivisorType")
@XmlEnum
public enum RateDimensionalDivisorType {

    COUNTRY,
    CUSTOMER,
    OTHER,
    PRODUCT,
    WAIVED;

    public String value() {
        return name();
    }

    public static RateDimensionalDivisorType fromValue(String v) {
        return valueOf(v);
    }

}
