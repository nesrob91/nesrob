
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OfficeOrderDeliveryMethodType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="OfficeOrderDeliveryMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COURIER"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PICKUP"/>
 *     &lt;enumeration value="SHIPMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OfficeOrderDeliveryMethodType")
@XmlEnum
public enum OfficeOrderDeliveryMethodType {

    COURIER,
    OTHER,
    PICKUP,
    SHIPMENT;

    public String value() {
        return name();
    }

    public static OfficeOrderDeliveryMethodType fromValue(String v) {
        return valueOf(v);
    }

}
