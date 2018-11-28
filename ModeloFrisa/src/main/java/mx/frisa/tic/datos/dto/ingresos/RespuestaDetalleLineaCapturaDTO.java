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
public class RespuestaDetalleLineaCapturaDTO implements Serializable{
    
    private static final long serialVersionUID = 8799656478674717052L;
    private Proceso proceso;
    private List<DetalleLineaCapturaDTO> detalleLineasCaptura;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<DetalleLineaCapturaDTO> getLineasCaptura() {
        return detalleLineasCaptura;
    }

    public void setLineasCaptura(List<DetalleLineaCapturaDTO> detalleLineasCaptura) {
        this.detalleLineasCaptura = detalleLineasCaptura;
    }
    
    
}
