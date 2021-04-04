/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.model;

import lombok.Data;

/**
 *
 * @author dparra
 */
@Data
public class Tarifa {
    private double tarifa;
    private String tipoTransporte;
    private String cpOrigen;
    private String cpDestino;
    private double pesoMinimo;
    private double pesoMaximo;
    private double costoPesoExtra;
    private boolean seguro;
    private double pesoExtra;
    private double costoExtra;
    private double tarifaFinal;

}
