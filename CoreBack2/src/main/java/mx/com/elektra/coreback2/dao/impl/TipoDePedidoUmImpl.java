/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.dao.mapper.DetalleSkusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoUmDao")
public class TipoDePedidoUmImpl implements TipoDePedidoDao{
    @Autowired
    private NamedParameterJdbcTemplate um ;

    @Override
    public boolean insertaContenidoCajaPorPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPedidoAlterno(Paquete paquete) {
        try{
            String sql = "select ce.FIPEDIDOID from SCCENEN.taceentregas ce\n" +
                "where ce.FIENTREGAID = :entregaid\n" +
                "and ce.FICENTROID = :centro";
            Map<String,Object> param=new HashMap<>();
            param.put("entregaid",paquete.getPedido());
            param.put("centro",paquete.getIdManh());
            return um.queryForObject(sql, param, String.class);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String getCpOrigen(Paquete paquete) {
        try{
            String sql = "select co.FCCODPOSTAL from SCCENEN.taceentregas ce\n" +
                "join SCCENEN.TACECENTROS co on co.FICENTROID = ce.FICENTROID\n" +
                "where ce.FIENTREGAID = :entregaid\n" +
                "and ce.FICENTROID = :centro";
            Map<String,Object> param=new HashMap<>();
            param.put("entregaid",paquete.getPedido());
            param.put("centro",paquete.getIdManh());
            return um.queryForObject(sql, param, String.class);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String getCpDestino(Paquete paquete) {
        try{
            String sql = "select cd.FICODPOSTAL from SCCENEN.taceentregas ce\n" +
                "join SCCENEN.TACECLIENTE cc on cc.FCCLIENTEID = ce.FCCLIENTEID and  ce.FIENTREGAID = cc.FIENTREGAID and ce.FICENTROID = cc.FICENTROID\n" +
                "join SCCENEN.TACEDIRECCIONES cd on cd.FCCLIENTEID = cc.FCCLIENTEID and cd.FICENTROID = cc.FICENTROID and cd.FIENTREGAID = cc.FIENTREGAID\n" +
                "where ce.FIENTREGAID = :entregaid\n" +
                "and ce.FICENTROID = :centro";
            Map<String,Object> param=new HashMap<>();
            param.put("entregaid",paquete.getPedido());
            param.put("centro",paquete.getIdManh());
            return um.queryForObject(sql, param, String.class);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkusRf(Paquete paquete, String esquema, List<String> lpns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(Paquete paquete, String esquema) {
        String sql = "select distinct cd.fiitemid id_sku, count(cd.fiitemid) cantidad,'' desc_sku, '' departamento, '' desc_departamento, '' subdepartamento, '' desc_subdepartamento, '' clase, '' subclase, '' desc_clase, '' desc_subclase, \n" +
            "cd.FILARGO largo, cd.FIALTO alto, cd.FIANCHO ancho, cd.PESO peso, 0 costo\n" +
            "from SCCENEN.taceentregas ce\n" +
            "join SCCENEN.TACEDETALLE cd on ce.FICENTROID = cd.FICENTROID and ce.FIENTREGAID = cd.FIENTREGAID\n" +
            "where ce.FIENTREGAID = :pedido\n" +
            "and ce.FICENTROID = :idManh\n"
                + "group by cd.fiitemid,cd.FILARGO , cd.FIALTO , cd.FIANCHO , cd.PESO ";
        List<DetalleSkus> result = null;
        Map<String,Object> param=new HashMap<>();
        try{
            param.put("pedido",paquete.getPedido());
            param.put("idManh",paquete.getIdManh());
            result=um.query(sql, param, new DetalleSkusMapper());
            return result;
        }catch(Exception e){
            return result;
        }
    }
    
    @Override
    public CajaRf getCajaRf(int idManh, int idCaja, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getVolumenUtilizadoCaja(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DimensionesQB getDimensionesPaquete(int idManh, String idLpn, String esquema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        String sql = "select case when count(*) = 0 then 1 else max(fpid)+1 end fpid from SCCENEN.corebackhdr";
        try{
            return um.queryForObject(sql, new HashMap<String, Object>(), String.class);
        }catch(Exception e){
            return "";
        }
    }
    
}
