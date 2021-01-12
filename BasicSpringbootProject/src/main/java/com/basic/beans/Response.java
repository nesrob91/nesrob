/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Long idPeticion;
    private Integer user;
    private String message;

    public Response() {
    }

    public Response(Long idPeticion, Integer user, String message) {
        this.idPeticion = idPeticion;
        this.user = user;
        this.message = message;
    }
    
    
}
