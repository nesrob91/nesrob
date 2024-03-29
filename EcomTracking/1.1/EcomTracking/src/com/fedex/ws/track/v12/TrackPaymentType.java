
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackPaymentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackPaymentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CASH_OR_CHECK_AT_DESTINATION"/>
 *     &lt;enumeration value="CASH_OR_CHECK_AT_ORIGIN"/>
 *     &lt;enumeration value="CREDIT_CARD_AT_DESTINATION"/>
 *     &lt;enumeration value="CREDIT_CARD_AT_ORIGIN"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="RECIPIENT_ACCOUNT"/>
 *     &lt;enumeration value="SHIPPER_ACCOUNT"/>
 *     &lt;enumeration value="THIRD_PARTY_ACCOUNT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackPaymentType")
@XmlEnum
public enum TrackPaymentType {

    CASH_OR_CHECK_AT_DESTINATION,
    CASH_OR_CHECK_AT_ORIGIN,
    CREDIT_CARD_AT_DESTINATION,
    CREDIT_CARD_AT_ORIGIN,
    OTHER,
    RECIPIENT_ACCOUNT,
    SHIPPER_ACCOUNT,
    THIRD_PARTY_ACCOUNT;

    public String value() {
        return name();
    }

    public static TrackPaymentType fromValue(String v) {
        return valueOf(v);
    }

}
