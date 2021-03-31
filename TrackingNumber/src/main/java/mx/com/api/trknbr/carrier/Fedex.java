/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import com.elektra.cadsumutils.ws.GetNodes;
import mx.com.api.trknbr.beans.CredencialesFedex;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaResponse;
//import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
//import org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl;
import fedex.qa.Address;
import fedex.qa.ClientDetail;
import fedex.qa.Contact;
import fedex.qa.ContactAndAddress;
import fedex.qa.CustomerSpecifiedLabelDetail;
import fedex.qa.Dimensions;
import fedex.qa.DropoffType;
import fedex.qa.FreightShipmentDetail;
import fedex.qa.FreightShipmentRoleType;
import fedex.qa.LabelFormatType;
import fedex.qa.LabelSpecification;
import fedex.qa.LabelStockType;
import fedex.qa.LinearUnits;
import fedex.qa.Localization;
import fedex.qa.NotificationSeverityType;
import fedex.qa.PackagingType;
import fedex.qa.Party;
import fedex.qa.Payment;
import fedex.qa.PaymentType;
import fedex.qa.Payor;
import fedex.qa.ProcessShipmentReply;
import fedex.qa.ProcessShipmentRequest;
import fedex.qa.RequestedPackageLineItem;
import fedex.qa.RequestedShipment;
import fedex.qa.ServiceType;
import fedex.qa.ShipPortType;
import fedex.qa.ShipService;
import fedex.qa.ShippingDocumentImageType;
import fedex.qa.VersionId;
import fedex.qa.WebAuthenticationCredential;
import fedex.qa.WebAuthenticationDetail;
import fedex.qa.Weight;
import fedex.qa.WeightUnits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("fedex")
public class Fedex extends GuiasCarriers{
    @Autowired
    private CredencialesDao credencialesFedex;
    
    @Override
    protected Object getCredenciales() throws Exception{
        return credencialesFedex.getCredenciales(guiaRequest.getIdCarrier(),CredencialesDao.ID_SERVICIO_GUIAS,guiaRequest.getIdTipoPedido());
    }

