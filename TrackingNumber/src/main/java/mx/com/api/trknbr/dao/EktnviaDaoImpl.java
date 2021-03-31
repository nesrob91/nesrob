/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import mx.com.api.trknbr.beans.DatosEktnvia;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.logging.log4j.LogManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("ektnviaDao")
public class EktnviaDaoImpl implements EktnviaDao{
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    private final NamedParameterJdbcTemplate namedTemplate2010 = new DataSources().namedTemplate2010();
    
    @Override
    public Object getEktnviaRequest(GuiaRequest request){
        try {

            String query = " SELECT DISTINCT A. PEDIDO "
                    + " , A.ORDER_ID "
                    + " , A.CD_ID "
                    + " , A.ID_CARRIER "
                    + " , CEIL(A.LARGO) LARGO "
                    + " , CEIL(A.ANCHO) ANCHO "
                    + " , CEIL(A.ALTO) ALTO "
                    + " , CEIL(A.PESO) PESO "
                    + " , A.CP_ORIGEN "
                    + " , substr(A.DIRECCION_ORIGEN, 1, 29) DIRECCION_ORIGEN "
                    + " , substr(A.CIUDAD_ORIGEN, 1, 29) CIUDAD_ORIGEN "
                    + " , substr(A.CONTACTO_ORIGEN, 1, 29) CONTACTO_ORIGEN "
                    + " , NVL( ELEK.TELEFONO_CARRIER, '00000000000')TELEFONO_ORIGEN "
                    + " , substr(A.RAZ_SOC_ORIGEN, 1, 29) RAZ_SOC_ORIGEN "
                    + " , substr(A.COLONIA_ORIGEN, 1, 29) COLONIA_ORIGEN "
                    + " , substr(A.ESTADO_ORIGEN, 1, 29)ESTADO_ORIGEN "
                    + " , A.ID_ESTADO_ORIGEN, 0 RESIDENCIAL_ORIGEN  "
                    + " , A.CP_DESTINO "
                    + " , substr(P.CALLE, 1, 29)DIRECCION_DESTINO "
                    + " , substr(A.CIUDAD_DESTINO, 1, 29)CIUDAD_DESTINO "
                    + " , substr(A.CONTACTO_DESTINO, 1, 29)CONTACTO_DESTINO "
                    + " , NVL( REPLACE(P.TELEFONO,'+',''), '00000000000')TELEFONO_DESTINO "
                    + " , substr(A.RAZON_SOC_DESTINO, 1, 29) RAZON_SOC_DESTINO "
                    + " , substr(UPPER(A.COLONIA_DESTINO), 1, 29) COLONIA_DESTINO "
                    + " , substr(A.ESTADO_DESTINO, 1, 29) ESTADO_DESTINO "
                    + " , A.ID_ESTADO_DESTINO, 1 RESIDENCIAL_DESTINO  "
                    + " , 'MEXICO' PAIS_1 "
                    + " , 'MEX' PAIS_2 "
                    + " , 'MX' PAIS_3 "
                    + " , TO_CHAR(SYSDATE, 'DD/MM/YYYY') REMESA "
                    + " , (SELECT G.GRPMH FROM INFO_CD.E3ALTWHS G WHERE ALMMN = A.CD_ID) GRUPO "
                    + " , A.REF_FIELD_2 "
                    + " , P.TELCEL "
                    + " , P.DELEGAC "
                    + " , P.NUMERO "
                    + " , P.NUMERINT "
                    + " , CASE WHEN CONTRAS LIKE'v%' THEN CONTRAS ELSE '' END PVTEX "
                    + " , nvl(ccu.ubicacion,'NA') ubicacion "
                    + " , nvl(p.observa,'NA') observaciones  "
                    + " FROM INFO_CD.CE_CONTROL_GUIAS A "
                    + " JOIN INFO_CD.PED_CENT P ON A.CD_ID = P.WHSE AND CONTRAS = :so  "
                    + " JOIN INFO_CD.CE_CAT_CARRIERS ELEK ON ELEK.ID_CARRIER = 1 "
                    + " left join info_cd.ce_rel_ubicacion_cp cps on LPAD(cps.cp, 8, '0') = LPAD(a.cp_destino, 8, '0') and id_estacion = :idEstacion and cps.id_estatus = 1 "
                    + " left join info_cd.ce_cat_ubicacion ccu on ccu.id_estacion = cps.id_estacion and ccu.id_ubicacion = cps.id_ubicacion and ccu.id_estatus = 1 "
                    + " WHERE A.ID_ESTATUS_GUIA = 5  "
                    + " AND A.CD_ID = :idManh "
                    + " AND A.REF_FIELD_2 = :idCaja "
                    + " AND ROWNUM < 2";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("so", request.getVtex());
            parametros.put("idEstacion", request.getIdEstacion());
            parametros.put("idManh", request.getIdManh());
            parametros.put("idCaja", request.getIdCaja());

            return namedTemplate2010.queryForObject(query, parametros, new DatosGuiasMapper());

        } catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            try{
                logger.insertaError(1010000, 10, request.getIdManh(), 0, request.getPedido(), request.getIdCaja(), 11, "", 1, request.getIdTipoPedido(), 
                    ex.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception el){}
            return null;
        }
    }
    
