
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LabelFormatType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="LabelFormatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMMON2D"/>
 *     &lt;enumeration value="FEDEX_FREIGHT_STRAIGHT_BILL_OF_LADING"/>
 *     &lt;enumeration value="LABEL_DATA_ONLY"/>
 *     &lt;enumeration value="VICS_BILL_OF_LADING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LabelFormatType")
@XmlEnum
public enum LabelFormatType {

    @XmlEnumValue("COMMON2D")
    COMMON_2_D("COMMON2D"),
    FEDEX_FREIGHT_STRAIGHT_BILL_OF_LADING("FEDEX_FREIGHT_STRAIGHT_BILL_OF_LADING"),
    LABEL_DATA_ONLY("LABEL_DATA_ONLY"),
    VICS_BILL_OF_LADING("VICS_BILL_OF_LADING");
    private final String value;

    LabelFormatType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LabelFormatType fromValue(String v) {
        for (LabelFormatType c: LabelFormatType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
