/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.ws;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
//import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

/**
 *
 * @author DPARRA
 */
public class RestUtil {
    
    public String consumeWsRestPostBasicAuth(String url, String authentication, String tipoEnvio, String input, int success) {
        
        String output = "";
        
        try {

            //ClientConfig config = new ClientConfig();
            //config.connectorProvider(new ApacheConnectorProvider());
            //config.register(JacksonJsonProvider.class);
            //Client client = ClientBuilder.newClient(config);
            Client client = Client.create();
            
            WebResource webResource = client.resource(url);
            /*
            ClientResponse resp = webResource.accept(tipoEnvio)
                    .header("Authorization", "Basic " + authentication)
                    .post(ClientResponse.class, input);
            */
            ClientResponse resp = webResource//.accept(tipoEnvio)
                    .type(tipoEnvio)
                    .header("Authorization", "Basic " + authentication)
                    .post(ClientResponse.class, input);
            
            
            if(resp.getStatus() == success){
                output = resp.getEntity(String.class);                
            }
            
            else if(resp.getStatus() == 401){
                output = "EKT-ERROR: [\n" +
                                            "{\"msgNo\":\""+resp.getStatus() + ". " + resp.getStatusInfo()+"\",\"msg\":\""+resp.getStatus() + ". " + resp.getStatusInfo()+"\"}\n" +
                                        "]";
            }

            else{
                output = "EKT-ERROR: " + resp.getEntity(String.class);
            }
            
            
            
        } catch (Exception e) {
            output = "EKT-ERROR: [\n" +
                                            "{\"msgNo\":\""+e.getMessage()+"\",\"msg\":\""+e.getMessage()+"\"}\n" +
                                        "]";
        }
        
        return output;
    }
    
    
    public String getJsonFromObject(Object object) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Sin formato
            //json = mapper.writeValueAsString(object);
            // con formato
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

        } catch (JsonGenerationException | JsonMappingException e) {
            json = "ECOM-Excepci�n: " + e.getMessage();
        } catch (IOException e) {
            json = "EKT-ERROR: " + e.getMessage();
        }
        return json;
    }
    
    public String encode64(String texto) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }

    public String decode64(String texto) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(texto);
        return new String(decodedByteArray);
    }
    
    public String getValorJson(String json, String tag) throws Exception{
        JSONObject jsonObject = new JSONObject(json);
        return (String) jsonObject.get(tag);
    }
    
    public List<LinkedHashMap> getValoresJson(String json) throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap> listas = mapper.readValue(json, List.class);
        
        return listas;
    }
}
