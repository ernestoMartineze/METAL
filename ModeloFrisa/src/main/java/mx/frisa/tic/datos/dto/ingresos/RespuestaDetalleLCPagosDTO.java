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
public class RespuestaDetalleLCPagosDTO implements Serializable{

    public static final long serialVersionUID = 0L;
    private Proceso proceso;
    private List<DetalleLCPagosDTO> detalleLCPagos;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<DetalleLCPagosDTO> getDetalleLCPagos() {
        return detalleLCPagos;
    }

    public void setDetalleLCPagos(List<DetalleLCPagosDTO> detalleLCPagos) {
        this.detalleLCPagos = detalleLCPagos;
    }
    
    
    
}
