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
public class RespuestaDetalleFacturaDTO {
    
    public static final long serialVersionUID = 0L;
    private Proceso proceso;
    private List<ProcessInterfaceLineDTO> processInterfaceLine;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<ProcessInterfaceLineDTO> getProcessInterfaceLine() {
        return processInterfaceLine;
    }

    public void setProcessInterfaceLine(List<ProcessInterfaceLineDTO> processInterfaceLine) {
        this.processInterfaceLine = processInterfaceLine;
    }
    
}
