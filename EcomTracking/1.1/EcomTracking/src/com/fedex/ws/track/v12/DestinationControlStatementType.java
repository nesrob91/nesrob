
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DestinationControlStatementType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DestinationControlStatementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEPARTMENT_OF_COMMERCE"/>
 *     &lt;enumeration value="DEPARTMENT_OF_STATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DestinationControlStatementType")
@XmlEnum
public enum DestinationControlStatementType {

    DEPARTMENT_OF_COMMERCE,
    DEPARTMENT_OF_STATE;

    public String value() {
        return name();
    }

    public static DestinationControlStatementType fromValue(String v) {
        return valueOf(v);
    }

}