    @Override
    public String getNumGuia(int idManh, int idCaja, String pedido,int idTipoPedido, String idUsuario){
        String query = "select 'EKT' || LPAD(info_cd.ce_ecom_guias.nextval, 15, '0') GUIA from dual"; 
        try {
            return namedTemplate2010.queryForObject(query, new HashMap<String, Object>(), String.class);
        } catch(EmptyResultDataAccessException empty){
            if(conf.isWriteAll())
                System.out.println("Error : "+empty.getMessage());
            return null;
        }catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            try{
                logger.insertaError(1010000, 10, idManh, 0, pedido, idCaja, 11, "", 1, idTipoPedido, ex.getMessage(), 
                    getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), ""+idUsuario);
                
            }catch(Exception e){}
            return null;
        } 
    }
    
    public static final class DatosGuiasMapper implements RowMapper<DatosEktnvia> {

        @Override
        public DatosEktnvia mapRow(ResultSet rs, int i) throws SQLException {

            DatosEktnvia datosGuias = new DatosEktnvia();

                datosGuias.setPedido(rs.getString("PEDIDO"));
                datosGuias.setOrderId(rs.getString("ORDER_ID"));
                datosGuias.setCdId(rs.getInt("CD_ID"));
                datosGuias.setIdCarrier(rs.getInt("ID_CARRIER"));
                datosGuias.setLargo(rs.getInt("LARGO"));
                datosGuias.setAncho(rs.getDouble("ANCHO"));
                datosGuias.setAlto(rs.getDouble("ALTO"));
                datosGuias.setPeso(rs.getDouble("PESO"));
                datosGuias.setCpOrigen(rs.getString("CP_ORIGEN"));
                datosGuias.setDireccionOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("DIRECCION_ORIGEN")));
                datosGuias.setCiudadOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("CIUDAD_ORIGEN")));
                datosGuias.setContactoOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("CONTACTO_ORIGEN")));
                datosGuias.setRazSocOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("RAZ_SOC_ORIGEN")));
                datosGuias.setColoniaOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("COLONIA_ORIGEN")));
                datosGuias.setEstadoOrigen(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("ESTADO_ORIGEN")));
                datosGuias.setIdEstadoOrigen(rs.getString("ID_ESTADO_ORIGEN"));
                datosGuias.setResidencialOrigen(rs.getBoolean("RESIDENCIAL_ORIGEN"));
                datosGuias.setTelefonoOrigen(rs.getString("TELEFONO_ORIGEN"));
                datosGuias.setCpDestino(rs.getString("CP_DESTINO"));
                datosGuias.setDireccionDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("DIRECCION_DESTINO")));
                datosGuias.setCiudadDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("CIUDAD_DESTINO")));
                datosGuias.setContactoDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("CONTACTO_DESTINO")));
                datosGuias.setRazSocDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("RAZON_SOC_DESTINO")));
                datosGuias.setColoniaDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("COLONIA_DESTINO")));
                datosGuias.setEstadoDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("ESTADO_DESTINO")));
                datosGuias.setIdEstadoDestino(rs.getString("ID_ESTADO_DESTINO"));
                datosGuias.setResidencialDestino(rs.getBoolean("RESIDENCIAL_DESTINO"));
                datosGuias.setTelefonoDestino(rs.getString("TELEFONO_DESTINO"));
                datosGuias.setPais1(rs.getString("PAIS_1"));
                datosGuias.setPais2(rs.getString("PAIS_2"));
                datosGuias.setPais3(rs.getString("PAIS_3"));
                datosGuias.setRemesa(rs.getString("REMESA"));
                datosGuias.setGrupo(rs.getString("GRUPO"));
                datosGuias.setIdCaja(rs.getInt("REF_FIELD_2"));
                datosGuias.setnExtDestino(rs.getString("NUMERO"));
                datosGuias.setnIntDestino(rs.getString("NUMERINT"));
                datosGuias.setTelefonoCelDestino(rs.getString("TELCEL"));
                datosGuias.setDeleagacionDestino(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("DELEGAC")));
                datosGuias.setPedidoVtex(rs.getString("PVTEX"));
                datosGuias.setUbicacion(rs.getString("UBICACION"));
                datosGuias.setObservaciones(org.apache.commons.lang3.StringUtils.stripAccents(rs.getString("OBSERVACIONES")));
            return datosGuias;

        }

    }
}
