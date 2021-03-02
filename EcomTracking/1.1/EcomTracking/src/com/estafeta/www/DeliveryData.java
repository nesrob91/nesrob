/**
 * DeliveryData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class DeliveryData  implements java.io.Serializable {
    private java.lang.String destinationAcronym;

    private java.lang.String destinationName;

    private java.lang.String deliveryDateTime;

    private java.lang.String zipCode;

    private java.lang.String receiverName;

    public DeliveryData() {
    }

    public DeliveryData(
           java.lang.String destinationAcronym,
           java.lang.String destinationName,
           java.lang.String deliveryDateTime,
           java.lang.String zipCode,
           java.lang.String receiverName) {
           this.destinationAcronym = destinationAcronym;
           this.destinationName = destinationName;
           this.deliveryDateTime = deliveryDateTime;
           this.zipCode = zipCode;
           this.receiverName = receiverName;
    }


    /**
     * Gets the destinationAcronym value for this DeliveryData.
     * 
     * @return destinationAcronym
     */
    public java.lang.String getDestinationAcronym() {
        return destinationAcronym;
    }


    /**
     * Sets the destinationAcronym value for this DeliveryData.
     * 
     * @param destinationAcronym
     */
    public void setDestinationAcronym(java.lang.String destinationAcronym) {
        this.destinationAcronym = destinationAcronym;
    }


    /**
     * Gets the destinationName value for this DeliveryData.
     * 
     * @return destinationName
     */
    public java.lang.String getDestinationName() {
        return destinationName;
    }


    /**
     * Sets the destinationName value for this DeliveryData.
     * 
     * @param destinationName
     */
    public void setDestinationName(java.lang.String destinationName) {
        this.destinationName = destinationName;
    }


    /**
     * Gets the deliveryDateTime value for this DeliveryData.
     * 
     * @return deliveryDateTime
     */
    public java.lang.String getDeliveryDateTime() {
        return deliveryDateTime;
    }


    /**
     * Sets the deliveryDateTime value for this DeliveryData.
     * 
     * @param deliveryDateTime
     */
    public void setDeliveryDateTime(java.lang.String deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }


    /**
     * Gets the zipCode value for this DeliveryData.
     * 
     * @return zipCode
     */
    public java.lang.String getZipCode() {
        return zipCode;
    }


    /**
     * Sets the zipCode value for this DeliveryData.
     * 
     * @param zipCode
     */
    public void setZipCode(java.lang.String zipCode) {
        this.zipCode = zipCode;
    }


    /**
     * Gets the receiverName value for this DeliveryData.
     * 
     * @return receiverName
     */
    public java.lang.String getReceiverName() {
        return receiverName;
    }


    /**
     * Sets the receiverName value for this DeliveryData.
     * 
     * @param receiverName
     */
    public void setReceiverName(java.lang.String receiverName) {
        this.receiverName = receiverName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeliveryData)) return false;
        DeliveryData other = (DeliveryData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destinationAcronym==null && other.getDestinationAcronym()==null) || 
             (this.destinationAcronym!=null &&
              this.destinationAcronym.equals(other.getDestinationAcronym()))) &&
            ((this.destinationName==null && other.getDestinationName()==null) || 
             (this.destinationName!=null &&
              this.destinationName.equals(other.getDestinationName()))) &&
            ((this.deliveryDateTime==null && other.getDeliveryDateTime()==null) || 
             (this.deliveryDateTime!=null &&
              this.deliveryDateTime.equals(other.getDeliveryDateTime()))) &&
            ((this.zipCode==null && other.getZipCode()==null) || 
             (this.zipCode!=null &&
              this.zipCode.equals(other.getZipCode()))) &&
            ((this.receiverName==null && other.getReceiverName()==null) || 
             (this.receiverName!=null &&
              this.receiverName.equals(other.getReceiverName())));
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
        if (getDestinationAcronym() != null) {
            _hashCode += getDestinationAcronym().hashCode();
        }
        if (getDestinationName() != null) {
            _hashCode += getDestinationName().hashCode();
        }
        if (getDeliveryDateTime() != null) {
            _hashCode += getDeliveryDateTime().hashCode();
        }
        if (getZipCode() != null) {
            _hashCode += getZipCode().hashCode();
        }
        if (getReceiverName() != null) {
            _hashCode += getReceiverName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeliveryData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "DeliveryData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationAcronym");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "destinationAcronym"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "destinationName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "deliveryDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "zipCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiverName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "receiverName"));
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
