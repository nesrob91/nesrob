
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ReturnEMailAllowedSpecialServiceType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ReturnEMailAllowedSpecialServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SATURDAY_DELIVERY"/>
 *     &lt;enumeration value="SATURDAY_PICKUP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReturnEMailAllowedSpecialServiceType")
@XmlEnum
public enum ReturnEMailAllowedSpecialServiceType {

    SATURDAY_DELIVERY,
    SATURDAY_PICKUP;

    public String value() {
        return name();
    }

    public static ReturnEMailAllowedSpecialServiceType fromValue(String v) {
        return valueOf(v);
    }

}
