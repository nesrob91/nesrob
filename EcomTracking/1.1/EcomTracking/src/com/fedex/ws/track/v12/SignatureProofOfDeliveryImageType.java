
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SignatureProofOfDeliveryImageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SignatureProofOfDeliveryImageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="PNG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SignatureProofOfDeliveryImageType")
@XmlEnum
public enum SignatureProofOfDeliveryImageType {

    PDF,
    PNG;

    public String value() {
        return name();
    }

    public static SignatureProofOfDeliveryImageType fromValue(String v) {
        return valueOf(v);
    }

}
