/**
 * LabelDescriptionExtended.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta.beans;

public class LabelDescriptionExtended  implements java.io.Serializable {
    private DRAlternativeInfo DRAlternativeInfo;

    private java.lang.String aditionalInfo;

    private COD cod;

    private java.lang.String content;

    private java.lang.String contentDescription;

    private java.lang.String costCenter;

    private java.lang.String customerID;

    private float declaredValue;

    private boolean deliveryToEstafetaOffice;

    private java.lang.String destinationCountryId;

    private DestinationInfoExtended destinationInfo;

    private DimensionsInfo dimensionsInfo;

    private java.lang.String effectiveDate;

    private boolean insurance;

    private int numberOfLabels;

    private java.lang.String officeNum;

    private OriginInfoExtended originInfo;

    private OriginPallet originPallet;

    private java.lang.String originZipCodeForRouting;

    private int parcelTypeId;

    private java.lang.String reference;

    private boolean returnDocument;

    private java.lang.String serviceTypeAditional;

    private java.lang.String serviceTypeAditionalID;

    private java.lang.String serviceTypeId;

    private java.lang.String serviceTypeIdDocRet;

    private java.lang.String shipmentGroupID;

    private SystemInformationVol systemInformationVol;

    private boolean valid;

    private float weight;

    public LabelDescriptionExtended() {
    }

    public LabelDescriptionExtended(
           DRAlternativeInfo DRAlternativeInfo,
           java.lang.String aditionalInfo,
           COD cod,
           java.lang.String content,
           java.lang.String contentDescription,
           java.lang.String costCenter,
           java.lang.String customerID,
           float declaredValue,
           boolean deliveryToEstafetaOffice,
           java.lang.String destinationCountryId,
           DestinationInfoExtended destinationInfo,
           DimensionsInfo dimensionsInfo,
           java.lang.String effectiveDate,
           boolean insurance,
           int numberOfLabels,
           java.lang.String officeNum,
           OriginInfoExtended originInfo,
           OriginPallet originPallet,
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
           this.DRAlternativeInfo = DRAlternativeInfo;
           this.aditionalInfo = aditionalInfo;
           this.cod = cod;
           this.content = content;
           this.contentDescription = contentDescription;
           this.costCenter = costCenter;
           this.customerID = customerID;
           this.declaredValue = declaredValue;
           this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
           this.destinationCountryId = destinationCountryId;
           this.destinationInfo = destinationInfo;
           this.dimensionsInfo = dimensionsInfo;
           this.effectiveDate = effectiveDate;
           this.insurance = insurance;
           this.numberOfLabels = numberOfLabels;
           this.officeNum = officeNum;
           this.originInfo = originInfo;
           this.originPallet = originPallet;
           this.originZipCodeForRouting = originZipCodeForRouting;
           this.parcelTypeId = parcelTypeId;
           this.reference = reference;
           this.returnDocument = returnDocument;
           this.serviceTypeAditional = serviceTypeAditional;
           this.serviceTypeAditionalID = serviceTypeAditionalID;
           this.serviceTypeId = serviceTypeId;
           this.serviceTypeIdDocRet = serviceTypeIdDocRet;
           this.shipmentGroupID = shipmentGroupID;
           this.systemInformationVol = systemInformationVol;
           this.valid = valid;
           this.weight = weight;
    }


    /**
     * Gets the DRAlternativeInfo value for this LabelDescriptionExtended.
     * 
     * @return DRAlternativeInfo
     */
    public DRAlternativeInfo getDRAlternativeInfo() {
        return DRAlternativeInfo;
    }


    /**
     * Sets the DRAlternativeInfo value for this LabelDescriptionExtended.
     * 
     * @param DRAlternativeInfo
     */
    public void setDRAlternativeInfo(DRAlternativeInfo DRAlternativeInfo) {
        this.DRAlternativeInfo = DRAlternativeInfo;
    }


    /**
     * Gets the aditionalInfo value for this LabelDescriptionExtended.
     * 
     * @return aditionalInfo
     */
    public java.lang.String getAditionalInfo() {
        return aditionalInfo;
    }


    /**
     * Sets the aditionalInfo value for this LabelDescriptionExtended.
     * 
     * @param aditionalInfo
     */
    public void setAditionalInfo(java.lang.String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }


    /**
     * Gets the cod value for this LabelDescriptionExtended.
     * 
     * @return cod
     */
    public COD getCod() {
        return cod;
    }


    /**
     * Sets the cod value for this LabelDescriptionExtended.
     * 
     * @param cod
     */
    public void setCod(COD cod) {
        this.cod = cod;
    }


    /**
     * Gets the content value for this LabelDescriptionExtended.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this LabelDescriptionExtended.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the contentDescription value for this LabelDescriptionExtended.
     * 
     * @return contentDescription
     */
    public java.lang.String getContentDescription() {
        return contentDescription;
    }


    /**
     * Sets the contentDescription value for this LabelDescriptionExtended.
     * 
     * @param contentDescription
     */
    public void setContentDescription(java.lang.String contentDescription) {
        this.contentDescription = contentDescription;
    }


    /**
     * Gets the costCenter value for this LabelDescriptionExtended.
     * 
     * @return costCenter
     */
    public java.lang.String getCostCenter() {
        return costCenter;
    }


    /**
     * Sets the costCenter value for this LabelDescriptionExtended.
     * 
     * @param costCenter
     */
    public void setCostCenter(java.lang.String costCenter) {
        this.costCenter = costCenter;
    }


    /**
     * Gets the customerID value for this LabelDescriptionExtended.
     * 
     * @return customerID
     */
    public java.lang.String getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this LabelDescriptionExtended.
     * 
     * @param customerID
     */
    public void setCustomerID(java.lang.String customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the declaredValue value for this LabelDescriptionExtended.
     * 
     * @return declaredValue
     */
    public float getDeclaredValue() {
        return declaredValue;
    }


    /**
     * Sets the declaredValue value for this LabelDescriptionExtended.
     * 
     * @param declaredValue
     */
    public void setDeclaredValue(float declaredValue) {
        this.declaredValue = declaredValue;
    }


    /**
     * Gets the deliveryToEstafetaOffice value for this LabelDescriptionExtended.
     * 
     * @return deliveryToEstafetaOffice
     */
    public boolean isDeliveryToEstafetaOffice() {
        return deliveryToEstafetaOffice;
    }


    /**
     * Sets the deliveryToEstafetaOffice value for this LabelDescriptionExtended.
     * 
     * @param deliveryToEstafetaOffice
     */
    public void setDeliveryToEstafetaOffice(boolean deliveryToEstafetaOffice) {
        this.deliveryToEstafetaOffice = deliveryToEstafetaOffice;
    }


    /**
     * Gets the destinationCountryId value for this LabelDescriptionExtended.
     * 
     * @return destinationCountryId
     */
    public java.lang.String getDestinationCountryId() {
        return destinationCountryId;
    }


    /**
     * Sets the destinationCountryId value for this LabelDescriptionExtended.
     * 
     * @param destinationCountryId
     */
    public void setDestinationCountryId(java.lang.String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }


    /**
     * Gets the destinationInfo value for this LabelDescriptionExtended.
     * 
     * @return destinationInfo
     */
    public DestinationInfoExtended getDestinationInfo() {
        return destinationInfo;
    }


    /**
     * Sets the destinationInfo value for this LabelDescriptionExtended.
     * 
     * @param destinationInfo
     */
    public void setDestinationInfo(DestinationInfoExtended destinationInfo) {
        this.destinationInfo = destinationInfo;
    }


    /**
     * Gets the dimensionsInfo value for this LabelDescriptionExtended.
     * 
     * @return dimensionsInfo
     */
    public DimensionsInfo getDimensionsInfo() {
        return dimensionsInfo;
    }


    /**
     * Sets the dimensionsInfo value for this LabelDescriptionExtended.
     * 
     * @param dimensionsInfo
     */
    public void setDimensionsInfo(DimensionsInfo dimensionsInfo) {
        this.dimensionsInfo = dimensionsInfo;
    }


    /**
     * Gets the effectiveDate value for this LabelDescriptionExtended.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this LabelDescriptionExtended.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the insurance value for this LabelDescriptionExtended.
     * 
     * @return insurance
     */
    public boolean isInsurance() {
        return insurance;
    }


    /**
     * Sets the insurance value for this LabelDescriptionExtended.
     * 
     * @param insurance
     */
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }


    /**
     * Gets the numberOfLabels value for this LabelDescriptionExtended.
     * 
     * @return numberOfLabels
     */
    public int getNumberOfLabels() {
        return numberOfLabels;
    }


    /**
     * Sets the numberOfLabels value for this LabelDescriptionExtended.
     * 
     * @param numberOfLabels
     */
    public void setNumberOfLabels(int numberOfLabels) {
        this.numberOfLabels = numberOfLabels;
    }


    /**
     * Gets the officeNum value for this LabelDescriptionExtended.
     * 
     * @return officeNum
     */
    public java.lang.String getOfficeNum() {
        return officeNum;
    }


    /**
     * Sets the officeNum value for this LabelDescriptionExtended.
     * 
     * @param officeNum
     */
    public void setOfficeNum(java.lang.String officeNum) {
        this.officeNum = officeNum;
    }


    /**
     * Gets the originInfo value for this LabelDescriptionExtended.
     * 
     * @return originInfo
     */
    public OriginInfoExtended getOriginInfo() {
        return originInfo;
    }


    /**
     * Sets the originInfo value for this LabelDescriptionExtended.
     * 
     * @param originInfo
     */
    public void setOriginInfo(OriginInfoExtended originInfo) {
        this.originInfo = originInfo;
    }


    /**
     * Gets the originPallet value for this LabelDescriptionExtended.
     * 
     * @return originPallet
     */
    public OriginPallet getOriginPallet() {
        return originPallet;
    }


    /**
     * Sets the originPallet value for this LabelDescriptionExtended.
     * 
     * @param originPallet
     */
    public void setOriginPallet(OriginPallet originPallet) {
        this.originPallet = originPallet;
    }


    /**
     * Gets the originZipCodeForRouting value for this LabelDescriptionExtended.
     * 
     * @return originZipCodeForRouting
     */
    public java.lang.String getOriginZipCodeForRouting() {
        return originZipCodeForRouting;
    }


    /**
     * Sets the originZipCodeForRouting value for this LabelDescriptionExtended.
     * 
     * @param originZipCodeForRouting
     */
    public void setOriginZipCodeForRouting(java.lang.String originZipCodeForRouting) {
        this.originZipCodeForRouting = originZipCodeForRouting;
    }


    /**
     * Gets the parcelTypeId value for this LabelDescriptionExtended.
     * 
     * @return parcelTypeId
     */
    public int getParcelTypeId() {
        return parcelTypeId;
    }


    /**
     * Sets the parcelTypeId value for this LabelDescriptionExtended.
     * 
     * @param parcelTypeId
     */
    public void setParcelTypeId(int parcelTypeId) {
        this.parcelTypeId = parcelTypeId;
    }


    /**
     * Gets the reference value for this LabelDescriptionExtended.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this LabelDescriptionExtended.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the returnDocument value for this LabelDescriptionExtended.
     * 
     * @return returnDocument
     */
    public boolean isReturnDocument() {
        return returnDocument;
    }


    /**
     * Sets the returnDocument value for this LabelDescriptionExtended.
     * 
     * @param returnDocument
     */
    public void setReturnDocument(boolean returnDocument) {
        this.returnDocument = returnDocument;
    }


    /**
     * Gets the serviceTypeAditional value for this LabelDescriptionExtended.
     * 
     * @return serviceTypeAditional
     */
    public java.lang.String getServiceTypeAditional() {
        return serviceTypeAditional;
    }


    /**
     * Sets the serviceTypeAditional value for this LabelDescriptionExtended.
     * 
     * @param serviceTypeAditional
     */
    public void setServiceTypeAditional(java.lang.String serviceTypeAditional) {
        this.serviceTypeAditional = serviceTypeAditional;
    }


    /**
     * Gets the serviceTypeAditionalID value for this LabelDescriptionExtended.
     * 
     * @return serviceTypeAditionalID
     */
    public java.lang.String getServiceTypeAditionalID() {
        return serviceTypeAditionalID;
    }


    /**
     * Sets the serviceTypeAditionalID value for this LabelDescriptionExtended.
     * 
     * @param serviceTypeAditionalID
     */
    public void setServiceTypeAditionalID(java.lang.String serviceTypeAditionalID) {
        this.serviceTypeAditionalID = serviceTypeAditionalID;
    }


    /**
     * Gets the serviceTypeId value for this LabelDescriptionExtended.
     * 
     * @return serviceTypeId
     */
    public java.lang.String getServiceTypeId() {
        return serviceTypeId;
    }


    /**
     * Sets the serviceTypeId value for this LabelDescriptionExtended.
     * 
     * @param serviceTypeId
     */
    public void setServiceTypeId(java.lang.String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }


    /**
     * Gets the serviceTypeIdDocRet value for this LabelDescriptionExtended.
     * 
     * @return serviceTypeIdDocRet
     */
    public java.lang.String getServiceTypeIdDocRet() {
        return serviceTypeIdDocRet;
    }


    /**
     * Sets the serviceTypeIdDocRet value for this LabelDescriptionExtended.
     * 
     * @param serviceTypeIdDocRet
     */
    public void setServiceTypeIdDocRet(java.lang.String serviceTypeIdDocRet) {
        this.serviceTypeIdDocRet = serviceTypeIdDocRet;
    }


    /**
     * Gets the shipmentGroupID value for this LabelDescriptionExtended.
     * 
     * @return shipmentGroupID
     */
    public java.lang.String getShipmentGroupID() {
        return shipmentGroupID;
    }


    /**
     * Sets the shipmentGroupID value for this LabelDescriptionExtended.
     * 
     * @param shipmentGroupID
     */
    public void setShipmentGroupID(java.lang.String shipmentGroupID) {
        this.shipmentGroupID = shipmentGroupID;
    }


    /**
     * Gets the systemInformationVol value for this LabelDescriptionExtended.
     * 
     * @return systemInformationVol
     */
    public SystemInformationVol getSystemInformationVol() {
        return systemInformationVol;
    }


    /**
     * Sets the systemInformationVol value for this LabelDescriptionExtended.
     * 
     * @param systemInformationVol
     */
    public void setSystemInformationVol(SystemInformationVol systemInformationVol) {
        this.systemInformationVol = systemInformationVol;
    }


    /**
     * Gets the valid value for this LabelDescriptionExtended.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this LabelDescriptionExtended.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }


    /**
     * Gets the weight value for this LabelDescriptionExtended.
     * 
     * @return weight
     */
    public float getWeight() {
        return weight;
    }


    /**
     * Sets the weight value for this LabelDescriptionExtended.
     * 
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LabelDescriptionExtended)) return false;
        LabelDescriptionExtended other = (LabelDescriptionExtended) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DRAlternativeInfo==null && other.getDRAlternativeInfo()==null) || 
             (this.DRAlternativeInfo!=null &&
              this.DRAlternativeInfo.equals(other.getDRAlternativeInfo()))) &&
            ((this.aditionalInfo==null && other.getAditionalInfo()==null) || 
             (this.aditionalInfo!=null &&
              this.aditionalInfo.equals(other.getAditionalInfo()))) &&
            ((this.cod==null && other.getCod()==null) || 
             (this.cod!=null &&
              this.cod.equals(other.getCod()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.contentDescription==null && other.getContentDescription()==null) || 
             (this.contentDescription!=null &&
              this.contentDescription.equals(other.getContentDescription()))) &&
            ((this.costCenter==null && other.getCostCenter()==null) || 
             (this.costCenter!=null &&
              this.costCenter.equals(other.getCostCenter()))) &&
            ((this.customerID==null && other.getCustomerID()==null) || 
             (this.customerID!=null &&
              this.customerID.equals(other.getCustomerID()))) &&
            this.declaredValue == other.getDeclaredValue() &&
            this.deliveryToEstafetaOffice == other.isDeliveryToEstafetaOffice() &&
            ((this.destinationCountryId==null && other.getDestinationCountryId()==null) || 
             (this.destinationCountryId!=null &&
              this.destinationCountryId.equals(other.getDestinationCountryId()))) &&
            ((this.destinationInfo==null && other.getDestinationInfo()==null) || 
             (this.destinationInfo!=null &&
              this.destinationInfo.equals(other.getDestinationInfo()))) &&
            ((this.dimensionsInfo==null && other.getDimensionsInfo()==null) || 
             (this.dimensionsInfo!=null &&
              this.dimensionsInfo.equals(other.getDimensionsInfo()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            this.insurance == other.isInsurance() &&
            this.numberOfLabels == other.getNumberOfLabels() &&
            ((this.officeNum==null && other.getOfficeNum()==null) || 
             (this.officeNum!=null &&
              this.officeNum.equals(other.getOfficeNum()))) &&
            ((this.originInfo==null && other.getOriginInfo()==null) || 
             (this.originInfo!=null &&
              this.originInfo.equals(other.getOriginInfo()))) &&
            ((this.originPallet==null && other.getOriginPallet()==null) || 
             (this.originPallet!=null &&
              this.originPallet.equals(other.getOriginPallet()))) &&
            ((this.originZipCodeForRouting==null && other.getOriginZipCodeForRouting()==null) || 
             (this.originZipCodeForRouting!=null &&
              this.originZipCodeForRouting.equals(other.getOriginZipCodeForRouting()))) &&
            this.parcelTypeId == other.getParcelTypeId() &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            this.returnDocument == other.isReturnDocument() &&
            ((this.serviceTypeAditional==null && other.getServiceTypeAditional()==null) || 
             (this.serviceTypeAditional!=null &&
              this.serviceTypeAditional.equals(other.getServiceTypeAditional()))) &&
            ((this.serviceTypeAditionalID==null && other.getServiceTypeAditionalID()==null) || 
             (this.serviceTypeAditionalID!=null &&
              this.serviceTypeAditionalID.equals(other.getServiceTypeAditionalID()))) &&
            ((this.serviceTypeId==null && other.getServiceTypeId()==null) || 
             (this.serviceTypeId!=null &&
              this.serviceTypeId.equals(other.getServiceTypeId()))) &&
            ((this.serviceTypeIdDocRet==null && other.getServiceTypeIdDocRet()==null) || 
             (this.serviceTypeIdDocRet!=null &&
              this.serviceTypeIdDocRet.equals(other.getServiceTypeIdDocRet()))) &&
            ((this.shipmentGroupID==null && other.getShipmentGroupID()==null) || 
             (this.shipmentGroupID!=null &&
              this.shipmentGroupID.equals(other.getShipmentGroupID()))) &&
            ((this.systemInformationVol==null && other.getSystemInformationVol()==null) || 
             (this.systemInformationVol!=null &&
              this.systemInformationVol.equals(other.getSystemInformationVol()))) &&
            this.valid == other.isValid() &&
            this.weight == other.getWeight();
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
        if (getDRAlternativeInfo() != null) {
            _hashCode += getDRAlternativeInfo().hashCode();
        }
        if (getAditionalInfo() != null) {
            _hashCode += getAditionalInfo().hashCode();
        }
        if (getCod() != null) {
            _hashCode += getCod().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getContentDescription() != null) {
            _hashCode += getContentDescription().hashCode();
        }
        if (getCostCenter() != null) {
            _hashCode += getCostCenter().hashCode();
        }
        if (getCustomerID() != null) {
            _hashCode += getCustomerID().hashCode();
        }
        _hashCode += new Float(getDeclaredValue()).hashCode();
        _hashCode += (isDeliveryToEstafetaOffice() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDestinationCountryId() != null) {
            _hashCode += getDestinationCountryId().hashCode();
        }
        if (getDestinationInfo() != null) {
            _hashCode += getDestinationInfo().hashCode();
        }
        if (getDimensionsInfo() != null) {
            _hashCode += getDimensionsInfo().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        _hashCode += (isInsurance() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getNumberOfLabels();
        if (getOfficeNum() != null) {
            _hashCode += getOfficeNum().hashCode();
        }
        if (getOriginInfo() != null) {
            _hashCode += getOriginInfo().hashCode();
        }
        if (getOriginPallet() != null) {
            _hashCode += getOriginPallet().hashCode();
        }
        if (getOriginZipCodeForRouting() != null) {
            _hashCode += getOriginZipCodeForRouting().hashCode();
        }
        _hashCode += getParcelTypeId();
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        _hashCode += (isReturnDocument() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServiceTypeAditional() != null) {
            _hashCode += getServiceTypeAditional().hashCode();
        }
        if (getServiceTypeAditionalID() != null) {
            _hashCode += getServiceTypeAditionalID().hashCode();
        }
        if (getServiceTypeId() != null) {
            _hashCode += getServiceTypeId().hashCode();
        }
        if (getServiceTypeIdDocRet() != null) {
            _hashCode += getServiceTypeIdDocRet().hashCode();
        }
        if (getShipmentGroupID() != null) {
            _hashCode += getShipmentGroupID().hashCode();
        }
        if (getSystemInformationVol() != null) {
            _hashCode += getSystemInformationVol().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Float(getWeight()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LabelDescriptionExtended.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "LabelDescriptionExtended"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DRAlternativeInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DRAlternativeInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DRAlternativeInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aditionalInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aditionalInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "COD"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costCenter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costCenter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("declaredValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "declaredValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryToEstafetaOffice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryToEstafetaOffice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationCountryId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationCountryId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destinationInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DestinationInfoExtended"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dimensionsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dimensionsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "DimensionsInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfLabels");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfLabels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("officeNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "officeNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "OriginInfoExtended"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originPallet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originPallet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "OriginPallet"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originZipCodeForRouting");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originZipCodeForRouting"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcelTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parcelTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnDocument");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnDocument"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeAditional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeAditional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeAditionalID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeAditionalID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypeIdDocRet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypeIdDocRet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipmentGroupID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shipmentGroupID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemInformationVol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "systemInformationVol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.estafetalabel.webservices.estafeta.com", "SystemInformationVol"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "weight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
