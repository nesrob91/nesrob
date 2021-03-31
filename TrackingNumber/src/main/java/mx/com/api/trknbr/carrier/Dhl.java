/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import com.elektra.cadsumutils.ws.GetNodes;
import mx.com.api.trknbr.beans.CredencialesDhl;
import mx.com.api.trknbr.beans.GuiaResponse;
import com.elektra.cadsumutils.ws.DHLClient;
import java.util.ArrayList;
import java.util.List;
import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("dhl")
public class Dhl extends GuiasCarriers{
    @Autowired
    private CredencialesDao credencialesDhl;
    
    @Override
    protected Object getCredenciales() throws Exception{
        return credencialesDhl.getCredenciales(guiaRequest.getIdCarrier(),credencialesDhl.ID_SERVICIO_GUIAS,guiaRequest.getIdTipoPedido());
    }
    
    @Override
    protected Object generaPeticion() throws Exception{
        
        CredencialesDhl credencialesDhl = (CredencialesDhl) credenciales;
        String request = "";
        String contenido = "";
        int cantidadCajas=1;
        String companyName = "";
        contenido = "            <Piece>\n" +
"                <PieceID>1</PieceID>\n" +
"                <Weight>"+(int)Math.ceil(guiaRequest.getPeso())+"</Weight>\n" +
"                <Width>"+(int)Math.ceil(guiaRequest.getAncho())+"</Width>\n" +
"                <Height>"+(int)Math.ceil(guiaRequest.getAlto())+"</Height>\n" +
"                <Depth>"+(int)Math.ceil(guiaRequest.getLargo())+"</Depth>\n" +
"                <PieceContents>PAQUETE ELEKTRA</PieceContents>\n" +
"            </Piece>\n";        
        if(guiaRequest.getIdTipoPedido()==6){
            if((guiaRequest.getDestino().getTienda()+" - "+guiaRequest.getPedido()).length()>35 )
                companyName = utils.substr(guiaRequest.getDestino().getTienda(), 0, 32-guiaRequest.getPedido().length())+" - "+guiaRequest.getPedido();
            else
                companyName = guiaRequest.getDestino().getTienda()+" - "+guiaRequest.getPedido();
        }else{
            companyName = utils.substr( "E-COMMERCE "+guiaRequest.getPedido(), 0, 35);
        }
            request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<req:ShipmentRequest schemaVersion=\"6.2\" xmlns:req=\"http://www.dhl.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.dhl.com ship-val-global-req.xsd\">\n" +
"    <Request>\n" +
"        <ServiceHeader>\n" +
"            <MessageTime>"+credencialesDhl.getMessageTime()+"</MessageTime>\n" +
"            <MessageReference>"+utils.substr(guiaRequest.getOrderId()+guiaRequest.getIdManh()+credencialesDhl.getMessageReference(), 0, 32)+"</MessageReference>\n" +
"            <SiteID>"+utils.substr(credencialesDhl.getUsuario(), 0, 20)+"</SiteID>\n" +
"            <Password>"+utils.substr(credencialesDhl.getContrasenia(), 0, 12)+"</Password>\n" +
"        </ServiceHeader>\n"+
"        <MetaData>\n" +
"            <SoftwareName>ELEKTRAMIL APP</SoftwareName>\n" +
"            <SoftwareVersion>1.00</SoftwareVersion>\n" +
"        </MetaData>\n" +
"    </Request>\n" +
"    <RegionCode>"+utils.substr(credencialesDhl.getRegionCode(), 0, 2)+"</RegionCode>\n" +
"    <RequestedPickupTime>"+credencialesDhl.getRequestedPickupTime()+"</RequestedPickupTime>\n" +
"    <NewShipper>"+utils.substr(credencialesDhl.getNewShipper(), 0, 1)+"</NewShipper>\n" +
"    <LanguageCode>"+utils.substr(credencialesDhl.getLanguageCode(), 0, 2)+"</LanguageCode>\n" +
"    <PiecesEnabled>"+utils.substr(credencialesDhl.getPiecesRnabled(), 0, 1)+"</PiecesEnabled>\n" +
"    <Billing>\n" +
"        <ShipperAccountNumber>"+utils.substr(credencialesDhl.getNumcte(), 0, 12)+"</ShipperAccountNumber>\n" +
"        <ShippingPaymentType>"+utils.substr(credencialesDhl.getShippingPaymentType(), 0, 1)+"</ShippingPaymentType>\n" +
"    </Billing>\n" +
"    <Consignee>\n" +
"        <CompanyName>"+companyName+"</CompanyName>\n" +
"        <AddressLine>"+utils.substr(guiaRequest.getDestino().getDireccion()+(guiaRequest.getDestino().getnExt().equals("0")?" SN ":" No."+guiaRequest.getDestino().getnExt())+ (guiaRequest.getDestino().getnInt().equals("0")?"":"-" + guiaRequest.getDestino().getnInt()), 0, 35)+"</AddressLine>\n" +
"        <AddressLine>"+utils.substr(guiaRequest.getDestino().getColonia(), 0, 35)+"</AddressLine>\n" +
"        <City>"+utils.substr(guiaRequest.getDestino().getCiudad(), 0, 35)+"</City>\n" +
"        <PostalCode>"+utils.substr(guiaRequest.getDestino().getCp(), 0, 12)+"</PostalCode>\n" +
"        <CountryCode>"+utils.substr(guiaRequest.getPais3(), 0, 2)+"</CountryCode>\n" +
"        <CountryName>"+utils.substr(guiaRequest.getPais1(), 0, 35)+"</CountryName>\n" +
"        <Contact>\n" +
"            <PersonName>"+utils.substr(guiaRequest.getDestino().getContacto(), 0, 35)+"</PersonName>\n" +
"            <PhoneNumber>"+utils.substr(guiaRequest.getDestino().getTelefono(), 0, 25)+"</PhoneNumber>\n" +
"        </Contact>\n" +
"    </Consignee>\n" +
"    <Reference>\n" +
"        <ReferenceID>PAQUETE ELEKTRA</ReferenceID>\n" +
"        <ReferenceType>SKU</ReferenceType>\n" +
"    </Reference>\n" +
"    <ShipmentDetails>\n" +
"        <NumberOfPieces>"+cantidadCajas+"</NumberOfPieces>\n" +
"        <Pieces>\n" +
                    
contenido+
"        </Pieces>\n" +
"        <Weight>"+(int)Math.ceil(guiaRequest.getPeso())+"</Weight>\n" +
"        <WeightUnit>"+utils.substr(credencialesDhl.getWeightUnit(), 0, 1)+"</WeightUnit>\n" +
"        <GlobalProductCode>"+utils.substr(credencialesDhl.getGlobalCode(), 0, 4)+"</GlobalProductCode>\n" +
"        <Date>"+credencialesDhl.getFecha()+"</Date>\n" +
"        <Contents>PAQUETE ELEKTRA</Contents>\n" +
"        <DimensionUnit>"+utils.substr(credencialesDhl.getDimensionUnit(), 0, 1)+"</DimensionUnit>\n" +
"        <InsuredAmount>" +
        (guiaRequest.isSeguro() && guiaRequest.getIdTipoPedido()==6 ?
        guiaRequest.getCostoAsegurado()
        :"0"
        ) +
        "</InsuredAmount>\n" +
"        <CurrencyCode>"+utils.substr(credencialesDhl.getCurrencyCode(), 0, 3)+"</CurrencyCode>\n" +
"    </ShipmentDetails>\n" +
"    <Shipper>\n" +
"        <ShipperID>"+utils.substr(credencialesDhl.getNumcte(), 0, 30)+"</ShipperID>\n" +
"        <CompanyName>"+utils.substr(guiaRequest.getOrigen().getContacto(), 0, 35)+"</CompanyName>\n" +
"        <RegisteredAccount>"+credencialesDhl.getNumcte()+"</RegisteredAccount>\n" +
"        <AddressLine>"+utils.substr(guiaRequest.getOrigen().getDireccion(), 0, 35)+"</AddressLine>\n" +
"        <AddressLine>"+utils.substr(guiaRequest.getOrigen().getColonia(), 0, 35)+"</AddressLine>\n" +
"        <City>"+utils.substr(guiaRequest.getOrigen().getCiudad(), 0, 35)+"</City>\n" +
"        <PostalCode>"+utils.substr(guiaRequest.getOrigen().getCp(), 0, 12)+"</PostalCode>\n" +
"        <CountryCode>"+utils.substr(guiaRequest.getPais3(), 0, 2)+"</CountryCode>\n" +
"        <CountryName>"+utils.substr(guiaRequest.getPais1(), 0, 35)+"</CountryName>\n" +
"        <Contact>\n" +
"            <PersonName>"+utils.substr(guiaRequest.getOrigen().getContacto(), 0, 35)+"</PersonName>\n" +
"            <PhoneNumber>" + "018005101111"/*+utils.substr(guiaRequest.getTelefonoOrigen(), 0, 35)*/+"</PhoneNumber>\n" +
"        </Contact>\n" +
"    </Shipper>\n" +
        (guiaRequest.isSeguro() && guiaRequest.getIdTipoPedido()==6 ?
"    <SpecialService>\n" +
"        <SpecialServiceType>II</SpecialServiceType>\n" +
"    </SpecialService>\n"
        :""
        ) +
"    <LabelImageFormat>"+utils.substr(credencialesDhl.getLabelImageFormat(), 0, 4)+"</LabelImageFormat>\n" +
"</req:ShipmentRequest>	";

        return request;
    }
    
