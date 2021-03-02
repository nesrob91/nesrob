/**
 * WaybillList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class WaybillList  implements java.io.Serializable {
    private java.lang.String waybillType;

    private java.lang.String[] waybills;

    public WaybillList() {
    }

    public WaybillList(
           java.lang.String waybillType,
           java.lang.String[] waybills) {
           this.waybillType = waybillType;
           this.waybills = waybills;
    }


    /**
     * Gets the waybillType value for this WaybillList.
     * 
     * @return waybillType
     */
    public java.lang.String getWaybillType() {
        return waybillType;
    }


    /**
     * Sets the waybillType value for this WaybillList.
     * 
     * @param waybillType
     */
    public void setWaybillType(java.lang.String waybillType) {
        this.waybillType = waybillType;
    }


    /**
     * Gets the waybills value for this WaybillList.
     * 
     * @return waybills
     */
    public java.lang.String[] getWaybills() {
        return waybills;
    }


    /**
     * Sets the waybills value for this WaybillList.
     * 
     * @param waybills
     */
    public void setWaybills(java.lang.String[] waybills) {
        this.waybills = waybills;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WaybillList)) return false;
        WaybillList other = (WaybillList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.waybillType==null && other.getWaybillType()==null) || 
             (this.waybillType!=null &&
              this.waybillType.equals(other.getWaybillType()))) &&
            ((this.waybills==null && other.getWaybills()==null) || 
             (this.waybills!=null &&
              java.util.Arrays.equals(this.waybills, other.getWaybills())));
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
        if (getWaybillType() != null) {
            _hashCode += getWaybillType().hashCode();
        }
        if (getWaybills() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWaybills());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWaybills(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WaybillList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybillType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.estafeta.com/", "string"));
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
