/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;

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
    public RespuestaDTO generarPago(PagoDTO pago);
}
