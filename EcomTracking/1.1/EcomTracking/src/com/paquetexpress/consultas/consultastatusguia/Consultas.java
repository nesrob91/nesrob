
package com.paquetexpress.consultas.consultastatusguia;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "consultas", targetNamespace = "http://www.paquetexpress.com/consultas/consultaStatusGuia")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.paquetexpress.consultas.consultastatusguia.ObjectFactory.class,
    com.paquetexpress.consultas.consultastatusguia.response.ObjectFactory.class,
    com.paquetexpress.consultas.consultasucursalenvio.ObjectFactory.class,
    com.paquetexpress.consultas.consultasucursalenvio.response.ObjectFactory.class,
    com.paquetexpress.consultas.consultatiempoestimadoguia.ObjectFactory.class,
    com.paquetexpress.consultas.consultatiempoestimadoguia.response.ObjectFactory.class
})
public interface Consultas {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.paquetexpress.consultas.consultastatusguia.response.DataResponse
     */
    @WebMethod(action = "http://www.paquetexpress.com/consultas/consultaStatusGuia")
    @WebResult(name = "DataResponse", targetNamespace = "http://www.paquetexpress.com/consultas/consultaStatusGuia/Response", partName = "parameters")
    public com.paquetexpress.consultas.consultastatusguia.response.DataResponse consultaStatusGuia(
        @WebParam(name = "Data", targetNamespace = "http://www.paquetexpress.com/consultas/consultaStatusGuia", partName = "parameters")
        com.paquetexpress.consultas.consultastatusguia.Data parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.paquetexpress.consultas.consultasucursalenvio.response.DataResponse
     */
    @WebMethod(action = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio")
    @WebResult(name = "DataResponse", targetNamespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", partName = "parameters")
    public com.paquetexpress.consultas.consultasucursalenvio.response.DataResponse consultaSucursalEnvio(
        @WebParam(name = "Data", targetNamespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio", partName = "parameters")
        com.paquetexpress.consultas.consultasucursalenvio.Data parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.paquetexpress.consultas.consultatiempoestimadoguia.response.DataResponse
     */
    @WebMethod(action = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia")
    @WebResult(name = "DataResponse", targetNamespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia/Response", partName = "parameters")
    public com.paquetexpress.consultas.consultatiempoestimadoguia.response.DataResponse consultaTiempoEstimadoGuia(
        @WebParam(name = "Data", targetNamespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", partName = "parameters")
        com.paquetexpress.consultas.consultatiempoestimadoguia.Data parameters);

}
