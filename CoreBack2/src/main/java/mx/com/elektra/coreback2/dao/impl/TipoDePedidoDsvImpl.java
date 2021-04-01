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
import mx.com.elektra.coreback2.dao.mapper.ContenidoMapper;
import mx.com.elektra.coreback2.dao.mapper.DetalleSkusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoDsvDao")
public class TipoDePedidoDsvImpl implements TipoDePedidoDao{
    @Autowired
    private NamedParameterJdbcTemplate scpp ;

    @Override
    public boolean insertaContenidoCajaPorPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //modify check for info data source 
    @Override
    public String getPedidoAlterno(Paquete paquete){
        String sql = "select id_pedido from info_cd.ecom_ctr_pedidos_hdr ph \n"
                + " where ph.id_pedido = :pedido "
                + " and ph.ID_TIPO_PEDIDO = :tipped and id_origen = :origen and rownum < 2";
        //modify - check real column names
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", paquete.getPedidoAlterno());
            parametros.put("origen", paquete.getIdManh());
            parametros.put("tipped", paquete.getIdTipoPedido());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
    }
    @Override
    public String getCpOrigen(Paquete paquete){
        String sql = "select cp_origen from info_cd.ecom_ctr_pedidos_hdr ph \n"
                + " where ph.id_pedido = :pedido "
                + " and ph.ID_TIPO_PEDIDO = :tipped and id_origen = :origen and rownum < 2";
        
        //modify - check for real prefix-suffix
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", paquete.getPedidoAlterno());
            parametros.put("origen", paquete.getIdManh());
            parametros.put("tipped", paquete.getIdTipoPedido());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
    }
    @Override
    public String getCpDestino(Paquete paquete){
        String sql = "select LPAD(TO_NUMBER(cp_destino), 5, '0') CP_DESTINO from info_cd.ecom_ctr_pedidos_hdr ph \n"
                + " where ph.id_pedido = :pedido "
                + " and ph.ID_TIPO_PEDIDO = :tipped and id_origen = :origen and rownum < 2";
        //modify - check for real prefix-suffix
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", paquete.getPedidoAlterno());
            parametros.put("origen", paquete.getIdManh());
            parametros.put("tipped", paquete.getIdTipoPedido());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
    }
    
    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        String sql = " SELECT GD.ID_MANH "
                + " , GD.ID_SKU "
                + " , GD.CANTIDAD "
                + " , GD.ORDER_ID "
                + " , GD.ADN "
                + " , GD.ID_LPN "
                + " , GD.SO "
                + " , GD.NC"
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " AND GD.ID_LPN = CD.OLPN "
                + " AND CD.FKIDCAJAHDR  = GD.ID_CAJA "
                + " WHERE CH.FKIDESTATUS <> 5 "
                + " AND CH.PKIDCAJAHDR = :idCaja "
                + " AND CH.ID_MANH = :idManh "
                + " AND CH.ID_TIPO_PEDIDO = :idTipoPedido ";

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());

            return scpp.query(sql, parametros, new ContenidoMapper());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<DetalleSkus> getDetalleSkusRf(Paquete paquete, String esquema, List<String> lpns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(Paquete pqt, String string) {
        String sql="select SUM(pd.CANTIDAD) CANTIDAD" +
            ", pd.ID_SKU, zi.IDESCR DESC_SKU" +
            ", zc.ZN1NCL DEPARTAMENTO, zc.ZN1CLAS DESC_DEPARTAMENTO" +
            ", zc.ZN2NCL SUBDEPARTAMENTO, zc.ZN2CLAS DESC_SUBDEPARTAMENTO" +
            ", zc.ZN3NCL CLASE, zc.ZN3CLAS DESC_CLASE" +
            ", zc.MATKL SUBCLASE, zc.WGBEZ DESC_SUBCLASE" +
            ", zi.BRGEW PESO, zi.BREIT*100 ANCHO, zi.LAENG*100 LARGO, zi.HOEHE*100 ALTO, zi.ZHCOST COSTO\n" +
            "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
            "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
            "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
            "join info_cd.ecom_cat_contenedor cc on ch.FKIDCONTENEDOR = cc.PKIDCONTENEDOR \n" +
            "join info_cd.Z_INVMST zi on  pd.ID_SKU = zi.INUMBER\n" +
            "join info_cd.ZMCLAS_SAP zc on zc.MATKL=zi.MATKL\n" +
            "where pd.ID_PEDIDO = :pedido\n" +
            "and ch.ID_MANH = :idori\n" +
            "and cd.FKIDCAJAHDR = :idcaja\n" +
            "and pd.ID_TIPO_PEDIDO = :tipope\n" +
            "and pd.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO \n" +
            "group by pd.ID_SKU,zi.IDESCR , zc.ZN3NCL , zc.ZN3CLAS , zc.MATKL , zc.WGBEZ , zc.ZN1CLAS , zc.ZN1CLAS ,\n" +
            "zc.ZN2NCL , zc.ZN2CLAS , zi.BRGEW , zi.BREIT , zi.LAENG , zi.HOEHE , zi.ZHCOST, zc.ZN1NCL ";
        //modify - check for real data source info
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
    public CajaRf getCajaRf(int idManh, int idCaja, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DimensionesQB getDimensionesPaquete(int i, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getVolumenUtilizadoCaja(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
