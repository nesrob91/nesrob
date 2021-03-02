/**
 * SearchConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class SearchConfiguration  implements java.io.Serializable {
    private boolean includeDimensions;

    private boolean includeWaybillReplaceData;

    private boolean includeReturnDocumentData;

    private boolean includeMultipleServiceData;

    private boolean includeInternationalData;

    private boolean includeSignature;

    private boolean includeCustomerInfo;

    private com.estafeta.www.HistoryConfiguration historyConfiguration;

    private com.estafeta.www.Filter filterType;

    public SearchConfiguration() {
    }

    public SearchConfiguration(
           boolean includeDimensions,
           boolean includeWaybillReplaceData,
           boolean includeReturnDocumentData,
           boolean includeMultipleServiceData,
           boolean includeInternationalData,
           boolean includeSignature,
           boolean includeCustomerInfo,
           com.estafeta.www.HistoryConfiguration historyConfiguration,
           com.estafeta.www.Filter filterType) {
           this.includeDimensions = includeDimensions;
           this.includeWaybillReplaceData = includeWaybillReplaceData;
           this.includeReturnDocumentData = includeReturnDocumentData;
           this.includeMultipleServiceData = includeMultipleServiceData;
           this.includeInternationalData = includeInternationalData;
           this.includeSignature = includeSignature;
           this.includeCustomerInfo = includeCustomerInfo;
           this.historyConfiguration = historyConfiguration;
           this.filterType = filterType;
    }


    /**
     * Gets the includeDimensions value for this SearchConfiguration.
     * 
     * @return includeDimensions
     */
    public boolean isIncludeDimensions() {
        return includeDimensions;
    }


    /**
     * Sets the includeDimensions value for this SearchConfiguration.
     * 
     * @param includeDimensions
     */
    public void setIncludeDimensions(boolean includeDimensions) {
        this.includeDimensions = includeDimensions;
    }


    /**
     * Gets the includeWaybillReplaceData value for this SearchConfiguration.
     * 
     * @return includeWaybillReplaceData
     */
    public boolean isIncludeWaybillReplaceData() {
        return includeWaybillReplaceData;
    }


    /**
     * Sets the includeWaybillReplaceData value for this SearchConfiguration.
     * 
     * @param includeWaybillReplaceData
     */
    public void setIncludeWaybillReplaceData(boolean includeWaybillReplaceData) {
        this.includeWaybillReplaceData = includeWaybillReplaceData;
    }


    /**
     * Gets the includeReturnDocumentData value for this SearchConfiguration.
     * 
     * @return includeReturnDocumentData
     */
    public boolean isIncludeReturnDocumentData() {
        return includeReturnDocumentData;
    }


    /**
     * Sets the includeReturnDocumentData value for this SearchConfiguration.
     * 
     * @param includeReturnDocumentData
     */
    public void setIncludeReturnDocumentData(boolean includeReturnDocumentData) {
        this.includeReturnDocumentData = includeReturnDocumentData;
    }


    /**
     * Gets the includeMultipleServiceData value for this SearchConfiguration.
     * 
     * @return includeMultipleServiceData
     */
    public boolean isIncludeMultipleServiceData() {
        return includeMultipleServiceData;
    }


    /**
     * Sets the includeMultipleServiceData value for this SearchConfiguration.
     * 
     * @param includeMultipleServiceData
     */
    public void setIncludeMultipleServiceData(boolean includeMultipleServiceData) {
        this.includeMultipleServiceData = includeMultipleServiceData;
    }


    /**
     * Gets the includeInternationalData value for this SearchConfiguration.
     * 
     * @return includeInternationalData
     */
    public boolean isIncludeInternationalData() {
        return includeInternationalData;
    }


    /**
     * Sets the includeInternationalData value for this SearchConfiguration.
     * 
     * @param includeInternationalData
     */
    public void setIncludeInternationalData(boolean includeInternationalData) {
        this.includeInternationalData = includeInternationalData;
    }


    /**
     * Gets the includeSignature value for this SearchConfiguration.
     * 
     * @return includeSignature
     */
    public boolean isIncludeSignature() {
        return includeSignature;
    }


    /**
     * Sets the includeSignature value for this SearchConfiguration.
     * 
     * @param includeSignature
     */
    public void setIncludeSignature(boolean includeSignature) {
        this.includeSignature = includeSignature;
    }


    /**
     * Gets the includeCustomerInfo value for this SearchConfiguration.
     * 
     * @return includeCustomerInfo
     */
    public boolean isIncludeCustomerInfo() {
        return includeCustomerInfo;
    }


    /**
     * Sets the includeCustomerInfo value for this SearchConfiguration.
     * 
     * @param includeCustomerInfo
     */
    public void setIncludeCustomerInfo(boolean includeCustomerInfo) {
        this.includeCustomerInfo = includeCustomerInfo;
    }


    /**
     * Gets the historyConfiguration value for this SearchConfiguration.
     * 
     * @return historyConfiguration
     */
    public com.estafeta.www.HistoryConfiguration getHistoryConfiguration() {
        return historyConfiguration;
    }


    /**
     * Sets the historyConfiguration value for this SearchConfiguration.
     * 
     * @param historyConfiguration
     */
    public void setHistoryConfiguration(com.estafeta.www.HistoryConfiguration historyConfiguration) {
        this.historyConfiguration = historyConfiguration;
    }


    /**
     * Gets the filterType value for this SearchConfiguration.
     * 
     * @return filterType
     */
    public com.estafeta.www.Filter getFilterType() {
        return filterType;
    }


    /**
     * Sets the filterType value for this SearchConfiguration.
     * 
     * @param filterType
     */
    public void setFilterType(com.estafeta.www.Filter filterType) {
        this.filterType = filterType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchConfiguration)) return false;
        SearchConfiguration other = (SearchConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.includeDimensions == other.isIncludeDimensions() &&
            this.includeWaybillReplaceData == other.isIncludeWaybillReplaceData() &&
            this.includeReturnDocumentData == other.isIncludeReturnDocumentData() &&
            this.includeMultipleServiceData == other.isIncludeMultipleServiceData() &&
            this.includeInternationalData == other.isIncludeInternationalData() &&
            this.includeSignature == other.isIncludeSignature() &&
            this.includeCustomerInfo == other.isIncludeCustomerInfo() &&
            ((this.historyConfiguration==null && other.getHistoryConfiguration()==null) || 
             (this.historyConfiguration!=null &&
              this.historyConfiguration.equals(other.getHistoryConfiguration()))) &&
            ((this.filterType==null && other.getFilterType()==null) || 
             (this.filterType!=null &&
              this.filterType.equals(other.getFilterType())));
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
        _hashCode += (isIncludeDimensions() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeWaybillReplaceData() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeReturnDocumentData() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeMultipleServiceData() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeInternationalData() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeSignature() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIncludeCustomerInfo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHistoryConfiguration() != null) {
            _hashCode += getHistoryConfiguration().hashCode();
        }
        if (getFilterType() != null) {
            _hashCode += getFilterType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "SearchConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeDimensions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeDimensions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeWaybillReplaceData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeWaybillReplaceData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeReturnDocumentData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeReturnDocumentData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeMultipleServiceData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeMultipleServiceData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeInternationalData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeInternationalData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeSignature");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeSignature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeCustomerInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "includeCustomerInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historyConfiguration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "historyConfiguration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "HistoryConfiguration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "filterType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "Filter"));
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
