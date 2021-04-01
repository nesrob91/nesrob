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
@Repository("pedidoMkpDao")
public class TipoDePedidoMkpImpl implements TipoDePedidoDao{
    @Autowired
    private NamedParameterJdbcTemplate scpp ;

    @Override
    public boolean insertaContenidoCajaPorPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPedidoAlterno(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCpOrigen(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCpDestino(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(Paquete pqt, String string) {
        String sql="select count(pd.ID_SKU) CANTIDAD, pd.ID_SKU, '' DESC_SKU, '' DEPARTAMENTO, '' DESC_DEPARTAMENTO, '' SUBDEPARTAMENTO, '' DESC_SUBDEPARTAMENTO, '' CLASE, '' DESC_CLASE,\n" +
            "'' SUBCLASE, '' DESC_SUBCLASE, '' PESO, '' LARGO, '' ANCHO, '' ALTO, 0 COSTO\n" +
            "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
            "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
            "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
            "join info_cd.ecom_cat_contenedor cc on cc.PKIDCONTENEDOR = ch.FKIDCONTENEDOR and cc.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO\n" +
            "where pd.ID_PEDIDO = :pedido\n" +
            "and ch.ID_MANH = :idori\n" +
            "and cd.FKIDCAJAHDR = :idcaja\n" +
            "and pd.ID_TIPO_PEDIDO = :tipope\n" +
            "group by pd.ID_SKU";
        //modify - check for sap info
        HashMap<String, Object> param=new HashMap<String,Object>();
            param.put("pedido", pqt.getPedidoAlterno());
            param.put("idori", pqt.getIdManh());
            param.put("idcaja", pqt.getIdCaja());
            param.put("tipope", pqt.getIdTipoPedido());
        try{
            return scpp.query(sql, param, new DetalleSkusMapper());
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<DetalleSkus> getDetalleSkusRf(Paquete paquete, String esquema, List<String> lpns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public CajaRf getCajaRf(int idManh, int idCaja, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Double getVolumenUtilizadoCaja(Paquete paquete){
        
        String sql = " SELECT VOLUMENUTILIZADO "
                + " FROM INFO_CD.ECOM_CAJA_HDR "
                + " WHERE ID_TIPO_PEDIDO = :idTipoPedido "
                + " AND ID_MANH = :idManh "
                + " AND PKIDCAJAHDR = :idCaja ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCaja", paquete.getIdCaja());
            
            return scpp.queryForObject(sql, parametros, Double.class);
        } catch (Exception ex) {
            return 0.0;
        }
    }

    @Override
    public DimensionesQB getDimensionesPaquete(int idManh, String idLpn, String esquema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
