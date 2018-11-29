/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFactDetDTO;

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
     * @return
     */
    public int ejecutaBatchLC(String idBatch);
    
    /**
     * 
     * @param detalleLineaCaptura
     * @return
    */
    public List<DetalleLineaCapturaDTO> consultarDetalleLineaCaptura(DetalleLineaCapturaDTO detalleLineaCaptura);
    
    /**
     *
     * @param facturaERP
     * @return
     */
    public List<DetalleLCPagosDTO> consultarLCPagos(String facturaERP);
    
    /**
     *
     * @param lcFactDetalle
     * @return
     */
    public List<LCFactDetDTO> consultarLCFactDet(LCFactDetDTO lcFactDetalle);


    
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
