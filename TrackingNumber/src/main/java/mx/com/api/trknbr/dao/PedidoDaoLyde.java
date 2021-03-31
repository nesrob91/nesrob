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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoDaoLyde")
public class PedidoDaoLyde implements PedidoDao{
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private NamedParameterJdbcTemplate dom18Connection;
    
    @Override
    public List<Map<String, Object>> getPedido(List<String> contenido, int idManh, String idLpn, int tipoPedido) {
        String sql = "select nh.folio,pc.canal,pc.whse,pc.pedido,pc.contras,nh.horario,nh.status from info_cd.notacargohdr nh \n" +
            "join info_cd.ped_cent pc on nh.remision = pedido and nh.cd_id=pc.whse\n" +
            "where nh.folio in (:nc) and nh.cd_id = :almmn";
        List<Map<String, Object>> list;
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("nc", contenido);
            param.put("almmn", idManh);
            list = sccpConnection.queryForList(sql, param);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
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
            return null;
        }
        return list;
    }

    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contacto getOrigenPedido(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        Contacto result;
        String sql = "SELECT DISTINCT ZT.POST_CODE1 CP_ORIGEN ,\n" +
            "ZT.STREET DIRECCION_ORIGEN , '0' NUMERO_INT_ORIGEN, '0' NUMERO_EXT_ORIGEN ,\n" +
            "ZT.CITY1 CIUDAD_ORIGEN , 'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' CONTACTO_ORIGEN , 'NUEVA ELEKTRA DEL MILENIO S.A. DE C.V.' RAZON_SOCIAL_ORIGEN ,\n" +
            "ZT.ZCOLONIA COLONIA_ORIGEN , ZT.ZESTADOJDA ESTADO_ORIGEN , CP.ID_ESTADO ID_ESTADO_ORIGEN ,\n" +
            "'5525696062' TELEFONO_ORIGEN \n" +
            "FROM INFO_CD.REMMQH R , INFO_CD.ZMTIENDAS ZT ,\n" +
            "INFO_CD.E3ALTWHS WHS , INFO_CD.CE_CAT_CP_CDS CP\n" +
            "WHERE 1=1\n" +
            "AND R.EMISOR = WHS.ALMJD\n" +
            "AND WHS.ALMMN = :almmn\n" +
            "AND WHS.ALMMN = CP.CD_ID\n" +
            "AND ZT.ZSTRNUM = WHS.ALMJD \n" +
            "--AND ZT.ZSTRNUM = :tda\n" +
            "AND R.FOLREM = :rem " ;
        HashMap<String, Object> param=new HashMap<>();
        try{
            param.put("rem",pedido);
            param.put("almmn",idManh);
            result = sccpConnection.queryForObject(sql, param, new ContactoMapper());
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
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
    public Contacto getDestinoPedido(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido) {
        Contacto result;
        String sql = "select  ZT.POST_CODE1 CP_DESTINO , ZT.STREET DIRECCION_DESTINO, \n" +
            " CS.NUMEXT NUMERO_EXT_DESTINO, CS.NUMINT NUMERO_INT_DESTINO,\n" +
            " ZT.CITY1 CIUDAD_DESTINO,\n" +
            " ZT.NAME3 CONTACTO_DESTINO, ZT.NAME3 RAZON_SOCIAL_DESTINO,\n" +
            " ZT.ZCOLONIA COLONIA_ORIGEN , ZT.ZESTADOJDA ESTADO_ORIGEN ,\n" +
            " CS.IDESTADOINEGI ID_ESTADO_DESTINO, ZT.TEL_NUMBER TELEFONO_DESTINO\n" +
            "FROM  INFO_CD.ZMTIENDAS ZT , INTERF_SCI.VM_CAT_CECO_SUCURSALES CS\n" +
            "WHERE 1=1\n" +
            "AND ZT.ZSTRNUM=CS.SUCURSAL\n" +
            "AND ZT.ZSTRNUM = (select recept from INFO_CD.REMMQH where folrem = :rem and emisor = (select almjd from info_cd.e3altwhs where almmn = :almmn))";
        HashMap<String, Object> param=new HashMap<>();
        try{
            param.put("rem",pedido);
            param.put("almmn",idManh);
            result = sccpConnection.queryForObject(sql, param, new ContactoMapper());
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
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
    public Contacto getOrigenPedidoWs(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest) {
        String sql="SELECT SUM(rd.CANTID) cantidad ,\n" +
            "rd.CODIGO ID_SKU ,zi.IDESCR DESC_SKU ,\n" +
            "zc.ZN1NCL DEPARTAMENTO,zc.ZN1CLAS DESC_DEPARTAMENTO ,\n" +
            "zc.ZN2NCL SUBDEPARTAMENTO,zc.ZN2CLAS DESC_SUBDEPARTAMENTO ,\n" +
            "zc.ZN3NCL CLASE,zc.ZN3CLAS DESC_CLASE ,\n" +
            "zc.MATKL SUBCLASE,zc.WGBEZ DESC_SUBCLASE ,\n" +
            "zi.BRGEW PESO,zi.BREIT*100 ANCHO,zi.LAENG*100 LARGO,zi.HOEHE*100 ALTO,zi.ZHCOST COSTO\n" +
            "FROM info_cd.ecom_caja_hdr ch\n" +
            "JOIN info_cd.ecom_caja_dtl cd ON cd.FKIDCAJAHDR=ch.PKIDCAJAHDR\n" +
            "JOIN info_cd.remmqh rh ON rh.folrem = cd.OLPN\n" +
            "  AND (select almjd from info_cd.e3altwhs where almmn=:idori)=rh.emisor\n" +
            "JOIN info_cd.remmqd_hist rd ON rd.EMISOR =rh.EMISOR AND rd.FOLREM=rh.FOLREM\n" +
            "JOIN info_cd.z_invmst zi ON rd.CODIGO=zi.INUMBER\n" +
            "JOIN info_cd.ZMCLAS_SAP zc ON zc.MATKL=zi.MATKL\n" +
            "WHERE ch.PKIDCAJAHDR = :idcaja\n" +
            "AND rh.emisor = (select almjd from info_cd.e3altwhs where almmn=:idori)\n" +
            "GROUP BY rd.CODIGO ,zi.IDESCR ,zc.ZN3NCL ,zc.ZN3CLAS ,zc.MATKL ,zc.WGBEZ ,zc.ZN1CLAS ,zc.ZN1CLAS ,\n" +
            "zc.ZN2NCL ,zc.ZN2CLAS ,zi.BRGEW ,zi.BREIT ,zi.LAENG ,zi.HOEHE ,zi.ZHCOST,zc.ZN1NCL ";
        //modify - check for real data source info
        HashMap<String, Object> param=new HashMap<String,Object>();
            param.put("idcaja", guiaRequest.getIdCaja());
            param.put("idori", guiaRequest.getIdManh());
        try{
            return sccpConnection.query(sql, param, new DetalleSkusMapper());
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010006
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , ""
                    , guiaRequest.getIdCaja()
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
    public String getOrderId(GuiaRequest guiaRequest, List<String> nc) {
        String result;
        String sql = "select o.ORDER_ID \n" +
            "from DOM18CA.ORDERS o where o.TC_ORDER_ID in (:dos) and o.O_FACILITY_ALIAS_ID = :almmn";
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("dos",nc);
            param.put("almmn",guiaRequest.getIdManh());
            result = dom18Connection.queryForObject(sql, param,String.class);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010003
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , ""
                    , 0
                    , 0
                    , null
                    , 0
                    , 0
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    ,    null);
            }catch(Exception ex){}
            result=null;
        }
        return result;
    }

    @Override
    public List<String> getNCbyAdn(int idCaja, int idManh) {
        List<String> ncs;
        Map<String,Object> param=new HashMap<>();
        String sql="select nh.horario from info_cd.ecom_caja_dtl cd\n" +
                "join info_cd.notacargohdr nh on cd.olpn=nh.folio\n" +
                "where cd.FKIDCAJAHDR = :caja\n" +
                "and nh.CD_ID=:almmn";
        try{
            param.put("caja",idCaja);
            param.put("almmn",idManh);
            ncs=sccpConnection.queryForList(sql, param, String.class);
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idManh
                    , null
                    , ""
                    , idCaja
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
        return ncs;
    }
    
}
