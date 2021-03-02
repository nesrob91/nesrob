/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dto.DetalleRem;
import mx.com.elektra.ektrutas.dto.Remision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("remisionDao")
public class RemisionDaoImpl implements RemisionDao{
    NamedParameterJdbcTemplate sccp=new DataSources().namedTemplate2010();
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private boolean DEBUGGER;
    
    @Override
    public Remision getInfoRemision(Integer origen, Integer destino, Integer rem) {
        String sql = "select CANAL,TIPOPE,EMISOR,RECEPT,FOLREM,FOLREF,FECEMI,FECPEN,FECRUT,FECART,FECING,FECREN,STSENV,FECENV,STSCON,FECCON,TOTDET,STSREG,FLAG \n" +
            "from info_cd.remmqh \n" +
            "where 1=1\n" +
            "and emisor = :emisor \n" +
            (destino!=null && destino != 0?"and recept = :recept\n":"") +
            "and folrem = :folrem" ;
        Remision res;
        Map<String, Object> param=new HashMap<>();
        try{
            param.put("emisor",origen);
            param.put("recept",destino);
            param.put("folrem",rem);
            res=sccp.queryForObject(sql, param, new RowMapper<Remision>(){
                @Override
                public Remision mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Remision r=new Remision();
                    r.setEmisor(rs.getInt("EMISOR"));
                    r.setFlag(rs.getString("FLAG"));
                    r.setFolrem(rs.getString("FOLREM"));
                    r.setRecept(rs.getInt("RECEPT"));
                    r.setTipo(rs.getInt("TIPOPE"));
                    r.setCanal(rs.getInt("CANAL"));
                    r.setFecart(rs.getString("FECART"));
                    r.setFecconf(rs.getString("FECCON"));
                    r.setFecemi(rs.getString("FECEMI"));
                    r.setFecing(rs.getString("FECING"));
                    r.setFecpen(rs.getString("FECPEN"));
                    r.setFecrut(rs.getString("FECRUT"));
                    r.setFecren(rs.getString("FECREN"));
                    r.setFolref(rs.getString("FOLREF"));
                    r.setFecenv(rs.getString("FECENV"));
                    r.setTotdet(rs.getInt("TOTDET"));
                    r.setStstenv(rs.getInt("STSENV"));
                    r.setStscon(rs.getInt("STSCON"));
                    r.setStsreg(rs.getInt("STSREG"));
                    return r;
                }
            });
        }catch(Exception e){
            if(DEBUGGER)
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1130001, 11, origen, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            res=null;
        }
        return res; 
    }

    @Override
    public List<DetalleRem> getDetalleRemision(Integer origen, Integer destino, Integer rem) {
        String sql = "select TIPOPE,EMISOR,RECEPT,FOLREM,CODIGO,CANTID,NUMREN,NUMSER,NUMPED,NUMUBI,FLAG \n" +
            "from info_cd.remmqd_hist \n" +
            "where 1=1\n" +
            "and emisor = :emisor \n" +
            (destino!=null && destino != 0?"and recept = :recept\n":"") +
            "and folrem = :folrem" ;
        List<DetalleRem> list;
        Map<String, Object> param=new HashMap<>();
        try{
            param.put("emisor",origen);
            param.put("recept",destino);
            param.put("folrem",rem);
            list=sccp.query(sql, param, new RowMapper<DetalleRem>(){
                @Override
                public DetalleRem mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DetalleRem d=new DetalleRem();
                    d.setCant(rs.getInt("CANTID"));
                    d.setEmisor(rs.getInt("EMISOR"));
                    d.setFlag(rs.getString("FLAG"));
                    d.setFolrem(rs.getString("FOLREM"));
                    d.setNumPed(rs.getString("NUMPED"));
                    d.setNumRen(rs.getInt("NUMREN"));
                    d.setNumSer(rs.getString("NUMSER"));
                    d.setNumUbi(rs.getString("NUMUBI"));
                    d.setRecept(rs.getInt("RECEPT"));
                    d.setSku(rs.getString("CODIGO"));
                    d.setTipo(rs.getInt("TIPOPE"));
                    return d;
                }
            });
        }catch(Exception e){
            if(DEBUGGER)
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1130001, 11, origen, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
            list=null;
        }
        return list;
    }
    
}
