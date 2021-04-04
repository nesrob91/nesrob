package mx.com.elektra.mso.cb.controller;

import mx.com.elektra.mso.cb.common.CodigosResponseCommon;
import mx.com.elektra.mso.cb.common.FolioCommon;
import mx.com.elektra.mso.cb.coreback.CorebackUm;
import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.PeticionCore;
import mx.elektra.dependencias.contenedorresponse.model.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coreback")
public class CoreController {
    @Autowired
    private FolioCommon folio;
    @Autowired
    private CorebackUm cbum;
    @Autowired
    Paquete paquete;

    @PostMapping("/um")
    public ResponseEntity<?> getCarrier(@RequestBody(required = true) PeticionCore peticion) {
        ResponseEntity<ResponseService> response;
        String fol = folio.getFolio();
        CarrierQB prov=cbum.iniciaEvaluacion(peticion,fol);
        ResponseService resp ;
        if(prov.getIdCarrier()==0){
            resp = new ResponseService(CodigosResponseCommon.CODIGO_500, fol, prov);
            response=new ResponseEntity(resp,HttpStatus.ACCEPTED);
        }else{
            resp = new ResponseService(CodigosResponseCommon.CODIGO_200, fol, prov);
            response=new ResponseEntity(resp,HttpStatus.OK);
        }
        return response;
    }

}
