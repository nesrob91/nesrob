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
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.dao.mappers.ContactoMapper;
import mx.com.api.trknbr.dao.mappers.DetalleSkusMapper;
import mx.com.api.trknbr.dao.mappers.GuiaRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoDaoDsv")
public class PedidoDaoDsv implements PedidoDao{
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public List<Map<String, Object>> getPedido(List<String> contenido, int idManh, String idLpn, int tipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn) {
        GuiaRequest gr;
        String sql="select pd.ID_PEDIDO PEDIDO,ch.ID_MANH,cd.FKIDCAJAHDR ID_CAJA, '' ID_LPN, ch.ID_TIPO, ch.ID_TIPO_PEDIDO, :idcarr ID_CARRIER, cc.ALTO, "
                    + "cc.ANCHO, cc.LARGO, sum(zi.BRGEW  * pd.CANTIDAD) PESO \n"
                    + "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
                "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
                "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
                "join info_cd.ecom_cat_contenedor cc on ch.FKIDCONTENEDOR = cc.PKIDCONTENEDOR \n" +
                " join info_cd.z_invmst zi on pd.ID_SKU = zi.INUMBER \n" +
                "where pd.ID_PEDIDO = :pedido\n" +
                "and ch.ID_MANH = :idori\n" +
                "and cd.FKIDCAJAHDR = :idcaja \n" +
                "and pd.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO \n" +
                "and pd.ID_TIPO_PEDIDO=cc.ID_TIPO_PEDIDO \n" +
                "and pd.ID_TIPO_PEDIDO = :tipope \n"
                    + "group by pd.ID_PEDIDO ,ch.ID_MANH,cd.FKIDCAJAHDR , ch.ID_TIPO, ch.ID_TIPO_PEDIDO, cc.ALTO, cc.ANCHO, cc.LARGO" ;
        HashMap<String, Object> param=new HashMap<String,Object>();
        try{
            param.put("pedido", pedido);
            param.put("idori", idManh);
            param.put("idcarr", idCarrier);
            param.put("idcaja", idCaja);
            param.put("tipope", idTipoPedido);
            
            gr = sccpConnection.queryForObject(sql, param, new GuiaRequestMapper());
        }catch(Exception e){
            
            try{
                logger.insertaError(
                    1010001
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            gr = null;
        }
        return gr;
    }

    @Override
    public Contacto getOrigenPedido(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        String sql = "select lpad(zfcpostalcode,5,0) cp_origen, zfcaddress direccion_origen, zfcintnumber NUMERO_INT_ORIGEN, zfcextnumber NUMERO_EXT_ORIGEN, zfccity CIUDAD_ORIGEN\n" +
                "-- CP_ORIGEN,zt.STREET DIRECCION_ORIGEN, 0 NUMERO_INT_ORIGEN, 0 NUMERO_EXT_ORIGEN, zt.REGION CIUDAD_ORIGEN\n" +
                ",zfcname CONTACTO_ORIGEN\n" +
                "--,'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' CONTACTO_ORIGEN \n" +
                ",zfcname RAZON_SOCIAL_ORIGEN, zfccolony COLONIA_ORIGEN, zfcstate ESTADO_ORIGEN, zstatenum ID_ESTADO_ORIGEN, zfcphonenumber telefono_origen\n" +
                "--,'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' RAZON_SOCIAL_ORIGEN ,zt.ZCOLONIA COLONIA_ORIGEN, zt.ZESTADOJDA ESTADO_ORIGEN,0 ID_ESTADO_ORIGEN\n" +
                "from info_cd.ZCPROVEEDORES \n" +
                "WHERE to_number(zfiproviderid) = :idManh and fiplatformtypeid = 2";
             //modify - check prov(idmanh) data type
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
             
            parametros.put("pedido", pedido);
            parametros.put("idManh", idManh);
            parametros.put("tipped", idTipoPedido);
            
            return sccpConnection.queryForObject(sql, parametros, new ContactoMapper());

        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
        }

         return null;
    }

    @Override
    public Contacto getDestinoPedido(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido) {
        String sql = "select lpad(CP_DESTINO,5,0) CP_DESTINO,CALLE_DESTINO DIRECCION_DESTINO, NUMERO_EXT_DESTINO, NUMERO_INT_DESTINO,CIUDAD_DESTINO,\n" +
                "NOMBRE_DESTINO||' '||AP_PATERNO_DESTINO||' '||AP_MATERNO_DESTINO CONTACTO_DESTINO,\n" +
                "RAZ_SOCIAL_DESTINO RAZON_SOCIAL_DESTINO,COLONIA_DESTINO,ESTADO_DESTINO,ID_ESTADO_DESTINO,TELEFONO_DESTINO \n" +
                "from info_cd.ECOM_CTR_PEDIDOS_HDR \n" +
                "WHERE ID_PEDIDO = :pedido and ID_ORIGEN = :idManh and id_tipo_pedido = :tipped";
             //modify - check real info data source
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
             
            parametros.put("pedido", pedido);
            parametros.put("idManh", idManh);
            parametros.put("tipped", idTipoPedido);
            
            return sccpConnection.queryForObject(sql, parametros, new ContactoMapper());

        } catch (Exception ex) { 
            
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
        }

         return null;
    }

