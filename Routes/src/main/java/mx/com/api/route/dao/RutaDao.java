/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.EsquemaPago;
import mx.com.api.route.beans.Remision;

/**
 *
 * @author nroblerol
 */
public interface RutaDao {
    public Integer getFolRut(int tipo, int almacen);
    public boolean updateFolRut(int tipo, int almacen, int folio);
    public Integer getDiasTol(int almacen);
    public boolean existsMDN(int mdn, int almacen);
    public List<Map<String,Object>> validateRemisionTranrut(List<Remision> rem);
    public double getFacorEstiba(String aplicacion);
    public double getMtsLibres(Integer almacen, Integer idTransporte, Integer idUnidad, double mts, String placa, Integer tiempoEco);
    public Map<String,Double> getMtsPago_Imp(Integer emisor, Integer destino, double mtsPagar);
    public Map<String,Double> getVolumenTarifa(Integer ori, String folrems);
    public Map<String,Double> getVolumen_Precio(Integer ori, Integer des, double mts, String folrems, double kms, double impMax);
    public Map<String,Double> getVolumen_Precio_Lyde(Integer ori, Integer des, double mts, String folrems, double kms, double impMax);
    public double getMtsPagar(Integer emisor, Integer destino, double mtsEst, boolean min);
    public double getIva(Integer emisor, Integer tienda);
    public boolean isSinIva(Integer idTransporte);
    public Map<String,Object> getKmsTR(Integer origen, Integer destino);
    public double getFactorDescuentoTransp(Integer origen);
    public boolean insertCobroTransportistas(int tipoRuta, Integer origen, Integer destino, Integer idTransp, Integer folrut, double importe, double descuento);
    public boolean insertCtlimprut(Integer origen, Integer destino, Integer folrut, Integer idTransp, Integer idUni, String placa, String chofer,
        Integer pta, String usuario, double mtsPago, double impBruto, double iva, double subTot, double ret, double impNeto, String sec    );
    public boolean insertCtlflt(String pais, Integer ola, Integer pta, Integer folrut, Integer origen, Integer destino, String cecoO,
        String cecoD, String locFor, Integer kms,  Integer idTransp, Integer idUni, double mts, Integer pzs, double costo, double mtsPago, double impBruto, 
        double iva, double subTot, double ret, double impNeto, String usuario, String ftcans, String ftfact, String placa, String obs, String sellos,
        String chofer, String sec, String tipoEco, Integer folenv,  double mtsUn, Integer mtvo,  Integer tipoRuta, Integer mdn, Integer ftfacd,
        Integer ftfoad, Integer ftfead, Integer ftfope, Integer ftfepe, Integer ftfoct, Integer ftfect, Integer ftfocp, Integer ftfecp, String checador,
        String estibador     );
    public boolean insertCtlfltd(Integer origen, Integer destino, Integer folrut, Integer folrem);
    public boolean insertTranrut(Integer origen, Integer destino, Integer folrut, Integer folrem, Integer fecart);
    public boolean cancelTranrut(Integer origen, List<String> rutas);
    public boolean cancelCtlflt(Integer origen, List<String> rutas);
    public List<EsquemaPago> getConceptosPago(Integer origen, Integer destino, Integer proveedor);
}
