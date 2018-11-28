/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;

/**
 *
 * @author soultech
 */
@Local
public interface GestorLineaCaptura {

    /**
     *
     * @param lineaCaptura
     * @return List<LineaCapturaDTO>
     */
    public List<LineaCapturaDTO> consultarLineaCaptura(LineaCapturaDTO lineaCaptura);
    
    /**
     *
     * @param pLC
     * @return int
     */
    public int ejecutaCuentaFacturas(String pLC);
    
    /**
     *
     * @param idBatch
     * @return int
     */
    public int ejecutaBatchLC(String idBatch);
    
     /**
     *
     * @param idBatch
     * @return String
     */
    public String consultaBatchFinalizado(String idBatch);
    
    /**
     *
     * @param idBatch
     * @return List<LineaCaptutaFacturaDTO>
     */
    public List<LineaCaptutaFacturaDTO> consultaLCGeneradas(String idBatch);
}
