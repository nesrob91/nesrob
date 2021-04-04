/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao;

import java.util.List;
import mx.com.elektra.msd.qb.model.ExclusionOInclusion;
import mx.com.elektra.msd.qb.model.Paquete;
import mx.com.elektra.msd.qb.model.Sku;
import mx.com.elektra.msd.qb.model.Tarifa;

/**
 *
 * @author dparra
 */
public interface ReglasDao {
    
    public boolean isDestinoValidoParaCarrier(Paquete paquete, int idCarrier) ;

    public int getRatingCarrier(Paquete paquete, int idCarrier);

    public boolean isPesoFisicoSoportadoPorCarrier(Paquete paquete, int idCarrier);
    
    public ExclusionOInclusion getExclusionesEInclusiones(Sku sku, Paquete paquete, int idCarrier, String tipo, List<String> clasf);
    
    public boolean isCapacidadValidaPorCarrier(Paquete paquete, int idCarrier);
    
    public int getCapacidadPorCarrier(Paquete paquete, int idCarrier);
    
    public int getPorcentajePorCarrier(Paquete paquete, int idCarrier);
    
    public int getPorcentajeRestoCarrier(Paquete paquete);
    
    public int getEstatusHorario(Paquete paquete, int idCarrier);
    
    public int getCantidadGuiasPorCarrier(Paquete paquete, int idCarrier);
    
    public int getCantidadGuias(Paquete paquete);
    
    public Tarifa getTarifa(Paquete paquete, int idCarrier);
    
    public Tarifa getTarifaPesoAdicional(Paquete paquete, int idCarrier);
    
    public double getTarifaMejorCarrier(Paquete paquete, int idCarrier);
    
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier);
}
