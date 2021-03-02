/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.config.appConfig;
import mx.com.elektra.ektrutas.dto.Remision;
import mx.com.elektra.ektrutas.dto.Respuesta;
import mx.com.elektra.ektrutas.tipos.Lyde;
import mx.com.elektra.ektrutas.tipos.Rutas;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author nroblerol
 */
public class GenRutas {
    //Initialize Spring context
    private AnnotationConfigApplicationContext ctx ;
    private Rutas lyde;
    private Rutas generic;
    private LogsPaqueterias logger;

    public GenRutas() {
        this.ctx = new AnnotationConfigApplicationContext(appConfig.class);
        initialize();
    }
    public GenRutas(AnnotationConfigApplicationContext ctx) {
        this.ctx = ctx;
    }
    
    private void initialize(){
        //Load all types(currenly only Lyde implemented-20200901)
        generic = ctx.getBean("GeneraRuta",Rutas.class);//for general purposes (document, validation)
        lyde=ctx.getBean(Lyde.class);
        logger = ctx.getBean(LogsPaqueterias.class);
    }
    
    public Respuesta getFolRutLyde(int origen, List<Integer> rem, int idTransporte, int eco, Integer mtvo, String checador, String estibador, boolean isExternal){
        Respuesta resp = new Respuesta();
        try{
            int tipRuta=1;
            int sec=0;
            String sello="";
            resp=lyde.generateFolRut( origen,  0,  rem,  idTransporte, eco, tipRuta, mtvo,sec, sello, checador, "", isExternal);
            if(resp.isError())
                resp.setDocument("NA");
            else{
                if(isExternal){
                    resp.setDocument("");
                }else{
                    try{
                        String d = getDocument(origen, resp.getRuta().size()>1?Integer.parseInt(resp.getFolEnvio()):0, resp.getRuta().size()>1?0:Integer.parseInt(resp.getRuta().get(0)));
                        resp.setDocument(d);
                    }catch(Exception e){
                        resp.setDocument("RE:");  
                    }
                }
            }
        }catch(Exception e){
            resp.setError(true);
            resp.setCode("GRT0001");
            resp.setMsg("Error Inesperado:"+e.getLocalizedMessage());
            try{
                logger.insertaError(1110002, 11, origen, null, null, eco, idTransporte, "", 0, 0, 
                        e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "1002");
            }catch(Exception ex){
                System.out.println("Error : "+ex.toString());
            }
        }
        return resp;
    }
    
    public String getSysdate(){
        return generic.getSysdate();
    }
    
    public String getDocument(Integer origen, Integer folEnv, Integer folRut){
        String document="";
        document=generic.getDocument(origen, folEnv, folRut);
        return document;
    }
    
    public Map<String,Object> validateRemision(List<String> rem, Integer origen){
        try{
            switch(origen){
                case 9971:
                    return lyde.validateRemisionAndTrkNbr(rem, origen);
                default :
                    return new HashMap<String,Object>();
            }
        }catch(Exception e){
            try{
                logger.insertaError(1110002, 11, origen, 0, "", 0, 0, "", 0, 0
                    , e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception el){
                System.out.println("Error "+el.toString());
            }
            Map<String,Object> result=new HashMap<>();
            result.put("valid",false);
            result.put("message","No se pudo comprobar informacion");
            result.put("code","GRTVRR0001");
            return result;
        }
    }
}
