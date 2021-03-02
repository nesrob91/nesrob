
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomsRoleType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomsRoleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXPORTER"/>
 *     &lt;enumeration value="IMPORTER"/>
 *     &lt;enumeration value="LEGAL_AGENT"/>
 *     &lt;enumeration value="PRODUCER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomsRoleType")
@XmlEnum
public enum CustomsRoleType {

    EXPORTER,
    IMPORTER,
    LEGAL_AGENT,
    PRODUCER;

    public String value() {
        return name();
    }

    public static CustomsRoleType fromValue(String v) {
        return valueOf(v);
    }

}
