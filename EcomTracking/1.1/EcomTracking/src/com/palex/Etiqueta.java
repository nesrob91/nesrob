package com.palex;

import com.elektra.util.UtilRest;

/**
 *
 * @author DPARRA
 */
public class Etiqueta {
    public static void main(String[] args) {
        UtilRest utilRest = new UtilRest();
        
        String authentication = "";
            authentication = utilRest.encode64("demows100:demoasdWs#100");
            
        String etiquetaRequest = 
                    "{\n" 
                        + "	\"Guia\" : \"262008250017\",\n" 
                        + "	\"TipoImpresion\" : 3 \n " 
                    + "}";
        
        String RESPONSE = utilRest.consumeWsRestPostBasicAuth("http://tpak.dyndns.ws:1051/ws/api/Documentacion/EtiquetaEnvio", authentication, "application/json", etiquetaRequest, "", 200
        );
        
        System.out.println(RESPONSE);
    }
    
    public String getEtiqueta(String json){
        return "";
    }
}
