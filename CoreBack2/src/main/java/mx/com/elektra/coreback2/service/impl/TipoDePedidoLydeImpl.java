/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.List;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("pedidoLydeService")
public class TipoDePedidoLydeImpl implements TipoDePedidoService{
    @Autowired
    private  TipoDePedidoDao pedidoLydeDao ;
    
    @Override
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema) {
        paquete.setSkus(pedidoLydeDao.getDetalleSkus(paquete, esquema));
        return pedidoLydeDao.insertaContenidoCajaPorPaquete(paquete);
    }

    @Override
    public String getPedidoAlterno(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCpOrigen(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paquete setDetalleSkusInfoCd(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getCpDestino(Paquete paquete){
        return pedidoLydeDao.getCpDestino(paquete);
    }

    @Override
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed) {
        //CajaRf caja = generalesDao.getCajaRf(idManh, idCaja, tipPed);
        double alto=0;
        double ancho=0;
        double largo=0;
        DetalleSkus middle=new DetalleSkus();
        middle.getSku().setAlto(0);
        middle.getSku().setAncho(0);
        middle.getSku().setLargo(0);
        DimensionesQB dimensiones = new DimensionesQB();
        for(DetalleSkus sku:paquete.getSkus()){
            if(middle.getSku().getLargo()==0){
                String smaller=getSmallerSize(sku.getSku().getAncho(),sku.getSku().getAlto(),sku.getSku().getLargo());
                if(smaller.equals("ancho")){
                    ancho+=sku.getSku().getAncho()*sku.getCantidad();
                    middle.getSku().setAlto(sku.getSku().getAlto());
                    middle.getSku().setLargo(sku.getSku().getLargo());
                    middle.getSku().setAncho(ancho);
                }
                if(smaller.equals("alto")){
                    alto+=sku.getSku().getAlto()*sku.getCantidad();
                    middle.getSku().setAlto(alto);
                    middle.getSku().setLargo(sku.getSku().getLargo());
                    middle.getSku().setAncho(sku.getSku().getAncho());
                }
                if(smaller.equals("largo")){
                    largo+=sku.getSku().getLargo()*sku.getCantidad();
                    middle.getSku().setAlto(sku.getSku().getAlto());
                    middle.getSku().setLargo(largo);
                    middle.getSku().setAncho(sku.getSku().getAncho());
                }
            }else{
                if(middle.getSku().getIdSku().equals(sku.getSku().getIdSku())){
                    String smaller=getSmallerSize(sku.getSku().getAncho(),sku.getSku().getAlto(),sku.getSku().getLargo());
                    if(smaller.equals("ancho"))
                        ancho+=sku.getSku().getAncho()*sku.getCantidad();
                    if(smaller.equals("alto"))
                        alto+=sku.getSku().getAlto()*sku.getCantidad();
                    if(smaller.equals("largo"))
                        largo+=sku.getSku().getLargo()*sku.getCantidad();
                }else{
                    String smaller=getSmallerSize(sku.getSku().getAncho(),sku.getSku().getAlto(),sku.getSku().getLargo());
                    String bigger="";
                    if(smaller.equals("ancho")){
                        ancho=sku.getSku().getAncho()*sku.getCantidad();
                        alto=sku.getSku().getAlto();
                        largo=sku.getSku().getLargo();
                    }
                    if(smaller.equals("alto")){
                        alto=sku.getSku().getAlto()*sku.getCantidad();
                        largo=sku.getSku().getLargo();
                        ancho=sku.getSku().getAncho();
                    }
                    if(smaller.equals("largo")){
                        largo=sku.getSku().getLargo()*sku.getCantidad();
                        alto=sku.getSku().getAlto();
                        ancho=sku.getSku().getAncho();
                    }
                    bigger=getBiggerSize(ancho,alto,largo);
                    smaller=getSmallerSize(middle.getSku().getAncho(),middle.getSku().getAlto(),middle.getSku().getLargo());
                    if(smaller.equals("ancho") ){
                        if(bigger.equals("ancho"))
                            middle.getSku().setAncho(middle.getSku().getAncho()+ancho);
                        if(bigger.equals("alto"))
                            middle.getSku().setAlto(middle.getSku().getAlto()+alto);
                        if(bigger.equals("largo"))
                            middle.getSku().setLargo(middle.getSku().getLargo()+largo);
                    }
                    if(smaller.equals("alto") ){
                        if(bigger.equals("ancho"))
                            middle.getSku().setAncho(middle.getSku().getAncho()+ancho);
                        if(bigger.equals("alto"))
                            middle.getSku().setAlto(middle.getSku().getAlto()+alto);
                        if(bigger.equals("largo"))
                            middle.getSku().setLargo(middle.getSku().getLargo()+largo);
                    }
                    if(smaller.equals("largo") ){
                        if(bigger.equals("ancho"))
                            middle.getSku().setAncho(middle.getSku().getAncho()+ancho);
                        if(bigger.equals("alto"))
                            middle.getSku().setAlto(middle.getSku().getAlto()+alto);
                        if(bigger.equals("largo"))
                            middle.getSku().setLargo(middle.getSku().getLargo()+largo);
                    }
                }
            }
        }
        dimensiones.setAlto(middle.getSku().getAlto());
        dimensiones.setAncho(middle.getSku().getAncho());
        dimensiones.setLargo(middle.getSku().getLargo());

        dimensiones.setVolumen( dimensiones.getAlto() * dimensiones.getAncho() * dimensiones.getLargo() );
        dimensiones.setPesoVolumetrico(dimensiones.getVolumen() / 5000);
        return dimensiones;
    }

    public String getSmallerSize(double ancho,double alto,double largo){
        String smaller="";
        double sum=0;
        if(ancho >= alto && ancho>=largo){
            if(alto>largo)
                smaller="largo";
            else
                smaller="alto";
        }
        if(alto >= ancho && alto>=largo){
            if(ancho>=largo)
                smaller="largo";
            else
                smaller="ancho";
        }
        if(largo >= alto && largo>=ancho){
            if(alto>ancho)
                smaller="ancho";
            else
                smaller="alto";
        }
        return smaller;
    }
    
    public String getBiggerSize(double ancho,double alto,double largo){
        String bigger="";
        double sum=0;
        if(ancho >= alto && ancho>=largo){
            
                bigger="ancho";
        }
        if(alto >= ancho && alto>=largo){
            
                bigger="alto";
        }
        if(largo >= alto && largo>=ancho){
            
                bigger="largo";
        }
        return bigger;
    }
    
    @Override
    public double getPesoPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
