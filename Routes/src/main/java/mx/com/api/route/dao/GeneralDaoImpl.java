/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import mx.com.api.route.beans.Almacen;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.User;
import mx.com.api.route.beans.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("generalDao")
public class GeneralDaoImpl implements GeneralDao{
    @Autowired
    NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;
    @Autowired
    private AtomicLong idRequest;

    @Override
    public String getRequestCount() {
        String sql = "select nvl(max(ref_field_1),0) from info_cd.paq_log_errores";
        try{
            String idReq=sccpConnection.queryForObject(sql, new HashMap<String, Object>(), String.class);
        }catch(DataAccessException e){
            
        }
        return "0";
    }

    @Override
    public List<SKU> getSkuInfo(List<String> sku) {
        String sql = "select zi.inumber, zi.maktx DESC_SKU, zc.ZN3NCL DEPARTAMENTO, zc.ZN3CLAS DESC_DEPARTAMENTO, zc.MATKL SUBDEPARTAMENTO, zc.WGBEZ DESC_SUBDEPARTAMENTO, zc.ZN1NCL CLASE, zc.ZN1CLAS DESC_CLASE,\n" +
            "zc.ZN2NCL SUBCLASE, zc.ZN2CLAS DESC_SUBCLASE, zi.BRGEW PESO, zi.BREIT*100 ANCHO, zi.LAENG*100 LARGO, zi.HOEHE*100 ALTO, zi.ZHCOST COSTO, (zi.BREIT*100) * (zi.LAENG*100) * (zi.HOEHE*100) VOLUMEN\n" +
            "from info_Cd.z_invmst zi\n" +
            "join info_cd.ZMCLAS_SAP zc on zc.MATKL=zi.MATKL\n" +
            "where inumber in (:skus)";
        List<SKU> result;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("skus",sku);
            result = sccpConnection.query(sql, param, new RowMapper<SKU>() {
                @Override
                public SKU mapRow(ResultSet rs, int rowNum) throws SQLException {
                    SKU s = new SKU();
                    s.setAlto(rs.getDouble("ALTO"));
                    s.setAncho(rs.getDouble("ANCHO"));
                    s.setPeso(rs.getDouble("PESO"));
                    s.setLargo(rs.getDouble("LARGO"));
                    s.setCosto(rs.getDouble("COSTO"));
                    s.setVolumen(rs.getDouble("VOLUMEN"));
                    s.setSku(rs.getString("INUMBER"));
                    s.setDesc(rs.getString("DESC_SKU"));
                    s.setDept(rs.getString("DESC_DEPARTAMENTO"));
                    s.setSubDepto(rs.getString("DESC_SUBDEPARTAMENTO"));
                    s.setClase(rs.getString("DESC_CLASE"));
                    s.setSubClase(rs.getString("DESC_SUBCLASE"));
                    s.setIdClase(rs.getString("CLASE"));
                    s.setIdDepto(rs.getString("DEPARTAMENTO"));
                    s.setIdSubClase(rs.getString("SUBCLASE"));
                    s.setIdSubDepto(rs.getString("SUBDEPARTAMENTO"));
                    s.setMatkl(rs.getString("SUBDEPARTAMENTO"));
                    return s;
                }
            });
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1180003, 11, 0, 0, "", 0, 0, "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");//, idRequest.toString(), "","");
            }catch(Exception ex){}
            result = null;
        }
        return result;
    }

    @Override
    public Integer getIdUsuario(String usuario) {
        String sql = "SELECT id_usuario\n" +
            "   FROM INFO_CD.USUARIOS_PORTAL_IAS\n" +
            "  WHERE 1 = 1 \n" +
            "    AND USUARIO = :usuario";
        Map<String,Object> param=new HashMap<>();
        Integer idUser;
        try{
            param.put("usuario",usuario);
            idUser=sccpConnection.queryForObject(sql, param, Integer.class);
        }catch(EmptyResultDataAccessException e){
            idUser=0;
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1120001, 11, 0, 0, "", 0, 0, "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), usuario);//, idRequest.toString(), "","");
            }catch(Exception ex){}
            idUser = null;
        }
        return idUser;
    }

    @Override
    public Usuario getInfoUsuario(Integer user) {
        String sql = "SELECT USUARIO,PASS_WORD,NOMBRE,EMAIL,CLAVE_CD,ID_ROL,STATUS \n" +
            "FROM info_cd.usuarios_portal_ias\n" +
            "WHERE id_usuario = :v_usuario";
        Usuario u;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("v_usuario",user);
            u=sccpConnection.queryForObject(sql, param, new RowMapper<Usuario>() {
                @Override
                public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Usuario u=new Usuario();
                    u.setCLAVE_CD(rs.getString("CLAVE_CD"));
                    u.setEMAIL(rs.getString("EMAIL"));
                    u.setID_ROL(rs.getString("ID_ROL"));
                    u.setNOMBRE(rs.getString("NOMBRE"));
                    u.setPASS_WORD(rs.getString("PASS_WORD"));
                    u.setSTATUS(rs.getString("STATUS"));
                    u.setUSUARIO(rs.getString("USUARIO"));
                    return u;
                }
            });
        }catch(EmptyResultDataAccessException e){
            u=new Usuario();
            u.setUSUARIO("ERROR");
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1120001, 11, 0, 0, "", 0, 0, "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), user+"");//, idRequest.toString(), "","");
            }catch(Exception ex){}
            u = null;
        }
        return u;
    }

    @Override
    public String getCeCo(boolean isDist, Integer ori, Integer des, String aplicacion, String vChar, boolean tda) {
        String ceco="";
        String sql = "";
        if(ori!=null){
            if(isDist){
                sql="SELECT valornum\n" +
                    "FROM info_cd.param_gen_rutas\n" +
                    "WHERE aplicacion = :aplic \n" +
                    "AND valorchar = :valchar \n" +
                    "AND ROWNUM = 1";
            }else{
                sql="select stbact\n" +
                    "from info_cd.tblstr\n" +
                    "where strnum = :v_emi\n" +
                    "and rownum = 1";
            }
        }
        if(des!=null){
            if(tda){
                sql = "select tdcce\n" +
                    "from info_cd.tblcc\n" +
                    "where tnume = :v_tda\n" +
                    "and rownum = 1";
            }else{
                ceco = "182011090";
            }
        }
        Map<String,Object> param = new HashMap<>();
        if(ceco.equals("")){
            param.put("aplic",aplicacion);
            param.put("valchar",vChar);
            param.put("v_emi",ori);
            param.put("v_tda",des);
            try{
                ceco=sccpConnection.queryForObject(sql, param, String.class);
            }catch(EmptyResultDataAccessException e){
                ceco="0";
            }catch(Exception e){
                if(configuration.isWriteActions())
                    System.out.println("ERROR : "+e.getMessage());
                try{
                    logger.insertaError(1110001, 11, 0, 0, "", 0, 0, "", 0, 0, 
                        e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");//, idRequest.toString(), "","");
                }catch(Exception ex){
                }
                ceco = null;
            }
        }
        return ceco;
    }
    
    @Override
    public String getSysdate(){
        String sql = "select sysdate from dual";
        try{
            return sccpConnection.queryForObject(sql, new HashMap<String, Object>(), String.class);
        }catch(Exception e){
            return "Error";
        }
    }
    
    @Override
    public Almacen getInfoAlmn(Integer idAlm) {
        String sql="select almmn,almjd,desjd from info_Cd.e3altwhs where \n" +
            "(almjd = :idOri or almmn = :idOri)";
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("idOri",idAlm);
            return sccpConnection.queryForObject(sql, paramMap, new RowMapper<Almacen>() {
                @Override
                public Almacen mapRow(ResultSet rs, int i) throws SQLException {
                   Almacen alm=new Almacen();
                   alm.setIdManh(rs.getInt("ALMMN"));
                   alm.setIdSap(rs.getInt("ALMJD"));
                   alm.setDesc(rs.getString("DESJD"));
                   return alm;
                }
            });
        }catch(Exception e){
            return null;
        }
    }
    
    @Override
    public User findByUsername(String user){
        User use=new User();
        String sql="select id_usuario,password from info_Cd.ektd_usuarios where \n" +
            "id_usuario = :usernam ";
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("usernam",user);
            return sccpConnection.queryForObject(sql, paramMap, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int i) throws SQLException {
                   User alm=new User();
                   alm.setUsername(rs.getString("id_usuario"));
                   alm.setPassword(rs.getString("password"));
                   return alm;
                }
            });
        }catch(Exception e){ 
            return null;
        }
    }
    
    @Override
    public boolean saveByUsername(User user){
        User use=new User();
        String sql="insert into info_Cd.ektd_usuarios (id_usuario,password,fecha_alta,almacen,perfil) values \n" +
            "(:usernam,:auth2,sysdate,9971,1)";
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("usernam",user.getUsername());
            paramMap.put("auth2",user.getPassword());
            return sccpConnection.update(sql, paramMap)>0;
        }catch(Exception e){
            return false;
        }
    }
}
