
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

    private final static QName _ActualizarAcceso_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "actualizarAcceso");
    private final static QName _ActualizarAccesoResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "actualizarAccesoResponse");
    private final static QName _AgregarUsuario_QNAME = new QName("http://ws.negocio.tic.frisa.mx/", "agregarUsuario");
    private final static QName _AgregarUsuarioResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "agregarUsuarioResponse");
    private final static QName _ConsultarAccesos_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarAccesos");
    private final static QName _ConsultarAccesosResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarAccesosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.frisa.tic.negocio.ws
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarAcceso }
     *
     */
    public ActualizarAcceso createActualizarAcceso() {
        return new ActualizarAcceso();
    }

    /**
     * Create an instance of {@link ActualizarAccesoResponse }
     *
     */
    public ActualizarAccesoResponse createActualizarAccesoResponse() {
        return new ActualizarAccesoResponse();
    }

    /**
     * Create an instance of {@link AgregarUsuario }
     *
     */
    public AgregarUsuario createAgregarUsuario() {
        return new AgregarUsuario();
    }

    /**
     * Create an instance of {@link AgregarUsuarioResponse }
     *
     */
    public AgregarUsuarioResponse createAgregarUsuarioResponse() {
        return new AgregarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ConsultarAccesos }
     *
     */
    public ConsultarAccesos createConsultarAccesos() {
        return new ConsultarAccesos();
    }

    /**
     * Create an instance of {@link ConsultarAccesosResponse }
     *
     */
    public ConsultarAccesosResponse createConsultarAccesosResponse() {
        return new ConsultarAccesosResponse();
    }

    /**
     * Create an instance of {@link RespuestaDTO }
     *
     */
    public RespuestaDTO createRespuestaDTO() {
        return new RespuestaDTO();
    }

    /**
     * Create an instance of {@link AgregarUsuarioDTO }
     *
     */
    public AgregarUsuarioDTO createAgregarUsuarioDTO() {
        return new AgregarUsuarioDTO();
    }

    /**
     * Create an instance of {@link ConsultarAccesoUsuarioDTO }
     *
     */
    public ConsultarAccesoUsuarioDTO createConsultarAccesoUsuarioDTO() {
        return new ConsultarAccesoUsuarioDTO();
    }

    /**
     * Create an instance of {@link AccesoUsuarioDTO }
     *
     */
    public AccesoUsuarioDTO createAccesoUsuarioDTO() {
        return new AccesoUsuarioDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarAcceso }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActualizarAcceso }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "actualizarAcceso")
    public JAXBElement<ActualizarAcceso> createActualizarAcceso(ActualizarAcceso value) {
        return new JAXBElement<ActualizarAcceso>(_ActualizarAcceso_QNAME, ActualizarAcceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarAccesoResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActualizarAccesoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "actualizarAccesoResponse")
    public JAXBElement<ActualizarAccesoResponse> createActualizarAccesoResponse(ActualizarAccesoResponse value) {
        return new JAXBElement<ActualizarAccesoResponse>(_ActualizarAccesoResponse_QNAME,
                                                         ActualizarAccesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarUsuario }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgregarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "agregarUsuario")
    public JAXBElement<AgregarUsuario> createAgregarUsuario(AgregarUsuario value) {
        return new JAXBElement<AgregarUsuario>(_AgregarUsuario_QNAME, AgregarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarUsuarioResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgregarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "agregarUsuarioResponse")
    public JAXBElement<AgregarUsuarioResponse> createAgregarUsuarioResponse(AgregarUsuarioResponse value) {
        return new JAXBElement<AgregarUsuarioResponse>(_AgregarUsuarioResponse_QNAME, AgregarUsuarioResponse.class,
                                                       null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAccesos }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarAccesos }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarAccesos")
    public JAXBElement<ConsultarAccesos> createConsultarAccesos(ConsultarAccesos value) {
        return new JAXBElement<ConsultarAccesos>(_ConsultarAccesos_QNAME, ConsultarAccesos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAccesosResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarAccesosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarAccesosResponse")
    public JAXBElement<ConsultarAccesosResponse> createConsultarAccesosResponse(ConsultarAccesosResponse value) {
        return new JAXBElement<ConsultarAccesosResponse>(_ConsultarAccesosResponse_QNAME,
                                                         ConsultarAccesosResponse.class, null, value);
    }

}
