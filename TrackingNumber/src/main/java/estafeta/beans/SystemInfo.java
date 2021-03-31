/**
 * SystemInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class SystemInfo  implements java.io.Serializable {
    private java.lang.String systemName;

    private java.lang.String systemReleasedDate;

    private java.lang.String systemVersion;

    private boolean valid;

    public SystemInfo() {
    }

    public SystemInfo(
           java.lang.String systemName,
           java.lang.String systemReleasedDate,
           java.lang.String systemVersion,
           boolean valid) {
           this.systemName = systemName;
           this.systemReleasedDate = systemReleasedDate;
           this.systemVersion = systemVersion;
           this.valid = valid;
    }


    /**
     * Gets the systemName value for this SystemInfo.
     * 
     * @return systemName
     */
    public java.lang.String getSystemName() {
        return systemName;
    }


    /**
     * Sets the systemName value for this SystemInfo.
     * 
     * @param systemName
     */
    public void setSystemName(java.lang.String systemName) {
        this.systemName = systemName;
    }


    /**
     * Gets the systemReleasedDate value for this SystemInfo.
     * 
     * @return systemReleasedDate
     */
    public java.lang.String getSystemReleasedDate() {
        return systemReleasedDate;
    }


    /**
     * Sets the systemReleasedDate value for this SystemInfo.
     * 
     * @param systemReleasedDate
     */
    public void setSystemReleasedDate(java.lang.String systemReleasedDate) {
        this.systemReleasedDate = systemReleasedDate;
    }


    /**
     * Gets the systemVersion value for this SystemInfo.
     * 
     * @return systemVersion
     */
    public java.lang.String getSystemVersion() {
        return systemVersion;
    }


    /**
     * Sets the systemVersion value for this SystemInfo.
     * 
     * @param systemVersion
     */
    public void setSystemVersion(java.lang.String systemVersion) {
        this.systemVersion = systemVersion;
    }


    /**
     * Gets the valid value for this SystemInfo.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this SystemInfo.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SystemInfo)) return false;
        SystemInfo other = (SystemInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.systemName==null && other.getSystemName()==null) || 
             (this.systemName!=null &&
              this.systemName.equals(other.getSystemName()))) &&
            ((this.systemReleasedDate==null && other.getSystemReleasedDate()==null) || 
             (this.systemReleasedDate!=null &&
              this.systemReleasedDate.equals(other.getSystemReleasedDate()))) &&
            ((this.systemVersion==null && other.getSystemVersion()==null) || 
             (this.systemVersion!=null &&
              this.systemVersion.equals(other.getSystemVersion()))) &&
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
        if (getSystemName() != null) {
            _hashCode += getSystemName().hashCode();
        }
        if (getSystemReleasedDate() != null) {
            _hashCode += getSystemReleasedDate().hashCode();
        }
        if (getSystemVersion() != null) {
            _hashCode += getSystemVersion().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SystemInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "SystemInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "systemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemReleasedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "systemReleasedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "systemVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
