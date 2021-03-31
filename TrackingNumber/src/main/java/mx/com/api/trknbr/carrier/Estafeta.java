/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import mx.com.api.trknbr.beans.CredencialesEstafeta;
import mx.com.api.trknbr.beans.GuiaResponse;
import estafeta.EstafetaLabel;
import estafeta.EstafetaLabelService;
import estafeta.EstafetaLabelServiceLocator;
import estafeta.beans.DestinationInfoVol;
import estafeta.beans.EstafetaLabelRequestVol;
import estafeta.beans.EstafetaLabelResponseVol;
import estafeta.beans.LabelDescriptionListVol;
import estafeta.beans.OriginInfoVol;
import java.util.Base64;
import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("estafeta")
public class Estafeta extends GuiasCarriers {

    @Autowired
    private CredencialesDao credencialesEstafeta;

    @Override
    protected Object getCredenciales() throws Exception {
        return credencialesEstafeta.getCredenciales(guiaRequest.getIdCarrier(),CredencialesDao.ID_SERVICIO_GUIAS,guiaRequest.getIdTipoPedido());
    }

    @Override
    protected Object generaPeticion() throws Exception {
        CredencialesEstafeta credencialesEstafeta = (CredencialesEstafeta) credenciales;

        EstafetaLabelRequestVol request = new EstafetaLabelRequestVol();
        LabelDescriptionListVol[] ldl = new LabelDescriptionListVol[1];
        LabelDescriptionListVol label = new LabelDescriptionListVol();
        
        DestinationInfoVol destinationInfo = new DestinationInfoVol();
        OriginInfoVol originInfo = new OriginInfoVol();
        //PROD
        request.setCustomerNumber(credencialesEstafeta.getNumcte());
        request.setLogin(credencialesEstafeta.getUsuario());
        request.setPassword(credencialesEstafeta.getContrasenia());
        switch(guiaRequest.getIdTipoPedido()){
            case 4: case 5 :
                break;
            default:
                request.setSecType("normalTipo7ZebraOri");
                break;
        }

        //QA
        /*request.setCustomerNumber("0000000");
        request.setLogin("prueba1");
        request.setPassword("lAbeL_K_11");
         */
        //Contenido
        label.setAditionalInfo(guiaRequest.getPedido());
        label.setContent("PAQUETE ELEKTRA");
        label.setContentDescription("PAQUETE ELEKTRA");
        label.setCostCenter("0");
        label.setDeliveryToEstafetaOffice(false);
        label.setDestinationCountryId(guiaRequest.getPais3());//MX

        //Destino				
        destinationInfo.setAddress1(guiaRequest.getDestino().getDireccion().toUpperCase());
        //modify - check for num int - ext
        destinationInfo.setAddress2((guiaRequest.getDestino().getnExt().equals("0")?"SN":" Ext."+guiaRequest.getDestino().getnExt()) + (guiaRequest.getDestino().getnInt().equals("0")?"":" Int." + guiaRequest.getDestino().getnInt()));
        destinationInfo.setNeighborhood(guiaRequest.getDestino().getColonia());
        destinationInfo.setCellPhone(guiaRequest.getDestino().getTelefono());
        destinationInfo.setCity(guiaRequest.getDestino().getCiudad());
        destinationInfo.setContactName(guiaRequest.getDestino().getContacto().toUpperCase());
        destinationInfo.setCorporateName(guiaRequest.getDestino().getContacto().toUpperCase());
        destinationInfo.setCustomerNumber(credencialesEstafeta.getNumcte());
        //destinationInfo.setNeighborhood(guiaRequest.getDestino().DeleagacionDestino());
        destinationInfo.setPhoneNumber(guiaRequest.getDestino().getTelefono());
        destinationInfo.setState(guiaRequest.getDestino().getEstado());
        destinationInfo.setValid(true);
        destinationInfo.setZipCode(guiaRequest.getDestino().getCp());
        label.setDestinationInfo(destinationInfo);

        //Origin	
        originInfo.setAddress1(guiaRequest.getOrigen().getDireccion());
        originInfo.setAddress2(" ");
        originInfo.setCellPhone(" - - ");
        originInfo.setCity(guiaRequest.getOrigen().getColonia());//DF
        originInfo.setContactName(utils.substr(guiaRequest.getOrigen().getRazonSocial(), 0, 29));
        originInfo.setCorporateName(guiaRequest.getOrigen().getRazonSocial());
        originInfo.setCustomerNumber(credencialesEstafeta.getNumcte());
        originInfo.setNeighborhood(guiaRequest.getOrigen().getColonia());
        originInfo.setPhoneNumber(guiaRequest.getOrigen().getTelefono());
        originInfo.setState(guiaRequest.getOrigen().getEstado());
        originInfo.setValid(true);
        originInfo.setZipCode(guiaRequest.getOrigen().getCp());
        label.setOriginInfo(originInfo);

        label.setOriginZipCodeForRouting(guiaRequest.getOrigen().getCp());
        label.setParcelTypeId(4);
        label.setReference(guiaRequest.getPedido());
        label.setReturnDocument(false);
        label.setServiceTypeId("70");
        label.setServiceTypeIdDocRet("50");
        label.setValid(true);
        label.setWeight(15);
        label.setEffectiveDate(credencialesEstafeta.getEffectiveDate());
        label.setNumberOfLabels(1);
        label.setOfficeNum(credencialesEstafeta.getNumOfi());

        //Informacion Adicional
        /*alternativeInfo.setAddress1(direccion[1]+" "+direccion[2]);
        alternativeInfo.setAddress2(direccion[0]);
        alternativeInfo.setCellPhone(guiaRequest.getTelefonoDestino());
        alternativeInfo.setCity(guiaRequest.getCiudadDestino());
        alternativeInfo.setContactName(guiaRequest.getContactoDestino());
        alternativeInfo.setCorporateName(guiaRequest.getContactoDestino());
        alternativeInfo.setCustomerNumber(credencialesEstafeta.getNumcte());
        alternativeInfo.setNeighborhood(guiaRequest.getColoniaDestino());
        alternativeInfo.setPhoneNumber(guiaRequest.getTelefonoDestino());
        alternativeInfo.setState(guiaRequest.getEstadoDestino());
        alternativeInfo.setValid(true);
        alternativeInfo.setZipCode(guiaRequest.getCpDestino());		
        label.setDRAlternativeInfo(alternativeInfo);*/
        ldl[0] = label;

        request.setLabelDescriptionList(ldl);
        request.setLabelDescriptionListCount(ldl.length);
        request.setPaperType(Integer.parseInt(credencialesEstafeta.getPaperType()));//1 Laser 2 Zebra
        request.setQuadrant(0);
        request.setSuscriberId(credencialesEstafeta.getIdSuscriptor());
        request.setValid(true);

        return request;
    }

