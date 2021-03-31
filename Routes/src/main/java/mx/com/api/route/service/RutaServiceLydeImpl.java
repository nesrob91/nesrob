/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import mx.com.api.route.dao.GeneralDao;
import mx.com.api.route.dao.RutaDao;
import mx.com.api.route.dao.TiendaDao;
import mx.com.api.route.dao.TransporteDao;
import mx.com.api.route.beans.DetalleRem;
import mx.com.api.route.beans.EntregaTienda;
import mx.com.api.route.beans.EsquemaPago;
import mx.com.api.route.beans.Remision;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nroblerol
 */
@Service("rutaServiceLyde")
public class RutaServiceLydeImpl implements RutaService {

    @Autowired
    private RutaDao rutasDaoLyde;
    @Autowired
    private GeneralDao generalDao;
    @Autowired
    private TransporteDao transporteDao;
    @Autowired
    private TiendaDao tiendaDao;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private AtomicLong idRequest;

    @Override
    public Integer getFolRut(int tipo, int almacen) {
        return rutasDaoLyde.getFolRut(tipo, almacen);
    }

    @Override
    public Map<String, Object> registraRuta(Integer origen, List<Remision> rem, Transporte transporte, Unidad unidad, Integer mdn, Integer folEnv,
            String checador, String estibador) {
        Map<String, Object> result = new HashMap<>();
        Integer getFolioEnv;
        Map<String, Object> validateRem = validateRemisionTranrut(rem);
        if ((Boolean) validateRem.get("error")) {
            result.put("Error", true);
            result.put("Code", (String) validateRem.get("code"));
            if(validateRem.containsKey("folrem"))
                result.put("Remision",(ArrayList)validateRem.get("folrem"));
            if (validateRem.containsKey("remision") && validateRem.containsKey("folios")) {
                result.put("Folios", validateRem.get("folios"));
                result.put("Message", "Rutas Obtenidas");
            } else {
                result.put("Message", (String) validateRem.get("message") + (validateRem.containsKey("remision") ? (String) validateRem.get("remision") : ""));
            }
        } else {
            try {
                getFolioEnv = rutasDaoLyde.getFolRut(6, origen);
            } catch (Exception e) {
                getFolioEnv = null;
            }
            if (getFolioEnv != null) {
                result.put("Error", false);
                result.put("Message", "OK");
                result.put("v_fol_env", getFolioEnv);
            } else {
                result.put("Error", true);
                result.put("Code", "GRTGF0001");
                result.put("Message", "No se pudo obtener Folio de Envio");
            }

        }
        return result;
    }

    @Override
    public boolean updateFolRut(int tipo, int almacen, int folio) {
        return rutasDaoLyde.updateFolRut(tipo, almacen, folio);
    }

    @Override
    public Integer getDiasTol(Integer origen) {
        return rutasDaoLyde.getDiasTol(origen);
    }

    @Override
    public boolean existsMDN(Integer mdn, Integer almacen) {

        return rutasDaoLyde.existsMDN(mdn, almacen);
    }

    private Map<String, SKU> getInfoSKU(List<Remision> rem) {
        Map<String, SKU> diccionarioSku = new HashMap<>();
        List<SKU> skuInfo = new ArrayList<>();
        Set<String> s = new HashSet<>();
        for (Remision r : rem) {
            for (DetalleRem dr : r.getDetalle()) {
                s.add(dr.getSku());
            }
        }
        List<String> skus = new ArrayList<>(s);
        try {
            for (int i = 0; skus.size() > i; i += 1000) {
                if ((i + 1000) < skus.size()) {
                    skuInfo.addAll(generalDao.getSkuInfo(skus.subList(i, i + 1000)));
                } else {
                    skuInfo.addAll(generalDao.getSkuInfo(skus.subList(i, skus.size())));
                }
            }
        } catch (Exception e) {
            skuInfo = null;
            SKU error = new SKU();
            error.setSku("No se puedo recuperar la informacion de los SKU");
            diccionarioSku.put("error", error);
        }
        if (skuInfo != null) {
            if (skuInfo.isEmpty()) {
                SKU error = new SKU();
                error.setSku("No se encontro informacion de los SKU");
                diccionarioSku.put("error", error);
            } else {
                if (s.size() > skuInfo.size()) {
                    SKU error = new SKU();
                    error.setSku("No se encontro informacion de uno o mas SKU");
                    diccionarioSku.put("error", error);
                } else {
                    skuInfo.forEach((si) -> {
                        diccionarioSku.put(si.getSku(), si);
                    });
                }
            }
        }
        return diccionarioSku;
    }

