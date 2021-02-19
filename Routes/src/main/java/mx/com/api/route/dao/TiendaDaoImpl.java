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
import mx.com.api.route.beans.ConfigBean;
import mx.com.api.route.beans.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("tiendaDao")
public class TiendaDaoImpl implements TiendaDao{
    @Autowired
    NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;

    @Override
    public Tienda getInfoTienda(int tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer isDistItk(List<Integer> tienda) {
        Integer isDist;
        String sql = "select count(*)\n" +
            "from info_cd.zmtiendas\n" +
            "where zstrnum in (:tiendas)\n" +
            "and (zstrtyp ='W' or\n" +
            "name1 like '%ITK%' or\n" +
            "UPPER(name1) like '%ITALIKA%' or\n" +
            "UPPER(name1) like '%DISTRIBUIDOR%' or\n" +
            "zstrnum in (9797,9398) or\n" +
            "UPPER(name1) like '%DSI%' \n" +
            ")\n" +
            "and rownum = 1";
        Map<String, Object> paramMap=new HashMap<>();
        try{
            paramMap.put("tiendas",tienda);
            isDist=sccpConnection.queryForObject(sql, paramMap, Integer.class);
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1140001, 11, 0, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            return null;
        }
        return isDist;
    }

    @Override
    public Integer isCD(Integer tienda) {
        String sql = "SELECT count(*)\n" +
            "--into v_es_cd\n" +
            "FROM INFO_CD.zmtiendas \n" +
            "WHERE zSTRNUM = :v_tda\n" +
            "AND zstrtyp='W' ";
        Map<String, Object> paramMap=new HashMap<>();
        Integer isCd;
        try{
            paramMap.put("v_tda",tienda);
            isCd=sccpConnection.queryForObject(sql, paramMap, Integer.class);
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, tienda, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            return null;
        }
        return isCd;
    }
    
    @Override
    public String getPaisTda(Integer tda){
        String sql="select country\n" +
            "    from info_cd.zmtiendas\n" +
            "    where zstrnum = :vi_origen";
        String pais="";
        Map<String, Object> paramMap=new HashMap<>();
        try{
            paramMap.put("vi_origen",tda);
            pais=sccpConnection.queryForObject(sql, paramMap, String.class);
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110001, 11, tda, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            pais = null;
        }
        return pais;
    }
}
