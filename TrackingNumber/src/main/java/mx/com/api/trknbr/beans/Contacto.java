/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

/**
 *
 * @author dparra
 */
public class Contacto {
    
    private String cp;
    private String direccion;
    private String nInt;
    private String nExt;
    private String ciudad;
    private String contacto;
    private String razonSocial;
    private String colonia;
    private String estado;
    private String idEstado;
    private String telefono;
    private boolean residencial;
    private String tienda;

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getnInt() {
        return nInt;
    }

    public void setnInt(String nInt) {
        this.nInt = nInt;
    }

    public String getnExt() {
        return nExt;
    }

    public void setnExt(String nExt) {
        this.nExt = nExt;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isResidencial() {
        return residencial;
    }

    public void setResidencial(boolean residencial) {
        this.residencial = residencial;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
}
