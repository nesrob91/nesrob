/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route;

/**
 *
 * @author nroblerol
 */
public enum Procesos {
    CREATE(1,"CREA_RUTA"),
    DOCUMENT(2,"DOCUMENTO_RUTA"),
    CANCEL(3,"CANCELA_RUTA"),
    UPDATE(4,"ACTUALIZA_RUTA"),
    STATUS(5,"ESTATUS_RUTA");
    
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
