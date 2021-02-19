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
import mx.com.api.route.beans.ConfigBean;
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
@Repository("rutasDao")
public class RutaDaoImpl implements RutaDao{
    @Autowired
    NamedParameterJdbcTemplate sccpConnection ;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;
    
    @Override
    public Integer getFolRut(int tipo, int almacen) {
        Integer folio;
        String sql = "select folnum \n" +
            "from info_cd.rplfol \n" +
            "where foltip = :tiporem \n" +
            "and whse = :emisor ";
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("tiporem",tipo);
            paramMap.put("emisor",almacen);
            folio=sccpConnection.queryForObject(sql, paramMap, Integer.class);
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
            "where (origen,destino,foldoc ) in ( :v_emi_rec_fol) \n" +
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
        String sql = "select  flemts, fleimp\n" +
            "from info_cd.fle150f \n" +
            "where flecdm = :v_emi\n" +
            "--and flemts = info_cd.pkg_catalogos_transp.obten_mts_pagar(v_emi, v_tda,vi_mts * 1.7 )\n" +
            "and flemts = :mtsPagar\n" +
            "and fletda = :v_tda\n" +
            "and flepro is null\n" +
            "and rownum = 1    ";
        Map<String,Double> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("v_emi",emisor);
            param.put("v_tda",destino);
            param.put("mtsPagar",mtsPagar);
            result=sccpConnection.queryForObject(sql, param, new RowMapper<Map<String,Double>>() {
                @Override
                public Map<String, Double> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Map<String, Double> r=new HashMap<>();
                    r.put("mtsPago",rs.getDouble("flemts"));
                    r.put("impPago",rs.getDouble("fleimp"));
                    return r;
                }
            });
        }catch(EmptyResultDataAccessException e){
            result.put("empty",0.0);
        }catch(Exception e){
            result.put("error",0.0);
        }
        return result;
    }

    @Override
    public Map<String, Double> getVolumenTarifa(Integer ori, String folrems) {
        Map<String,Object> result;
        Map<String,Double> fixed;
        Map<String,Object> param = new HashMap<>();
        try{
            SimpleJdbcCall call = new SimpleJdbcCall(sccpConnection.getJdbcTemplate());
            call.withSchemaName("INFO_CD");
            call.withCatalogName("EKT_GEN_RUTAS_PKG");
            call.withProcedureName("PR_VALIDA_VOLUMEN_TARIFAS");
            param.put("v_origen",ori);
            param.put("folios_rem",folrems);
            result = call.execute(param);
            fixed = new HashMap<>();
            if(result.isEmpty()){
                fixed.put("empty",0.0);
            }else{
                if(result.containsKey("VOLUMEN_TOT") && result.get("VOLUMEN_TOT")!=null)
                    fixed.put("volTot", Double.parseDouble(result.get("VOLUMEN_TOT").toString()));
                if(result.containsKey("KMSTOT") && result.get("KMSTOT")!=null)
                    fixed.put("kms", Double.parseDouble(result.get("KMSTOT").toString()));
                if(result.containsKey("IMPORTEMAX") && result.get("IMPORTEMAX")!=null)
                    fixed.put("impPago", Double.parseDouble(result.get("IMPORTEMAX").toString()));
                if(fixed.isEmpty())
                    fixed.put("empty", 0.0);
            }
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1190001, 11, ori, 0, 
                    folrems.substring(0, 75), 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            fixed = null;
        }
        return fixed;
    }

    @Override
    public Map<String, Double> getVolumen_Precio(Integer ori, Integer des, double mts, String folrems, double kms, double impMax) {
         Map<String,Object> result;
        Map<String,Double> fixed;
        Map<String,Object> param = new HashMap<>();
        try{
            /*SimpleJdbcCall call = new SimpleJdbcCall(sccpConnection.getJdbcTemplate());
            call.withSchemaName("INFO_CD");
            call.withCatalogName("EKT_GEN_RUTAS_PKG");
            call.withProcedureName("pr_calculaFormula");
            param.put("origen",ori);
            param.put("tienda",des);
            param.put("metrosTotal",mts);
            param.put("folios_par",folrems);
            param.put("v_kms",kms);
            param.put("v_importeMAX",impMax);
            result = call.execute(param);*/
            List<SqlParameter> params = Arrays.asList(
                    new SqlParameter("origen", Types.BIGINT),
                    new SqlParameter("tienda", Types.BIGINT),
                    new SqlParameter("metrosTotal", Types.BIGINT),
                    new SqlParameter("folios_par", Types.VARCHAR),
                    new SqlParameter("v_kms", Types.BIGINT),
                    new SqlParameter("v_importeMAX", Types.BIGINT),
                    new SqlOutParameter("volumenParcial", Types.BIGINT),
                    new SqlOutParameter("precioCalculado", Types.BIGINT)
            );
            result = sccpConnection.getJdbcTemplate().call(new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection con) throws SQLException {
                    CallableStatement call = con.prepareCall("{call info_cd.EKT_GEN_RUTAS_PKG.pr_calculaFormula(?,?,?,?,?,?,?,?)}");
                    call.setInt(1, ori);
                    call.setInt(2, des);
                    call.setDouble(3, mts);
                    call.setString(4, folrems);
                    call.setDouble(5, kms);
                    call.setDouble(6, impMax);
                    call.registerOutParameter(7, Types.BIGINT);
                    call.registerOutParameter(8, Types.BIGINT);
                    return call;
                }
            }, params);
            fixed = new HashMap<>();
            if(result.isEmpty()){
                fixed.put("empty",0.0);
            }else{
                if(result.containsKey("VOLUMENPARCIAL") && result.get("VOLUMENPARCIAL")!=null)
                    fixed.put("volPar", Double.parseDouble(result.get("VOLUMENPARCIAL").toString()));
                if(result.containsKey("volumenParcial") && result.get("volumenParcial")!=null)
                    fixed.put("volPar", Double.parseDouble(result.get("volumenParcial").toString()));
                if(result.containsKey("PRECIOCALCULADO") && result.get("PRECIOCALCULADO")!=null)
                    fixed.put("impPagar", Double.parseDouble(result.get("PRECIOCALCULADO").toString()));
                if(result.containsKey("precioCalculado") && result.get("precioCalculado")!=null)
                    fixed.put("impPagar", Double.parseDouble(result.get("precioCalculado").toString()));
                if(fixed.isEmpty())
                    fixed.put("empty", 0.0);
            }
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1190001, 11, ori, 0, 
                    folrems.substring(0, 75), 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            fixed = null;
        }
        return fixed;
    }

    @Override
    public Map<String, Double> getVolumen_Precio_Lyde(Integer ori, Integer des, double mts, String folrems, double kms, double impMax) {
        Map<String,Object> result;
        Map<String,Double> fixed;
        Map<String,Object> param = new HashMap<>();
        try{
            List<SqlParameter> params = Arrays.asList(
                    new SqlParameter("origen_", Types.BIGINT),
                    new SqlParameter("folios_rem", Types.VARCHAR),
                    new SqlOutParameter("error_", Types.BIGINT),
                    new SqlOutParameter("MSG", Types.VARCHAR),
                    new SqlOutParameter("volumen", Types.DOUBLE),
                    new SqlOutParameter("precioEquipos", Types.DOUBLE)
            );
            result = sccpConnection.getJdbcTemplate().call(new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection con) throws SQLException {
                    CallableStatement call = con.prepareCall("{call info_cd.EKT_GEN_RUTAS_PKG.pr_calculaFormulaLYDE(?,?,?,?,?,?)}");
                    call.setInt(1, ori);
                    call.setString(2, folrems);
                    call.registerOutParameter(3, Types.BIGINT);
                    call.registerOutParameter(4, Types.VARCHAR);
                    call.registerOutParameter(5, Types.DOUBLE);
                    call.registerOutParameter(6, Types.DOUBLE);
                    return call;
                }
            }, params);
            fixed=new HashMap<>();
            if(result.isEmpty()){
                fixed.put("empty",0.0);
                try{
                    logger.insertaError(1190001, 11, ori, 0, 
                        folrems.substring(0, 75), 0, 0, 
                        "", 0, 0, 
                        "info_cd.EKT_GEN_RUTAS_PKG.pr_calculaFormulaLYDE returned no values", 
                        getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
                }catch(Exception ex){
                }
            }else{
                if(result.containsKey("MSG") && result.get("MSG")!=null){
                    try{
                        logger.insertaError(1190001, 11, ori, 0, 
                            (folrems.length()>75?folrems.substring(0, 75):folrems), 0, 0, 
                            "", 0, 0, 
                            result.get("MSG").toString(), 
                            getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
                    }catch(Exception ex){
                        System.out.println("Error : " + result.get("MSG"));
                    }
                }else{
                    if(result.containsKey("volumen") && result.get("volumen")!=null)
                        fixed.put("volumen", Double.parseDouble(result.get("volumen").toString()));
                    if(result.containsKey("precioEquipos") && result.get("precioEquipos")!=null)
                        fixed.put("precioEquipos", Double.parseDouble(result.get("precioEquipos").toString()));
                }
                if(fixed.isEmpty())
                    fixed.put("empty", 0.0);
            }
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1190001, 11, ori, 0, 
                    folrems.substring(0, 75), 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            fixed = null;
        }
        return fixed;
    }

    @Override
    public double getMtsPagar(Integer emisor, Integer destino, double mtsEst, boolean min) {
        double mtsPagar=0;
        String sqlMin="select flemts\n" +
            "    from info_cd.fle150f\n" +
            "    where flecdm = :vi_origen\n" +
            "    and fletda = :vi_destino\n" +
            "    and (flemts - :vi_mts_sys) = (select max(flemts - :vi_mts_sys)\n" +
            "  from info_cd.fle150f\n" +
            "  where flecdm = :vi_origen\n" +
            "  and fletda = :vi_destino\n" +
            "  and flemts < :vi_mts_sys \n" +
            " )    \n" +
            "    and rownum = 1";
        String sqlMax="select flemts\n" +
            "    from info_cd.fle150f\n" +
            "    where flecdm = :vi_origen\n" +
            "    and fletda = :vi_destino\n" +
            "    and (flemts - :vi_mts_sys) = (select min(flemts - :vi_mts_sys)\n" +
            "            from info_cd.fle150f\n" +
            "            where flecdm = :vi_origen\n" +
            "            and flemts >= :vi_mts_sys  \n" +
            "          )\n" +
            "    and fletda = vi_destino\n" +
            "    and rownum = 1    ";
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("vi_origen",emisor);
            param.put("vi_destino",destino);
            param.put("vi_mts_sys",mtsEst);
            if(min)
                mtsPagar=sccpConnection.queryForObject(sqlMin, param, Double.class);
            else
                mtsPagar=sccpConnection.queryForObject(sqlMax, param, Double.class);
        }catch(EmptyResultDataAccessException e){
            sqlMin="select min(flemts)\n" +
            "        from info_cd.fle150f\n" +
            "        where flecdm = :vi_origen\n" +
            "        and fletda = :vi_destino";
            sqlMax="select max(flemts)\n" +
            "        from info_cd.fle150f\n" +
            "        where flecdm = :vi_origen\n" +
            "        and fletda = :vi_destino";
            if(min){
                mtsPagar=sccpConnection.queryForObject(sqlMin, param, Double.class);
                mtsPagar=(mtsPagar*-1);
            }else{
                mtsPagar=sccpConnection.queryForObject(sqlMax, param, Double.class);
                mtsPagar=(mtsPagar*-1);
            }
        }catch(Exception e){
            
        }
        return mtsPagar;
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
    
}
