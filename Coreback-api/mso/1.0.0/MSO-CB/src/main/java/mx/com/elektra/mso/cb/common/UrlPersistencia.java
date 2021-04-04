/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Data
@Component
public class UrlPersistencia {

    @Value("${persistance.url.shipment}")
    private String urlPaquete;
    @Value("${persistance.url.exec}")
    private String urlEvalPrev;
    @Value("${persistance.url.rules}")
    private String urlReglas;
    @Value("${persistance.url.provs}")
    private String urlProveedores;
    @Value("${persistance.url.provs.cond}")
    private String urlProveedoresCond;
    @Value("${persistance.url.provs.min}")
    private String urlProveedoresMin;
    @Value("${persistance.url.provs.max}")
    private String urlProveedoresMax;
    @Value("${persistance.url.provs.ini}")
    private String urlProveedoresHdr;
    @Value("${persistance.url.provs.iter}")
    private String urlProveedoresIter;
    @Value("${persistance.url.hdr}")
    private String urlHdr;
    @Value("${persistance.url.dtl}")
    private String urlDtl;
    @Value("${persistance.url.dtl.eval}")
    private String urlDtlEval;
    @Value("${persistance.url.trfs}")
    private String urlTarifa;
    @Value("${persistance.url.ei}")
    private String urlExclIncl;
    @Value("${persistance.url.rating}")
    private String urlRating;
    @Value("${persistance.url.asig}")
    private String urlCapacidad;
    @Value("${persistance.url.asig.cur}")
    private String urlCapacidadAsig;

}
