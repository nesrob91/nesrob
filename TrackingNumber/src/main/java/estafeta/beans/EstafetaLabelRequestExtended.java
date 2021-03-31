/**
 * EstafetaLabelRequestExtended.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstafetaLabelRequestExtended  implements java.io.Serializable {
    private java.lang.String customerNumber;

    private LabelDescriptionListExtended[] labelDescriptionList;

    private int labelDescriptionListCount;

    private java.lang.String login;

    private int paperType;

    private java.lang.String password;

    private int quadrant;

    private java.lang.String secType;

    private java.lang.String suscriberId;

    private boolean valid;

    public EstafetaLabelRequestExtended() {
    }

    public EstafetaLabelRequestExtended(
           java.lang.String customerNumber,
           LabelDescriptionListExtended[] labelDescriptionList,
           int labelDescriptionListCount,
           java.lang.String login,
           int paperType,
           java.lang.String password,
           int quadrant,
           java.lang.String secType,
           java.lang.String suscriberId,
           boolean valid) {
           this.customerNumber = customerNumber;
           this.labelDescriptionList = labelDescriptionList;
           this.labelDescriptionListCount = labelDescriptionListCount;
           this.login = login;
           this.paperType = paperType;
           this.password = password;
           this.quadrant = quadrant;
           this.secType = secType;
           this.suscriberId = suscriberId;
           this.valid = valid;
    }


    /**
     * Gets the customerNumber value for this EstafetaLabelRequestExtended.
     * 
     * @return customerNumber
     */
    public java.lang.String getCustomerNumber() {
        return customerNumber;
    }


    /**
     * Sets the customerNumber value for this EstafetaLabelRequestExtended.
     * 
     * @param customerNumber
     */
    public void setCustomerNumber(java.lang.String customerNumber) {
        this.customerNumber = customerNumber;
    }


    /**
     * Gets the labelDescriptionList value for this EstafetaLabelRequestExtended.
     * 
     * @return labelDescriptionList
     */
    public LabelDescriptionListExtended[] getLabelDescriptionList() {
        return labelDescriptionList;
    }


    /**
     * Sets the labelDescriptionList value for this EstafetaLabelRequestExtended.
     * 
     * @param labelDescriptionList
     */
    public void setLabelDescriptionList(LabelDescriptionListExtended[] labelDescriptionList) {
        this.labelDescriptionList = labelDescriptionList;
    }

    public LabelDescriptionListExtended getLabelDescriptionList(int i) {
        return this.labelDescriptionList[i];
    }

    public void setLabelDescriptionList(int i, LabelDescriptionListExtended _value) {
        this.labelDescriptionList[i] = _value;
    }


    /**
     * Gets the labelDescriptionListCount value for this EstafetaLabelRequestExtended.
     * 
     * @return labelDescriptionListCount
     */
    public int getLabelDescriptionListCount() {
        return labelDescriptionListCount;
    }


    /**
     * Sets the labelDescriptionListCount value for this EstafetaLabelRequestExtended.
     * 
     * @param labelDescriptionListCount
     */
    public void setLabelDescriptionListCount(int labelDescriptionListCount) {
        this.labelDescriptionListCount = labelDescriptionListCount;
    }


    /**
     * Gets the login value for this EstafetaLabelRequestExtended.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this EstafetaLabelRequestExtended.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the paperType value for this EstafetaLabelRequestExtended.
     * 
     * @return paperType
     */
    public int getPaperType() {
        return paperType;
    }


    /**
     * Sets the paperType value for this EstafetaLabelRequestExtended.
     * 
     * @param paperType
     */
    public void setPaperType(int paperType) {
        this.paperType = paperType;
    }


    /**
     * Gets the password value for this EstafetaLabelRequestExtended.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this EstafetaLabelRequestExtended.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the quadrant value for this EstafetaLabelRequestExtended.
     * 
     * @return quadrant
     */
    public int getQuadrant() {
        return quadrant;
    }


    /**
     * Sets the quadrant value for this EstafetaLabelRequestExtended.
     * 
     * @param quadrant
     */
    public void setQuadrant(int quadrant) {
        this.quadrant = quadrant;
    }


    /**
     * Gets the secType value for this EstafetaLabelRequestExtended.
     * 
     * @return secType
     */
    public java.lang.String getSecType() {
        return secType;
    }


    /**
     * Sets the secType value for this EstafetaLabelRequestExtended.
     * 
     * @param secType
     */
    public void setSecType(java.lang.String secType) {
        this.secType = secType;
    }


    /**
     * Gets the suscriberId value for this EstafetaLabelRequestExtended.
     * 
     * @return suscriberId
     */
    public java.lang.String getSuscriberId() {
        return suscriberId;
    }


    /**
     * Sets the suscriberId value for this EstafetaLabelRequestExtended.
     * 
     * @param suscriberId
     */
    public void setSuscriberId(java.lang.String suscriberId) {
        this.suscriberId = suscriberId;
    }


    /**
     * Gets the valid value for this EstafetaLabelRequestExtended.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this EstafetaLabelRequestExtended.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstafetaLabelRequestExtended)) return false;
        EstafetaLabelRequestExtended other = (EstafetaLabelRequestExtended) obj;
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
            ((this.labelDescriptionList==null && other.getLabelDescriptionList()==null) || 
             (this.labelDescriptionList!=null &&
              java.util.Arrays.equals(this.labelDescriptionList, other.getLabelDescriptionList()))) &&
            this.labelDescriptionListCount == other.getLabelDescriptionListCount() &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.paperType == other.getPaperType() &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            this.quadrant == other.getQuadrant() &&
            ((this.secType==null && other.getSecType()==null) || 
             (this.secType!=null &&
              this.secType.equals(other.getSecType()))) &&
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
        if (getLabelDescriptionList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLabelDescriptionList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLabelDescriptionList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getLabelDescriptionListCount();
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += getPaperType();
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        _hashCode += getQuadrant();
        if (getSecType() != null) {
            _hashCode += getSecType().hashCode();
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
        new org.apache.axis.description.TypeDesc(EstafetaLabelRequestExtended.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestExtended"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelDescriptionList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelDescriptionList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelDescriptionListExtended"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labelDescriptionListCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labelDescriptionListCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paperType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paperType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quadrant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quadrant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "secType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
