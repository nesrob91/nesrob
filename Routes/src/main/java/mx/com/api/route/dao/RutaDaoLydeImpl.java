/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.EsquemaPago;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.beans.Remision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("rutasDaoLyde")
public class RutaDaoLydeImpl implements RutaDao{
    @Autowired
    NamedParameterJdbcTemplate sccpConnection ;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;
    
    @Override
    public Integer getFolRut(int tipo, int almacen) {
        Integer folio;
        String sqlRuta = "select info_cd.seq_fruta_".concat(almacen+". nextval from dual");
        String sqlEnvio="select info_cd.seq_fenvio_".concat(almacen+". nextval from dual");
        String sql = "select folnum \n" +
            "from info_cd.rplfol \n" +
            "where foltip = :tiporem \n" +
            "and whse = :emisor ";
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("tiporem",tipo);
            paramMap.put("emisor",almacen);
            switch(tipo){
                case 5:
                    folio=sccpConnection.queryForObject(sqlRuta, paramMap, Integer.class);
                    break;
                case 6:
                    folio=sccpConnection.queryForObject(sqlEnvio, paramMap, Integer.class);
                    break;
                default :
                    folio=sccpConnection.queryForObject(sql, paramMap, Integer.class);
            }
        }catch(Exception e){
            folio = null;
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1112001, 11, almacen, 0, 
                    "", 0, 0, 
                    "", 0, tipo, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return folio;
    }

    @Override
    public boolean updateFolRut(int tipo, int almacen, int folio) {
        boolean updated=false;
        String sql = "update info_cd.rplfol \n" +
            "set folnum = :folprev + 1 \n" +
            "where foltip = :tiporem \n" +
            "and whse = :emisor ";
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("tiporem",tipo);
            paramMap.put("folprev",folio);
            paramMap.put("emisor",almacen);
            updated=sccpConnection.update(sql, paramMap)>0;
        }catch(Exception e){
            updated = false;
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1112002, 11, almacen, 0, 
                    "", 0, 0, 
                    "", 0, tipo, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return updated;
    }

