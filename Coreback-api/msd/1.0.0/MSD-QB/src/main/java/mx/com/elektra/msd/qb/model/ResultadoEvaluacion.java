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
public class ResultadoEvaluacion {
    private double cantidad;
    private double tarifaBase;
    private double tarifaFinal;
    private String mensaje;
    private boolean procesado;
    private boolean valido;
    private boolean nulo;
    
}