    @Override
    public double sumaCtoRemision(List<Remision> rem, Map<String, SKU> diccionarioSku) {
        double costo = 0;
        for (Remision r : rem) {
            for (DetalleRem dr : r.getDetalle()) {
                if (diccionarioSku.containsKey(dr.getSku())) {
                    costo += diccionarioSku.get(dr.getSku()).getCosto() * dr.getCant();
                }
            }
        }
        return costo;
    }

    @Override
    public Integer sumaPzsRemision(List<Remision> rem) {
        Integer sumPzs = 0;
        for (Remision r : rem) {
            for (DetalleRem dr : r.getDetalle()) {
                sumPzs += dr.getCant();
            }
        }
        return sumPzs;
    }

    @Override
    public double sumaMtsRemision(List<Remision> rem, Map<String, SKU> diccionarioSku) {
        double mts = 0;
        for (Remision r : rem) {
            for (DetalleRem dr : r.getDetalle()) {
                if (diccionarioSku.containsKey(dr.getSku())) {
                    mts += diccionarioSku.get(dr.getSku()).getVolumen() * dr.getCant();
                }
            }
        }
        return mts;
    }

    @Override
    public Map<String, Object> validateRemisionTranrut(List<Remision> rem) {
        Map<String, Object> validate = new HashMap<>();
        List<Map<String, Object>> remsFound = rutasDaoLyde.validateRemisionTranrut(rem);
        List<String> rutas;
        List<String> guias;
        List<String> folrems;
        if (remsFound != null) {
            if (remsFound.isEmpty()) {
                validate.put("error", false);
                validate.put("message", "Sin rutas");
            } else {
                validate.put("error", true);
                validate.put("code", "GRTVRR0002");
                validate.put("message", "Ya hay informacion");
                String found = " (Remision,Ruta) : {";
                String foundG = " (Remision,Guia) : {";
                String rems = "";
                String gs = "";
                rutas = new ArrayList<>();
                guias = new ArrayList<>();
                folrems=new ArrayList<>();
                for (Map<String, Object> r : remsFound) {
                    folrems.add(r.get("FOLDOC").toString());
                    if (r.containsKey("NUM_GUIA") && r.get("NUM_GUIA") != null) {
                        guias.add(r.get("NUM_GUIA").toString());
                        gs += (" [" + r.get("FOLDOC") + " , " + r.get("NUM_GUIA") + "] ,");
                    } else {
                        rutas.add(r.get("FOLRUT").toString());
                        rems += (" [" + r.get("FOLDOC") + " , " + r.get("FOLRUT") + "] ,");
                    }
                }
                if (!rutas.isEmpty()) {
                    rems = rems.substring(0, rems.length() - 2);
                    rems = rems.substring(1, rems.length());
                    found += rems + "}";
                }
                if (!guias.isEmpty()) {
                    gs = gs.substring(0, gs.length() - 2);
                    gs = gs.substring(1, gs.length());
                    foundG += gs + "}";
                }
                if (!rutas.isEmpty() && !guias.isEmpty()) {
                    found += "," + foundG;
                }
                if (rutas.isEmpty()) {
                    found = foundG;
                }
                validate.put("remision", found);
                validate.put("folrem", folrems);
                if (guias.isEmpty()) {
                    validate.put("folios", rutas);
                }
            }
        } else {
            validate.put("error", true);
            validate.put("code", "GRTVRR0001");
            validate.put("message", "No se pudo validar la informacion de rutas");
        }
        return validate;
    }

