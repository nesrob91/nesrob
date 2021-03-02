
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NaftaNetCostMethodCode.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NaftaNetCostMethodCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NC"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NaftaNetCostMethodCode")
@XmlEnum
public enum NaftaNetCostMethodCode {

    NC,
    NO;

    public String value() {
        return name();
    }

    public static NaftaNetCostMethodCode fromValue(String v) {
        return valueOf(v);
    }

}
