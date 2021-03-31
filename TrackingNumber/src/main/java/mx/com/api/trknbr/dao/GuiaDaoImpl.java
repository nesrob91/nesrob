/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("carrierDao")
public class GuiaDaoImpl implements GuiaDao {
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public boolean insertaControlGuias(GuiaRequest guiaRequest, String usuario) {
        
        String query = " INSERT INTO INFO_CD.CE_CONTROL_GUIAS "
                + " ( "
                + " PEDIDO, ORDER_ID, CD_ID "
                + " , CP_ORIGEN, DIRECCION_ORIGEN, CIUDAD_ORIGEN, CONTACTO_ORIGEN, RAZ_SOC_ORIGEN, COLONIA_ORIGEN, ESTADO_ORIGEN, ID_ESTADO_ORIGEN "
                + " , CP_DESTINO, DIRECCION_DESTINO, CIUDAD_DESTINO, CONTACTO_DESTINO, RAZON_SOC_DESTINO, COLONIA_DESTINO, ESTADO_DESTINO, ID_ESTADO_DESTINO "
                + " , LARGO, ANCHO, PESO, ALTO, ID_CARRIER, ID_ESTATUS_GUIA, REF_FIELD_2, ID_TIPO, ID_TIPO_PEDIDO, USUARIO_CREACION, FECHA_CREACION "
                + " ) "
                + " VALUES "
                + " ( "
                + " :pedido, :orderId, :idManh "
                + " , :cpOrigen, :direccionOrigen, :ciudadOrigen, :contactoOrigen, :razonSocialOrigen, :coloniaOrigen, :estadoOrigen, :idEstadoOrigen "
                + " , :cpDestino, :direccionDestino, :ciudadDestino, :contactoDestino, :razonSocialDestino, :coloniaDestino, :estadoDestino, :idEstadoDestino "
                + " , :largo, :ancho, :peso, :alto, :idCarrier, :idEstatusGuia, :idCsja, :idCanal, :idTipoPedido, :usuarioCreacion, SYSDATE "
                + " ) ";

        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", guiaRequest.getPedido());
            parametros.put("orderId", guiaRequest.getOrderId());
            parametros.put("idManh", guiaRequest.getIdManh());
            parametros.put("cpOrigen", guiaRequest.getOrigen().getCp());
            parametros.put("direccionOrigen", guiaRequest.getOrigen().getDireccion());
            parametros.put("ciudadOrigen", guiaRequest.getOrigen().getCiudad());
            parametros.put("contactoOrigen", guiaRequest.getOrigen().getContacto());
            parametros.put("razonSocialOrigen", guiaRequest.getOrigen().getRazonSocial());
            parametros.put("coloniaOrigen", guiaRequest.getOrigen().getColonia());
            parametros.put("estadoOrigen", guiaRequest.getOrigen().getEstado());
            parametros.put("idEstadoOrigen", guiaRequest.getOrigen().getIdEstado());
            parametros.put("cpDestino", guiaRequest.getDestino().getCp());
            parametros.put("direccionDestino", guiaRequest.getDestino().getDireccion());
            parametros.put("ciudadDestino", guiaRequest.getDestino().getCiudad());
            parametros.put("contactoDestino", guiaRequest.getDestino().getContacto());
            parametros.put("razonSocialDestino", guiaRequest.getDestino().getRazonSocial());
            parametros.put("coloniaDestino", guiaRequest.getDestino().getColonia());
            parametros.put("estadoDestino", guiaRequest.getDestino().getEstado());
            parametros.put("idEstadoDestino", guiaRequest.getDestino().getIdEstado());
            parametros.put("largo", guiaRequest.getLargo());
            parametros.put("ancho", guiaRequest.getAncho());
            parametros.put("peso", guiaRequest.getPeso());
            parametros.put("alto", guiaRequest.getAlto());
            parametros.put("idCarrier", guiaRequest.getIdCarrier());
            parametros.put("idEstatusGuia", 5);
            parametros.put("idCsja", guiaRequest.getIdCaja()+"");
            parametros.put("idCanal", guiaRequest.getIdCanal());
            parametros.put("idTipoPedido", guiaRequest.getIdTipoPedido());
            parametros.put("usuarioCreacion", usuario);
            parametros.put("idLpn", guiaRequest.getIdLpn());
            
            return sccpConnection.update(query, parametros) > 0;

        } catch (Exception ex) {
            //logger.error("Error al insertar en CONTROL_GUIAS");
            try{
                logger.insertaError(
                    1011001
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean actualizaControlGuias(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String usuario){
        
        String sql = " UPDATE INFO_CD.CE_CONTROL_GUIAS "
                    + " SET ID_ESTATUS_GUIA = :idEstatusGuia "
                    + " , USUARIO_MODIFICACION = :usuario "
                    + " , FECHA_MODIFICACION = SYSDATE "
                    + " , NUM_GUIA = :numGuia "
                    + " , REF_FIELD_1 =substr( :mensaje , 1, 200) "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ORDER_ID = :orderId "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND REF_FIELD_2 = :idCaja ";

        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idEstatusGuia", guiaResponse.getIdEstatusGuia());
            parametros.put("usuario", usuario);
            parametros.put("numGuia", guiaResponse.getNumGuia());
            parametros.put("mensaje", guiaResponse.getMensaje());
            parametros.put("pedido", guiaRequest.getPedido());
            parametros.put("orderId", guiaRequest.getOrderId());
            parametros.put("idManh", guiaRequest.getIdManh());
            parametros.put("idCarrier", guiaRequest.getIdCarrier());
            parametros.put("idCaja", guiaRequest.getIdCaja() + "");
            
            return sccpConnection.update(sql, parametros) > 0;
            
        } catch (Exception ex) {
            //logger.error("Error al actualizar CONTROL_GUIAS ");
            try{
                logger.insertaError(
                    1012001
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return false;
        }

    }
    
    @Override
    public boolean insertaMensajesWs(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String operacion) {

        String sql = " INSERT INTO INFO_CD.CE_RESULT_GUIAS_WS "
                + " ( "
                + " PEDIDO, ORDER_ID, CD_ID, ID_CARRIER, FECHA_CREACION "
                + " , CODIGO, RESULTADO, DESCRIPCION "
                + " , XML_INPUT, XML_OUTPUT_CLOB, OPERACION, REF_FIELD_2 ) "
                + " VALUES "
                + " ( "
                + " ?, ?, ?, ?, SYSDATE "
                + " , ?, SUBSTR(?, 0, 100), SUBSTR(?, 0, 100) "
                + " , ?, ?, ?, ? "
                + " ) ";
        try {

            LobHandler lobHandler=new DefaultLobHandler();
            //clobRequest = new CLOB((OracleConnection)sccpConnection.getJdbcTemplate().getDataSource().getConnection(), guiaResponse.getInput().getBytes());
            //oracle.sql.CLOB.createTemporary(sccpConnection.getJdbcTemplate().getDataSource().getConnection(), false, 12);
            //clobRequest.setString(1, guiaResponse.getInput());
            //clobResponse = new CLOB((OracleConnection)sccpConnection.getJdbcTemplate().getDataSource().getConnection(), guiaResponse.getOutput().getBytes());
            //clobResponse = oracle.sql.CLOB.createTemporary(sccpConnection.getJdbcTemplate().getDataSource().getConnection(), false, 12);
            //clobResponse.setString(1, guiaResponse.getOutput());

            
            PreparedStatement ps = sccpConnection.getJdbcTemplate().getDataSource().getConnection().prepareStatement(sql);
            lobHandler.getLobCreator().setClobAsString(ps, 8, guiaResponse.getInput());
            lobHandler.getLobCreator().setClobAsString(ps, 9, guiaResponse.getOutput());
            ps.setObject(1, guiaRequest.getPedido());
            ps.setObject(2, guiaRequest.getOrderId());
            ps.setObject(3, guiaRequest.getIdManh());
            ps.setObject(4, guiaRequest.getIdCarrier());
            ps.setObject(5, guiaResponse.getIdEstatusGuia() + "");
            ps.setObject(6, (guiaResponse.getIdEstatusGuia()==10) ? guiaResponse.getNumGuia() : guiaResponse.getMensaje());
            ps.setObject(7, (guiaResponse.getIdEstatusGuia()==10) ? guiaResponse.getNumGuia() : guiaResponse.getMensaje());
            ps.setObject(10, operacion);
            ps.setObject(11, guiaRequest.getIdCaja() + "");
            return ps.executeUpdate() > 0;
            /*
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", guiaRequest.getPedido());
            parametros.put("orderId", guiaRequest.getOrderId());
            parametros.put("idManh", guiaRequest.getIdManh());
            parametros.put("idCarrier", guiaRequest.getIdCarrier());
            parametros.put("idEstatusGuia", guiaResponse.getIdEstatusGuia() + "");
            parametros.put("resultado", (guiaResponse.getIdEstatusGuia()==10) ? guiaResponse.getNumGuia() : guiaResponse.getMensaje());
            parametros.put("xmlInput", clobRequest);
            parametros.put("xmlOutput", clobResponse);
            parametros.put("operacion", operacion);
            parametros.put("idCaja", guiaRequest.getIdCaja() + "");
            return sccpConnection.update(sql, parametros) > 0;
            */
        } catch (Exception ex) {
            try{
                logger.insertaError(
                    1011002
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return false;

        }

    }
    
    @Override
    public boolean insEtiqueta(GuiaRequest guiaRequest, GuiaResponse guiaResponse) {
        String sql = "INSERT INTO INFO_CD.CE_ETIQUETAS "
                + " (ORDER_ID, CD, ID_CARRIER, NUM_GUIA, CONTENIDO_ETIQUETA, FECHA_CREACION, REF_FIELD_2, REF_FIELD_1 ) "
                + "  VALUES "
                + " (?, ?, ?, ?, ?, SYSDATE, ? , ?) " ;
        try {
            LobHandler lobHandler=new DefaultLobHandler();
            //clob = oracle.sql.CLOB.createTemporary(sccpConnection.getJdbcTemplate().getDataSource().getConnection(), false, oracle.sql.CLOB.DURATION_SESSION);
            //clob.setString(1, guiaResponse.getEtiqueta());

            
            /*
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("orderId", guiaRequest.getOrderId());
            parametros.put("idManh", guiaRequest.getIdManh());
            parametros.put("idCarrier", guiaRequest.getIdCarrier());
            parametros.put("numGuia", guiaResponse.getNumGuia());
            parametros.put("etiqueta", guiaResponse.getEtiqueta());
            parametros.put("idCaja", guiaRequest.getIdCaja() + "");

            return sccpConnection.update(sql, parametros) > 0;
            */
            PreparedStatement ps = sccpConnection.getJdbcTemplate().getDataSource().getConnection().prepareStatement(sql);
            lobHandler.getLobCreator().setClobAsString(ps, 5, guiaResponse.getEtiqueta());
            ps.setObject(1, guiaRequest.getOrderId());
            ps.setObject(2, guiaRequest.getIdManh());
            ps.setObject(3, guiaRequest.getIdCarrier());
            ps.setObject(4, guiaResponse.getNumGuia());
            ps.setObject(6, guiaRequest.getIdCaja() + "");
            ps.setObject(7, guiaResponse.getEncrypt());
            return ps.executeUpdate() > 0;
            
        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1011003
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){
                
            }
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return false;

        } 

    }
    
    
    @Override
    public String getTipoServicioPorPeso(GuiaRequest guiaRequest){
        String sql = " SELECT (CASE WHEN PESO >= :peso AND VOLUMEN >= :peso " 
                + " THEN REF_FIELD_1 ELSE REF_FIELD_2 END) TIPO_SERVICIO " 
                + " FROM INFO_CD.CE_CAT_CONDICIONES " 
                + " WHERE ID_CARRIER = :idCarrier " 
                + " AND ID_TIPO_PEDIDO = :idTipoPedido ";
        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("peso", guiaRequest.getPeso());
            parametros.put("idCarrier", guiaRequest.getIdCarrier());
            parametros.put("idTipoPedido", guiaRequest.getIdTipoPedido());
            
            return sccpConnection.queryForObject(sql, parametros, String.class);
            
        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010005
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return null;
        } 
    }
    
    @Override
    public String getTipoServicioPorRangoPeso(float pesoFisico, int idCarrier, int tipo) {
        String tipoServicio = "";
        Map<String,Object> stmt = new HashMap<>();

        try {
            String sql = " SELECT REF_FIELD_1 TIPO_SERVICIO "
                    + " FROM INFO_CD.CE_CAT_COTIZACION "
                    + " WHERE TIPO =   :tipo   "
                    + " AND ID_CARRIER =   :carrier   "
                    + " AND   :peso    BETWEEN PESO AND COSTO "
            ;

            stmt.put("tipo", tipo);
            stmt.put("carrier", idCarrier);
            stmt.put("peso", pesoFisico);

            tipoServicio = sccpConnection.queryForObject(sql,stmt,String.class);

        } catch (Exception ex) {

            logger.insertaError(1010005,10,0,0,"",0,idCarrier,"",0,0,ex.toString(),getClass().getName(),"");

        } finally {

            return tipoServicio;

        }
    }
    
    @Override
    public GuiaResponse getLabel(String numGuia, int carrier){
        String sql="select et.NUM_GUIA,et.CONTENIDO_ETIQUETA,cg.ID_ESTATUS_GUIA,cg.ID_CARRIER,ch.PKIDCAJAHDR,case when cg.id_estatus_guia = -1 then 'Cancelada' else cg.REF_FIELD_1 end "
                + " from info_cd.ce_etiquetas et\n" +
            "join info_cd.ce_control_guias cg on cg.NUM_GUIA=et.NUM_GUIA and cg.ID_CARRIER=et.ID_CARRIER\n" +
            "join info_cd.ecom_caja_hdr ch on ch.PKIDCAJAHDR=cg.REF_FIELD_2 and ch.ID_MANH=cg.CD_ID\n" +
            "where et.NUM_GUIA = :numGuia \n" +
            "and et.ID_CARRIER = :idCarr";
        Map<String,Object> param=new HashMap<>();
        param.put("numGuia",numGuia);
        param.put("idCarr",carrier);
        try{
            return sccpConnection.queryForObject(sql, param, (ResultSet rs, int rowNum) -> {
                GuiaResponse gr=new GuiaResponse();
                gr.setCarrier(rs.getInt("ID_CARRIER"));
                gr.setEtiqueta(rs.getString("CONTENIDO_ETIQUETA"));
                gr.setIdCaja(rs.getInt("PKIDCAJAHDR"));
                gr.setNumGuia(rs.getString("NUM_GUIA"));
                gr.setIdEstatusGuia(rs.getInt("ID_ESTATUS_GUIA"));
                return gr;
            });
        }catch(EmptyResultDataAccessException e){
            if(conf.isWriteAll())
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , 0
                    , null
                    , numGuia
                    , 0
                    , carrier
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
    public List<Map<String, Object>> getTrkNbr3PL(List<String> nc, int cd, int type) {
        String sql = "select nh.folio,cd.FKIDCAJAHDR,cg.NUM_GUIA,cc.id_carrier,cc.cod_carrier from info_cd.notacargohdr nh\n" +
            "join info_cd.ecom_caja_dtl cd on cd.OLPN = nh.remision\n" +
            "join  info_cd.ce_control_guias cg on cd.FKIDCAJAHDR=cg.REF_FIELD_2 \n " +
                "join info_cd.ce_cat_carriers cc on cc.id_carrier=cg.id_carrier \n" +
            "where nh.folio in (:nc) and nh.cd_id = :almmn \n" +
            "and cg.ID_ESTATUS_GUIA >= 10 \n" +
            "and cg.ID_ESTATUS_GUIA < 99";
        String sqlRem = "select rh.folrem folio,cd.FKIDCAJAHDR,cg.NUM_GUIA,cc.id_carrier,cc.cod_carrier from info_cd.remmqh rh\n" +
            "join info_cd.ecom_caja_dtl cd on cd.OLPN = to_char(rh.FOLREM)\n" +
            "join  info_cd.ce_control_guias cg on cd.FKIDCAJAHDR=cg.REF_FIELD_2 \n" +
                "join info_cd.ce_cat_carriers cc on cc.id_carrier=cg.id_carrier \n" +
            "where rh.folrem in (:rem) and rh.emisor = (select almjd from info_cd.e3altwhs where almmn = :almmn)\n" +
            "and cg.ID_ESTATUS_GUIA >= 10 \n" +
            "and cg.ID_ESTATUS_GUIA < 99";
        List<Map<String, Object>> list;
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("nc", nc);
            param.put("rem", nc);
            param.put("almmn", cd);
            switch(type){
                case 1:
                    list = sccpConnection.queryForList(sqlRem, param);
                    break;
                case 2:
                    list = sccpConnection.queryForList(sql, param);
                    break;
                default :
                    list = null;
                    break;
            }
            
        }catch(Exception ex){
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
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
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            return null;
        }
        return list;
    }
    
    @Override
    public List<Map<String, Object>> getStatusTrknbr(String numGuia, int idCarrier) {
        String sql = "select cg.pedido,cg.cd_id origen,cg.num_guia,cg.id_estatus_guia stat,cg.ref_field_2 caja,ch.pkidcajahdr,ch.fkidestatus,ch.pedido pedido_caja \n" +
            " from info_cd.ce_control_guias cg\n" +
            " join info_cd.ecom_caja_hdr ch on cg.ref_field_2=ch.pkidcajahdr\n" +
            " where cg.NUM_GUIA = :numguia\n" +
            " and cg.ID_CARRIER = :carrier" ;
        Map<String, Object> parametros = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> fix = new ArrayList<>();
        try{
            parametros.put("numguia", numGuia);
            parametros.put("carrier", idCarrier);
            return sccpConnection.queryForList(sql, parametros);
        }catch(Exception e){
            result.put("valid",false);
            result.put("message","No se pudo recuperar informacion de la guia.");
            if(conf.isWriteAll())
                System.out.println("ERROR : "+e.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , 0
                    , null
                    , numGuia
                    , 0
                    , idCarrier
                    , null
                    , 0
                    , 0
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            fix.add(result);
        }
        return fix;
    }

    @Override
    public List<Map<String, Object>> getStatusTrknbr(List<String> contenido, int idCentro, int idTipoPedido) {
        String sql = "select distinct cg.pedido,cg.cd_id origen,case when cg.id_estatus_guia BETWEEN (10) and 30 then cg.num_guia else 'SIN GUIA' end num_guia,cg.id_estatus_guia stat,cs.DESC_ESTATUS,\n" +
            "case when cg.id_estatus_guia BETWEEN (10) and 30 then ch.pkidcajahdr else 0 end pkidcajahdr,ch.fkidestatus,ch.pedido pedido_caja,cd.olpn  \n" +
            "from info_cd.ce_control_guias cg \n" +
            "join info_cd.CE_ESTATUS_GUIA cs on cs.ID_ESTATUS_GUIA=cg.ID_ESTATUS_GUIA \n" +
            "join info_cd.ecom_caja_hdr ch on cg.ref_field_2=to_char(ch.pkidcajahdr) \n" +
            "join info_cd.ecom_caja_dtl cd on cd.fkidcajahdr=ch.pkidcajahdr \n" +
            "where 1=1 \n" +
            "and cg.ID_TIPO_PEDIDO = :tipPed \n" +
            "and cg.CD_ID = :idManh \n" +
            "and cd.olpn in (:olpn) \n" +
            "order by cd.olpn,cg.id_estatus_guia" ;
        Map<String, Object> parametros = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> fix = new ArrayList<>();
        try{
            parametros.put("olpn", contenido);
            parametros.put("idManh", idCentro);
            parametros.put("tipPed", idTipoPedido);
            return sccpConnection.queryForList(sql, parametros);
        }catch(Exception e){
            result.put("valid",false);
            result.put("message","No se pudo recuperar informacion de guia.");
            if(conf.isWriteAll())
                System.out.println("ERROR : "+e.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idCentro
                    , null
                    , contenido.get(0)
                    , 0
                    , 0
                    , null
                    , 0
                    , idTipoPedido
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            fix.add(result);
        }
        return fix;
    }

    @Override
    public boolean cancelTrknbr(String numGuia, int idCarrier, int tipoPedido) {
        String sql = "update info_cd.ce_control_guias cg set cg.id_estatus_guia = 99 \n" +
            " where cg.num_guia = :numguia \n" +
            " and id_estatus_guia = 10 \n" +
            " and id_tipo_pedido = :tipped \n" +
            " and id_carrier = :carrier";
        Map<String, Object> parametros = new HashMap<String, Object>();
        try{
            parametros.put("numguia",numGuia);
            parametros.put("tipped",tipoPedido);
            parametros.put("carrier",idCarrier);
            return sccpConnection.update(sql, parametros) > 0;
        }catch(Exception e){
            if(conf.isWriteAll())
                System.out.println("ERROR : "+e.getMessage()); 
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , 0
                    , null
                    , numGuia
                    , 0
                    , 0
                    , null
                    , 0
                    , tipoPedido
                    , e.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception ex){}
            return false;
        }
    }
    
}
