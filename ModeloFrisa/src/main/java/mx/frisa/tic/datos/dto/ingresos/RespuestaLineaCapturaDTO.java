package mx.frisa.tic.datos.dto.ingresos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ernestomtz
 */public class RespuestaLineaCapturaDTO implements Serializable{
    private static final long serialVersionUID = 8799656478674717051L;
    private Proceso proceso;
    private List<LineaCapturaDTO> lineasCaptura;


    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<LineaCapturaDTO> getLineasCaptura() {
        return lineasCaptura;
    }

    public void setLineasCaptura(List<LineaCapturaDTO> lineasCaptura) {
        this.lineasCaptura = lineasCaptura;
    }

    
           

}