    @Override
    public Map<String, Object> insertRuta(
            int vi_truta, Transporte vi_prov, Unidad vi_eco, List<Remision> vi_frems, double vi_mts_modif, Integer vi_usuario, Integer motivo, String vi_obs,
            String vi_sellos, int vi_sec, Integer v_folenv, Integer vi_mtvo, Integer vi_mdn, Integer vi_ccts, Integer vi_ccts_tda, String vi_checador,
            String vi_estibador, Integer folRut) {
        String rems = "";
        for (Remision r : vi_frems) {
            rems += (r.getFolrem() + ",");
        }
        rems = rems.substring(0, rems.length() - 1);
        Map<String, Object> result = new HashMap<>();
        Map<String, SKU> diccionarioSku = getInfoSKU(vi_frems);
        double mts = 0;
        Integer pzs = 0;
        double costo = 0;

        if (diccionarioSku.containsKey("error")) {
            result.put("Error", true);
            result.put("Code", "GRTGSI0001");
            result.put("Message", diccionarioSku.get("error").getSku());
            return result;
        } else {
            mts = sumaMtsRemision(vi_frems, diccionarioSku);
            pzs = sumaPzsRemision(vi_frems);
            costo = sumaCtoRemision(vi_frems, diccionarioSku);
        }
        double fe = 0;
        switch (vi_frems.get(0).getEmisor()) {
            default:
                //if(vi_eco.getTipo().equals("D"))
                fe = rutasDaoLyde.getFacorEstiba("RUTAS REMISIONES");
                //else
                //fe=1.22;
                break;
        }
        double mtscalc = 0;
        if (vi_mts_modif == 0) {
            mtscalc = vi_eco.getMts();
        } else {
            mtscalc = vi_mts_modif;
        }
        double mtsLibre = 0;
        double mtsEst = mtscalc * fe;
        Integer tiempoEco;
        tiempoEco = transporteDao.getTiempoEco(vi_frems.get(0).getEmisor());
        if (tiempoEco != null) {
            mtsLibre = vi_eco.getMts();//rutasDaoLyde.getMtsLibres(vi_frems.get(0).getEmisor(), vi_prov.getIdTransporte(), vi_eco.getEco(), vi_eco.getMts(), vi_eco.getPlaca(), tiempoEco);
        }
        String cecoOrig;
        String cecoDest;
        Integer isDist;
        Integer isCd;
        //if (vi_ccts == 0) {
        //ccts is never retrieved until this method is invocated (as of feb-2021)
            //List<Integer> tienda = new ArrayList<>();
            //tienda.add(vi_frems.get(0).getRecept());
            //isDist = tiendaDao.isDistItk(tienda);//validate if result was null ? theoretically it was validated before
            //is never validated for 3PL (Lyde as of feb 2021)
            //if (isDist > 0) {
                //app-'ITK'
                //if (vi_frems.get(0).getEmisor() == 712) {
                    //vChar-DECODE (v_tda, 1941, '7', 5420, '7', '6',9190,'8')
                    //cecoOrig = generalDao.getCeCo(true, vi_frems.get(0).getEmisor(), null, "'ITK'", "DECODE (" + vi_frems.get(0).getRecept() + ", 1941, '7', 5420, '7', '6',9190,'8')", false);
                //} else {
                    //vChar-'0'
                    //cecoOrig = generalDao.getCeCo(true, vi_frems.get(0).getEmisor(), null, "'ITK'", "'0'", false);
                //}
            //} else {
                cecoOrig = generalDao.getCeCo(false, vi_frems.get(0).getEmisor(), null, "", "", false);
            //}
        //} else {
            //cecoOrig = vi_ccts + "";
        //}
        if (cecoOrig == null) {
            result.put("Error", true);
            result.put("Code", "GRT0001");
            result.put("Message", "Sin centro de costos origen");
            return result;
        }
        isCd = tiendaDao.isCD(vi_frems.get(0).getRecept());
        if (isCd == null) {
            result.put("Error", true);
            result.put("Code", "GRT0001");
            result.put("Message", "No se recupero informacion de tienda");
            return result;
        }
        //if (vi_ccts_tda == 0) {
        //ccts is never retrieved until this method is invocated (as of feb-2021)
            if (isCd > 0) {
                cecoDest = generalDao.getCeCo(false, null, vi_frems.get(0).getRecept(), "", "", false);
            } else {
                cecoDest = generalDao.getCeCo(false, null, vi_frems.get(0).getRecept(), "", "", true);
            }
        //} else {
            //cecoDest = vi_ccts_tda + "";
        //}
        if (cecoDest == null) {
            result.put("Error", true);
            result.put("Code", "GRT0001");
            result.put("Message", "Sin centro de costos destino");
            return result;
        }
        double mtsPago = 0;
        double impPago = 0;
        int kms = 0;
        double ret = 0;
        double subTot = 0;
        double iva = 0;
        boolean sinIva = false;
        double impNeto = 0;
        String rutaLocFor="";
        
        impPago=calculateImp(vi_frems, diccionarioSku, vi_prov.getIdTransporte());
        
        //validate mtsPago
        //mtsPago = ?
        
        sinIva = rutasDaoLyde.isSinIva(vi_prov.getIdTransporte());
        if (sinIva) {
            iva = 0;
        } else {
            iva = rutasDaoLyde.getIva(vi_frems.get(0).getEmisor(), vi_frems.get(0).getRecept());
        }
        if (iva == 0 && impPago == 0 && !vi_eco.getTipo().equals("D") && vi_frems.get(0).getEmisor() != 3302) {
            sinIva = true;
        }
        if (iva == -1) {
            result.put("Error", true);
            result.put("Code", "GRTIVA0001");
            result.put("Message", "No se recupero IVA. T" + vi_frems.get(0).getRecept());
            return result;
        } else {
            iva = iva * impPago;
        }
        switch (vi_frems.get(0).getEmisor()) {
            case 3302:
            case 712:
                ret = 0;
                break;
            case 7469:
            case 9105:
                ret = impPago * 0.04;
                break;
            case 9001:
                if (vi_eco.getTipo().equals("D") && impPago >= 2500) {
                    ret = iva * 0.15;
                } else {
                    ret = 0;
                }
                break;
            default:
                ret = impPago * 0.04;
                break;
        }
        subTot = impPago + iva;
        impNeto = subTot - ret;
        Map<String, Object> kmsTR;
        
        kmsTR = rutasDaoLyde.getKmsTR(vi_frems.get(0).getEmisor(), vi_frems.get(0).getRecept());
        if (kmsTR.containsKey("error")) {
            result.put("Error", true);
            result.put("Code", "GRT0001");
            result.put("Message", "No se recupero Tipo de ruta");
            return result;
        }else{
            kms=Integer.valueOf(kmsTR.get("kms").toString());
            rutaLocFor=kmsTR.get("locFor").toString();
        }
        
        String ftfact = "";
        Integer ftfacd = 0;
        Integer ftfead = 0;
        String ftcans = "";
        double descTransp = 0;
        Integer ftfoad = 0;
        double ftimpb = 0;
        String pais = tiendaDao.getPaisTda(vi_frems.get(0).getEmisor());
        if (pais == null) {
            result.put("Error", true);
            result.put("Code", "GRT0001");
            result.put("Message", "No se recupero Informacion de tienda");
            return result;
        }
        if (vi_eco.getTipo().equals("D")) {
            if (pais.equals("MEX")) {
                ftfact = "0000000000";
                ftfacd = Integer.parseInt(new SimpleDateFormat("YYYYMMDD").format(new Date()));
            } else {
                ftfact = null;
                ftfacd = null;
            }
            ftfead = Integer.parseInt(new SimpleDateFormat("YYYYMMDD").format(new Date()));
            ftfoad = 1;
        } else {
            ftcans = null;
            ftfact = null;
            if (impPago > 1000) {
                double facDesc = rutasDaoLyde.getFactorDescuentoTransp(vi_frems.get(0).getEmisor());
                descTransp = impPago * facDesc;
                ftimpb = impPago - descTransp;
            } else {
                ftimpb = impPago;
            }
        }
        
        Integer ola = null;
        Integer pta = null;
        try {
            insertsRutas(vi_frems, vi_prov, vi_eco, ftimpb, folRut, descTransp, pais, ola, pta, cecoOrig, cecoDest, rutaLocFor,
                    kms, mts, pzs, costo, mtsPago, iva, subTot, ret, impNeto, vi_usuario + "", ftcans, ftfact, vi_eco.getPlaca(),
                    vi_obs, vi_sellos, vi_sec + "", vi_eco.getTipo(), v_folenv, vi_mtvo, vi_truta, vi_mdn, ftfacd, ftfoad, ftfead, ftfoad, ftfead, ftfoad,
                    ftfead, ftfoad, ftfead, vi_checador, vi_estibador);
            //if(rutasDaoLyde.updateFolRut(5, vi_frems.get(0).getEmisor(), folrut)){

            //}else{
            //  result.put("Error",true);
            //result.put("Code","GRTGFR0003");
            //result.put("FolEnv",v_folenv);
            //result.put("Message","No se pudo recuperar folio de ruta");
            //}
            result.put("Error", false);
            result.put("Code", folRut);
            result.put("FolEnv", v_folenv);
            result.put("Message", "Ruta Creada");
        } catch (Exception e) {
            result.put("Error", true);
            result.put("Code", folRut);
            result.put("FolEnv", v_folenv);
            try {
                String[] s = e.getMessage().split(":");
                result.put("Message", s[0] + "Fallo al registrar ruta");
                logger.insertaError(1110002, 11, 9971, 0, "", 0, 0, "", 0, 0,
                        e.getMessage(), getClass().getName() + "." + new Object() {
                }.getClass().getEnclosingMethod().getName(), "");//, idRequest.toString(), "","");

            } catch (Exception ex) {
                result.put("Message", "GRCT0:Fallo al registrar ruta");
            }
        }
        return result;
    }
    
