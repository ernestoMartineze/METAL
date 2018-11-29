/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author Ernesto
 */
@Stateless(name = "GestorNotaCreditoBean")
@LocalBean
public class GestorNotaCreditoBean implements GestorNotaCreditoBeanLocal {

    @Override
    public RespuestaDTO cargarNota(NotaCreditoDTO notaCredito) {

        RespuestaDTO respuesta = new RespuestaDTO();
        ManejadorLog manejaLog = new ManejadorLog();
        manejaLog.debug("Datos de entrada " + notaCredito);
        try {

            if (notaCredito.isValido()) {
                respuesta.setIdError("0");
                respuesta.setDescripcionError("");
                respuesta.setProceso(ProcesoEnum.EXITOSO.toString());
            } else {
                respuesta.setIdError("1");
                respuesta.setDescripcionError(notaCredito.getMsgError());
                respuesta.setProceso(ProcesoEnum.ERROR.toString());
            }

        } catch (Exception ex) {
            Logger.getLogger(GestorNotaCreditoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

}
