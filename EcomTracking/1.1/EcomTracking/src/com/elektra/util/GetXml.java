/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.util;

import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author dparra
 */
public class GetXml {
    
    
    
    public String getMensajeXml(Object clase, Object objeto){
        JAXBContext jaxbContext;
        ByteArrayOutputStream in = new ByteArrayOutputStream();
        String mensaje = "";
            try {
                    jaxbContext = JAXBContext.newInstance(clase.getClass());
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    in = new ByteArrayOutputStream();
                    jaxbMarshaller.marshal(objeto, in);
                    mensaje = new String(in.toByteArray());


                } catch (JAXBException ex) {
                    System.out.println("Excepción: " + ex.toString());
                }
            return mensaje;
    }
    
    
}