    private double calculateImp(List<Remision> vi_frems, Map<String,SKU> skuInfo, Integer idTransporte){
        double imp=0.0;
        double costoBase=0.0;
        double costoSku=0.0;
        double costoSkuTot=0.0;
        double costoAccesorio=0.0;
        double costoVolumen=0.0;
        double costoVolumenE=0.0;
        double costoZE=0.0;
        Set<String> changeClass=new HashSet<>();
        double volumen=0.0;
        List<EsquemaPago> esquemaPago=rutasDaoLyde.getConceptosPago(vi_frems.get(0).getEmisor(), vi_frems.get(0).getRecept(), idTransporte);
        //List<EsquemaPagoAcc> esquemaPagoAcc=rutasDao.getAccesorioConceptosPago(vi_frems.get(0).getEmisor(), vi_frems.get(0).getRecept());
        if(esquemaPago==null){
            imp=-1;
        }else{
            if(esquemaPago.isEmpty()){
                imp=0;
            }else{
                for(EsquemaPago esquema:esquemaPago){
                    costoSku=esquema.getImporteClasf();
                    costoAccesorio=esquema.getImporteAcc();
                    costoVolumen=esquema.getImporteSCBase();
                    costoZE=esquema.getImporteZE();
                    int count=0;
                    int acc=0;
                    for(Remision r:vi_frems){
                        for(DetalleRem dr: r.getDetalle()){
                            if(esquema.getImporteSCBase()==0){
                                switch(esquema.getNivelClasificacion()){
                                    case 2:
                                        if(skuInfo.get(dr.getSku()).getIdClase().equals(esquema.getClasificacion()))
                                            count++;
                                        break;
                                    case 3:
                                        if(skuInfo.get(dr.getSku()).getIdSubClase().equals(esquema.getClasificacion()))
                                            count++;
                                        break;
                                    case 4:
                                        if(skuInfo.get(dr.getSku()).getIdDepto().equals(esquema.getClasificacion()))
                                            count++;
                                        break;
                                    case 5:
                                        if(skuInfo.get(dr.getSku()).getIdSubDepto().equals(esquema.getClasificacion()))
                                            count++;
                                        break;
                                    default :
                                        count+=0;
                                        break;
                                }
                            }else{
                                volumen+=skuInfo.get(dr.getSku()).getPeso();
                                count=1;
                            }
                        }
                    }
                    if(!changeClass.contains(esquema.getDescTipoPago())){
                        changeClass.add(esquema.getDescTipoPago());
                        if(count>0)
                            costoBase+=esquema.getImporte();
                    }
                    if(esquema.getImporteSCBase()==0){
                        if(!esquema.getAccesorioTipo().equals(1)){
                            acc=count/esquema.getVolumenMax();
                            float floatValue=count % esquema.getVolumenMax() ;
                            acc=acc+(floatValue == 0 ? 0:1);

                            costoSkuTot+=costoAccesorio*acc;//
                        }else{
                            costoSkuTot+=costoSku*count;
                        }
                    }else{
                        int base = esquema.getVolumenSCBase();
                        Double div = volumen/base;
                        BigDecimal db = new BigDecimal(div.toString());
                        BigDecimal round = db.setScale(0, RoundingMode.UP);
                        Integer roundI = round.intValue();
                        costoVolumenE=esquema.getImporteSCExtra()*(roundI-1);
                    }
                }
            }
            imp=costoBase+costoSkuTot+costoZE+costoVolumen+costoVolumenE;
        }
        return imp;
    }

