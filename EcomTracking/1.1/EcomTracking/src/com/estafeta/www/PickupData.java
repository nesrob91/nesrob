/**
 * PickupData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class PickupData  implements java.io.Serializable {
    private java.lang.String originAcronym;

    private java.lang.String originName;

    private java.lang.String pickupDateTime;

    public PickupData() {
    }

    public PickupData(
           java.lang.String originAcronym,
           java.lang.String originName,
           java.lang.String pickupDateTime) {
           this.originAcronym = originAcronym;
           this.originName = originName;
           this.pickupDateTime = pickupDateTime;
    }


    /**
     * Gets the originAcronym value for this PickupData.
     * 
     * @return originAcronym
     */
    public java.lang.String getOriginAcronym() {
        return originAcronym;
    }


    /**
     * Sets the originAcronym value for this PickupData.
     * 
     * @param originAcronym
     */
    public void setOriginAcronym(java.lang.String originAcronym) {
        this.originAcronym = originAcronym;
    }


    /**
     * Gets the originName value for this PickupData.
     * 
     * @return originName
     */
    public java.lang.String getOriginName() {
        return originName;
    }


    /**
     * Sets the originName value for this PickupData.
     * 
     * @param originName
     */
    public void setOriginName(java.lang.String originName) {
        this.originName = originName;
    }


    /**
     * Gets the pickupDateTime value for this PickupData.
     * 
     * @return pickupDateTime
     */
    public java.lang.String getPickupDateTime() {
        return pickupDateTime;
    }


    /**
     * Sets the pickupDateTime value for this PickupData.
     * 
     * @param pickupDateTime
     */
    public void setPickupDateTime(java.lang.String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PickupData)) return false;
        PickupData other = (PickupData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.originAcronym==null && other.getOriginAcronym()==null) || 
             (this.originAcronym!=null &&
              this.originAcronym.equals(other.getOriginAcronym()))) &&
            ((this.originName==null && other.getOriginName()==null) || 
             (this.originName!=null &&
              this.originName.equals(other.getOriginName()))) &&
            ((this.pickupDateTime==null && other.getPickupDateTime()==null) || 
             (this.pickupDateTime!=null &&
              this.pickupDateTime.equals(other.getPickupDateTime())));
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
        if (getOriginAcronym() != null) {
            _hashCode += getOriginAcronym().hashCode();
        }
        if (getOriginName() != null) {
            _hashCode += getOriginName().hashCode();
        }
        if (getPickupDateTime() != null) {
            _hashCode += getPickupDateTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PickupData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "PickupData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originAcronym");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originAcronym"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pickupDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "pickupDateTime"));
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
