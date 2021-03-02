/**
 * WaybillReplaceData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class WaybillReplaceData  implements java.io.Serializable {
    private java.lang.String originalWaybill;

    private java.lang.String replaceWaybill;

    public WaybillReplaceData() {
    }

    public WaybillReplaceData(
           java.lang.String originalWaybill,
           java.lang.String replaceWaybill) {
           this.originalWaybill = originalWaybill;
           this.replaceWaybill = replaceWaybill;
    }


    /**
     * Gets the originalWaybill value for this WaybillReplaceData.
     * 
     * @return originalWaybill
     */
    public java.lang.String getOriginalWaybill() {
        return originalWaybill;
    }


    /**
     * Sets the originalWaybill value for this WaybillReplaceData.
     * 
     * @param originalWaybill
     */
    public void setOriginalWaybill(java.lang.String originalWaybill) {
        this.originalWaybill = originalWaybill;
    }


    /**
     * Gets the replaceWaybill value for this WaybillReplaceData.
     * 
     * @return replaceWaybill
     */
    public java.lang.String getReplaceWaybill() {
        return replaceWaybill;
    }


    /**
     * Sets the replaceWaybill value for this WaybillReplaceData.
     * 
     * @param replaceWaybill
     */
    public void setReplaceWaybill(java.lang.String replaceWaybill) {
        this.replaceWaybill = replaceWaybill;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WaybillReplaceData)) return false;
        WaybillReplaceData other = (WaybillReplaceData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.originalWaybill==null && other.getOriginalWaybill()==null) || 
             (this.originalWaybill!=null &&
              this.originalWaybill.equals(other.getOriginalWaybill()))) &&
            ((this.replaceWaybill==null && other.getReplaceWaybill()==null) || 
             (this.replaceWaybill!=null &&
              this.replaceWaybill.equals(other.getReplaceWaybill())));
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
        if (getOriginalWaybill() != null) {
            _hashCode += getOriginalWaybill().hashCode();
        }
        if (getReplaceWaybill() != null) {
            _hashCode += getReplaceWaybill().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WaybillReplaceData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillReplaceData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originalWaybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replaceWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "replaceWaybill"));
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
