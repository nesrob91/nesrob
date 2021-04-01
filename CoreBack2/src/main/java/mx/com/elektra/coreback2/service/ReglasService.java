/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service;

import java.util.Map;
import mx.com.elektra.coreback2.beans.ExclusionOInclusion;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Tarifa;

/**
 *
 * @author dparra
 */
public interface ReglasService {
    public boolean isDestinoValidoParaCarrier(Paquete paquete, int idCarrier);
    public int getRatingCarrier(Paquete paquete, int idCarrier);
    public boolean isPesoFisicoSoportadoPorCarrier(Paquete paquete, int idCarrier);
    public ExclusionOInclusion validaExclusiones(Paquete paquete, int idCarrier);
    public boolean isCapacidadValidaPorCarrier(Paquete paquete, int idCarrier);
    public int getEstatusHorario(Paquete paquete, int idCarrier);
    public Map<Boolean, Integer> getCalculoPorcentajePorCarrier(Paquete paquete, int idCarrier);
    public Tarifa getTarifaEnvio(Paquete paquete, int idCarrier);
    public boolean isPaqueteReqSeguro(Paquete paquete, int idCarrier);
    public double getTarifaMejorCarrier(Paquete paquete, int idCarrier);
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier);
}