    //@Transactional(rollbackFor = Exception.class)
    @Override
    public void insertsRutas(List<Remision> rem, Transporte transp, Unidad eco, double impBruto, Integer folrut, double descTransp, String pais,
            Integer ola, Integer pta, String cecoO, String cecoD, String locFor, Integer kms, double mts, Integer pzs,
            double costo, double mtsPago, double iva, double subTot, double ret, double impNeto, String usuario, String ftcans, String ftfact,
            String placa, String obs, String sellos, String sec, String tipoEco, Integer folenv, Integer mtvo,
            Integer tipoRuta, Integer mdn, Integer ftfacd, Integer ftfoad, Integer ftfead, Integer ftfope, Integer ftfepe, Integer ftfoct, Integer ftfect,
            Integer ftfocp, Integer ftfecp, String checador, String estibador) throws Exception {
        String msg = "";
        try {
            if (descTransp > 0) {
                rutasDaoLyde.insertCobroTransportistas(3, rem.get(0).getEmisor(), rem.get(0).getRecept(), transp.getIdTransporte(), folrut, impBruto, descTransp);
            }
            if (pais.equals("PER")) {
                //same inserts, diferent values, not implemented yet
            } else {
                boolean i1 = rutasDaoLyde.insertCtlimprut(rem.get(0).getEmisor(), rem.get(0).getRecept(), folrut, transp.getIdTransporte(), eco.getEco(), placa, eco.getChofer(), pta, usuario,
                        mtsPago, impBruto, iva, subTot, ret, impNeto, sec);
                boolean i2 = rutasDaoLyde.insertCtlflt(pais, ola, pta, folrut, rem.get(0).getEmisor(), rem.get(0).getRecept(), cecoO, cecoD, locFor, kms, transp.getIdTransporte(),
                        eco.getEco(), mts, pzs, costo, mtsPago, impBruto, iva, subTot, ret, impNeto, usuario, ftcans, ftfact, placa, obs, sellos, eco.getChofer(),
                        sec, tipoEco, folenv, eco.getMts(), mtvo, tipoRuta, mdn, ftfacd, ftfoad, ftfead, ftfope, ftfepe, ftfoct, ftfect, ftfocp, ftfecp,
                        checador, estibador);
                boolean i3 = false;
                boolean i4 = false;
                if (i2) {
                    for (Remision r : rem) {
                        i3 = rutasDaoLyde.insertCtlfltd(r.getEmisor(), r.getRecept(), folrut, Integer.parseInt(r.getFolrem()));
                        i4 = rutasDaoLyde.insertTranrut(r.getEmisor(), r.getRecept(), folrut, Integer.parseInt(r.getFolrem()), Integer.parseInt(r.getFecart()));
                        if (!i4) {
                            msg = "GRCT2:";
                            throw new Exception(msg + "Fallo al registrar ruta por remison TRANRUT | Folio de ruta intentado " + folrut);
                        }
                        EntregaTienda entrega=new EntregaTienda();
                        entrega.setOrigen(r.getEmisor());
                        entrega.setDestino(r.getRecept());
                        entrega.setFolrem(r.getFolrem());
                        entrega.setIdStatus(1);
                        entrega.setUsuarioModificacion(Integer.parseInt(usuario));
                        rutasDaoLyde.insEntregaTienda(entrega);
                        rutasDaoLyde.insEntregaTiendaBit(entrega);
                    }
                } else {
                    msg = "GRCT1:";
                    throw new Exception(msg + "Fallo al registrar ruta en CTLFLT | Folio de ruta intentado " + folrut);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean cancelTranrut(Integer origen, String remision, Integer usuario) {
        try {
            if (rutasDaoLyde.cancelTranrut(origen, remision, usuario)) {
                rutasDaoLyde.cancelCtlflt(origen, remision, usuario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            try {
                logger.insertaError(1110002, 11, origen, 0, "", 0, 0, "", 0, 0,
                        e.toString(), getClass().getName() + "." + new Object() {
                }.getClass().getEnclosingMethod().getName(), "");//, idRequest.toString(), "","");

            } catch (Exception ex) {
            }
            return false;
        }
    }

    @Override
    public Map<String, Object> getStatRut(Integer origen, String remision) {
        Map<String, Object> result = new HashMap<>();
        try{
            List<Map<String,Object>> res=rutasDaoLyde.getStatRoute(origen, remision);
            if(res==null){
                result.put("Error",true);
                result.put("Mensaje","No se pudo recuperar informacion");
                result.put("Ruta","");
            }else if (res.isEmpty()){
                result.put("Error",true);
                result.put("Mensaje","No hay informacion de ruta");
                result.put("Ruta","");
            }else{
                result.put("Error",false);
                result.put("Ruta",res.get(0).get("FOLRUT").toString());
                StringBuilder sb=new StringBuilder();
                if(res.get(0).get("STATUS").toString().equals("C"))
                    sb.append("Estatus Cancelada");
                else{
                    sb.append("Estatus ");
                    if(res.get(0).containsKey("FECCONF") && res.get(0).get("FECCONF")!=null){
                        sb.append("Confirmada. Confirmacion ".concat(res.get(0).get("FECCONF").toString()));
                    }else{
                        sb.append("Transito");
                    }
                    if(res.get(0).containsKey("FOLIO_NC") && res.get(0).get("FOLIO_NC")!=null){
                        sb.append(". Con Cargo ".concat(res.get(0).get("FOLIO_NC").toString()));
                    }
                    if(res.get(0).containsKey("FOLIO_NE") && res.get(0).get("FOLIO_NE")!=null){
                        sb.append(". Con NotaEntrada ".concat(res.get(0).get("FOLIO_NE").toString()));
                    }
                }
                result.put("Mensaje",sb.toString());
            }
        }catch(Exception e){
            result.put("Error", true);
        }
        return result;
    }
    
    @Override
    public boolean updtEntregaTienda(EntregaTienda entrega){
        if(rutasDaoLyde.updtEntregaTienda(entrega))
            return rutasDaoLyde.insEntregaTiendaBit(entrega);
        else 
            return false;
    }
    
}
