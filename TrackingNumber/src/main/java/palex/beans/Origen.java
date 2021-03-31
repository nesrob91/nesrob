/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palex.beans;

import java.util.List;

/**
 *
 * @author DPARRA
 */
public class Origen {
    
    private String Remitente;
    private Domicilio domicilio;
    private List<Telefonos> telefonos;
    String Email;
    String Referencia;

    public String getRemitente() {
        return Remitente;
    }

    public void setRemitente(String Remitente) {
        this.Remitente = Remitente;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Telefonos> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefonos> telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }
    
    
    
   }
