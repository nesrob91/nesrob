
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PieceCountLocationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PieceCountLocationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DESTINATION"/>
 *     &lt;enumeration value="ORIGIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PieceCountLocationType")
@XmlEnum
public enum PieceCountLocationType {

    DESTINATION,
    ORIGIN;

    public String value() {
        return name();
    }

    public static PieceCountLocationType fromValue(String v) {
        return valueOf(v);
    }

}
