
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UploadDocumentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="UploadDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CERTIFICATE_OF_ORIGIN"/>
 *     &lt;enumeration value="COMMERCIAL_INVOICE"/>
 *     &lt;enumeration value="ETD_LABEL"/>
 *     &lt;enumeration value="NAFTA_CERTIFICATE_OF_ORIGIN"/>
 *     &lt;enumeration value="NET_RATE_SHEET"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PRO_FORMA_INVOICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UploadDocumentType")
@XmlEnum
public enum UploadDocumentType {

    CERTIFICATE_OF_ORIGIN,
    COMMERCIAL_INVOICE,
    ETD_LABEL,
    NAFTA_CERTIFICATE_OF_ORIGIN,
    NET_RATE_SHEET,
    OTHER,
    PRO_FORMA_INVOICE;

    public String value() {
        return name();
    }

    public static UploadDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
