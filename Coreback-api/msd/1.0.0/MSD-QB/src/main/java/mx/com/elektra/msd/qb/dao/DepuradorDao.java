/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao;

import mx.com.elektra.msd.qb.model.Paquete;

/**
 *
 * @author dparra
 */
public interface DepuradorDao {

    public boolean eliminaCbHdr(Paquete paquete);

    public boolean eliminaAccesorios(Paquete paquete);

    public boolean eliminaCbDtl(Paquete paquete);

    public boolean eliminaContenidoCaja(Paquete paquete);

    public int countCbHdr(Paquete paquete);

    public int countCbDtl(Paquete paquete);

    public int countContenidoCaja(Paquete paquete);

    public int countGuia(Paquete paquete);

    public int countAccesorios(Paquete paquete);
}
