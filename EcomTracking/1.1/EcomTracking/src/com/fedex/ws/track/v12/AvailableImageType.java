
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AvailableImageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="AvailableImageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BILL_OF_LADING"/>
 *     &lt;enumeration value="SIGNATURE_PROOF_OF_DELIVERY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AvailableImageType")
@XmlEnum
public enum AvailableImageType {

    BILL_OF_LADING,
    SIGNATURE_PROOF_OF_DELIVERY;

    public String value() {
        return name();
    }

    public static AvailableImageType fromValue(String v) {
        return valueOf(v);
    }

}
