
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RatedWeightMethod.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RatedWeightMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTUAL"/>
 *     &lt;enumeration value="AVERAGE_PACKAGE_WEIGHT_MINIMUM"/>
 *     &lt;enumeration value="BALLOON"/>
 *     &lt;enumeration value="DEFAULT_WEIGHT_APPLIED"/>
 *     &lt;enumeration value="DIM"/>
 *     &lt;enumeration value="FREIGHT_MINIMUM"/>
 *     &lt;enumeration value="MIXED"/>
 *     &lt;enumeration value="OVERSIZE"/>
 *     &lt;enumeration value="OVERSIZE_1"/>
 *     &lt;enumeration value="OVERSIZE_2"/>
 *     &lt;enumeration value="OVERSIZE_3"/>
 *     &lt;enumeration value="PACKAGING_MINIMUM"/>
 *     &lt;enumeration value="WEIGHT_BREAK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RatedWeightMethod")
@XmlEnum
public enum RatedWeightMethod {

    ACTUAL,
    AVERAGE_PACKAGE_WEIGHT_MINIMUM,
    BALLOON,
    DEFAULT_WEIGHT_APPLIED,
    DIM,
    FREIGHT_MINIMUM,
    MIXED,
    OVERSIZE,
    OVERSIZE_1,
    OVERSIZE_2,
    OVERSIZE_3,
    PACKAGING_MINIMUM,
    WEIGHT_BREAK;

    public String value() {
        return name();
    }

    public static RatedWeightMethod fromValue(String v) {
        return valueOf(v);
    }

}
