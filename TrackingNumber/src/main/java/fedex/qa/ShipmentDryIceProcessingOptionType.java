
package fedex.qa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShipmentDryIceProcessingOptionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ShipmentDryIceProcessingOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHIPMENT_LEVEL_DRY_ICE_ONLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ShipmentDryIceProcessingOptionType")
@XmlEnum
public enum ShipmentDryIceProcessingOptionType {

    SHIPMENT_LEVEL_DRY_ICE_ONLY;

    public String value() {
        return name();
    }

    public static ShipmentDryIceProcessingOptionType fromValue(String v) {
        return valueOf(v);
    }

}
