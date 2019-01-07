/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author danie
 */
public class RespuestaTipoMonedaDTO {
    Proceso proceso;
    List<TipoMonedaDTO> tipoMoneda;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<TipoMonedaDTO> getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(List<TipoMonedaDTO> tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
    
    
}
