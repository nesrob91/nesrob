/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
package com.elektra.cadsumutils.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * * * @author dparra
 */
public class DHLClient {

    String result = "";
    String requestMessagePath = "";
    String httpURL = "";

    public DHLClient() {

    }

    public String ejecutar(String requestMessagePath, String httpURL, String proxy) {

        try {

            /**
             * XML PI 5.0 - To support 3DNS Fail Over/Fall Back scenarios -
             * START
             */
            result = processDHLClient(requestMessagePath, httpURL, proxy);

            /**
             * XML PI 5.0 - To support 3DNS Fail Over/Fall Back scenarios -
             * START
             */
        } catch (MalformedURLException mfURLex) {
            System.out.println("MalformedURLException " + mfURLex.getMessage());
            mfURLex.printStackTrace();
        } catch (IOException e) {
            
            long timeToSleep = 6000;
            try {
                
                flushDNS();
                Thread.sleep(timeToSleep);
                
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            for (int i = 1; i <= 3; i++) {
                System.out.println("RETRY =========> " + i);
                try {
                    processDHLClient(requestMessagePath, httpURL, proxy);
                    break;
                } catch (MalformedURLException mfURLex) {
                    System.out.println("MalformedURLException " + mfURLex.getMessage());
                    continue;
                } catch (IOException ioe) {
                    System.out.println("IOException " + ioe.getMessage() + "\n");
                    if (i == 3) {
                        System.out.println("=================    Three (3) retries are done - please contact DHL Support Team       ======================\n");
                    }
                    continue;
                }

            }

            /**
             *
             * XML PI 5.0 - To support 3DNS Fail Over/Fall Back scenarios -
             *
             * COMPLETED
             *
             */
        }

        return result;

    }

    public String processDHLClient(String requestMessagePath, String httpURL, String proxy) throws IOException {
        if(proxy != null && !proxy.equals("")){
            String ipProxy = proxy;
            System.setProperty("http.proxyHost", ipProxy);
            System.setProperty("http.proxyPort", "8080");
            System.setProperty("https.proxyHost", ipProxy);
            System.setProperty("https.proxyPort", "8080");
        }

        //Preparing file inputstream from a file    
        String clientRequestXML = requestMessagePath;
        URL servletURL = null;
        String query = "isUTF8Support=true";
        servletURL = new URL(httpURL + "?" + query);

        HttpURLConnection servletConnection = null;
        servletConnection = (HttpURLConnection) servletURL.openConnection();
        servletConnection.setDoOutput(true);
        servletConnection.setDoInput(true);
        servletConnection.setUseCaches(false);
        servletConnection.setRequestMethod("POST");
        servletConnection.setRequestProperty("Content-Type", "text/html");
        servletConnection.setRequestProperty("Accept-Charset", "UTF-8");
        String len = Integer.toString(clientRequestXML.getBytes().length);
        servletConnection.setRequestProperty("Content-Length", len);
        servletConnection.connect();

        OutputStreamWriter wr = null;
        wr = new OutputStreamWriter(servletConnection.getOutputStream(), "UTF8");
        wr.write(clientRequestXML);
        wr.flush();
        wr.close();
        InputStreamReader isr = null;
        isr = new InputStreamReader(servletConnection.getInputStream(), "UTF8");

        java.io.BufferedReader rd = new java.io.BufferedReader(isr);
        StringBuilder result = new StringBuilder();
        String line = "";

        while ((line = rd.readLine()) != null) {
            result.append(line).append("\n");
        }
        return result.toString();

    }

    private static void flushDNS() {

        String OSName = getOSName();
        if ("MAC".equals(OSName)) {

            String command = "dscacheutil -flushcache";
            String macOSxResponseText = runCommand(command);
            command = "lookupd -flushcache";
            String macOSxLResponseText = runCommand(command);

        } else if ("WINDOWS".equalsIgnoreCase(OSName)) {

            String command = "ipconfig /flushdns";
            String windowsResponseText = runCommand(command);
            System.out.println("WINDOWS OS ->  " + command + "  -> " + windowsResponseText + "\n");

        } else if ("UX".equalsIgnoreCase(OSName)) {

            String command = "nscd -I hosts";
            String linuxResponseText = runCommand(command);
            command = "dnsmasq restart";
            linuxResponseText = runCommand(command);
            command = "rndc restart";
            linuxResponseText = runCommand(command);

        }

    }

    private static String runCommand(String command) {

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            InputStream inputStream = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            int ilength = inputStream.available();
            char[] c = new char[ilength];
            int i = reader.read(c);
            String responseText = new String(c);
            return responseText;

        } catch (Exception e) {
            return "FLUSHDNS cannot be completed";
        }

    }

    private static String getOSName() {

        String OS = System.getProperty("os.name", "generic").toLowerCase();

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            return "MAC";
        } else if (OS.indexOf("win") >= 0) {
            return "WINDOWS";
        } else if (OS.indexOf("ux") >= 0) {
            return "UX";
        } else {
            return "OTHERS";
        }

    }

}
