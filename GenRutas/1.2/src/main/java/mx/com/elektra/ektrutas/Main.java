/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dao.GeneralDao;
import mx.com.elektra.ektrutas.dao.GeneralDaoImpl;
import mx.com.elektra.ektrutas.dao.RemisionDao;
import mx.com.elektra.ektrutas.dao.RemisionDaoImpl;
import mx.com.elektra.ektrutas.dao.RutaDao;
import mx.com.elektra.ektrutas.dao.RutaDaoImpl;
import mx.com.elektra.ektrutas.dao.TiendaDao;
import mx.com.elektra.ektrutas.dao.TiendaDaoImpl;
import mx.com.elektra.ektrutas.dao.TransporteDao;
import mx.com.elektra.ektrutas.dao.TransporteDaoImpl;
import mx.com.elektra.ektrutas.dto.DetalleRem;
import mx.com.elektra.ektrutas.dto.Remision;
import mx.com.elektra.ektrutas.dto.Respuesta;
import mx.com.elektra.ektrutas.dto.SKU;
import mx.com.elektra.ektrutas.dto.Tienda;
import mx.com.elektra.ektrutas.dto.Transporte;
import mx.com.elektra.ektrutas.dto.Unidad;
import mx.com.elektra.ektrutas.dto.Usuario;

/**
 *
 * @author nroblerol
 */
public class Main {
    public static void main(String[] args) {
        GenRutas g=new GenRutas();
        
        System.out.println("Test ");
        int origen=9971;
        int folioLyde=0;//46759;
        List<Integer> rem=new ArrayList<>();
        List<Remision> remtest=new ArrayList<>();
        List<String> skus=new ArrayList<>();
        Remision r=new Remision();
        DetalleRem dr;
        SKU sku;
        List<SKU> iSku;
        List<DetalleRem> detRem;
        r.setEmisor(6040);
        r.setRecept(100);
        r.setFolrem("1113624");
        remtest.add(r);
        int idTransporte=81012293;
        int idEco=1806;
        int tipRuta=0;
        int tienda=3167;
        Tienda tda;
        int mtvo=0;
        int isDist;
        Integer folEnv=16100;
        Usuario u;
        //rem.add(2150);
        /*rem.add(57820);
        rem.add(58007);
        rem.add(58214);
        rem.add(58502);*/
        //rem.add(74476);
        //rem.add(91501);
        //rem.add(77321);
        //rem.add(89555);
        rem.add(422688);
        rem.add(84903);
        rem.add(79293);
        skus.add("840703");
        Transporte trns;
        List<Transporte> lTrans;
        Unidad uni;
        List<Unidad> lUni;
        double test=9898121.989000988;
        //g.getFolRutLyde( origen,  folioLyde,  rem,  idTransporte, idEco, mtvo, "chec", "estib");
        System.out.println("Resultado :"+g.getSysdate());
        DecimalFormat df2 = new DecimalFormat("#.00");
        df2.setRoundingMode(RoundingMode.UP);
        //RutaDao test=new RutaDaoImpl();
        //double d = test.;
        //String s = test.getTransporteDisponibilidad(6040, 929292, 82828, "", 8);
        //u=test.getInfoUsuario(2250);
        //iSku=test.getSkuInfo(skus);
        //int i = test.getTiempoEco(6040);
        //lTrans = test.getTransportes(6040, null);
        //lUni = test.getUnidades(6040, null, "");
        //tda = test.getInfoTienda(100);
        //detRem=test.getDetalleRemision(6040, 100, 1113624);
        //test.registraVol(2234, "3379466");
        //r=test.getInfoRemision(6040, 100, 1113624);
        //List<String> rems = testRutaDao.;
        //Map<String,Double> testJdbcCall=test.getVolumenTarifa(2234, "3296895");
        //test.registraVol(2234, "3296895");
        //System.out.println("sSTR"+"8918,93849,".substring(0, "8918,93849,".length()-1));
        //Map<String,Double> testJdbcCall2=test.getVolumen_Precio(2234, 8765, testJdbcCall.get("volTot"), "3296895", testJdbcCall.get("kms"),testJdbcCall.get("impPago"));
        //System.out.println("Test :"+df2.format(test));
        Respuesta resp;
        //resp = g.getFolRutLyde(origen, rem, idTransporte, idEco, mtvo, "", "");
        resp = g.getFolRutLyde(origen, rem, idTransporte, 0, 0, "", "", false);
        //g.getDocument(origen, folEnv, folioLyde);
        System.out.println(resp.getCode());
        System.out.println(resp.getDocument());
        System.out.println(resp.getMsg());
        System.out.println(resp.getRuta());
        System.out.println(resp.getFolEnvio());
        //System.out.println("Result : "+d);
        //System.out.println("Result : "+i);
        //System.out.println("Result : "+s);
        
        
        //AEBALTAZARP 
        //Ana Elizabeth Baltazar Pinon
        //abaltazar@elektra.com.mx
        //AACEVESL    
        //Adolfo Aceves Lopez
        //adolfo.aceves@elektra.com.mx
    }
}
