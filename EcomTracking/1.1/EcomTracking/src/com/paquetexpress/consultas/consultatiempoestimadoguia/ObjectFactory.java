
package com.paquetexpress.consultas.consultatiempoestimadoguia;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.paquetexpress.consultas.consultatiempoestimadoguia package. 
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

    private final static QName _AgreementKey_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "agreementKey");
    private final static QName _CodigoPostalOrigen_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "codigoPostalOrigen");
    private final static QName _DataAditional1_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "dataAditional1");
    private final static QName _DataAditional2_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "dataAditional2");
    private final static QName _DataAditional3_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "dataAditional3");
    private final static QName _DataAditional4_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "dataAditional4");
    private final static QName _ValorDataAd_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "valorDataAd");
    private final static QName _ClaveDataAd_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "claveDataAd");
    private final static QName _TypeEvent_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "typeEvent");
    private final static QName _OrgnSystem_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "orgnSystem");
    private final static QName _CodigoPostalDestino_QNAME = new QName("http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", "codigoPostalDestino");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.paquetexpress.consultas.consultatiempoestimadoguia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link SolicitudEnvio }
     * 
     */
    public SolicitudEnvio createSolicitudEnvio() {
        return new SolicitudEnvio();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "agreementKey")
    public JAXBElement<String> createAgreementKey(String value) {
        return new JAXBElement<String>(_AgreementKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "codigoPostalOrigen")
    public JAXBElement<String> createCodigoPostalOrigen(String value) {
        return new JAXBElement<String>(_CodigoPostalOrigen_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "dataAditional1")
    public JAXBElement<String> createDataAditional1(String value) {
        return new JAXBElement<String>(_DataAditional1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "dataAditional2")
    public JAXBElement<String> createDataAditional2(String value) {
        return new JAXBElement<String>(_DataAditional2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "dataAditional3")
    public JAXBElement<String> createDataAditional3(String value) {
        return new JAXBElement<String>(_DataAditional3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "dataAditional4")
    public JAXBElement<String> createDataAditional4(String value) {
        return new JAXBElement<String>(_DataAditional4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "valorDataAd")
    public JAXBElement<String> createValorDataAd(String value) {
        return new JAXBElement<String>(_ValorDataAd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "claveDataAd")
    public JAXBElement<String> createClaveDataAd(String value) {
        return new JAXBElement<String>(_ClaveDataAd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "typeEvent")
    public JAXBElement<String> createTypeEvent(String value) {
        return new JAXBElement<String>(_TypeEvent_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "orgnSystem")
    public JAXBElement<String> createOrgnSystem(String value) {
        return new JAXBElement<String>(_OrgnSystem_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.paquetexpress.com/consultas/consultaTiempoEstimadoGuia", name = "codigoPostalDestino")
    public JAXBElement<String> createCodigoPostalDestino(String value) {
        return new JAXBElement<String>(_CodigoPostalDestino_QNAME, String.class, null, value);
    }

}