    @Override
    protected Object generaPeticion() throws Exception {
        
        CredencialesFedex credencialesFedex = (CredencialesFedex) credenciales;

        WebAuthenticationCredential userCredential = new WebAuthenticationCredential();
        userCredential.setKey(credencialesFedex.getKey());
        userCredential.setPassword(credencialesFedex.getPassword());

        WebAuthenticationDetail webAuthenticationDetail = new WebAuthenticationDetail();
        webAuthenticationDetail.setParentCredential(null);
        webAuthenticationDetail.setUserCredential(userCredential);

        Localization localization = new Localization();
        localization.setLanguageCode(credencialesFedex.getLanguageCode());
        localization.setLocaleCode(credencialesFedex.getLocalCode());

        ClientDetail clientDetail = new ClientDetail();
        clientDetail.setAccountNumber(credencialesFedex.getAccountNumber());
        clientDetail.setMeterNumber(credencialesFedex.getMeterNumber());
        clientDetail.setLocalization(localization);

        VersionId versionId = new VersionId();
        versionId.setServiceId(credencialesFedex.getServiceId());
        versionId.setMajor(Integer.parseInt(credencialesFedex.getMajor()));
        versionId.setIntermediate(Integer.parseInt(credencialesFedex.getIntermediate()));
        versionId.setMinor(Integer.parseInt(credencialesFedex.getMinor()));

        GregorianCalendar calendar = new GregorianCalendar(Locale.ENGLISH);
        XMLGregorianCalendar shipTimestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

        Weight weight = new Weight();
        weight.setUnits(WeightUnits.KG.KG);
        weight.setValue((BigDecimal.valueOf(guiaRequest.getPeso())));

        List<String> streetLines = new ArrayList<>();
        streetLines.add(guiaRequest.getOrigen().getDireccion());
        Address address = new Address();
        address.setCity(guiaRequest.getOrigen().getCiudad());
        address.setCountryCode(guiaRequest.getPais3());
        address.setCountryName(guiaRequest.getPais1());
        address.setPostalCode(guiaRequest.getOrigen().getCp());
        address.setResidential(guiaRequest.getOrigen().isResidencial());
        address.setStateOrProvinceCode(guiaRequest.getOrigen().getEstado());
        address.setStreetLines(streetLines);

        Contact contact = new Contact();
        contact.setCompanyName(guiaRequest.getOrigen().getRazonSocial());
        contact.setPersonName(guiaRequest.getOrigen().getContacto());
        contact.setPhoneNumber(guiaRequest.getOrigen().getTelefono());

        Party shipper = new Party();
        shipper.setAddress(address);
        shipper.setAccountNumber(credencialesFedex.getAccountNumber());
        shipper.setContact(contact);

        streetLines = new ArrayList<>();
        streetLines.add(guiaRequest.getDestino().getDireccion()+(guiaRequest.getDestino().getnExt().equals("0")?" SN ":" No."+guiaRequest.getDestino().getnExt()) + (guiaRequest.getDestino().getnInt().equals("0")?"":"-" + guiaRequest.getDestino().getnInt()) );
        address = new Address();
        address.setCity(guiaRequest.getDestino().getCiudad());
        address.setCountryCode(guiaRequest.getPais3());
        address.setCountryName(guiaRequest.getPais1());
        address.setPostalCode(guiaRequest.getDestino().getCp());
        address.setResidential(guiaRequest.getDestino().isResidencial());
        address.setStateOrProvinceCode(guiaRequest.getDestino().getEstado());
        address.setStreetLines(streetLines);

        contact = new Contact();
        contact.setCompanyName(guiaRequest.getDestino().getRazonSocial());
        contact.setPersonName(guiaRequest.getDestino().getContacto());
        contact.setPhoneNumber(guiaRequest.getDestino().getTelefono());

        Party recipient = new Party();
        recipient.setAddress(address);
        recipient.setAccountNumber(credencialesFedex.getAccountNumber());
        recipient.setContact(contact);

        Payor payor = new Payor();
        payor.setResponsibleParty(shipper);

        Payment payment = new Payment();
        payment.setPaymentType(PaymentType.valueOf(credencialesFedex.getPaymentType()));
        payment.setPayor(payor);

        ContactAndAddress contactAndAddress = new ContactAndAddress();
        contactAndAddress.setAddress(shipper.getAddress());
        contactAndAddress.setContact(shipper.getContact());

        Dimensions dimensions = new Dimensions();
        dimensions.setHeight(BigInteger.valueOf((int) guiaRequest.getAlto()));
        dimensions.setWidth(BigInteger.valueOf((int) guiaRequest.getAncho()));
        dimensions.setLength(BigInteger.valueOf((int) guiaRequest.getLargo()));
        dimensions.setUnits(LinearUnits.valueOf(credencialesFedex.getDimensionUnits()));

        List<RequestedPackageLineItem> lineItems = new ArrayList<>();
        //lineItems = piezasFedex.getPiezasFedex(piezas);

        RequestedPackageLineItem item = new RequestedPackageLineItem();
        item.setDimensions(dimensions);
        item.setWeight(weight);
        item.setItemDescription("Paquete Elektra");
        item.setSequenceNumber(BigInteger.valueOf(1));
        lineItems.add(item);

        FreightShipmentDetail freightShipmentDetail = new FreightShipmentDetail();
        freightShipmentDetail.setAlternateBilling(shipper);
        freightShipmentDetail.setRole(FreightShipmentRoleType.valueOf(credencialesFedex.getRole()));
        freightShipmentDetail.setFedExFreightBillingContactAndAddress(contactAndAddress);
        freightShipmentDetail.setTotalHandlingUnits(BigInteger.valueOf(getTotalPiezas()));
        freightShipmentDetail.setShipmentDimensions(dimensions);

        CustomerSpecifiedLabelDetail customerSpecifiedLabelDetail = new CustomerSpecifiedLabelDetail();
        customerSpecifiedLabelDetail.setTermsAndConditionsLocalization(localization);

        LabelSpecification labelSpecification = new LabelSpecification();
        labelSpecification.setLabelFormatType(LabelFormatType.valueOf(credencialesFedex.getLabelFormatType()));
        labelSpecification.setImageType(ShippingDocumentImageType.valueOf(credencialesFedex.getImageType()));
        labelSpecification.setLabelStockType(LabelStockType.valueOf(credencialesFedex.getLabelStockType()));
        labelSpecification.setCustomerSpecifiedDetail(customerSpecifiedLabelDetail);

        RequestedShipment requestedShipment = new RequestedShipment();
        requestedShipment.setShipTimestamp(shipTimestamp);
        requestedShipment.setDropoffType(DropoffType.valueOf(credencialesFedex.getDropOffType()));
        requestedShipment.setServiceType(ServiceType.valueOf(carrierService.getTipoServicioPorPeso(guiaRequest)));
        requestedShipment.setPackagingType(PackagingType.valueOf(credencialesFedex.getPackagingType()));
        requestedShipment.setTotalWeight(weight);
        requestedShipment.setShipper(shipper);
        requestedShipment.setRecipient(recipient);
        requestedShipment.setShippingChargesPayment(payment);
        requestedShipment.setFreightShipmentDetail(freightShipmentDetail);
        requestedShipment.setLabelSpecification(labelSpecification);
        requestedShipment.setPackageCount(BigInteger.valueOf(guiaRequest.getSkus().size()));
        requestedShipment.setRequestedPackageLineItems(lineItems);

        ProcessShipmentRequest processShipmentRequest = new ProcessShipmentRequest();
        processShipmentRequest.setWebAuthenticationDetail(webAuthenticationDetail);
        processShipmentRequest.setVersion(versionId);
        processShipmentRequest.setClientDetail(clientDetail);
        processShipmentRequest.setRequestedShipment(requestedShipment);

        return processShipmentRequest;

    }

