/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import mx.com.api.trknbr.beans.CredencialesPaquetexpress;
import mx.com.api.trknbr.beans.GuiaResponse;
import com.paquetexpress.webbooking.documentacion.ClienteDestino;
import com.paquetexpress.webbooking.documentacion.Data;
import com.paquetexpress.webbooking.documentacion.DatoAdicional;
import com.paquetexpress.webbooking.documentacion.DatosAdicionales;
import com.paquetexpress.webbooking.documentacion.DetalleEmbarque;
import com.paquetexpress.webbooking.documentacion.DomicilioDestino;
import com.paquetexpress.webbooking.documentacion.Embarque;
import com.paquetexpress.webbooking.documentacion.Header;
import com.paquetexpress.webbooking.documentacion.OtroServicio;
import com.paquetexpress.webbooking.documentacion.OtrosServicios;
import com.paquetexpress.webbooking.documentacion.Referencia;
import com.paquetexpress.webbooking.documentacion.Referencias;
import com.paquetexpress.webbooking.documentacion.Servicios;
import com.paquetexpress.webbooking.documentacion.SolicitudEnvio;
import com.paquetexpress.webbooking.documentacion.retorno.DataResponse;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;
import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("paquetexpress")
public class Paquetexpress extends GuiasCarriers {
    @Autowired
    private CredencialesDao credencialesPaqueteExpress;

    @Override
    protected Object getCredenciales() throws Exception {
        return credencialesPaqueteExpress.getCredenciales(guiaRequest.getIdCarrier(),CredencialesDao.ID_SERVICIO_GUIAS,guiaRequest.getIdTipoPedido());
    }

    @Override
    protected Object generaPeticion() throws Exception {
        
        CredencialesPaquetexpress credencialesPaquetexpress = (CredencialesPaquetexpress) credenciales;
        
        Data data = new Data();

        Header header = new Header();
        header.setOrgnClntId(credencialesPaquetexpress.getOrgnClntId());
        header.setClntPswd(credencialesPaquetexpress.getClntPswd());
        header.setAgreementKey(credencialesPaquetexpress.getAgreementKey());
        header.setTypeEvent(credencialesPaquetexpress.getTypeEvent());

        DomicilioDestino domicilioDestino = new DomicilioDestino();
        domicilioDestino.setPais(guiaRequest.getPais1());
        domicilioDestino.setEstado(guiaRequest.getDestino().getEstado());
//        domicilioDestino.setCiudad(direccion[0]);
//        domicilioDestino.setStrtName(direccion[1]);
//        domicilioDestino.setDrnr(direccion[2]);
        domicilioDestino.setColonyName(guiaRequest.getDestino().getColonia());
        domicilioDestino.setZipCode(guiaRequest.getDestino().getCp());
        domicilioDestino.setAmMailId("");
        domicilioDestino.setPhoneNo(guiaRequest.getDestino().getTelefono());
        domicilioDestino.setDestinationRefDom("Sin referencias");

        ClienteDestino clienteDestino = new ClienteDestino();
        clienteDestino.setDomicilioDestino(domicilioDestino);
        clienteDestino.setDestClntId("");
        clienteDestino.setDestCustClntId(guiaRequest.getOrderId());
        clienteDestino.setDestClntName(guiaRequest.getDestino().getContacto());

        Embarque embarque = new Embarque();
        embarque.setQuantity(1);
        embarque.setShpCode(credencialesPaquetexpress.getShpCode());
        embarque.setContent("Paquete EKT");
        embarque.setSlabNo(carrierService.getTipoServicioPorRangoPeso((float)guiaRequest.getPeso(),7,2));
        embarque.setWeight(Double.valueOf((Double) guiaRequest.getPeso()));
        embarque.setVolume(null);
        embarque.setLongShip(Double.valueOf((Double) guiaRequest.getLargo()));
        embarque.setWidthShip(Double.valueOf((Double) guiaRequest.getAncho()));
        embarque.setHighShip(Double.valueOf((Double) guiaRequest.getAlto()));

        List<Embarque> embarques = new ArrayList<>();
        embarques.add(embarque);

        OtroServicio otroServicio = new OtroServicio();
        otroServicio.setClave("");
        otroServicio.setDescripcion("");
        otroServicio.setDataAditional1("");
        otroServicio.setDataAditional2("");

        List<OtroServicio> otrosServicioList = new ArrayList<>();
        otrosServicioList.add(otroServicio);

        OtrosServicios otrosServicios = new OtrosServicios();
        otroServicio.setClave("1");
        otroServicio.setDescripcion("1");
        otroServicio.setDataAditional1("1");
        otroServicio.setDataAditional2("1");
        otrosServicios.setOtroServicio(otrosServicioList);

        Referencia referencia = new Referencia();
        referencia.setClaveRef("");

        List<Referencia> referenciaList = new ArrayList<>();
        referenciaList.add(referencia);

        Referencias referencias = new Referencias();
        referencias.setReferencia(referenciaList);

        Servicios servicios = new Servicios();
        servicios.setOtrosServicios(otrosServicios);
        servicios.setDlvyType(credencialesPaquetexpress.getDlvyType());
        servicios.setAckType(credencialesPaquetexpress.getAckType());
        servicios.setCodAmount(null);
        servicios.setTotlDeclVlue(null);
        servicios.setInvType(credencialesPaquetexpress.getInvType());
        servicios.setComments("");
        servicios.setReference(guiaRequest.getPedido());
        servicios.setFormaPago(credencialesPaquetexpress.getFormaPago());
        servicios.setReferencias(referencias);

        DetalleEmbarque detalleEmbarque = new DetalleEmbarque();
        detalleEmbarque.setEmbarque(embarques);

        DatoAdicional datoAdicional = new DatoAdicional();
        datoAdicional.setClaveDataAd("");
        datoAdicional.setDataAditional1("");
        datoAdicional.setDataAditional2("");
        datoAdicional.setDataAditional3("");
        datoAdicional.setDataAditional4("");
        datoAdicional.setValorDataAd("");

        List<DatoAdicional> datoAdicionals = new ArrayList<>();
        datoAdicionals.add(datoAdicional);

        DatosAdicionales datosAdicionales = new DatosAdicionales();
        datosAdicionales.setDatoAdicional(datoAdicionals);

        SolicitudEnvio solicitudEnvio = new SolicitudEnvio();
        solicitudEnvio.setClienteDestino(clienteDestino);
        solicitudEnvio.setDetalleEmbarque(detalleEmbarque);
        solicitudEnvio.setServicios(servicios);
        solicitudEnvio.setCustAgnt("");
        solicitudEnvio.setGhPediNumb("");
        solicitudEnvio.setDatosAdicionales(datosAdicionales);

        data.setHeader(header);
        data.setSolicitudEnvio(solicitudEnvio);

        return data;
    }

