/**
 * LabelDescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class LabelDescription  implements java.io.Serializable {
    private DRAlternativeInfo DRAlternativeInfo;

    private java.lang.String aditionalInfo;

    private java.lang.String content;

    private java.lang.String contentDescription;

    private java.lang.String costCenter;

    private boolean deliveryToEstafetaOffice;

    private java.lang.String destinationCountryId;

    private DestinationInfo destinationInfo;

    private java.lang.String effectiveDate;

    private int numberOfLabels;

    private java.lang.String officeNum;

    private OriginInfo originInfo;

    private java.lang.String originZipCodeForRouting;

    private int parcelTypeId;

    private java.lang.String reference;

    private boolean returnDocument;

    private java.lang.String serviceTypeId;

    private java.lang.String serviceTypeIdDocRet;

    private boolean valid;

    private float weight;

    public LabelDescription() {
    }

    public LabelDescription(
           DRAlternativeInfo DRAlternativeInfo,
           java.lang.String aditionalInfo,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String costCenter,
           boolean deliveryToEstafetaOffice,
           java.lang.String destinationCountryId,
           DestinationInfo destinationInfo,
           java.lang.String effectiveDate,
           int numberOfLabels,
           java.lang.String officeNum,
           OriginInfo originInfo,
           java.lang.String originZipCodeForRouting,
           int parcelTypeId,
           java.lang.String reference,
           boolean returnDocument,
           java.lang.String serviceTypeId,
           java.lang.String serviceTypeIdDocRet,
           boolean valid,
           float weight) {
           this.DRAlternativeInfo = DRAlternativeInfo;
           this.aditionalInfo = aditionalInfo;
           this.content = content;
           this.contentDescription = contentDescription;
           this.costCenter = costCenter;
           this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
           this.destinationCountryId = destinationCountryId;
           this.destinationInfo = destinationInfo;
           this.effectiveDate = effectiveDate;
           this.numberOfLabels = numberOfLabels;
           this.officeNum = officeNum;
           this.originInfo = originInfo;
           this.originZipCodeForRouting = originZipCodeForRouting;
           this.parcelTypeId = parcelTypeId;
           this.reference = reference;
           this.returnDocument = returnDocument;
           this.serviceTypeId = serviceTypeId;
           this.serviceTypeIdDocRet = serviceTypeIdDocRet;
           this.valid = valid;
           this.weight = weight;
    }


    /**
     * Gets the DRAlternativeInfo value for this LabelDescription.
     * 
     * @return DRAlternativeInfo
     */
    public DRAlternativeInfo getDRAlternativeInfo() {
        return DRAlternativeInfo;
    }


    /**
     * Sets the DRAlternativeInfo value for this LabelDescription.
     * 
     * @param DRAlternativeInfo
     */
    public void setDRAlternativeInfo(DRAlternativeInfo DRAlternativeInfo) {
        this.DRAlternativeInfo = DRAlternativeInfo;
    }


    /**
     * Gets the aditionalInfo value for this LabelDescription.
     * 
     * @return aditionalInfo
     */
    public java.lang.String getAditionalInfo() {
        return aditionalInfo;
    }


    /**
     * Sets the aditionalInfo value for this LabelDescription.
     * 
     * @param aditionalInfo
     */
    public void setAditionalInfo(java.lang.String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }


    /**
     * Gets the content value for this LabelDescription.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this LabelDescription.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the contentDescription value for this LabelDescription.
     * 
     * @return contentDescription
     */
    public java.lang.String getContentDescription() {
        return contentDescription;
    }


    /**
     * Sets the contentDescription value for this LabelDescription.
     * 
     * @param contentDescription
     */
    public void setContentDescription(java.lang.String contentDescription) {
        this.contentDescription = contentDescription;
    }


    /**
     * Gets the costCenter value for this LabelDescription.
     * 
     * @return costCenter
     */
    public java.lang.String getCostCenter() {
        return costCenter;
    }


    /**
     * Sets the costCenter value for this LabelDescription.
     * 
     * @param costCenter
     */
    public void setCostCenter(java.lang.String costCenter) {
        this.costCenter = costCenter;
    }


    /**
     * Gets the deliveryToEstafetaOffice value for this LabelDescription.
     * 
     * @return deliveryToEstafetaOffice
     */
    public boolean isDeliveryToEstafetaOffice() {
        return deliveryToEstafetaOffice;
    }


    /**
     * Sets the deliveryToEstafetaOffice value for this LabelDescription.
     * 
     * @param deliveryToEstafetaOffice
     */
    public void setDeliveryToEstafetaOffice(boolean deliveryToEstafetaOffice) {
        this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
    }


    /**
     * Gets the destinationCountryId value for this LabelDescription.
     * 
     * @return destinationCountryId
     */
    public java.lang.String getDestinationCountryId() {
        return destinationCountryId;
    }


    /**
     * Sets the destinationCountryId value for this LabelDescription.
     * 
     * @param destinationCountryId
     */
    public void setDestinationCountryId(java.lang.String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }


    /**
     * Gets the destinationInfo value for this LabelDescription.
     * 
     * @return destinationInfo
     */
    public DestinationInfo getDestinationInfo() {
        return destinationInfo;
    }


    /**
     * Sets the destinationInfo value for this LabelDescription.
     * 
     * @param destinationInfo
     */
    public void setDestinationInfo(DestinationInfo destinationInfo) {
        this.destinationInfo = destinationInfo;
    }


    /**
     * Gets the effectiveDate value for this LabelDescription.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this LabelDescription.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the numberOfLabels value for this LabelDescription.
     * 
     * @return numberOfLabels
     */
    public int getNumberOfLabels() {
        return numberOfLabels;
    }


    /**
     * Sets the numberOfLabels value for this LabelDescription.
     * 
     * @param numberOfLabels
     */
    public void setNumberOfLabels(int numberOfLabels) {
        this.numberOfLabels = numberOfLabels;
    }


    /**
     * Gets the officeNum value for this LabelDescription.
     * 
     * @return officeNum
     */
    public java.lang.String getOfficeNum() {
        return officeNum;
    }


    /**
     * Sets the officeNum value for this LabelDescription.
     * 
     * @param officeNum
     */
    public void setOfficeNum(java.lang.String officeNum) {
        this.officeNum = officeNum;
    }


    /**
     * Gets the originInfo value for this LabelDescription.
     * 
     * @return originInfo
     */
    public OriginInfo getOriginInfo() {
        return originInfo;
    }


    /**
     * Sets the originInfo value for this LabelDescription.
     * 
     * @param originInfo
     */
    public void setOriginInfo(OriginInfo originInfo) {
        this.originInfo = originInfo;
    }


    /**
     * Gets the originZipCodeForRouting value for this LabelDescription.
     * 
     * @return originZipCodeForRouting
     */
    public java.lang.String getOriginZipCodeForRouting() {
        return originZipCodeForRouting;
    }


    /**
     * Sets the originZipCodeForRouting value for this LabelDescription.
     * 
     * @param originZipCodeForRouting
     */
    public void setOriginZipCodeForRouting(java.lang.String originZipCodeForRouting) {
        this.originZipCodeForRouting = originZipCodeForRouting;
    }


    /**
     * Gets the parcelTypeId value for this LabelDescription.
     * 
     * @return parcelTypeId
     */
    public int getParcelTypeId() {
        return parcelTypeId;
    }


    /**
     * Sets the parcelTypeId value for this LabelDescription.
     * 
     * @param parcelTypeId
     */
    public void setParcelTypeId(int parcelTypeId) {
        this.parcelTypeId = parcelTypeId;
    }


    /**
     * Gets the reference value for this LabelDescription.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this LabelDescription.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the returnDocument value for this LabelDescription.
     * 
     * @return returnDocument
     */
    public boolean isReturnDocument() {
        return returnDocument;
    }


    /**
     * Sets the returnDocument value for this LabelDescription.
     * 
     * @param returnDocument
     */
    public void setReturnDocument(boolean returnDocument) {
        this.returnDocument = returnDocument;
    }


    /**
     * Gets the serviceTypeId value for this LabelDescription.
     * 
     * @return serviceTypeId
     */
    public java.lang.String getServiceTypeId() {
        return serviceTypeId;
    }


    /**
     * Sets the serviceTypeId value for this LabelDescription.
     * 
     * @param serviceTypeId
     */
    public void setServiceTypeId(java.lang.String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }


    /**
     * Gets the serviceTypeIdDocRet value for this LabelDescription.
     * 
     * @return serviceTypeIdDocRet
     */
    public java.lang.String getServiceTypeIdDocRet() {
        return serviceTypeIdDocRet;
    }


    /**
     * Sets the serviceTypeIdDocRet value for this LabelDescription.
     * 
     * @param serviceTypeIdDocRet
     */
    public void setServiceTypeIdDocRet(java.lang.String serviceTypeIdDocRet) {
        this.serviceTypeIdDocRet = serviceTypeIdDocRet;
    }


    /**
     * Gets the valid value for this LabelDescription.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this LabelDescription.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the weight value for this LabelDescription.
     * 
     * @return weight
     */
    public float getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this LabelDescription.
     * 
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelDescription)) return false;
        LabelDescription other = (LabelDescription) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DRAlternativeInfo==null && other.getDRAlternativeInfo()==null) || 
             (this.DRAlternativeInfo!=null &&
              this.DRAlternativeInfo.equals(other.getDRAlternativeInfo()))) &&
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
            ((this.destinationInfo==null && other.getDestinationInfo()==null) || 
             (this.destinationInfo!=null &&
              this.destinationInfo.equals(other.getDestinationInfo()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            this.numberOfLabels == other.getNumberOfLabels() &&
            ((this.officeNum==null && other.getOfficeNum()==null) || 
             (this.officeNum!=null &&
              this.officeNum.equals(other.getOfficeNum()))) &&
            ((this.originInfo==null && other.getOriginInfo()==null) || 
             (this.originInfo!=null &&
              this.originInfo.equals(other.getOriginInfo()))) &&
            ((this.originZipCodeForRouting==null && other.getOriginZipCodeForRouting()==null) || 
             (this.originZipCodeForRouting!=null &&
              this.originZipCodeForRouting.equals(other.getOriginZipCodeForRouting()))) &&
            this.parcelTypeId == other.getParcelTypeId() &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            this.returnDocument == other.isReturnDocument() &&
            ((this.serviceTypeId==null && other.getServiceTypeId()==null) || 
             (this.serviceTypeId!=null &&
              this.serviceTypeId.equals(other.getServiceTypeId()))) &&
            ((this.serviceTypeIdDocRet==null && other.getServiceTypeIdDocRet()==null) || 
             (this.serviceTypeIdDocRet!=null &&
              this.serviceTypeIdDocRet.equals(other.getServiceTypeIdDocRet()))) &&
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
        if (getDRAlternativeInfo() != null) {
            _hashCode += getDRAlternativeInfo().hashCode();
        }
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
        if (getDestinationInfo() != null) {
            _hashCode += getDestinationInfo().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        _hashCode += getNumberOfLabels();
        if (getOfficeNum() != null) {
            _hashCode += getOfficeNum().hashCode();
        }
        if (getOriginInfo() != null) {
            _hashCode += getOriginInfo().hashCode();
        }
        if (getOriginZipCodeForRouting() != null) {
            _hashCode += getOriginZipCodeForRouting().hashCode();
        }
        _hashCode += getParcelTypeId();
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        _hashCode += (isReturnDocument() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServiceTypeId() != null) {
            _hashCode += getServiceTypeId().hashCode();
        }
        if (getServiceTypeIdDocRet() != null) {
            _hashCode += getServiceTypeIdDocRet().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Float(getWeight()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LabelDescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelDescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DRAlternativeInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DRAlternativeInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DRAlternativeInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("destinationInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DestinationInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfLabels");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfLabels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officeNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "officeNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "OriginInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originZipCodeForRouting");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originZipCodeForRouting"));
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
        elemField.setFieldName("returnDocument");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnDocument"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeIdDocRet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeIdDocRet"));
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
