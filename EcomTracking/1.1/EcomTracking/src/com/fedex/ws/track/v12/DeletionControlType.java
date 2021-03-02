
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DeletionControlType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DeletionControlType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DELETE_ALL_PACKAGES"/>
 *     &lt;enumeration value="DELETE_ENTIRE_CONSOLIDATION"/>
 *     &lt;enumeration value="DELETE_ONE_PACKAGE"/>
 *     &lt;enumeration value="LEGACY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeletionControlType")
@XmlEnum
public enum DeletionControlType {

    DELETE_ALL_PACKAGES,
    DELETE_ENTIRE_CONSOLIDATION,
    DELETE_ONE_PACKAGE,
    LEGACY;

    public String value() {
        return name();
    }

    public static DeletionControlType fromValue(String v) {
        return valueOf(v);
    }

}
