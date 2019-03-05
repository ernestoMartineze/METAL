
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

    private final static QName _ConsultaDetalleFacturas_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultaDetalleFacturas");
    private final static QName _ConsultaDetalleFacturasResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultaDetalleFacturasResponse");
    private final static QName _ConsultarLCFacturas_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarLCFacturas");
    private final static QName _ConsultarLCFacturasResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarLCFacturasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.frisa.tic.negocio.ws
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaDetalleFacturas }
     *
     */
    public ConsultaDetalleFacturas createConsultaDetalleFacturas() {
        return new ConsultaDetalleFacturas();
    }

    /**
     * Create an instance of {@link ConsultaDetalleFacturasResponse }
     *
     */
    public ConsultaDetalleFacturasResponse createConsultaDetalleFacturasResponse() {
        return new ConsultaDetalleFacturasResponse();
    }

    /**
     * Create an instance of {@link ConsultarLCFacturas }
     *
     */
    public ConsultarLCFacturas createConsultarLCFacturas() {
        return new ConsultarLCFacturas();
    }

    /**
     * Create an instance of {@link ConsultarLCFacturasResponse }
     *
     */
    public ConsultarLCFacturasResponse createConsultarLCFacturasResponse() {
        return new ConsultarLCFacturasResponse();
    }

    /**
     * Create an instance of {@link RespuestaDetalleFacturaDTO }
     *
     */
    public RespuestaDetalleFacturaDTO createRespuestaDetalleFacturaDTO() {
        return new RespuestaDetalleFacturaDTO();
    }

    /**
     * Create an instance of {@link FacturaLCDTO }
     *
     */
    public FacturaLCDTO createFacturaLCDTO() {
        return new FacturaLCDTO();
    }

    /**
     * Create an instance of {@link CabeceraFacturaDTO }
     *
     */
    public CabeceraFacturaDTO createCabeceraFacturaDTO() {
        return new CabeceraFacturaDTO();
    }

    /**
     * Create an instance of {@link LineasFacturaDTO }
     *
     */
    public LineasFacturaDTO createLineasFacturaDTO() {
        return new LineasFacturaDTO();
    }

    /**
     * Create an instance of {@link LineaDTO }
     *
     */
    public LineaDTO createLineaDTO() {
        return new LineaDTO();
    }

    /**
     * Create an instance of {@link Proceso }
     *
     */
    public Proceso createProceso() {
        return new Proceso();
    }

    /**
     * Create an instance of {@link RespuestaLCFacturaDTO }
     *
     */
    public RespuestaLCFacturaDTO createRespuestaLCFacturaDTO() {
        return new RespuestaLCFacturaDTO();
    }

    /**
     * Create an instance of {@link LcFacturaDTO }
     *
     */
    public LcFacturaDTO createLcFacturaDTO() {
        return new LcFacturaDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaDetalleFacturas }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultaDetalleFacturas }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultaDetalleFacturas")
    public JAXBElement<ConsultaDetalleFacturas> createConsultaDetalleFacturas(ConsultaDetalleFacturas value) {
        return new JAXBElement<ConsultaDetalleFacturas>(_ConsultaDetalleFacturas_QNAME, ConsultaDetalleFacturas.class,
                                                        null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaDetalleFacturasResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultaDetalleFacturasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultaDetalleFacturasResponse")
    public JAXBElement<ConsultaDetalleFacturasResponse> createConsultaDetalleFacturasResponse(ConsultaDetalleFacturasResponse value) {
        return new JAXBElement<ConsultaDetalleFacturasResponse>(_ConsultaDetalleFacturasResponse_QNAME,
                                                                ConsultaDetalleFacturasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarLCFacturas }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarLCFacturas }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarLCFacturas")
    public JAXBElement<ConsultarLCFacturas> createConsultarLCFacturas(ConsultarLCFacturas value) {
        return new JAXBElement<ConsultarLCFacturas>(_ConsultarLCFacturas_QNAME, ConsultarLCFacturas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarLCFacturasResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarLCFacturasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarLCFacturasResponse")
    public JAXBElement<ConsultarLCFacturasResponse> createConsultarLCFacturasResponse(ConsultarLCFacturasResponse value) {
        return new JAXBElement<ConsultarLCFacturasResponse>(_ConsultarLCFacturasResponse_QNAME,
                                                            ConsultarLCFacturasResponse.class, null, value);
    }

}
