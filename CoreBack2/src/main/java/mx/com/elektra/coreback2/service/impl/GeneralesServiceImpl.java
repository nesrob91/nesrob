/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.FamiliaSap;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Pedido;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import mx.com.elektra.coreback2.dao.DepuradorDao;
import mx.com.elektra.coreback2.dao.GeneralesDao;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.tipo.PSelector;
import mx.com.elektra.coreback2.tipo.PedidoDSV;
import mx.com.elektra.coreback2.tipo.PedidoEcom;
import mx.com.elektra.coreback2.tipo.PedidoLyde;
import mx.com.elektra.coreback2.tipo.PedidoMKP;
import mx.com.elektra.coreback2.tipo.TipoDePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("generalesService")
public class GeneralesServiceImpl implements GeneralesService{
    @Autowired
    private GeneralesDao generalesDao ;
    @Autowired
    private DepuradorDao depuradorDao ;
    @Autowired
    private PSelector selectorPedido;
    private TipoDePedido tipoDePedido;
    
    
    
    
    @Override
    public String getEsquema(int idManh){
        return generalesDao.getEsquema(idManh);
    }
    
    @Override
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema){
        return generalesDao.isLpnDifCantInicialVSEmpacado(idManh, idLpn, esquema);
    }
    
    @Override
    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn){
        return generalesDao.getDimensionesLpnEvaluado(idManh, idLpn);
    }
    
    
    /*
    public DimensionesQB getDimensionesPaqueteMKP(int idManh, int idCaja, String esquema, int tipPed){
        return generalesDao.getDimensionesPaqueteMKP(idManh, idCaja, esquema, tipPed);
    }*/
    
    
    
    
    
    
    
    @Override
    public Pedido getPedidoEpi(String idLpn, String esquema){
        return generalesDao.getPedidoEpi(idLpn, esquema);
    }
    @Override
    public Pedido getPedidoMKP(List<String> adn, int idVendor, int idTipoPedido){
        Set<String> vtex=new HashSet<>();
        //List<Map<String,Object>> infoAdn=getVtexByAdnsOrLpns(adn,null,esquema);
        List<Map<String,Object>> infoAdn=generalesDao.getPedidoMKP(adn, idVendor, idTipoPedido);
        if(infoAdn.size() < adn.size())//check for adns from the same vendor
            return null;
        
        for(Map<String,Object> inf:infoAdn){
            vtex.add(inf.get("ID_PEDIDO").toString());
            //lpn.add(inf.get("ID_LPN").toString());
        }
        if(vtex.size()>1)//check for only one vtex
            return null;
        
        Pedido pedido=new Pedido();
        pedido.setIdCaja(0);
        pedido.setIdCanal(1);
        pedido.setIdManh(Integer.parseInt(infoAdn.get(0).get("ID_ORIGEN").toString()));//modify - check for real name
        pedido.setIdTipoPedido(idTipoPedido);
        pedido.setLpns(adn);//adns
        pedido.setIdLpn("");
        pedido.setOrderType("00");//modify - if necessary
        pedido.setPedido(infoAdn.get(0).get("ID_PEDIDO").toString());
        return pedido;
    }
    @Override
    public Pedido getPedidoDSV(List<String> adn, int idVendor, int idTipoPedido){
        Set<String> vtex=new HashSet<>();
        //List<Map<String,Object>> infoAdn=getVtexByAdnsOrLpns(adn,null,esquema);
        List<Map<String,Object>> infoAdn=generalesDao.getPedidoDSV(adn, idVendor, idTipoPedido);
        if(infoAdn.size() < adn.size())//check for adns from the same vendor
            return null;
        
        for(Map<String,Object> inf:infoAdn){
            vtex.add(inf.get("ID_PEDIDO").toString());
            //lpn.add(inf.get("ID_LPN").toString());
        }
        if(vtex.size()>1)//check for only one vtex
            return null;
        
        Pedido pedido=new Pedido();
        pedido.setIdCaja(0);
        pedido.setIdCanal(1);
        pedido.setIdManh(Integer.parseInt(infoAdn.get(0).get("ID_ORIGEN").toString()));//modify - check for real name
        pedido.setIdTipoPedido(4);
        pedido.setLpns(adn);//adns
        pedido.setIdLpn("");
        pedido.setOrderType("00");//modify - if necessary
        pedido.setPedido(infoAdn.get(0).get("ID_PEDIDO").toString());
        return pedido;
    }
    private List<Map<String,String>> getLpnsByAdn(List<String> adn, String esquema){
        return generalesDao.getLpnsByAdn(adn, esquema);
    }
    private List<Map<String,Object>> getVtexByAdnsOrLpns(List<String> adn, List<String> lpn, String esquema){
        return generalesDao.getVtexByAdnsOrLpns(adn==null?new ArrayList<String>():adn, lpn==null?new ArrayList<String>():lpn, esquema);
    }
    
    @Override
    public int getIdTipoPedidoByOrderType(String orderType){
        return generalesDao.getIdTipoPedidoByOrderType(orderType);
    }
    
    @Override
    public List<Regla> getReglas(int idCanal,int tipoPedido){
        return generalesDao.getReglas(idCanal, tipoPedido);
    }
    
    @Override
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario){
        return generalesDao.insertaCbDtl(paquete, carrier, regla, usuario);
    }
    @Override
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion){
        return generalesDao.actualizaCbDtl(paquete, regla, carrier, resultadoEvaluacion);
    }
    @Override
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa){
        return generalesDao.actualizaCbHdr(paquete, carrier, usuario, tarifa);
    }
    
    @Override
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn){
        return generalesDao.getMejorCarrierPostCalculo(idManh, idLpn);
    }
    
    
    
    
    
    
    @Override
    public Paquete getPaquete(Paquete paquete, int idTipoPeticion, String esquema) {

        String pedidoAlterno = null;
        String cpOrigen = null;
        String cpDestino = null;

        setTipoDePedido(paquete);
        if (tipoDePedido != null) {
            if(paquete.getPedidoAlterno() == null){
                pedidoAlterno = tipoDePedido.getPedidoAlterno();
            }
            else{
                pedidoAlterno = paquete.getPedidoAlterno();
            }
            
            if (pedidoAlterno != null) {
                paquete.setPedidoAlterno(pedidoAlterno);
                cpOrigen = tipoDePedido.getCpOrigen();
                if (cpOrigen != null) {
                    paquete.setCpOrigen(cpOrigen);
                    cpDestino = tipoDePedido.getCpDestino();
                    if (cpDestino != null) {
                        paquete.setCpDestino(cpDestino);
                            if (tipoDePedido.insertaContenidoCaja(idTipoPeticion, esquema)) {
                                paquete = tipoDePedido.setDimensionesPaquete(paquete, esquema, idTipoPeticion);
                                if(paquete.getError().equals("")){
                                    if (!insertaCbHdrByPaquete(paquete, "GeneralesServiceImpl")) {
                                        //return paquete;
                                    //} else {
                                        paquete.setError("CBP0006");
                                        //return paquete;
                                    }
                                }
                            } else {
                                paquete.setError("CBP0005");
                                //return paquete;
                            }
                        
                    } else {
                        paquete.setError("CBP0004");
                        //return paquete;
                    }
                } else {
                    paquete.setError("CBP0003");
                    //return paquete;
                }
            } else {
                paquete.setError("CBP0002");
                //return paquete;
            }

        } else {
            paquete.setError("CBP0001");
            //return paquete;
        }
        return paquete;
    }
    
    private boolean insertaCbHdrByPaquete(Paquete paquete, String usuario){
        boolean res = false;
        for(CarrierQB c : generalesDao.getCarriersActivos(paquete.getIdCanal(),paquete.getIdTipoPedido())){
            boolean resultado = generalesDao.insertaCbHder2018(paquete, usuario, c);
            res = (!res) ? resultado : res; 
        }
        return res;
    }
    
    @Override
    public List<CarrierQB> getCarriersActivos(Paquete paquete, List <CarrierQB> carriersActuales, int iteracion, int idRegla){
        List<CarrierQB> carriers = new ArrayList<>();
        if(iteracion == 0){
            carriers = generalesDao.getCarriersPrimeraIteracion(paquete);
        }
        else{
            carriers = generalesDao.getCarriersSiguienteIteracion(paquete, idRegla);
        }
        if(carriers.isEmpty()){
            carriers =  carriersActuales;
        }
        return carriers;
    }
    
    
    
    @Override
    public boolean isPaqueteProcesado(Pedido pedido){
        Paquete paquete = new Paquete();
        paquete.setPedido(pedido.getPedido());
        paquete.setIdCaja(pedido.getIdCaja());
        paquete.setIdManh(pedido.getIdManh());
        paquete.setIdCanal(pedido.getIdCanal());
        paquete.setIdTipoPedido(pedido.getIdTipoPedido());
        return depuradorDao.countCbHdr(paquete) > 0;
    }
    
    @Override
    public boolean isLpnModificado(DimensionesQB lpnPrimeraEvaluacion, DimensionesQB lpnSegundaEvaluacion){
        return (
                lpnPrimeraEvaluacion.getLargo() != lpnSegundaEvaluacion.getLargo()
                && lpnPrimeraEvaluacion.getAncho()!= lpnSegundaEvaluacion.getAncho()
                && lpnPrimeraEvaluacion.getAlto()!= lpnSegundaEvaluacion.getAlto()
                && lpnPrimeraEvaluacion.getVolumen()!= lpnSegundaEvaluacion.getVolumen()
                && lpnPrimeraEvaluacion.getPesoFisico()!= lpnSegundaEvaluacion.getPesoFisico()
                && lpnPrimeraEvaluacion.getPesoVolumetrico()!= lpnSegundaEvaluacion.getPesoVolumetrico()
                );
    }

    private void setTipoDePedido(Paquete paquete){
        /*switch (paquete.getIdTipoPedido()){
            case 1: case 7:
                tipoDePedido = selectorPedido.getPedidoEcom();
                break;
            case 4:
                tipoDePedido = selectorPedido.getPedidoMkp();
                break;
            case 5:
                tipoDePedido = selectorPedido.getPedidoDsv();
                break;
            case 6:
                tipoDePedido = selectorPedido.getPedidoLyde();
                break;
            default:
                tipoDePedido = null;
                break;
        }
        */
        tipoDePedido=selectorPedido.getPedidoUm();
    }
    
    
    
    /***
     * Metodo para crear caja
     * @param idUsuario Usuario que crea caja (si se crea nueva)
     * @param pedido vtex sin 'v * ekt-01'
     * @param idLpn carton(es), olpn | adn en MKP,DSV
     * @param idManh origen desde donde se realiza el surtimeinto
     * @param idCanal canal (ECOM | Retail) 
     * @param idTipPed tipo de pedido (ECOM | Envio Domicilio | MarketPlace | ...)
     * @param idContainer id de contenedor (MKP only)
     * @param peso peso de la caja (MKP only)
     * @return 
     */
    @Override
    public int getIdCaja(int idUsuario, String pedido, List<String> idLpn, int idManh, int idCanal, int idTipPed, int idContainer, double peso){
        int idCaja = 0;
        switch(idTipPed){
            default: 
                if(generalesDao.isCajaExistente(idManh, idLpn.get(0))){
                    idCaja = generalesDao.getIdCajaByLpn(idManh, idLpn.get(0));
                }else{
                    idCaja = generalesDao.getIdCaja();
                    generalesDao.insertaCajaHdr(idUsuario, idCaja, idManh, pedido, idCanal, idTipPed, 0, 99);
                    generalesDao.insertaCajaDtl(idCaja, idLpn.get(0));
                }
                break;
            case 4: case 5:
                idCaja = generalesDao.getIdCaja();
                generalesDao.insertaCajaHdr(idUsuario, idCaja, idManh, pedido, idCanal, idTipPed, idContainer, peso);
                for(String s : idLpn)
                    generalesDao.insertaCajaDtl(idCaja, s);//modify | adn sent instead of lpn
                break;
        }
        return idCaja;
    }

    /***
     * Metodo para crear Contenedor
     * @param lenght 
     * @param width
     * @param height
     * @param weight
     * @param idVendor
     * @param idTipPed
     * @param idUsuario
     * @return id del contenedor creado
     */
    @Override
    public int createContainer(double lenght, double width, double height, double weight, int idVendor, int idTipPed, int idUsuario) {
        int idContainer=generalesDao.getIdContainer(lenght, width, height, weight, idVendor, idTipPed, false);
        if(idContainer==0)
            idContainer=generalesDao.createContainer(lenght, width, height, weight, idVendor, idTipPed, idUsuario) ;
        return idContainer;
    }

    @Override
    public List<Integer> getCdsOfLpns(Paquete paquete){
        return generalesDao.getCdsOfLpns(paquete);
    }
    
}
