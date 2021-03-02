
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NaftaImporterSpecificationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NaftaImporterSpecificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IMPORTER_OF_RECORD"/>
 *     &lt;enumeration value="RECIPIENT"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="VARIOUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NaftaImporterSpecificationType")
@XmlEnum
public enum NaftaImporterSpecificationType {

    IMPORTER_OF_RECORD,
    RECIPIENT,
    UNKNOWN,
    VARIOUS;

    public String value() {
        return name();
    }

    public static NaftaImporterSpecificationType fromValue(String v) {
        return valueOf(v);
    }

}
