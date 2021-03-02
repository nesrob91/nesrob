/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palex;

import com.elektra.beans.CredencialesTrackingPalex;
import com.elektra.beans.DatosTracking;
import com.elektra.beans.TrackingResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import com.elektra.beans.palex.ErrorPalex;
import com.elektra.beans.palex.Referencia;
import com.elektra.beans.palex.Guias;
import com.elektra.beans.palex.Referencias;
import com.elektra.beans.palex.TrackingPalexRequest;
import com.elektra.util.TrackingPlantilla;
import com.elektra.util.UtilRest;

/**
 *
 * @author dparra
 */
public class TrackingPalex extends TrackingPlantilla{
    
    UtilRest utilRest = new UtilRest();
    
    @Override
    protected Object generaRequest(DatosTracking datosTracking, Object credenciales) throws Exception{
        Object object = null;
        String request = "";
        
            // REALIZAR EL CAST AL TIPO DE CREDENCIALES DEL CARRIER QUE APLIQUE (EJEMPLO)
            CredencialesTrackingPalex credencialesGuiasPalex = (CredencialesTrackingPalex) credenciales;
            
            // CONFIGURAR EL OBJETO QUE SERÁ LA SOLICITUD AL WS

            Guias guias = new Guias();
            guias.setGuia(datosTracking.getNumGuia());
            guias.setReferencia(null);

            Referencia referencia = new Referencia();
            referencia.setCuenta(credencialesGuiasPalex.getCuenta());
            referencia.setReferencia1("MIA1000003024117");
            referencia.setReferencia2(null);

            Referencias referencias = new Referencias();
            referencias.setGuia(null);
            referencias.setReferencia(referencia);

            //System.out.println(utilRest.getJsonFromObject(guia)+",");
            //System.out.println(utilRest.getJsonFromObject(referencias));

            TrackingPalexRequest trackingPalexRequest = new TrackingPalexRequest();
            trackingPalexRequest.setGuias(guias);
            trackingPalexRequest.setReferencias(referencias);
            
            List<TrackingPalexRequest> lista = new ArrayList<TrackingPalexRequest>();
            lista.add(trackingPalexRequest);
            
            request = utilRest.getJsonFromObject(lista);

            
            request = request.replace("\"guias\" :", "");
            request = request.replace("\"referencias\" :", "");
            request = request.replace("[ {", "[");
            request = request.replace("} ]", "]");
            
            
            // ASIGNAR AL OBJETO DE RETORNO EL OBJETO QUE SE CONFIGURÓ EN PASOS ANTERIORES (EJEMPLO)
            object = request;
            //object = credencialesGuiasPalex;
          
        return object;
        
    }
    @Override
    protected TrackingResponse consumeWebService(DatosTracking datosTracking, Object objRequest, Object credenciales, String proxy) throws Exception{
        TrackingResponse trackingResponse = new TrackingResponse();
        
        try{
            CredencialesTrackingPalex credencialesTrackingPalex = (CredencialesTrackingPalex)credenciales;
            // OBTENER EL OBJETO DE LA SOLICITUD DE ACUERDO AL CARRIER QUE APLIQUE (ELEMPLO)
            // GuiasPalexRequest guiasPalexRequest = (GuiasPalexRequest)generaRequest(datosGuias, credenciales);
            String authentication = "";
            String REQUEST = (String)objRequest;
            authentication = utilRest.encode64(credencialesTrackingPalex.getUsuario() + ":" + credencialesTrackingPalex.getContrasenia());
            String RESPONSE = utilRest.consumeWsRestPostBasicAuth(credencialesTrackingPalex.getUrl() + credencialesTrackingPalex.getPath(), authentication, "application/json", REQUEST, proxy, 200
        );
            
            
        if (RESPONSE.contains("ECOM-Excepción")) {           
            String respuesta = RESPONSE.replace("ECOM-Excepción: ", "");
                        
            List<ErrorPalex> errores = getErrores(respuesta);            
            respuesta = "";
            
            for(int i=0; i < errores.size(); i++){
                respuesta = (i==0 ? "" : ", ") + respuesta + errores.get(i).getMsgNo();   
            }
            
            trackingResponse.setOutput(respuesta);
            trackingResponse.setInput(REQUEST);
            trackingResponse.setIdEstatusGuia(-1);
            trackingResponse.setRefField1(respuesta);
            trackingResponse.setIdEstatusGuiaCarrier(null);

        } else {
            trackingResponse = processResponse(RESPONSE, datosTracking.getNumGuia());
            trackingResponse.setInput(REQUEST);
            trackingResponse.setOutput(RESPONSE);
            trackingResponse.setRefField1(null);
        }       
        }catch(Exception e){
            return configuraExcepcion(e);
        }
        return trackingResponse;
    }
    
    public List<ErrorPalex> getErrores(String json) throws IOException{
        List<ErrorPalex> errores = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap> listas = mapper.readValue(json, List.class);
        
        for(LinkedHashMap lista : listas){
            
            ErrorPalex error = new ErrorPalex();
            error.setMsgNo(lista.get("msgNo").toString());
            error.setMsg(lista.get("msg").toString());
            errores.add(error);
            
        }
        
        return errores;
    }
    
    public TrackingResponse processResponse(String json, String guia) throws IOException{
        TrackingResponse trackingResponse = new TrackingResponse();        
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap> listas = mapper.readValue(json, List.class);
        
        int i = 1;
        for(LinkedHashMap lista : listas){
        	if(lista.get("guia").equals(guia)) {
	            List<LinkedHashMap> l = (List<LinkedHashMap>)lista.get("movimientos");
	            for(LinkedHashMap movimiento : l){
	                trackingResponse.setIdEstatusGuiaCarrier(movimiento.get("codigo").toString());
	                if(i == 1) {
	                	String fecha = movimiento.get("fMovimiento").toString();      
						String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
						trackingResponse.setFechaRecoleccion(fecha2);
	                }
	                if(movimiento.get("codigo").toString().equals("CV")) {
	                	String fecha = movimiento.get("fMovimiento").toString();      
						String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
						trackingResponse.setFechaRecoleccion(fecha2);
	                }
	                if(movimiento.get("codigo").toString().equals("EN")) {
	                	String fecha = movimiento.get("fMovimiento").toString();      
						String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
						trackingResponse.setFechaRecepcion(fecha2);
						trackingResponse.setRecibe(lista.get("recibio").toString());
	                }
	                i++;
	                /*
	                if(!movimiento.get("codigo").toString().equals("ER") && !movimiento.get("codigo").toString().equals("AE")&&!movimiento.get("codigo").toString().equals("CV")&&!movimiento.get("codigo").toString().equals("SI")&&!movimiento.get("codigo").toString().equals("LI")
	                		&&!movimiento.get("codigo").toString().equals("LE")&&!movimiento.get("codigo").toString().equals("CM")&&!movimiento.get("codigo").toString().equals("EN")) {
	                	System.out.println(movimiento.get("codigo").toString());
	                }*/
	            }
        	}
        }
        
        return trackingResponse;
    }
}
