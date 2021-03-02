/**
 * SearchType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class SearchType  implements java.io.Serializable {
    private com.estafeta.www.WaybillRange waybillRange;

    private com.estafeta.www.WaybillList waybillList;

    private java.lang.String type;

    public SearchType() {
    }

    public SearchType(
           com.estafeta.www.WaybillRange waybillRange,
           com.estafeta.www.WaybillList waybillList,
           java.lang.String type) {
           this.waybillRange = waybillRange;
           this.waybillList = waybillList;
           this.type = type;
    }


    /**
     * Gets the waybillRange value for this SearchType.
     * 
     * @return waybillRange
     */
    public com.estafeta.www.WaybillRange getWaybillRange() {
        return waybillRange;
    }


    /**
     * Sets the waybillRange value for this SearchType.
     * 
     * @param waybillRange
     */
    public void setWaybillRange(com.estafeta.www.WaybillRange waybillRange) {
        this.waybillRange = waybillRange;
    }


    /**
     * Gets the waybillList value for this SearchType.
     * 
     * @return waybillList
     */
    public com.estafeta.www.WaybillList getWaybillList() {
        return waybillList;
    }


    /**
     * Sets the waybillList value for this SearchType.
     * 
     * @param waybillList
     */
    public void setWaybillList(com.estafeta.www.WaybillList waybillList) {
        this.waybillList = waybillList;
    }


    /**
     * Gets the type value for this SearchType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this SearchType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchType)) return false;
        SearchType other = (SearchType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.waybillRange==null && other.getWaybillRange()==null) || 
             (this.waybillRange!=null &&
              this.waybillRange.equals(other.getWaybillRange()))) &&
            ((this.waybillList==null && other.getWaybillList()==null) || 
             (this.waybillList!=null &&
              this.waybillList.equals(other.getWaybillList()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getWaybillRange() != null) {
            _hashCode += getWaybillRange().hashCode();
        }
        if (getWaybillList() != null) {
            _hashCode += getWaybillList().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "SearchType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybillRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillRange"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybillList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "type"));
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
