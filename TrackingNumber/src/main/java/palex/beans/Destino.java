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
public class Destino {
    
    private String Destinatario;
    private String Destinatario2;
    private Domicilio domicilio;
    private List<Telefonos> telefonos;
    private String Email;
    private String Referencia;

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public String getDestinatario2() {
        return Destinatario2;
    }

    public void setDestinatario2(String Destinatario2) {
        this.Destinatario2 = Destinatario2;
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
