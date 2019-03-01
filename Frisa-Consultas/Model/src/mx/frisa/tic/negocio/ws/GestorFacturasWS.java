
package mx.frisa.tic.negocio.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-b170214.1743
 * Generated source version: 2.2
 *
 */
@WebService(name = "GestorFacturasWS", targetNamespace = "http://ws.negocio.tic.frisa.mx/")
@XmlSeeAlso({ ObjectFactory.class })
public interface GestorFacturasWS {


    /**
     *
     * @param lineaCaptura
     * @return
     *     returns mx.frisa.tic.negocio.ws.RespuestaLCFacturaDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarLCFacturas", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                    className = "mx.frisa.tic.negocio.ws.ConsultarLCFacturas")
    @ResponseWrapper(localName = "consultarLCFacturasResponse", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                     className = "mx.frisa.tic.negocio.ws.ConsultarLCFacturasResponse")
    @Action(input = "http://ws.negocio.tic.frisa.mx/GestorFacturasWS/consultarLCFacturasRequest",
            output = "http://ws.negocio.tic.frisa.mx/GestorFacturasWS/consultarLCFacturasResponse")
    public RespuestaLCFacturaDTO consultarLCFacturas(@WebParam(name = "lineaCaptura", targetNamespace = "")
                                                     String lineaCaptura);

    /**
     *
     * @param idBatch
     * @return
     *     returns mx.frisa.tic.negocio.ws.RespuestaDetalleFacturaDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaDetalleFacturas", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                    className = "mx.frisa.tic.negocio.ws.ConsultaDetalleFacturas")
    @ResponseWrapper(localName = "consultaDetalleFacturasResponse", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                     className = "mx.frisa.tic.negocio.ws.ConsultaDetalleFacturasResponse")
    @Action(input = "http://ws.negocio.tic.frisa.mx/GestorFacturasWS/consultaDetalleFacturasRequest",
            output = "http://ws.negocio.tic.frisa.mx/GestorFacturasWS/consultaDetalleFacturasResponse")
    public RespuestaDetalleFacturaDTO consultaDetalleFacturas(@WebParam(name = "idBatch", targetNamespace = "")
                                                              String idBatch);

}
