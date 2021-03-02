/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.ws;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author dparra
 */
public class GetNodes {

    protected String string = "";
    protected String[] valor = null;

    public String getstring() {
        return string;
    }

    public void setstring(String val) {
        string = val;
    }

    public String[] getvalor() {
        return valor;
    }

    public void setvalor(String[] val) {
        valor = val;
    }

    /**
     *
     * **** END SET/GET METHOD, DO NOT MODIFY ****
     *
     */
    public GetNodes() {

    }

    public List<String> getNodes(List<String> nodos) {
        //valor = new String[]{getNodeValue("ActionStatus"), getNodeValue("ConditionData"), getNodeValue("EventCode")};

        try {

            List<String> valores = new ArrayList<>();

            for (int i = 0; i < nodos.size(); i++) {
                valores.add(getNodeValue(nodos.get(i)));
            }

            return valores;

        } catch (Exception e) {

            System.out.println("Excepcion: " + e.toString());
            return null;

        }

    }

    public String getNodeValue(String nodo) throws SAXException, IOException, ParserConfigurationException {

        NodeList responseNodes = null;
        String valorNodo = "";

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlResponse;
            xmlResponse = builder.parse(new InputSource(new StringReader(string)));
            Element respuesta = xmlResponse.getDocumentElement();
            responseNodes = respuesta.getElementsByTagName(nodo);
            Element valor = (Element) responseNodes.item(0);

            if (responseNodes != null && responseNodes.getLength() > 0) {

                for (int i = 0; i < responseNodes.getLength(); i++) {

                    valor = (Element) responseNodes.item(i);

                    if (valor.getFirstChild() != null) {
                        valorNodo = valor.getFirstChild().getNodeValue();
                    }
                }

            }

        } catch (NullPointerException exception) {
            System.err.println("ExcepciÃ³n: " + exception);
            return "Excepcion";
        }
        return valorNodo;
    }
}