    @Override
    public Integer getDiasTol(int almacen) {
        String sql = "select valornum\n" +
            "from info_cd.param_gen_rutas\n" +
            "where aplicacion = 'RUTAS REMISIONES'\n" +
            "and valorchar = 'DT'\n" +
            "and status = 'A'\n" +
            "and descripcion = to_char(:vi_cd)\n" +
            "and rownum =1 ";
        Integer dias;
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("vi_cd",almacen);
            dias = sccpConnection.queryForObject(sql, paramMap, Integer.class);
        }catch(Exception e){
            dias = 1;
        }
        return dias;
    }

    @Override
    public boolean existsMDN(int mdn, int almacen) {
        String sql="select count(*)\n" +
            "    from info_cd.cat_mdn\n" +
            "    where tel = :vi_mdn\n" +
            "    and almacen = :v_emisor\n" +
            "    and rownum = 1";
        boolean exists=false;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_mdn",mdn);
            param.put("v_emisor",almacen);
            exists=sccpConnection.queryForObject(sql, param, Integer.class)>0;
        }catch(Exception e){
            
        }
        return exists;
    }

    @Override
    public List<Map<String,Object>> validateRemisionTranrut(List<Remision> rem) {
        List<String> rems;
        List<Map<String,Object>> result;
        String sql = "select distinct foldoc,folrut,status,ftfenv\n" +
                ",olpn,pkidcajahdr,fkidestatus,num_guia,id_estatus_guia\n" +
            "from info_cd.tranrut t\n" +
                "join info_cd.ctlflt c on fttdao=origen and fttdad = destino and ftruta=folrut \n"+
                "left join (\n" +
                "  select id_manh,pkidcajahdr,olpn,fkidestatus,num_guia,id_estatus_guia\n" +
                "  from info_cd.ecom_caja_dtl cd \n" +
                "  join info_cd.ecom_caja_hdr ch on pkidcajahdr=fkidcajahdr and fkidestatus = 2\n" +
                "  left join info_cd.ce_control_guias cg on pkidcajahdr=cg.ref_field_2 and id_estatus_guia = 10\n" +
                "  where ch.id_manh = 324\n" +
                ") g on g.olpn=to_char(foldoc)\n" +
            "where (origen,destino,foldoc ) in ( :v_emi_rec_fol ) \n" +
            "--and destino = tabla_datos(v_concat).receptor\n" +
            "--and foldoc = tabla_datos(v_concat).folrem\n" +
            "and (status <> 'C' and status <> 'T')\n" +
            "--and tipodoc in (1,3)\n" +
            "and tipodoc=3";
        Map<String,Object> param=new HashMap<>();
        List<String> group=new ArrayList<>();
        
        try{
            rem.forEach((r) -> {
                group.add("("+r.getEmisor()+","+r.getRecept()+","+r.getFolrem()+")");
            });
            param.put("v_emi_rec_fol",group);
            String r=sql.replace(":v_emi_rec_fol", group.toString());
            result=sccpConnection.queryForList(r.replace("[", "").replace("]", ""), param);
        }catch(EmptyResultDataAccessException e){
            rems=new ArrayList<>();
            result = new ArrayList<>();
        }catch(Exception e){
            rems=null;
            result = null;
        }
        return result;
    }

    @Override
    public double getFacorEstiba(String aplicacion) {
        String sql = "select valornum\n" +
            "--into v_regresa\n" +
            "from info_cd.param_gen_rutas\n" +
            "where aplicacion = :vi_nom_aplic\n" +
            "and valorchar = 'FE'\n" +
            "and sysdate between fecha_ini and fecha_fin\n" +
            "and status = 'A'\n" +
            "and rownum = 1";
        Map<String,Object> param=new HashMap<>();
        double fe = 0;
        try{
            param.put("vi_nom_aplic",aplicacion);
            fe=sccpConnection.queryForObject(sql, param, Double.class);
        }catch(EmptyResultDataAccessException e){
            fe=0;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110002, 11, 0, 0, 
                    aplicacion, 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            fe=0;
        }
        return fe;
    }
    
    @Override
    public double getMtsLibres(Integer almacen, Integer idTransporte, Integer idUnidad, double mts, String placa, Integer tiempoEco){
        String sql="select :vi_mts_eco - nvl(sum(ftcubi),0) mts\n" +
            "from info_cd.ctlflt\n" +
            "where fttdao = :v_emi\n" +
            "and ftprov = :vi_prov\n" +
            "and ftecon = :vi_eco\n" +
            "and ftref8 = :v_placas\n" +
            "and ftfalt = to_number(to_char(sysdate,'rrrrmmdd'))\n" +
            "and fthora between to_number(to_char(sysdate,'hh24miss')) - :tiempoEco and to_number(to_char(sysdate,'hh24miss'))\n" +
            "and ftcans is null";
        double mtsLibre=0;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("v_emi",almacen);
            param.put("vi_prov",idTransporte);
            param.put("vi_mts_eco",mts);
            param.put("vi_eco",idUnidad);
            param.put("v_placas",placa);
            param.put("tiempoEco",tiempoEco);
            mtsLibre=sccpConnection.queryForObject(sql, param, Double.class);
        }catch(Exception e){
            mtsLibre=-1;
        }
        return mtsLibre;
    }

    @Override
    public Map<String,Double> getMtsPago_Imp(Integer emisor, Integer destino, double mtsPagar) {
        
        return null;
    }

    @Override
    public Map<String, Double> getVolumenTarifa(Integer ori, String folrems) {
        
        return null;
    }

    @Override
    public Map<String, Double> getVolumen_Precio(Integer ori, Integer des, double mts, String folrems, double kms, double impMax) {
        
        return null;
    }

    @Override
    public Map<String, Double> getVolumen_Precio_Lyde(Integer ori, Integer des, double mts, String folrems, double kms, double impMax) {
        
        return null;
    }

    @Override
    public double getMtsPagar(Integer emisor, Integer destino, double mtsEst, boolean min) {
        
        return 0.0;
    }

    @Override
    public double getIva(Integer emisor, Integer tienda) {
        //String call="call {info_cd.EKT_IVA_FNC(?,?)}";
        SimpleJdbcCall call=new SimpleJdbcCall(sccpConnection.getJdbcTemplate().getDataSource());
        call.withFunctionName("EKT_IVA_FNC");
        call.withSchemaName("info_cd");
        Map<String,Object> param=new HashMap<>();
        double iva=0;
        try{
            param.put("ve_origen",emisor);
            param.put("ve_destino",tienda);
            String s=call.executeFunction(BigDecimal.class, param).toString();
            iva=new Double(s);
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1190001, 11, emisor, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            iva=-1;
        }
        return iva;
    }
    
    @Override
    public boolean isSinIva(Integer idTransporte){
        boolean isIva=false;
        String sql="select count(*)\n" +
            "from info_cd.param_gen_rutas\n" +
            "where aplicacion='SIN_IVA' and valornum= :vi_prov";
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_prov",idTransporte);
            isIva=sccpConnection.queryForObject(sql, param, Integer.class)>0;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1190001, 11, 0, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return isIva;
    }

    @Override
    public Map<String, Object> getKmsTR(Integer origen, Integer destino) {
        String sql = "select trim(fletip) fletip, flekms" +
                //update fletarifa sep2020
            //"select trim(fletip) fletip, flekms\n" +
            //"    from info_cd.fle150f\n" +
            "    from info_cd.fletarifa " +
            "    where flecdm = :vi_origen\n" +
            "    and fletda = :vi_destino\n" +
            //"    and flepro is null\n" +
            "    and rownum=1";
        Map<String, Object> kmsTR = new HashMap<>();
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_origen",origen);
            param.put("vi_destino",destino);
            kmsTR=sccpConnection.queryForObject(sql, param, new RowMapper<Map<String,Object>>(){
                @Override
                public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Map<String, Object> map=new HashMap<>();
                    map.put("locFor",rs.getString("FLETIP"));
                    map.put("kms",rs.getInt("FLEKMS"));
                    return map;
                }
                
            });
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, origen, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            kmsTR.put("error",0.0);
        }
        return kmsTR;
    }
    
    @Override
    public double getFactorDescuentoTransp(Integer origen){
        String sql="select valornum\n" +
            "  from info_cd.param_gen_rutas\n" +
            "  where aplicacion = 'DESCUENTO'\n" +
            "  and valornum2 = :vi_cd\n" +
            "  and status = 'A'\n" +
            "  and rownum = 1";
        Map<String,Object> param=new HashMap<>();
        double fd=0;
        try{
            param.put("vi_cd",origen);
            fd=sccpConnection.queryForObject(sql, param, Double.class);
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, origen, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return fd;
    }

    @Override
    public boolean insertCobroTransportistas(int tipoRuta, Integer origen, Integer destino, Integer idTransp, Integer folrut, double importe, double descuento) {
        String sql="insert into info_cd.ekt_cobro_transportistas (tipo_ruta,origen,destino,proveedor,folio_ruta,fecha,imp_bruto,imp_prctl)\n" +
            "values (:vi_tiporuta,:vi_origen,:vi_destino,:vi_prov,:v_folruta,to_number(to_char(sysdate,'rrrrmmdd')),:vi_importe,:v_descuento)";
        Map<String,Object> param=new HashMap<>();
        boolean insert=false;
        try{
            param.put("vi_tiporuta",tipoRuta);
            param.put("vi_origen",origen);
            param.put("vi_destino",destino);
            param.put("vi_prov",idTransp);
            param.put("v_folruta",folrut);
            param.put("vi_importe",importe);
            param.put("v_descuento",descuento);
            insert=sccpConnection.update(sql, param)>0;
        }catch(Exception e){
            
        }
        return insert;
    }
    
    @Override
    public boolean insertCtlimprut(Integer origen, Integer destino, Integer folrut, Integer idTransp, Integer idUni, String placa, String chofer,
    Integer pta, String usuario, double mtsPago, double impBruto, double iva, double subTot, double ret, double impNeto, String sec
    ){
        String sql = "insert into info_cd.ctlimprut(\n" +
"FTTDAO,FTTDAD,FOLRUT,FTPROV,NUMECO,PLACAS,NOMCHO,FTPUER,FTREF4,FTFALT,FTHORA,FTUALT,RPCHEC,RPESTI,RPENTR,RPMCCE,FTIMPB,FTIVA,FTSUBT,FTRET,FTIMPN,WOBRUT,RPSTAT,NUMSEC,FTREF1 \n" +
")values(\n" +
":vi_origen, :vi_destino,:v_folruta,:vi_prov,:vi_eco,substr(:vi_placa,1,7),substr(:vi_chof,1,30),:v_pta,null," +
"to_number(to_char(sysdate,'rrrrmmdd')), to_number(to_char(sysdate,'HHMMSS')), :vi_usuario, null, null, null,\n" +
":vi_mts_pag, nvl(:v_ftimpb,0),nvl(:v_ftiva,0),nvl(:v_ftsubt,0),nvl(:v_ftret,0),nvl(:v_ftimpn,0),null,\n" +
"'A', :vi_sec, null  )";
        boolean insert = false;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_origen",origen);
            param.put("vi_destino",destino);
            param.put("vi_prov",idTransp);
            param.put("v_folruta",folrut);
            param.put("vi_placa",placa);
            param.put("vi_chof",chofer);
            param.put("vi_eco",idUni);
            param.put("v_pta",pta);
            param.put("vi_usuario",usuario);
            param.put("vi_mts_pag",mtsPago);
            param.put("v_ftimpb",impBruto);
            param.put("v_ftiva",iva);
            param.put("v_ftsubt",subTot);
            param.put("v_ftret",ret);
            param.put("v_ftimpn",impNeto);
            param.put("vi_sec",sec);
            insert=sccpConnection.update(sql, param)>0;
        }catch(Exception e){
            insert = false;
        }
        return insert;
    }
    
    @Override
    public boolean insertCtlflt(String pais, Integer ola, Integer pta, Integer folrut, Integer origen, Integer destino, String cecoO,
    String cecoD, String locFor, Integer kms,  Integer idTransp, Integer idUni, double mts, Integer pzs, double costo, double mtsPago, double impBruto, 
    double iva, double subTot, double ret, double impNeto, String usuario, String ftcans, String ftfact, String placa, String obs, String sellos,
    String chofer, String sec, String tipoEco, Integer folenv,  double mtsUn, Integer mtvo,  Integer tipoRuta, Integer mdn, Integer ftfacd,
    Integer ftfoad, Integer ftfead, Integer ftfope, Integer ftfepe, Integer ftfoct, Integer ftfect, Integer ftfocp, Integer ftfecp, String checador,
    String estibador
    ){
        String sql="insert into info_cd.ctlflt(\n" +
"ftpais,fttope,ftola,ftpuer,ftruta,fttdao,ftccto,fttdad,ftcctd,fttdat,ftkms,ftprov,ftecon,ftmcce,ftpzas,ftcost,ftcubi, \n" +
"ftimpb,ftiva,ftsubt,ftret,ftimpn,ftfalt,ftualt,ftcans,ftfact,fthora,ftref8,ftobs2,ftsell,ftchof,ftsec,fttipo, ftfenv,\n" +
"ftmccs,ftmtvm,fttmerc,ftmdn,ftfacd,ftfoad,ftfead,ftfope,ftfepe,ftfoct,ftfect,ftfocp,ftfecp,ftchec,ftesti\n" +
" ) values(\n" +
" :v_pais, 3, :v_ola, :v_pta, :v_folruta, :vi_origen, :v_ccstorig, :vi_destino, :v_ccsttda, :v_locfor, :v_kms, :vi_prov, :vi_eco, :vi_mts, :v_totpzs, :v_costo,\n" +
" :vi_mts_pag, nvl(:v_ftimpb,0), nvl(:v_ftiva,0), nvl(:v_ftsubt,0), nvl(:v_ftret,0), nvl(:v_ftimpn,0), to_number(to_char(sysdate,'rrrrmmdd')), \n" +
":vi_usuario, :vi_ftcans, :vi_ftfact, to_number(to_char(sysdate,'HH24MISS')), :vi_placa, substr(:vi_obs,1,50), substr(:vi_sellos,1,30), substr(:vi_chof,1,30), \n" +
":vi_sec, substr(:vi_tipo_eco,1,1), :v_folenv, :vi_mts_sys, :vi_mtvo, :vi_truta, :v_mdn_aux, :v_ftfacd, :v_ftfoad, :v_ftfead, :v_ftfope,\n" +
" :v_ftfepe, :v_ftfoct, :v_ftfect, :v_ftfocp, :v_ftfecp, :vi_checador, :vi_estibador )";
        boolean insert = false;
        Map<String,Object> param=new HashMap<>();
        DecimalFormat df2 = new DecimalFormat("#.0000");
        try{
            df2.setRoundingMode(RoundingMode.UP);
            param.put("v_pais",pais);param.put("v_ola",ola);
            param.put("v_pta",pta);param.put("v_folruta",folrut);
            param.put("vi_origen",origen);param.put("v_ccstorig",cecoO);
            param.put("vi_destino",destino);param.put("v_ccsttda",cecoD);
            param.put("v_locfor",locFor);param.put("v_kms",kms);
            param.put("vi_prov",idTransp);param.put("vi_eco",idUni);
            param.put("vi_mts",df2.format(mtsUn));param.put("v_totpzs",pzs);
            param.put("v_costo",df2.format(costo));param.put("vi_mts_pag",df2.format(mtsPago));
            param.put("v_ftimpb",df2.format(impBruto));param.put("v_ftiva",iva);
            param.put("v_ftsubt",df2.format(subTot));param.put("v_ftret",ret);
            param.put("v_ftimpn",df2.format(impNeto));param.put("vi_usuario",usuario);
            param.put("vi_ftcans",ftcans);param.put("vi_ftfact",ftfact);
            param.put("vi_placa",placa);param.put("vi_obs",obs);
            param.put("vi_sellos",sellos);param.put("vi_chof",chofer);
            param.put("vi_sec",sec);param.put("vi_tipo_eco",tipoEco);
            param.put("v_folenv",folenv);param.put("vi_mts_sys",mtsUn);
            param.put("vi_mtvo",mtvo);param.put("vi_truta",tipoRuta);
            param.put("v_mdn_aux",mdn);param.put("v_ftfacd",ftfacd);
            param.put("v_ftfoad",ftfoad);param.put("v_ftfead",ftfead);
            param.put("v_ftfope",ftfope);param.put("v_ftfepe",ftfepe);
            param.put("v_ftfoct",ftfoct);param.put("v_ftfect",ftfect);
            param.put("v_ftfocp",ftfocp);param.put("v_ftfecp",ftfecp);
            param.put("vi_checador",checador);param.put("vi_estibador",estibador);
            insert=sccpConnection.update(sql, param)>0;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1113001, 11, origen, 0, 
                    folrut+"", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            insert = false;
        }
        return insert;
    }
    
    @Override
    public boolean insertCtlfltd(Integer origen, Integer destino, Integer folrut, Integer folrem){
        String sql="insert into info_cd.ctlfltd(FTTDAO,FTTDAD,FOLRUT,REMHOR)\n" +
            "values(:vi_origen,:vi_destino,:v_folruta,:cn_rems)";
        boolean insert = false;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_origen",origen);
            param.put("vi_destino",destino);
            param.put("v_folruta",folrut);
            param.put("cn_rems",folrem);
            insert=sccpConnection.update(sql, param)>0;
        }catch(Exception e){
            insert = false;
        }
        return insert;
    }
    
    @Override
    public boolean insertTranrut(Integer origen, Integer destino, Integer folrut, Integer folrem, Integer fecart){
        String sql="insert into info_cd.tranrut (origen,destino,folrut,foldoc,tipodoc,fecproc,fecconf,status,folcarga)"
                + "values(:vi_origen,:vi_destino,:v_folruta,:folrem,3,sysdate,null,'A',:fecart)";
        boolean insert = false;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_origen",origen);
            param.put("vi_destino",destino);
            param.put("v_folruta",folrut);
            param.put("folrem",folrem);
            param.put("fecart",fecart);
            insert=sccpConnection.update(sql, param)>0;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1113002, 11, origen, 0, 
                    folrut+"", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            insert = false;
        }
        return insert;
    }
    
    @Override
    public boolean cancelTranrut(Integer origen, List<String> rutas){
        String sql="update info_cd.tranrut set status = 'C' where origen = :origen and folrut in (:foldoc)";
        Map<String,Object> param=new HashMap<>();
        param.put("origen",origen);
        param.put("foldoc",rutas);
        return sccpConnection.update(sql, param)>0;
    }

    @Override
    public boolean cancelCtlflt(Integer origen, List<String> rutas) {
        String sql = "update info_cd.ctlflt set ftcans = 'C' where fttdao = :origen and ftruta in (:foldoc)  and fttope = 3";
        Map<String,Object> param=new HashMap<>();
        param.put("origen",origen);
        param.put("foldoc",rutas);
        return sccpConnection.update(sql, param)>0;
    }
    
    @Override
    public List<EsquemaPago> getConceptosPago(Integer origen, Integer destino, Integer proveedor){
        List<EsquemaPago> conceptos=new ArrayList<>();
        String sql = "select \n" +
            "--info guia base\n" +
            "cpd.origen,cpd.tienda destino,cpd.importe importe_guia_gase,proveedor,unidad_afecta,tipo_flete,moneda      \n" +
            "--info proveedor\n" +
            ",t.TRAPRO, t.TRARZO, t.TRACD\n" +
            "--info tipo contenido \n" +
            ",cpt.id_tipo tipo_guia,cpt.origen origen_tipo_guia,cpt.descripcion\n" +
            "--info clasificacion por tipo\n" +
            ",cpc.id_tipo tipo_clasf,cpc.origen origen_clasf,nvl(cpc.clasificacion,'-') clasificacion,cpc.nivel_clasificacion \n" +
            "--info nivel clasificacion\n" +
            ",cpnt.id_nivel,cpnt.descripcion desc_nivel_clasificacion \n" +
            "--info importe clasificacion x tipo_sku\n" +
            ",cps.id_tipo tipo_guia_sku,cps.origen origen_tipo_guia_sku,cps.destino destino_tipo_guia_sku,nvl(cps.IMPORTE,0) importe_sku,cps.ID_ACC flg_volumen\n" +
            "--info importe volumen (sim) (by origen- as of feb,2021)\n" +
            ",cpa.ID_TIPO_ACC,cpa.ORIGEN origen_tipo_accesorio,cpa.destino destino_tipo_accesorio,cpa.DESCRIPCION desc_accesorio,nvl(cpa.IMPORTE,0) importe_accesorio,cpa.VOLUMEN_MIN,cpa.VOLUMEN_MAX \n" +
            "--info importe zona extendida\n" +
            ",cpz.ORIGEN origen_ze,cpz.destino destino_ze,nvl(cpz.importe,0) importe_ze \n" +
            "--info importe sin cobertura\n" +
            ",cpn.ORIGEN origen_sc,cpn.destino destino_sc,cpn.VOL_BASE,nvl(cpn.importe_base,0) importe_sc, nvl(cpn.importe_extra,0) importe_sc_ex  \n" +
            "from info_cd.conceptos_pago_dtl cpd\n" +
            "left join info_cd.conceptos_pago_tipo cpt on cpd.UNIDAD_AFECTA=cpt.ID_TIPO and cpd.ORIGEN=cpt.ORIGEN and cpt.FLG_ACTIVE = 1\n" +
            "left join info_cd.conceptos_pago_clasf cpc on cpd.unidad_afecta=cpc.id_tipo and cpd.origen=cpc.origen and cpc.FLG_ACTIVE = 1\n" +
            "left join info_cd.conceptos_pago_nvl_tipo cpnt on cpc.NIVEL_CLASIFICACION = cpnt.ID_NIVEL and cpnt.FLG_ACTIVE = 1\n" +
            "left join info_cd.conceptos_pago_sku cps on to_char(cps.ID_TIPO) = cpd.UNIDAD_AFECTA and cpd.ORIGEN=cps.ORIGEN and cps.DESTINO = cpd.TIENDA and cps.FLG_ACTIVE = 1\n" +
            "left join info_cd.conceptos_pago_acc_tipo cpa on cpa.ID_TIPO_ACC = cps.ID_ACC and cpa.ORIGEN=cps.ORIGEN and cpa.destino=cps.destino and cpa.FLG_ACTIVE = 1\n" +
            "left join info_Cd.conceptos_pago_ze cpz on cpd.ORIGEN=cpz.ORIGEN and cpz.DESTINO = cpd.tienda and cpz.FLG_ACTIVE=1\n" +
            "left join info_Cd.conceptos_pago_sc cpn on cpd.ORIGEN=cpn.ORIGEN and cpn.DESTINO = cpd.tienda and cpn.FLG_ACTIVE = 1\n" +
            "left join info_cd.tra150f t on cpd.PROVEEDOR=t.TRAPRO\n" +
            "where 1=1\n" +
            "and cpd.status = 1\n" +
            "and cpd.ORIGEN = :origen and tienda = :destino--2185--9757--1135--100\n" +
            "--and cpd.proveedor = :proveedor";
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("origen",origen);
            param.put("destino",destino);
            param.put("proveedor",proveedor);
            conceptos = sccpConnection.query(sql, param, new RowMapper() {
                @Override
                public EsquemaPago mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EsquemaPago ep=new EsquemaPago();
                    ep.setAccesorioTipo(rs.getInt("FLG_VOLUMEN"));
                    ep.setClasificacion(rs.getString("CLASIFICACION"));
                    ep.setDescAccesorioTipo(rs.getString("DESC_ACCESORIO"));
                    ep.setDescTipoPago(rs.getString("DESCRIPCION"));
                    ep.setDescNivelClasf(rs.getString("DESC_NIVEL_CLASIFICACION"));
                    ep.setDescProveedor(rs.getString("TRARZO"));
                    ep.setDestino(rs.getInt("DESTINO"));
                    ep.setImporte(rs.getDouble("IMPORTE_GUIA_BASE"));
                    ep.setImporteAcc(rs.getDouble("IMPORTE_ACCESORIO"));
                    ep.setImporteSCBase(rs.getDouble("IMPORTE_SC"));
                    ep.setImporteClasf(rs.getDouble("IMPORTE_SKU"));
                    ep.setImporteSCExtra(rs.getDouble("IMPORTE_SC_EX"));
                    ep.setImporteZE(rs.getDouble("IMPORTE_ZE"));
                    ep.setMoneda(rs.getString("MONEDA"));
                    ep.setNivelClasificacion(rs.getInt("NIVEL_CLASIFICACION"));
                    ep.setOrigen(rs.getInt("ORIGEN"));
                    ep.setProveedor(rs.getString("IMPORTE_ACCESORIO"));
                    ep.setTipoPago(rs.getInt("TIPO_GUIA"));
                    ep.setVolumenSCBase(rs.getInt("VOL_BASE"));
                    ep.setVolumenMin(rs.getInt("VOLUMEN_MIN"));
                    ep.setVolumenMax(rs.getInt("VOLUMEN_MAX"));
                    return ep;
                }
            });
        }catch(Exception e){
            conceptos = null;
        }
        return conceptos;
    }
}
