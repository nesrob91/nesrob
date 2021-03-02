package com.elektra.util;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * 
 * @author nroblerol
 */

public class Conexion  {
    
    private Properties props=new Properties();
    private Properties propsBD=new Properties();
    private Connection conn = null;
    private boolean desarrollo ;
    private final String BD_CONFIGURACION = "cadsum.properties";
    private final String ARCHIVO_CONFIGURACION = "tracking.properties";
    private boolean fromProps=false;
    
    public Conexion(){
        try{
            props.load(new FileReader(new File(ARCHIVO_CONFIGURACION)));
            propsBD.load(new FileReader(new File(BD_CONFIGURACION)));
            desarrollo = Boolean.getBoolean(props.getProperty("tracking.writeactions"));
            fromProps=true;
        }catch(Exception e){
            System.out.println("  paqueterias | loadProperties | Excepcion:   " + e.toString());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            //System.exit(0);
            fromProps=false;
        }
        desarrollo=false;
    }
    
    public Connection getConexion() {
        return this.conn;
       
    }
    
    public void startConexion() {

        if (desarrollo) {
            System.out.println("Comenzando conexion DAO");
        }
        
        try {
            if(fromProps){
                if(props.containsKey("tracking.app.env") && props.getProperty("tracking.app.env").equalsIgnoreCase("QA")){
                    Class.forName(propsBD.getProperty("cadsum.bd.qa.drivername"));
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection(propsBD.getProperty("cadsum.bd.qa.url"), propsBD.getProperty("cadsum.bd.qa.user"),propsBD.getProperty("cadsum.bd.qa.pswd"));
                    conn.setAutoCommit(false);
                }else{
                    Class.forName(propsBD.getProperty("cadsum.bd.prod.drivername"));
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection(propsBD.getProperty("cadsum.bd.prod.url"),propsBD.getProperty("cadsum.bd.prod.user"),propsBD.getProperty("cadsum.bd.prod.pswd"));
                    conn.setAutoCommit(false);
                }
            }else{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                conn = DriverManager.getConnection("","","");
                conn.setAutoCommit(false);
            }
        } catch (Exception ex) {
            System.out.println("  paqueterias |startConexion | Excepcion:   " + ex.toString());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void endConnection() {
        if (desarrollo) {
            System.out.println("Cerrando conexion DAO");
        }

        try {
            this.conn.commit();
            this.conn.close();
        } catch (Exception ex) {
            System.out.println("  paqueterias |endConnection | Excepcion:   " + ex.toString());
        }
    }
    
}