/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dao;

import com.elektra.beans.TrackingResponse;
import com.elektra.beans.DatosTracking;
import java.util.List;

/**
 *
 * @author dparra
 */
public interface TrackingDao {
    
    public List<DatosTracking> getTrackingData();
    
    public int getIdEstatusGuia(int idCarrier, String idEstatusGuiaCarrier);
    
    public int actIdEstatusGuia(TrackingResponse trackingResponse, DatosTracking datosTracking);
    public int actIdEstatusGuiaDoNothing(TrackingResponse trackingResponse, DatosTracking datosTracking);
    public int actIdEstatusGuiaError(TrackingResponse trackingResponse, DatosTracking datosTracking);
    public String getCredencialesGrales();
}
