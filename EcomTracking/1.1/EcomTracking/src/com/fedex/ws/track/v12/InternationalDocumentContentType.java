
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InternationalDocumentContentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="InternationalDocumentContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DERIVED"/>
 *     &lt;enumeration value="DOCUMENTS_ONLY"/>
 *     &lt;enumeration value="NON_DOCUMENTS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InternationalDocumentContentType")
@XmlEnum
public enum InternationalDocumentContentType {

    DERIVED,
    DOCUMENTS_ONLY,
    NON_DOCUMENTS;

    public String value() {
        return name();
    }

    public static InternationalDocumentContentType fromValue(String v) {
        return valueOf(v);
    }

}
