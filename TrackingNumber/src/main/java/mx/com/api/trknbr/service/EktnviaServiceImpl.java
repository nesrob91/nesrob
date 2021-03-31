/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.dao.EktnviaDao;
import javax.xml.bind.DatatypeConverter;
import mx.com.api.trknbr.beans.DatosEktnvia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("ektnviaService")
public class EktnviaServiceImpl implements EktnviaService{
    @Autowired
    private EktnviaDao ektnviaDao ;
    
    @Override
    public Object getEktnviaRequest(GuiaRequest req){
        return ektnviaDao.getEktnviaRequest(req);
    }
    
    @Override
    public String getNumGuia(int idManh, int idCaja, String pedido,int idTipoPedido, String idUsuario) {
        return ektnviaDao.getNumGuia(idManh, idCaja, pedido, idTipoPedido, idUsuario);
    }
    
    @Override
    public String getEtiquetaByNumGuia(DatosEktnvia datosGuias, boolean desarrollo, String guia) throws Exception{
        String zplcommand = "^XA  "
        		+ "^CF0,60  "
        		+ "^FO320,20^AB^A0N,50,50^FDektnvia^FS "
        		+ "^FO700,0^GB0,110,6^FD^FS  "
        		+ "^FO720,40^AB^A0N,70,90^FD"+"ubicacion"+"^FS "
        		+ "^FO700,110^GB850,1,6^FS  "
        		+ " "
        		+ "^CFA,30  "
        		+ "^FO200,80^FDPedido: "+datosGuias.getPedido()+"^FS "
        		+ "^CFA,30 "  
        		+ "^FO160,120^FDContactanos: 01 800 510 1111^FS " 
        		+ " "
        		+ " "
        		+ "^FO50,180^A0N,40,40^FDRemitente: ^FS "
        		+ "^FO50,220^A0N,30,30^FDAV. INDUSTRIAL 9^FS "
        		+ "^FO50,250^A0N,30,30^FDLAS ANIMAS^FS "
        		+ "^FO50,280^A0N,30,30^FDTEPOTZOTLAN, ESTADO DE MEXICO^FS "
        		+ "^FO660,280^A0N,30,30^FDC.P. "+datosGuias.getCpOrigen()+"^FS "
        		+ "^FO50,320^GB730,1,3^FS  "
        		+ " "
        		+ "^FO50,370^A0N,40,40^FDDestinatario: ^FS "
        		+ "^FO50,420^A0N,30,30^FD"+datosGuias.getContactoDestino()+"^FS "
        		+ "^FO50,450^A0N,30,30^FD"+datosGuias.getDireccionDestino()+"^FS "
        		+ "^FO50,480^A0N,30,30^FDExt. "+datosGuias.getnExtDestino()+" Int. "+datosGuias.getnIntDestino()+"^FS "
        		+ "^FO50,510^A0N,30,30^FD"+datosGuias.getColoniaDestino()+"^FS "
        		+ "^FO50,540^A0N,30,30^FD"+datosGuias.getCiudadDestino()+", "+datosGuias.getEstadoDestino()+"^FS "
        		+ "^FO660,540^A0N,30,30^FDC.P. "+datosGuias.getCpDestino()+"^FS "
        		+ "^FO50,570^A0N,30,30^FDTel. "+datosGuias.getTelefonoDestino()+"^FS "
        		+ "^FO50,600^A0N,30,30^FDReferencias: ^FS "
        		+ "^FO50,630^A0N,30,30^FD"+datosGuias.getObservaciones()+"^FS "
        		+ "^FO50,670^GB730,1,3^FS  "
        		+ " "
        		+ " "
        		+ "^FO50,720^BY3^BCN,120,N,Y^FD"+guia+"^FS  "
        		+ "^FO250,880^A0N,40,40^FD"+guia+"^FS "
        		+ " "
        		+ "^FO100,970^A0N,40,40^FD1er intento^FS "
        		+ "^FO280,960^GB0,40,1^FD^FS  "
        		+ "^FO280,960^GB400,1,1^FS  "
        		+ "^FO680,960^GB0,40,1^FD^FS "
        		+ "^FO280,1000^GB400,1,1^FS  "
        		+ " "
        		+ "^FO100,1040^A0N,40,40^FD2do intento^FS "
        		+ "^FO280,1030^GB0,40,1^FD^FS  "
        		+ "^FO280,1030^GB400,1,1^FS  "
        		+ "^FO680,1030^GB0,40,1^FD^FS "
        		+ "^FO280,1070^GB400,1,1^FS  "
        		+ " "
        		+ "^FO100,1110^A0N,40,40^FD3er intento^FS "
        		+ "^FO280,1100^GB0,40,1^FD^FS  "
        		+ "^FO280,1100^GB400,1,1^FS  "
        		+ "^FO680,1100^GB0,40,1^FD^FS "
        		+ "^FO280,1140^GB400,1,1^FS  "
        		+ " "
        		+ "^XZ  ";
        
        if(desarrollo)
        	System.out.println(zplcommand);
        return DatatypeConverter.printBase64Binary(zplcommand.getBytes());
    }
}
