/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.type;

import java.util.List;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("elektra")
public class EktImpl implements RutaIfc{

    /*
     * No impl for EKT, currently managed in MONDIS (as of FEB-2021)
    */
    
    @Override
    public ResponseRuta generateFolRut(int usuario, int origen, int folioEnvio, List<Integer> rem, int idTransporte, int eco, int tipRuta, Integer mtvo, int sec, String sello, String checador, String estibador, boolean isExternal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDocument(Integer origen, Integer folEnv, Integer folRut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseRuta cancelFolRut(int origen, List<String> remision, Integer usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseRuta modifyFolRut(int origen, List<Integer> rutas, Integer usuario, String fecha, String estatus, String comentario, String pod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseRuta getStatRut(int origen, List<String> remision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
