/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.negocio.ingresos.GestorPagos;

/**
 *
 * @author Soultech
 */
@WebService(serviceName = "GestorPagosWS")
public class GestorPagosWS {

    @EJB
    private GestorPagos ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "generarPago")
    public RespuestaDTO generarPago(@WebParam(name = "pago") PagoDTO pago) {
        List<PagoDTO> pagos = new ArrayList<>();
        
        return ejbRef.generarPago(pagos);
    }
    
}
