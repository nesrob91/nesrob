/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */package com.elektra.tracking;import java.util.ArrayList;import java.util.List;import com.elektra.beans.CredencialesTrackingCarssa;import com.elektra.beans.CredencialesTrackingDhl;import com.elektra.beans.CredencialesTrackingEstafeta;import com.elektra.beans.CredencialesTrackingFedex;import com.elektra.beans.CredencialesTrackingPalex;import com.elektra.beans.CredencialesTrackingPaquetexpress;import com.elektra.beans.CredencialesTrackingTracusa;import com.elektra.beans.DatosTracking;import com.elektra.beans.TrackingResponse;import com.elektra.dao.CredencialesDao;import com.elektra.dao.CredencialesDaoImpl;import com.elektra.dao.TrackingDao;import com.elektra.dao.TrackingDaoImpl;import com.elektra.dhl.TrackingDhl;import com.elektra.estafeta.TrackingEstafeta;import com.elektra.fedex.TrackingFedex;import com.elektra.paquetexpress.TrackingPaquetexpress;import com.elektra.util.TrackingPlantilla;import com.palex.TrackingPalex;import tracusa.TrackingTracusa;/** * * * * @author dparra * */public class Tracking {    TrackingDao trackingDao;    CredencialesDao credencialesDao;    TrackingResponse trackingResponse;    List<DatosTracking> datosTrackingList;    TrackingEstafeta trackingEstafeta;    TrackingDhl trackingDhl;    //TrackingCarssa trackingCarssa;    TrackingFedex trackingFedex;    TrackingPaquetexpress trackingPaquetexpress;    TrackingTracusa trackingTracusa;    CredencialesTrackingEstafeta credencialesTrackingEstafeta;    CredencialesTrackingDhl credencialesTrackingDhl;    CredencialesTrackingCarssa credencialesTrackingCarssa;    CredencialesTrackingFedex credencialesTrackingFedex;    CredencialesTrackingPaquetexpress credencialesTrackingPaquetexpress;    CredencialesTrackingPalex credencialesTrackingPalex;    CredencialesTrackingTracusa credencialesTrackingTracusa;    /**     *     * @param args the command line arguments     *     */    public static void main(String[] args) {        Tracking tracking = new Tracking();        tracking.ejecutar();        //System.out.println("Proceso Ejecutado Correctamente");    }    public void ejecutar() {        int i = 0;        String proxy = "";        System.out.println("Iniciando Tracking... ");        String fecha = "2018-04-13T11:09:00-05:00";        String fecha2 = fecha.substring(8, 10) + "/" + fecha.substring(5, 7) + "/" + fecha.substring(0, 4) + " " + fecha.substring(11, 16);        // INSTANCIAMOS OBJETOS GENÉRICOS        trackingDao = new TrackingDaoImpl();        credencialesDao = new CredencialesDaoImpl();        trackingResponse = new TrackingResponse();        datosTrackingList = new ArrayList<>();        TrackingPlantilla tracking;        // INSTANCIAMOS OBJETOS DE CONEXIÓN A WS DE CARRIERS        trackingEstafeta = new TrackingEstafeta();        trackingDhl = new TrackingDhl();        //trackingCarssa = new TrackingCarssa();        trackingFedex = new TrackingFedex();        trackingPaquetexpress = new TrackingPaquetexpress();        trackingTracusa = new TrackingTracusa();        System.out.println("Consultando credenciales ESTAFETA - TRACKING");        // OBTENEMOS CREDENCIALES DE ESTAFETA - TRACKING        credencialesTrackingEstafeta = credencialesDao.getCredencialesTrackingEstafeta(2, 3);        System.out.println("Consultando credenciales DHL - TRACKING");        // OBTENEMOS CREDENCIALES DE DHL - TRACKING        credencialesTrackingDhl = credencialesDao.getCredencialesTrackingDhl(3, 3);        System.out.println("Consultando credenciales CARSSA - TRACKING");        // OBTENEMOS CREDENCIALES DE CARSSA - TRACKING        credencialesTrackingCarssa = credencialesDao.getCredencialesTrackingCarssa(4, 3);        System.out.println("Consultando credenciales FEDEX - TRACKING");        // OBTENEMOS CREDENCIALES DE FEDEX - TRACKING        credencialesTrackingFedex = credencialesDao.getCredencialesTrackingFedex(10, 3);        System.out.println("Consultando credenciales PAQUETEXPRESS - TRACKING");        // OBTENEMOS CREDENCIALES DE PAQUETEXPRESS - TRACKING        credencialesTrackingPaquetexpress = credencialesDao.getCredencialesTrackingPaquetexpress(7, 3);        System.out.println("Consultando credenciales PALEX - TRACKING");        // OBTENEMOS CREDENCIALES DE PALEX - TRACKING        credencialesTrackingPalex = credencialesDao.getCredencialesTrackingPalex(9, 3);        System.out.println("Consultando credenciales TRACUSA - TRACKING");        // OBTENEMOS CREDENCIALES DE PALEX - TRACKING        credencialesTrackingTracusa = credencialesDao.getCredencialesTrackingTracusa(15, 3);        System.out.println("Obteniendo guías");        // OBTENEMOS LA COLECCIÓN DE GUÍAS PARA REALIZAR TRACKING        datosTrackingList = trackingDao.getTrackingData();        proxy = trackingDao.getCredencialesGrales();        System.out.println("Iterando colección de guías...");        // ITERAMOS LA COLECCIÓN DE GUÍAS        for (DatosTracking dt : datosTrackingList) {            // ELEGIMOS EL WEB SERVICE A CONSUMIR DE ACUERDO AL CARRIER                                    switch (dt.getIdCarrier()) {                // ESTAFETA                case 2:                    trackingResponse = trackingEstafeta.getTracking(dt, credencialesTrackingEstafeta, proxy);                    break;                // DHL                case 3:                    trackingResponse = trackingDhl.getTracking(dt, credencialesTrackingDhl, proxy);                    break;                // CARSSA                case 4:                    //trackingResponse = trackingCarssa.getTracking(dt, credencialesTrackingCarssa);                    break;                // ESTAFETABT                case 6:                    trackingResponse = trackingEstafeta.getTracking(dt, credencialesTrackingEstafeta, proxy);                    //trackingResponse = trackingFedex.getTracking(dt, credencialesTrackingFedex);                    break;                // PAQUETEXPRESS                case 7:                    trackingResponse = trackingPaquetexpress.getTracking(dt, credencialesTrackingPaquetexpress, proxy);                    break;                // PALEX                case 9:                    tracking = new TrackingPalex();                    trackingResponse = tracking.getTracking(dt, credencialesTrackingPalex, proxy);                    break;                // FEDEX                case 10:                    trackingResponse = trackingFedex.getTracking(dt, credencialesTrackingFedex, proxy);                    break;                // TRACUSA                case 15:                    trackingResponse = trackingTracusa.getTracking(dt, credencialesTrackingTracusa, proxy);                    break;                // EKTNVIA                case 11:                    break;                // CARRIER NO IDENTIFICADO                default:                    trackingResponse.setIdEstatusGuia(-1);                    trackingResponse.setRefField1("Carrier no identificado");                    trackingResponse.setIdEstatusGuiaCarrier(null);                    break;            }            // ACTUALIZAMOS LAS GUÍAS QUE GENERARON UN ERROR AL CONSUMIR EL WS            if (trackingResponse.getIdEstatusGuia() == -1) {                trackingDao.actIdEstatusGuiaError(trackingResponse, dt);            } // ACTUALIZAMOS LAS GUÍAS QUE AÚN NO GENERAN UN MOVIMIENTO            else if (trackingResponse.getIdEstatusGuia() == 0 && trackingResponse != null) {                trackingDao.actIdEstatusGuiaDoNothing(trackingResponse, dt);            } // ACTUALIZAMOS LAS GUÍAS QUE YA GENERARON UN MOVIMIENTO            else {                trackingDao.actIdEstatusGuia(trackingResponse, dt);            }            i++;            System.out.println(((i * 100) / datosTrackingList.size()) + " %");            //System.out.println(" -----------------------------------------------------------------------------------------\n");        }    }}