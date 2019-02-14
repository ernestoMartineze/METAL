
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the mx.frisa.tic.negocio.ws package.
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

    private final static QName _ConsultarCuentaBancaria_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarCuentaBancaria");
    private final static QName _ConsultarCuentaBancariaResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarCuentaBancariaResponse");
    private final static QName _ConsultarPais_QNAME = new QName("http://ws.negocio.tic.frisa.mx/", "consultarPais");
    private final static QName _ConsultarPaisResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarPaisResponse");
    private final static QName _ConsultarTipoMoneda_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarTipoMoneda");
    private final static QName _ConsultarTipoMonedaResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarTipoMonedaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.frisa.tic.negocio.ws
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarCuentaBancaria }
     *
     */
    public ConsultarCuentaBancaria createConsultarCuentaBancaria() {
        return new ConsultarCuentaBancaria();
    }

    /**
     * Create an instance of {@link ConsultarCuentaBancariaResponse }
     *
     */
    public ConsultarCuentaBancariaResponse createConsultarCuentaBancariaResponse() {
        return new ConsultarCuentaBancariaResponse();
    }

    /**
     * Create an instance of {@link ConsultarPais }
     *
     */
    public ConsultarPais createConsultarPais() {
        return new ConsultarPais();
    }

    /**
     * Create an instance of {@link ConsultarPaisResponse }
     *
     */
    public ConsultarPaisResponse createConsultarPaisResponse() {
        return new ConsultarPaisResponse();
    }

    /**
     * Create an instance of {@link ConsultarTipoMoneda }
     *
     */
    public ConsultarTipoMoneda createConsultarTipoMoneda() {
        return new ConsultarTipoMoneda();
    }

    /**
     * Create an instance of {@link ConsultarTipoMonedaResponse }
     *
     */
    public ConsultarTipoMonedaResponse createConsultarTipoMonedaResponse() {
        return new ConsultarTipoMonedaResponse();
    }

    /**
     * Create an instance of {@link CuentaBancariaDTO }
     *
     */
    public CuentaBancariaDTO createCuentaBancariaDTO() {
        return new CuentaBancariaDTO();
    }

    /**
     * Create an instance of {@link TipoMonedaDTO }
     *
     */
    public TipoMonedaDTO createTipoMonedaDTO() {
        return new TipoMonedaDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaBancaria }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaBancaria }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarCuentaBancaria")
    public JAXBElement<ConsultarCuentaBancaria> createConsultarCuentaBancaria(ConsultarCuentaBancaria value) {
        return new JAXBElement<ConsultarCuentaBancaria>(_ConsultarCuentaBancaria_QNAME, ConsultarCuentaBancaria.class,
                                                        null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaBancariaResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaBancariaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarCuentaBancariaResponse")
    public JAXBElement<ConsultarCuentaBancariaResponse> createConsultarCuentaBancariaResponse(ConsultarCuentaBancariaResponse value) {
        return new JAXBElement<ConsultarCuentaBancariaResponse>(_ConsultarCuentaBancariaResponse_QNAME,
                                                                ConsultarCuentaBancariaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPais }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarPais }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarPais")
    public JAXBElement<ConsultarPais> createConsultarPais(ConsultarPais value) {
        return new JAXBElement<ConsultarPais>(_ConsultarPais_QNAME, ConsultarPais.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPaisResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarPaisResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarPaisResponse")
    public JAXBElement<ConsultarPaisResponse> createConsultarPaisResponse(ConsultarPaisResponse value) {
        return new JAXBElement<ConsultarPaisResponse>(_ConsultarPaisResponse_QNAME, ConsultarPaisResponse.class, null,
                                                      value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarTipoMoneda }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarTipoMoneda }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarTipoMoneda")
    public JAXBElement<ConsultarTipoMoneda> createConsultarTipoMoneda(ConsultarTipoMoneda value) {
        return new JAXBElement<ConsultarTipoMoneda>(_ConsultarTipoMoneda_QNAME, ConsultarTipoMoneda.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarTipoMonedaResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarTipoMonedaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarTipoMonedaResponse")
    public JAXBElement<ConsultarTipoMonedaResponse> createConsultarTipoMonedaResponse(ConsultarTipoMonedaResponse value) {
        return new JAXBElement<ConsultarTipoMonedaResponse>(_ConsultarTipoMonedaResponse_QNAME,
                                                            ConsultarTipoMonedaResponse.class, null, value);
    }

}
