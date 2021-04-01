/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.tipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("tipoPedido")
public class PSelector {
    @Autowired
    private TipoDePedido pedidoDsv;
    @Autowired
    private TipoDePedido pedidoEcom;
    @Autowired
    private TipoDePedido pedidoMkp;
    @Autowired
    private TipoDePedido pedidoUm;
    @Autowired
    private TipoDePedido pedidoLyde;

    public TipoDePedido getPedidoDsv() {
        return pedidoDsv;
    }

    public TipoDePedido getPedidoEcom() {
        return pedidoEcom;
    }

    public TipoDePedido getPedidoMkp() {
        return pedidoMkp;
    }

    public TipoDePedido getPedidoUm() {
        return pedidoUm;
    }

    public TipoDePedido getPedidoLyde() {
        return pedidoLyde;
    }
    
}