    @Override
    protected Object consumeWs() throws Exception {
        Data data = (Data) peticion;
        DataResponse dataResponse = documentarGuia(data);
        return dataResponse;
    }

    @Override
    protected GuiaResponse procesaRespuesta() throws Exception {
        
        GuiaResponse guiaResponse = new GuiaResponse();
        DataResponse dataResponse = (DataResponse) respuesta;
        
        if (dataResponse.getRetornoSolicitud().getMensajes().getMensaje().get(0).getCveMsjeRetorno() != 0) {

            guiaResponse.setNumGuia(null);
                guiaResponse.setEtiqueta(null);
                guiaResponse.setMensaje(dataResponse.getRetornoSolicitud().getMensajes().getMensaje().get(0).getCveMsjeRetorno().toString());
                guiaResponse.setIdEstatusGuia(-1);
                
            } else {

                guiaResponse.setNumGuia(dataResponse.getRetornoSolicitud().getGuiaNo());
                guiaResponse.setEtiqueta(dataResponse.getRetornoSolicitud().getCadenaImpresion());
                guiaResponse.setMensaje(null);
                guiaResponse.setIdEstatusGuia(10);
                guiaResponse.setCarrier(guiaRequest.getIdCarrier());
                guiaResponse.setEncrypt(0);

            }
        guiaResponse.setInput(xmlUtil.getXmlByObject(peticion));
        guiaResponse.setOutput(xmlUtil.getXmlByObject(respuesta));
        
        return guiaResponse;
    }
    
    private static DataResponse documentarGuia(com.paquetexpress.webbooking.documentacion.Data parameters) {
        
        com.paquetexpress.webbooking.documentacion.Documentacion_Service service = new com.paquetexpress.webbooking.documentacion.Documentacion_Service();
        com.paquetexpress.webbooking.documentacion.Documentacion port = service.getDocumentacionSOAP();                
        
        //PROD
        String endpointURL = "http://webbooking.paquetexpress.com.mx:8104/wsPaquetexpress/services/DocumentacionSOAP";
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);        
        
        return port.documentarGuia(parameters);
    }    
    
}
