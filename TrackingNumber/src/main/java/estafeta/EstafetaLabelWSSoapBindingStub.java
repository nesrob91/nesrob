/**
 * EstafetaLabelWSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package estafeta;
import estafeta.beans.*;
public class EstafetaLabelWSSoapBindingStub extends org.apache.axis.client.Stub implements EstafetaLabel {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequest"), EstafetaLabelRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponse"));
        oper.setReturnClass(EstafetaLabelResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("reprintLabel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaReprintLabelRequest"), EstafetaReprintLabelRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponse"));
        oper.setReturnClass(EstafetaLabelResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "reprintLabelReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSimpleLabel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleRequest"), EstafetaLabelSimpleRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleResponse"));
        oper.setReturnClass(EstafetaLabelSimpleResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createSimpleLabelReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSimpleLabelImage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleRequest"), EstafetaLabelSimpleRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelImageSimpleResponse"));
        oper.setReturnClass(EstafetaLabelImageSimpleResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createSimpleImageLabelReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabelVol");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestVol"), EstafetaLabelRequestVol.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseVol"));
        oper.setReturnClass(EstafetaLabelResponseVol.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelVolReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabelIndividual");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestVol"), EstafetaLabelRequestVol.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseIndividual"));
        oper.setReturnClass(EstafetaLabelResponseIndividual.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelIndividualReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabelVolR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestVol"), EstafetaLabelRequestVol.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseVol"));
        oper.setReturnClass(EstafetaLabelResponseVol.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelVolReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabelIndividualR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestVol"), EstafetaLabelRequestVol.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseIndividual"));
        oper.setReturnClass(EstafetaLabelResponseIndividual.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelIndividualReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLabelExtended");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestExtended"), EstafetaLabelRequestExtended.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseExtended"));
        oper.setReturnClass(EstafetaLabelResponseExtended.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLabelExtendedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

    }

    public EstafetaLabelWSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public EstafetaLabelWSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public EstafetaLabelWSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "COD");
            cachedSerQNames.add(qName);
            cls = COD.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfo");
            cachedSerQNames.add(qName);
            cls = DestinationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfoExtended");
            cachedSerQNames.add(qName);
            cls = DestinationInfoExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfoReprint");
            cachedSerQNames.add(qName);
            cls = DestinationInfoReprint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfoResult");
            cachedSerQNames.add(qName);
            cls = DestinationInfoResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfoSimple");
            cachedSerQNames.add(qName);
            cls = DestinationInfoSimple.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DestinationInfoVol");
            cachedSerQNames.add(qName);
            cls = DestinationInfoVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DimensionsInfo");
            cachedSerQNames.add(qName);
            cls = DimensionsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DRAlternativeInfo");
            cachedSerQNames.add(qName);
            cls = DRAlternativeInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "DRAlternativeInfoSimple");
            cachedSerQNames.add(qName);
            cls = DRAlternativeInfoSimple.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelImageSimpleResponse");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelImageSimpleResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequest");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestExtended");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelRequestExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelRequestVol");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelRequestVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponse");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseExtended");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelResponseExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseIndividual");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelResponseIndividual.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelResponseVol");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelResponseVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleRequest");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelSimpleRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaLabelSimpleResponse");
            cachedSerQNames.add(qName);
            cls = EstafetaLabelSimpleResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "EstafetaReprintLabelRequest");
            cachedSerQNames.add(qName);
            cls = EstafetaReprintLabelRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "GlobalImageSimpleResult");
            cachedSerQNames.add(qName);
            cls = GlobalImageSimpleResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "GlobalResult");
            cachedSerQNames.add(qName);
            cls = GlobalResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "GlobalSimpleResult");
            cachedSerQNames.add(qName);
            cls = GlobalSimpleResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescription");
            cachedSerQNames.add(qName);
            cls = LabelDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescriptionExtended");
            cachedSerQNames.add(qName);
            cls = LabelDescriptionExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescriptionList");
            cachedSerQNames.add(qName);
            cls = LabelDescriptionList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescriptionListExtended");
            cachedSerQNames.add(qName);
            cls = LabelDescriptionListExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescriptionListVol");
            cachedSerQNames.add(qName);
            cls = LabelDescriptionListVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelDescriptionVol");
            cachedSerQNames.add(qName);
            cls = LabelDescriptionVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelListIndividual");
            cachedSerQNames.add(qName);
            cls = LabelListIndividual.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelResultList");
            cachedSerQNames.add(qName);
            cls = LabelResultList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelSimpleDescription");
            cachedSerQNames.add(qName);
            cls = LabelSimpleDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelSimpleDescriptionData");
            cachedSerQNames.add(qName);
            cls = LabelSimpleDescriptionData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfo");
            cachedSerQNames.add(qName);
            cls = OriginInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfoExtended");
            cachedSerQNames.add(qName);
            cls = OriginInfoExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfoReprint");
            cachedSerQNames.add(qName);
            cls = OriginInfoReprint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfoResult");
            cachedSerQNames.add(qName);
            cls = OriginInfoResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfoSimple");
            cachedSerQNames.add(qName);
            cls = OriginInfoSimple.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginInfoVol");
            cachedSerQNames.add(qName);
            cls = OriginInfoVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "OriginPallet");
            cachedSerQNames.add(qName);
            cls = OriginPallet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "PrinterSystem");
            cachedSerQNames.add(qName);
            cls = PrinterSystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ReprintLabelDescription");
            cachedSerQNames.add(qName);
            cls = ReprintLabelDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ReprintLabelDescriptionList");
            cachedSerQNames.add(qName);
            cls = ReprintLabelDescriptionList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "Result");
            cachedSerQNames.add(qName);
            cls = Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "Routing");
            cachedSerQNames.add(qName);
            cls = Routing.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "RoutingResult");
            cachedSerQNames.add(qName);
            cls = RoutingResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ShipmentInfo");
            cachedSerQNames.add(qName);
            cls = ShipmentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ShipmentInfoExtended");
            cachedSerQNames.add(qName);
            cls = ShipmentInfoExtended.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ShipmentInfoVol");
            cachedSerQNames.add(qName);
            cls = ShipmentInfoVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "SystemInfo");
            cachedSerQNames.add(qName);
            cls = SystemInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "SystemInformationVol");
            cachedSerQNames.add(qName);
            cls = SystemInformationVol.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "Waybill");
            cachedSerQNames.add(qName);
            cls = Waybill.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "WaybillEstafeta");
            cachedSerQNames.add(qName);
            cls = WaybillEstafeta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "WaybillGeneratorSystem");
            cachedSerQNames.add(qName);
            cls = WaybillGeneratorSystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "WaybillResult");
            cachedSerQNames.add(qName);
            cls = WaybillResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ArrayOf_tns1_LabelListIndividual");
            cachedSerQNames.add(qName);
            cls = LabelListIndividual[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelListIndividual");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ArrayOf_tns1_LabelResultList");
            cachedSerQNames.add(qName);
            cls = LabelResultList[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "LabelResultList");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "ArrayOf_tns1_WaybillEstafeta");
            cachedSerQNames.add(qName);
            cls = WaybillEstafeta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "WaybillEstafeta");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public EstafetaLabelResponse createLabel(EstafetaLabelRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponse) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponse reprintLabel(EstafetaReprintLabelRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "reprintLabel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponse) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelSimpleResponse createSimpleLabel(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createSimpleLabel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelSimpleResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelSimpleResponse) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelSimpleResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelImageSimpleResponse createSimpleLabelImage(EstafetaLabelSimpleRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createSimpleLabelImage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelImageSimpleResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelImageSimpleResponse) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelImageSimpleResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponseVol createLabelVol(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabelVol"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponseVol) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponseVol) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponseVol.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponseIndividual createLabelIndividual(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabelIndividual"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponseIndividual) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponseIndividual) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponseIndividual.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponseVol createLabelVolR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabelVolR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponseVol) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponseVol) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponseVol.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponseIndividual createLabelIndividualR(EstafetaLabelRequestVol in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabelIndividualR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponseIndividual) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponseIndividual) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponseIndividual.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public EstafetaLabelResponseExtended createLabelExtended(EstafetaLabelRequestExtended in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://estafetalabel.webservices.estafeta.com", "createLabelExtended"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (EstafetaLabelResponseExtended) _resp;
            } catch (java.lang.Exception _exception) {
                return (EstafetaLabelResponseExtended) org.apache.axis.utils.JavaUtils.convert(_resp, EstafetaLabelResponseExtended.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
