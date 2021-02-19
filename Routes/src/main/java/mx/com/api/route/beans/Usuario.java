/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

/**
 *
 * @author nroblerol
 */
public class Usuario {
    private String USUARIO;
    private String PASS_WORD;
    private String NOMBRE;
    private String EMAIL;
    private String CLAVE_CD;
    private String ID_ROL;
    private String STATUS;

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASS_WORD() {
        return PASS_WORD;
    }

    public void setPASS_WORD(String PASS_WORD) {
        this.PASS_WORD = PASS_WORD;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getCLAVE_CD() {
        return CLAVE_CD;
    }

    public void setCLAVE_CD(String CLAVE_CD) {
        this.CLAVE_CD = CLAVE_CD;
    }

    public String getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(String ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
}
