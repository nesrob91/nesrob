/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.type;

import java.util.List;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;

/**
 *
 * @author nroblerol
 */
public interface RutaIfc {
    public ResponseRuta generateFolRut(int usuario, int origen, int folioEnvio, List<Integer> rem, int idTransporte, int eco, int tipRuta, Integer mtvo, int sec, String sello, String checador, String estibador, boolean isExternal);
    
    public String getDocument(Integer origen, Integer folEnv, Integer folRut);
    
    public ResponseRuta cancelFolRut(int origen, List<String> rutas, Integer usuario);
    
    public ResponseRuta modifyFolRut(int origen, List<Integer> remision, Integer usuario, String fecha, String estatus, String comentario, String pod);
    
    public ResponseRuta getStatRut(int origen, List<String> remision);
    
}
