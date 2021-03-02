/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.elektra.util.Conexion;

import com.elektra.beans.CredencialesTrackingCarssa;
import com.elektra.beans.CredencialesTrackingDhl;
import com.elektra.beans.CredencialesTrackingEstafeta;
import com.elektra.beans.CredencialesTrackingFedex;
import com.elektra.beans.CredencialesTrackingPaquetexpress;
import com.elektra.beans.CredencialesTrackingTracusa;
import com.elektra.beans.CredencialesTrackingPalex;

/**
 *
 * @author dparra
 */
public class CredencialesDaoImpl implements CredencialesDao{
    
    Conexion con = new Conexion();
    
    @Override
    public CredencialesTrackingEstafeta getCredencialesTrackingEstafeta(int idCarrier, int idServicio) {
        CredencialesTrackingEstafeta credencialesTrackingEstafeta = new CredencialesTrackingEstafeta();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    " SELECT USUARIO "
                            + " , CONTRASENIA "
                            + " , ID_SUSCRIPTOR "
                            + " , 'L' TYPE "
                            + " , 'G' WAYBILL_TYPE "
                            + " , 'LAST_EVENT' HISTORY_TYPE " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =   ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                credencialesTrackingEstafeta.setUsuario(rs.getString("USUARIO"));
                credencialesTrackingEstafeta.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesTrackingEstafeta.setIdSuscriptor(rs.getString("iD_SUSCRIPTOR"));
                credencialesTrackingEstafeta.setType(rs.getString("TYPE"));
                credencialesTrackingEstafeta.setWaybillType(rs.getString("WAYBILL_TYPE"));
                credencialesTrackingEstafeta.setHistoryType(rs.getString("HISTORY_TYPE"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingEstafeta;
         }
        
        
    }

    @Override
    public CredencialesTrackingDhl getCredencialesTrackingDhl(int idCarrier, int idServicio) {
        CredencialesTrackingDhl credencialesTrackingDhl = new CredencialesTrackingDhl();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    " SELECT TO_CHAR(CURRENT_TIMESTAMP,'YYYY-MM-DD\"T\"HH24:MI:SS.FF3')||'-06:00' MESSAGE_TIME "
                            + " ,  '0123456789'||TO_CHAR(CURRENT_TIMESTAMP,'YYYYMMDDHH24MISSFF3') MESSAGE_REFERENECE "
                            + " ,  USUARIO, CONTRASENIA "
                            + " , 'EN' AS LANGUAGE_CODE "
                            + " , 'LAST_CHECK_POINT_ONLY' AS LEVEL_OF_DETAILS "
                            + " , REF_FIELD_1 AS URL " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =   ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                credencialesTrackingDhl.setMessageTime(rs.getString("MESSAGE_TIME"));
                credencialesTrackingDhl.setMesageReference(rs.getString("MESSAGE_REFERENECE"));
                credencialesTrackingDhl.setUsuario(rs.getString("USUARIO"));
                credencialesTrackingDhl.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesTrackingDhl.setLanguajeCode(rs.getString("LANGUAGE_CODE"));
                credencialesTrackingDhl.setLevelOfDetails(rs.getString("LEVEL_OF_DETAILS"));
                credencialesTrackingDhl.setUrl(rs.getString("URL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingDhl;
         }
        
    }

    @Override
    public CredencialesTrackingCarssa getCredencialesTrackingCarssa(int idCarrier, int idServicio) {
        CredencialesTrackingCarssa credencialesTrackingCarssa = new CredencialesTrackingCarssa();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    " SELECT USUARIO"
                            + " , CONTRASENIA"
                            + " , NUMCTE AS CTRL " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS "
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =   ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                credencialesTrackingCarssa.setUsuario(rs.getString("USUARIO"));
                credencialesTrackingCarssa.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesTrackingCarssa.setCtrl(rs.getString("CTRL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingCarssa;
         }
    }
    
    @Override
    public CredencialesTrackingFedex getCredencialesTrackingFedex(int idCarrier, int idServicio){
        CredencialesTrackingFedex credencialesTrackingFedex = new CredencialesTrackingFedex();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    " SELECT USUARIO KEY "
                            + " , CONTRASENIA PASSWORD "
                            + " , NUMCTE ACCOUNT_NUMBER "
                            + " , 'ES' LANGUAGE_CODE "
                            + " , 'MX' LOCAL_CODE "
                            + " , ID_SUSCRIPTOR METER_NUMBER "
                            + " , SERVICE_TYPE_DOC_RET SERVICE_ID "
                            + " , 'TRACKING_NUMBER_OR_DOORTAG' TYPE "
                            + " , REF_FIELD_3 MAJOR "
                            + " , '0' INTERMEDIATE "
                            + " , '0' MINOR " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =   ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                credencialesTrackingFedex.setKey(rs.getString("KEY"));
                credencialesTrackingFedex.setPassword(rs.getString("PASSWORD"));
                credencialesTrackingFedex.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                credencialesTrackingFedex.setLanguageCode(rs.getString("LANGUAGE_CODE"));
                credencialesTrackingFedex.setLocalCode(rs.getString("LOCAL_CODE"));
                credencialesTrackingFedex.setMeterNumber(rs.getString("METER_NUMBER"));
                credencialesTrackingFedex.setServiceId(rs.getString("SERVICE_ID"));
                credencialesTrackingFedex.setType(rs.getString("TYPE"));
                credencialesTrackingFedex.setMajor(rs.getString("MAJOR"));
                credencialesTrackingFedex.setIntermediate(rs.getString("INTERMEDIATE"));
                credencialesTrackingFedex.setMinor(rs.getString("MINOR"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingFedex;
         }
    }
    
    @Override
    public CredencialesTrackingPaquetexpress getCredencialesTrackingPaquetexpress(int idCarrier, int idServicio){
        CredencialesTrackingPaquetexpress credencialesTrackingPaquetexpress = new CredencialesTrackingPaquetexpress();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    " SELECT USUARIO ORGN_SYSTEM " 
                            + " , CONTRASENIA AGREEMENT_KEY " 
                            + " , SERVICE_TYPE TYPE_EVENT " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =    ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                credencialesTrackingPaquetexpress.setOrgnSystem(rs.getString("ORGN_SYSTEM"));
                credencialesTrackingPaquetexpress.setAgreementKey(rs.getString("AGREEMENT_KEY"));
                credencialesTrackingPaquetexpress.setTypeEvent(rs.getString("TYPE_EVENT"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingPaquetexpress;
         }
    }
    
    @Override
    public CredencialesTrackingPalex getCredencialesTrackingPalex(int idCarrier, int idServicio){
        
        CredencialesTrackingPalex credencialesTrackingPalex = new CredencialesTrackingPalex();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    "SELECT USUARIO " 
                            + " , CONTRASENIA " 
                            + " , REF_FIELD_1 URL " 
                            + " , REF_FIELD_3 PATH " 
                            + " , NUMCTE CUENTA " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =    ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                credencialesTrackingPalex.setUsuario(rs.getString("USUARIO"));
                credencialesTrackingPalex.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesTrackingPalex.setUrl(rs.getString("URL"));
                credencialesTrackingPalex.setPath(rs.getString("PATH"));
                credencialesTrackingPalex.setCuenta(rs.getString("CUENTA"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingPalex;
         }
    }

	@Override
	public CredencialesTrackingTracusa getCredencialesTrackingTracusa(int idCarrier, int idServicio) {
		CredencialesTrackingTracusa credencialesTrackingTracusa = new CredencialesTrackingTracusa();
        PreparedStatement stmt = null;
         try {
            this.con.startConexion();
            stmt = this.con.getConexion().prepareStatement(
                    "SELECT USUARIO " 
                            + " , CONTRASENIA " 
                            + " , REF_FIELD_1 URL " 
                            + " , REF_FIELD_3 PATH " 
                            + " , NUMCTE CUENTA " 
                            + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                            + " WHERE ID_CARRIER =   ?   " 
                            + " AND ID_SERVICIO =    ?   " 
            );
            
            stmt.setInt(1, idCarrier);
            stmt.setInt(2, idServicio);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
            	credencialesTrackingTracusa.setUsuario(rs.getString("USUARIO"));
            	credencialesTrackingTracusa.setContrasenia(rs.getString("CONTRASENIA"));
            	credencialesTrackingTracusa.setUrl(rs.getString("URL"));
            	credencialesTrackingTracusa.setPath(rs.getString("PATH"));
            	credencialesTrackingTracusa.setCuenta(rs.getString("CUENTA"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             this.con.endConnection();
             return credencialesTrackingTracusa;
         }
	}

}