    @Override
    protected Object consumeWs() throws Exception {
        EstafetaLabelService service = new EstafetaLabelServiceLocator();
        EstafetaLabel port;
        port = service.getEstafetaLabelWS();

        return port.createLabelVol((EstafetaLabelRequestVol) peticion);
    }

    @Override
    protected GuiaResponse procesaRespuesta() throws Exception {
        EstafetaLabelResponseVol response = (EstafetaLabelResponseVol) respuesta;
        GuiaResponse guiasResponse = new GuiaResponse();
        guiasResponse.setInput(xmlUtil.getXmlByObject(peticion));
        guiasResponse.setOutput(xmlUtil.getXmlByObject(response));
        if (response.getGlobalResult().getResultCode() != 0) {
            guiasResponse.setNumGuia(null);
            guiasResponse.setEtiqueta("GWSC"+guiaRequest.getIdCarrier()+"R"+response.getGlobalResult().getResultCode());
            guiasResponse.setMensaje(response.getGlobalResult().getResultSpanishDescription());
            guiasResponse.setIdEstatusGuia(-1);
        } else {
            guiasResponse.setNumGuia(response.getLabelResultList()[0].getResultSpanishDescription());
            switch(guiaRequest.getIdTipoPedido()){
                case 4: case 5 :
                    guiasResponse.setEtiqueta(Base64.getEncoder().encodeToString(response.getLabelPDF()));
                    break;
                default:
                    guiasResponse.setEtiqueta(new String(response.getSecEsc()));
                    break;
            }
            guiasResponse.setMensaje(null);
            guiasResponse.setIdEstatusGuia(10);
            guiasResponse.setCarrier(guiaRequest.getIdCarrier());
            guiasResponse.setEncrypt(0);
        }
        return guiasResponse;
    }

}
