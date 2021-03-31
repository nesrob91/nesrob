/**
 * Waybill.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class Waybill  implements java.io.Serializable {
    private java.lang.String aditionalInfo;

    private byte[] codeC128;

    private byte[] codePDF417;

    private java.lang.String content;

    private java.lang.String contentDescription;

    private java.lang.String declaredWeight;

    private DestinationInfoResult destinationInfoResult;

    private java.lang.String effectiveDate;

    private OriginInfoResult originInfoResult;

    private java.lang.String parcelId;

    private java.lang.String parcelIdShort;

    private java.lang.String reference;

    private RoutingResult routingResult;

    private boolean valid;

    private WaybillResult waybillResult;

    public Waybill() {
    }

    public Waybill(
           java.lang.String aditionalInfo,
           byte[] codeC128,
           byte[] codePDF417,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String declaredWeight,
           DestinationInfoResult destinationInfoResult,
           java.lang.String effectiveDate,
           OriginInfoResult originInfoResult,
           java.lang.String parcelId,
           java.lang.String parcelIdShort,
           java.lang.String reference,
           RoutingResult routingResult,
           boolean valid,
           WaybillResult waybillResult) {
           this.aditionalInfo = aditionalInfo;
           this.codeC128 = codeC128;
           this.codePDF417 = codePDF417;
           this.content = content;
           this.contentDescription = contentDescription;
           this.declaredWeight = declaredWeight;
           this.destinationInfoResult = destinationInfoResult;
           this.effectiveDate = effectiveDate;
           this.originInfoResult = originInfoResult;
           this.parcelId = parcelId;
           this.parcelIdShort = parcelIdShort;
           this.reference = reference;
           this.routingResult = routingResult;
           this.valid = valid;
           this.waybillResult = waybillResult;
    }


    /**
     * Gets the aditionalInfo value for this Waybill.
     * 
     * @return aditionalInfo
     */
    public java.lang.String getAditionalInfo() {
        return aditionalInfo;
    }


    /**
     * Sets the aditionalInfo value for this Waybill.
     * 
     * @param aditionalInfo
     */
    public void setAditionalInfo(java.lang.String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }


    /**
     * Gets the codeC128 value for this Waybill.
     * 
     * @return codeC128
     */
    public byte[] getCodeC128() {
        return codeC128;
    }


    /**
     * Sets the codeC128 value for this Waybill.
     * 
     * @param codeC128
     */
    public void setCodeC128(byte[] codeC128) {
        this.codeC128 = codeC128;
    }


    /**
     * Gets the codePDF417 value for this Waybill.
     * 
     * @return codePDF417
     */
    public byte[] getCodePDF417() {
        return codePDF417;
    }


    /**
     * Sets the codePDF417 value for this Waybill.
     * 
     * @param codePDF417
     */
    public void setCodePDF417(byte[] codePDF417) {
        this.codePDF417 = codePDF417;
    }


    /**
     * Gets the content value for this Waybill.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this Waybill.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the contentDescription value for this Waybill.
     * 
     * @return contentDescription
     */
    public java.lang.String getContentDescription() {
        return contentDescription;
    }


    /**
     * Sets the contentDescription value for this Waybill.
     * 
     * @param contentDescription
     */
    public void setContentDescription(java.lang.String contentDescription) {
        this.contentDescription = contentDescription;
    }


    /**
     * Gets the declaredWeight value for this Waybill.
     * 
     * @return declaredWeight
     */
    public java.lang.String getDeclaredWeight() {
        return declaredWeight;
    }


    /**
     * Sets the declaredWeight value for this Waybill.
     * 
     * @param declaredWeight
     */
    public void setDeclaredWeight(java.lang.String declaredWeight) {
        this.declaredWeight = declaredWeight;
    }


    /**
     * Gets the destinationInfoResult value for this Waybill.
     * 
     * @return destinationInfoResult
     */
    public DestinationInfoResult getDestinationInfoResult() {
        return destinationInfoResult;
    }


    /**
     * Sets the destinationInfoResult value for this Waybill.
     * 
     * @param destinationInfoResult
     */
    public void setDestinationInfoResult(DestinationInfoResult destinationInfoResult) {
        this.destinationInfoResult = destinationInfoResult;
    }


    /**
     * Gets the effectiveDate value for this Waybill.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this Waybill.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the originInfoResult value for this Waybill.
     * 
     * @return originInfoResult
     */
    public OriginInfoResult getOriginInfoResult() {
        return originInfoResult;
    }


    /**
     * Sets the originInfoResult value for this Waybill.
     * 
     * @param originInfoResult
     */
    public void setOriginInfoResult(OriginInfoResult originInfoResult) {
        this.originInfoResult = originInfoResult;
    }


    /**
     * Gets the parcelId value for this Waybill.
     * 
     * @return parcelId
     */
    public java.lang.String getParcelId() {
        return parcelId;
    }


    /**
     * Sets the parcelId value for this Waybill.
     * 
     * @param parcelId
     */
    public void setParcelId(java.lang.String parcelId) {
        this.parcelId = parcelId;
    }


    /**
     * Gets the parcelIdShort value for this Waybill.
     * 
     * @return parcelIdShort
     */
    public java.lang.String getParcelIdShort() {
        return parcelIdShort;
    }


    /**
     * Sets the parcelIdShort value for this Waybill.
     * 
     * @param parcelIdShort
     */
    public void setParcelIdShort(java.lang.String parcelIdShort) {
        this.parcelIdShort = parcelIdShort;
    }


    /**
     * Gets the reference value for this Waybill.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this Waybill.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the routingResult value for this Waybill.
     * 
     * @return routingResult
     */
    public RoutingResult getRoutingResult() {
        return routingResult;
    }


    /**
     * Sets the routingResult value for this Waybill.
     * 
     * @param routingResult
     */
    public void setRoutingResult(RoutingResult routingResult) {
        this.routingResult = routingResult;
    }


    /**
     * Gets the valid value for this Waybill.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this Waybill.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the waybillResult value for this Waybill.
     * 
     * @return waybillResult
     */
    public WaybillResult getWaybillResult() {
        return waybillResult;
    }


    /**
     * Sets the waybillResult value for this Waybill.
     * 
     * @param waybillResult
     */
    public void setWaybillResult(WaybillResult waybillResult) {
        this.waybillResult = waybillResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Waybill)) return false;
        Waybill other = (Waybill) obj;
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
            ((this.codeC128==null && other.getCodeC128()==null) || 
             (this.codeC128!=null &&
              java.util.Arrays.equals(this.codeC128, other.getCodeC128()))) &&
            ((this.codePDF417==null && other.getCodePDF417()==null) || 
             (this.codePDF417!=null &&
              java.util.Arrays.equals(this.codePDF417, other.getCodePDF417()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.contentDescription==null && other.getContentDescription()==null) || 
             (this.contentDescription!=null &&
              this.contentDescription.equals(other.getContentDescription()))) &&
            ((this.declaredWeight==null && other.getDeclaredWeight()==null) || 
             (this.declaredWeight!=null &&
              this.declaredWeight.equals(other.getDeclaredWeight()))) &&
            ((this.destinationInfoResult==null && other.getDestinationInfoResult()==null) || 
             (this.destinationInfoResult!=null &&
              this.destinationInfoResult.equals(other.getDestinationInfoResult()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.originInfoResult==null && other.getOriginInfoResult()==null) || 
             (this.originInfoResult!=null &&
              this.originInfoResult.equals(other.getOriginInfoResult()))) &&
            ((this.parcelId==null && other.getParcelId()==null) || 
             (this.parcelId!=null &&
              this.parcelId.equals(other.getParcelId()))) &&
            ((this.parcelIdShort==null && other.getParcelIdShort()==null) || 
             (this.parcelIdShort!=null &&
              this.parcelIdShort.equals(other.getParcelIdShort()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.routingResult==null && other.getRoutingResult()==null) || 
             (this.routingResult!=null &&
              this.routingResult.equals(other.getRoutingResult()))) &&
            this.valid == other.isValid() &&
            ((this.waybillResult==null && other.getWaybillResult()==null) || 
             (this.waybillResult!=null &&
              this.waybillResult.equals(other.getWaybillResult())));
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
        if (getCodeC128() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCodeC128());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCodeC128(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodePDF417() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCodePDF417());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCodePDF417(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getContentDescription() != null) {
            _hashCode += getContentDescription().hashCode();
        }
        if (getDeclaredWeight() != null) {
            _hashCode += getDeclaredWeight().hashCode();
        }
        if (getDestinationInfoResult() != null) {
            _hashCode += getDestinationInfoResult().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getOriginInfoResult() != null) {
            _hashCode += getOriginInfoResult().hashCode();
        }
        if (getParcelId() != null) {
            _hashCode += getParcelId().hashCode();
        }
        if (getParcelIdShort() != null) {
            _hashCode += getParcelIdShort().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getRoutingResult() != null) {
            _hashCode += getRoutingResult().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getWaybillResult() != null) {
            _hashCode += getWaybillResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Waybill.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "Waybill"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aditionalInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aditionalInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeC128");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeC128"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codePDF417");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codePDF417"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
        elemField.setFieldName("declaredWeight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "declaredWeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DestinationInfoResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "OriginInfoResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcelId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcelId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcelIdShort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcelIdShort"));
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
        elemField.setFieldName("routingResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routingResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "RoutingResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waybillResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "WaybillResult"));
        elemField.setNillable(true);
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
