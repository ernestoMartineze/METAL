/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;


import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.FiltroPagoSinReferencia;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaPagoSinReferencia;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;
import mx.frisa.tic.negocio.ingresos.GestorPagos;

/**
 *
 * @author Soultech
 */
@WebService(serviceName = "GestorPagosWS")
public class GestorPagosWS {

    @EJB
    private GestorPagos ejbRef;

    @WebMethod(operationName = "generarPago")
    public RespuestaProcesaFacturasDTO generarPago(@WebParam(name = "pago") List<PagoDTO> pagos ) {
        
        return ejbRef.generarPago(pagos);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarPagosSinReferencia")
    public RespuestaPagoSinReferencia consultarPagosSinReferencia(@WebParam(name = "filtros") FiltroPagoSinReferencia filtros) {
        
        return ejbRef.consultarPagosSinReferencia(filtros);
    }
    
}
