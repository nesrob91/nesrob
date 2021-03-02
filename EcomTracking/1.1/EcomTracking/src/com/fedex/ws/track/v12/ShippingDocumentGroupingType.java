
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShippingDocumentGroupingType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ShippingDocumentGroupingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONSOLIDATED_BY_DOCUMENT_TYPE"/>
 *     &lt;enumeration value="INDIVIDUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ShippingDocumentGroupingType")
@XmlEnum
public enum ShippingDocumentGroupingType {

    CONSOLIDATED_BY_DOCUMENT_TYPE,
    INDIVIDUAL;

    public String value() {
        return name();
    }

    public static ShippingDocumentGroupingType fromValue(String v) {
        return valueOf(v);
    }

}
