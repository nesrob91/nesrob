/**
 * Dimensions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class Dimensions  implements java.io.Serializable {
    private java.lang.String weight;

    private java.lang.String volumetricWeight;

    private java.lang.String width;

    private java.lang.String length;

    private java.lang.String height;

    public Dimensions() {
    }

    public Dimensions(
           java.lang.String weight,
           java.lang.String volumetricWeight,
           java.lang.String width,
           java.lang.String length,
           java.lang.String height) {
           this.weight = weight;
           this.volumetricWeight = volumetricWeight;
           this.width = width;
           this.length = length;
           this.height = height;
    }


    /**
     * Gets the weight value for this Dimensions.
     * 
     * @return weight
     */
    public java.lang.String getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this Dimensions.
     * 
     * @param weight
     */
    public void setWeight(java.lang.String weight) {
        this.weight = weight;
    }


    /**
     * Gets the volumetricWeight value for this Dimensions.
     * 
     * @return volumetricWeight
     */
    public java.lang.String getVolumetricWeight() {
        return volumetricWeight;
    }


    /**
     * Sets the volumetricWeight value for this Dimensions.
     * 
     * @param volumetricWeight
     */
    public void setVolumetricWeight(java.lang.String volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }


    /**
     * Gets the width value for this Dimensions.
     * 
     * @return width
     */
    public java.lang.String getWidth() {
        return width;
    }


    /**
     * Sets the width value for this Dimensions.
     * 
     * @param width
     */
    public void setWidth(java.lang.String width) {
        this.width = width;
    }


    /**
     * Gets the length value for this Dimensions.
     * 
     * @return length
     */
    public java.lang.String getLength() {
        return length;
    }


    /**
     * Sets the length value for this Dimensions.
     * 
     * @param length
     */
    public void setLength(java.lang.String length) {
        this.length = length;
    }


    /**
     * Gets the height value for this Dimensions.
     * 
     * @return height
     */
    public java.lang.String getHeight() {
        return height;
    }


    /**
     * Sets the height value for this Dimensions.
     * 
     * @param height
     */
    public void setHeight(java.lang.String height) {
        this.height = height;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dimensions)) return false;
        Dimensions other = (Dimensions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.weight==null && other.getWeight()==null) || 
             (this.weight!=null &&
              this.weight.equals(other.getWeight()))) &&
            ((this.volumetricWeight==null && other.getVolumetricWeight()==null) || 
             (this.volumetricWeight!=null &&
              this.volumetricWeight.equals(other.getVolumetricWeight()))) &&
            ((this.width==null && other.getWidth()==null) || 
             (this.width!=null &&
              this.width.equals(other.getWidth()))) &&
            ((this.length==null && other.getLength()==null) || 
             (this.length!=null &&
              this.length.equals(other.getLength()))) &&
            ((this.height==null && other.getHeight()==null) || 
             (this.height!=null &&
              this.height.equals(other.getHeight())));
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
        if (getWeight() != null) {
            _hashCode += getWeight().hashCode();
        }
        if (getVolumetricWeight() != null) {
            _hashCode += getVolumetricWeight().hashCode();
        }
        if (getWidth() != null) {
            _hashCode += getWidth().hashCode();
        }
        if (getLength() != null) {
            _hashCode += getLength().hashCode();
        }
        if (getHeight() != null) {
            _hashCode += getHeight().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dimensions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "Dimensions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "weight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumetricWeight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "volumetricWeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("width");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "width"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("height");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "height"));
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
