/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author Ernesto
 */
public class RespuestaLCFactDetDTO {
    
    public static final long serialVersionUID = 87996564786747L;
    private Proceso proceso;
    private List<LCFactDetDTO> lcFactDetalle;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<LCFactDetDTO> getLcFactDetalle() {
        return lcFactDetalle;
    }

    public void setLcFactDetalle(List<LCFactDetDTO> lcFactDetalle) {
        this.lcFactDetalle = lcFactDetalle;
    }
    
    
    
}
