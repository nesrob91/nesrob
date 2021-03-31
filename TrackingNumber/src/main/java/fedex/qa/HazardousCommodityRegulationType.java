
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para HazardousCommodityRegulationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="HazardousCommodityRegulationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADR"/>
 *     &lt;enumeration value="DOT"/>
 *     &lt;enumeration value="IATA"/>
 *     &lt;enumeration value="ORMD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HazardousCommodityRegulationType")
@XmlEnum
public enum HazardousCommodityRegulationType {

    ADR,
    DOT,
    IATA,
    ORMD;

    public String value() {
        return name();
    }

    public static HazardousCommodityRegulationType fromValue(String v) {
        return valueOf(v);
    }

}
