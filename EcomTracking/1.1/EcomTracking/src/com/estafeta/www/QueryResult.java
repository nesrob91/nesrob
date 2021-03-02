/**
 * QueryResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class QueryResult  implements java.io.Serializable {
    private java.lang.String errorCode;

    private java.lang.String errorCodeDescriptionSPA;

    private java.lang.String errorCodeDescriptionENG;

    private com.estafeta.www.TrackingData[] trackingData;

    public QueryResult() {
    }

    public QueryResult(
           java.lang.String errorCode,
           java.lang.String errorCodeDescriptionSPA,
           java.lang.String errorCodeDescriptionENG,
           com.estafeta.www.TrackingData[] trackingData) {
           this.errorCode = errorCode;
           this.errorCodeDescriptionSPA = errorCodeDescriptionSPA;
           this.errorCodeDescriptionENG = errorCodeDescriptionENG;
           this.trackingData = trackingData;
    }


    /**
     * Gets the errorCode value for this QueryResult.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this QueryResult.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorCodeDescriptionSPA value for this QueryResult.
     * 
     * @return errorCodeDescriptionSPA
     */
    public java.lang.String getErrorCodeDescriptionSPA() {
        return errorCodeDescriptionSPA;
    }


    /**
     * Sets the errorCodeDescriptionSPA value for this QueryResult.
     * 
     * @param errorCodeDescriptionSPA
     */
    public void setErrorCodeDescriptionSPA(java.lang.String errorCodeDescriptionSPA) {
        this.errorCodeDescriptionSPA = errorCodeDescriptionSPA;
    }


    /**
     * Gets the errorCodeDescriptionENG value for this QueryResult.
     * 
     * @return errorCodeDescriptionENG
     */
    public java.lang.String getErrorCodeDescriptionENG() {
        return errorCodeDescriptionENG;
    }


    /**
     * Sets the errorCodeDescriptionENG value for this QueryResult.
     * 
     * @param errorCodeDescriptionENG
     */
    public void setErrorCodeDescriptionENG(java.lang.String errorCodeDescriptionENG) {
        this.errorCodeDescriptionENG = errorCodeDescriptionENG;
    }


    /**
     * Gets the trackingData value for this QueryResult.
     * 
     * @return trackingData
     */
    public com.estafeta.www.TrackingData[] getTrackingData() {
        return trackingData;
    }


    /**
     * Sets the trackingData value for this QueryResult.
     * 
     * @param trackingData
     */
    public void setTrackingData(com.estafeta.www.TrackingData[] trackingData) {
        this.trackingData = trackingData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryResult)) return false;
        QueryResult other = (QueryResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorCodeDescriptionSPA==null && other.getErrorCodeDescriptionSPA()==null) || 
             (this.errorCodeDescriptionSPA!=null &&
              this.errorCodeDescriptionSPA.equals(other.getErrorCodeDescriptionSPA()))) &&
            ((this.errorCodeDescriptionENG==null && other.getErrorCodeDescriptionENG()==null) || 
             (this.errorCodeDescriptionENG!=null &&
              this.errorCodeDescriptionENG.equals(other.getErrorCodeDescriptionENG()))) &&
            ((this.trackingData==null && other.getTrackingData()==null) || 
             (this.trackingData!=null &&
              java.util.Arrays.equals(this.trackingData, other.getTrackingData())));
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
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorCodeDescriptionSPA() != null) {
            _hashCode += getErrorCodeDescriptionSPA().hashCode();
        }
        if (getErrorCodeDescriptionENG() != null) {
            _hashCode += getErrorCodeDescriptionENG().hashCode();
        }
        if (getTrackingData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrackingData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrackingData(), i);
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
        new org.apache.axis.description.TypeDesc(QueryResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "QueryResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "errorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCodeDescriptionSPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "errorCodeDescriptionSPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCodeDescriptionENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "errorCodeDescriptionENG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackingData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "trackingData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "TrackingData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.estafeta.com/", "TrackingData"));
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
