package com.elektra.util;

import com.elektra.beans.DatosTracking;
import com.elektra.beans.TrackingResponse;
import com.elektra.dao.GeneralDao;
import com.elektra.dao.GeneralDaoImpl;
import com.elektra.dao.TrackingDao;
import com.elektra.dao.TrackingDaoImpl;

/**
 *
 * @author dparra
 */
public class TrackingPlantilla {
    
    TrackingDao trackingDao = new TrackingDaoImpl();
    GeneralDao generalDao = new GeneralDaoImpl();
    
    public TrackingResponse getTracking(DatosTracking datosTracking, Object credenciales, String proxy){
        TrackingResponse trackingResponse = new TrackingResponse();
        
        try{
            Object objectRequest = generaRequest(datosTracking, credenciales);
            trackingResponse = consumeWebService(datosTracking, objectRequest, credenciales, proxy);
            
            if(trackingResponse.getIdEstatusGuia()== -1){
                generalDao.insXml("-1", datosTracking.getNumGuia(), trackingResponse.getRefField1(), trackingResponse.getInput(), trackingResponse.getOutput(), datosTracking.getPedido(), datosTracking.getOrderId(), datosTracking.getCdId(), datosTracking.getIdCarrier(), "Tracking", datosTracking.getRef_field_2());
            }
            else{
                trackingResponse.setIdEstatusGuia(trackingDao.getIdEstatusGuia(datosTracking.getIdCarrier(), trackingResponse.getIdEstatusGuiaCarrier()));
            }
        
        }catch(Exception e){
            trackingResponse = configuraExcepcion(e);
            generalDao.insXml("-1", datosTracking.getNumGuia(), trackingResponse.getRefField1(), trackingResponse.getInput(), trackingResponse.getOutput(), datosTracking.getPedido(), datosTracking.getOrderId(), datosTracking.getCdId(), datosTracking.getIdCarrier(), "Tracking", datosTracking.getRef_field_2());
        }
        return trackingResponse;
    }
    
    protected Object generaRequest(DatosTracking datosTracking, Object credenciales) throws Exception{
        Object object = null;
        // REALIZAR EL CAST AL TIPO DE CREDENCIALES DEL CARRIER QUE APLIQUE (EJEMPLO)
        //CredencialesPalex credencialesGuiasPalex = (CredencialesPalex) credenciales;

        // CONFIGURAR EL OBJETO QUE SERÁ LA SOLICITUD AL WS



        // ASIGNAR AL OBJETO DE RETORNO EL OBJETO QUE SE CONFIGURÓ EN PASOS ANTERIORES (EJEMPLO)
        //object = credencialesGuiasPalex;


        return object;
        
    }
    
    protected TrackingResponse consumeWebService(DatosTracking datosTracking, Object objRequest, Object credenciales, String proxy) throws Exception{
        
        TrackingResponse trackingResponse = new TrackingResponse();
        
        try{
            
            // OBTENER EL OBJETO DE LA SOLICITUD DE ACUERDO AL CARRIER QUE APLIQUE (ELEMPLO)
            // GuiasPalexRequest guiasPalexRequest = (GuiasPalexRequest)generaRequest(datosGuias, credenciales);
            
        }catch(Exception e){
            
        }
        
        return trackingResponse;

    }
    
    protected TrackingResponse configuraExcepcion(Exception e){
        TrackingResponse trackingResponse = new TrackingResponse();
        trackingResponse.setIdEstatusGuia(-1);
        trackingResponse.setRefField1(e.toString());
        trackingResponse.setIdEstatusGuiaCarrier(null);
        return trackingResponse;
    }
    
}
