
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DangerousGoodsPackingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DangerousGoodsPackingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OVERPACK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DangerousGoodsPackingOptionType")
@XmlEnum
public enum DangerousGoodsPackingOptionType {

    OVERPACK;

    public String value() {
        return name();
    }

    public static DangerousGoodsPackingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
