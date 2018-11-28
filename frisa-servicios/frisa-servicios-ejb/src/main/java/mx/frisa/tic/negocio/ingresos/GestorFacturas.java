/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.LCFacturaDTO;

/**
 *
 * @author Ernesto
 */
@Local
public interface GestorFacturas {
    
    /**
     *
     * @param lcFactura
     * @return
     */
    public List<LCFacturaDTO> consultarLCFactura(String idLineaCaptura);
}
