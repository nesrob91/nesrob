/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service;

import mx.com.elektra.mso.cb.model.Paquete;

/**
 *
 * @author dparra
 */
public interface DepuradorService {
    public boolean limpiaTablas(Paquete paquete);
}