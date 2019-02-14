
package mx.frisa.tic.negocio.ws;

import java.util.List;

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
@WebService(name = "CatalogoWS", targetNamespace = "http://ws.negocio.tic.frisa.mx/")
@XmlSeeAlso({ ObjectFactory.class })
public interface CatalogoWS {


    /**
     *
     * @param clave
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarPais", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                    className = "mx.frisa.tic.negocio.ws.ConsultarPais")
    @ResponseWrapper(localName = "consultarPaisResponse", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                     className = "mx.frisa.tic.negocio.ws.ConsultarPaisResponse")
    @Action(input = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarPaisRequest",
            output = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarPaisResponse")
    public String consultarPais(@WebParam(name = "id", targetNamespace = "") int id,
                                @WebParam(name = "clave", targetNamespace = "") String clave);

    /**
     *
     * @return
     *     returns java.util.List<mx.frisa.tic.negocio.ws.TipoMonedaDTO>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarTipoMoneda", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                    className = "mx.frisa.tic.negocio.ws.ConsultarTipoMoneda")
    @ResponseWrapper(localName = "consultarTipoMonedaResponse", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                     className = "mx.frisa.tic.negocio.ws.ConsultarTipoMonedaResponse")
    @Action(input = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarTipoMonedaRequest",
            output = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarTipoMonedaResponse")
    public List<TipoMonedaDTO> consultarTipoMoneda();

    /**
     *
     * @param numeroCuenta
     * @return
     *     returns java.util.List<mx.frisa.tic.negocio.ws.CuentaBancariaDTO>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarCuentaBancaria", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                    className = "mx.frisa.tic.negocio.ws.ConsultarCuentaBancaria")
    @ResponseWrapper(localName = "consultarCuentaBancariaResponse", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                     className = "mx.frisa.tic.negocio.ws.ConsultarCuentaBancariaResponse")
    @Action(input = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarCuentaBancariaRequest",
            output = "http://ws.negocio.tic.frisa.mx/CatalogoWS/consultarCuentaBancariaResponse")
    public List<CuentaBancariaDTO> consultarCuentaBancaria(@WebParam(name = "numeroCuenta", targetNamespace = "")
                                                           String numeroCuenta);

}
