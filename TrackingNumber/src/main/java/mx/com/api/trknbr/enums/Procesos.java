/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.enums;

/**
 *
 * @author nroblerol
 */
public enum Procesos {
    CREATE(1,"CREA_GUIA"),
    DOCUMENT(2,"DOCUMENTO_GUIA"),
    CANCEL(3,"CANCELA_GUIA"),
    UPDATE(4,"ACTUALIZA_GUIA"),
    STATUS(5,"ESTATUS_GUIA");
    
    private int idProceso;
    private String descProceso;

    private Procesos(int idProceso, String descProceso) {
        this.idProceso = idProceso;
        this.descProceso = descProceso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public String getDescProceso() {
        return descProceso;
    }
    
    
}
