/**
 * CustomerInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class CustomerInfo  implements java.io.Serializable {
    private java.lang.String reference;

    private java.lang.String costsCentre;

    public CustomerInfo() {
    }

    public CustomerInfo(
           java.lang.String reference,
           java.lang.String costsCentre) {
           this.reference = reference;
           this.costsCentre = costsCentre;
    }


    /**
     * Gets the reference value for this CustomerInfo.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this CustomerInfo.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the costsCentre value for this CustomerInfo.
     * 
     * @return costsCentre
     */
    public java.lang.String getCostsCentre() {
        return costsCentre;
    }


    /**
     * Sets the costsCentre value for this CustomerInfo.
     * 
     * @param costsCentre
     */
    public void setCostsCentre(java.lang.String costsCentre) {
        this.costsCentre = costsCentre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerInfo)) return false;
        CustomerInfo other = (CustomerInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.costsCentre==null && other.getCostsCentre()==null) || 
             (this.costsCentre!=null &&
              this.costsCentre.equals(other.getCostsCentre())));
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
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getCostsCentre() != null) {
            _hashCode += getCostsCentre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "CustomerInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costsCentre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "costsCentre"));
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
