
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

    private final static QName _AgregarUsuario_QNAME = new QName("http://ws.negocio.tic.frisa.mx/", "agregarUsuario");
    private final static QName _AgregarUsuarioResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "agregarUsuarioResponse");
    private final static QName _ConsultarUsuario_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarUsuario");
    private final static QName _ConsultarUsuarioResponse_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "consultarUsuarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.frisa.tic.negocio.ws
     *
     */
    public ObjectFactory() {
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
     * Create an instance of {@link ConsultarUsuario }
     *
     */
    public ConsultarUsuario createConsultarUsuario() {
        return new ConsultarUsuario();
    }

    /**
     * Create an instance of {@link ConsultarUsuarioResponse }
     *
     */
    public ConsultarUsuarioResponse createConsultarUsuarioResponse() {
        return new ConsultarUsuarioResponse();
    }

    /**
     * Create an instance of {@link AgregarUsuarioDTO }
     *
     */
    public AgregarUsuarioDTO createAgregarUsuarioDTO() {
        return new AgregarUsuarioDTO();
    }

    /**
     * Create an instance of {@link RespuestaDTO }
     *
     */
    public RespuestaDTO createRespuestaDTO() {
        return new RespuestaDTO();
    }

    /**
     * Create an instance of {@link ConsultarUsuarioDTO }
     *
     */
    public ConsultarUsuarioDTO createConsultarUsuarioDTO() {
        return new ConsultarUsuarioDTO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarUsuario }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarUsuario")
    public JAXBElement<ConsultarUsuario> createConsultarUsuario(ConsultarUsuario value) {
        return new JAXBElement<ConsultarUsuario>(_ConsultarUsuario_QNAME, ConsultarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarUsuarioResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.negocio.tic.frisa.mx/", name = "consultarUsuarioResponse")
    public JAXBElement<ConsultarUsuarioResponse> createConsultarUsuarioResponse(ConsultarUsuarioResponse value) {
        return new JAXBElement<ConsultarUsuarioResponse>(_ConsultarUsuarioResponse_QNAME,
                                                         ConsultarUsuarioResponse.class, null, value);
    }

}
