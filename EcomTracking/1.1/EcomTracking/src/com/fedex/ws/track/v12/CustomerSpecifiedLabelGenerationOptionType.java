
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CustomerSpecifiedLabelGenerationOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerSpecifiedLabelGenerationOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONTENT_ON_SHIPPING_LABEL_ONLY"/>
 *     &lt;enumeration value="CONTENT_ON_SHIPPING_LABEL_PREFERRED"/>
 *     &lt;enumeration value="CONTENT_ON_SUPPLEMENTAL_LABEL_ONLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerSpecifiedLabelGenerationOptionType")
@XmlEnum
public enum CustomerSpecifiedLabelGenerationOptionType {

    CONTENT_ON_SHIPPING_LABEL_ONLY,
    CONTENT_ON_SHIPPING_LABEL_PREFERRED,
    CONTENT_ON_SUPPLEMENTAL_LABEL_ONLY;

    public String value() {
        return name();
    }

    public static CustomerSpecifiedLabelGenerationOptionType fromValue(String v) {
        return valueOf(v);
    }

}
