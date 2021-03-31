
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RadioactivityUnitOfMeasure.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RadioactivityUnitOfMeasure">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BQ"/>
 *     &lt;enumeration value="GBQ"/>
 *     &lt;enumeration value="KBQ"/>
 *     &lt;enumeration value="MBQ"/>
 *     &lt;enumeration value="PBQ"/>
 *     &lt;enumeration value="TBQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RadioactivityUnitOfMeasure")
@XmlEnum
public enum RadioactivityUnitOfMeasure {

    BQ,
    GBQ,
    KBQ,
    MBQ,
    PBQ,
    TBQ;

    public String value() {
        return name();
    }

    public static RadioactivityUnitOfMeasure fromValue(String v) {
        return valueOf(v);
    }

}
