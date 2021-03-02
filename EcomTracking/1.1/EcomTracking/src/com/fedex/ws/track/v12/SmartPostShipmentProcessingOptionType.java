
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SmartPostShipmentProcessingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SmartPostShipmentProcessingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GROUND_TRACKING_NUMBER_REQUESTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SmartPostShipmentProcessingOptionType")
@XmlEnum
public enum SmartPostShipmentProcessingOptionType {

    GROUND_TRACKING_NUMBER_REQUESTED;

    public String value() {
        return name();
    }

    public static SmartPostShipmentProcessingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
