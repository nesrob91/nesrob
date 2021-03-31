/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.EntregaTienda;
import mx.com.api.route.beans.Remision;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;

/**
 *
 * @author nroblerol
 */
public interface RutaService {
    public Integer getFolRut(int tipo, int almacen);
    public Map<String,Object> registraRuta(Integer origen, List<Remision> rem, Transporte transporte, Unidad unidad, Integer mdn, Integer folEnv, String checador, String estibador);
    public boolean updateFolRut(int tipo, int almacen, int folio) ;
    public Integer getDiasTol(Integer origen);
    public boolean existsMDN(Integer mdn, Integer almacen);
    public double sumaCtoRemision(List<Remision> rem, Map<String,SKU> diccionarioSku);
    public Integer sumaPzsRemision(List<Remision> rem);
    public double sumaMtsRemision(List<Remision> rem, Map<String,SKU> diccionarioSku);
    public Map<String,Object> validateRemisionTranrut(List<Remision> rem);
    public Map<String,Object> insertRuta(
                        int vi_truta,Transporte vi_prov,Unidad vi_eco,List<Remision> vi_frems, double mts_modif, Integer vi_usuario,Integer mtvo,String vi_obs,String vi_sellos,
                        int vi_sec,Integer v_folenv, Integer vi_mtvo,Integer vi_mdn,
                        Integer vi_ccts,Integer vi_ccts_tda,String vi_checador,String vi_estibador, Integer folRut);
    public void insertsRutas(List<Remision> rem, Transporte transp, Unidad eco, double impBruto, Integer folrut, double descTransp, String pais,
        Integer ola, Integer pta, String cecoO, String cecoD, String locFor, Integer kms,  double mts, Integer pzs, 
        double costo, double mtsPago,  double iva, double subTot, double ret, double impNeto, String usuario, String ftcans, String ftfact, 
        String placa, String obs, String sellos, String sec, String tipoEco, Integer folenv, Integer mtvo,  
        Integer tipoRuta, Integer mdn, Integer ftfacd,Integer ftfoad, Integer ftfead, Integer ftfope, Integer ftfepe, Integer ftfoct, Integer ftfect, 
        Integer ftfocp, Integer ftfecp, String checador, String estibador ) throws Exception;
    public boolean cancelTranrut(Integer origen, String rutas, Integer usuario);
    public Map<String,Object> getStatRut(Integer origen, String remision);
    public boolean updtEntregaTienda(EntregaTienda entrega);
}
