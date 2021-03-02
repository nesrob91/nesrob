
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RecipientCustomsIdType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RecipientCustomsIdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPANY"/>
 *     &lt;enumeration value="INDIVIDUAL"/>
 *     &lt;enumeration value="PASSPORT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecipientCustomsIdType")
@XmlEnum
public enum RecipientCustomsIdType {

    COMPANY,
    INDIVIDUAL,
    PASSPORT;

    public String value() {
        return name();
    }

    public static RecipientCustomsIdType fromValue(String v) {
        return valueOf(v);
    }

}
