/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dao;

import com.elektra.beans.CredencialesTrackingCarssa;
import com.elektra.beans.CredencialesTrackingDhl;
import com.elektra.beans.CredencialesTrackingEstafeta;
import com.elektra.beans.CredencialesTrackingFedex;
import com.elektra.beans.CredencialesTrackingPalex;
import com.elektra.beans.CredencialesTrackingPaquetexpress;
import com.elektra.beans.CredencialesTrackingTracusa;

/**
 *
 * @author dparra
 */
public interface CredencialesDao {
    
    public CredencialesTrackingEstafeta getCredencialesTrackingEstafeta(int idCarrier, int idServicio);
    public CredencialesTrackingDhl getCredencialesTrackingDhl(int idCarrier, int idServicio);
    public CredencialesTrackingCarssa getCredencialesTrackingCarssa(int idCarrier, int idServicio);
    public CredencialesTrackingFedex getCredencialesTrackingFedex(int idCarrier, int idServicio);
    public CredencialesTrackingPaquetexpress getCredencialesTrackingPaquetexpress(int idCarrier, int idServicio);
    public CredencialesTrackingPalex getCredencialesTrackingPalex(int idCarrier, int idServicio);
    public CredencialesTrackingTracusa getCredencialesTrackingTracusa(int idCarrier, int idServicio);
}