    @Override
    protected Object consumeWs() throws Exception{
        // AGREGAR OBJECT DE LA PETICION
        CredencialesDhl credencialesDhl = (CredencialesDhl) credenciales;
        DHLClient dHLClient = new DHLClient();
        String mensaje = "";
        String request = (String) peticion;
        if(!desarrollo){
            mensaje = dHLClient.ejecutar(request, credencialesDhl.getUrl(), proxy);
            if(mensaje.equals(""))
                mensaje = null;
        }
        
        return mensaje;
    }
    
    @Override
    protected GuiaResponse procesaRespuesta() throws Exception{
        
        GuiaResponse guiaResponse = new GuiaResponse();
        GetNodes getnodes = new GetNodes();
        List<String> response = new ArrayList<>();
        String mensaje = (String) respuesta;
        List<String> nodos = new ArrayList<>();

            nodos.add("ConditionData");
            nodos.add("ConditionCode");
            nodos.add("AirwayBillNumber");
            nodos.add("OutputImage");
        
        guiaResponse.setInput((String) peticion);
        guiaResponse.setOutput((String) respuesta);
        
        try {
            if(!desarrollo){
                getnodes.setstring(mensaje);
                response = getnodes.getNodes(nodos);
            }

            if(desarrollo){
                System.out.println("DHL: DUMMY Response...");
                guiaResponse.setIdEstatusGuia(10);
                guiaResponse.setMensaje(null);
                guiaResponse.setEtiqueta("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37ik7jrjaL1qbx9bdbJZbttHdXep7uluSK1v1WN33zc5FD/1CAhwf2PivC98N/bdoTY+avhJOYXsi9fmJW8IuttQj/sXf7kJmxNyT93jd6YM9teoPUn7Hv79F2eC22cKZW5kc3RyZWFtCmVuZG9iago3IDAgb2JqCjw8L0NvbnRlbnRzIDggMCBSL1R5cGUvUGFnZS9SZXNvdXJjZXM8PC9Qcm9jU2V0Wy9QREYvVGV4dC9JbWFnZUIvSW1hZ2VDL0ltYWdlSV0vWE9iamVjdDw8L1hmMSA5IDAgUj4+Pj4vUGFyZW50IDYgMCBSL01lZGlhQm94WzAgMCA4NDEuODkgNTk1LjI4XT4+CmVuZG9iago2IDAgb2JqCjw8L0tpZHNbMSAwIFIgNyAwIFJdL1R5cGUvUGFnZXMvQ291bnQgMi9JVFhUKDIuMS43KT4+CmVuZG9iagoxMiAwIG9iago8PC9UeXBlL0NhdGFsb2cvUGFnZXMgNiAwIFI+PgplbmRvYmoKMTMgMCBvYmoKPDwvTW9kRGF0ZShEOjIwMjAwNDA2MTkyNjQ4WikvQ3JlYXRpb25EYXRlKEQ6MjAyMDA0MDYxOTI2NDhaKS9Qcm9kdWNlcihpVGV4dCAyLjEuNyBieSAxVDNYVCk+PgplbmRvYmoKeHJlZgowIDE0CjAwMDAwMDAwMDAgNjU1MzUgZiAKMDAwMDAwNDU5OSAwMDAwMCBuIAowMDAwMDAwMDE1IDAwMDAwIG4gCjAwMDAwMDAzMTMgMDAwMDAgbiAKMDAwMDAwMDEzMiAwMDAwMCBuIAowMDAwMDAwMjI1IDAwMDAwIG4gCjAwMDAwMDgzNzUgMDAwMDAgbiAKMDAwMDAwODIxMyAwMDAwMCBuIAowMDAwMDA0NzYxIDAwMDAwIG4gCjAwMDAwMDUwNjEgMDAwMDAgbiAKMDAwMDAwNDg3OCAwMDAwMCBuIAowMDAwMDA0OTcyIDAwMDAwIG4gCjAwMDAwMDg0NDQgMDAwMDAgbiAKMDAwMDAwODQ5MCAwMDAwMCBuIAp0cmFpbGVyCjw8L0luZm8gMTMgMCBSL0lEIFs8NWZmZDQ0OWIxZGRjMWVkMGY4NDU4ZThlYjRhYWI2NTc+PDE2MGQzNTY5OTVmMTEzMDdlNDBjMGZlY2ZiOTYwZjRjPl0vUm9vdCAxMiAwIFIvU2l6ZSAxND4+CnN0YXJ0eHJlZgo4NjAxCiUlRU9GCg==");
                guiaResponse.setNumGuia("6739722360");
                guiaResponse.setCarrier(guiaRequest.getIdCarrier());
            }else{
                if(response.get(2).equals("")){
                    guiaResponse.setIdEstatusGuia(-1);
                    guiaResponse.setMensaje(response.get(0));
                    guiaResponse.setEtiqueta("GWSC"+guiaRequest.getIdCarrier()+"R"+response.get(0));
                    guiaResponse.setNumGuia(null);
    //                generalDao.insXml("-1", response.get(1), response.get(0), request, mensaje, datosGuias.getPedido(), datosGuias.getOrderId(), datosGuias.getCdId(), datosGuias.getIdCarrier(), "Guias DHL", idCajaHdr+"");
                }
                else{
                    guiaResponse.setIdEstatusGuia(10);
                    guiaResponse.setMensaje(null);
                    guiaResponse.setEtiqueta(response.get(3));
                    guiaResponse.setNumGuia(response.get(2));
                    guiaResponse.setCarrier(guiaRequest.getIdCarrier());
                    guiaResponse.setEncrypt(1);
    //                guiasDao.insEtiqueta(datosGuias, guiasResponse.getNumGuia(), guiasResponse.getEtiqueta(), idCajaHdr);
    //                generalDao.insXml("10", guiasResponse.getNumGuia(), guiasResponse.getNumGuia(), request, mensaje, datosGuias.getPedido(), datosGuias.getOrderId(), datosGuias.getCdId(), datosGuias.getIdCarrier(), "Guias DHL", idCajaHdr+"");
                }
            }
        }catch(Exception e){
            guiaResponse.setMensaje(e.getMessage());
            guiaResponse.setIdEstatusGuia(-1);
            guiaResponse.setNumGuia("");
        }
        return guiaResponse;
    }

}
