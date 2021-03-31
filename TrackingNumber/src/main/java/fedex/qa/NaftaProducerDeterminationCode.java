
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NaftaProducerDeterminationCode.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="NaftaProducerDeterminationCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO_1"/>
 *     &lt;enumeration value="NO_2"/>
 *     &lt;enumeration value="NO_3"/>
 *     &lt;enumeration value="YES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NaftaProducerDeterminationCode")
@XmlEnum
public enum NaftaProducerDeterminationCode {

    NO_1,
    NO_2,
    NO_3,
    YES;

    public String value() {
        return name();
    }

    public static NaftaProducerDeterminationCode fromValue(String v) {
        return valueOf(v);
    }

}
