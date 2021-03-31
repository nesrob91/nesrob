/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import mx.com.api.trknbr.beans.CredencialesPalex;
import mx.com.api.trknbr.beans.GuiaResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import palex.beans.ErrorPalex;

/**
 *
 * @author dparra
 */
@Component("palex")
public class Palex extends GuiasCarriers{
        
    @Override
    protected Object getCredenciales() throws Exception{
        //return credencialesService.getCredenciales(guiaRequest.getIdCarrier(),guiaRequest.getIdTipoPedido());
        return  null;
    }

    @Override
    protected Object generaPeticion() throws Exception {
        CredencialesPalex credencialesPalex = (CredencialesPalex) credenciales;
        String request = null;
        /*
        Opciones opciones = new Opciones();
            opciones.setTipoEnvio(credencialesPalex.getTipoEnvio());
            opciones.setTipoEntrega(credencialesPalex.getTipoEntrega());
            opciones.setTipoServicio(credencialesPalex.getTipoServicio());
            opciones.setTipoCobro("");

            Domicilio domicilioOrigen = new Domicilio();
            domicilioOrigen.setPais(guiaRequest.getPais1());
            domicilioOrigen.setEstado(guiaRequest.getOrigen().getEstado());
            domicilioOrigen.setCiudad(guiaRequest.getOrigen().getCiudad());
            domicilioOrigen.setColonia(guiaRequest.getOrigen().getColonia());
            domicilioOrigen.setCodigoPostal(guiaRequest.getOrigen().getCp());
            domicilioOrigen.setCalle(guiaRequest.getOrigen().getDireccion());
            domicilioOrigen.setNumeroInt("");
            domicilioOrigen.setNumeroExt("123");

            Telefonos telefonoOrigen = new Telefonos();
            telefonoOrigen.setNumeroTelefono(guiaRequest.getOrigen().getTelefono());
            List<Telefonos> telefonosOrigen = new ArrayList<>();
            telefonosOrigen.add(telefonoOrigen);

            Origen origen = new Origen();
            origen.setRemitente(guiaRequest.getOrigen().getCiudad());
            origen.setDomicilio(domicilioOrigen);
            origen.setTelefonos(telefonosOrigen);
            origen.setEmail("");
            origen.setReferencia("");

            Domicilio domicilioDestino = new Domicilio();
            domicilioDestino.setPais(guiaRequest.getPais1());
            domicilioDestino.setEstado(guiaRequest.getDestino().getEstado());
            domicilioDestino.setCiudad(guiaRequest.getDestino().getCiudad());
            domicilioDestino.setColonia(guiaRequest.getDestino().getColonia());
            domicilioDestino.setCodigoPostal(guiaRequest.getDestino().getCp());
            domicilioDestino.setCalle(guiaRequest.getDestino().getDireccion());
            domicilioDestino.setNumeroInt("");
            domicilioDestino.setNumeroExt("123");

            Telefonos telefonoDestino = new Telefonos();
            telefonoDestino.setNumeroTelefono(guiaRequest.getDestino().getTelefono());
            List<Telefonos> telefonosDestino = new ArrayList<>();
            telefonosDestino.add(telefonoDestino);


            Destino destino = new Destino();
            destino.setDestinatario(guiaRequest.getDestino().getContacto());
            destino.setDestinatario2("");
            destino.setDomicilio(domicilioDestino);
            destino.setTelefonos(telefonosDestino);
            destino.setEmail("");
            destino.setReferencia("");

            Dimensiones dimensiones = new Dimensiones();
            dimensiones.setLargo((int)Math.round(guiaRequest.getLargo()));
            dimensiones.setAlto((int)Math.round(guiaRequest.getAlto()));
            dimensiones.setAncho((int)Math.round(guiaRequest.getAncho()));
            dimensiones.setPeso(guiaRequest.getPeso());

            Detalle detalle = new Detalle();
            detalle.setIdentificador("1");
            detalle.setContenido("PAQUETE ELEKTRA");
            detalle.setValorDeclarado(0);
            detalle.setDimensiones(dimensiones);

            List<Detalle> detalles = new ArrayList<>();
            detalles.add(detalle);

            Servicios servicios = new Servicios();
            servicios.setServicio("");
            servicios.setValor(0);
            List<Servicios> servicioses = new ArrayList<>();
            servicioses.add(servicios);

            GuiasPalexRequest guiasPalexRequest = new GuiasPalexRequest();
            guiasPalexRequest.setCuenta(0);
            guiasPalexRequest.setOpciones(opciones);
            guiasPalexRequest.setReferencia1(guiaRequest.getPedido());
            guiasPalexRequest.setReferencia2("");
            guiasPalexRequest.setContiene("");
            guiasPalexRequest.setOrigen(origen);
            guiasPalexRequest.setDestino(destino);
            guiasPalexRequest.setDetalle(detalles);
            guiasPalexRequest.setServicios(servicioses);
        
            request = restUtil.getJsonFromObject(guiasPalexRequest);
          */  
        return request;
    }

