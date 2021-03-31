
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AssociatedShipmentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="AssociatedShipmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COD_AND_DELIVERY_ON_INVOICE_ACCEPTANCE_RETURN"/>
 *     &lt;enumeration value="COD_RETURN"/>
 *     &lt;enumeration value="DELIVERY_ON_INVOICE_ACCEPTANCE_RETURN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssociatedShipmentType")
@XmlEnum
public enum AssociatedShipmentType {

    COD_AND_DELIVERY_ON_INVOICE_ACCEPTANCE_RETURN,
    COD_RETURN,
    DELIVERY_ON_INVOICE_ACCEPTANCE_RETURN;

    public String value() {
        return name();
    }

    public static AssociatedShipmentType fromValue(String v) {
        return valueOf(v);
    }

}
