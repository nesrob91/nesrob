/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("transportDao")
public class TransporteDaoImpl implements TransporteDao{
    @Autowired
    NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;
    
    @Override
    public List<Transporte> getTransportes(Integer almacen, Integer transporte) {
        List<Transporte> list;
        String sql="select distinct trapro|| ' - ' ||tralin nom,tralin ,trapro, trarzo\n" +
            "from info_cd.uni150f, info_cd.tra150f\n" +
            "where unialm=to_char(:v_emisor)\n" +
                (transporte!=null && transporte!=0?"and trapro = :transporte \n":"") +
            "and unipro = trapro \n"
                + "order by trapro";
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("v_emisor",almacen);
            paramMap.put("transporte",transporte);
            list=sccpConnection.query(sql, paramMap, new RowMapper<Transporte>(){
                @Override
                public Transporte mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Transporte t=new Transporte();
                    t.setIdTransporte(rs.getInt("TRAPRO"));
                    t.setDescLIN(rs.getString("TRALIN"));
                    t.setDescRZO(rs.getString ("TRARZO"));
                    return t;
                }
            });
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1150001, 11, almacen, 0, 
                    ""+transporte, 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            list=null;
        }
        return list;
    }

    @Override
    public String getTransporteDisponibilidad(Integer almacen, Integer proveedor, Integer eco, String placa, Integer tiempoEco) {
        String sql = "select 'OCUPADO' disponible\n" +
            "from info_cd.ctlflt\n" +
            "where --fttdao = :vi_cd and GLS 20150828\n" +
            "ftprov = :vi_prov\n" +
            "and ftecon = :vi_eco\n" +
            "--and trim(ftref8) = trim(:vi_placa)\n" +
            "and ftfalt = :v_fechahoy\n" +
            "and fthora between :v_horaactual - :tiempoEco and :v_horaactual\n" +
            "and ftcans is null";
        String hora="select to_number(to_char(sysdate,'hh24miss')) from dual";
        String fecha="select to_number(to_char(sysdate,'rrrrmmdd')) from dual";
        String disp="";
        Integer fechaF;
        Integer horaF;
        Map<String,Object> paramMap=new HashMap<>();
        try{
            fechaF=sccpConnection.queryForObject(fecha, paramMap, Integer.class);
            horaF=sccpConnection.queryForObject(hora, paramMap, Integer.class);
            paramMap.put("vi_cd",almacen);
            paramMap.put("vi_prov",proveedor);
            paramMap.put("vi_eco",eco);
            paramMap.put("vi_placa",placa);
            paramMap.put("v_horaactual",horaF);
            paramMap.put("v_fechahoy",fechaF);
            paramMap.put("tiempoEco",tiempoEco);
            
            disp=sccpConnection.queryForObject(sql, paramMap, String.class);
        }catch(EmptyResultDataAccessException e){
            disp="";
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1150001, 11, almacen, 0, 
                    ""+proveedor, 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            disp="OCUPADO";
        }
        return disp;
    }

    @Override
    public Integer getTiempoEco(Integer almn) {
        String sql = "select valornum\n" +
            "from info_cd.param_gen_rutas\n" +
            "where aplicacion = 'ECO OCUPADO'\n" +
            "and descripcion = to_char(:vi_cd_id)";
        Integer tiempo;
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("vi_cd_id",almn);
            tiempo=sccpConnection.queryForObject(sql, paramMap, Integer.class);
        }catch(EmptyResultDataAccessException e){
            tiempo=99999999;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, almn, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            tiempo=null;
        }
        return tiempo;
    }

    @Override
    public List<Unidad> getUnidades(Integer almacen, Integer unidad, String disp) {
        String sql="select distinct unipro,unieco, unipla, unicho, unitipo, unimts, unists,\n" +
            "'ECO '||unieco||' - Metros: '||unimts||' - Placas: '||unipla||' - '||unitipo||' '||:disp UNIDES \n" +
            " from info_cd.uni150f, info_cd.tra150f \n" +
            " where unialm = to_char(:v_emisor) \n" +
                (unidad!=null&&unidad!=0?"and unieco = :unidad \n":"") +
            " and unipro = trapro \n"
                + "order by unipro,unieco ";
        List<Unidad> list;
        Map<String,Object> paramMap=new HashMap<>();
        try{
            paramMap.put("v_emisor",almacen);
            paramMap.put("unidad",unidad);
            paramMap.put("disp",disp);
            list=sccpConnection.query(sql, paramMap, new RowMapper<Unidad>(){
                @Override
                public Unidad mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Unidad u=new Unidad();
                    u.setIdTransporte(rs.getInt("UNIPRO"));
                    u.setEco(rs.getInt("UNIECO"));
                    u.setPlaca(rs.getString("UNIPLA"));
                    u.setChofer(rs.getString("UNICHO"));
                    u.setTipo(rs.getString("UNITIPO"));
                    u.setMts(rs.getInt("UNIMTS"));
                    u.setStat(rs.getString("UNISTS"));
                    return u;
                }
            });
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1150001, 11, almacen, 0, 
                    ""+unidad, 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            list=null;
        }
        return list;
    }

    @Override
    public boolean registraVol(Integer ori, String folrems) {
        boolean inserted=false;
        Map<String,Object> param = new HashMap<>();
        try{
            SimpleJdbcCall call = new SimpleJdbcCall(sccpConnection.getJdbcTemplate());
            call.withSchemaName("INFO_CD");
            call.withCatalogName("EKT_GEN_RUTAS_PKG");
            call.withProcedureName("pr_registra_vol");
            param.put("vi_origen",ori);
            param.put("vi_fol_rems",folrems);
            call.execute(param);
            inserted=true;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, ori, 0, 
                    folrems.substring(0, 75), 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return inserted;
    }
    
}
