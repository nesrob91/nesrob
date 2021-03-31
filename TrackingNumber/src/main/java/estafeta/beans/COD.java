/**
 * COD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class COD  implements java.io.Serializable {
    private java.lang.String deliveryType;

    private java.lang.String officeCOD;

    private java.lang.String productDescription;

    private java.lang.String reference;

    private java.lang.String shipmentInvoice;

    private float totalCharge;

    private boolean valid;

    public COD() {
    }

    public COD(
           java.lang.String deliveryType,
           java.lang.String officeCOD,
           java.lang.String productDescription,
           java.lang.String reference,
           java.lang.String shipmentInvoice,
           float totalCharge,
           boolean valid) {
           this.deliveryType = deliveryType;
           this.officeCOD = officeCOD;
           this.productDescription = productDescription;
           this.reference = reference;
           this.shipmentInvoice = shipmentInvoice;
           this.totalCharge = totalCharge;
           this.valid = valid;
    }


    /**
     * Gets the deliveryType value for this COD.
     * 
     * @return deliveryType
     */
    public java.lang.String getDeliveryType() {
        return deliveryType;
    }


    /**
     * Sets the deliveryType value for this COD.
     * 
     * @param deliveryType
     */
    public void setDeliveryType(java.lang.String deliveryType) {
        this.deliveryType = deliveryType;
    }


    /**
     * Gets the officeCOD value for this COD.
     * 
     * @return officeCOD
     */
    public java.lang.String getOfficeCOD() {
        return officeCOD;
    }


    /**
     * Sets the officeCOD value for this COD.
     * 
     * @param officeCOD
     */
    public void setOfficeCOD(java.lang.String officeCOD) {
        this.officeCOD = officeCOD;
    }


    /**
     * Gets the productDescription value for this COD.
     * 
     * @return productDescription
     */
    public java.lang.String getProductDescription() {
        return productDescription;
    }


    /**
     * Sets the productDescription value for this COD.
     * 
     * @param productDescription
     */
    public void setProductDescription(java.lang.String productDescription) {
        this.productDescription = productDescription;
    }


    /**
     * Gets the reference value for this COD.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this COD.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the shipmentInvoice value for this COD.
     * 
     * @return shipmentInvoice
     */
    public java.lang.String getShipmentInvoice() {
        return shipmentInvoice;
    }


    /**
     * Sets the shipmentInvoice value for this COD.
     * 
     * @param shipmentInvoice
     */
    public void setShipmentInvoice(java.lang.String shipmentInvoice) {
        this.shipmentInvoice = shipmentInvoice;
    }


    /**
     * Gets the totalCharge value for this COD.
     * 
     * @return totalCharge
     */
    public float getTotalCharge() {
        return totalCharge;
    }


    /**
     * Sets the totalCharge value for this COD.
     * 
     * @param totalCharge
     */
    public void setTotalCharge(float totalCharge) {
        this.totalCharge = totalCharge;
    }


    /**
     * Gets the valid value for this COD.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this COD.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof COD)) return false;
        COD other = (COD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deliveryType==null && other.getDeliveryType()==null) || 
             (this.deliveryType!=null &&
              this.deliveryType.equals(other.getDeliveryType()))) &&
            ((this.officeCOD==null && other.getOfficeCOD()==null) || 
             (this.officeCOD!=null &&
              this.officeCOD.equals(other.getOfficeCOD()))) &&
            ((this.productDescription==null && other.getProductDescription()==null) || 
             (this.productDescription!=null &&
              this.productDescription.equals(other.getProductDescription()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.shipmentInvoice==null && other.getShipmentInvoice()==null) || 
             (this.shipmentInvoice!=null &&
              this.shipmentInvoice.equals(other.getShipmentInvoice()))) &&
            this.totalCharge == other.getTotalCharge() &&
            this.valid == other.isValid();
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
        if (getDeliveryType() != null) {
            _hashCode += getDeliveryType().hashCode();
        }
        if (getOfficeCOD() != null) {
            _hashCode += getOfficeCOD().hashCode();
        }
        if (getProductDescription() != null) {
            _hashCode += getProductDescription().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getShipmentInvoice() != null) {
            _hashCode += getShipmentInvoice().hashCode();
        }
        _hashCode += new Float(getTotalCharge()).hashCode();
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(COD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "COD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officeCOD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "officeCOD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipmentInvoice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shipmentInvoice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
