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
import estafeta.beans.DestinationInfoExtended;
import estafeta.beans.DimensionsInfo;
import estafeta.beans.EstafetaLabelRequestExtended;
import estafeta.beans.EstafetaLabelResponseVol;
import estafeta.beans.LabelDescriptionListExtended;
import estafeta.beans.OriginInfoExtended;
import estafeta.beans.OriginPallet;
import java.util.Base64;
import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("estafetaLTL")
public class EstafetaLTL extends GuiasCarriers {
    @Autowired
    private CredencialesDao credencialesEstafeta;

    @Override
    protected Object getCredenciales() throws Exception {
        return credencialesEstafeta.getCredenciales(guiaRequest.getIdCarrier(),CredencialesDao.ID_SERVICIO_GUIAS,guiaRequest.getIdTipoPedido());
    }

    @Override
    protected Object generaPeticion() throws Exception {
        CredencialesEstafeta credencialesEstafeta = (CredencialesEstafeta) credenciales;

        EstafetaLabelRequestExtended request = new EstafetaLabelRequestExtended();
        LabelDescriptionListExtended[] ldl = new LabelDescriptionListExtended[1];
        LabelDescriptionListExtended label = new LabelDescriptionListExtended();
        
        DimensionsInfo dimensionsInfo = new DimensionsInfo();
        DestinationInfoExtended destinationInfo = new DestinationInfoExtended();
        OriginInfoExtended originInfo = new OriginInfoExtended();
        OriginPallet originPallet = new OriginPallet();
        
        //PROD
        request.setCustomerNumber(credencialesEstafeta.getNumcte());
        request.setLogin(credencialesEstafeta.getUsuario());
        request.setPassword(credencialesEstafeta.getContrasenia());
        request.setSuscriberId(credencialesEstafeta.getIdSuscriptor());
        switch(guiaRequest.getIdTipoPedido()){
            case 4: case 5 :
                break;
            default:
                request.setSecType("normalTipo7ZebraOri");
                break;
        }

        //QA
        /*
                    request.setCustomerNumber("0000000");
                    request.setLogin("prueba1");
                    request.setPassword("lAbeL_K_11");
                    request.setSuscriberId("28");
         */
            //Contenido
            label.setAditionalInfo(guiaRequest.getPedido());
            label.setContent(guiaRequest.getSkus().get(0).getSku().getIdSku());
            label.setContentDescription(guiaRequest.getSkus().get(0).getSku().getDescSku());
            //label.setCostCenter("0");
            label.setDeliveryToEstafetaOffice(false);
            label.setDestinationCountryId(guiaRequest.getPais3());//MX

            dimensionsInfo.setHeight((int) guiaRequest.getAlto());
            dimensionsInfo.setLength((int) guiaRequest.getLargo());
            dimensionsInfo.setWidth((int) guiaRequest.getAncho());
            label.setDimensionsInfo(dimensionsInfo);
            //label.setWeight(Float.parseFloat(guiaRequest.getPeso()+""));
            label.setWeight(71);

            //Destino
            destinationInfo.setAddress1(guiaRequest.getDestino().getDireccion().toUpperCase());
            destinationInfo.setAddress2((guiaRequest.getDestino().getnExt().equals("0")?"SN":"Ext."+guiaRequest.getDestino().getnExt()) + (guiaRequest.getDestino().getnInt().equals("0")?"":" Int." + guiaRequest.getDestino().getnInt()));
            //destinationInfo.setAddress2(" ");
            destinationInfo.setNeighborhood(guiaRequest.getDestino().getColonia());
            destinationInfo.setOutNum(guiaRequest.getDestino().getnExt()+"");
            destinationInfo.setIntNum(guiaRequest.getDestino().getnInt()+"");
            destinationInfo.setCellPhone(guiaRequest.getDestino().getTelefono());
            //destinationInfo.setEmail(" - - ");
            destinationInfo.setCity(guiaRequest.getDestino().getCiudad().toUpperCase());
            destinationInfo.setContactName(guiaRequest.getDestino().getContacto().toUpperCase());
            destinationInfo.setCorporateName(guiaRequest.getDestino().getContacto().toUpperCase());
            //destinationInfo.setNeighborhood(guiDRequestgetdestino()..getDeleagacion().toUpperCase());
            destinationInfo.setPhoneNumber(guiaRequest.getDestino().getTelefono());
            destinationInfo.setState(guiaRequest.getDestino().getEstado().toUpperCase());
            destinationInfo.setZipCode(guiaRequest.getDestino().getCp());
            destinationInfo.setNave("NA");
            destinationInfo.setPlatform("NA");
            label.setDestinationInfo(destinationInfo);

            //Origin								
            originInfo.setAddress1(guiaRequest.getOrigen().getDireccion());
            originInfo.setAddress2(" ");
            originInfo.setOutNum("0");
            //originInfo.setIntNum("0");
            originInfo.setCellPhone(" - - ");
            //originInfo.setEmail(" - - ");
            originInfo.setCity(guiaRequest.getOrigen().getColonia());//DF
            originInfo.setContactName(utils.substr(guiaRequest.getOrigen().getRazonSocial(),0, 29));
            originInfo.setCorporateName(guiaRequest.getOrigen().getRazonSocial());
            originInfo.setCustomerNumber(credencialesEstafeta.getNumcte());
            originInfo.setNeighborhood(guiaRequest.getOrigen().getColonia());
            originInfo.setPhoneNumber(guiaRequest.getOrigen().getTelefono());
            originInfo.setState(guiaRequest.getOrigen().getEstado());
            originInfo.setZipCode(guiaRequest.getOrigen().getCp());
            originInfo.setNave("NA");
            originInfo.setPlatform("NA");
            label.setOriginInfo(originInfo);

            originPallet.setMerchandise("NACIONAL");
            label.setOriginPallet(originPallet);

            label.setOriginZipCodeForRouting(guiaRequest.getOrigen().getCp());
            label.setParcelTypeId(4);
            label.setReference(guiaRequest.getPedido());
            label.setReturnDocument(false);
            label.setServiceTypeId("L0");
            label.setServiceTypeIdDocRet("50");
            label.setEffectiveDate(credencialesEstafeta.getEffectiveDate());
            label.setNumberOfLabels(1);
            label.setOfficeNum(credencialesEstafeta.getNumOfi());

            ldl[0] = label;

            request.setLabelDescriptionList(ldl);
            request.setLabelDescriptionListCount(ldl.length);
            request.setPaperType(Integer.parseInt(credencialesEstafeta.getPaperType()));//1 Laser 2 Zebra
            request.setQuadrant(0);

            request.setValid(true);

        return request;
    }

    @Override
    protected Object consumeWs() throws Exception {
        EstafetaLabelService service = new EstafetaLabelServiceLocator();
        EstafetaLabel port;
        port = service.getEstafetaLabelWS();

        return port.createLabelExtended((EstafetaLabelRequestExtended) peticion);
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
