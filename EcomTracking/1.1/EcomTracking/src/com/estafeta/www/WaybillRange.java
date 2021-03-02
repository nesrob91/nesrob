/**
 * WaybillRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class WaybillRange  implements java.io.Serializable {
    private java.lang.String initialWaybill;

    private java.lang.String finalWaybill;

    public WaybillRange() {
    }

    public WaybillRange(
           java.lang.String initialWaybill,
           java.lang.String finalWaybill) {
           this.initialWaybill = initialWaybill;
           this.finalWaybill = finalWaybill;
    }


    /**
     * Gets the initialWaybill value for this WaybillRange.
     * 
     * @return initialWaybill
     */
    public java.lang.String getInitialWaybill() {
        return initialWaybill;
    }


    /**
     * Sets the initialWaybill value for this WaybillRange.
     * 
     * @param initialWaybill
     */
    public void setInitialWaybill(java.lang.String initialWaybill) {
        this.initialWaybill = initialWaybill;
    }


    /**
     * Gets the finalWaybill value for this WaybillRange.
     * 
     * @return finalWaybill
     */
    public java.lang.String getFinalWaybill() {
        return finalWaybill;
    }


    /**
     * Sets the finalWaybill value for this WaybillRange.
     * 
     * @param finalWaybill
     */
    public void setFinalWaybill(java.lang.String finalWaybill) {
        this.finalWaybill = finalWaybill;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WaybillRange)) return false;
        WaybillRange other = (WaybillRange) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.initialWaybill==null && other.getInitialWaybill()==null) || 
             (this.initialWaybill!=null &&
              this.initialWaybill.equals(other.getInitialWaybill()))) &&
            ((this.finalWaybill==null && other.getFinalWaybill()==null) || 
             (this.finalWaybill!=null &&
              this.finalWaybill.equals(other.getFinalWaybill())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInitialWaybill() != null) {
            _hashCode += getInitialWaybill().hashCode();
        }
        if (getFinalWaybill() != null) {
            _hashCode += getFinalWaybill().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WaybillRange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillRange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initialWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "initialWaybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finalWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "finalWaybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
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
