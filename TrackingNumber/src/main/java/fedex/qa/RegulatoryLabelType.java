
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RegulatoryLabelType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RegulatoryLabelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALCOHOL_SHIPMENT_LABEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RegulatoryLabelType")
@XmlEnum
public enum RegulatoryLabelType {

    ALCOHOL_SHIPMENT_LABEL;

    public String value() {
        return name();
    }

    public static RegulatoryLabelType fromValue(String v) {
        return valueOf(v);
    }

}
