
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DocTabContentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DocTabContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BARCODED"/>
 *     &lt;enumeration value="CUSTOM"/>
 *     &lt;enumeration value="MINIMUM"/>
 *     &lt;enumeration value="STANDARD"/>
 *     &lt;enumeration value="ZONE001"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocTabContentType")
@XmlEnum
public enum DocTabContentType {

    BARCODED("BARCODED"),
    CUSTOM("CUSTOM"),
    MINIMUM("MINIMUM"),
    STANDARD("STANDARD"),
    @XmlEnumValue("ZONE001")
    ZONE_001("ZONE001");
    private final String value;

    DocTabContentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DocTabContentType fromValue(String v) {
        for (DocTabContentType c: DocTabContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
