/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import com.elektra.quarterback.beans.CarrierQB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import mx.com.api.trknbr.beans.Almacen;
import mx.com.api.trknbr.beans.User;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
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
    private NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private NamedParameterJdbcTemplate wm18Connection;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean conf;
    
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
                   alm.setAuth(rs.getString("password"));
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
            paramMap.put("auth2",user.getAuth());
            return sccpConnection.update(sql, paramMap)>0;
        }catch(Exception e){
            return false;
        }
    }
    
    @Override
    public List<Map<String, Object>> getRemisionHdrInfo(List<String> rem, int cd) {
        List<Map<String, Object>> result;
        String sql = "select emisor,recept,folrem,stsreg from info_cd.remmqh "
                + "where folrem in (:folrem) and emisor = (select almjd from info_cd.e3altwhs where almmn = :almmn)";
        HashMap<String, Object> param=new HashMap<String,Object>();
        try{
            param.put("folrem", rem);
            param.put("almmn", cd);
            result = sccpConnection.queryForList(sql, param);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , cd
                    , null
                    , ""
                    , 0
                    , 0
                    , null
                    , 0
                    , 0
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            result = null;
        }
        return result;
    }

    @Override
    public Integer getIdSap(Integer idManh) {
        String sql="select almjd from info_cd.e3altwhs where almmn = :idOri";
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("idOri",idManh);
            return sccpConnection.queryForObject(sql, paramMap, Integer.class);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("ERROR : "+e.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idManh
                    , null
                    , ""
                    , 0
                    , 0
                    , null
                    , 0
                    , 0
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            return 0;
        }
    }
    
    @Override
    public List<String> getRemisionWithRoute(List<String> nc, int cd) {
        String sql="select foldoc from info_cd.tranrut where origen = :idOri and foldoc in (:rems) and status not like 'C'";
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("idOri",cd);
            paramMap.put("rems",nc);
            return sccpConnection.queryForList(sql, paramMap, String.class);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("ERROR : "+e.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , cd
                    , null
                    , nc.get(0)
                    , 0
                    , 0
                    , null
                    , 0
                    , 0
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            return null;
        }
    }
    
    @Override
    public CarrierQB getCarrier(String codCarrier, int idCanal, int tipPed, boolean active){
        String sql = " SELECT c.COD_CARRIER, c.DESC_CARRIER, c.ID_CARRIER \n" +
            "FROM INFO_CD.CE_CAT_CARRIERS c\n" +
            "join INFO_CD.PAQ_REL_CARRIER_TIPPED ct on c.ID_CARRIER=ct.ID_CARRIER\n" +
            "WHERE 1=1 \n"
                + (active ? "and c.FLG_ACTIVO = 1 \n" : "")+
            "AND c.ID_TIPO = 1 \n" +
            "and ct.ID_TIPO_PEDIDO = :tipped \n" +
            " and c.COD_CARRIER = :cod " ;
        if(tipPed == 0){
            sql = " SELECT c.COD_CARRIER, c.DESC_CARRIER, c.ID_CARRIER \n" + "FROM INFO_CD.CE_CAT_CARRIERS c\n" + 
                    "WHERE 1=1 \n"
                    + (active ? "and c.FLG_ACTIVO = 1 \n" : "")+
                    "AND c.ID_TIPO = 1 \n" +
                    " and c.COD_CARRIER = :cod " ;
        }
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCanal", idCanal);
            parametros.put("tipped", tipPed);
            parametros.put("cod", codCarrier);

            return sccpConnection.queryForObject(sql, parametros, new RowMapper<CarrierQB>() {
                @Override
                public CarrierQB mapRow(ResultSet rs, int rowNum) throws SQLException {
                    CarrierQB c = new CarrierQB();
                    c.setIdCarrier(rs.getInt("ID_CARRIER"));
                    c.setDesdCarrier(rs.getString("DESC_CARRIER"));
                    c.setCodCarrier(rs.getString("COD_CARRIER"));
                    return c;
                }
            });
        } catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("ERROR : "+ex.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , 0
                    , null
                    , codCarrier
                    , 0
                    , 0
                    , null
                    , 0
                    , tipPed
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            return null;
        }
    }
    
    @Override
    public int getIdCarrierByCodCarrier(int idCanal, String codCarrier){
        String sql = " SELECT ID_CARRIER "
                + " FROM INFO_CD.CE_CAT_CARRIERS "
                + " WHERE ID_TIPO = :idCanal "
                + " AND COD_CARRIER = :codCarrier ";
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
        
            parametros.put("idCanal", idCanal);
            parametros.put("codCarrier", codCarrier);
            
            return sccpConnection.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1020007
                    , 10
                    , 0
                    , null
                    , codCarrier
                    , 0
                    , 0
                    , null
                    , idCanal
                    , 0
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return 0;
        } 
    }
    
    @Override
    public String getOrderType(int idManh, String idLpn){
        String sql = " SELECT O.ORDER_TYPE "
                + " FROM WMECOM18DM.ORDERS O "
                + " JOIN WMECOM18DM.LPN L "
                + " ON L.TC_ORDER_ID = O.TC_ORDER_ID "
                + " AND L.C_FACILITY_ALIAS_ID = O.O_FACILITY_ALIAS_ID "
                + " AND L.TC_LPN_ID = :idLpn "
                + " AND O.O_FACILITY_ALIAS_ID = :idManh " ;
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        
        try {

        parametros.put("idLpn", idLpn);
        parametros.put("idManh", idManh);

        return wm18Connection.queryForObject(sql, parametros, String.class);

        } catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idManh
                    , null
                    , idLpn
                    , 0
                    , null
                    , null
                    , 0
                    , 0
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            return null;
        }
    }
    
    @Override
    public int getIdTipoPedidoByOrderType(String orderType){
        String sql = " SELECT ID_TIPO_PEDIDO "
                + " FROM INFO_CD.CE_CAT_TIPO_PEDIDO "
                + " WHERE REF_FIELD_1 = :orderType "
            ;
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
        
            parametros.put("orderType", orderType);
            
            return sccpConnection.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , 0
                    , null
                    , orderType
                    , 0
                    , 0
                    , null
                    , 0
                    , 0
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return 0;
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
}
