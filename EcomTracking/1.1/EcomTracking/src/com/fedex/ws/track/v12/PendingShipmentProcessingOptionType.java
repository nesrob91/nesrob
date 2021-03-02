
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PendingShipmentProcessingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PendingShipmentProcessingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALLOW_MODIFICATIONS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PendingShipmentProcessingOptionType")
@XmlEnum
public enum PendingShipmentProcessingOptionType {

    ALLOW_MODIFICATIONS;

    public String value() {
        return name();
    }

    public static PendingShipmentProcessingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
