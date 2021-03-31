/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import com.elektra.cadsumutils.generales.Generales;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DOinfo;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.dao.GuiaDao;
import mx.com.api.trknbr.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("lyde")
public class Lyde implements TipoPeticion{
    @Autowired
    private PedidoDao pedidoDaoLyde;
    @Autowired
    private PedidoDao pedidoDaoEcom;
    @Autowired
    private GuiaDao guiaDao;
    
    @Override
    public List<Contacto> getContactos(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido, int tipoDoc){
        Contacto contactoO = new Contacto();
        Contacto contactoD = new Contacto();
        List<Contacto> fixed ;
        switch(tipoDoc){
            case 1://for non NC request
                contactoO = pedidoDaoLyde.getOrigenPedido(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
                contactoD = pedidoDaoLyde.getDestinoPedido(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido);
                break;
            case 2://for NC Request, considering are going to be in P_C
                contactoO = pedidoDaoLyde.getOrigenPedido(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
                contactoD = pedidoDaoEcom.getDestinoPedido(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido);
                break;
        }
        if(contactoO == null || contactoD == null){
            fixed = null;
        }else{
            List<Contacto> contactos = new ArrayList<>();
            contactos.add(contactoO);
            contactos.add(contactoD);
            if(verifyContactInformation(contactos, idTipoPedido)){
                fixed=new ArrayList<>(contactos);
                //first item should be origin, considering ELEKTRA is the origin
                    for(Contacto c : contactos){
                        if(c.getContacto().contains("NUEVA ELEKTRA")){
                            fixed.set(0,c);
                        }else{
                            fixed.set(1,c);
                        }
                    }

                if(fixed.size()!=2){
                    fixed = null;
                }
            }else{
                fixed = null;
            }
        }
        return fixed;
    }
    
    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn){
        GuiaRequest request=new GuiaRequest();
        List<DetalleSkus> skus = new ArrayList<>();//pedidoDaoLyde.getDetalleSkusLyde(idCaja,idManh);
        if(skus==null)
            return null;
        else{
            request.setIdTipoPedido(idTipoPedido);
            request.setIdManh(idManh);
            request.setIdCaja(idCaja);
            request.setVtex(pedido);
            request.setIdCanal(idCanal);
            request.setIdCarrier(idCarrier);
            request.setIdLpn("");
            //request.setSkus(skus);
            /*double alto=0;
            double ancho=0;
            double largo=0;
            double peso=0;
            DetalleSkus middle=new DetalleSkus();
            Sku mSku=new Sku() ;
            middle.setSku(mSku);
            middle.getSku().setAlto(0);
            middle.getSku().setAncho(0);
            middle.getSku().setLargo(0);
            for(DetalleSkus sku:skus){
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
                    peso=sku.getSku().getPeso()*sku.getCantidad();
                }else{
                    //if(middle.getSku().getIdSku().equals(sku.getSku().getIdSku())){
                      //  String smaller=getSmallerSize(sku.getSku().getAncho(),sku.getSku().getAlto(),sku.getSku().getLargo());
                      //  if(smaller.equals("ancho"))
                      //      ancho+=sku.getSku().getAncho()*sku.getCantidad();
                      //  if(smaller.equals("alto"))
                      //      alto+=sku.getSku().getAlto()*sku.getCantidad();
                      //  if(smaller.equals("largo"))
                      //      largo+=sku.getSku().getLargo()*sku.getCantidad();
                    //}else{
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
                    //}
                    peso+=sku.getSku().getPeso()*sku.getCantidad();
                }
            }
            request.setLargo(middle.getSku().getLargo());
            request.setAncho(middle.getSku().getAncho());
            request.setAlto(middle.getSku().getAlto());
            request.setPeso(peso);
            */
            request.setLargo(trknbrSize.get("lenght"));
            request.setAncho(trknbrSize.get("width"));
            request.setAlto(trknbrSize.get("height"));
            request.setPeso(trknbrSize.get("weight"));
        }
        return request;
        
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
    public String getOrderId(GuiaRequest guiaRequest){
        String info;
        List<String> ncDOByAdn=pedidoDaoLyde.getNCbyAdn(guiaRequest.getIdCaja(),guiaRequest.getIdManh());
        if(ncDOByAdn!=null){
            info=pedidoDaoLyde.getOrderId(guiaRequest, ncDOByAdn);//modify lyde
        }else{
            return null;
        }
        if(info!=null){
            guiaRequest.setIdTipoPedido(6);//for ctr_guia purpose(as of feb 2021)//validate for nc
            String orderID=Generales.getInstance().padding(info,0,'0',8);//in case is not long enough
            return orderID;//info.get(0).getOrderID();//modify lyde
        }else{
            return null;
        }
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest){
        return pedidoDaoLyde.getDetalleSkus(guiaRequest);
    }

    @Override
    public List<Contacto> getContactosWs(List<Contacto> od, String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInsertControlGuias(GuiaRequest guiaRequest, String usuario) {
        return guiaDao.insertaControlGuias(guiaRequest, usuario);
    }

}
