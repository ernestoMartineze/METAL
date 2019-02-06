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
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.negocio.ingresos.FiltroEstadoCuenta;
import mx.frisa.tic.negocio.ingresos.GestorEstadoCuentaLocal;
import mx.frisa.tic.negocio.ingresos.ReporteEstadoCuentaDTO;

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
    public RespuestaDTO procesarEstadosCuenta(@WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFinal") String fechaFinal) {
        return ejbRefEdoCuenta.procesarEstadosCuenta(fechaInicio, fechaFinal, "");
    }

    @WebMethod(operationName = "reporteEstadosCuenta")
    public List<ReporteEstadoCuentaDTO> reporteEstadosCuenta(@WebParam(name = "filtros") FiltroEstadoCuenta filtros) {
        return ejbRefEdoCuenta.consultaReporteEstadoCuenta(filtros);
    }

}
