/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;

/**
 *
 * @author Soultech
 */
@Local
public interface GestorPagos {
    
    /**
     *
     * @param pago
     * @return
     */
    public RespuestaProcesaFacturasDTO generarPago(List<PagoDTO> pagos);
}
