
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TrackChargesPaymentClassificationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackChargesPaymentClassificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DUTIES_AND_TAXES"/>
 *     &lt;enumeration value="TRANSPORTATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackChargesPaymentClassificationType")
@XmlEnum
public enum TrackChargesPaymentClassificationType {

    DUTIES_AND_TAXES,
    TRANSPORTATION;

    public String value() {
        return name();
    }

    public static TrackChargesPaymentClassificationType fromValue(String v) {
        return valueOf(v);
    }

}
