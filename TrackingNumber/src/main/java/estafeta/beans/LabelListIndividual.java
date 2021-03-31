/**
 * LabelListIndividual.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class LabelListIndividual  extends Result  implements java.io.Serializable {
    private byte[] labelPDF;

    private java.lang.String numRef;

    private java.lang.String numWaybill;

    private java.lang.String secEsc;

    public LabelListIndividual() {
    }

    public LabelListIndividual(
           int resultCode,
           java.lang.String resultDescription,
           java.lang.String resultSpanishDescription,
           boolean valid,
           byte[] labelPDF,
           java.lang.String numRef,
           java.lang.String numWaybill,
           java.lang.String secEsc) {
        super(
            resultCode,
            resultDescription,
            resultSpanishDescription,
            valid);
        this.labelPDF = labelPDF;
        this.numRef = numRef;
        this.numWaybill = numWaybill;
        this.secEsc = secEsc;
    }


    /**
     * Gets the labelPDF value for this LabelListIndividual.
     * 
     * @return labelPDF
     */
    public byte[] getLabelPDF() {
        return labelPDF;
    }


    /**
     * Sets the labelPDF value for this LabelListIndividual.
     * 
     * @param labelPDF
     */
    public void setLabelPDF(byte[] labelPDF) {
        this.labelPDF = labelPDF;
    }


    /**
     * Gets the numRef value for this LabelListIndividual.
     * 
     * @return numRef
     */
    public java.lang.String getNumRef() {
        return numRef;
    }


    /**
     * Sets the numRef value for this LabelListIndividual.
     * 
     * @param numRef
     */
    public void setNumRef(java.lang.String numRef) {
        this.numRef = numRef;
    }


    /**
     * Gets the numWaybill value for this LabelListIndividual.
     * 
     * @return numWaybill
     */
    public java.lang.String getNumWaybill() {
        return numWaybill;
    }


    /**
     * Sets the numWaybill value for this LabelListIndividual.
     * 
     * @param numWaybill
     */
    public void setNumWaybill(java.lang.String numWaybill) {
        this.numWaybill = numWaybill;
    }


    /**
     * Gets the secEsc value for this LabelListIndividual.
     * 
     * @return secEsc
     */
    public java.lang.String getSecEsc() {
        return secEsc;
    }


    /**
     * Sets the secEsc value for this LabelListIndividual.
     * 
     * @param secEsc
     */
    public void setSecEsc(java.lang.String secEsc) {
        this.secEsc = secEsc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelListIndividual)) return false;
        LabelListIndividual other = (LabelListIndividual) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.labelPDF==null && other.getLabelPDF()==null) || 
             (this.labelPDF!=null &&
              java.util.Arrays.equals(this.labelPDF, other.getLabelPDF()))) &&
            ((this.numRef==null && other.getNumRef()==null) || 
             (this.numRef!=null &&
              this.numRef.equals(other.getNumRef()))) &&
            ((this.numWaybill==null && other.getNumWaybill()==null) || 
             (this.numWaybill!=null &&
              this.numWaybill.equals(other.getNumWaybill()))) &&
            ((this.secEsc==null && other.getSecEsc()==null) || 
             (this.secEsc!=null &&
              this.secEsc.equals(other.getSecEsc())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
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
        if (getNumRef() != null) {
            _hashCode += getNumRef().hashCode();
        }
        if (getNumWaybill() != null) {
            _hashCode += getNumWaybill().hashCode();
        }
        if (getSecEsc() != null) {
            _hashCode += getSecEsc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LabelListIndividual.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelListIndividual"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelPDF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelPDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numRef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numWaybill");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numWaybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secEsc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "secEsc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
