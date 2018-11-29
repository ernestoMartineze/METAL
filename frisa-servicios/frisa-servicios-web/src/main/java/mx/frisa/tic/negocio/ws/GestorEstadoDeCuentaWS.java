/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.negocio.ingresos.GestorEstadoCuentaLocal;

/**
 *
 * @author USER_1
 */
@WebService(serviceName = "GestorEstadoDeCuentaWS")
public class GestorEstadoDeCuentaWS {

    @EJB(beanName = "GestorEstadoCuenta")
    private GestorEstadoCuentaLocal ejbRefEdoCuenta;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "procesarEstadosCuenta")
    public RespuestaDTO procesarEstadosCuenta(@WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFinal") String fechaFinal, @WebParam(name = "numeroCuenta") String numeroCuenta) {
        return ejbRefEdoCuenta.procesarEstadosCuenta(fechaInicio, fechaFinal, numeroCuenta);
    }
    
}
