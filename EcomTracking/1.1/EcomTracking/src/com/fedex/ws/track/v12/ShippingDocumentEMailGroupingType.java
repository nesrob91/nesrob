
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShippingDocumentEMailGroupingType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ShippingDocumentEMailGroupingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BY_RECIPIENT"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ShippingDocumentEMailGroupingType")
@XmlEnum
public enum ShippingDocumentEMailGroupingType {

    BY_RECIPIENT,
    NONE;

    public String value() {
        return name();
    }

    public static ShippingDocumentEMailGroupingType fromValue(String v) {
        return valueOf(v);
    }

}
