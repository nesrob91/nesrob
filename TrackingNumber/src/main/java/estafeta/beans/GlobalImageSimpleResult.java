/**
 * GlobalImageSimpleResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class GlobalImageSimpleResult  extends Result  implements java.io.Serializable {
    private byte[] _imgCartaPorte;

    private byte[] _imgDomicilioFiscal;

    private byte[] _imgLogoEstafeta;

    public GlobalImageSimpleResult() {
    }

    public GlobalImageSimpleResult(
           int resultCode,
           java.lang.String resultDescription,
           java.lang.String resultSpanishDescription,
           boolean valid,
           byte[] _imgCartaPorte,
           byte[] _imgDomicilioFiscal,
           byte[] _imgLogoEstafeta) {
        super(
            resultCode,
            resultDescription,
            resultSpanishDescription,
            valid);
        this._imgCartaPorte = _imgCartaPorte;
        this._imgDomicilioFiscal = _imgDomicilioFiscal;
        this._imgLogoEstafeta = _imgLogoEstafeta;
    }


    /**
     * Gets the _imgCartaPorte value for this GlobalImageSimpleResult.
     * 
     * @return _imgCartaPorte
     */
    public byte[] get_imgCartaPorte() {
        return _imgCartaPorte;
    }


    /**
     * Sets the _imgCartaPorte value for this GlobalImageSimpleResult.
     * 
     * @param _imgCartaPorte
     */
    public void set_imgCartaPorte(byte[] _imgCartaPorte) {
        this._imgCartaPorte = _imgCartaPorte;
    }


    /**
     * Gets the _imgDomicilioFiscal value for this GlobalImageSimpleResult.
     * 
     * @return _imgDomicilioFiscal
     */
    public byte[] get_imgDomicilioFiscal() {
        return _imgDomicilioFiscal;
    }


    /**
     * Sets the _imgDomicilioFiscal value for this GlobalImageSimpleResult.
     * 
     * @param _imgDomicilioFiscal
     */
    public void set_imgDomicilioFiscal(byte[] _imgDomicilioFiscal) {
        this._imgDomicilioFiscal = _imgDomicilioFiscal;
    }


    /**
     * Gets the _imgLogoEstafeta value for this GlobalImageSimpleResult.
     * 
     * @return _imgLogoEstafeta
     */
    public byte[] get_imgLogoEstafeta() {
        return _imgLogoEstafeta;
    }


    /**
     * Sets the _imgLogoEstafeta value for this GlobalImageSimpleResult.
     * 
     * @param _imgLogoEstafeta
     */
    public void set_imgLogoEstafeta(byte[] _imgLogoEstafeta) {
        this._imgLogoEstafeta = _imgLogoEstafeta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GlobalImageSimpleResult)) return false;
        GlobalImageSimpleResult other = (GlobalImageSimpleResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this._imgCartaPorte==null && other.get_imgCartaPorte()==null) || 
             (this._imgCartaPorte!=null &&
              java.util.Arrays.equals(this._imgCartaPorte, other.get_imgCartaPorte()))) &&
            ((this._imgDomicilioFiscal==null && other.get_imgDomicilioFiscal()==null) || 
             (this._imgDomicilioFiscal!=null &&
              java.util.Arrays.equals(this._imgDomicilioFiscal, other.get_imgDomicilioFiscal()))) &&
            ((this._imgLogoEstafeta==null && other.get_imgLogoEstafeta()==null) || 
             (this._imgLogoEstafeta!=null &&
              java.util.Arrays.equals(this._imgLogoEstafeta, other.get_imgLogoEstafeta())));
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
        if (get_imgCartaPorte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_imgCartaPorte());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_imgCartaPorte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (get_imgDomicilioFiscal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_imgDomicilioFiscal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_imgDomicilioFiscal(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (get_imgLogoEstafeta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_imgLogoEstafeta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_imgLogoEstafeta(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GlobalImageSimpleResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "GlobalImageSimpleResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_imgCartaPorte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "_imgCartaPorte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_imgDomicilioFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "_imgDomicilioFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_imgLogoEstafeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "_imgLogoEstafeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
