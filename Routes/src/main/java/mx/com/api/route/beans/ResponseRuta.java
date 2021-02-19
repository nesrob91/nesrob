/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

import java.util.List;
import lombok.Data;

/**
 *
 * @author darkn
 */
@Data
public class ResponseRuta {
   private Long idPeticion;
    private Integer estatus;
    private String mensaje;
    private List<String> ruta;
    private String numGuia;
    private String documento;
    private String carrier;
    private FoliosResponse folios;
    private Boolean error;
    private String code;
    private Integer folEnvio;
     
}
