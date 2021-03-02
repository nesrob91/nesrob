
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShipmentNotificationAggregationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ShipmentNotificationAggregationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PER_PACKAGE"/>
 *     &lt;enumeration value="PER_SHIPMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ShipmentNotificationAggregationType")
@XmlEnum
public enum ShipmentNotificationAggregationType {

    PER_PACKAGE,
    PER_SHIPMENT;

    public String value() {
        return name();
    }

    public static ShipmentNotificationAggregationType fromValue(String v) {
        return valueOf(v);
    }

}
