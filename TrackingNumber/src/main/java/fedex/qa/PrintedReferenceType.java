
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PrintedReferenceType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PrintedReferenceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BILL_OF_LADING"/>
 *     &lt;enumeration value="CONSIGNEE_ID_NUMBER"/>
 *     &lt;enumeration value="SHIPPER_ID_NUMBER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrintedReferenceType")
@XmlEnum
public enum PrintedReferenceType {

    BILL_OF_LADING,
    CONSIGNEE_ID_NUMBER,
    SHIPPER_ID_NUMBER;

    public String value() {
        return name();
    }

    public static PrintedReferenceType fromValue(String v) {
        return valueOf(v);
    }

}
