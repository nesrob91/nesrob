/**
 * ReprintLabelDescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class ReprintLabelDescription  implements java.io.Serializable {
    private java.lang.String aditionalInfo;

    private java.lang.String content;

    private java.lang.String contentDescription;

    private java.lang.String costCenter;

    private boolean deliveryToEstafetaOffice;

    private java.lang.String destinationCountryId;

    private DestinationInfoReprint destinationInfoReprint;

    private java.lang.String effectiveDate;

    private OriginInfoReprint originInfoReprint;

    private java.lang.String originZipCodeForRouting;

    private java.lang.String parcelNumber;

    private int parcelTypeId;

    private java.lang.String reference;

    private boolean valid;

    private float weight;

    public ReprintLabelDescription() {
    }

    public ReprintLabelDescription(
           java.lang.String aditionalInfo,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String costCenter,
           boolean deliveryToEstafetaOffice,
           java.lang.String destinationCountryId,
           DestinationInfoReprint destinationInfoReprint,
           java.lang.String effectiveDate,
           OriginInfoReprint originInfoReprint,
           java.lang.String originZipCodeForRouting,
           java.lang.String parcelNumber,
           int parcelTypeId,
           java.lang.String reference,
           boolean valid,
           float weight) {
           this.aditionalInfo = aditionalInfo;
           this.content = content;
           this.contentDescription = contentDescription;
           this.costCenter = costCenter;
           this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
           this.destinationCountryId = destinationCountryId;
           this.destinationInfoReprint = destinationInfoReprint;
           this.effectiveDate = effectiveDate;
           this.originInfoReprint = originInfoReprint;
           this.originZipCodeForRouting = originZipCodeForRouting;
           this.parcelNumber = parcelNumber;
           this.parcelTypeId = parcelTypeId;
           this.reference = reference;
           this.valid = valid;
           this.weight = weight;
    }


    /**
     * Gets the aditionalInfo value for this ReprintLabelDescription.
     * 
     * @return aditionalInfo
     */
    public java.lang.String getAditionalInfo() {
        return aditionalInfo;
    }


    /**
     * Sets the aditionalInfo value for this ReprintLabelDescription.
     * 
     * @param aditionalInfo
     */
    public void setAditionalInfo(java.lang.String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }


    /**
     * Gets the content value for this ReprintLabelDescription.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this ReprintLabelDescription.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the contentDescription value for this ReprintLabelDescription.
     * 
     * @return contentDescription
     */
    public java.lang.String getContentDescription() {
        return contentDescription;
    }


    /**
     * Sets the contentDescription value for this ReprintLabelDescription.
     * 
     * @param contentDescription
     */
    public void setContentDescription(java.lang.String contentDescription) {
        this.contentDescription = contentDescription;
    }


    /**
     * Gets the costCenter value for this ReprintLabelDescription.
     * 
     * @return costCenter
     */
    public java.lang.String getCostCenter() {
        return costCenter;
    }


    /**
     * Sets the costCenter value for this ReprintLabelDescription.
     * 
     * @param costCenter
     */
    public void setCostCenter(java.lang.String costCenter) {
        this.costCenter = costCenter;
    }


    /**
     * Gets the deliveryToEstafetaOffice value for this ReprintLabelDescription.
     * 
     * @return deliveryToEstafetaOffice
     */
    public boolean isDeliveryToEstafetaOffice() {
        return deliveryToEstafetaOffice;
    }


    /**
     * Sets the deliveryToEstafetaOffice value for this ReprintLabelDescription.
     * 
     * @param deliveryToEstafetaOffice
     */
    public void setDeliveryToEstafetaOffice(boolean deliveryToEstafetaOffice) {
        this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
    }


    /**
     * Gets the destinationCountryId value for this ReprintLabelDescription.
     * 
     * @return destinationCountryId
     */
    public java.lang.String getDestinationCountryId() {
        return destinationCountryId;
    }


    /**
     * Sets the destinationCountryId value for this ReprintLabelDescription.
     * 
     * @param destinationCountryId
     */
    public void setDestinationCountryId(java.lang.String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }


    /**
     * Gets the destinationInfoReprint value for this ReprintLabelDescription.
     * 
     * @return destinationInfoReprint
     */
    public DestinationInfoReprint getDestinationInfoReprint() {
        return destinationInfoReprint;
    }


    /**
     * Sets the destinationInfoReprint value for this ReprintLabelDescription.
     * 
     * @param destinationInfoReprint
     */
    public void setDestinationInfoReprint(DestinationInfoReprint destinationInfoReprint) {
        this.destinationInfoReprint = destinationInfoReprint;
    }


    /**
     * Gets the effectiveDate value for this ReprintLabelDescription.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this ReprintLabelDescription.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the originInfoReprint value for this ReprintLabelDescription.
     * 
     * @return originInfoReprint
     */
    public OriginInfoReprint getOriginInfoReprint() {
        return originInfoReprint;
    }


    /**
     * Sets the originInfoReprint value for this ReprintLabelDescription.
     * 
     * @param originInfoReprint
     */
    public void setOriginInfoReprint(OriginInfoReprint originInfoReprint) {
        this.originInfoReprint = originInfoReprint;
    }


    /**
     * Gets the originZipCodeForRouting value for this ReprintLabelDescription.
     * 
     * @return originZipCodeForRouting
     */
    public java.lang.String getOriginZipCodeForRouting() {
        return originZipCodeForRouting;
    }


    /**
     * Sets the originZipCodeForRouting value for this ReprintLabelDescription.
     * 
     * @param originZipCodeForRouting
     */
    public void setOriginZipCodeForRouting(java.lang.String originZipCodeForRouting) {
        this.originZipCodeForRouting = originZipCodeForRouting;
    }


    /**
     * Gets the parcelNumber value for this ReprintLabelDescription.
     * 
     * @return parcelNumber
     */
    public java.lang.String getParcelNumber() {
        return parcelNumber;
    }


    /**
     * Sets the parcelNumber value for this ReprintLabelDescription.
     * 
     * @param parcelNumber
     */
    public void setParcelNumber(java.lang.String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }


    /**
     * Gets the parcelTypeId value for this ReprintLabelDescription.
     * 
     * @return parcelTypeId
     */
    public int getParcelTypeId() {
        return parcelTypeId;
    }


    /**
     * Sets the parcelTypeId value for this ReprintLabelDescription.
     * 
     * @param parcelTypeId
     */
    public void setParcelTypeId(int parcelTypeId) {
        this.parcelTypeId = parcelTypeId;
    }


    /**
     * Gets the reference value for this ReprintLabelDescription.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this ReprintLabelDescription.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the valid value for this ReprintLabelDescription.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this ReprintLabelDescription.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the weight value for this ReprintLabelDescription.
     * 
     * @return weight
     */
    public float getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this ReprintLabelDescription.
     * 
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReprintLabelDescription)) return false;
        ReprintLabelDescription other = (ReprintLabelDescription) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aditionalInfo==null && other.getAditionalInfo()==null) || 
             (this.aditionalInfo!=null &&
              this.aditionalInfo.equals(other.getAditionalInfo()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.contentDescription==null && other.getContentDescription()==null) || 
             (this.contentDescription!=null &&
              this.contentDescription.equals(other.getContentDescription()))) &&
            ((this.costCenter==null && other.getCostCenter()==null) || 
             (this.costCenter!=null &&
              this.costCenter.equals(other.getCostCenter()))) &&
            this.deliveryToEstafetaOffice == other.isDeliveryToEstafetaOffice() &&
            ((this.destinationCountryId==null && other.getDestinationCountryId()==null) || 
             (this.destinationCountryId!=null &&
              this.destinationCountryId.equals(other.getDestinationCountryId()))) &&
            ((this.destinationInfoReprint==null && other.getDestinationInfoReprint()==null) || 
             (this.destinationInfoReprint!=null &&
              this.destinationInfoReprint.equals(other.getDestinationInfoReprint()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.originInfoReprint==null && other.getOriginInfoReprint()==null) || 
             (this.originInfoReprint!=null &&
              this.originInfoReprint.equals(other.getOriginInfoReprint()))) &&
            ((this.originZipCodeForRouting==null && other.getOriginZipCodeForRouting()==null) || 
             (this.originZipCodeForRouting!=null &&
              this.originZipCodeForRouting.equals(other.getOriginZipCodeForRouting()))) &&
            ((this.parcelNumber==null && other.getParcelNumber()==null) || 
             (this.parcelNumber!=null &&
              this.parcelNumber.equals(other.getParcelNumber()))) &&
            this.parcelTypeId == other.getParcelTypeId() &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            this.valid == other.isValid() &&
            this.weight == other.getWeight();
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
        if (getAditionalInfo() != null) {
            _hashCode += getAditionalInfo().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getContentDescription() != null) {
            _hashCode += getContentDescription().hashCode();
        }
        if (getCostCenter() != null) {
            _hashCode += getCostCenter().hashCode();
        }
        _hashCode += (isDeliveryToEstafetaOffice() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDestinationCountryId() != null) {
            _hashCode += getDestinationCountryId().hashCode();
        }
        if (getDestinationInfoReprint() != null) {
            _hashCode += getDestinationInfoReprint().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getOriginInfoReprint() != null) {
            _hashCode += getOriginInfoReprint().hashCode();
        }
        if (getOriginZipCodeForRouting() != null) {
            _hashCode += getOriginZipCodeForRouting().hashCode();
        }
        if (getParcelNumber() != null) {
            _hashCode += getParcelNumber().hashCode();
        }
        _hashCode += getParcelTypeId();
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Float(getWeight()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReprintLabelDescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "ReprintLabelDescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aditionalInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aditionalInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costCenter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costCenter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryToEstafetaOffice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryToEstafetaOffice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationCountryId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationCountryId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationInfoReprint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationInfoReprint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DestinationInfoReprint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originInfoReprint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originInfoReprint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "OriginInfoReprint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originZipCodeForRouting");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originZipCodeForRouting"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcelNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcelNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcelTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcelTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
