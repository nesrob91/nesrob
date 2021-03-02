/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.logs.error;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;

/**
 *
 * @author nroblerol
 */
public class LogThread implements Runnable{

    private final LogsPaqueterias logger = new LogsPaqueterias();
    
    private int idManh=0;
    private String pedido="";
    private int idCaja=0;
    private int idCanal=0;
    private int idTipoPedido=0;
    private String msg="";
    private String method="";
    private int idApp=0;

    public LogThread() {
    }
    public LogThread(int idApp, int idManh,String pedido,int idCaja,int idCanal,int idTipoPedido,String msg,String method) {
        this.idManh=idManh;
        this.pedido=pedido;
        this.idCaja=idCaja;
        this.idCanal=idCanal;
        this.idTipoPedido=idTipoPedido;
        this.msg=msg;
        this.method=method;
        this.idApp=idApp;
    }
    
    @Override
    public void run() {
        logger.insertaError(100000, idApp, idManh, 0, pedido, idCaja, 0, "", idCanal, idTipoPedido, msg, method, "");
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setIdManh(int idManh) {
        this.idManh = idManh;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public void setIdTipoPedido(int idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }
    
}
