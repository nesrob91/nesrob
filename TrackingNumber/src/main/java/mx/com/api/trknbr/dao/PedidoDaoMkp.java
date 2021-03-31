/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoDaoMkp")
public class PedidoDaoMkp implements PedidoDao{
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;

    @Override
    public List<Map<String, Object>> getPedido(List<String> contenido, int idManh, String idLpn, int tipoPedido) {
        String sql = "select ph.id_origen,pd.adn,ph.id_pedido from info_cd.ecom_ctr_pedidos_hdr ph \n"
                + "join info_cd.ecom_ctr_pedidos_dtl pd on ph.id_pedido=pd.id_pedido and ph.id_tipo_pedido=pd.id_tipo_pedido\n"
                + "where pd.adn in (:adn) and ph.id_origen = :idvend and ph.id_tipo_pedido = :tipope";
        //modify - check for real columns
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("adn", contenido);
            parametros.put("idvend", idManh);
            parametros.put("tipope", tipoPedido);

            return sccpConnection.queryForList(sql, parametros);
        } catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idManh
                    , null
                    , null
                    , 0
                    , null
                    , null
                    , 0
                    , tipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            return null;
        }
    }

    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn) {
        String sql="select pd.ID_PEDIDO PEDIDO,ch.ID_MANH,cd.FKIDCAJAHDR ID_CAJA, '' ID_LPN, ch.ID_TIPO, ch.ID_TIPO_PEDIDO, :idcarr ID_CARRIER, cc.ALTO, cc.ANCHO, cc.LARGO, ch.VOLUMENUTILIZADO PESO  "
                    + "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
                "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
                "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
                "join info_cd.ecom_cat_contenedor cc on ch.FKIDCONTENEDOR = cc.PKIDCONTENEDOR \n" +
                "where pd.ID_PEDIDO = :pedido\n" +
                "and ch.ID_MANH = :idori\n" +
                "and cd.FKIDCAJAHDR = :idcaja \n" +
                "and pd.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO \n" +
                "and pd.ID_TIPO_PEDIDO=cc.ID_TIPO_PEDIDO \n" +
                "and pd.ID_TIPO_PEDIDO = :tipope and rownum < 2" ;
        HashMap<String, Object> param=new HashMap<String,Object>();
        try{
            
            param.put("pedido", pedido);
            param.put("idori", idManh);
            param.put("idcarr", idCarrier);
            param.put("idcaja", idCaja);
            param.put("tipope", idTipoPedido);
            
            return sccpConnection.queryForObject(sql, param, new GuiaRequestMapper());
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
            return null;
        }
    }

    @Override
    public Contacto getOrigenPedido(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        //modify - check name origin
        String sql = "select case when length(CP_ORIGEN) > 5 then to_char(to_number(CP_ORIGEN)) else CP_ORIGEN end CP_ORIGEN,CALLE_ORIGEN DIRECCION_ORIGEN, NUMERO_INT_ORIGEN, NUMERO_EXT_ORIGEN ,CIUDAD_ORIGEN,\n" +
                "RAZ_SOCIAL_ORIGEN CONTACTO_ORIGEN,\n" +
                "RAZ_SOCIAL_ORIGEN RAZON_SOCIAL_ORIGEN,COLONIA_ORIGEN,ESTADO_ORIGEN,ID_ESTADO_ORIGEN,TELEFONO_ORIGEN, \n" +
                "case when length(CP_DESTINO) > 5 then to_char(to_number(CP_DESTINO)) else CP_DESTINO end CP_DESTINO,CALLE_DESTINO DIRECCION_DESTINO, NUMERO_EXT_DESTINO, NUMERO_INT_DESTINO,CIUDAD_DESTINO,\n" +
                "NOMBRE_DESTINO||' '||AP_PATERNO_DESTINO||' '||AP_MATERNO_DESTINO CONTACTO_DESTINO,\n" +
                "RAZ_SOCIAL_DESTINO RAZON_SOCIAL_DESTINO,COLONIA_DESTINO,ESTADO_DESTINO,ID_ESTADO_DESTINO,TELEFONO_DESTINO \n" +
                "from info_cd.ECOM_CTR_PEDIDOS_HDR "
                + " WHERE ID_PEDIDO = :pedidov and ID_ORIGEN = :idprov and id_tipo_pedido = :tipope";
             
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
            parametros.put("pedidov", pedido);
            parametros.put("idprov", idManh);
            parametros.put("tipope", idTipoPedido);
            
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
        //modify - check name origin
        String sql = "select case when length(CP_ORIGEN) > 5 then to_char(to_number(CP_ORIGEN)) else CP_ORIGEN end CP_ORIGEN,CALLE_ORIGEN DIRECCION_ORIGEN, NUMERO_INT_ORIGEN, NUMERO_EXT_ORIGEN ,CIUDAD_ORIGEN,\n" +
                "RAZ_SOCIAL_ORIGEN CONTACTO_ORIGEN,\n" +
                "RAZ_SOCIAL_ORIGEN RAZON_SOCIAL_ORIGEN,COLONIA_ORIGEN,ESTADO_ORIGEN,ID_ESTADO_ORIGEN,TELEFONO_ORIGEN, \n" +
                "case when length(CP_DESTINO) > 5 then to_char(to_number(CP_DESTINO)) else CP_DESTINO end CP_DESTINO,CALLE_DESTINO DIRECCION_DESTINO, NUMERO_EXT_DESTINO, NUMERO_INT_DESTINO,CIUDAD_DESTINO,\n" +
                "NOMBRE_DESTINO||' '||AP_PATERNO_DESTINO||' '||AP_MATERNO_DESTINO CONTACTO_DESTINO,\n" +
                "RAZ_SOCIAL_DESTINO RAZON_SOCIAL_DESTINO,COLONIA_DESTINO,ESTADO_DESTINO,ID_ESTADO_DESTINO,TELEFONO_DESTINO \n" +
                "from info_cd.ECOM_CTR_PEDIDOS_HDR "
                + " WHERE ID_PEDIDO = :pedidov and ID_ORIGEN = :idprov and id_tipo_pedido = :tipope";
             
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
            parametros.put("pedidov", pedido);
            parametros.put("idprov", idManh);
            parametros.put("tipope", idTipoPedido);
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest gr) {
        //modify - check info sap (returning null)
        String sql="select count(pd.ID_SKU) CANTIDAD, pd.ID_SKU, '' DESC_SKU, '' DEPARTAMENTO, '' DESC_DEPARTAMENTO, '' SUBDEPARTAMENTO, '' DESC_SUBDEPARTAMENTO, '' CLASE, '' DESC_CLASE,\n" +
            "'' SUBCLASE, '' DESC_SUBCLASE, '' PESO, '' LARGO, '' ANCHO, '' ALTO, '' COSTO\n" +
            "from info_cd.ECOM_CTR_PEDIDOS_DTL pd\n" +
            "join info_cd.ecom_caja_dtl cd on pd.ADN = cd.OLPN \n" +
            "join info_cd.ecom_caja_hdr ch on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
            "join info_cd.ecom_cat_contenedor cc on ch.FKIDCONTENEDOR = cc.PKIDCONTENEDOR \n" +
            "where pd.ID_PEDIDO =  'v'||:pedido||'ekt-01'\n" +
            "and ch.ID_MANH = :idori\n" +
            "and cd.FKIDCAJAHDR = :idcaja\n" +
            "and pd.ID_TIPO_PEDIDO = :tipope\n" +
            "and pd.ID_TIPO_PEDIDO=cc.ID_TIPO_PEDIDO \n" +
            "and pd.ID_TIPO_PEDIDO=ch.ID_TIPO_PEDIDO \n" +
            "group by pd.ID_SKU";
        HashMap<String, Object> param=new HashMap<String,Object>();
            param.put("pedido", gr.getPedido());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getNCbyAdn(int idCaja, int idManh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
