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
public class DimensionesQB {
    
    private double largo;
    private double ancho;
    private double alto;
    private double volumen;
    private double pesoFisico;
    private double pesoVolumetrico;
    
}
