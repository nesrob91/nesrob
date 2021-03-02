/**
 * History.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class History  implements java.io.Serializable {
    private java.lang.String eventDateTime;

    private java.lang.String eventId;

    private java.lang.String eventDescriptionSPA;

    private java.lang.String eventDescriptionENG;

    private java.lang.String eventPlaceAcronym;

    private java.lang.String eventPlaceName;

    private java.lang.String exceptionCode;

    private java.lang.String exceptionCodeDescriptionSPA;

    private java.lang.String exceptionCodeDescriptionENG;

    private java.lang.String exceptionCodeDetails;

    public History() {
    }

    public History(
           java.lang.String eventDateTime,
           java.lang.String eventId,
           java.lang.String eventDescriptionSPA,
           java.lang.String eventDescriptionENG,
           java.lang.String eventPlaceAcronym,
           java.lang.String eventPlaceName,
           java.lang.String exceptionCode,
           java.lang.String exceptionCodeDescriptionSPA,
           java.lang.String exceptionCodeDescriptionENG,
           java.lang.String exceptionCodeDetails) {
           this.eventDateTime = eventDateTime;
           this.eventId = eventId;
           this.eventDescriptionSPA = eventDescriptionSPA;
           this.eventDescriptionENG = eventDescriptionENG;
           this.eventPlaceAcronym = eventPlaceAcronym;
           this.eventPlaceName = eventPlaceName;
           this.exceptionCode = exceptionCode;
           this.exceptionCodeDescriptionSPA = exceptionCodeDescriptionSPA;
           this.exceptionCodeDescriptionENG = exceptionCodeDescriptionENG;
           this.exceptionCodeDetails = exceptionCodeDetails;
    }


    /**
     * Gets the eventDateTime value for this History.
     * 
     * @return eventDateTime
     */
    public java.lang.String getEventDateTime() {
        return eventDateTime;
    }


    /**
     * Sets the eventDateTime value for this History.
     * 
     * @param eventDateTime
     */
    public void setEventDateTime(java.lang.String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }


    /**
     * Gets the eventId value for this History.
     * 
     * @return eventId
     */
    public java.lang.String getEventId() {
        return eventId;
    }


    /**
     * Sets the eventId value for this History.
     * 
     * @param eventId
     */
    public void setEventId(java.lang.String eventId) {
        this.eventId = eventId;
    }


    /**
     * Gets the eventDescriptionSPA value for this History.
     * 
     * @return eventDescriptionSPA
     */
    public java.lang.String getEventDescriptionSPA() {
        return eventDescriptionSPA;
    }


    /**
     * Sets the eventDescriptionSPA value for this History.
     * 
     * @param eventDescriptionSPA
     */
    public void setEventDescriptionSPA(java.lang.String eventDescriptionSPA) {
        this.eventDescriptionSPA = eventDescriptionSPA;
    }


    /**
     * Gets the eventDescriptionENG value for this History.
     * 
     * @return eventDescriptionENG
     */
    public java.lang.String getEventDescriptionENG() {
        return eventDescriptionENG;
    }


    /**
     * Sets the eventDescriptionENG value for this History.
     * 
     * @param eventDescriptionENG
     */
    public void setEventDescriptionENG(java.lang.String eventDescriptionENG) {
        this.eventDescriptionENG = eventDescriptionENG;
    }


    /**
     * Gets the eventPlaceAcronym value for this History.
     * 
     * @return eventPlaceAcronym
     */
    public java.lang.String getEventPlaceAcronym() {
        return eventPlaceAcronym;
    }


    /**
     * Sets the eventPlaceAcronym value for this History.
     * 
     * @param eventPlaceAcronym
     */
    public void setEventPlaceAcronym(java.lang.String eventPlaceAcronym) {
        this.eventPlaceAcronym = eventPlaceAcronym;
    }


    /**
     * Gets the eventPlaceName value for this History.
     * 
     * @return eventPlaceName
     */
    public java.lang.String getEventPlaceName() {
        return eventPlaceName;
    }


    /**
     * Sets the eventPlaceName value for this History.
     * 
     * @param eventPlaceName
     */
    public void setEventPlaceName(java.lang.String eventPlaceName) {
        this.eventPlaceName = eventPlaceName;
    }


    /**
     * Gets the exceptionCode value for this History.
     * 
     * @return exceptionCode
     */
    public java.lang.String getExceptionCode() {
        return exceptionCode;
    }


    /**
     * Sets the exceptionCode value for this History.
     * 
     * @param exceptionCode
     */
    public void setExceptionCode(java.lang.String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }


    /**
     * Gets the exceptionCodeDescriptionSPA value for this History.
     * 
     * @return exceptionCodeDescriptionSPA
     */
    public java.lang.String getExceptionCodeDescriptionSPA() {
        return exceptionCodeDescriptionSPA;
    }


    /**
     * Sets the exceptionCodeDescriptionSPA value for this History.
     * 
     * @param exceptionCodeDescriptionSPA
     */
    public void setExceptionCodeDescriptionSPA(java.lang.String exceptionCodeDescriptionSPA) {
        this.exceptionCodeDescriptionSPA = exceptionCodeDescriptionSPA;
    }


    /**
     * Gets the exceptionCodeDescriptionENG value for this History.
     * 
     * @return exceptionCodeDescriptionENG
     */
    public java.lang.String getExceptionCodeDescriptionENG() {
        return exceptionCodeDescriptionENG;
    }


    /**
     * Sets the exceptionCodeDescriptionENG value for this History.
     * 
     * @param exceptionCodeDescriptionENG
     */
    public void setExceptionCodeDescriptionENG(java.lang.String exceptionCodeDescriptionENG) {
        this.exceptionCodeDescriptionENG = exceptionCodeDescriptionENG;
    }


    /**
     * Gets the exceptionCodeDetails value for this History.
     * 
     * @return exceptionCodeDetails
     */
    public java.lang.String getExceptionCodeDetails() {
        return exceptionCodeDetails;
    }


    /**
     * Sets the exceptionCodeDetails value for this History.
     * 
     * @param exceptionCodeDetails
     */
    public void setExceptionCodeDetails(java.lang.String exceptionCodeDetails) {
        this.exceptionCodeDetails = exceptionCodeDetails;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof History)) return false;
        History other = (History) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.eventDateTime==null && other.getEventDateTime()==null) || 
             (this.eventDateTime!=null &&
              this.eventDateTime.equals(other.getEventDateTime()))) &&
            ((this.eventId==null && other.getEventId()==null) || 
             (this.eventId!=null &&
              this.eventId.equals(other.getEventId()))) &&
            ((this.eventDescriptionSPA==null && other.getEventDescriptionSPA()==null) || 
             (this.eventDescriptionSPA!=null &&
              this.eventDescriptionSPA.equals(other.getEventDescriptionSPA()))) &&
            ((this.eventDescriptionENG==null && other.getEventDescriptionENG()==null) || 
             (this.eventDescriptionENG!=null &&
              this.eventDescriptionENG.equals(other.getEventDescriptionENG()))) &&
            ((this.eventPlaceAcronym==null && other.getEventPlaceAcronym()==null) || 
             (this.eventPlaceAcronym!=null &&
              this.eventPlaceAcronym.equals(other.getEventPlaceAcronym()))) &&
            ((this.eventPlaceName==null && other.getEventPlaceName()==null) || 
             (this.eventPlaceName!=null &&
              this.eventPlaceName.equals(other.getEventPlaceName()))) &&
            ((this.exceptionCode==null && other.getExceptionCode()==null) || 
             (this.exceptionCode!=null &&
              this.exceptionCode.equals(other.getExceptionCode()))) &&
            ((this.exceptionCodeDescriptionSPA==null && other.getExceptionCodeDescriptionSPA()==null) || 
             (this.exceptionCodeDescriptionSPA!=null &&
              this.exceptionCodeDescriptionSPA.equals(other.getExceptionCodeDescriptionSPA()))) &&
            ((this.exceptionCodeDescriptionENG==null && other.getExceptionCodeDescriptionENG()==null) || 
             (this.exceptionCodeDescriptionENG!=null &&
              this.exceptionCodeDescriptionENG.equals(other.getExceptionCodeDescriptionENG()))) &&
            ((this.exceptionCodeDetails==null && other.getExceptionCodeDetails()==null) || 
             (this.exceptionCodeDetails!=null &&
              this.exceptionCodeDetails.equals(other.getExceptionCodeDetails())));
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
        if (getEventDateTime() != null) {
            _hashCode += getEventDateTime().hashCode();
        }
        if (getEventId() != null) {
            _hashCode += getEventId().hashCode();
        }
        if (getEventDescriptionSPA() != null) {
            _hashCode += getEventDescriptionSPA().hashCode();
        }
        if (getEventDescriptionENG() != null) {
            _hashCode += getEventDescriptionENG().hashCode();
        }
        if (getEventPlaceAcronym() != null) {
            _hashCode += getEventPlaceAcronym().hashCode();
        }
        if (getEventPlaceName() != null) {
            _hashCode += getEventPlaceName().hashCode();
        }
        if (getExceptionCode() != null) {
            _hashCode += getExceptionCode().hashCode();
        }
        if (getExceptionCodeDescriptionSPA() != null) {
            _hashCode += getExceptionCodeDescriptionSPA().hashCode();
        }
        if (getExceptionCodeDescriptionENG() != null) {
            _hashCode += getExceptionCodeDescriptionENG().hashCode();
        }
        if (getExceptionCodeDetails() != null) {
            _hashCode += getExceptionCodeDetails().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(History.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "History"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventDescriptionSPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventDescriptionSPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventDescriptionENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventDescriptionENG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventPlaceAcronym");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventPlaceAcronym"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventPlaceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "eventPlaceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "exceptionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionCodeDescriptionSPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "exceptionCodeDescriptionSPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionCodeDescriptionENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "exceptionCodeDescriptionENG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionCodeDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "exceptionCodeDetails"));
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
