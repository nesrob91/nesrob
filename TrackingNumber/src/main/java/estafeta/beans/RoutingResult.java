/**
 * RoutingResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class RoutingResult  extends Routing  implements java.io.Serializable {
    public RoutingResult() {
    }

    public RoutingResult(
           java.lang.String additionalService,
           java.lang.String borderPlace,
           java.lang.String deliveryToEstafetaOffice,
           java.lang.String destinationPlace,
           java.lang.String downFligth,
           java.lang.String ground,
           java.lang.String holdPoint,
           java.lang.String noWarranty,
           java.lang.String originPlace,
           java.lang.String placeId,
           java.lang.String placeName,
           java.lang.String regionId,
           java.lang.String service,
           java.lang.String serviceDescription,
           java.lang.String upFligth,
           boolean valid,
           java.lang.String zipCode,
           java.lang.String zoneId) {
        super(
            additionalService,
            borderPlace,
            deliveryToEstafetaOffice,
            destinationPlace,
            downFligth,
            ground,
            holdPoint,
            noWarranty,
            originPlace,
            placeId,
            placeName,
            regionId,
            service,
            serviceDescription,
            upFligth,
            valid,
            zipCode,
            zoneId);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RoutingResult)) return false;
        RoutingResult other = (RoutingResult) obj;
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
        new org.apache.axis.description.TypeDesc(RoutingResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "RoutingResult"));
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