    @Override
    public Contacto getOrigenPedidoWs(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        String sql = "select lpad(zfcpostalcode,5,0) CP_ORIGEN,zt.STREET DIRECCION_ORIGEN, 0 NUMERO_INT_ORIGEN, 0 NUMERO_EXT_ORIGEN, zt.REGION CIUDAD_ORIGEN\n" +
                "--CALLE_ORIGEN DIRECCION_ORIGEN, NUMERO_INT_ORIGEN, NUMERO_EXT_ORIGEN ,CIUDAD_ORIGEN,\n" +
                ",'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' CONTACTO_ORIGEN \n" +
                "--RAZ_SOCIAL_ORIGEN CONTACTO_ORIGEN,\n" +
                ",'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' RAZON_SOCIAL_ORIGEN ,zt.ZCOLONIA COLONIA_ORIGEN, zt.ZESTADOJDA ESTADO_ORIGEN,0 ID_ESTADO_ORIGEN\n" +
                "--RAZ_SOCIAL_ORIGEN RAZON_SOCIAL_ORIGEN,COLONIA_ORIGEN,ESTADO_ORIGEN,ID_ESTADO_ORIGEN,TELEFONO_ORIGEN\n" +
                "from info_cd.ZCPROVEEDORES zp \n" +
                "join info_cd.ZMTIENDAS zt on zt.werks = 9778 \n" +
                "WHERE to_number(zfiproviderid) = :idManh and fiplatformtypeid = 2";
             //modify - check real info data source
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
             
            parametros.put("pedido", pedido);
            parametros.put("idManh", idManh);
            parametros.put("tipped", idTipoPedido);
            
            return sccpConnection.queryForObject(sql, parametros, new ContactoMapper());

        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
        }

         return null;
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest gr) {
        //modify - check info sap (returning null)
        String sql="select sum(pd.CANTIDAD) CANTIDAD, pd.ID_SKU, zi.IDESCR DESC_SKU, zc.ZN3NCL DEPARTAMENTO, zc.ZN3CLAS DESC_DEPARTAMENTO, zc.MATKL SUBDEPARTAMENTO, zc.WGBEZ DESC_SUBDEPARTAMENTO, zc.ZN1CLAS CLASE, zc.ZN1CLAS DESC_CLASE,\n" +
            "zc.ZN2NCL SUBCLASE, zc.ZN2CLAS DESC_SUBCLASE, zi.BRGEW PESO, zi.BREIT*100 ANCHO, zi.LAENG*100 LARGO, zi.HOEHE*100 ALTO, zi.ZHCOST COSTO\n" +
            "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
            "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
            "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
            "join info_cd.ecom_cat_contenedor cc on ch.FKIDCONTENEDOR = cc.PKIDCONTENEDOR \n" +
            "join info_cd.Z_INVMST zi on  pd.ID_SKU = zi.INUMBER\n" +
            "join info_cd.ZMCLAS_SAP zc on zc.MATKL=zi.MATKL\n" +
            "where pd.ID_PEDIDO =  :pedido \n" +
            "and ch.ID_MANH = :idori\n" +
            "and cd.FKIDCAJAHDR = :idcaja\n" +
            "and pd.ID_TIPO_PEDIDO = :tipope\n" +
            "and pd.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO \n" +
            "and pd.ID_TIPO_PEDIDO=cc.ID_TIPO_PEDIDO \n" +
            "group by pd.ID_SKU,zi.IDESCR , zc.ZN3NCL , zc.ZN3CLAS , zc.MATKL , zc.WGBEZ , zc.ZN1CLAS , zc.ZN1CLAS ,\n" +
            "zc.ZN2NCL , zc.ZN2CLAS , zi.BRGEW , zi.BREIT , zi.LAENG , zi.HOEHE , zi.ZHCOST  ";
        HashMap<String, Object> param=new HashMap<String,Object>();
            param.put("pedido", gr.getVtex());
            param.put("idori", gr.getIdManh());
            param.put("idcaja", gr.getIdCaja());
            param.put("tipope", gr.getIdTipoPedido());
        try{
            return sccpConnection.query(sql, param, new DetalleSkusMapper());
        }catch(Exception e){
            
            try{
                logger.insertaError(
                    1010006
                    , 10
                    , gr.getIdManh()
                    , null
                    , gr.getPedido()
                    , gr.getIdCaja()
                    , gr.getIdCarrier()
                    , null
                    , gr.getIdCanal()
                    , gr.getIdTipoPedido()
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            return null;
        }
    }

    @Override
    public String getOrderId(GuiaRequest guiaRequest, List<String> nc) {
        return null;
    }

    @Override
    public List<String> getNCbyAdn(int idCaja, int idManh) {
        return null;
    }

}
