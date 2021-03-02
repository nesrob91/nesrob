/**
 * InternationalData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class InternationalData  implements java.io.Serializable {
    private java.lang.String internationalWaybill;

    private java.lang.String originCountryCode;

    private java.lang.String originCountrySPA;

    private java.lang.String originCountryENG;

    public InternationalData() {
    }

    public InternationalData(
           java.lang.String internationalWaybill,
           java.lang.String originCountryCode,
           java.lang.String originCountrySPA,
           java.lang.String originCountryENG) {
           this.internationalWaybill = internationalWaybill;
           this.originCountryCode = originCountryCode;
           this.originCountrySPA = originCountrySPA;
           this.originCountryENG = originCountryENG;
    }


    /**
     * Gets the internationalWaybill value for this InternationalData.
     * 
     * @return internationalWaybill
     */
    public java.lang.String getInternationalWaybill() {
        return internationalWaybill;
    }


    /**
     * Sets the internationalWaybill value for this InternationalData.
     * 
     * @param internationalWaybill
     */
    public void setInternationalWaybill(java.lang.String internationalWaybill) {
        this.internationalWaybill = internationalWaybill;
    }


    /**
     * Gets the originCountryCode value for this InternationalData.
     * 
     * @return originCountryCode
     */
    public java.lang.String getOriginCountryCode() {
        return originCountryCode;
    }


    /**
     * Sets the originCountryCode value for this InternationalData.
     * 
     * @param originCountryCode
     */
    public void setOriginCountryCode(java.lang.String originCountryCode) {
        this.originCountryCode = originCountryCode;
    }


    /**
     * Gets the originCountrySPA value for this InternationalData.
     * 
     * @return originCountrySPA
     */
    public java.lang.String getOriginCountrySPA() {
        return originCountrySPA;
    }


    /**
     * Sets the originCountrySPA value for this InternationalData.
     * 
     * @param originCountrySPA
     */
    public void setOriginCountrySPA(java.lang.String originCountrySPA) {
        this.originCountrySPA = originCountrySPA;
    }


    /**
     * Gets the originCountryENG value for this InternationalData.
     * 
     * @return originCountryENG
     */
    public java.lang.String getOriginCountryENG() {
        return originCountryENG;
    }


    /**
     * Sets the originCountryENG value for this InternationalData.
     * 
     * @param originCountryENG
     */
    public void setOriginCountryENG(java.lang.String originCountryENG) {
        this.originCountryENG = originCountryENG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InternationalData)) return false;
        InternationalData other = (InternationalData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.internationalWaybill==null && other.getInternationalWaybill()==null) || 
             (this.internationalWaybill!=null &&
              this.internationalWaybill.equals(other.getInternationalWaybill()))) &&
            ((this.originCountryCode==null && other.getOriginCountryCode()==null) || 
             (this.originCountryCode!=null &&
              this.originCountryCode.equals(other.getOriginCountryCode()))) &&
            ((this.originCountrySPA==null && other.getOriginCountrySPA()==null) || 
             (this.originCountrySPA!=null &&
              this.originCountrySPA.equals(other.getOriginCountrySPA()))) &&
            ((this.originCountryENG==null && other.getOriginCountryENG()==null) || 
             (this.originCountryENG!=null &&
              this.originCountryENG.equals(other.getOriginCountryENG())));
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
        if (getInternationalWaybill() != null) {
            _hashCode += getInternationalWaybill().hashCode();
        }
        if (getOriginCountryCode() != null) {
            _hashCode += getOriginCountryCode().hashCode();
        }
        if (getOriginCountrySPA() != null) {
            _hashCode += getOriginCountrySPA().hashCode();
        }
        if (getOriginCountryENG() != null) {
            _hashCode += getOriginCountryENG().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InternationalData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "InternationalData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "internationalWaybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originCountrySPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originCountrySPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originCountryENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "originCountryENG"));
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
