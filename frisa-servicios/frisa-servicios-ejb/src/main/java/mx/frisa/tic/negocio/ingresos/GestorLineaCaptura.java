/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;

/**
 *
 * @author soultech
 */
@Local
public interface GestorLineaCaptura {

    /**
     *
     * @param lineaCaptura
     * @return
     */
    public List<LineaCapturaDTO> consultarLineaCaptura(LineaCapturaDTO lineaCaptura);
    
    /**
     *
     * @param pLC
     * @return
     */
    public int ejecutaCuentaFacturas(String pLC);
    
    /**
     *
     * @param idBatch
     * @return
     */
    public int ejecutaBatchLC(String idBatch);
}
