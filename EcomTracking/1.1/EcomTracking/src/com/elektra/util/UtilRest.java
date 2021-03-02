package com.elektra.util;

/**
*
* @author dparra
*/
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.xml.bind.DatatypeConverter;

/**
*
* @author DPARRA
*/
public class UtilRest {
   
   public String consumeWsRestPostBasicAuth(String url, String authentication, String tipoEnvio, String input, String proxy, int success) {
       
	   String ipProxy = proxy;	   
       //String ipProxy = "10.50.8.21";
       //System.setProperty("java.net.useSystemProxies", "true");
       System.setProperty("http.proxyHost", "10.50.8.20");
       System.setProperty("http.proxyPort", "8080");       
       System.setProperty("https.proxyHost", "10.50.8.20");
       System.setProperty("https.proxyPort", "8080");
       System.setProperty("https.proxyUser","ELEKTRA\\NROBLEROL");
       System.setProperty("https.proxyPassword","Wasdx7391qwerty");
       
       String output = "";
       
       try {
           //Client client = Client.create();          
           //url = "http://apilogistica.sytes.net:8180/rest-tracusa-logistica/vI/shipment/getShipmentTracking/000000000296725";//QA
           //url = "https://www.tracusalogistica.com.mx/rest-tracusa-logistica/vI/shipment/getShipmentTracking/000000000583305";//PROD
           //authentication ="dHJhY3VzYTpwYXNzd29yZEFkbWluLVRSUw==";//QA
           //authentication ="QFBJRUxFS1RSQDE6TG9naXN0aWNhVFJTQEFwaWVsZWsjMjA=";//PROD
           //WebResource webResource = client.resource(url);
           //System.out.println(url);
           
           //ClientResponse resp = webResource.accept(tipoEnvio)
             //      .header("Authorization", "Basic " + authentication)
               //    .post(ClientResponse.class, input);
           
           //ClientResponse resp = webResource//.accept(tipoEnvio)
                   //.type(tipoEnvio)
             //      .header("Authorization", "Basic " + authentication)
               //    .post(ClientResponse.class);//, input);
           
        
        URL servletURL = null;
        servletURL = new URL(url);

        HttpsURLConnection servletConnection = null;
        servletConnection = (HttpsURLConnection) servletURL.openConnection();
        servletConnection.setDoOutput(true);
        //servletConnection.setDoInput(true);
        servletConnection.setUseCaches(false);
        servletConnection.setRequestMethod("POST");
           //System.out.println(resp.getStatus());
        servletConnection.setRequestProperty("Authorization",  "Basic " + authentication);

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };
        HostnameVerifier trustAllHostnames = new HostnameVerifier(){
            @Override
            public boolean verify(String hostname, SSLSession session) { 
                return true; // Just allow them all. 
            };
        };
        SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
        servletConnection.setHostnameVerifier(trustAllHostnames);
        servletConnection.setSSLSocketFactory(sc.getSocketFactory());
        
        servletConnection.connect();



        InputStreamReader isr = null;
                
           //if(resp.getStatus() == success){
           if(servletConnection.getResponseCode() == success){
               isr = new InputStreamReader(servletConnection.getInputStream(), "UTF8");

                    BufferedReader rd = new BufferedReader(isr);
                    StringBuilder result = new StringBuilder();
                    String line = "";
               while ((line = rd.readLine()) != null) {
                    result.append(line).append("\n");
                }
               //output = resp.getEntity(String.class);       
               output = result.toString();
               //System.out.println(output);
           }
           
           //else if(resp.getStatus() == 401){
             //  output = "ECOM-Excepción: [\n" +
               //                            "{\"msgNo\":\""+resp.getStatus() + ". " + resp.getStatusInfo()+"\",\"msg\":\""+resp.getStatus() + ". " + resp.getStatusInfo()+"\"}\n" +
                 //                      "]";               
           //}

           else{
               output = "ECOM-Excepción: " + servletConnection.getResponseMessage();//resp.getEntity(String.class);
           }
           
           
           
       } catch (Exception e) {
    	   System.out.println(e.getMessage());
           output = "ECOM-Excepción:" +// [\n" +
                                           "{\"msgNo\":\""+e.getMessage()+"\",\"msg\":\""+e.getMessage()+"\"}\n" ;//+
                                      // "]";
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
           json = "ECOM-Excepción: " + e.getMessage();
       } catch (IOException e) {
           json = "ECOM-Excepción: " + e.getMessage();
       }
       return json;
   }
   
   public String encode64(String texto) {
	   return DatatypeConverter.printBase64Binary(texto.getBytes(StandardCharsets.UTF_8));
   }

   public String decode64(String texto) {
	   return new String(DatatypeConverter.parseBase64Binary(texto));
   }
   
}
