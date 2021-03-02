
package com.fedex.ws.track.v12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PhysicalPackagingType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalPackagingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BAG"/>
 *     &lt;enumeration value="BARREL"/>
 *     &lt;enumeration value="BASKET"/>
 *     &lt;enumeration value="BOX"/>
 *     &lt;enumeration value="BUCKET"/>
 *     &lt;enumeration value="BUNDLE"/>
 *     &lt;enumeration value="CAGE"/>
 *     &lt;enumeration value="CARTON"/>
 *     &lt;enumeration value="CASE"/>
 *     &lt;enumeration value="CHEST"/>
 *     &lt;enumeration value="CONTAINER"/>
 *     &lt;enumeration value="CRATE"/>
 *     &lt;enumeration value="CYLINDER"/>
 *     &lt;enumeration value="DRUM"/>
 *     &lt;enumeration value="ENVELOPE"/>
 *     &lt;enumeration value="HAMPER"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PACKAGE"/>
 *     &lt;enumeration value="PAIL"/>
 *     &lt;enumeration value="PALLET"/>
 *     &lt;enumeration value="PARCEL"/>
 *     &lt;enumeration value="PIECE"/>
 *     &lt;enumeration value="REEL"/>
 *     &lt;enumeration value="ROLL"/>
 *     &lt;enumeration value="SACK"/>
 *     &lt;enumeration value="SHRINK_WRAPPED"/>
 *     &lt;enumeration value="SKID"/>
 *     &lt;enumeration value="TANK"/>
 *     &lt;enumeration value="TOTE_BIN"/>
 *     &lt;enumeration value="TUBE"/>
 *     &lt;enumeration value="UNIT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalPackagingType")
@XmlEnum
public enum PhysicalPackagingType {

    BAG,
    BARREL,
    BASKET,
    BOX,
    BUCKET,
    BUNDLE,
    CAGE,
    CARTON,
    CASE,
    CHEST,
    CONTAINER,
    CRATE,
    CYLINDER,
    DRUM,
    ENVELOPE,
    HAMPER,
    OTHER,
    PACKAGE,
    PAIL,
    PALLET,
    PARCEL,
    PIECE,
    REEL,
    ROLL,
    SACK,
    SHRINK_WRAPPED,
    SKID,
    TANK,
    TOTE_BIN,
    TUBE,
    UNIT;

    public String value() {
        return name();
    }

    public static PhysicalPackagingType fromValue(String v) {
        return valueOf(v);
    }

}
