
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ImageSizeType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ImageSizeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LARGE"/>
 *     &lt;enumeration value="SMALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ImageSizeType")
@XmlEnum
public enum ImageSizeType {

    LARGE,
    SMALL;

    public String value() {
        return name();
    }

    public static ImageSizeType fromValue(String v) {
        return valueOf(v);
    }

}
