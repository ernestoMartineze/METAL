
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

    private final static QName _AplicarPagoManual_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "aplicarPagoManual");
    private final static QName _AplicarPagoManualResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "aplicarPagoManualResponse");
    private final static QName _ConsultarPagosSinReferencia_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarPagosSinReferencia");
    private final static QName _ConsultarPagosSinReferenciaResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarPagosSinReferenciaResponse");
    private final static QName _ConsultarReferenciaLCExistente_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarReferenciaLCExistente");
    private final static QName _ConsultarReferenciaLCExistenteResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarReferenciaLCExistenteResponse");
    private final static QName _GenerarPago_QNAME = new QName("http://ws.negocio.tic.frisa.mx/", "generarPago");
    private final static QName _GenerarPagoResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "generarPagoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.frisa.tic.negocio.ws
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AplicarPagoManual }
     *
     */
    public AplicarPagoManual createAplicarPagoManual() {
        return new AplicarPagoManual();
    }

    /**
     * Create an instance of {@link AplicarPagoManualResponse }
     *
     */
    public AplicarPagoManualResponse createAplicarPagoManualResponse() {
        return new AplicarPagoManualResponse();
    }

    /**
     * Create an instance of {@link ConsultarPagosSinReferencia }
     *
     */
    public ConsultarPagosSinReferencia createConsultarPagosSinReferencia() {
        return new ConsultarPagosSinReferencia();
    }

    /**
     * Create an instance of {@link ConsultarPagosSinReferenciaResponse }
     *
     */
    public ConsultarPagosSinReferenciaResponse createConsultarPagosSinReferenciaResponse() {
        return new ConsultarPagosSinReferenciaResponse();
    }

    /**
     * Create an instance of {@link ConsultarReferenciaLCExistente }
     *
     */
    public ConsultarReferenciaLCExistente createConsultarReferenciaLCExistente() {
        return new ConsultarReferenciaLCExistente();
    }

    /**
     * Create an instance of {@link ConsultarReferenciaLCExistenteResponse }
     *
     */
    public ConsultarReferenciaLCExistenteResponse createConsultarReferenciaLCExistenteResponse() {
        return new ConsultarReferenciaLCExistenteResponse();
    }

    /**
     * Create an instance of {@link GenerarPago }
     *
     */
    public GenerarPago createGenerarPago() {
        return new GenerarPago();
    }

    /**
     * Create an instance of {@link GenerarPagoResponse }
     *
     */
    public GenerarPagoResponse createGenerarPagoResponse() {
        return new GenerarPagoResponse();
    }

    /**
     * Create an instance of {@link AplicarPagoDTO }
     *
     */
    public AplicarPagoDTO createAplicarPagoDTO() {
        return new AplicarPagoDTO();
    }

    /**
     * Create an instance of {@link PagoPorAplicarDTO }
     *
     */
    public PagoPorAplicarDTO createPagoPorAplicarDTO() {
        return new PagoPorAplicarDTO();
    }

    /**
     * Create an instance of {@link RespuestaAplicarPagoDTO }
     *
     */
    public RespuestaAplicarPagoDTO createRespuestaAplicarPagoDTO() {
        return new RespuestaAplicarPagoDTO();
    }

    /**
     * Create an instance of {@link Proceso }
     *
     */
    public Proceso createProceso() {
        return new Proceso();
    }

    /**
     * Create an instance of {@link FiltroPagoSinReferencia }
     *
     */
    public FiltroPagoSinReferencia createFiltroPagoSinReferencia() {
        return new FiltroPagoSinReferencia();
    }

    /**
     * Create an instance of {@link RespuestaPagoSinReferencia }
     *
     */
    public RespuestaPagoSinReferencia createRespuestaPagoSinReferencia() {
        return new RespuestaPagoSinReferencia();
    }

    /**
     * Create an instance of {@link LineaEstadoCuentaDTO }
     *
     */
    public LineaEstadoCuentaDTO createLineaEstadoCuentaDTO() {
        return new LineaEstadoCuentaDTO();
    }

    /**
     * Create an instance of {@link PeticionExistente }
     *
     */
    public PeticionExistente createPeticionExistente() {
        return new PeticionExistente();
    }

    /**
     * Create an instance of {@link RespuestaClienteDTO }
     *
     */
    public RespuestaClienteDTO createRespuestaClienteDTO() {
        return new RespuestaClienteDTO();
    }

    /**
     * Create an instance of {@link PagoDTO }
     *
     */
    public PagoDTO createPagoDTO() {
        return new PagoDTO();
    }

    /**
     * Create an instance of {@link RespuestaProcesaFacturasDTO }
     *
     */
    public RespuestaProcesaFacturasDTO createRespuestaProcesaFacturasDTO() {
        return new RespuestaProcesaFacturasDTO();
    }

    /**
     * Create an instance of {@link FacturaPagoDTO }
     *
     */
    public FacturaPagoDTO createFacturaPagoDTO() {
        return new FacturaPagoDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AplicarPagoManual }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AplicarPagoManual }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "aplicarPagoManual")
    public JAXBElement<AplicarPagoManual> createAplicarPagoManual(AplicarPagoManual value) {
        return new JAXBElement<AplicarPagoManual>(_AplicarPagoManual_QNAME, AplicarPagoManual.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AplicarPagoManualResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AplicarPagoManualResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "aplicarPagoManualResponse")
    public JAXBElement<AplicarPagoManualResponse> createAplicarPagoManualResponse(AplicarPagoManualResponse value) {
        return new JAXBElement<AplicarPagoManualResponse>(_AplicarPagoManualResponse_QNAME,
                                                          AplicarPagoManualResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPagosSinReferencia }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarPagosSinReferencia }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarPagosSinReferencia")
    public JAXBElement<ConsultarPagosSinReferencia> createConsultarPagosSinReferencia(ConsultarPagosSinReferencia value) {
        return new JAXBElement<ConsultarPagosSinReferencia>(_ConsultarPagosSinReferencia_QNAME,
                                                            ConsultarPagosSinReferencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPagosSinReferenciaResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarPagosSinReferenciaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarPagosSinReferenciaResponse")
    public JAXBElement<ConsultarPagosSinReferenciaResponse> createConsultarPagosSinReferenciaResponse(ConsultarPagosSinReferenciaResponse value) {
        return new JAXBElement<ConsultarPagosSinReferenciaResponse>(_ConsultarPagosSinReferenciaResponse_QNAME,
                                                                    ConsultarPagosSinReferenciaResponse.class, null,
                                                                    value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarReferenciaLCExistente }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarReferenciaLCExistente }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarReferenciaLCExistente")
    public JAXBElement<ConsultarReferenciaLCExistente> createConsultarReferenciaLCExistente(ConsultarReferenciaLCExistente value) {
        return new JAXBElement<ConsultarReferenciaLCExistente>(_ConsultarReferenciaLCExistente_QNAME,
                                                               ConsultarReferenciaLCExistente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarReferenciaLCExistenteResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarReferenciaLCExistenteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarReferenciaLCExistenteResponse")
    public JAXBElement<ConsultarReferenciaLCExistenteResponse> createConsultarReferenciaLCExistenteResponse(ConsultarReferenciaLCExistenteResponse value) {
        return new JAXBElement<ConsultarReferenciaLCExistenteResponse>(_ConsultarReferenciaLCExistenteResponse_QNAME,
                                                                       ConsultarReferenciaLCExistenteResponse.class,
                                                                       null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPago }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenerarPago }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "generarPago")
    public JAXBElement<GenerarPago> createGenerarPago(GenerarPago value) {
        return new JAXBElement<GenerarPago>(_GenerarPago_QNAME, GenerarPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPagoResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenerarPagoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "generarPagoResponse")
    public JAXBElement<GenerarPagoResponse> createGenerarPagoResponse(GenerarPagoResponse value) {
        return new JAXBElement<GenerarPagoResponse>(_GenerarPagoResponse_QNAME, GenerarPagoResponse.class, null, value);
    }

}
