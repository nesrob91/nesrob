/**
 * MultipleServiceData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class MultipleServiceData  implements java.io.Serializable {
    private java.lang.String precedingWaybills;

    private java.lang.String followingWaybills;

    private java.lang.String[] waybillList;

    public MultipleServiceData() {
    }

    public MultipleServiceData(
           java.lang.String precedingWaybills,
           java.lang.String followingWaybills,
           java.lang.String[] waybillList) {
           this.precedingWaybills = precedingWaybills;
           this.followingWaybills = followingWaybills;
           this.waybillList = waybillList;
    }


    /**
     * Gets the precedingWaybills value for this MultipleServiceData.
     * 
     * @return precedingWaybills
     */
    public java.lang.String getPrecedingWaybills() {
        return precedingWaybills;
    }


    /**
     * Sets the precedingWaybills value for this MultipleServiceData.
     * 
     * @param precedingWaybills
     */
    public void setPrecedingWaybills(java.lang.String precedingWaybills) {
        this.precedingWaybills = precedingWaybills;
    }


    /**
     * Gets the followingWaybills value for this MultipleServiceData.
     * 
     * @return followingWaybills
     */
    public java.lang.String getFollowingWaybills() {
        return followingWaybills;
    }


    /**
     * Sets the followingWaybills value for this MultipleServiceData.
     * 
     * @param followingWaybills
     */
    public void setFollowingWaybills(java.lang.String followingWaybills) {
        this.followingWaybills = followingWaybills;
    }


    /**
     * Gets the waybillList value for this MultipleServiceData.
     * 
     * @return waybillList
     */
    public java.lang.String[] getWaybillList() {
        return waybillList;
    }


    /**
     * Sets the waybillList value for this MultipleServiceData.
     * 
     * @param waybillList
     */
    public void setWaybillList(java.lang.String[] waybillList) {
        this.waybillList = waybillList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MultipleServiceData)) return false;
        MultipleServiceData other = (MultipleServiceData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.precedingWaybills==null && other.getPrecedingWaybills()==null) || 
             (this.precedingWaybills!=null &&
              this.precedingWaybills.equals(other.getPrecedingWaybills()))) &&
            ((this.followingWaybills==null && other.getFollowingWaybills()==null) || 
             (this.followingWaybills!=null &&
              this.followingWaybills.equals(other.getFollowingWaybills()))) &&
            ((this.waybillList==null && other.getWaybillList()==null) || 
             (this.waybillList!=null &&
              java.util.Arrays.equals(this.waybillList, other.getWaybillList())));
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
        if (getPrecedingWaybills() != null) {
            _hashCode += getPrecedingWaybills().hashCode();
        }
        if (getFollowingWaybills() != null) {
            _hashCode += getFollowingWaybills().hashCode();
        }
        if (getWaybillList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWaybillList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWaybillList(), i);
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
        new org.apache.axis.description.TypeDesc(MultipleServiceData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "MultipleServiceData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precedingWaybills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "precedingWaybills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("followingWaybills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "followingWaybills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybillList"));
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
