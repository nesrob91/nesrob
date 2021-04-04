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
public class Sku {
    
    private String idSku;
    private String descSku;
    private String idDepartamento;
    private String descDepartamento;
    private String idSubdepartamento;
    private String descSubdepartamento;
    private String idClase;
    private String descClase;
    private String idSubclase;
    private String descSubclase;
    private double alto;
    private double ancho;
    private double largo;
    private double costoUnitario;
    private double peso;
    
}
