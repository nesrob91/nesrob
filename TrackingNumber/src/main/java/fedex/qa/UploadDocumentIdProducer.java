
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UploadDocumentIdProducer.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="UploadDocumentIdProducer">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="FEDEX_CAFE"/>
 *     &lt;enumeration value="FEDEX_CSHP"/>
 *     &lt;enumeration value="FEDEX_FXRS"/>
 *     &lt;enumeration value="FEDEX_GSMW"/>
 *     &lt;enumeration value="FEDEX_GTM"/>
 *     &lt;enumeration value="FEDEX_INET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UploadDocumentIdProducer")
@XmlEnum
public enum UploadDocumentIdProducer {

    CUSTOMER,
    FEDEX_CAFE,
    FEDEX_CSHP,
    FEDEX_FXRS,
    FEDEX_GSMW,
    FEDEX_GTM,
    FEDEX_INET;

    public String value() {
        return name();
    }

    public static UploadDocumentIdProducer fromValue(String v) {
        return valueOf(v);
    }

}