    @Override
    protected Object consumeWs() throws Exception {
        
        String guiasPalexRequest = (String) peticion;
        CredencialesPalex credencialesGuiasPalex = (CredencialesPalex) credenciales;
        String authentication = null;
        String guiasPalexResponse = null;
  /*      
        authentication = restUtil.encode64(credencialesGuiasPalex.getUsuario() + ":" + credencialesGuiasPalex.getContrasenia());

        guiasPalexResponse = restUtil.consumeWsRestPostBasicAuth(
                credencialesGuiasPalex.getUrl() + credencialesGuiasPalex.getPath(), authentication, "application/json", guiasPalexRequest, 200
        );
*/
        return guiasPalexResponse;
    }

    @Override
    protected GuiaResponse procesaRespuesta() throws Exception {
        GuiaResponse guiaResponse = new GuiaResponse();
        /*
        String guiasPalexRequest = (String) peticion;
        String guiasPalexResponse = (String) respuesta;

        if (guiasPalexResponse.contains("EKT-ERROR")) {
            
            String respuesta = guiasPalexResponse.replace("EKT-ERROR: ", "");
            
            List<ErrorPalex> errores = getErrores(respuesta);
            
            respuesta = "";
            
            for(int i=0; i < errores.size(); i++){
                
                if(i!=0){
                    respuesta = respuesta + ", ";
                }
                respuesta = respuesta + errores.get(i).getMsgNo();   
            }
            

            guiaResponse.setIdEstatusGuia(-1);
            guiaResponse.setMensaje(respuesta);
            guiaResponse.setEtiqueta(null);
            guiaResponse.setNumGuia(null);

        } else {

            guiaResponse.setIdEstatusGuia(10);
            guiaResponse.setMensaje(null);
            guiaResponse.setNumGuia(restUtil.getValorJson(guiasPalexResponse, "guia"));
            
            guiaResponse.setEtiqueta(consumeWebServiceEtiqueta(guiaResponse.getNumGuia()));
            guiaResponse.setCarrier(guiaRequest.getIdCarrier());

        }
        
        guiaResponse.setInput(guiasPalexResponse);
        guiaResponse.setInput(guiasPalexRequest);
        */
        return guiaResponse;
    }
    
    private String consumeWebServiceEtiqueta(String guia) throws Exception{
        
        //CredencialesPalex credencialesEtiquetasPalex = (CredencialesPalex)credencialesService.getCredenciales(guiaRequest.getIdCarrier(),guiaRequest.getIdTipoPedido());
    /*    String authentication = restUtil.encode64(credencialesEtiquetasPalex.getUsuario() + ":" + credencialesEtiquetasPalex.getContrasenia());
        String etiquetaRequest = 
                    "{\n" 
                        + "	\"Guia\" : \"" + guia + "\",\n" 
                        + "	\"TipoImpresion\" : " + credencialesEtiquetasPalex.getTipoImpresion() + " \n " 
                    + "}";
        return restUtil.consumeWsRestPostBasicAuth(credencialesEtiquetasPalex.getUrl() + credencialesEtiquetasPalex.getPath(), authentication, "application/json", etiquetaRequest, 200);*/
    return null;
    }

    public List<ErrorPalex> getErrores(String json) throws IOException{
        List<ErrorPalex> errores = new ArrayList<>();
        /*
        for(LinkedHashMap lista : restUtil.getValoresJson(json)){
            
            ErrorPalex error = new ErrorPalex();
            error.setMsgNo(lista.get("msgNo").toString());
            error.setMsg(lista.get("msg").toString());
            errores.add(error);
            
        }
        */
        return errores;
    }
}
