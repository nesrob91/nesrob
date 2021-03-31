/**
 * EstafetaLabelResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class EstafetaLabelResponse  implements java.io.Serializable {
    private GlobalResult globalResult;

    private byte[] labelPDF;

    private LabelResultList[] labelResultList;

    private boolean valid;

    public EstafetaLabelResponse() {
    }

    public EstafetaLabelResponse(
           GlobalResult globalResult,
           byte[] labelPDF,
           LabelResultList[] labelResultList,
           boolean valid) {
           this.globalResult = globalResult;
           this.labelPDF = labelPDF;
           this.labelResultList = labelResultList;
           this.valid = valid;
    }


    /**
     * Gets the globalResult value for this EstafetaLabelResponse.
     * 
     * @return globalResult
     */
    public GlobalResult getGlobalResult() {
        return globalResult;
    }


    /**
     * Sets the globalResult value for this EstafetaLabelResponse.
     * 
     * @param globalResult
     */
    public void setGlobalResult(GlobalResult globalResult) {
        this.globalResult = globalResult;
    }


    /**
     * Gets the labelPDF value for this EstafetaLabelResponse.
     * 
     * @return labelPDF
     */
    public byte[] getLabelPDF() {
        return labelPDF;
    }


    /**
     * Sets the labelPDF value for this EstafetaLabelResponse.
     * 
     * @param labelPDF
     */
    public void setLabelPDF(byte[] labelPDF) {
        this.labelPDF = labelPDF;
    }


    /**
     * Gets the labelResultList value for this EstafetaLabelResponse.
     * 
     * @return labelResultList
     */
    public LabelResultList[] getLabelResultList() {
        return labelResultList;
    }


    /**
     * Sets the labelResultList value for this EstafetaLabelResponse.
     * 
     * @param labelResultList
     */
    public void setLabelResultList(LabelResultList[] labelResultList) {
        this.labelResultList = labelResultList;
    }


    /**
     * Gets the valid value for this EstafetaLabelResponse.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this EstafetaLabelResponse.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstafetaLabelResponse)) return false;
        EstafetaLabelResponse other = (EstafetaLabelResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.globalResult==null && other.getGlobalResult()==null) || 
             (this.globalResult!=null &&
              this.globalResult.equals(other.getGlobalResult()))) &&
            ((this.labelPDF==null && other.getLabelPDF()==null) || 
             (this.labelPDF!=null &&
              java.util.Arrays.equals(this.labelPDF, other.getLabelPDF()))) &&
            ((this.labelResultList==null && other.getLabelResultList()==null) || 
             (this.labelResultList!=null &&
              java.util.Arrays.equals(this.labelResultList, other.getLabelResultList()))) &&
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
        if (getGlobalResult() != null) {
            _hashCode += getGlobalResult().hashCode();
        }
        if (getLabelPDF() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLabelPDF());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLabelPDF(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLabelResultList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLabelResultList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLabelResultList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstafetaLabelResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "EstafetaLabelResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("globalResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "globalResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "GlobalResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelPDF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelPDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelResultList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelResultList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelResultList"));
        elemField.setNillable(true);
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
