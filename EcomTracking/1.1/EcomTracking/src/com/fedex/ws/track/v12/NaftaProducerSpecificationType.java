
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NaftaProducerSpecificationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NaftaProducerSpecificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AVAILABLE_UPON_REQUEST"/>
 *     &lt;enumeration value="MULTIPLE_SPECIFIED"/>
 *     &lt;enumeration value="SAME"/>
 *     &lt;enumeration value="SINGLE_SPECIFIED"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NaftaProducerSpecificationType")
@XmlEnum
public enum NaftaProducerSpecificationType {

    AVAILABLE_UPON_REQUEST,
    MULTIPLE_SPECIFIED,
    SAME,
    SINGLE_SPECIFIED,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static NaftaProducerSpecificationType fromValue(String v) {
        return valueOf(v);
    }

}
