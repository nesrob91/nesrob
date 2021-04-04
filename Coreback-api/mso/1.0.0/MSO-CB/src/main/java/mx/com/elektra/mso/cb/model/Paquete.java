/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author dparra
 */
@Data
public class Paquete {
    private int idManh;
    private String pedido;
    private int idCaja;
    private String cpOrigen;
    private String cpDestino;
    private double pesoFisico;
    private double pesoVolumetrico;
    private double peso;
    private double largo;
    private double ancho;
    private double alto;
    private double volumen;
    private int idCanal;
    private int idTipoPedido;
    private List<DetalleSkus> skus;
    private String pedidoAlterno;
    private double costoTotal;
    private String idLpn;
    private List<String> lpns;
    private List<String> adns;
    private String error;
    Map<Integer, Tarifa> tarifas;
    private String folio;
        
}
