
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomsOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomsOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COURTESY_RETURN_LABEL"/>
 *     &lt;enumeration value="EXHIBITION_TRADE_SHOW"/>
 *     &lt;enumeration value="FAULTY_ITEM"/>
 *     &lt;enumeration value="FOLLOWING_REPAIR"/>
 *     &lt;enumeration value="FOR_REPAIR"/>
 *     &lt;enumeration value="ITEM_FOR_LOAN"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="REJECTED"/>
 *     &lt;enumeration value="REPLACEMENT"/>
 *     &lt;enumeration value="TRIAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomsOptionType")
@XmlEnum
public enum CustomsOptionType {

    COURTESY_RETURN_LABEL,
    EXHIBITION_TRADE_SHOW,
    FAULTY_ITEM,
    FOLLOWING_REPAIR,
    FOR_REPAIR,
    ITEM_FOR_LOAN,
    OTHER,
    REJECTED,
    REPLACEMENT,
    TRIAL;

    public String value() {
        return name();
    }

    public static CustomsOptionType fromValue(String v) {
        return valueOf(v);
    }

}
