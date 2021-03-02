/**
 * TrackingData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.estafeta.www;

public class TrackingData  implements java.io.Serializable {
    private java.lang.String waybill;

    private java.lang.String shortWaybillId;

    private java.lang.String serviceId;

    private java.lang.String serviceDescriptionSPA;

    private java.lang.String serviceDescriptionENG;

    private java.lang.String customerNumber;

    private java.lang.String packageType;

    private java.lang.String additionalInformation;

    private java.lang.String statusSPA;

    private java.lang.String statusENG;

    private com.estafeta.www.PickupData pickupData;

    private com.estafeta.www.DeliveryData deliveryData;

    private com.estafeta.www.Dimensions dimensions;

    private com.estafeta.www.WaybillReplaceData waybillReplaceData;

    private com.estafeta.www.ReturnDocumentData returnDocumentData;

    private com.estafeta.www.MultipleServiceData multipleServiceData;

    private com.estafeta.www.InternationalData internationalData;

    private com.estafeta.www.CustomerInfo customerInfo;

    private com.estafeta.www.History[] history;

    private byte[] signature;

    public TrackingData() {
    }

    public TrackingData(
           java.lang.String waybill,
           java.lang.String shortWaybillId,
           java.lang.String serviceId,
           java.lang.String serviceDescriptionSPA,
           java.lang.String serviceDescriptionENG,
           java.lang.String customerNumber,
           java.lang.String packageType,
           java.lang.String additionalInformation,
           java.lang.String statusSPA,
           java.lang.String statusENG,
           com.estafeta.www.PickupData pickupData,
           com.estafeta.www.DeliveryData deliveryData,
           com.estafeta.www.Dimensions dimensions,
           com.estafeta.www.WaybillReplaceData waybillReplaceData,
           com.estafeta.www.ReturnDocumentData returnDocumentData,
           com.estafeta.www.MultipleServiceData multipleServiceData,
           com.estafeta.www.InternationalData internationalData,
           com.estafeta.www.CustomerInfo customerInfo,
           com.estafeta.www.History[] history,
           byte[] signature) {
           this.waybill = waybill;
           this.shortWaybillId = shortWaybillId;
           this.serviceId = serviceId;
           this.serviceDescriptionSPA = serviceDescriptionSPA;
           this.serviceDescriptionENG = serviceDescriptionENG;
           this.customerNumber = customerNumber;
           this.packageType = packageType;
           this.additionalInformation = additionalInformation;
           this.statusSPA = statusSPA;
           this.statusENG = statusENG;
           this.pickupData = pickupData;
           this.deliveryData = deliveryData;
           this.dimensions = dimensions;
           this.waybillReplaceData = waybillReplaceData;
           this.returnDocumentData = returnDocumentData;
           this.multipleServiceData = multipleServiceData;
           this.internationalData = internationalData;
           this.customerInfo = customerInfo;
           this.history = history;
           this.signature = signature;
    }


    /**
     * Gets the waybill value for this TrackingData.
     * 
     * @return waybill
     */
    public java.lang.String getWaybill() {
        return waybill;
    }


    /**
     * Sets the waybill value for this TrackingData.
     * 
     * @param waybill
     */
    public void setWaybill(java.lang.String waybill) {
        this.waybill = waybill;
    }


    /**
     * Gets the shortWaybillId value for this TrackingData.
     * 
     * @return shortWaybillId
     */
    public java.lang.String getShortWaybillId() {
        return shortWaybillId;
    }


    /**
     * Sets the shortWaybillId value for this TrackingData.
     * 
     * @param shortWaybillId
     */
    public void setShortWaybillId(java.lang.String shortWaybillId) {
        this.shortWaybillId = shortWaybillId;
    }


    /**
     * Gets the serviceId value for this TrackingData.
     * 
     * @return serviceId
     */
    public java.lang.String getServiceId() {
        return serviceId;
    }


    /**
     * Sets the serviceId value for this TrackingData.
     * 
     * @param serviceId
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }


    /**
     * Gets the serviceDescriptionSPA value for this TrackingData.
     * 
     * @return serviceDescriptionSPA
     */
    public java.lang.String getServiceDescriptionSPA() {
        return serviceDescriptionSPA;
    }


    /**
     * Sets the serviceDescriptionSPA value for this TrackingData.
     * 
     * @param serviceDescriptionSPA
     */
    public void setServiceDescriptionSPA(java.lang.String serviceDescriptionSPA) {
        this.serviceDescriptionSPA = serviceDescriptionSPA;
    }


    /**
     * Gets the serviceDescriptionENG value for this TrackingData.
     * 
     * @return serviceDescriptionENG
     */
    public java.lang.String getServiceDescriptionENG() {
        return serviceDescriptionENG;
    }


    /**
     * Sets the serviceDescriptionENG value for this TrackingData.
     * 
     * @param serviceDescriptionENG
     */
    public void setServiceDescriptionENG(java.lang.String serviceDescriptionENG) {
        this.serviceDescriptionENG = serviceDescriptionENG;
    }


    /**
     * Gets the customerNumber value for this TrackingData.
     * 
     * @return customerNumber
     */
    public java.lang.String getCustomerNumber() {
        return customerNumber;
    }


    /**
     * Sets the customerNumber value for this TrackingData.
     * 
     * @param customerNumber
     */
    public void setCustomerNumber(java.lang.String customerNumber) {
        this.customerNumber = customerNumber;
    }


    /**
     * Gets the packageType value for this TrackingData.
     * 
     * @return packageType
     */
    public java.lang.String getPackageType() {
        return packageType;
    }


    /**
     * Sets the packageType value for this TrackingData.
     * 
     * @param packageType
     */
    public void setPackageType(java.lang.String packageType) {
        this.packageType = packageType;
    }


    /**
     * Gets the additionalInformation value for this TrackingData.
     * 
     * @return additionalInformation
     */
    public java.lang.String getAdditionalInformation() {
        return additionalInformation;
    }


    /**
     * Sets the additionalInformation value for this TrackingData.
     * 
     * @param additionalInformation
     */
    public void setAdditionalInformation(java.lang.String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


    /**
     * Gets the statusSPA value for this TrackingData.
     * 
     * @return statusSPA
     */
    public java.lang.String getStatusSPA() {
        return statusSPA;
    }


    /**
     * Sets the statusSPA value for this TrackingData.
     * 
     * @param statusSPA
     */
    public void setStatusSPA(java.lang.String statusSPA) {
        this.statusSPA = statusSPA;
    }


    /**
     * Gets the statusENG value for this TrackingData.
     * 
     * @return statusENG
     */
    public java.lang.String getStatusENG() {
        return statusENG;
    }


    /**
     * Sets the statusENG value for this TrackingData.
     * 
     * @param statusENG
     */
    public void setStatusENG(java.lang.String statusENG) {
        this.statusENG = statusENG;
    }


    /**
     * Gets the pickupData value for this TrackingData.
     * 
     * @return pickupData
     */
    public com.estafeta.www.PickupData getPickupData() {
        return pickupData;
    }


    /**
     * Sets the pickupData value for this TrackingData.
     * 
     * @param pickupData
     */
    public void setPickupData(com.estafeta.www.PickupData pickupData) {
        this.pickupData = pickupData;
    }


    /**
     * Gets the deliveryData value for this TrackingData.
     * 
     * @return deliveryData
     */
    public com.estafeta.www.DeliveryData getDeliveryData() {
        return deliveryData;
    }


    /**
     * Sets the deliveryData value for this TrackingData.
     * 
     * @param deliveryData
     */
    public void setDeliveryData(com.estafeta.www.DeliveryData deliveryData) {
        this.deliveryData = deliveryData;
    }


    /**
     * Gets the dimensions value for this TrackingData.
     * 
     * @return dimensions
     */
    public com.estafeta.www.Dimensions getDimensions() {
        return dimensions;
    }


    /**
     * Sets the dimensions value for this TrackingData.
     * 
     * @param dimensions
     */
    public void setDimensions(com.estafeta.www.Dimensions dimensions) {
        this.dimensions = dimensions;
    }


    /**
     * Gets the waybillReplaceData value for this TrackingData.
     * 
     * @return waybillReplaceData
     */
    public com.estafeta.www.WaybillReplaceData getWaybillReplaceData() {
        return waybillReplaceData;
    }


    /**
     * Sets the waybillReplaceData value for this TrackingData.
     * 
     * @param waybillReplaceData
     */
    public void setWaybillReplaceData(com.estafeta.www.WaybillReplaceData waybillReplaceData) {
        this.waybillReplaceData = waybillReplaceData;
    }


    /**
     * Gets the returnDocumentData value for this TrackingData.
     * 
     * @return returnDocumentData
     */
    public com.estafeta.www.ReturnDocumentData getReturnDocumentData() {
        return returnDocumentData;
    }


    /**
     * Sets the returnDocumentData value for this TrackingData.
     * 
     * @param returnDocumentData
     */
    public void setReturnDocumentData(com.estafeta.www.ReturnDocumentData returnDocumentData) {
        this.returnDocumentData = returnDocumentData;
    }


    /**
     * Gets the multipleServiceData value for this TrackingData.
     * 
     * @return multipleServiceData
     */
    public com.estafeta.www.MultipleServiceData getMultipleServiceData() {
        return multipleServiceData;
    }


    /**
     * Sets the multipleServiceData value for this TrackingData.
     * 
     * @param multipleServiceData
     */
    public void setMultipleServiceData(com.estafeta.www.MultipleServiceData multipleServiceData) {
        this.multipleServiceData = multipleServiceData;
    }


    /**
     * Gets the internationalData value for this TrackingData.
     * 
     * @return internationalData
     */
    public com.estafeta.www.InternationalData getInternationalData() {
        return internationalData;
    }


    /**
     * Sets the internationalData value for this TrackingData.
     * 
     * @param internationalData
     */
    public void setInternationalData(com.estafeta.www.InternationalData internationalData) {
        this.internationalData = internationalData;
    }


    /**
     * Gets the customerInfo value for this TrackingData.
     * 
     * @return customerInfo
     */
    public com.estafeta.www.CustomerInfo getCustomerInfo() {
        return customerInfo;
    }


    /**
     * Sets the customerInfo value for this TrackingData.
     * 
     * @param customerInfo
     */
    public void setCustomerInfo(com.estafeta.www.CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }


    /**
     * Gets the history value for this TrackingData.
     * 
     * @return history
     */
    public com.estafeta.www.History[] getHistory() {
        return history;
    }


    /**
     * Sets the history value for this TrackingData.
     * 
     * @param history
     */
    public void setHistory(com.estafeta.www.History[] history) {
        this.history = history;
    }


    /**
     * Gets the signature value for this TrackingData.
     * 
     * @return signature
     */
    public byte[] getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this TrackingData.
     * 
     * @param signature
     */
    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrackingData)) return false;
        TrackingData other = (TrackingData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.waybill==null && other.getWaybill()==null) || 
             (this.waybill!=null &&
              this.waybill.equals(other.getWaybill()))) &&
            ((this.shortWaybillId==null && other.getShortWaybillId()==null) || 
             (this.shortWaybillId!=null &&
              this.shortWaybillId.equals(other.getShortWaybillId()))) &&
            ((this.serviceId==null && other.getServiceId()==null) || 
             (this.serviceId!=null &&
              this.serviceId.equals(other.getServiceId()))) &&
            ((this.serviceDescriptionSPA==null && other.getServiceDescriptionSPA()==null) || 
             (this.serviceDescriptionSPA!=null &&
              this.serviceDescriptionSPA.equals(other.getServiceDescriptionSPA()))) &&
            ((this.serviceDescriptionENG==null && other.getServiceDescriptionENG()==null) || 
             (this.serviceDescriptionENG!=null &&
              this.serviceDescriptionENG.equals(other.getServiceDescriptionENG()))) &&
            ((this.customerNumber==null && other.getCustomerNumber()==null) || 
             (this.customerNumber!=null &&
              this.customerNumber.equals(other.getCustomerNumber()))) &&
            ((this.packageType==null && other.getPackageType()==null) || 
             (this.packageType!=null &&
              this.packageType.equals(other.getPackageType()))) &&
            ((this.additionalInformation==null && other.getAdditionalInformation()==null) || 
             (this.additionalInformation!=null &&
              this.additionalInformation.equals(other.getAdditionalInformation()))) &&
            ((this.statusSPA==null && other.getStatusSPA()==null) || 
             (this.statusSPA!=null &&
              this.statusSPA.equals(other.getStatusSPA()))) &&
            ((this.statusENG==null && other.getStatusENG()==null) || 
             (this.statusENG!=null &&
              this.statusENG.equals(other.getStatusENG()))) &&
            ((this.pickupData==null && other.getPickupData()==null) || 
             (this.pickupData!=null &&
              this.pickupData.equals(other.getPickupData()))) &&
            ((this.deliveryData==null && other.getDeliveryData()==null) || 
             (this.deliveryData!=null &&
              this.deliveryData.equals(other.getDeliveryData()))) &&
            ((this.dimensions==null && other.getDimensions()==null) || 
             (this.dimensions!=null &&
              this.dimensions.equals(other.getDimensions()))) &&
            ((this.waybillReplaceData==null && other.getWaybillReplaceData()==null) || 
             (this.waybillReplaceData!=null &&
              this.waybillReplaceData.equals(other.getWaybillReplaceData()))) &&
            ((this.returnDocumentData==null && other.getReturnDocumentData()==null) || 
             (this.returnDocumentData!=null &&
              this.returnDocumentData.equals(other.getReturnDocumentData()))) &&
            ((this.multipleServiceData==null && other.getMultipleServiceData()==null) || 
             (this.multipleServiceData!=null &&
              this.multipleServiceData.equals(other.getMultipleServiceData()))) &&
            ((this.internationalData==null && other.getInternationalData()==null) || 
             (this.internationalData!=null &&
              this.internationalData.equals(other.getInternationalData()))) &&
            ((this.customerInfo==null && other.getCustomerInfo()==null) || 
             (this.customerInfo!=null &&
              this.customerInfo.equals(other.getCustomerInfo()))) &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              java.util.Arrays.equals(this.history, other.getHistory()))) &&
            ((this.signature==null && other.getSignature()==null) || 
             (this.signature!=null &&
              java.util.Arrays.equals(this.signature, other.getSignature())));
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
        if (getWaybill() != null) {
            _hashCode += getWaybill().hashCode();
        }
        if (getShortWaybillId() != null) {
            _hashCode += getShortWaybillId().hashCode();
        }
        if (getServiceId() != null) {
            _hashCode += getServiceId().hashCode();
        }
        if (getServiceDescriptionSPA() != null) {
            _hashCode += getServiceDescriptionSPA().hashCode();
        }
        if (getServiceDescriptionENG() != null) {
            _hashCode += getServiceDescriptionENG().hashCode();
        }
        if (getCustomerNumber() != null) {
            _hashCode += getCustomerNumber().hashCode();
        }
        if (getPackageType() != null) {
            _hashCode += getPackageType().hashCode();
        }
        if (getAdditionalInformation() != null) {
            _hashCode += getAdditionalInformation().hashCode();
        }
        if (getStatusSPA() != null) {
            _hashCode += getStatusSPA().hashCode();
        }
        if (getStatusENG() != null) {
            _hashCode += getStatusENG().hashCode();
        }
        if (getPickupData() != null) {
            _hashCode += getPickupData().hashCode();
        }
        if (getDeliveryData() != null) {
            _hashCode += getDeliveryData().hashCode();
        }
        if (getDimensions() != null) {
            _hashCode += getDimensions().hashCode();
        }
        if (getWaybillReplaceData() != null) {
            _hashCode += getWaybillReplaceData().hashCode();
        }
        if (getReturnDocumentData() != null) {
            _hashCode += getReturnDocumentData().hashCode();
        }
        if (getMultipleServiceData() != null) {
            _hashCode += getMultipleServiceData().hashCode();
        }
        if (getInternationalData() != null) {
            _hashCode += getInternationalData().hashCode();
        }
        if (getCustomerInfo() != null) {
            _hashCode += getCustomerInfo().hashCode();
        }
        if (getHistory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHistory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHistory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSignature() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignature());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignature(), i);
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
        new org.apache.axis.description.TypeDesc(TrackingData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "TrackingData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybill");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybill"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortWaybillId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "shortWaybillId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "serviceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDescriptionSPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "serviceDescriptionSPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDescriptionENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "serviceDescriptionENG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "customerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "packageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "additionalInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusSPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "statusSPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusENG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "statusENG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pickupData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "pickupData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "PickupData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "deliveryData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "DeliveryData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dimensions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "dimensions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "Dimensions"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waybillReplaceData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "waybillReplaceData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "WaybillReplaceData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnDocumentData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "returnDocumentData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "ReturnDocumentData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multipleServiceData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "multipleServiceData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "MultipleServiceData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "internationalData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "InternationalData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "customerInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "CustomerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "history"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.estafeta.com/", "History"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.estafeta.com/", "History"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signature");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.estafeta.com/", "signature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
