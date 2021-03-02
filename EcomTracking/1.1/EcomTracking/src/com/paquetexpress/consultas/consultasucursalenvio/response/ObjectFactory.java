
package com.paquetexpress.consultas.consultasucursalenvio.response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.paquetexpress.consultas.consultasucursalenvio.response package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataAditional1_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "dataAditional1");
    private final static QName _DataAditional2_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "dataAditional2");
    private final static QName _DataAditional3_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "dataAditional3");
    private final static QName _DataAditional4_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "dataAditional4");
    private final static QName _Telefonos_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "telefonos");
    private final static QName _CveMsjeRetorno_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "cveMsjeRetorno");
    private final static QName _TipoMsje_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "tipoMsje");
    private final static QName _Sucursal_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "sucursal");
    private final static QName _ValorDataAd_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "valorDataAd");
    private final static QName _ClaveDataAd_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "claveDataAd");
    private final static QName _TratamientoMsje_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "tratamientoMsje");
    private final static QName _Direccion_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "direccion");
    private final static QName _DesMsjeRetorno_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", "desMsjeRetorno");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.paquetexpress.consultas.consultasucursalenvio.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link RetornoSolicitud }
     * 
     */
    public RetornoSolicitud createRetornoSolicitud() {
        return new RetornoSolicitud();
    }

    /**
     * Create an instance of {@link Mensajes }
     * 
     */
    public Mensajes createMensajes() {
        return new Mensajes();
    }

    /**
     * Create an instance of {@link DatosAdicionales }
     * 
     */
    public DatosAdicionales createDatosAdicionales() {
        return new DatosAdicionales();
    }

    /**
     * Create an instance of {@link DatoAdicional }
     * 
     */
    public DatoAdicional createDatoAdicional() {
        return new DatoAdicional();
    }

    /**
     * Create an instance of {@link DataResponse }
     * 
     */
    public DataResponse createDataResponse() {
        return new DataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "dataAditional1")
    public JAXBElement<String> createDataAditional1(String value) {
        return new JAXBElement<String>(_DataAditional1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "dataAditional2")
    public JAXBElement<String> createDataAditional2(String value) {
        return new JAXBElement<String>(_DataAditional2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "dataAditional3")
    public JAXBElement<String> createDataAditional3(String value) {
        return new JAXBElement<String>(_DataAditional3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "dataAditional4")
    public JAXBElement<String> createDataAditional4(String value) {
        return new JAXBElement<String>(_DataAditional4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "telefonos")
    public JAXBElement<String> createTelefonos(String value) {
        return new JAXBElement<String>(_Telefonos_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "cveMsjeRetorno")
    public JAXBElement<Integer> createCveMsjeRetorno(Integer value) {
        return new JAXBElement<Integer>(_CveMsjeRetorno_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "tipoMsje")
    public JAXBElement<String> createTipoMsje(String value) {
        return new JAXBElement<String>(_TipoMsje_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "sucursal")
    public JAXBElement<String> createSucursal(String value) {
        return new JAXBElement<String>(_Sucursal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "valorDataAd")
    public JAXBElement<String> createValorDataAd(String value) {
        return new JAXBElement<String>(_ValorDataAd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "claveDataAd")
    public JAXBElement<String> createClaveDataAd(String value) {
        return new JAXBElement<String>(_ClaveDataAd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "tratamientoMsje")
    public JAXBElement<String> createTratamientoMsje(String value) {
        return new JAXBElement<String>(_TratamientoMsje_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "direccion")
    public JAXBElement<String> createDireccion(String value) {
        return new JAXBElement<String>(_Direccion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaSucursalEnvio/Response", name = "desMsjeRetorno")
    public JAXBElement<String> createDesMsjeRetorno(String value) {
        return new JAXBElement<String>(_DesMsjeRetorno_QNAME, String.class, null, value);
    }

}