    @Override
    protected Object consumeWs() throws Exception {
        ProcessShipmentRequest processShipmentRequest = (ProcessShipmentRequest)peticion;
        ProcessShipmentReply processShipmentReply = new ProcessShipmentReply();
        processShipmentReply = processShipment(processShipmentRequest);
        return processShipmentReply;
    }

    @Override
    protected GuiaResponse procesaRespuesta() throws Exception {
        GuiaResponse guiaResponse = new GuiaResponse();
        
        ProcessShipmentReply processShipmentReply  = (ProcessShipmentReply) respuesta;
        
        guiaResponse.setInput(xmlUtil.getXmlByObject(peticion));
        guiaResponse.setOutput(xmlUtil.getXmlByObject(processShipmentReply));
        
        if(processShipmentReply.getHighestSeverity() == NotificationSeverityType.FAILURE || processShipmentReply.getHighestSeverity() == NotificationSeverityType.ERROR){
                String refField1="";
                for(int i=0; i < processShipmentReply.getNotifications().size();i++){
                    if(i>0){
                        refField1 += ", "+processShipmentReply.getNotifications().get(i).getCode();
                    }
                    else{
                        refField1 += processShipmentReply.getNotifications().get(i).getCode();
                    }
                }

                guiaResponse.setNumGuia(null);
                guiaResponse.setMensaje(refField1);
                guiaResponse.setEtiqueta("GWSC"+guiaRequest.getIdCarrier()+"R"+refField1);
                guiaResponse.setIdEstatusGuia(-1);
            }
            else{
                GetNodes getnodes = new GetNodes();
                List<String> listaNodos = new ArrayList<>();
                listaNodos.add("Image");
                getnodes.setstring(guiaResponse.getOutput());
                List <String> etiquetaList = new ArrayList<>();
                etiquetaList = getnodes.getNodes(listaNodos);

                
                guiaResponse.setNumGuia(processShipmentReply.getCompletedShipmentDetail().getCompletedPackageDetails().get(0).getTrackingIds().get(0).getTrackingNumber());
                guiaResponse.setMensaje(null);
                guiaResponse.setEtiqueta(etiquetaList.get(0));
                guiaResponse.setIdEstatusGuia(10);
                guiaResponse.setCarrier(guiaRequest.getIdCarrier());
                guiaResponse.setEncrypt(1);
            }
        return guiaResponse;

    }
    
    private static ProcessShipmentReply processShipment(ProcessShipmentRequest processShipmentRequest) {
        String endpointURL = "https://ws.fedex.com:443/web-services"; 
        
        ShipService service ;
        
            service = new ShipService();
        
        ShipPortType port = service.getShipServicePort();
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);   
        return port.processShipment(processShipmentRequest);
    }

    private int getTotalPiezas(){
        int piezas = 0;
        for(DetalleSkus detalle : guiaRequest.getSkus()){
            piezas += detalle.getCantidad();
        }
        return piezas;
    }
}
