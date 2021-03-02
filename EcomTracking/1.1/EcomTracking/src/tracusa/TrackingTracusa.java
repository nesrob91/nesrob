/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracusa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.elektra.beans.CredencialesTrackingTracusa;
import com.elektra.beans.DatosTracking;
import com.elektra.beans.TrackingResponse;
import com.elektra.beans.palex.ErrorPalex;
import com.elektra.util.TrackingPlantilla;
import com.elektra.util.UtilRest;
import com.fasterxml.jackson.databind.ObjectMapper;

import tracusa.beans.DeliveryTracusa;
import tracusa.beans.ShipmentsTracusa;
import tracusa.beans.TrackerTracusa;
import tracusa.beans.TrackingTracusaRequest;
import tracusa.beans.TrackingTracusaResponse;

/**
 *
 * @author dparra
 */
public class TrackingTracusa extends TrackingPlantilla{
    
    UtilRest utilRest = new UtilRest();
    
    @Override
    protected Object generaRequest(DatosTracking datosTracking, Object credenciales) throws Exception{
        Object object = null;
        String request = "";
        
            // REALIZAR EL CAST AL TIPO DE CREDENCIALES DEL CARRIER QUE APLIQUE (EJEMPLO)
            CredencialesTrackingTracusa credencialesGuiasTracusa = (CredencialesTrackingTracusa) credenciales;
            
            // CONFIGURAR EL OBJETO QUE SERÁ LA SOLICITUD AL WS

            TrackingTracusaRequest trackingTracusaRequest = new TrackingTracusaRequest();
            ShipmentsTracusa shipmentsTracusa = new ShipmentsTracusa();
            DeliveryTracusa deliveryTracusa = new DeliveryTracusa();
            	deliveryTracusa.setSuccess(false);
            	deliveryTracusa.setLatitude(0.0);
            	deliveryTracusa.setLongitude(0.0);
            	deliveryTracusa.setSignature(false);            
            	
            shipmentsTracusa.setIdGuide(datosTracking.getNumGuia());
            shipmentsTracusa.setReference("EKT");
            shipmentsTracusa.setObservations("");
            shipmentsTracusa.setDelivery(deliveryTracusa);
            ArrayList<ShipmentsTracusa> shipments = new ArrayList<ShipmentsTracusa>();
            shipments.add(shipmentsTracusa);
            
            trackingTracusaRequest.setCode("200");
            trackingTracusaRequest.setMessage("OK");
            trackingTracusaRequest.setShipments(shipments);
            
            request = utilRest.getJsonFromObject(trackingTracusaRequest);
           
            /*
            request = request.replace("\"guias\" :", "");
            request = request.replace("\"referencias\" :", "");
            request = request.replace("[ {", "[");
            request = request.replace("} ]", "]");
            */
            
            // ASIGNAR AL OBJETO DE RETORNO EL OBJETO QUE SE CONFIGURÓ EN PASOS ANTERIORES (EJEMPLO)
            object = request;
            //object = credencialesGuiasPalex;
          
        return object;
        
    }
    @Override
    protected TrackingResponse consumeWebService(DatosTracking datosTracking, Object objRequest, Object credenciales, String proxy) throws Exception{
        TrackingResponse trackingResponse = new TrackingResponse();
        
        try{
            CredencialesTrackingTracusa credencialesTrackingTracusa = (CredencialesTrackingTracusa)credenciales;
            // OBTENER EL OBJETO DE LA SOLICITUD DE ACUERDO AL CARRIER QUE APLIQUE (ELEMPLO)
            // GuiasPalexRequest guiasPalexRequest = (GuiasPalexRequest)generaRequest(datosGuias, credenciales);
            String authentication = "";
            String REQUEST = (String)objRequest;
            authentication = credencialesTrackingTracusa.getContrasenia();
                String RESPONSE = utilRest.consumeWsRestPostBasicAuth(credencialesTrackingTracusa.getUrl() + credencialesTrackingTracusa.getPath()+"/"+datosTracking.getNumGuia(), authentication, "application/json", REQUEST, proxy, 200
        );
            
            
        if (RESPONSE.contains("ECOM-Excepción")) {           
            String respuesta = RESPONSE.replace("ECOM-Excepción: ", "");
                        /*
            List<ErrorPalex> errores = getErrores(respuesta);            
            respuesta = "";
            
            for(int i=0; i < errores.size(); i++){
                respuesta = (i==0 ? "" : ", ") + respuesta + errores.get(i).getMsgNo();   
            }
            */
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
        
        TrackingTracusaResponse trackingTracusaResponse = new TrackingTracusaResponse();
        trackingTracusaResponse = mapper.readValue(json, TrackingTracusaResponse.class);
        trackingTracusaResponse.getShipments().get(0).getTracker();
        
        for(int i = 0; i < trackingTracusaResponse.getShipments().get(0).getTracker().size();i++) {
        	if(trackingTracusaResponse.getShipments().get(0).getTracker().get(i).getTypeMovement().contains("RECOLECTADO")) {
        		String fecha = trackingTracusaResponse.getShipments().get(0).getTracker().get(i).getDate();
				String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
				trackingResponse.setFechaRecoleccion(fecha2);
				trackingResponse.setIdEstatusGuiaCarrier("TRN");
        	}        		
        }
        
        for(int i = 0; i < trackingTracusaResponse.getShipments().get(0).getTracker().size();i++) {
        	if(trackingTracusaResponse.getShipments().get(0).getTracker().get(i).getTypeMovement().contains("ENTREGADO")) {
        		String fecha = trackingTracusaResponse.getShipments().get(0).getTracker().get(i).getDate();
				String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
				trackingResponse.setFechaRecepcion(fecha2);
				trackingResponse.setIdEstatusGuiaCarrier("DLV");
				//trackingResponse.setRecibe(lista.get("recibio").toString());
        	}        		
        }
        
        if(trackingTracusaResponse.getShipments().get(0).getDelivery().getSignedBy() != null) {
	        if(!trackingTracusaResponse.getShipments().get(0).getDelivery().getSignedBy().equals("")) {
	        	String fecha = trackingTracusaResponse.getShipments().get(0).getDelivery().getDeliveryDate();
				String fecha2 = fecha.substring(8,10)+"/"+fecha.substring(5,7)+"/"+fecha.substring(0,4)+" "+fecha.substring(11,16);
	        	trackingResponse.setRecibe(trackingTracusaResponse.getShipments().get(0).getDelivery().getSignedBy());
	        	trackingResponse.setFechaRecepcion(fecha2);
	        	trackingResponse.setIdEstatusGuiaCarrier("DLV");
	        	trackingResponse.setIdEstatusGuia(30);
	        }
        }
        
        return trackingResponse;
    }
}
