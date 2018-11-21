/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ernesto
 */
public class RespuestaLCFacturaDTO implements Serializable{
    
    public static final long serialVersionUID = 0L;
    private Proceso proceso;
    private List<LCFacturaDTO> lcFacturas;


    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<LCFacturaDTO> getLcFacturas() {
        return lcFacturas;
    }

    public void setLcFacturas(List<LCFacturaDTO> lcFacturas) {
        this.lcFacturas = lcFacturas;
    }
    
}
