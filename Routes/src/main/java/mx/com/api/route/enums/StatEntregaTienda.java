/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.enums;

/**
 *
 * @author nroblerol
 */
public enum StatEntregaTienda {
    CREADO(1,"RUTA CREADA"),
    ENVIADO(2,"ENVIADO A TIENDA"),
    ENTREGADO(3,"ENTREGADO EN TIENDA"),
    RECHAZO(4,"RECHAZO EN TIENDA"),
    NO_ENCONTRADO(5,"NO ENCONTRADO"),
    CANCELADO(6,"CANCELADO");
    
    private int idStatEntrega;
    private String descStat;

    private StatEntregaTienda(int idStatEntrega, String descStat) {
        this.idStatEntrega = idStatEntrega;
        this.descStat = descStat;
    }

    public int getIdStatEntrega() {
        return idStatEntrega;
    }

    public String getDescStat() {
        return descStat;
    }
}
