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
@Repository("pedidoLydeDao")
public class TipoDePedidoLydeImpl implements TipoDePedidoDao{
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
    public String getCpDestino(Paquete paquete){
        
        String sql = " SELECT DISTINCT LPAD(TO_NUMBER(CP), 5, '0') CP "
                + " FROM INFO_CD.PED_CENT  "
                + " WHERE STORE_NBR = 9797 "
                + " AND WHSE = :idManh "
                + " AND CONTRAS = :pedido ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("pedido", paquete.getPedidoAlterno());
            
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
        String sql="select sum(nd.CANTIDAD) cantidad\n" +
            ", nd.SKU_ID ID_SKU, zi.IDESCR DESC_SKU\n" +
            ", zc.ZN1NCL DEPARTAMENTO, zc.ZN1CLAS DESC_DEPARTAMENTO\n" +
            ", zc.ZN2NCL SUBDEPARTAMENTO, zc.ZN2CLAS DESC_SUBDEPARTAMENTO\n" +
            ", zc.ZN3NCL CLASE, zc.ZN3CLAS DESC_CLASE\n" +
            ", zc.MATKL SUBCLASE, zc.WGBEZ DESC_SUBCLASE\n" +
            ", zi.BRGEW PESO, zi.BREIT*100 ANCHO, zi.LAENG*100 LARGO, zi.HOEHE*100 ALTO, zi.ZHCOST COSTO\n" +
            "from info_cd.notacargohdr nh\n" +
            "join info_cd.notacargodtl nd on nd.CD_ID=nh.CD_ID and nd.FOLIO=nh.FOLIO\n" +
            "join info_cd.z_invmst zi on nd.SKU_ID=zi.INUMBER\n" +
            "join info_cd.ZMCLAS_SAP zc on zc.MATKL=zi.MATKL\n" +
            "where nh.folio in (:pedido) and nh.cd_id = :idori\n" +
            "group by nd.SKU_ID,zi.IDESCR , zc.ZN3NCL , zc.ZN3CLAS , zc.MATKL , zc.WGBEZ , zc.ZN1CLAS , zc.ZN1CLAS ,\n" +
            "zc.ZN2NCL , zc.ZN2CLAS , zi.BRGEW , zi.BREIT , zi.LAENG , zi.HOEHE , zi.ZHCOST, zc.ZN1NCL ";
        //modify - check for real data source info
        HashMap<String, Object> param=new HashMap<String,Object>();
            param.put("pedido", pqt.getLpns());
            param.put("idori", pqt.getIdManh());
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
    public Double getVolumenUtilizadoCaja(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
