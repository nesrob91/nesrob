/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.ws;

/**
 *
 * @author nroblerol
 */
public class UrlBeanUtil {

    public String path;
    public String host;
    public String port;
    public String context;
    public boolean error;

    public void printValues() {
        System.out.println("path " + path);
        System.out.println("host " + host);
        System.out.println("port " + port);
        System.out.println("ctx " + context);
    }

}
