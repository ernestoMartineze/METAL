/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;


import java.util.List;

/**
 *
 * @author USER_1
 */
public class RespuestaPagoSinReferencia {
    Proceso proceso;
    List<LineaEstadoCuentaDTO> lineas;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<LineaEstadoCuentaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaEstadoCuentaDTO> lineas) {
        this.lineas = lineas;
    }
    
}
