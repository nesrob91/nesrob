/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2;

import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.config.configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author nroblerol
 */
public class runner {
    private AnnotationConfigApplicationContext ctx ;
    private boolean DEBUGGER;
    private Core core;

    public runner() {
        this.ctx = new AnnotationConfigApplicationContext(configuration.class);
        initialize();
    }
    public runner(AnnotationConfigApplicationContext ctx) {
        this.ctx = ctx;
    }
    
    private void initialize(){
        core=ctx.getBean(Core.class);
    }
    
    public CarrierQB evalCarrier(String pedido, int idCaja, int idManh, int idCanal, int idTipoPedido, int emular, String idLpn, int idTipoPeticion){
        CarrierQB c=null;
        c=core.iniciaEvaluacion( pedido,  idCaja,  idManh,  idCanal,  idTipoPedido,  emular,  idLpn,  idTipoPeticion);
        return c;
    }
    
    public static void main(String[] args){
        runner run=new runner();
        System.out.println("Result "+run.evalCarrier("25", 0, 1, 0, 0, 0, "", 0));
    }
}
