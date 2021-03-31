/**
 * WaybillEstafeta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class WaybillEstafeta  extends Waybill  implements java.io.Serializable {
    public WaybillEstafeta() {
    }

    public WaybillEstafeta(
           java.lang.String aditionalInfo,
           byte[] codeC128,
           byte[] codePDF417,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String declaredWeight,
           DestinationInfoResult destinationInfoResult,
           java.lang.String effectiveDate,
           OriginInfoResult originInfoResult,
           java.lang.String parcelId,
           java.lang.String parcelIdShort,
           java.lang.String reference,
           RoutingResult routingResult,
           boolean valid,
           WaybillResult waybillResult) {
        super(
            aditionalInfo,
            codeC128,
            codePDF417,
            content,
            contentDescription,
            declaredWeight,
            destinationInfoResult,
            effectiveDate,
            originInfoResult,
            parcelId,
            parcelIdShort,
            reference,
            routingResult,
            valid,
            waybillResult);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WaybillEstafeta)) return false;
        WaybillEstafeta other = (WaybillEstafeta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WaybillEstafeta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "WaybillEstafeta"));
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
