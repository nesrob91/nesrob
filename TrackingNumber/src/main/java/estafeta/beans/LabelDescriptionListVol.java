/**
 * LabelDescriptionListVol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class LabelDescriptionListVol  extends LabelDescriptionVol  implements java.io.Serializable {
    public LabelDescriptionListVol() {
    }

    public LabelDescriptionListVol(
           DRAlternativeInfo DRAlternativeInfo,
           java.lang.String aditionalInfo,
           COD cod,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String costCenter,
           java.lang.String customerID,
           boolean deliveryToEstafetaOffice,
           java.lang.String destinationCountryId,
           DestinationInfoVol destinationInfo,
           java.lang.String effectiveDate,
           int numberOfLabels,
           java.lang.String officeNum,
           OriginInfoVol originInfo,
           java.lang.String originZipCodeForRouting,
           int parcelTypeId,
           java.lang.String reference,
           boolean returnDocument,
           java.lang.String serviceTypeAditional,
           java.lang.String serviceTypeAditionalID,
           java.lang.String serviceTypeId,
           java.lang.String serviceTypeIdDocRet,
           java.lang.String shipmentGroupID,
           SystemInformationVol systemInformationVol,
           boolean valid,
           float weight) {
        super(
            DRAlternativeInfo,
            aditionalInfo,
            cod,
            content,
            contentDescription,
            costCenter,
            customerID,
            deliveryToEstafetaOffice,
            destinationCountryId,
            destinationInfo,
            effectiveDate,
            numberOfLabels,
            officeNum,
            originInfo,
            originZipCodeForRouting,
            parcelTypeId,
            reference,
            returnDocument,
            serviceTypeAditional,
            serviceTypeAditionalID,
            serviceTypeId,
            serviceTypeIdDocRet,
            shipmentGroupID,
            systemInformationVol,
            valid,
            weight);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelDescriptionListVol)) return false;
        LabelDescriptionListVol other = (LabelDescriptionListVol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LabelDescriptionListVol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelDescriptionListVol"));
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
