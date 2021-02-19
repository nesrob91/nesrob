/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.ws;

import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author dparra
 */
public class XmlUtil {
    
    public String getXmlByObject(Object object) {
        String xmlString = null;
        try {
            ByteArrayOutputStream in = new ByteArrayOutputStream();
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            in = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(object, in);
            xmlString = new String(in.toByteArray());

        } catch (JAXBException ex) {
            System.out.print("");
        }
        return xmlString;
    }
}
