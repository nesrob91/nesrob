/**
 * EstafetaLabelSimpleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class EstafetaLabelSimpleResponse  implements java.io.Serializable {
    private GlobalSimpleResult globalSimpleResult;

    private PrinterSystem printerSystem;

    private boolean valid;

    private WaybillEstafeta[] waybillEstafeta;

    private WaybillGeneratorSystem waybillGeneratorSystem;

    public EstafetaLabelSimpleResponse() {
    }

    public EstafetaLabelSimpleResponse(
           GlobalSimpleResult globalSimpleResult,
           PrinterSystem printerSystem,
           boolean valid,
           WaybillEstafeta[] waybillEstafeta,
           WaybillGeneratorSystem waybillGeneratorSystem) {
           this.globalSimpleResult = globalSimpleResult;
           this.printerSystem = printerSystem;
           this.valid = valid;
           this.waybillEstafeta = waybillEstafeta;
           this.waybillGeneratorSystem = waybillGeneratorSystem;
    }


    /**
     * Gets the globalSimpleResult value for this EstafetaLabelSimpleResponse.
     * 
     * @return globalSimpleResult
     */
    public GlobalSimpleResult getGlobalSimpleResult() {
        return globalSimpleResult;
    }


    /**
     * Sets the globalSimpleResult value for this EstafetaLabelSimpleResponse.
     * 
     * @param globalSimpleResult
     */
    public void setGlobalSimpleResult(GlobalSimpleResult globalSimpleResult) {
        this.globalSimpleResult = globalSimpleResult;
    }


    /**
     * Gets the printerSystem value for this EstafetaLabelSimpleResponse.
     * 
     * @return printerSystem
     */
    public PrinterSystem getPrinterSystem() {
        return printerSystem;
    }


    /**
     * Sets the printerSystem value for this EstafetaLabelSimpleResponse.
     * 
     * @param printerSystem
     */
    public void setPrinterSystem(PrinterSystem printerSystem) {
        this.printerSystem = printerSystem;
    }


    /**
     * Gets the valid value for this EstafetaLabelSimpleResponse.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this EstafetaLabelSimpleResponse.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the waybillEstafeta value for this EstafetaLabelSimpleResponse.
     * 
     * @return waybillEstafeta
     */
    public WaybillEstafeta[] getWaybillEstafeta() {
        return waybillEstafeta;
    }


    /**
     * Sets the waybillEstafeta value for this EstafetaLabelSimpleResponse.
     * 
     * @param waybillEstafeta
     */
    public void setWaybillEstafeta(WaybillEstafeta[] waybillEstafeta) {
        this.waybillEstafeta = waybillEstafeta;
    }


    /**
     * Gets the waybillGeneratorSystem value for this EstafetaLabelSimpleResponse.
     * 
     * @return waybillGeneratorSystem
     */
    public WaybillGeneratorSystem getWaybillGeneratorSystem() {
        return waybillGeneratorSystem;
    }


    /**
     * Sets the waybillGeneratorSystem value for this EstafetaLabelSimpleResponse.
     * 
     * @param waybillGeneratorSystem
     */
    public void setWaybillGeneratorSystem(WaybillGeneratorSystem waybillGeneratorSystem) {
        this.waybillGeneratorSystem = waybillGeneratorSystem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstafetaLabelSimpleResponse)) return false;
        EstafetaLabelSimpleResponse other = (EstafetaLabelSimpleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.globalSimpleResult==null && other.getGlobalSimpleResult()==null) || 
             (this.globalSimpleResult!=null &&
              this.globalSimpleResult.equals(other.getGlobalSimpleResult()))) &&
            ((this.printerSystem==null && other.getPrinterSystem()==null) || 
             (this.printerSystem!=null &&
              this.printerSystem.equals(other.getPrinterSystem()))) &&
            this.valid == other.isValid() &&
            ((this.waybillEstafeta==null && other.getWaybillEstafeta()==null) || 
             (this.waybillEstafeta!=null &&
              java.util.Arrays.equals(this.waybillEstafeta, other.getWaybillEstafeta()))) &&
            ((this.waybillGeneratorSystem==null && other.getWaybillGeneratorSystem()==null) || 
             (this.waybillGeneratorSystem!=null &&
              this.waybillGeneratorSystem.equals(other.getWaybillGeneratorSystem())));
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
        if (getGlobalSimpleResult() != null) {
            _hashCode += getGlobalSimpleResult().hashCode();
        }
        if (getPrinterSystem() != null) {
            _hashCode += getPrinterSystem().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getWaybillEstafeta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWaybillEstafeta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWaybillEstafeta(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWaybillGeneratorSystem() != null) {
            _hashCode += getWaybillGeneratorSystem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstafetaLabelSimpleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("globalSimpleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "globalSimpleResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "GlobalSimpleResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("printerSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "printerSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "PrinterSystem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillEstafeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waybillEstafeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "WaybillEstafeta"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillGeneratorSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waybillGeneratorSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "WaybillGeneratorSystem"));
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
