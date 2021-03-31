/**
 * EstafetaLabelSimpleRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class EstafetaLabelSimpleRequest  implements java.io.Serializable {
    private java.lang.String customerNumber;

    private LabelSimpleDescriptionData labelSimpleDescriptionData;

    private java.lang.String login;

    private java.lang.String password;

    private PrinterSystem printerSystem;

    private java.lang.String suscriberId;

    private boolean valid;

    public EstafetaLabelSimpleRequest() {
    }

    public EstafetaLabelSimpleRequest(
           java.lang.String customerNumber,
           LabelSimpleDescriptionData labelSimpleDescriptionData,
           java.lang.String login,
           java.lang.String password,
           PrinterSystem printerSystem,
           java.lang.String suscriberId,
           boolean valid) {
           this.customerNumber = customerNumber;
           this.labelSimpleDescriptionData = labelSimpleDescriptionData;
           this.login = login;
           this.password = password;
           this.printerSystem = printerSystem;
           this.suscriberId = suscriberId;
           this.valid = valid;
    }


    /**
     * Gets the customerNumber value for this EstafetaLabelSimpleRequest.
     * 
     * @return customerNumber
     */
    public java.lang.String getCustomerNumber() {
        return customerNumber;
    }


    /**
     * Sets the customerNumber value for this EstafetaLabelSimpleRequest.
     * 
     * @param customerNumber
     */
    public void setCustomerNumber(java.lang.String customerNumber) {
        this.customerNumber = customerNumber;
    }


    /**
     * Gets the labelSimpleDescriptionData value for this EstafetaLabelSimpleRequest.
     * 
     * @return labelSimpleDescriptionData
     */
    public LabelSimpleDescriptionData getLabelSimpleDescriptionData() {
        return labelSimpleDescriptionData;
    }


    /**
     * Sets the labelSimpleDescriptionData value for this EstafetaLabelSimpleRequest.
     * 
     * @param labelSimpleDescriptionData
     */
    public void setLabelSimpleDescriptionData(LabelSimpleDescriptionData labelSimpleDescriptionData) {
        this.labelSimpleDescriptionData = labelSimpleDescriptionData;
    }


    /**
     * Gets the login value for this EstafetaLabelSimpleRequest.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this EstafetaLabelSimpleRequest.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the password value for this EstafetaLabelSimpleRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this EstafetaLabelSimpleRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the printerSystem value for this EstafetaLabelSimpleRequest.
     * 
     * @return printerSystem
     */
    public PrinterSystem getPrinterSystem() {
        return printerSystem;
    }


    /**
     * Sets the printerSystem value for this EstafetaLabelSimpleRequest.
     * 
     * @param printerSystem
     */
    public void setPrinterSystem(PrinterSystem printerSystem) {
        this.printerSystem = printerSystem;
    }


    /**
     * Gets the suscriberId value for this EstafetaLabelSimpleRequest.
     * 
     * @return suscriberId
     */
    public java.lang.String getSuscriberId() {
        return suscriberId;
    }


    /**
     * Sets the suscriberId value for this EstafetaLabelSimpleRequest.
     * 
     * @param suscriberId
     */
    public void setSuscriberId(java.lang.String suscriberId) {
        this.suscriberId = suscriberId;
    }


    /**
     * Gets the valid value for this EstafetaLabelSimpleRequest.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this EstafetaLabelSimpleRequest.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstafetaLabelSimpleRequest)) return false;
        EstafetaLabelSimpleRequest other = (EstafetaLabelSimpleRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customerNumber==null && other.getCustomerNumber()==null) || 
             (this.customerNumber!=null &&
              this.customerNumber.equals(other.getCustomerNumber()))) &&
            ((this.labelSimpleDescriptionData==null && other.getLabelSimpleDescriptionData()==null) || 
             (this.labelSimpleDescriptionData!=null &&
              this.labelSimpleDescriptionData.equals(other.getLabelSimpleDescriptionData()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.printerSystem==null && other.getPrinterSystem()==null) || 
             (this.printerSystem!=null &&
              this.printerSystem.equals(other.getPrinterSystem()))) &&
            ((this.suscriberId==null && other.getSuscriberId()==null) || 
             (this.suscriberId!=null &&
              this.suscriberId.equals(other.getSuscriberId()))) &&
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
        if (getCustomerNumber() != null) {
            _hashCode += getCustomerNumber().hashCode();
        }
        if (getLabelSimpleDescriptionData() != null) {
            _hashCode += getLabelSimpleDescriptionData().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPrinterSystem() != null) {
            _hashCode += getPrinterSystem().hashCode();
        }
        if (getSuscriberId() != null) {
            _hashCode += getSuscriberId().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstafetaLabelSimpleRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelSimpleDescriptionData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelSimpleDescriptionData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelSimpleDescriptionData"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("printerSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "printerSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "PrinterSystem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscriberId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscriberId"));
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
