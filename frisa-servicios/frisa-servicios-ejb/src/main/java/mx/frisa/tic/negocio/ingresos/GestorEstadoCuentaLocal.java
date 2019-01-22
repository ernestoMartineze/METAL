/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;

/**
 *
 * @author USER_1
 */
@Local
public interface GestorEstadoCuentaLocal {

     RespuestaDTO procesarEstadosCuenta(final String fechaInicio, final String fechaFinal, final String numeroCuenta);
     List<ReporteEstadoCuentaDTO> consultaReporteEstadoCuenta(String uuid);
}
